package IPC;


public class Main {
 public static void main(String[] args) {
     MessageListener listener = new MessagePrinter();
     Server server = new Server(12345, listener);

     new Thread(server::start).start();

     Client client = new Client("localhost", 12345);
     client.sendMessage("Hello from the client!");
 }
}

