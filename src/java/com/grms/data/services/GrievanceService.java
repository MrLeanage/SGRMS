/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.data.services;

import com.grms.data.dbConnection.DBConnection;
import com.grms.data.model.ChatMessage;
import com.grms.data.model.ChatParticipant;
import com.grms.data.model.Grievance;
import com.grms.data.model.User;
import com.grms.data.query.GrievanceQuery;
import com.grms.data.query.UserQuery;
import com.grms.logic.utility.UtilityMethod;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GrievanceService {
    private Connection connection;
    public GrievanceService(){
        connection = DBConnection.getDBConnection();
    }
     public ArrayList<Grievance> getAllGrievanceList(){
       ArrayList<Grievance> grievanceList = new ArrayList<Grievance>();
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(GrievanceQuery.LOAD_ALL_GRIEVANCE_DATA);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                grievanceList.add( new Grievance(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10), resultSet.getString(11), resultSet.getString(12)));
                
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return grievanceList;
    }
    public ArrayList<Grievance> getEmployeeGrievanceList(String userID){
       ArrayList<Grievance> grievanceList = new ArrayList<Grievance>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(GrievanceQuery.LOAD_ALL_SPECIFIC_USER_GRIEVANCE_DATA);
            preparedStatement.setString(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                grievanceList.add( new Grievance(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10), resultSet.getString(11), resultSet.getString(12)));
                
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return grievanceList;
    }
    public ArrayList<Grievance> getManagerGrievanceList(String userID){
       ArrayList<Grievance> grievanceList = new ArrayList<Grievance>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(GrievanceQuery.LOAD_ALL_SPECIFIC_MANAGER_GRIEVANCE_DATA);
            preparedStatement.setString(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                grievanceList.add( new Grievance(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10), resultSet.getString(11), resultSet.getString(12)));
                
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return grievanceList;
    }
    
    public ArrayList<Grievance> getGrievanceListByStatus(String status){
       ArrayList<Grievance> grievanceList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(GrievanceQuery.LOAD_ALL_SPECIFIC_STATUS_GRIEVANCE_DATA);
            preparedStatement.setString(1, status);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                grievanceList.add( new Grievance(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10), resultSet.getString(11), resultSet.getString(12)));
                
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return grievanceList;
    }
    
    public boolean postNewGrievance(Grievance grievance){
         
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GrievanceQuery.INSERT_GRIEVANCE_DATA);
            preparedStatement.setString(1, grievance.getgUID());
            preparedStatement.setString(2, grievance.getgTitle());
            preparedStatement.setString(3, grievance.getgDescription());
            preparedStatement.setString(4, grievance.getgStartDate());
            preparedStatement.setString(5, grievance.getgStartTime());
            preparedStatement.setString(6, grievance.getgL3Manager());
            preparedStatement.setString(7, grievance.getgType());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    public boolean acceptManagerL3Grievance(String gID){
         
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GrievanceQuery.ACCEPT_MANAGERL3_GRIEVANCE);
            preparedStatement.setString(1, "Processing");
            preparedStatement.setString(2, "true");
            preparedStatement.setInt(3, UtilityMethod.seperateID(gID));
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean registerGrievance(String gID, String user){
         
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GrievanceQuery.REGISTER_GRIEVANCE_USER);
            preparedStatement.setInt(1, UtilityMethod.seperateID(gID));
            preparedStatement.setString(2, user);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public Grievance loadSpecificGrievance(String gID){
       Grievance grievance = null;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(GrievanceQuery.LOAD_SPECIFIC_GRIEVANCE_DATA);
            preparedStatement.setInt(1, UtilityMethod.seperateID(gID));
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                grievance = new Grievance(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10), resultSet.getString(11), resultSet.getString(12));
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return grievance;
    }
    
    public ArrayList<Grievance> getAllChatParticipantRecords(){
       ArrayList<Grievance> grievanceList = new ArrayList<Grievance>();
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(GrievanceQuery.LOAD_ALL_GRIEVANCE_DATA);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                grievanceList.add( new Grievance(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10), resultSet.getString(11), resultSet.getString(12)));
                
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return grievanceList;
    }
    
    public ArrayList<ChatMessage> getChatMessages(String gID){
       ArrayList<ChatMessage> chatGroupMessageData = new ArrayList<ChatMessage>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(GrievanceQuery.LOAD_SPECIFIC_CHAT_GROUP_DATA);
            preparedStatement.setInt(1, UtilityMethod.seperateID(gID));
            ResultSet resultSet = preparedStatement.executeQuery();
            UserService userService = new UserService();
            while(resultSet.next()){
                User user = new User();
                user.setuID(resultSet.getString(4));
                User userInfo = userService.loadSpecificUser(user);
                chatGroupMessageData.add( new ChatMessage(resultSet.getString(1), resultSet.getString(2), resultSet.getString(4), userInfo.getuFName() + " " + userInfo.getuLName(), resultSet.getString(3), resultSet.getString(5), resultSet.getString(6)));
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return chatGroupMessageData;
    }
    
    public boolean addChatMsg(String gID, String msg, String senderID, String date, String time){
         
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GrievanceQuery.INSERT_CHAT_DATA);
            preparedStatement.setInt(1, UtilityMethod.seperateID(gID));
            preparedStatement.setString(2, msg);
            preparedStatement.setString(3, senderID);
            preparedStatement.setString(4, date);
            preparedStatement.setString(5, time);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    public ArrayList<ChatParticipant> getAllGrievanceChatParticipantData(){
       ArrayList<ChatParticipant> chatParticipantList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(GrievanceQuery.LOAD_ALL_GRIEVANCE_CHAT_PARTICIPANTS);           
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                chatParticipantList.add( new ChatParticipant(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return chatParticipantList;
    }
    public ArrayList<User> getGrievanceChatParticipants(String grievanceID){
       ArrayList<User> chatParticipants = new ArrayList<User>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(GrievanceQuery.LOAD_GRIEVANCE_CHAT_PARTICIPANTS);
            preparedStatement.setInt(1, UtilityMethod.seperateID(grievanceID));
            ResultSet resultSet = preparedStatement.executeQuery();
            UserService userService = new UserService();
            while(resultSet.next()){
                User user = new User();
                user.setuID(resultSet.getString(3));
                chatParticipants.add(userService.loadSpecificUser(user));
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return chatParticipants;
    }
    public ArrayList<ChatParticipant> getGrievanceChatParticipantsByLoggedUser(String userID){
       ArrayList<ChatParticipant> chatParticipants = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(GrievanceQuery.LOAD_GRIEVANCE_CHAT_PARTICIPANTS_BY_USER);
            preparedStatement.setString(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                chatParticipants.add(new ChatParticipant(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)) );
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return chatParticipants;
    }
    
    public boolean updateGrievanceStatus(String grievanceID, String grievanceStatus){
         
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GrievanceQuery.UPDATE_GRIEVANCE_STATUS);
            preparedStatement.setString(1, grievanceStatus);
            preparedStatement.setInt(2, UtilityMethod.seperateID(grievanceID));
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
}
