/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.useraccount;

import com.bank.login.LoginView;

/**
 *
 * @author welcome
 */
public interface UserAccountViewCallBack {

    public void yourDetails(int id, LoginView loginView);

    public void checkAccountDetails(int id, LoginView loginView);

    public void permissionDenied(int id, LoginView loginView);

    public void logout(int id, LoginView loginView);

    public void invalidInput(int id, LoginView loginView);

    public void editInfo(int id, LoginView loginView);

    public void userHomePage(LoginView loginView, int id);


    public void editUserName(int id);

    public void editDOB(int id, LoginView loginView);

    public void editMobileNo(int id);

    public void editBrance(int id, LoginView loginView);

    public void editGender(int id);

    public void unableToEditBranch(int id, LoginView loginView);

    public void deposit(int id, LoginView loginView);

    public void withdraw(int id, LoginView loginView);

    public void accountBalance(int id, LoginView loginView);


    public void invalidAccountDetailSelection(int id, LoginView loginView);

    public void limitReached(int id, LoginView loginView);

    public void depositSuccess(int id, LoginView loginView, long amount);

    public void unableToWithdraw(int id, LoginView loginView);

    public void withdrawSuccess(int id, long amount, LoginView loginView);

    public void balanceLow(int id, LoginView loginView);

    public void moneyTransfer(int id, LoginView loginView);

    public void unableToTransfer(int id, LoginView loginView);

    public void moneyTransferedSuccess(int id, LoginView loginView);

    public void monerTransferedFailed(int id, LoginView loginView);
    
}
