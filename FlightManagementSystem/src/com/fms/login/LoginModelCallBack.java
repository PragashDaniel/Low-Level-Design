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
interface LoginModelCallBack {

    public void loginAdmin(int input);

    public void checkUser(int input);

    public void checkLogin(int id, String password);

    public void checkUserCredentials(int userId, String userPassword);

    public void addData(String userName, String userDOB, String userMobileNo, Integer gender, String password, String reEnteredPassword);
    
}
