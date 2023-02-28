/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crickettournament.login;

import com.crickettournament.dto.Player;
import com.crickettournament.repository.CricketRepository;

/**
 *
 * @author welcome
 */
public class LoginModel implements LoginModelCallBack {
    LoginControllerModelCallBack loginController;

    public LoginModel(LoginController loginController) {
        this.loginController = loginController;
    }

    public void addPlayers(String teamName, long contNo, byte nop, Player[] players, String password) {
        CricketRepository.getInstance().addPlayers(teamName,contNo,nop,players,password);
    }

    public boolean checkUserCredentials(int userId, String password) {
         return CricketRepository.getInstance().checkUserCredentials(userId,password);
    }

    public int getId() {
        return CricketRepository.getInstance().getId();
    }

    public boolean checkAdminCredentials(int adminId, String adminPassword) {
        return CricketRepository.getInstance().checkAdminCredentials(adminId,adminPassword);
    }
}
