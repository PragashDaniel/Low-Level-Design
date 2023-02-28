/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.login;


import java.util.Date;
import java.util.HashMap;


/**
 *
 * @author welcome
 */
public class LoginController implements  LoginControllerViewCallBack,LoginControllerModelCallBack{

    private LoginModelCallBack loginModel;
    private LoginViewCallBack loginView;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        loginModel = new LoginModel(this);
    }

    public void login(int input) {
        loginModel.login(input);
    }

    void adminLogin() {
        loginView.adminLogin();
    }

    void user() {
        loginView.user();
    }

    void exit() {
        loginView.exit();
    }

    void invalidInput() {
        loginView.invalidInput();
    }

    public void check(int input) {
        loginModel.check(input);
    }

    void userSignIn() {
        loginView.userSignIn();
    }

    void userSignUp() {
        loginView.userSignUp();
    }

    void back() {
        loginView.firstPage();
    }

    public HashMap<Integer, String> brances() {
        return loginModel.branches();
    }

    void passwordMismatch() {
        loginView.passwordMismatch();
    }

    void unableToAdd() {
        loginView.unableToAdd();
    }

    public boolean checkUserCredentials(Integer userId, String userPassword) {
        return loginModel.checkUserCredentials(userId, userPassword);
    }

    public int getId() {
        return loginModel.getId();
    }

    public void checkBranch(int branch) {
        if(!loginModel.checkBranch(branch))
            loginView.invalidBranch();
    }

    public boolean checkAdminCredentials(int adminId, String adminPassword) {
        return loginModel.checkAdminCredentials(adminId,adminPassword);
    }

    @Override
    public boolean addData(String firstName, String lastName, Date dob, long mobileNo, Integer gender, int branch, String password, String reEnteredPassword) {
        return loginModel.addData(firstName, lastName, dob, mobileNo, gender, branch, password, reEnteredPassword);
    }

}
