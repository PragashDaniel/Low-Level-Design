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
public interface UserAccountControllerViewCallBack {

    public long accountBalance(int id);

    public void withdraw(int id, long amount, LoginView loginView);

    public void deposit(int id, long amount, LoginView loginView);

    public void accountDetailSelection(int nextInt, int id, LoginView loginView);

    public void editGender(Integer gender, int id);

    public void editBranch(Integer brance, int id, LoginView loginView);

    public HashMap<Integer, String> branches();

    public void editMobileNo(long mobileNumber, int id);

    public void editDOB(Date dob, int id);

    public void editUserName(String firstName, String lastName, int id);

    public void editInfo(int nextInt, int id, LoginView loginView);

    public void next(int input, int id, LoginView loginView);

    public void selectedModule(int input, int id, LoginView loginView);

    public User getDetail(int id);

    public void moneyTransfer(int id, LoginView loginView, int receiverId, long amount);

}
