/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.data.model;

/**
 *
 * @author dulshan
 */
public class UserValidation {
    private Boolean userVStatus = null;
    private String uEmpIDVMsg = null;
    private String uFNameVMsg = null;
    private String uLNameVMsg = null;
    private String uTypeVMsg = null;
    private String uPasswordVMsg = null;
    private String uStatusVMsg = null;

    public UserValidation() {
        setUserVStatus(false);
        setuEmpIDVMsg("");
        setuFNameVMsg("");
        setuLNameVMsg("");
        setuTypeVMsg("");
        setuPasswordVMsg("");
        setuStatusVMsg("");
        
    }

    public Boolean getUserVStatus() {
        return userVStatus;
    }

    public void setUserVStatus(Boolean userVStatus) {
        this.userVStatus = userVStatus;
    }
    
    public String getuEmpIDVMsg() {
        return uEmpIDVMsg;
    }

    public void setuEmpIDVMsg(String uEmpIDVMsg) {
        this.uEmpIDVMsg = uEmpIDVMsg;
    }

    public String getuFNameVMsg() {
        return uFNameVMsg;
    }

    public void setuFNameVMsg(String uFNameVMsg) {
        this.uFNameVMsg = uFNameVMsg;
    }

    public String getuLNameVMsg() {
        return uLNameVMsg;
    }

    public void setuLNameVMsg(String uLNameVMsg) {
        this.uLNameVMsg = uLNameVMsg;
    }

    public String getuTypeVMsg() {
        return uTypeVMsg;
    }

    public void setuTypeVMsg(String uTypeVMsg) {
        this.uTypeVMsg = uTypeVMsg;
    }

    public String getuPasswordVMsg() {
        return uPasswordVMsg;
    }

    public void setuPasswordVMsg(String uPasswordVMsg) {
        this.uPasswordVMsg = uPasswordVMsg;
    }

    public String getuStatusVMsg() {
        return uStatusVMsg;
    }

    public void setuStatusVMsg(String uStatusVMsg) {
        this.uStatusVMsg = uStatusVMsg;
    }
    
    
}
