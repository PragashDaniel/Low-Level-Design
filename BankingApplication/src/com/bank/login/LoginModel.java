/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.login;

import com.bank.dto.User;
import com.bank.repository.BankRepository;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author welcome
 */
public class LoginModel implements LoginModelCallBack{

    LoginController loginController;

    public LoginModel(LoginController loginController) {
        this.loginController = loginController;
    }

    public void login(int input) {
        if (input == 1) {
            loginController.adminLogin();
        } else if (input == 2) {
            loginController.user();
        } else if (input == 3) {
            loginController.exit();
        } else {
            loginController.invalidInput();
        }
    }

    public void check(int input) {
        if (input == 1) {
            loginController.userSignIn();
        } else if (input == 2) {
            loginController.userSignUp();
        } else if (input == 3) {
            loginController.back();
        } else {
            loginController.invalidInput();
        }
    }

    public HashMap<Integer, String> branches() {
        return BankRepository.getInstance().branches();
    }

    

    public boolean checkUserCredentials(Integer userId, String userPassword) {
        HashMap<Integer, User> registeredUser = BankRepository.getInstance().registeredUser();
        return (registeredUser.containsKey(userId) && registeredUser.get(userId).getPassword().equals(userPassword));
    }

    public int getId() {
        return BankRepository.getInstance().getId();
    }

    public boolean checkBranch(int branch) {
        return BankRepository.getInstance().checkBranch(branch);
    }

    public boolean checkAdminCredentials(int adminId, String adminPassword) {
        return BankRepository.getInstance().containsAdminId(adminId) &&
               BankRepository.getInstance().containsAdminPassword(adminId,adminPassword);           
    }

    @Override
    public boolean addData(String firstName, String lastName, Date dob, long mobileNo, Integer gender, int branch, String password, String reEnteredPassword) {
        if (firstName != null && dob != null  && password != null) {
            if (password.equals(reEnteredPassword)) {
                BankRepository.getInstance().addData(firstName, lastName, dob, mobileNo, gender, branch, password, reEnteredPassword);
                return true;
            } else {
                loginController.passwordMismatch();
                return false;
            }
        }
        loginController.unableToAdd();
        return false;
    }
}
