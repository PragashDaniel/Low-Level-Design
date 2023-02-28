/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crickettournament.admin;

import com.crickettournament.dto.Match;
import com.crickettournament.dto.Player;
import com.crickettournament.dto.Team;
import java.util.HashMap;

/**
 *
 * @author welcome
 */
public interface AdminModelCallBack {

    public HashMap<Integer, Team> teamRequest();

    public boolean approveTeam(int teamId);

    public Player[] players(int teamId);

    public HashMap<Integer, Team> allTeams();

    public boolean deleteTeam(int teamId);

    public boolean addEvent(String tournamentName, int team1, int team2, String venue, String time, String date, String otherInfo);

    public HashMap<Integer, Match> getEvents();

    public boolean deleteMatch(int matchNo);

    public boolean manageResult(int matchId, String result);

    public boolean updateTeam(int teamId, int matchNo);

    public boolean updateOpponentTeam(int teamId, int matchNo);

    public void updateVenue(int matchNo, String venue);

    public void updateTime(int matchNo, String time);

    public void updateDate(int matchNo, String date);

    public void updateOtherInfo(int matchNo, String otherInfo);
    
}
