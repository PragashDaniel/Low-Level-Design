/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crickettournament.login;

import com.crickettournament.dto.Player;

/**
 *
 * @author welcome
 */
public class LoginController implements LoginControllerModelCallBack,LoginControllerViewCallBack{
    private LoginModelCallBack loginModel;
    private LoginViewCallBack loginView;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        loginModel = new LoginModel(this);
    }

    public boolean checkPlayerAge(byte age) {
        return age>=18 && age<=35;
    }

    public void addPlayers(String teamName, long contNo, byte nop, Player[] players, String password, String reEnteredPassword) {
        if(password.equals(reEnteredPassword) && String.valueOf(contNo).length()==10)
        {loginModel.addPlayers(teamName,contNo,nop,players,password);
         loginView.signUpSuccess(loginModel.getId());}
        else
            loginView.inputMismatch();
    }

    public boolean checkUserCredentials(int userId, String password) {
        return loginModel.checkUserCredentials(userId,password);
    }

    public boolean checkNOP(byte nop) {
        return nop>22;
    }

    public boolean checkAdminCredentials(int adminId, String adminPassword) {
        return loginModel.checkAdminCredentials(adminId,adminPassword);
    }  

 
    
}
