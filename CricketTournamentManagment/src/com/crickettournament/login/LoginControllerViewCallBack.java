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
interface LoginControllerViewCallBack {

    public boolean checkAdminCredentials(int adminId, String adminPassword);

    public boolean checkUserCredentials(int userId, String password);

    public boolean checkNOP(byte nop);

    public void addPlayers(String teamName, long contNo, byte nop, Player[] players, String password, String reEnteredPassword);

    public boolean checkPlayerAge(byte age);
    
}
