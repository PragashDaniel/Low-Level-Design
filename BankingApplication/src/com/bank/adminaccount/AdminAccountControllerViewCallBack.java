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
public interface AdminAccountControllerViewCallBack {

    public void firstPageSeletion(int nextInt, LoginView loginView);

    public long totalBankBalance();

    public HashMap<Integer, String> branchList();

    public HashMap<Integer, User> showUsersByBranch(int branch, LoginView loginView);

    public void checkForManage(int input, int userId, LoginView loginView);

    public HashMap<Integer, String> brances();

    public void checkBranch(int branch, LoginView loginView);

    public boolean addData(String firstName, String lastName, Date dob, long mobileNo, Integer gender, int branch, String password, String reEnteredPassword);

    public void approveUser(int id, LoginView loginView);

    public int getId();

    public HashMap<Integer, User> userRequest(int branch, LoginView loginView);
    
}
