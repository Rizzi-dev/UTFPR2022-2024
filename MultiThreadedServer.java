import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class MultiThreadedServer {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(2525);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            executorService.execute(new ClientHandler(clientSocket));
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                OutputStream out = clientSocket.getOutputStream();

                String line = in.readLine();
                String[] tokens = line.split(" ");
                String method = tokens[0];
                String resource = tokens[1];

                if ("GET".equals(method)) {
                    File file = new File("." + resource);
                    if (file.exists()) {
                        out.write("HTTP/1.0 200 OK\r\n".getBytes());
                        out.write(("Content-Type: " + guessContentType(file) + "\r\n").getBytes());
                        out.write("\r\n".getBytes());
                        FileInputStream fileIn = new FileInputStream(file);
                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = fileIn.read(buffer)) != -1) {
                            out.write(buffer, 0, bytesRead);
                        }
                        fileIn.close();
                    } else {
                        out.write("HTTP/1.0 404 Not Found\r\n".getBytes());
                        out.write("\r\n".getBytes());
                        out.write("<h1>404 Not Found</h1>".getBytes());
                    }
                } else {
                    out.write("HTTP/1.0 501 Não Implementado\r\n".getBytes());
                    out.write("\r\n".getBytes());
                    out.write("<h1>501 Não Implementado</h1>".getBytes());
                }

                out.flush();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static String guessContentType(File file) {
            if (file.getName().endsWith(".html") || file.getName().endsWith(".htm")) {
                return "text/html";
            } else if (file.getName().endsWith(".txt") || file.getName().endsWith(".java")) {
                return "text/plain";
            } else if (file.getName().endsWith(".gif")) {
                return "image/gif";
            } else if (file.getName().endsWith(".class")) {
                return "application/octet-stream";
            } else if (file.getName().endsWith(".jpg") || file.getName().endsWith(".jpeg")) {
                return "image/jpeg";
            } else {
                return "application/octet-stream";
            }
        }
    }
}
