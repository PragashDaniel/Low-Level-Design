/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crickettournament.dto;

/**
 *
 * @author welcome
 */
public class Match {

    private String tournament;
    private String team1;
    private String team2;
    private String Venue;
    private String date;
    private String time;
    private String otherInfo;
    private String winner;

    public Match(int matchNo, String tournamentName, String team1, String team2, 
                String venue, String time, String date, String otherInfo,String winner) {
        this.tournament = tournamentName;
        this.team1 = team1;
        this.team2 = team2;
        this.Venue = venue;
        this.time = time;
        this.date = date;
        this.otherInfo = otherInfo;
        this.winner=winner;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    

    public String getVenue() {
        return Venue;
    }

    public void setVenue(String Venue) {
        this.Venue = Venue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

}
