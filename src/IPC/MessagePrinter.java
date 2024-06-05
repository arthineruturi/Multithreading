package IPC;


public class MessagePrinter implements MessageListener {
 @Override
 public void onMessage(String message) {
     System.out.println("Received: " + message);
 }
}
