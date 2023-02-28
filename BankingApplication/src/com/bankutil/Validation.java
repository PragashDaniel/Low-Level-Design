/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankutil;

import com.bank.login.LoginView;

/**
 *
 * @author welcome
 */
public class Validation 
{
    private static LoginView loginView;
    
    //private Validation(){}
            
    public static boolean checkName(String firstName) {
        if (firstName.length() > 30) {
            loginView.invalidName();
            return false;
        }
        firstName=firstName.toLowerCase();
        for (int i = 0; i < firstName.length(); i++) {
            if(firstName.charAt(i) < 97 || firstName.charAt(i) > 122) {
                    return false;
            }
        }
        return true;
    }

    public static boolean checkMobile(Long mobileNo) {

        String mobNo = String.valueOf(mobileNo);
        if (mobNo.length() != 10) {
            return false;
        }
        return true;
    }

    public static boolean checkGender(Integer gender) {
        if (gender != 1 && gender != 2) {
            return false;
        }
        return true;
    }

}
