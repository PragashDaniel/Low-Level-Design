/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crickettournament.repository;

import com.crickettournament.dto.Match;
import com.crickettournament.dto.Player;
import com.crickettournament.dto.Team;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author welcome
 */
public class CricketRepository {

    private HashMap<Integer, Team> teams = new HashMap<>();
    private HashMap<Integer, String> admin = new HashMap<>();
    private HashMap<Integer,Match> matches=new HashMap<>();
    public static CricketRepository cricketRepoInstance;
    private int teamId,matchNo;

    private CricketRepository() {}

    public static CricketRepository getInstance() {
        if (cricketRepoInstance == null) {
            cricketRepoInstance = new CricketRepository();
            cricketRepoInstance.initialSetup();
        }
        return cricketRepoInstance;
    }

    public void addPlayers(String teamName, long contNo, byte nop, Player[] players, String password) {
        teams.put(++teamId, new Team(teamId, teamName, contNo, nop, players, password, false,0));
    }

    public boolean checkUserCredentials(int userId, String password) {
        return teams.containsKey(userId) && teams.get(userId).getPassword().equals(password);
    }

    public int getId() {
        return teamId;
    }

    public String getTeamName(int teamId) {
        return teams.get(teamId).getTeamName();
    }

    public Team getTeamDetails(int teamId) {
        return teams.get(teamId);
    }

    public void editTeamName(int teamId, String name) {
        teams.get(teamId).setTeamName(name);
    }

    public void editContNo(int teamId, long mobNo) {
        teams.get(teamId).setContactNo(mobNo);
    }

    public Player[] getTeamPlayers(int teamId) {
        return teams.get(teamId).getPlayers();
    }

    public boolean editPlayerName(int teamId, int playerId, String name) {
        teams.get(teamId).getPlayers()[playerId - 1].setName(name);
        return true;
    }

    public boolean editPlayerAge(int teamId, int playerId, byte age) {
        teams.get(teamId).getPlayers()[playerId - 1].setAge(age);
        return true;
    }

    public boolean editPlayerType(int teamId, int playerId, String type) {
        teams.get(teamId).getPlayers()[playerId - 1].setType(type);
        return true;
    }

    public boolean addNewPlayer(Player[] newPlayers, int teamId) {
        teams.get(teamId).setPlayers(newPlayers);
        return true;
    }

    public HashMap<Integer, Team> getAllTeams() {
        return teams;
    }

    private void initialSetup() {
        admin.put(1001, "admin");
    }

    public boolean checkAdminCredentials(int adminId, String adminPassword) {
        return admin.containsKey(adminId) && admin.get(adminId).equals(adminPassword);
    }

    public boolean approveTeam(int teamId) {
        if(teams.containsKey(teamId))
        {
            teams.get(teamId).setStatus(true);
            return true;
        }   
        return false;
    }

    public Player[] players(int teamId) {
        if(teams.containsKey(teamId))
            return teams.get(teamId).getPlayers();
        return null;
    }

    public boolean deleteTeam(int teamId) {
        if(teams.containsKey(teamId))
        {
            teams.remove(teamId);
            return true;
        }
        return false;
    }

    public boolean addEvent(String tournamentName, int team1, int team2, String venue, String time, String date, String otherInfo) {
        if(teams.containsKey(team1) && teams.containsKey(team2))
        {
            matches.put(++matchNo,new Match(matchNo,tournamentName,teams.get(team1).getTeamName(),
                        teams.get(team2).getTeamName(),venue,time,date,otherInfo,""));
            return true;
        }
        return false;
    }

    public HashMap<Integer, Match> getEvents() {
        return matches;
    }

    public boolean deleteMatch(int matchno) {
        if(matches.containsKey(matchno))
        {
            matches.remove(matchno);
            return true;
        }
        return false;
    }

    public void updateOtherInfo(int matchNo, String otherInfo) {
        this.matches.get(matchNo).setOtherInfo(otherInfo);
    }

    
    public void updateTime(int matchNo, String time) {
        this.matches.get(matchNo).setTime(time);
    }
    
    public void updateDate(int matchNo, String date) {
        this.matches.get(matchNo).setDate(date);
    }
    
    public void updateVenue(int matchNo, String venue) {
        this.matches.get(matchNo).setVenue(venue);
    }

    public boolean updateOpponentTeam(int teamId,int matchNo) {
        if(teams.containsKey(teamId))
        {
            matches.get(matchNo).setTeam2(teams.get(teamId).getTeamName());
            teams.get(teamId).setPoint(teams.get(teamId).getPoint()+2);
            return true;
        }
        return false;
    }

    public boolean updateTeam(int teamId,int matchNo) {
        if(teams.containsKey(teamId))
        {
            matches.get(matchNo).setTeam1(teams.get(teamId).getTeamName());
            teams.get(teamId).setPoint(teams.get(teamId).getPoint()+2);
            return true;
        }
        return false;
    }

    public boolean manageResult(int matchId, String result) {
        if(matches.containsKey(matchId))
        {
            matches.get(matchId).setWinner(result);
            return true;
        }
        return false;
    }
    

}
