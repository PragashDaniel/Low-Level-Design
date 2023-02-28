/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.login.adminaccount;

import com.bank.login.LoginView;

/**
 *
 * @author welcome
 */
public interface AdminAccountViewCallBack {

    public void userRequest(LoginView loginView);

    public void manageUser(LoginView loginView);

    public void showUsers(LoginView loginView);

    public void totalBankBalance(LoginView loginView);

    public void signOut(LoginView loginView);

    public void invalidInput(LoginView loginView);

    public void deletionSuccess(LoginView loginView);

    public void deletionUnsuccess(LoginView loginView);

    public void add(LoginView loginView);

    public void invalidInputForManage(LoginView loginView);

    public void invalidBranchId(LoginView loginView);

    public void approved(LoginView loginView);

    
}
