/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crickettournament.user;

import com.crickettournament.dto.Match;
import com.crickettournament.dto.Player;
import com.crickettournament.dto.Team;
import java.util.HashMap;

/**
 *
 * @author welcome
 */
interface UserModelCallBack {

    public String getTeamName(int teamId);

    public Team teamDetails(int teamId);

    public void editTeamName(int teamId, String fN, String mN, String lN);

    public void editContNo(int teamId, long mobNo);

    public Player[] getTeamPlayers(int teamId);

    public boolean editPlayerName(int teamId, int playerId, String name);

    public boolean editPlayerAge(int teamId, int playerId, byte age);

    public boolean editPlayerType(int teamId, int playerId, String type);

    public boolean addNewPlayers(Player[] newPlayers, int teamId);

    public HashMap<Integer, Team> coPraticipants();

    public HashMap<Integer, Match> getEvents();

    
}
