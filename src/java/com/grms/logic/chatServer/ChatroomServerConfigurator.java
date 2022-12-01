/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.logic.chatServer;

import com.grms.data.model.User;
import javax.servlet.http.HttpSession; 
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

public class ChatroomServerConfigurator extends ServerEndpointConfig.Configurator {
    
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response){
        sec.getUserProperties().put("authUser", (User)((HttpSession) request.getHttpSession()).getAttribute("authUser"));
        sec.getUserProperties().put("chatTokenID", (String)((HttpSession) request.getHttpSession()).getAttribute("chatTokenID"));
        
    }
}
