import Pyro5.api
import Pyro5.server
from Usuario import Usuario

Pyro5.config.SERPENT_BYTES_REPR = True

@Pyro5.api.expose
class Server:
    @Pyro5.api.expose
    def cadastrar_usuario(self, nomeUsuario, chavePublica, URI):
        if not nomeUsuario or not chavePublica:
            return {'message': 'Todos os campos são obrigatórios.'}

        usuario = Usuario(nomeUsuario)
        usuario.setURI(URI)
        usuario.setChavePublica(chavePublica)
        
    @Pyro5.api.expose
    def server_side_event(self, notificacao):
        for URI in notificacao.getURIs():
            cliente = Pyro5.api.Proxy(URI)
            cliente.receber_notificacao(notificacao.getNotificacao())


Pyro5.api.config.SERIALIZER = "marshal"
servidor = Server()
daemon = Pyro5.server.Daemon() 
uri = daemon.register(servidor)
print("URI do servidor:", uri)
daemon.requestLoop()
