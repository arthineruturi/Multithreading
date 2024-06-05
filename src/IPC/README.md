# Java IPC using Sockets 
The example includes a server that listens for client connections and processes messages, and a client that sends messages to the server.

## Project Structure

- MessageListener.java: An interface for handling messages.
- Server.java: The server class that listens for client connections.
- ClientHandler.java:Handles each client connection in a separate thread.
- Client.java: The client class that sends messages to the server.
- MessagePrinter.java:An implementation of `MessageListener` that processes and prints messages.
- Main.java:Entry point for running the server and client.

### What is IPC:
IPC (Inter-Process Communication) is a mechanism that allows processes (running instances of programs) to communicate and share data with each other. It enables coordination and collaboration between different processes on a computer system or across a network.

In the provided example, IPC is achieved using TCP sockets. The server process listens for client connections, and when a client connects, it creates a separate thread (ClientHandler) to handle that client's communication. This allows multiple clients to interact with the server concurrently.
The Client class connects to the server using a TCP socket and sends messages to the server. The server, upon receiving a message from a client, processes it and prints it using the MessagePrinter class, which implements the MessageListener interface for message handling.
#### Description of Classes
MessageListener.java

Interface for handling messages.
Contains a single method onMessage(String message).
Server.java

Listens for client connections on a specified port using TCP sockets.
Creates a new ClientHandler thread for each client connection.
Delegates message processing to the ClientHandler class.
ClientHandler.java

Handles each client connection in a separate thread.
Reads messages from clients and invokes the onMessage method of a MessageListener implementation (MessagePrinter in this case).
Client.java

Connects to the server using a TCP socket.
Sends messages to the server.
MessagePrinter.java

Implements the MessageListener interface.
Processes and prints messages received from clients.
Main.java

Entry point for running the server and client.
Creates instances of the server, client, and MessagePrinter, and starts the server.

##### Advantages of Using IPC with Sockets
Sockets provide a reliable and flexible way to establish communication between processes.
TCP sockets ensure data integrity and order of messages.
Using threads (ClientHandler) allows concurrent handling of multiple clients, improving system responsiveness.
Separation of concerns through interfaces (MessageListener) promotes modularity and code maintainability.
