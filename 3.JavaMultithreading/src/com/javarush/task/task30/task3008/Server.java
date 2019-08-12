package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

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

        @Override
        public void run() {
            super.run();
        }

    }
}
