/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.data.query;

public class UserQuery {
    public static final String LOAD_ALL_USER_DATA = "SELECT * FROM user";
    public static final String LOAD_ALL_USER_DATA_BY_TYPE = "SELECT * FROM user WHERE uType = ? AND uStatus = ?";
    public static final String LOAD_SPECIFIC_USER_DATA = "SELECT * FROM user WHERE uID = ?";
    public static final String INSERT_USER_DATA = "INSERT INTO user (uID, uFName, uLName, uType, uPassword, uStatus, uSpecialization) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_USER_DATA = "UPDATE user SET uFName = ?, uLName = ?, uType = ?, uStatus = ? WHERE uID = ?";
    public static final String UPDATE_USER_PASSWORD = "UPDATE user SET uPassword = ? WHERE uID = ?";
    public static final String UPDATE_USER_STATUS = "UPDATE user SET uStatus = ? WHERE uID = ?";
    public static final String DELETE_USER_DELETE = "DELETE FROM user WHERE uID = ?";
}
