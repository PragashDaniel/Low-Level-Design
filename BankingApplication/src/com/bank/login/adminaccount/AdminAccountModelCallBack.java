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
public interface AdminAccountModelCallBack {

    public long totalBankBalance();

    public HashMap<Integer, String> branchList();

    public HashMap<Integer, User> showUsersByBranch(int branch);

    public boolean delete(int userId);

    public int getId();

    public HashMap<Integer, String> branches();

    public boolean addData(String firstName, String lastName, Date dob, long mobileNo, Integer gender, int branch, String password, String reEnteredPassword);

    public boolean checkBranch(int branch);

    public boolean approveUser(int id);

    public HashMap<Integer, User> userRequest(int branch, LoginView loginView);
    
}
