/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.login;

/**
 *
 * @author welcome
 */
interface LoginViewCallBack {

    public void adminLogin();

    public void user();

    public void exit();

    public void invalidInput();

    public void userSignIn();

    public void userSignUp();

    public void firstPage();

    public void passwordMismatch();

    public void unableToAdd();

    public void invalidBranch();
    
}
