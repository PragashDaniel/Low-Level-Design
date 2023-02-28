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
public interface AdminControllerViewCallBack {

    public HashMap<Integer, Team> teamRequest(LoginView loginView);

    public boolean approveTeam(int nextInt);

    public Player[] players(int nextInt);

    public HashMap<Integer, Team> allTeams();

    public boolean deleteTeam(int nextInt);

    public boolean addEvent(String tournamentName, int team1, int team2, String venue, String time, String date, String otherInfo);

    public HashMap<Integer, Match> getEvents();

    public boolean deleteMatch(int matchNo);

    public void updateOtherInfo(int matchNo, String otherInfo);

    public void updateTime(int matchNo, String time);

    public void updateDate(int matchNo, String date);

    public boolean updateOpponentTeam(int nextInt, int matchNo);

    public void updateVenue(int matchNo, String venue);

    public boolean updateTeam(int nextInt, int matchNo);

    public boolean manageResult(int matchId, String result);
    
}
