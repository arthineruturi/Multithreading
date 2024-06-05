package IPC;
import java.io.*;
import java.net.*;
public class Server {
    private final int port;
    private final MessageListener messageListener;

    public Server(int port, MessageListener messageListener) {
        this.port = port;
        this.messageListener = messageListener;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ClientHandler(socket, messageListener)).start();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


