/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crickettournament.admin;

import com.crickettournament.dto.Match;
import com.crickettournament.dto.Player;
import com.crickettournament.dto.Team;
import com.crickettournament.repository.CricketRepository;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author welcome
 */
public class AdminModel implements AdminModelCallBack{

    private AdminControllerModelCallBack adminController;
    private static CricketRepository cricketRepo=CricketRepository.getInstance();
    AdminModel(AdminController adminController) {
        this.adminController = adminController;
    }

    public HashMap<Integer, Team> teamRequest() {
        HashMap<Integer, Team> teams= cricketRepo.getAllTeams();
        HashMap<Integer, Team> requestedTeams=new HashMap<>();
        for(Map.Entry<Integer,Team> t:teams.entrySet())
        {
            if(!t.getValue().isStatus())
                requestedTeams.put(t.getKey(),t.getValue());
        }
        return requestedTeams;
    }

    public boolean approveTeam(int teamId) {
        return cricketRepo.approveTeam(teamId);
    }

    public Player[] players(int teamId) {
        return cricketRepo.players(teamId);
    }

    public HashMap<Integer, Team> allTeams() {
        HashMap<Integer, Team> teams= cricketRepo.getAllTeams();
        HashMap<Integer, Team> allTeams=new HashMap<>();
        for(Map.Entry<Integer,Team> t:teams.entrySet())
        {
            if(t.getValue().isStatus())
                allTeams.put(t.getKey(),t.getValue());
        }
        return allTeams;
    }

    public boolean deleteTeam(int teamId) {
        return cricketRepo.deleteTeam(teamId);
    }

    public boolean addEvent(String tournamentName, int team1, int team2, String venue, String time, String date, String otherInfo) {
        return cricketRepo.addEvent(tournamentName,team1,team2,venue,time,date,otherInfo);
    }

    public HashMap<Integer, Match> getEvents() {
        return cricketRepo.getEvents();
    }

    public boolean deleteMatch(int matchNo) {
        return cricketRepo.deleteMatch(matchNo);
    }

    public void updateOtherInfo(int matchNo, String otherInfo) {
        cricketRepo.updateOtherInfo(matchNo,otherInfo);
    }

    public void updateDate(int matchNo, String date) {
        cricketRepo.updateDate(matchNo,date);
    }
    
    public void updateTime(int matchNo, String time) {
        cricketRepo.updateTime(matchNo,time);
    }
    
    public void updateVenue(int matchNo, String venue) {
        cricketRepo.updateVenue(matchNo,venue);
    }

    public boolean updateOpponentTeam(int teamId,int matchNo) {
        return cricketRepo.updateOpponentTeam(teamId,matchNo);
    }

    public boolean updateTeam(int teamId,int matchNo) {
       return cricketRepo.updateTeam(teamId,matchNo);
    }

    public boolean manageResult(int matchId, String result) {
        return cricketRepo.manageResult(matchId,result);
    }
    
}
