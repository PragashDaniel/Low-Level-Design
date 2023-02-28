/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.useraccount;

import com.bank.dto.User;
import com.bank.login.LoginView;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author welcome
 */
public class UserAccountController implements UserAccountControllerModelCallBack,UserAccountControllerViewCallBack {
    
    private UserAccountViewCallBack userAccountView;
    private UserAccountModelCallBack userAccountModel;
    public UserAccountController(UserAccountView userAccountView)
    {
        this.userAccountModel=new UserAccountModel(this);
        this.userAccountView=userAccountView;
    }

    public void selectedModule(int input,int id,LoginView loginView) {
        if(input==1)
            userAccountView.yourDetails(id,loginView);
        else if(input==2)
            if(userAccountModel.checkAccountDetails(id))
                userAccountView.checkAccountDetails(id,loginView);
            else 
                userAccountView.permissionDenied(id,loginView);
        else if(input==3)
            userAccountView.logout(id,loginView);
        else
            userAccountView.invalidInput(id,loginView);
    }

    

    public User getDetail(int id) {
        return userAccountModel.getDetail(id);
    }

    public void next(int input,int id,LoginView loginView) {
        if(input==1)
            userAccountView.editInfo(id,loginView);
        else if(input==2)
            userAccountView.userHomePage(loginView, id);
        else
            userAccountView.invalidInput(id,loginView);
    }

    public void editInfo(int input,int id,LoginView loginView) {
        if(input==1)
            userAccountView.editUserName(id);
        else if(input==2)
            userAccountView.editDOB(id,loginView);
        else if(input==3)
            userAccountView.editMobileNo(id);
        else if(input==4)
            userAccountView.editBrance(id,loginView);
        else if(input==5)
            userAccountView.editGender(id);
        else
            userAccountView.invalidInput(id,loginView);
    }

    public HashMap<Integer,String> branches() {
        return userAccountModel.branches();
    }

    public void editUserName(String firstName, String lastName,int id) {
        userAccountModel.editUserName(firstName,lastName,id);
    }

    public void editDOB(Date dob, int id) {
        userAccountModel.editDOB(dob,id);
    }

    public void editMobileNo(long mobileNumber, int id) {
        userAccountModel.editMobileNo(mobileNumber,id);
    }

    public void editBranch(Integer branch, int id,LoginView loginView) {
        if(branch>=1 && branch<6)
            userAccountModel.editBranch(branch,id);
        else 
            userAccountView.unableToEditBranch(id,loginView);
    }

    public void editGender(Integer gender, int id) {
        userAccountModel.editGender(gender,id);
    }

    public void accountDetailSelection(int input, int id, LoginView loginView) {
        if(input==1)
            userAccountView.deposit(id,loginView);
        else if(input==2)
            userAccountView.withdraw(id,loginView);
        else if(input==3)
            userAccountView.accountBalance(id,loginView);
        else if(input==4)
            userAccountView.moneyTransfer(id,loginView);
        else if(input==5)
                userAccountView.userHomePage(loginView, id);
        else
            userAccountView.invalidAccountDetailSelection(id,loginView);
    }

    public void deposit(int id, long amount,LoginView loginView) {
        if(amount%100!=0 || (amount>=25000 || amount<100))
            userAccountView.limitReached(id,loginView);
        else
            if(userAccountModel.deposit(id,amount))
                userAccountView.depositSuccess(id, loginView,amount);
    }

    public void withdraw(int id, long amount, LoginView loginView) {
        if(amount%100!=0 || (amount<100 || amount>10000))
            userAccountView.unableToWithdraw(id,loginView);
        else
            if(userAccountModel.withdraw(id,amount))
                userAccountView.withdrawSuccess(id,amount,loginView);
            else
                userAccountView.balanceLow(id,loginView);
    }

    public long accountBalance(int id) {
        return userAccountModel.accountBalance(id);
    }

    @Override
    public void moneyTransfer(int id, LoginView loginView, int receiverId, long amount) {
        if(amount%100!=0 || (amount<100 || amount>10000))
            userAccountView.unableToTransfer(id,loginView);
        else    
            if(userAccountModel.moneyTransfer(id,loginView,receiverId,amount))
                userAccountView.moneyTransferedSuccess(id, loginView);
            else
                userAccountView.monerTransferedFailed(id,loginView);
            
    }

    
    
    
}
