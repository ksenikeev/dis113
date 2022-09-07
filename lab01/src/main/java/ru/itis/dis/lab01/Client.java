package ru.itis.dis.lab01;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket ("localhost",50001);


/*
            System.out.println(clientSocket.getLocalAddress());
            System.out.println(clientSocket.getLocalPort());
*/
            OutputStream os = clientSocket.getOutputStream();

            if (args != null) {
                os.write((args[0] + "\n").getBytes("UTF8"));
            }

            InputStream is = clientSocket.getInputStream();



            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String receivedData = br.readLine();

            System.out.println("Received Data: "+receivedData);

            clientSocket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
