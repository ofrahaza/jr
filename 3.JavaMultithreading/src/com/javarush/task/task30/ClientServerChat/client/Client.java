package com.javarush.task.task30.ClientServerChat.client;
import com.javarush.task.task30.ClientServerChat.Connection;
import com.javarush.task.task30.ClientServerChat.ConsoleHelper;
import com.javarush.task.task30.ClientServerChat.Message;
import com.javarush.task.task30.ClientServerChat.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args) throws InterruptedException {
        Client client = new Client();
        client.run();
    }

    protected String getServerAddress() {
        String s = ConsoleHelper.readString();
        return s;
    }
    protected int getServerPort(){
        int s = ConsoleHelper.readInt();
        return s;
    }
    protected String getUserName() {
        String s = ConsoleHelper.readString();
        return s;
    }
    protected boolean shouldSendTextFromConsole() {
        return true;
    }
    protected SocketThread getSocketThread(){
        return new SocketThread();
    }
    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            clientConnected = false;
            ConsoleHelper.writeMessage("Error");
            e.printStackTrace();
        }
    }

    public void run() throws InterruptedException {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        try {
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            ConsoleHelper.writeMessage("Ошибка, возникло исключение");
        }
        if (clientConnected == true) {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        } else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }
        while (clientConnected) {
            String line = ConsoleHelper.readString();
            if (line.equals("exit")) break;
            if (shouldSendTextFromConsole()) sendTextMessage(line);
        }

    }

    public class SocketThread extends Thread {
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }
        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(String.format("%s присоединился к чату.", userName));
        }
        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(String.format("%s покинул чат.", userName));
        }
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            Message incomingMessage;
            while (true) {
                incomingMessage = connection.receive();
                if (incomingMessage.getType() == MessageType.NAME_REQUEST) {
                    String s = getUserName();
                    connection.send(new Message(MessageType.USER_NAME, s));
                } else if (incomingMessage.getType() == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    break;
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            Message incomingMessage;
            while (true) {
                incomingMessage = connection.receive();
                if (incomingMessage.getType() == MessageType.TEXT) {
                    processIncomingMessage(incomingMessage.getData());
                } else if (incomingMessage.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(incomingMessage.getData());
                } else if (incomingMessage.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(incomingMessage.getData());
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        public void run(){
            try {
                Socket socket = new Socket(getServerAddress(), getServerPort());
                connection = new Connection(socket);
                this.clientHandshake();
                this.clientMainLoop();
            } catch (IOException e) {
                notifyConnectionStatusChanged(false);
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
                e.printStackTrace();
            }


        }


    }

}
