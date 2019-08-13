package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    public static void main(String args[]) throws IOException {

        int n;
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            while (true) {
                n = ConsoleHelper.readInt();
                serverSocket = new ServerSocket(n);
                System.out.println("Server has started");
                socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        }
            catch (IOException e){
                socket.close();
                serverSocket.close();
                System.out.println(e.getMessage());
            }
    }

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<String, Connection>();

    public static void sendBroadcastMessage(Message message) {
        for (String name : connectionMap.keySet()) {
            try {
                connectionMap.get(name).send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage(String.format("Can't send the message to %s", name));
            }
        }
    }

    private static class Handler extends Thread {
        public Handler(Socket socket) {
            this.socket = socket;
        }

        private Socket socket;

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message message = new Message(MessageType.NAME_REQUEST);
            Message messageReceive;
            String name = "";

            while(true) {
                connection.send(message);
                messageReceive = connection.receive();
                if (messageReceive.getType().equals(MessageType.USER_NAME) && !messageReceive.getData().equals("") && !connectionMap.containsKey(messageReceive.getData())) {
                        connectionMap.put(messageReceive.getData(), connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        name = messageReceive.getData();
                        break;
                }
            }
            return name;
        }



        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> e : connectionMap.entrySet()) {
                if (!e.getKey().equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, e.getKey()));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {

            while (true) {
                Message messageReceive = connection.receive();
                if (messageReceive.getType()==MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, String.format("%s: " + messageReceive.getData(), userName)));
                } else {
                    ConsoleHelper.writeMessage("Text error");
                }
            }
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Connection established with " + socket.getRemoteSocketAddress());
            String s = "";
            try {
                Connection connection = new Connection(socket);
                s = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, s));
                notifyUsers(connection,s);
                serverMainLoop(connection,s);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                connectionMap.remove(s);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, s));
            }

        }

    }
}
