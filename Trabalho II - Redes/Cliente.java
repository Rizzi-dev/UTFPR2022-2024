import java.io.*;
import java.net.*;

public class Cliente {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 3306;
    private static final int WINDOW_SIZE = 4;
    private static final int TIMEOUT = 3000;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Conectado ao servidor.");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Simulando dados a serem enviados
            Integer[] dados = {1, 2, 3, 4, 5, 6};

            int base = 0;
            int nextSeqNum = 0;

            while (base < dados.length) {
                // Envia pacotes dentro da janela
                while (nextSeqNum < base + WINDOW_SIZE && nextSeqNum < dados.length) {
                    writer.println(dados[nextSeqNum]);
                    System.out.println("Enviado pacote: " + dados[nextSeqNum]);
                    nextSeqNum++;
                }

                try {
                    socket.setSoTimeout(TIMEOUT);

                    // Recebe a confirmação (ACK)
                    String ack = reader.readLine();
                    int ackNum = Integer.parseInt(ack);
                    System.out.println("Recebido ACK: " + ackNum);
                     // Atualiza a base se receber o ACK esperado
                    if (ackNum == base) {
                        base++;
                    }
                } catch (SocketTimeoutException e) {
                    // Timeout: reenvia pacotes a partir da base
                    System.out.println("Timeout, reenviando pacotes a partir de: " + base);
                    nextSeqNum = base;
                }
            }

            // Encerra a conexão
            writer.println("FIN");
            System.out.println("Enviado FIN.");

            socket.close();
            System.out.println("Conexão encerrada.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


