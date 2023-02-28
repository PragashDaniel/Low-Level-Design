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
public class UserController implements UserControllerViewCallBack,UserControllerModelCallBack{

    private UserViewCallBack userView;
    private UserModelCallBack userModel;

    UserController(UserView userView) {
        this.userView = userView;
        this.userModel = new UserModel(this);
    }

    public String getTeamName(int teamId) {
        return userModel.getTeamName(teamId);
    }

    public void teamDetails(LoginView loginView, int teamId) {
        Team teamDetail=userModel.teamDetails(teamId);
        userView.teamDetails(teamDetail,teamId,loginView);
    }

    public void editTeamName(int teamId, String fN, String mN, String lN) {
        userModel.editTeamName(teamId,fN,mN,lN);
    }

    public void editContNo(int teamId, long mobNo) {
        userModel.editContNo(teamId,mobNo);
    }

    public void playerDetails(LoginView loginView, int teamId) {
        Player[] players=userModel.getTeamPlayers(teamId);
        userView.playerDetails(loginView,teamId,players);
    }

    public boolean editPlayerName(int teamId, int playerId,String name,Player[] players) {
        if(playerId>1 && playerId<=players.length)
            return userModel.editPlayerName(teamId,playerId,name);
        return false;
    }

    public boolean editPlayerAge(int teamId, int playerId, byte age,Player[] players) {
        if(playerId>1 && playerId<=players.length)
            return userModel.editPlayerAge(teamId,playerId,age);
        return false;
    }

    public boolean editPlayerType(int teamId, int playerId, String type,Player[] players) {
        if(playerId>1 && playerId<=players.length)
            return userModel.editPlayerType(teamId,playerId,type);
        return false;
    }
    
    public boolean checkNOP(byte nop,Player[] players) {
        return nop+players.length>22;
    }

    public boolean checkPlayerAge(byte age) {
        return age>=18 && age<=35;
    }

    public void addNewPlayers(Player[] newPlayers, int teamId) {
        userModel.addNewPlayers(newPlayers,teamId);
    }

    public HashMap<Integer, Team> coPraticipants() {
        return userModel.coPraticipants();
    }

    public HashMap<Integer, Match> getEvents() {
        return userModel.getEvents();
    }

}
