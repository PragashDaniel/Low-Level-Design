/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fms.login;

/**
 *
 * @author welcome
 */
interface LoginControllerModelCallBack {

    public void dataAddedSuccesfully(int userId);

    public void dataAddedFailed();

    public void passwordMismatch();

    public void userLoginFailed();

    public void userLoginSuccess(int userId);

    public void adminLoginFailed();

    public void adminLoginSuccess();

    public void inValidUser();

    public void back();

    public void signUp();

    public void signIn();

    public void inValidAdmin();

    public void exit();

    public void user();

    public void admin();
    
}
