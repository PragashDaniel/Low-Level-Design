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
interface LoginViewCallBack {

    public void admin();

    public void user();

    public void signIn();

    public void signUp();

    public void adminLoginSuccess();

    public void adminLoginFailed();

    public void userLoginSuccess(int userId);

    public void userLoginFailed();

    public void passwordMismatch();

    public void dataAddedSuccessfully(int userId);

    public void dataAddedFailed();

    public void inValidUser();

    public void inValidAdmin();

    public void exit();

    public void back();
    
}
