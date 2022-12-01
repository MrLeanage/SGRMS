/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.data.query;


public class GrievanceQuery {
    public static final String LOAD_ALL_GRIEVANCE_DATA = "SELECT * FROM grievance";
    public static final String LOAD_ALL_SPECIFIC_STATUS_GRIEVANCE_DATA = "SELECT * FROM grievance where gStatus = ?";
    public static final String LOAD_ALL_SPECIFIC_USER_GRIEVANCE_DATA = "SELECT * FROM grievance where gUID = ?";
    public static final String LOAD_ALL_SPECIFIC_MANAGER_GRIEVANCE_DATA = "SELECT * FROM grievance where gL3Manager = ?";
    public static final String LOAD_SPECIFIC_GRIEVANCE_DATA = "SELECT * FROM grievance WHERE gID = ?";
    public static final String INSERT_GRIEVANCE_DATA = "INSERT INTO grievance (gUID, gTitle, gDescription, gStartDate, gStartTime, gL3Manager, gType) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_GRIEVANCE_DATA = "UPDATE grievance SET gTitle = ?, gDescription = ?, gStartDate = ?, gStartTime = ?, gEndDate = ?, gEndTime = ?, gStatus = ?, gChat = ? WHERE gID = ?";
    public static final String UPDATE_GRIEVANCE_STATUS = "UPDATE grievance SET gStatus = ? WHERE gID = ?";
    public static final String ACCEPT_MANAGERL3_GRIEVANCE = "UPDATE grievance SET gStatus =?, gChat = ? WHERE gID = ?";
    
    public static final String REGISTER_GRIEVANCE_USER = "INSERT INTO chat_participants (cPGID, cPParticipant) VALUES (?, ?)";
    
    public static final String LOAD_SPECIFIC_CHAT_GROUP_DATA = "SELECT * FROM grievance_chat where cGID = ?";
    public static final String INSERT_CHAT_DATA = "INSERT INTO grievance_chat (cGID, cMsg, cMsgSender, cMsgDate, cMsgTime) VALUES (?, ?, ?, ?, ?)";
    
    public static final String LOAD_ALL_GRIEVANCE_CHAT_PARTICIPANTS = "SELECT * FROM chat_participants WHERE cPStatus = 'Enabled'";
    public static final String LOAD_GRIEVANCE_CHAT_PARTICIPANTS = "SELECT * FROM chat_participants where cPGID = ?";
    public static final String LOAD_GRIEVANCE_CHAT_PARTICIPANTS_BY_USER = "SELECT * FROM chat_participants where cPParticipant = ?";
}
