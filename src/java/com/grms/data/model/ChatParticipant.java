/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.data.model;

import com.grms.logic.utility.UtilityMethod;

public class ChatParticipant {
    
    private String cPID = null;
    private String cPGID = null;
    private String cPParticipant = null;
    private String cPStatus = null;

    public ChatParticipant() {
    }
    
    public ChatParticipant(String cPID, String cPGID, String cPParticipant, String cPStatus) {
        this.cPID = UtilityMethod.addPrefix("CP", cPID);
        this.cPGID = UtilityMethod.addPrefix("G", cPGID);
        this.cPParticipant = cPParticipant;
        this.cPStatus = cPStatus;
    }

    public String getcPID() {
        return cPID;
    }

    public void setcPID(String cPID) {
        this.cPID = cPID;
    }

    public String getcPGID() {
        return cPGID;
    }

    public void setcPGID(String cPGID) {
        this.cPGID = cPGID;
    }

    public String getcPParticipant() {
        return cPParticipant;
    }

    public void setcPParticipant(String cPParticipant) {
        this.cPParticipant = cPParticipant;
    }

    public String getcPStatus() {
        return cPStatus;
    }

    public void setcPStatus(String cPStatus) {
        this.cPStatus = cPStatus;
    }
    
    
}
