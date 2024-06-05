# Java IPC using Sockets

## Introduction
The example includes a server that listens for client connections and processes messages, and a client that sends messages to the server.

## Project Structure
- `MessageListener.java`: An interface for handling messages.
- `Server.java`: The server class that listens for client connections.
- `ClientHandler.java`: Handles each client connection in a separate thread.
- `Client.java`: The client class that sends messages to the server.
- `MessagePrinter.java`: An implementation of `MessageListener` that processes and prints messages.
- `Main.java`: Entry point for running the server and client.

## IPC (Inter-Process Communication)
IPC is a mechanism that allows processes to communicate and share data. In this project, IPC is achieved using TCP sockets. The server listens for client connections, and when a client connects, it creates a separate thread (`ClientHandler`) to handle communication.

## Description of Classes
1. **MessageListener.java**
   - Interface for handling messages.
   - Contains a single method `onMessage(String message)`.

2. **Server.java**
   - Listens for client connections on a specified port using TCP sockets.
   - Creates a new `ClientHandler` thread for each client connection.

3. **ClientHandler.java**
   - Handles each client connection in a separate thread.
   - Reads messages from clients and invokes `onMessage` method of `MessageListener`.

4. **Client.java**
   - Connects to the server using a TCP socket.
   - Sends messages to the server.

5. **MessagePrinter.java**
   - Implements `MessageListener` interface.
   - Processes and prints messages received from clients.

6. **Main.java**
   - Entry point for running the server and client.

## Advantages of Using IPC with Sockets
- Provides a reliable and flexible way to establish communication.
- TCP sockets ensure data integrity and order of messages.
- Using threads allows concurrent handling of multiple clients.
- Promotes modularity and code maintainability through interfaces.

