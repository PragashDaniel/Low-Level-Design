/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crickettournament.admin;

import com.crickettournament.dto.Match;
import com.crickettournament.dto.Player;
import com.crickettournament.dto.Team;
import com.crickettournament.login.LoginView;
import java.util.HashMap;

/**
 *
 * @author welcome
 */
public class AdminController implements AdminControllerViewCallBack,AdminControllerModelCallBack{

    private AdminViewCallBack adminView;
    private AdminModelCallBack adminModel;

    AdminController(AdminView adminView) {
        this.adminView = adminView;
        this.adminModel = new AdminModel(this);
    }

    public HashMap<Integer, Team> teamRequest(LoginView loginView) {
        return adminModel.teamRequest();
    }

    public boolean approveTeam(int teamId) {
        return adminModel.approveTeam(teamId);
    }

    public Player[] players(int teamId) {
        return adminModel.players(teamId);
    }

   public HashMap<Integer, Team> allTeams() {
        return adminModel.allTeams();
    }

    public boolean deleteTeam(int teamId) {
        return adminModel.deleteTeam(teamId);
    }

   public boolean addEvent(String tournamentName, int team1, int team2, String venue, String time, String date, String otherInfo) {
        if (team1 != team2) {
            return adminModel.addEvent(tournamentName, team1, team2, venue, time, date, otherInfo);
        }
        return false;
    }

    public HashMap<Integer, Match> getEvents() {
        return adminModel.getEvents();
    }

    public boolean deleteMatch(int matchNo) {
        return adminModel.deleteMatch(matchNo);
    }

    public void updateOtherInfo(int matchNo, String otherInfo) {
        adminModel.updateOtherInfo(matchNo, otherInfo);
    }

    public void updateDate(int matchNo, String date) {
        adminModel.updateDate(matchNo, date);
    }

    public void updateTime(int matchNo, String time) {
        adminModel.updateTime(matchNo, time);
    }

    public void updateVenue(int matchNo, String venue) {
        adminModel.updateVenue(matchNo, venue);
    }

    public boolean updateOpponentTeam(int teamId, int matchNo) {
        return adminModel.updateOpponentTeam(teamId, matchNo);
    }

    public boolean updateTeam(int teamId, int matchNo) {
        return adminModel.updateTeam(teamId, matchNo);
    }

    public boolean manageResult(int matchId, String result) {
        return adminModel.manageResult(matchId, result);
    }

}
