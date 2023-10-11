import datetime
import Pyro5.api
from Usuario import Usuario

@Pyro5.api.expose
class InventoryManager:
    def __init__(self):
        self.inventory = {}
        self.users = {}

    def register_user(self, name, public_key):
        user = Usuario(name, public_key)
        self.users[name] = user
        return user

    def add_product(self, user, code, name, description, quantity, unit_price, min_stock):
        timestamp = datetime.datetime.now()
        message = f"ADD_PRODUCT|{code}|{name}|{description}|{quantity}|{unit_price}|{min_stock}|{timestamp}"
        signature = user.sign_message(message)

        if user.verify_signature(message, signature):
            self.inventory[code] = {
                "Nome": name,
                "Descrição": description,
                "Quantidade": quantity,
                "Preço Unitário": unit_price,
                "Estoque mínimo": min_stock,
                "Hora/Data": timestamp,
            }
            print(f"Produto com código {code} adicionado ao inventário.")
        else:
            print("Assinatura inválida. Produto não adicionado.")

    def checkout_product(self, user, code, quantity):
        timestamp = datetime.datetime.now()
        message = f"CHECKOUT_PRODUCT|{code}|{quantity}|{timestamp}"
        signature = user.sign_message(message)

        if user.verify_signature(message, signature):
            if code in self.inventory and self.inventory[code]["quantity"] >= quantity:
                self.inventory[code]["quantity"] -= quantity
                print(f"Produto com código {code} retirado.")
            else:
                print("Produto não disponível ou quantidade insuficiente.")
        else:
            print("Assinatura inválida. Retirada não processada.")
