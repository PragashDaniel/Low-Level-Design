/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fms.login;

import com.fms.repository.Repository;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author welcome
 */
public class LoginModel implements LoginModelCallBack{

    LoginControllerModelCallBack loginController;

    public LoginModel(LoginController loginController) {
        this.loginController = loginController;
    }

    public void loginAdmin(int input) {
        if (input == 1) {
            loginController.admin();
        } else if (input == 2) {
            loginController.user();
        }
        else if(input==3)
            loginController.exit();
        else
            loginController.inValidAdmin();
    }

    public void checkUser(int input) {
        if (input == 1) {
            loginController.signIn();
        } else if (input == 2) {
            loginController.signUp();
        }
        else if(input ==3)
        {
            loginController.back();
        }
        else 
            loginController.inValidUser();
    }

    public void checkLogin(int adminId, String password) {
        try {
            if (Repository.getInstance().checkAdmin(adminId, password))
                loginController.adminLoginSuccess();
            else
                loginController.adminLoginFailed();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            loginController.adminLoginFailed();
        }
    }

    public void checkUserCredentials(int userId, String userPassword) {
        try {
            if (Repository.getInstance().checkUserCredentials(userId,userPassword)) {
                loginController.userLoginSuccess(userId);
            } else {
                loginController.userLoginFailed();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            loginController.userLoginFailed();
        }
    }

    public void addData(String userName, String userDOB, String userMobileNo, Integer gender, String password, String reEnteredPassword) {
        if(password.equals(reEnteredPassword))
            if(userName==null  && userMobileNo==null && gender==null && userDOB==null)
                loginController.dataAddedFailed();
            else
            { 
                try {
                     int userId=Repository.getInstance().addUserData(userName,userDOB,userMobileNo,gender,password);
                     if(userId!=-1)
                        loginController.dataAddedSuccesfully(userId);
                     else
                         loginController.dataAddedFailed();
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
                    loginController.dataAddedFailed();
                }
            }
        else
            loginController.passwordMismatch();
    }

}
