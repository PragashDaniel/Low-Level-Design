/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.login.adminaccount;

import com.bank.dto.User;
import com.bank.login.LoginView;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author welcome
 */
public class AdminAccountController implements AdminAccountControllerViewCallBack,AdminAccountControllerModelCallBack{

    private AdminAccountViewCallBack adminAccountView;
    private AdminAccountModelCallBack adminAccountModel;
    
    AdminAccountController(AdminAccountView adminAccountView) {
       this.adminAccountView=adminAccountView;
       this.adminAccountModel=new AdminAccountModel(this);
    }

    public void firstPageSeletion(int input,LoginView loginView) {
        if(input==1)
            adminAccountView.userRequest(loginView);
        else if(input==2)
            adminAccountView.manageUser(loginView);
        else if(input==3)
            adminAccountView.showUsers(loginView);
        else if(input==4)
            adminAccountView.totalBankBalance(loginView);
        else if(input==5)
            adminAccountView.signOut(loginView);
        else 
            adminAccountView.invalidInput(loginView);
    }

    public long totalBankBalance() {
        return adminAccountModel.totalBankBalance();
    }

    public HashMap<Integer,String> branchList() {
        return adminAccountModel.branchList();
    }

    public HashMap<Integer,User> showUsersByBranch(int branch, LoginView loginView) {
        if(branch>=1 && branch<=5)
            return adminAccountModel.showUsersByBranch(branch);
        else
            return null;
    }

    public void checkForManage(int input,int userId,LoginView loginView) {
        if(input==0)
            if(adminAccountModel.delete(userId))
                adminAccountView.deletionSuccess(loginView);
            else
                adminAccountView.deletionUnsuccess(loginView);
        else if(input==1)
            adminAccountView.add(loginView);
        else
            adminAccountView.invalidInputForManage(loginView);
    }
    
    public int getId() {
        return adminAccountModel.getId();
    }
    
    public HashMap<Integer, String> brances() {
        return adminAccountModel.branches();
    }
    
    public boolean addData(String firstName, String lastName, Date dob, long mobileNo, Integer gender, int branch, String password, String reEnteredPassword) {
        return adminAccountModel.addData(firstName, lastName, dob, mobileNo, gender, branch, password, reEnteredPassword);
    }
     
    public void checkBranch(int branch,LoginView loginView) {
        if(!adminAccountModel.checkBranch(branch))
            adminAccountView.invalidBranchId(loginView);
    }

    public void approveUser(int id,LoginView loginView) {
        if(adminAccountModel.approveUser(id))
        {
            adminAccountView.approved(loginView);
        }
        else
            adminAccountView.invalidInput(loginView);
    }

    @Override
    public HashMap<Integer, User> userRequest(int branch, LoginView loginView) {
        return adminAccountModel.userRequest(branch,loginView);
    }

}
