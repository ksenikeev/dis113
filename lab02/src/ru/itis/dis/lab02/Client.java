package ru.itis.dis.lab02;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket ("localhost",50001);

            // поток для отправки данных на сервер
            OutputStream os = clientSocket.getOutputStream();
            // поток для получения данных от сервера
            InputStream is = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            Scanner in = new Scanner(System.in);

            while (true) {
                // read question from console
                System.out.print("Введите вопрос: ");
                String question = in.nextLine();

                //1. send question to server
                os.write((question + "\n").getBytes("UTF-8"));
                //2. read response from server
                String response = reader.readLine();

                System.out.printf("Ответ: %s \n", response);

                if (question.equals("exit")) {
                    break;
                }

            }
            in.close();
            os.close();
            clientSocket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
