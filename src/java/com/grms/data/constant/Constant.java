/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.data.constant;

public class Constant {
    
    public static final String SYSTEM_PUBLISH_NAME = "SGRMS";
   
    //Network Configurations ws://localhost:2872/GMS/chatroomServerEndpoint
    private static final String CHATROOM_SERVER_ADDRESS = "localhost";
    private static final int CHATROOM_SERVER_PORT = 2872;
    public static final String CHATROOM_ENDPOINT_NAME = "chatroomServerEndpoint";
    public static final String WEB_SOCKET_ADDRESS = "ws://" +CHATROOM_SERVER_ADDRESS + ":" + CHATROOM_SERVER_PORT +"/" + SYSTEM_PUBLISH_NAME + "/" + CHATROOM_ENDPOINT_NAME;
    
    //Grievance types
    public static final String GRIEVANCE_TYPE_ACADEMIC = "Academic Grievance";
    public static final String GRIEVANCE_TYPE_NON_ACADEMIC = "Non Academic Grievance";
    public static final String GRIEVANCE_TYPE_COUNSELING = "Counseling Grievance";
    public static final String GRIEVANCE_TYPE_STUDENT= "Student Grievance";
    public static final String GRIEVANCE_TYPE_MASTER= "Grievance Master";
    
    //user Types
    public static final String USER_TYPE_ADMINISTRATOR = "Administrator";
    public static final String USER_TYPE_MANAGER_LEVEL_1 = "Manager - Level 1";
    public static final String USER_TYPE_MANAGER_LEVEL_2 = "Manager - Level 2";
    public static final String USER_TYPE_MANAGER_LEVEL_3 = "Manager - Level 3";
    public static final String USER_TYPE_STUDENT = "Student";
    
    
    
}
