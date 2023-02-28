/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.useraccount;

import com.bank.dto.User;
import com.bank.login.LoginView;
import com.bank.repository.BankRepository;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author welcome
 */
public class UserAccountModel implements UserAccountModelCallBack {

    private UserAccountControllerModelCallBack userAccountController;

    public UserAccountModel(UserAccountController userAccountController) {
        this.userAccountController = userAccountController;
    }

    public User getDetail(int id) {
        return BankRepository.getInstance().getDetail(id);
    }

    public HashMap<Integer, String> branches() {
        return BankRepository.getInstance().branches();
    }

    public void editUserName(String firstName, String lastName, int id) {
        BankRepository.getInstance().editUserName(firstName, lastName, id);
    }

    public void editDOB(Date dob, int id) {
        BankRepository.getInstance().editDOB(dob, id);
    }

    public void editMobileNo(long mobileNumber, int id) {
        BankRepository.getInstance().editMobileNo(mobileNumber, id);
    }

    public void editBranch(Integer brance, int id) {
        BankRepository.getInstance().editBranch(brance, id);
    }

    public void editGender(Integer gender, int id) {
        BankRepository.getInstance().editGender(gender, id);
    }

    public boolean checkAccountDetails(int id) {
        return BankRepository.getInstance().checkStatus(id);
    }

    public boolean deposit(int id, long amount) {
        return BankRepository.getInstance().deposit(id, amount);
    }

    public boolean withdraw(int id, long amount) {
        long balance = BankRepository.getInstance().getBalance(id) - amount;
        if (balance > 500) {
            BankRepository.getInstance().setAmount(id, balance);
            return true;
        } else {
            return false;
        }
    }

    public long accountBalance(int id) {
        return BankRepository.getInstance().getBalance(id);
    }

    @Override
    public boolean moneyTransfer(int id, LoginView loginView, int receiverId, long amount) {
        
        BankRepository bankRepo=BankRepository.getInstance();
        if(bankRepo.checkId(id,receiverId,amount))
        {   
            if((bankRepo.getBalance(id)-amount) > 500)
            {
                bankRepo.setAmount(id, bankRepo.getBalance(id)-amount);
                bankRepo.deposit(receiverId, bankRepo.getBalance(receiverId)+amount);
                return true;
            }
        }
        return false;
    }

}
