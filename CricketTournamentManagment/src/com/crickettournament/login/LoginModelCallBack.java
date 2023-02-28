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
interface LoginModelCallBack {

    public void addPlayers(String teamName, long contNo, byte nop, Player[] players, String password);

    public boolean checkUserCredentials(int userId, String password);
    
    public int getId();
    
    public boolean checkAdminCredentials(int adminId, String adminPassword);
    
}
