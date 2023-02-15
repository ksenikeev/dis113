package ru.itis.semestr2.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ServerEndpoint(value="/accept_trip")
public class AcceptTripWebSocket {

    private Map<String, Session> users = new HashMap<>();

    @OnOpen
    public void onOpen(Session session) {

        System.out.printf("Session opened, id: %s%n", session.getId());
/*
        try {
            session.getBasicRemote().sendText("Hi there, we are successfully connected.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
*/
    }

    @OnMessage
    public void onMessage(String message, Session session) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            MessageWS msg = mapper.readValue(message, MessageWS.class);

            System.out.println(msg.tripId + ", " + msg.driverId);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


        System.out.printf("Message received. Session id: %s Message: %s",
                session.getId(), message);
        try {
            session.getBasicRemote().sendText(String.format("We received your message: %s%n", message));
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

class MessageWS {
    public String driverId;
    public String tripId;
    public String clientId;
}

}

