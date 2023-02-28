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
public class Team {

    private int teamId;
    private String teamName;
    private long contactNo;
    private byte nop;
    private Player players[];
    private String password;
    private int point;
    private boolean status;

    public Team(int teamId, String teamName, long contNo, byte nop, Player[] players, String password, boolean status, int point) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.contactNo = contNo;
        this.nop = nop;
        this.players = players;
        this.password = password;
        this.status = status;
        this.point = point;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public long getContactNo() {
        return contactNo;
    }

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }

    public byte getNop() {
        return nop;
    }

    public void setNop(byte nop) {
        this.nop = nop;
    }

    public Player[] getPlayers() {
        return players;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

}
