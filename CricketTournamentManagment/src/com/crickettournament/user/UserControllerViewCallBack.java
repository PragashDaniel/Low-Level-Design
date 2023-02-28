/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crickettournament.user;

import com.crickettournament.dto.Match;
import com.crickettournament.dto.Player;
import com.crickettournament.dto.Team;
import com.crickettournament.login.LoginView;
import java.util.HashMap;

/**
 *
 * @author welcome
 */
interface UserControllerViewCallBack {

    public String getTeamName(int teamId);

    public void teamDetails(LoginView loginView, int teamId);

    public void playerDetails(LoginView loginView, int teamId);

    public void editTeamName(int teamId, String fN, String mN, String lN);

    public void editContNo(int teamId, long mobNo);

    public boolean editPlayerName(int teamId, int playerId, String name, Player[] players);

    public boolean editPlayerAge(int teamId, int playerId, byte age, Player[] players);

    public boolean editPlayerType(int teamId, int playerId, String type, Player[] players);

    public void addNewPlayers(Player[] newPlayers, int teamId);

    public boolean checkPlayerAge(byte age);

    public HashMap<Integer, Team> coPraticipants();

    public HashMap<Integer, Match> getEvents();

    public boolean checkNOP(byte nop, Player[] players);
    
}
