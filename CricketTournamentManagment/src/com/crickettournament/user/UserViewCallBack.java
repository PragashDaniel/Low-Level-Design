/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crickettournament.user;

import com.crickettournament.dto.Player;
import com.crickettournament.dto.Team;
import com.crickettournament.login.LoginView;

/**
 *
 * @author welcome
 */
interface UserViewCallBack {

    public void teamDetails(Team teamDetail, int teamId, LoginView loginView);

    public void playerDetails(LoginView loginView, int teamId, Player[] players);

    
}
