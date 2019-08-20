package com.javarush.task.task30.ClientServerChat;

import java.io.Serializable;

public class Message implements Serializable {

    public Message(MessageType type, String data) {
        this.type = type;
        this.data = data;
    }

    public Message(MessageType type) {
        this.type = type;
        data = null;
    }

    private final MessageType type;
    private final String data;

    public MessageType getType() {
        return type;
    }

    public String getData() {
        return data;
    }


}
