package IPC;

import java.io.*;
import java.net.*;

public class Client {
    private final String hostname;
    private final int port;

    public Client(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void sendMessage(String message) {
        try (Socket socket = new Socket(hostname, port)) {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println(message);
            System.out.println("Client sent: " + message);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}