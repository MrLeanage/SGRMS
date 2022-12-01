/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.data.model;

public class GrievanceManagerStatistics {
    private String gMID = null;
    private int gMPendingCount = 0; 
    private int gMProcessingCount = 0; 
    private int gMFinishedCount = 0; 
    private int gMTotalGrievanceCount = 0; 

    public GrievanceManagerStatistics() {
    }
    
    public GrievanceManagerStatistics(String gMID, int gMPendingCount, int gMProcessingCount, int gMFinishedCount, int gMTotalGrievanceCount) {
        this.gMID =  gMID;
        this.gMPendingCount =  gMPendingCount;
        this.gMProcessingCount =  gMProcessingCount;
        this.gMFinishedCount =  gMFinishedCount;
        this.gMTotalGrievanceCount =  gMPendingCount + gMProcessingCount + gMFinishedCount;
    }

    public String getgMID() {
        return gMID;
    }

    public void setgMID(String gMID) {
        this.gMID = gMID;
    }

    public int getgMPendingCount() {
        return gMPendingCount;
    }

    public void setgMPendingCount(int gMPendingCount) {
        this.gMPendingCount = gMPendingCount;
    }

    public int getgMProcessingCount() {
        return gMProcessingCount;
    }

    public void setgMProcessingCount(int gMProcessingCount) {
        this.gMProcessingCount = gMProcessingCount;
    }

    public int getgMFinishedCount() {
        return gMFinishedCount;
    }

    public void setgMFinishedCount(int gMFinishedCount) {
        this.gMFinishedCount = gMFinishedCount;
    }

    public int getgMTotalGrievanceCount() {
        return gMTotalGrievanceCount;
    }
    
}
