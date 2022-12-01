/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.data.model;

import com.grms.logic.utility.UtilityMethod;


public class Feedback {
    String fID = null;
    String fTitle = null;
    String fNote = null;
    String fGID = null;
    String fDate = null;
    String fTime = null;
    Grievance fGrievance = null;

    public Feedback() {
        fGrievance = new Grievance();
    }

    public Feedback(String fID, String fTitle, String fNote, String fGID, String fDate, String fTime) {
        this.fID = UtilityMethod.addPrefix("F", fID);
        this.fTitle = fTitle;
        this.fNote = fNote;
        this.fGID = UtilityMethod.addPrefix("G", fGID);
        this.fDate = fDate;
        this.fTime = fTime;
    }
    
    public String getfID() {
        return fID;
    }

    public void setfID(String fID) {
        this.fID = fID;
    }

    public String getfTitle() {
        return fTitle;
    }

    public void setfTitle(String fTitle) {
        this.fTitle = fTitle;
    }

    public String getfNote() {
        return fNote;
    }

    public void setfNote(String fNote) {
        this.fNote = fNote;
    }

    public String getfGID() {
        return fGID;
    }

    public void setfGID(String fGID) {
        this.fGID = fGID;
    }
    
    public Integer getIntegerFGID() {
        return UtilityMethod.seperateID(fGID);
    }
    
    

    public String getfDate() {
        return fDate;
    }

    public void setfDate(String fDate) {
        this.fDate = fDate;
    }

    public String getfTime() {
        return fTime;
    }

    public void setfTime(String fTime) {
        this.fTime = fTime;
    }

    public Grievance getfGrievance() {
        return fGrievance;
    }

    public void setfGrievance(Grievance fGrievance) {
        this.fGrievance = fGrievance;
    }
    
    
    
    
}
