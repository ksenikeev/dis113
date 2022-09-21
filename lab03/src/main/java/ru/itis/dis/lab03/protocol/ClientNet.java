package ru.itis.dis.lab03.protocol;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientNet {

    public static void main(String[] args) {

        try {
            String message = "Перевод 1000 рублей в банк";

            int len = message.getBytes("UTF-8").length;

            byte[] lenArray = toBytes(len);

            Socket clientSocket = new Socket ("localhost",50001);

            OutputStream os = clientSocket.getOutputStream();

            // Отправляем длину сообщения
            os.write(lenArray);
            // Отправляем сообщение
            os.write(message.getBytes("UTF-8"));

            clientSocket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static byte[] toBytes(int i) {

        byte[] result = new byte[4];

        result[0] = (byte) (i >> 24);
        result[1] = (byte) (i >> 16);
        result[2] = (byte) (i >> 8);
        result[3] = (byte) (i /*>> 0*/);

        return result;
    }

}
