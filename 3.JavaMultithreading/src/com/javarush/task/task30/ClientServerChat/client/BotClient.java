package com.javarush.task.task30.ClientServerChat.client;

import com.javarush.task.task30.ClientServerChat.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {
    public static void main(String[] args) throws InterruptedException {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }
    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }
    @Override
    protected String getUserName() {
        return "date_bot_" + (int)(Math.random() * 100);
    }

     public class BotSocketThread extends SocketThread {
         @Override
         protected void processIncomingMessage(String message) {
             ConsoleHelper.writeMessage(message);
             if (message.contains(": ")) {
                 String[] parseMessage = message.split(": ", 2);

                 Calendar calendar = Calendar.getInstance();
                 SimpleDateFormat sdf = new SimpleDateFormat();

                 if ((parseMessage[1] != "") && (parseMessage[1] != null)) {
                     switch (parseMessage[1]) {
                         case "дата":
                             sdf = new SimpleDateFormat("d.MM.YYYY");
                             break;
                         case "день":
                             sdf = new SimpleDateFormat("d");
                             break;
                         case "месяц":
                             sdf = new SimpleDateFormat("MMMM");
                             break;
                         case "год":
                             sdf = new SimpleDateFormat("YYYY");
                             break;
                         case "время":
                             sdf = new SimpleDateFormat("H:mm:ss");
                             break;
                         case "час":
                             sdf = new SimpleDateFormat("H");
                             break;
                         case "минуты":
                             sdf = new SimpleDateFormat("m");
                             break;
                         case "секунды":
                             sdf = new SimpleDateFormat("s");
                             break;
                         default:
                             sdf = null;
                             break;
                     }
                     if (sdf != null) {
                         sendTextMessage("Информация для " + parseMessage[0] + ": " + sdf.format(calendar.getTime()));
                     }
                 }
             }
         }

         @Override
         protected void clientMainLoop() throws IOException, ClassNotFoundException {
             sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
             super.clientMainLoop();
         }
     }
}
