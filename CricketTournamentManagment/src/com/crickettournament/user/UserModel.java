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
import com.crickettournament.repository.CricketRepository;
import java.util.HashMap;

/**
 *
 * @author welcome
 */
public class UserModel implements UserModelCallBack{

    private UserControllerModelCallBack userController;
    private static  CricketRepository cricketRepo=CricketRepository.cricketRepoInstance;
    UserModel(UserController userController) {
        this.userController=userController;
    }

    public String getTeamName(int teamId) {
        return cricketRepo.getTeamName(teamId);
    }

    public Team teamDetails(int teamId) {
       return cricketRepo.getTeamDetails(teamId);
    }

   public  void editTeamName(int teamId, String fN, String mN, String lN) {
        String name=fN+" "+mN+" "+lN;
        cricketRepo.editTeamName(teamId,name);
    }

    public void editContNo(int teamId, long mobNo) {
        cricketRepo.editContNo(teamId,mobNo);
    }

    public Player[] getTeamPlayers(int teamId) {
        return cricketRepo.getTeamPlayers(teamId);
    }

   public  boolean editPlayerName(int teamId, int playerId,String name) {
        return cricketRepo.editPlayerName(teamId,playerId,name);
    }

    public boolean editPlayerAge(int teamId, int playerId, byte age) {
        return cricketRepo.editPlayerAge(teamId,playerId,age);
    }

    public boolean editPlayerType(int teamId, int playerId, String type) {
        return cricketRepo.editPlayerType(teamId,playerId,type);
    }

    public boolean addNewPlayers(Player[] newPlayers, int teamId) {
        return cricketRepo.addNewPlayer(newPlayers,teamId);
    }

    public HashMap<Integer, Team> coPraticipants() {
         return cricketRepo.getAllTeams();
    }

   public  HashMap<Integer, Match> getEvents() {
        return cricketRepo.getEvents();
    }

   

}
