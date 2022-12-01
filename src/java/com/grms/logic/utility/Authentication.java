/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.logic.utility;

import com.grms.data.model.User;
import com.grms.data.services.UserService;

public class Authentication {
    private static User userSession = null;

    public static User getUserSession() {
        return userSession;
    }

    public static void setUserSession(User userSession) {
        Authentication.userSession = userSession;
    }
    
    public static User authenticateUser(User user){
        UserService userService = new UserService();
        User resultUser = userService.loadSpecificUser(user);
        
        if(resultUser == null){
            resultUser.setuStatus("Invalid User ID");
            return resultUser;
        }else if(!resultUser.getuPassword().equals(user.getuPassword())){
            resultUser.setuStatus("Invalid Password");
            return resultUser;
        }else{
            return resultUser;
        }
    }
}
