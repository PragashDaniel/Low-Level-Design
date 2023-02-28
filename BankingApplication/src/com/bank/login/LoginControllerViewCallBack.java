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
interface LoginControllerViewCallBack {

    public void login(int input);

    public boolean checkAdminCredentials(int adminId, String adminPassword);

    public void check(int input);

    public boolean checkUserCredentials(Integer userId, String userPassword);

    public HashMap<Integer,String> brances();

    public void checkBranch(int branch);

    public boolean addData(String firstName, String lastName, Date dob, long mobileNo, Integer gender, int branch, String password, String reEnteredPassword);

    public int getId();
    
}
