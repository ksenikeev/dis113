package ru.itis.dis.lab02;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            System.out.println("processing new client from " + clientSocket.getInetAddress());
            // поток для получения данных от клиента
            InputStream is = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            // поток для отправления клиенту ответа
            OutputStream os = clientSocket.getOutputStream();


            boolean workStatus = true;
            while (workStatus) {
                System.out.println("1. read question from client");

                //1. read question from client
                String question = reader.readLine();
                System.out.println(question);
                String response = "";
                if (question.equals("exit")) {
                    response = "До свидания!";
                    workStatus = false;
                } else if (question.equals("Как дела?")) {
                    String[] resps = {"Хорошо :)","Плохо :(","Отлично! :)))"};
                    response = resps[(int)(Math.random()*resps.length)];
                } else {
                    response = "Не понял вопроса!";
                }

                // 2. send response to client
                DataOutputStream serverOutput = new DataOutputStream(os);
                serverOutput.write((response + "\n").getBytes("UTF-8"));
            }
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
