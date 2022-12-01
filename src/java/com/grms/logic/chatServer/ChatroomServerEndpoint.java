/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.logic.chatServer;

import com.grms.data.constant.Constant;
import java.io.StringWriter;
import java.time.LocalDate;  
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import com.grms.data.model.User;
import com.grms.data.services.GrievanceService;
import com.grms.logic.utility.UtilityMethod;

@ServerEndpoint(value = "/" + Constant.CHATROOM_ENDPOINT_NAME, configurator = ChatroomServerConfigurator.class)
public class ChatroomServerEndpoint {

    static Set<Session> chatroomUsers = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void handleOpen(EndpointConfig endpointConfig,
            Session userSession) {
        userSession.getUserProperties().put("authUser", endpointConfig.getUserProperties().get("authUser"));
        userSession.getUserProperties().put("chatTokenID", endpointConfig.getUserProperties().get("chatTokenID"));
        chatroomUsers.add(userSession);
    }

    @OnMessage
    public void handleMessage(String message,
            Session userSession) {
        User authUser = (User) userSession.getUserProperties().get("authUser");
        String chatTokenID = (String) userSession.getUserProperties().get("chatTokenID");

        System.out.println(authUser.getuID());
        if (authUser.getuID() != null) {
            GrievanceService grievanceService = new GrievanceService();
            String date = String.valueOf(LocalDate.now());
            String time = UtilityMethod.currentTime();
            grievanceService.addChatMsg(chatTokenID, message, authUser.getuID(), date, time);
            chatroomUsers.stream().forEach(x -> {
                try {
                    x.getBasicRemote().sendText(buildJsonData(chatTokenID, authUser.getuID(), authUser.getuFName() + " " + authUser.getuLName(), message, date, time));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @OnClose
    public void handleClose(Session userSession) {
        chatroomUsers.remove(userSession);
    }

    @OnError
    public void handleError(Throwable t) {

    }

    private String buildJsonData(String chatTokenID,
            String userID,
            String userName,
            String message,
            String date,
            String time) {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("chatTokenID", chatTokenID)
                .add("userID", userID)
                .add("userName", userName)
                .add("message", message)
                .add("date_stamp", date)
                .add("time_stamp", time)
                .build();

        StringWriter stringWriter = new StringWriter();
        try (JsonWriter jsonWriter = Json.createWriter(stringWriter)) {
            jsonWriter.write(jsonObject);
        }
        return stringWriter.toString();
    }
}
