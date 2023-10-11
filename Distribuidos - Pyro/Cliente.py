from datetime import datetime
import threading
from Crypto.PublicKey import RSA
import Pyro5.api
from Usuario import Usuario

Pyro5.config.SERPENT_BYTES_REPR = True

@Pyro5.api.expose
class Cliente:

    def __init__(self, nome, chavePublica=None, chavePrivada=None):
        self.usuario = Usuario(nome)
        self.nome = nome
        self.chavePrivada = None
        self.notificacoes = []
        self.uri_objeto_remoto = None
        self.notificacoes_recebidas = []

        if not (chavePublica and chavePrivada):
            key = RSA.generate(2048)
            self.usuario.setChavePublica(key.publickey().export_key().decode("utf-8"))
            self.chavePrivada = key.export_key().decode("utf-8")
            self.salvar_chave(self.usuario.getChavePublica(), 'chaves/A_publica.pem')
            self.salvar_chave(self.chavePrivada, 'chaves/A_privada.pem')
            print("CHAVES GERADAS AUTOMATICAMENTE:")
        else:
            self.usuario.setChavePublica(chavePublica)
            self.chavePrivada = chavePrivada

        print("CHAVE PÚBLICA:" + self.usuario.getChavePublica())
        print("CHAVE PRIVADA:" + self.chavePrivada)

        self.daemon = Pyro5.server.Daemon()
        uri = str(self.daemon.register(self))
        self.usuario.setURI(uri)
        threading.Thread(target=self.daemon.requestLoop).start()

    def cadastrar_usuario(self, nome_objeto_remoto):
        self.uri_objeto_remoto = nome_objeto_remoto 
        self.server = Pyro5.api.Proxy(self.uri_objeto_remoto)
        response = self.server.cadastrar_usuario(self.usuario.getNome(), self.usuario.getChavePublica(), self.usuario.getURI())
        print(response['message'])

    def cadastrar_produto(self):
        condicoes = False
        while not condicoes:
            print("\n\n--- CADASTRO DE PRODUTO: ---")
            nome_produto = input("NOME: ")
            descricao_produto = input("DESCRICAO: ")
            condicoes = nome_produto != "" and descricao_produto != ""

            if not condicoes:
                print("*** DADOS INVÁLIDOS ***")

        response = self.server.cadastrar_produto(nome_produto, descricao_produto, self.usuario.getIdUsuario())
        print(response['message'])

    @Pyro5.api.expose
    def receber_notificacao(self, notificacao):
        print("\n\n" + notificacao)
        time = datetime.now()
        time = time.strftime("%d/%m/%Y %H:%M:%S")
        notificacao_dict = [time, notificacao]
        self.notificacoes_recebidas.append(notificacao_dict)

    def listar_notificacoes(self):
        print("\n\n--- LISTAR NOTIFICAÇÕES: ---\n")
        if len(self.notificacoes_recebidas) == 0:
            print("\nNenhuma notificação recebida.")
            return

        for i in range(len(self.notificacoes_recebidas) - 1, -1, -1):
            notificacao = self.notificacoes_recebidas[i]
            print(f"{notificacao[0]} - {notificacao[1]}")
            print("-" * 30)

    def salvar_chave(self, chave, caminho_arquivo):
        with open(caminho_arquivo, 'w') as file:
            file.write(chave)

@Pyro5.api.expose
def is_key(key):
    try:
        RSA.import_key(key)
        return True
    except (ValueError, TypeError):
            return False

def carregar_chave(caminho_arquivo):
 try:
    with open(caminho_arquivo, 'r') as file:
         chave = file.read()
         if is_key(chave):
             return chave
 except FileNotFoundError:
    return None


if __name__ == "__main__":
    
    while True:
        print("\n\n-CADASTRO/LOGIN DE USUÁRIO-")

        nome = input("NOME: ")

        if nome:
            print("Deixar em branco para gerar automaticamente!")
            path_chavePublica = input("CHAVE PÚBLICA: ").strip()
            path_chavePrivada = input("CHAVE PRIVADA: ").strip()

            chavePublica = carregar_chave(path_chavePublica)
            chavePrivada = carregar_chave(path_chavePrivada)

            cliente = Cliente(nome, chavePublica, chavePrivada)

            conectado = False  
            while(not conectado): 
                conectado = True
                nome_objeto_remoto = (input("NOME OBJETO REMOTO: ")).strip()
                if nome_objeto_remoto != '' or nome_objeto_remoto is not None:
                    try:
                        print(cliente.cadastrar_usuario(nome_objeto_remoto))
                    except: 
                        conectado = False
                        print("\n *** NOME DO OBJETO REMOTO INVÁLIDO ****\n")
            try:
                opcao = -1
                while opcao != "0":
                    print("\n\n------OPÇÕES------\n")
                    print("- (1) Consulta de Estoque")
                    print("- (2) Cadastro de Produto em Estoque")
                    print("- (3) Notificações Recebidas")
                    print("- (0) Sair")

                    opcao = input("DIGITE A OPÇÃO: ").strip()
                    if opcao == "1":
                        cliente.consultar_produtos()
                    elif opcao == "2":
                        cliente.cadastrar_produto()
                    elif opcao == "4":
                        cliente.listar_notificacoes()
                    elif opcao == "0":
                        print("\n- SAIR -")
                    else:
                        print("*** OPÇÃO INVÁLIDA ***")
            except:
                print("\n *** PROBLEMA DE CONEXÃO COM SERVIDOR ****\n")
        else:
            print("\n*** PROBLEMA COM USUÁRIO ***")
