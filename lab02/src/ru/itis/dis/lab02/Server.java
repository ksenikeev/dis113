package ru.itis.dis.lab02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int SERVER_PORT = 50001;

    public static void main (String[] args){
        try {
            ServerSocket server =
                    new ServerSocket(SERVER_PORT);

            while (true) {
                Socket clientSocket = server.accept();
                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
