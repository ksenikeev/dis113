package ru.itis.semestr2.controller;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/testws")
public class WebSocketTest {

    @OnOpen
    public void onOpen(Session session) {
        System.out.printf("Session opened, id: %s%n", session.getId());
        try {
            session.getBasicRemote().sendText("Hi there, we are successfully connected.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // client -> send message
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.printf("Message received. Session id: %s Message: %s%n",
                session.getId(), message);
        try {
            session.getBasicRemote()
                .sendText(String.format("We received your message: %s, session id: %s ", message, session.getId()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @OnError
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    @OnClose
    public void onClose(Session session) {
        System.out.printf("Session closed with id: %s%n", session.getId());
    }
}

