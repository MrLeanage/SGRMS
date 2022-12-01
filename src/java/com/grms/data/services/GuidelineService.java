/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.data.services;

import com.grms.data.dbConnection.DBConnection;
import com.grms.data.model.Guideline;
import com.grms.data.query.GuidelineQuery;
import com.grms.logic.utility.UtilityMethod;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GuidelineService {
    private Connection connection;

    public GuidelineService() {
        connection = DBConnection.getDBConnection();
    }
    
    public ArrayList<Guideline> loadGuidelineList(){
       ArrayList<Guideline> guidelineList = new ArrayList<Guideline>();
        
        try{
            
            PreparedStatement preparedStatement = connection.prepareStatement(GuidelineQuery.LOAD_ALL_GUIDELINE_DATA);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                guidelineList.add( new Guideline(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(5), resultSet.getString(6)));
                
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return guidelineList;
    }
    
    public Guideline loadSpecificGuideline(int gLVersionID){
       Guideline guideline = new Guideline();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(GuidelineQuery.LOAD_SPECIFIC_GUIDELINE_DATA);
            preparedStatement.setInt(1, gLVersionID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Blob blob = resultSet.getBlob(4);
                guideline = new Guideline(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), blob.getBinaryStream(), resultSet.getString(5), resultSet.getString(6));
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return guideline;
    }
    
    public Guideline loadLatestGuideline(){
       Guideline guideline = new Guideline();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(GuidelineQuery.LOAD_LATEST_GUIDELINE_DATA);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Blob blob = resultSet.getBlob(4);
                guideline = new Guideline(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), blob.getBinaryStream(), resultSet.getString(5), resultSet.getString(6));
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return guideline;
    }
    
     public boolean addNewGuideline(Guideline guideline){
         
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GuidelineQuery.INSERT_GUIDELINE_DATA);
            preparedStatement.setString(1, guideline.getgLTitle());
            preparedStatement.setString(2, guideline.getgLDescription());
            preparedStatement.setBlob(3, guideline.getgLFile());
            preparedStatement.setString(4, guideline.getgLUploadDate());
            preparedStatement.setString(5, guideline.getgLModifyDate());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
}
 