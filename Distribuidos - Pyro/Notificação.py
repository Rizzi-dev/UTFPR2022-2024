import Pyro5.api

@Pyro5.api.expose
class Notificacao:
    def __init__(self, URIs, notificacao):
        self.URIs = URIs
        self.notificacao = notificacao

    def getURIs(self):
        return self.URIs

    def setURIs(self, URIs):
        self.URIs = URIs

    def getNotificacao(self):
        return self.notificacao

    def setNotificacao(self, notificacao):
        self.notificacao = notificacao

    def __getstate__(self):
        return self.__dict__

    def __setstate__(self, state):
        self.__dict__.update(state)
