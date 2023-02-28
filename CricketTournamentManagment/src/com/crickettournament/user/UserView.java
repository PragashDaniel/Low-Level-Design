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
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author welcome
 */
public class UserView implements UserViewCallBack{

    private UserControllerViewCallBack userController;
    private Scanner sc=new Scanner(System.in);
    public UserView() {
        this.userController = new UserController(this);
    }

    public void userHomePage(LoginView loginView,int teamId) {
        System.out.println("*** Welcome "+userController.getTeamName(teamId)+" ***");
        System.out.println("1) Team Details");
        System.out.println("2) Player Details ");
        System.out.println("3) Co-Participants");
        System.out.println("4) Match Details");
        System.out.println("5) Points Table");
        System.out.println("6) Sign Out");
        switch(sc.nextInt())
        {
            case 1:
                userController.teamDetails(loginView,teamId);
                break;
            case 2:
                userController.playerDetails(loginView,teamId);
                break;
            case 3:
               coParticipants(loginView,teamId);
                break;
            case 4:
                matchDetails(loginView,teamId);
                break;
            case 5:
                pointsTable(loginView,teamId);
            case 6:
                loginView.firstPage();
                break;
            default:
                System.out.println("Invalid Input...");
                userHomePage(loginView,teamId);
        }
    }

    public void teamDetails(Team teamDetail, int teamId, LoginView loginView) 
    {
        System.out.println(" *** Team Details *** ");
        System.out.println("Team Id : "+teamDetail.getTeamId());
        System.out.println("Name of the Team : "+teamDetail.getTeamName());
        System.out.println("Contact No : "+teamDetail.getContactNo());
        System.out.println("Status : "+(teamDetail.isStatus()?"Approved":"Not Approved"));
        System.out.println("For Edit, Press 1 ");
        System.out.println("For Back, press 0");
        switch(sc.nextInt())
        {
            case 0:
                backHome(teamId,loginView);
                break;
            case 1:
                editInfo(teamDetail,teamId,loginView);
                break;
            default:
                System.out.println("Invalid Input...");
                userHomePage(loginView,teamId);
        }
    }

    private void backHome(int teamId, LoginView loginView) {
        userHomePage(loginView,teamId);
    }

    private void editInfo(Team teamDetail,int teamId, LoginView loginView) {
        System.out.println("*** Edit Info ***");
        System.out.println("1)Team Name");
        System.out.println("2)Contact Number");
        System.out.println("3)Back");
        System.out.println("Enter an option to continue...");
        switch(sc.nextInt())
        {
            case 1:
                editTeamName(teamDetail,teamId,loginView);
                break;
            case 2:
                editContNo(teamDetail,teamId,loginView);
                break;
            case 3:
                teamDetails(teamDetail,teamId,loginView);
                break;
            default:
                System.out.println("Entered Invalid Option, Try Again...");
                editInfo(teamDetail,teamId,loginView);
        }
    }

    private void editTeamName(Team teamDetail,int teamId,LoginView loginView) {
        System.out.println(" TEAM NAME UPDATION");
        System.out.println("Please, Enter the new team name...");
        System.out.println("First Name : ");
        String fN=sc.next();
        System.out.println("Middle Name : ");
        String mN=sc.next();
        System.out.println("Last Name : ");
        String lN=sc.next();
        userController.editTeamName(teamId,fN,mN,lN);
        System.out.println("Team Name Updated...");
        editInfo(teamDetail,teamId,loginView);
    }

    private void editContNo(Team teamDetail,int teamId,LoginView loginView) {
        System.out.println("CONTACT UPDATION");
        System.out.println("PLease, Enter the new contact number...");
        System.out.println("Enter Here : ");
        long mobNo=sc.nextLong();
        if(String.valueOf(mobNo).length()==10)
            userController.editContNo(teamId,mobNo);
        else
        {   
            System.out.println("Invalid mobile No...");
            editInfo(teamDetail,teamId,loginView);
            return;
        }
        System.out.println("Updation Successfull...");
        editInfo(teamDetail,teamId,loginView);
    }

    public void playerDetails(LoginView loginView, int teamId, Player[] players) {
        System.out.println("*** Your Team Players ***");
        System.out.println("Number Of Players : "+players.length);
        System.out.println("No. |  Name\t     | Age\t| Type\t|  ");
        for(int i=0;i<players.length;i++)
        {
            System.out.print(players[i].getId()+"  |   "+players[i].getName()+""
                    + "  |  "+players[i].getAge()+" |\t"+players[i].getType()+"   |\n");
        }
        System.out.println("For Add new player press 11");
        System.out.println("For Edit Press 1 ");
        System.out.println("For Back Press 0");
        switch(sc.nextInt())
        {
            case 0:
                backHome(teamId,loginView);
                break;
            case 1:
                editPlayerInfo(teamId,loginView,players);
                break;
            case 11:
                addNewPlayers(teamId,loginView,players);
                break;
            default:
                System.out.println("Invalid Input...");
                backHome(teamId,loginView);
        }
    }

    private void editPlayerInfo(int teamId, LoginView loginView,Player[] players) {
        System.out.println("Edit Players Info");
        System.out.println("1)Player Name");
        System.out.println("2)Player Age");
        System.out.println("3)Player Type");
        System.out.println("4)Back");
        System.out.println("Enter an option...");
        switch(sc.nextInt())
        {
            case 1:
                editPlayerName(teamId,loginView,players);
                break;
            case 2:
                editPlayerAge(teamId,loginView,players);
                break;
            case 3:
                editPlayerType(teamId,loginView,players);
                break;
            case 4:
                playerDetails(loginView,teamId,players);
                break;
            default:
                System.out.println("Invalid Input");
                playerDetails(loginView,teamId,players);
        }
    }

    private void editPlayerName(int teamId, LoginView loginView, Player[] players) {
        System.out.println(" PLAYER NAME UPDATION ");
        System.out.println("Enter the Player No :");
        int playerId=sc.nextInt();
        System.out.println("Enter the new Name ");
        String name=sc.next();
        if(userController.editPlayerName(teamId,playerId,name,players))
        {
            System.out.println("Updation Succesfull...");
            editPlayerInfo(teamId,loginView,players);
        }
        else 
        {
            System.out.println("Invalid Player Number...");
            editPlayerInfo(teamId,loginView,players);
        }
    }

    private void editPlayerAge(int teamId, LoginView loginView, Player[] players) {
        System.out.println(" PLAYER AGE UPDATION ");
        System.out.println("Enter the Player No :");
        int playerId=sc.nextInt();
        System.out.println("Enter the new Age : ");
        byte age=sc.nextByte();
        if(userController.editPlayerAge(teamId,playerId,age,players))
        {System.out.println("Updation Success...");editPlayerInfo(teamId,loginView,players);}
        else
        {System.out.println("Invalid Player Id...");editPlayerInfo(teamId,loginView,players);}
    }

    private void editPlayerType(int teamId, LoginView loginView, Player[] players) {
        System.out.println(" PLAYER TYPE UPDATION ");
        System.out.println("Enter the Player No : ");
        int playerId=sc.nextInt();
        System.out.println("Enter the type of the player : ");
        String type=sc.next();
        if(userController.editPlayerType(teamId,playerId,type,players))
        {
            System.out.println("Updation Success...");
            editPlayerInfo(teamId,loginView,players);
        }
        else
        {
            System.out.println("Invalid Player Id...");
            editPlayerInfo(teamId,loginView,players);
        }
    }

    private void addNewPlayers(int teamId, LoginView loginView, Player[] players) {
        System.out.println(" ADD NEW PLAYERS ");
        System.out.println("No. of Players want to add : ");
        byte nop=sc.nextByte();
        if(userController.checkNOP(nop, players)){
            System.out.println("No.Of Players must be in the range(Max-22)");editPlayerInfo(teamId,loginView,players);return;}
        Player[] newPlayers=new Player[players.length+nop];
        System.arraycopy(players, 0, newPlayers, 0, players.length);
        newPlayers=addPlayers(newPlayers,nop,players.length);
        userController.addNewPlayers(newPlayers,teamId);
        System.out.println("New Players added successfully...");
        playerDetails(loginView,teamId,newPlayers);
    }

    Player[] addPlayers(Player players[],byte nop,int id)
    {
        for(int i=id;i<players.length;i++)
        {
            String name;
            byte age;
            String type;   
            System.out.println("Enter the next Player Name : ");
            name=sc.next();
            System.out.println("Enter the player Age : ");
            age=sc.nextByte();
            System.out.println("Enter the Playe Type : ");
            type=sc.next();
            if(userController.checkPlayerAge(age))
            {   
                players[i]=new Player(i+1,name,age,type);
                }
            else{
                System.out.println("Player Age must be greater than 17 and less than 36, Try Again...");
                addPlayers(players,nop,i);
            }
        }
        return players;
    }

    private void coParticipants(LoginView loginView, int teamId) {
        HashMap<Integer,Team> coParticipants=userController.coPraticipants();
        if(coParticipants.get(teamId)!=null)
        {
            if(coParticipants.get(teamId).isStatus())
            {
                System.out.println("*** Co-Practicipants ***");
                System.out.println("S.No |  TEAM NAME ");
                for(Map.Entry<Integer,Team> team:coParticipants.entrySet())
                {
                    if(teamId==team.getValue().getTeamId()) continue;
                    System.out.print(team.getValue().getTeamId()+"       ");
                    System.out.print(team.getValue().getTeamName()+"   \n ");
                }
                System.out.println("For Back press 0");
                System.out.println("For Player details press 1");
                int input=sc.nextInt();
                if(input==0)
                    userHomePage(loginView,teamId);
                else if(input==1)
                {
                    System.out.println("Enter the Co-Team Id : " );
                    int coTeamId=sc.nextInt();
                    coPlayers(loginView,teamId,coTeamId,coParticipants);
                }        
            }
            else
            {
                System.out.println("You are not Approved Yet...,");
                userHomePage(loginView,teamId);
            }
        }
        else {
            System.out.println("No Teams Yet...");
        }
    }

    private void coPlayers(LoginView loginView, int teamId,int coTeamID,HashMap<Integer,Team> coParticipants) {
        String teamName;
        if(coParticipants.get(coTeamID)!=null)
        {
            teamName=coParticipants.get(coTeamID).getTeamName();
            System.out.println("*** Team "+teamName+" ***");
            Player[] players=coParticipants.get(coTeamID).getPlayers();
            System.out.println("S.No |       Name    |  Age  | Type |");
            for(int i=0;i<players.length;i++)
            {
                System.out.print((i+1)+"   "+players[i].getName()+" "+players[i].getAge()+" "+players[i].getType()+"\n");
            }    
            coParticipants(loginView,teamId);
        }
        else
        {
            System.out.println("Invalid Co-Team ID....");
            coParticipants(loginView,teamId);
        }
        
    }

    private void matchDetails(LoginView loginView, int teamId) {
        System.out.println("*** Matches Details ***");
        HashMap<Integer,Match> matches=userController.getEvents();
        if(userController.coPraticipants().get(teamId).isStatus())
        {
            if (matches != null) {
                System.out.println("Match No. |     Team     |  Opponent Team   |  venue  |  Date | Time | other Info ");
                for (Map.Entry<Integer, Match> event : matches.entrySet()) {
                    System.out.print(event.getKey() + "   ");
                    System.out.println(event.getValue().getTeam1() + "   ");
                    System.out.println(event.getValue().getTeam2() + "   ");
                    System.out.println(event.getValue().getVenue() + "   ");
                    System.out.println(event.getValue().getDate() + "   ");
                    System.out.println(event.getValue().getTime() + "   ");
                    System.out.println(event.getValue().getOtherInfo() + "   \n");
                }
                userHomePage(loginView,teamId);
             }
             else
            {
                System.out.println("No Matches yet...");
                userHomePage(loginView,teamId);
            }
        }   
        else
        {   
            System.out.println("You are not yet selected...");
            userHomePage(loginView,teamId);
        }
    }

    private void pointsTable(LoginView loginView, int teamId) {
        System.out.println("*** Points Table ***");
        HashMap<Integer,Team> teams=userController.coPraticipants();
        if(teams.get(teamId).isStatus())
        {
        System.out.println("S.No |      TEAM NAME   |  Points   | ");
        for(Map.Entry<Integer,Team> team:teams.entrySet())
        {
            System.out.print(team.getValue().getTeamId()+"       ");
            System.out.print(team.getValue().getTeamName()+"    ");
            System.out.println(team.getValue().getPoint()+"  \n");
        }
        userHomePage(loginView,teamId);
        }
        else
        {System.out.println("You are not approved... yet");userHomePage(loginView,teamId);}
    }
   

}
