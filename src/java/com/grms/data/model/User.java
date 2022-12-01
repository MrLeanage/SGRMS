/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.data.model;

public class User {
    private String uID = null;
    private String uFName = null;
    private String uLName = null;
    private String uType = null;
    private String uPassword = null;
    private String uStatus = null;
    private String uSpecialization = null;

    public User() {
    }

    public User(String uID, String uFName, String uLName, String uType, String uPassword, String uStatus, String uSpecialization){
        this.uID = uID;
        this.uFName = uFName;
        this.uLName = uLName;
        this.uType = uType;
        this.uPassword = uPassword;
        this.uStatus = uStatus;
        this.uSpecialization = uSpecialization;
    }
    
    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getuFName() {
        return uFName;
    }

    public void setuFName(String uFName) {
        this.uFName = uFName;
    }

    public String getuLName() {
        return uLName;
    }

    public void setuLName(String uLName) {
        this.uLName = uLName;
    }

    public String getuType() {
        return uType;
    }

    public void setuType(String uType) {
        this.uType = uType;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuStatus() {
        return uStatus;
    }

    public void setuStatus(String uStatus) {
        this.uStatus = uStatus;
    }

    public String getuSpecialization() {
        return uSpecialization;
    }

    public void setuSpecialization(String uSpecialization) {
        this.uSpecialization = uSpecialization;
    }
    
}
