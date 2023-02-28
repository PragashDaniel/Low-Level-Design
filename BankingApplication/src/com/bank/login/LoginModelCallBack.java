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
interface LoginModelCallBack {

    public void login(int input);

    public void check(int input);

    public HashMap<Integer, String> branches();

    public boolean checkUserCredentials(Integer userId, String userPassword);

    public int getId();

    public boolean checkBranch(int branch);

    public boolean checkAdminCredentials(int adminId, String adminPassword);

    public boolean addData(String firstName, String lastName, Date dob, long mobileNo, Integer gender, int branch, String password, String reEnteredPassword);
    
}
