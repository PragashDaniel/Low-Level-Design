/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.login.adminaccount;

import com.bank.dto.User;
import com.bank.login.LoginView;
import com.bank.repository.BankRepository;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author welcome
 */
public class AdminAccountModel implements AdminAccountModelCallBack{

    private AdminAccountControllerModelCallBack adminAccountController;

    AdminAccountModel(AdminAccountController adminAccountController) {
        this.adminAccountController = adminAccountController;
    }

    public long totalBankBalance() {
        HashMap<Integer, Long> totalBankBalanceList = BankRepository.getInstance().getTotalBankBalanceList();
        long totalBankBalance = 0;
        for (int i = 1; i <= totalBankBalanceList.size(); i++) {
            totalBankBalance += totalBankBalanceList.get(i);
        }
        return totalBankBalance;
    }

    public HashMap<Integer, String> branchList() {
        return BankRepository.getInstance().branches();
    }

    public HashMap<Integer, User> showUsersByBranch(int branch) {
        HashMap<Integer,String> branches=BankRepository.getInstance().branches();
        HashMap<Integer, User> usersList = BankRepository.getInstance().getUsers();
        HashMap<Integer, User> usersByBranch = new HashMap<>();
        for(Map.Entry<Integer,User> byBranch:usersList.entrySet())
        {
            if(branches.get(branch).equals(byBranch.getValue().getBranch()))
            {
                if(byBranch.getValue().getStatus())
                    usersByBranch.put(byBranch.getKey(),byBranch.getValue());
            }
        }
        return usersByBranch;
    }

    public boolean delete(int userId)
    {
        return BankRepository.getInstance().deleteUser(userId);
    }

    public int getId() {
        return BankRepository.getInstance().getId();
    }

    public HashMap<Integer, String> branches() {
        return BankRepository.getInstance().branches();
    }

    public boolean addData(String firstName, String lastName, Date dob, long mobileNo, Integer gender, int branch, String password, String reEnteredPassword) {
        if (firstName != null && dob != null && mobileNo != 0 && password != null) {
            if (password.equals(reEnteredPassword)==true) {
                BankRepository.getInstance().addData(firstName, lastName, dob, mobileNo, gender, branch, password, reEnteredPassword);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean checkBranch(int branch) {
        return BankRepository.getInstance().checkBranch(branch);
    }

    public boolean approveUser(int id) 
    {
        return BankRepository.getInstance().approveUser(id);
    }

    @Override
    public HashMap<Integer, User> userRequest(int branch, LoginView loginView) {
        HashMap<Integer, User> userRequest=new HashMap<>();
        HashMap<Integer, User> users=BankRepository.getInstance().getUsers();
        for(Map.Entry<Integer,User> user:users.entrySet())
        {
            if(user.getValue().getStatus()==false)
            {
                userRequest.put(user.getKey(), user.getValue());
            }
        }
        return userRequest;
    }

}
