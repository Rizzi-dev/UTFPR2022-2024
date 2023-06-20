import java.io.*;
import java.net.*;

public class Servidor {
    private static final int SERVER_PORT = 3306;
    private static final int WINDOW_SIZE = 4;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Aguardando conexão do cliente...");

            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado.");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            int expectedSeqNum = 0; 

            while (true) {
                // Recebe o pacote
                String pacote = reader.readLine();

                if (pacote.equals("FIN")) {
                    System.out.println("Recebido FIN. Encerrando conexão.");
                    break;
                }

                System.out.println("Recebido pacote: " + pacote);

                if (Integer.parseInt(pacote) == expectedSeqNum) {
                    // Pacote esperado: envia ACK
                    writer.println(expectedSeqNum);
                    System.out.println("Enviado ACK: " + expectedSeqNum);
                    expectedSeqNum++;
                } else {
                    // Pacote fora de ordem: descarta e envia ACK duplicado
                    writer.println(expectedSeqNum - 1);
                    System.out.println("Enviado ACK duplicado: " + (expectedSeqNum - 1));
                }
            }

            socket.close();
            serverSocket.close();
            System.out.println("Conexão encerrada.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}