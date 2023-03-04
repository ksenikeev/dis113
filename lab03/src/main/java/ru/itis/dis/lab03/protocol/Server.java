package ru.itis.dis.lab03.protocol;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int SERVER_PORT = 50001;

    public static void main (String[] args){
        try {
            ServerSocket server =
                    new ServerSocket(SERVER_PORT);

                Socket clientSocket = server.accept();

                System.out.println("connected");

                InputStream is = clientSocket.getInputStream();

                byte[] lenMsg = new byte[4];

                // читаем длину сообщения
                is.read(lenMsg);

                int len = fromByteArray(lenMsg);

                // готовим массив для сообщения
                byte[] msgArray = new byte[len];

                // читаем сообщение
                is.read(msgArray);

            System.out.println(new String(msgArray));



                clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int fromByteArray(byte[] bytes) {
        return ((bytes[0] & 0xFF) << 24) |
                ((bytes[1] & 0xFF) << 16) |
                ((bytes[2] & 0xFF) << 8 ) |
                ((bytes[3] & 0xFF) << 0 );
    }

}
