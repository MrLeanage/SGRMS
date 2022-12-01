/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.data.services;

import com.grms.data.dbConnection.DBConnection;
import com.grms.data.model.User;
import com.grms.data.query.UserQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService {
    private Connection connection;
    public UserService(){
        connection = DBConnection.getDBConnection();
    }
    public ArrayList<User> loadAllUser(){
        ArrayList<User> userArrayList = new ArrayList();
        try{
            ResultSet resultSet = connection.createStatement().executeQuery(UserQuery.LOAD_ALL_USER_DATA);
            while(resultSet.next()){
                userArrayList.add(new User(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7)));
             }
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return userArrayList;
    }
    public ArrayList<User> loadAllUserByPosition(String type, String status){
        ArrayList<User> userArrayList = new ArrayList();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.LOAD_ALL_USER_DATA_BY_TYPE);
            preparedStatement.setString(1, type);
            preparedStatement.setString(2, status);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                userArrayList.add(new User(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7)));
             }
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return userArrayList;
    }
    public User loadSpecificUser(User user){
        User resultUser = null;
        
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.LOAD_SPECIFIC_USER_DATA);
            preparedStatement.setString(1, user.getuID());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                resultUser = new User(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return resultUser;
    }
    public boolean insertUserData(User user){
         
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.INSERT_USER_DATA);
                preparedStatement.setString(1, user.getuID());
            preparedStatement.setString(2, user.getuFName());
            preparedStatement.setString(3, user.getuLName());
            preparedStatement.setString(4, user.getuType());
            preparedStatement.setString(5, user.getuPassword());
            preparedStatement.setString(6, user.getuStatus());
            preparedStatement.setString(7, user.getuSpecialization());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    public boolean updateUserData(User user){
         
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.UPDATE_USER_DATA);
            
            preparedStatement.setString(1, user.getuFName());
            preparedStatement.setString(2, user.getuLName());
            preparedStatement.setString(3, user.getuType());
            preparedStatement.setString(4, user.getuStatus());
            preparedStatement.setString(5, user.getuID());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    public boolean updateUserPassword(User user){
         
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.UPDATE_USER_PASSWORD);
            
            preparedStatement.setString(1, user.getuPassword());
            preparedStatement.setString(2, user.getuID());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public boolean updateUserStatus(User user){
         
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.UPDATE_USER_STATUS);
            
            preparedStatement.setString(1, user.getuStatus());
            preparedStatement.setString(2, user.getuID());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public boolean deleteUserRecord(User user){
         
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.DELETE_USER_DELETE);
            
            preparedStatement.setString(1, user.getuID());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }


}
