/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fms.login;

import java.util.Date;

/**
 *
 * @author welcome
 */
interface LoginControllerViewCallBack {

    public void loginAdmin(int input);

    public void checkLogin(int adminId, String adminPassword);

    public void checkUser(int input);

    public void checkUserCredentials(int userId, String userPassword);

    public void addData(String userName, String userDOB, String userMobileNo, Integer userGender, String userPassword, String reEnteredPassword);
    
}
