/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fms.login;

import java.util.Date;

public class LoginController implements LoginControllerViewCallBack,LoginControllerModelCallBack {

    private LoginModelCallBack loginModel;
    private LoginViewCallBack loginView;

    public LoginController(LoginView loginView) {
        this.loginView=loginView;
        loginModel = new LoginModel(this);
    }

    public void loginAdmin(int input) {
        loginModel.loginAdmin(input);
    }

    public void admin() {
        loginView.admin();
    }

    public void user() {
        loginView.user();
    }

    public void checkUser(int input) {
        loginModel.checkUser(input);
    }

    public void signIn() {
        loginView.signIn();
    }

    public void signUp() {
        loginView.signUp();
    }

    public void checkLogin(int id, String password) {
        loginModel.checkLogin(id, password);
    }

    public void adminLoginSuccess() {
        loginView.adminLoginSuccess();
    }

    public void adminLoginFailed() {
        loginView.adminLoginFailed();
    }

    public void checkUserCredentials(int userId, String userPassword) {
        loginModel.checkUserCredentials(userId, userPassword);
    }

    public void userLoginSuccess(int userId) {
        loginView.userLoginSuccess(userId);
    }

    public void userLoginFailed() {
        loginView.userLoginFailed();
    }

    public void addData(String userName,String userDOB,String userMobileNo,Integer gender,String password,String reEnteredPassword) {
        if(userMobileNo.length()==10)
            loginModel.addData(userName,userDOB,userMobileNo,gender,password,reEnteredPassword);
        loginView.dataAddedFailed();
    }
    
    public void passwordMismatch()
    {
        loginView.passwordMismatch();
    }

    public void dataAddedSuccesfully(int userId) {
        loginView.dataAddedSuccessfully(userId);
    }

    public void dataAddedFailed() {
       loginView.dataAddedFailed();
    }
    
    public void inValidUser()
    {
        loginView.inValidUser();
    }
    
    public void inValidAdmin()
    {
        loginView.inValidAdmin();
    }

    public void exit() {
        loginView.exit();
    }

    public void back() {
        loginView.back();
    }

}
