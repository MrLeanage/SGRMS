/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.data.model;

import com.grms.logic.utility.UtilityMethod;

public class Performance {

    private String employeeID = null;
    private String employeeName = null;
    private String employeePosition = null;
    private int pendingCount = 0;
    private int processingCount = 0;
    private int finishedCount = 0;
    private double rank = 0.0;

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public int getPendingCount() {
        return pendingCount;
    }

    public void setPendingCount(int pendingCount) {
        this.pendingCount = pendingCount;
    }

    public int getProcessingCount() {
        return processingCount;
    }

    public void setProcessingCount(int processingCount) {
        this.processingCount = processingCount;
    }

    public int getFinishedCount() {
        return finishedCount;
    }

    public void setFinishedCount(int finishedCount) {
        this.finishedCount = finishedCount;
    }

    public double getRank() {
        return UtilityMethod.formatNumberToTwoDecimalPlaces(generateRank());
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    private Double generateRank() {
        double rank = 0.0;
        double totalCount = (double) pendingCount + processingCount + finishedCount;
        if (totalCount > 0) {
            rank = (finishedCount / totalCount) * 100;
        }
        return rank;
    }

    
}
