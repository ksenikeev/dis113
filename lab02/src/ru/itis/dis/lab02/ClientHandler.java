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
            System.out.println("runned");
            InputStream is = null;
                is = clientSocket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String receivedData = br.readLine();

            System.out.println(receivedData);

            OutputStream os = clientSocket.getOutputStream();

            DataOutputStream serverOutput = new DataOutputStream(os);
            serverOutput.writeBytes("Send response "
                    + " " + receivedData + "\n");

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
