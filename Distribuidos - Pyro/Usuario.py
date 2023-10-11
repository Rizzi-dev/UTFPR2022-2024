import hashlib
from Crypto.PublicKey import RSA
from Crypto.Signature import pkcs1_15
import Pyro5.api

@Pyro5.api.expose
class Usuario:
    def __init__(self, nome):
        self.nome = nome
        self.chavePublica = None
        self.idUsuario = None
        self.URI = None
    
    def getURI(self):
        return self.URI

    def setURI(self, URI):
        self.URI = URI

    def getNome(self):
        return self.nome

    def setNome(self, nome):
        self.nome = nome

    def getChavePublica(self):
        return self.chavePublica

    def setChavePublica(self, chavePublica):
        self.chavePublica = chavePublica
        self.idUsuario = hashlib.sha256(chavePublica.encode()).hexdigest()
    
    def getIdUsuario(self):
        return self.idUsuario

    def setIdUsuario(self, idUsuario):
        self.idUsuario = idUsuario

    def __getstate__(self):
        return self.__dict__

    def __setstate__(self, state):
        self.__dict__.update(state)

