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

/**
 *
 * @author welcome
 */
public interface UserAccountModelCallBack {

    public boolean checkAccountDetails(int id);

    public User getDetail(int id);

    public HashMap<Integer, String> branches();

    public void editUserName(String firstName, String lastName, int id);

    public void editDOB(Date dob, int id);

    public void editMobileNo(long mobileNumber, int id);

    public void editBranch(Integer branch, int id);

    public void editGender(Integer gender, int id);

    public boolean deposit(int id, long amount);

    public boolean withdraw(int id, long amount);

    public long accountBalance(int id);

    public boolean moneyTransfer(int id, LoginView loginView, int receiverId, long amount);
    
}
