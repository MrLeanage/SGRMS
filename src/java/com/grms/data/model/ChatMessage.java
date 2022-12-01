/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.data.model;

import com.grms.logic.utility.UtilityMethod;

public class ChatMessage {
    private String cID = null;
    private String cGID = null;
    private String cMsgSenderID = null;
    private String cMsgSenderName = null;
    private String cMsg = null;
    private String cMsgDate = null;
    private String cMsgTime = null;

    public ChatMessage() {
    }

    public ChatMessage(String cID, String cGID, String cMsgSenderID, String cMsgSenderName, String cMsg, String cMsgDate, String cMsgTime) {
        this.cID = UtilityMethod.addPrefix("GC", cID);
        this.cGID = UtilityMethod.addPrefix("G", cGID);
        this.cMsgSenderID = cMsgSenderID;
        this.cMsgSenderName = cMsgSenderName;
        this.cMsg = cMsg;
        this.cMsgDate = cMsgDate;
        this.cMsgTime = cMsgTime;
    }
    
    public String getcID() {
        return cID;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }

    public String getcGID() {
        return cGID;
    }

    public void setcGID(String cGID) {
        this.cGID = cGID;
    }

    public String getcMsgSenderID() {
        return cMsgSenderID;
    }

    public void setcMsgSenderID(String cMsgSenderID) {
        this.cMsgSenderID = cMsgSenderID;
    }

    public String getcMsgSenderName() {
        return cMsgSenderName;
    }

    public void setcMsgSenderName(String cMsgSenderName) {
        this.cMsgSenderName = cMsgSenderName;
    }

    public String getcMsg() {
        return cMsg;
    }

    public void setcMsg(String cMsg) {
        this.cMsg = cMsg;
    }

    public String getcMsgDate() {
        return cMsgDate;
    }

    public void setcMsgDate(String cMsgDate) {
        this.cMsgDate = cMsgDate;
    }

    public String getcMsgTime() {
        return cMsgTime;
    }

    public void setcMsgTime(String cMsgTime) {
        this.cMsgTime = cMsgTime;
    }
    
    
    
}
