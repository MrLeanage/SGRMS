/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.logic.controller;

import com.grms.data.model.User;
import com.grms.data.model.UserValidation;
import com.grms.data.services.UserService;
import com.grms.logic.utility.Authentication;
import com.grms.logic.utility.Validation;
import java.util.ArrayList;

public class UserController {

    public ArrayList<User> loadAllUser() {
        UserService userService = new UserService();
        return userService.loadAllUser();
    }
    public ArrayList<User> loadAllStudentUsers() {
        UserService userService = new UserService();
        ArrayList<User> studentUsers = new ArrayList();
        for(User user :userService.loadAllUser()){
            if(user.getuType().equals("Student")){
                studentUsers.add(user);
            }
        }
        return studentUsers;
    }

    public ArrayList<User> loadAllManagerUsers() {
        UserService userService = new UserService();
        ArrayList<User> managerUsers = new ArrayList();
        for(User user :userService.loadAllUser()){
            if(!(user.getuType().equals("Student") || user.getuType().equals("Administrator") || user.getuType().equals("Manager - Level 1")) ){
                managerUsers.add(user);
            }
        }
        
        return managerUsers;
    }
    
    public ArrayList<User> loadAllAdminUsers() {
        UserService userService = new UserService();
        ArrayList<User> adminUsers = new ArrayList();
        for(User user :userService.loadAllUser()){
            if(user.getuType().equals("Administrator") || user.getuType().equals("Manager - Level 1")){
                adminUsers.add(user);
            }
        }
        return adminUsers;
    }
    public User loadSpecificUser(User user) {
        UserService userService = new UserService();
        return userService.loadSpecificUser(user);
    }

    public User authenticateUserInfo(User user) {
        return Authentication.authenticateUser(user);
    }

    public boolean addUser(User user) {
        UserService userService = new UserService();
        return userService.insertUserData(user);
    }

    public boolean updateUserData(User user) {
        UserService userService = new UserService();
        return userService.updateUserData(user);
    }

    public boolean updateUserPassword(User user) {
        UserService userService = new UserService();
        return userService.updateUserPassword(user);
    }

    public boolean updateUserStatus(User user) {
        UserService userService = new UserService();
        return userService.updateUserStatus(user);
    }

    public boolean deleteUser(User user) {
        UserService userService = new UserService();
        return userService.deleteUserRecord(user);
    }

    public UserValidation verifyUser(User user) {
        UserValidation userValidation = new UserValidation();
        User matchingUser = loadSpecificUser(user);

        if (matchingUser == null) {
            userValidation.setUserVStatus(false);
        } else {
            if (matchingUser.getuFName().equals(user.getuFName())
                    && matchingUser.getuLName().equals(user.getuLName())
                    && matchingUser.getuStatus().equals(user.getuStatus())
                    && matchingUser.getuType().equals(user.getuType())) {
                userValidation.setUserVStatus(true);
            }else
                userValidation.setUserVStatus(false);
            
            if (!matchingUser.getuFName().equals(user.getuFName())) {
                userValidation.setuFNameVMsg("Invalid First Name!");
            }
            if (!matchingUser.getuLName().equals(user.getuLName())) {
                userValidation.setuLNameVMsg("Invalid Last Name!");
            }
            if (!matchingUser.getuStatus().equals(user.getuStatus())) {
                userValidation.setuStatusVMsg("Invalid Account Status!");
            }
            if (!matchingUser.getuType().equals(user.getuType())) {
                userValidation.setuTypeVMsg("Invalid User Type!");
            }
        }

        return userValidation;
    }
}
