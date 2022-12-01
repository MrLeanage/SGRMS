/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.logic.utility;

/**
 *
 * @author dulshan
 */
public class Validation {
    public static boolean isValidMaxLength(String value, int length){
        return value.length() <= length;
    }
    public static String isValidMaxLength (String value, int length, String validationMsg){
        if(isValidMaxLength(value, length))
            return validationMsg;
        return "";
    }
    public static boolean isValidMinLength(String value, int length){
        return value.length() > length;
    }
    public static String isValidMinLength(String value, int length, String validationMsg){
        if(isValidMinLength(value, length))
            return validationMsg;
        return "";
    }
}
