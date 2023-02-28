/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalmanagement.login;

import com.hospitalmanagament.hospitalrepository.HospitalRepository;

/**
 *
 * @author welcome
 */
public class LoginModel implements LoginModelCallBack {
    LoginController loginController;

    public LoginModel(LoginController loginController) {
        this.loginController = loginController;
    }
    
    public boolean checkAdminCredentials(int adminId, String password) {
         return HospitalRepository.getInstance().checkAdminCredentials(adminId,password);
    }
}
