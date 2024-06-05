package IPC;

import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private final MessageListener messageListener;

    public ClientHandler(Socket socket, MessageListener messageListener) {
        this.socket = socket;
        this.messageListener = messageListener;
    }

    @Override
    public void run() {
        try (InputStream input = socket.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {

            String message = reader.readLine();
            messageListener.onMessage(message);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
