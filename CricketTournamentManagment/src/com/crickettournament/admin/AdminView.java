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
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author welcome
 */
public class AdminView implements AdminViewCallBack
{

    private AdminControllerViewCallBack adminController;
    private Scanner sc = new Scanner(System.in);

    public AdminView() {
        adminController = new AdminController(this);
    }

    public void adminHomePage(LoginView loginView) {
        System.out.println("*** Welcome Admin ***");
        System.out.println("1)Team Request");
        System.out.println("2)Show Teams");
        System.out.println("3)Create Match");
        System.out.println("4)Manage Match details");
        System.out.println("5)Sign Out");
        System.out.println("Please, Enter the option...");
        switch (sc.nextInt()) {
            case 1:
                teamRequest(loginView);
                break;
            case 2:
                allTeams(loginView);
                break;
            case 3:
                createMatch(loginView);
                break;
            case 4:
                manageEvents(loginView);
                break;
            case 5:
                signOut(loginView);
                break;
            default:
                System.out.println("Invalid Input...");
                adminHomePage(loginView);
        }
    }

    private void signOut(LoginView loginView) {
        System.out.println("Signed Out...");
        loginView.firstPage();
    }

    private void teamRequest(LoginView loginView) {
        System.out.println("*** Team Request ***");
        HashMap<Integer, Team> teamRequest = adminController.teamRequest(loginView);
        System.out.println("Team Id |       Team Name       | Contact No    |   Status    |");
        for (Map.Entry<Integer, Team> team : teamRequest.entrySet()) {
            System.out.print(team.getValue().getTeamId() + " ");
            System.out.print(team.getValue().getTeamName() + " ");
            System.out.print(team.getValue().getContactNo() + " ");
            System.out.print(team.getValue().isStatus() ? "Approved" : "Not Approved" + "\n");
        }
        System.out.println("Press 1 for Approve");
        System.out.println("Press 0 for Back");
        System.out.println("Press 2 for Players List");
        int input = sc.nextInt();
        if (input == 1) {
            System.out.println("Enter the Team Id : ");
            if (adminController.approveTeam(sc.nextInt())) {
                System.out.println("Team Approved... ");
                teamRequest(loginView);
            } else {
                System.out.println("InValid Team Id....");
                teamRequest(loginView);
            }
        } else if (input == 0) {
            adminHomePage(loginView);
        } else if (input == 2) {
            System.out.println("Enter the Team Id");
            Player[] players = adminController.players(sc.nextInt());
            if (players == null) {
                System.out.println("Entered Invalid Team Id...");
                teamRequest(loginView);
            } else {
                players(players, loginView);
                System.out.println("Press 0 for Back...");
                int inp = sc.nextInt();
                if (inp == 0) {
                    teamRequest(loginView);
                } else {
                    System.out.println("Invalid Input...");
                    teamRequest(loginView);
                }
            }

        } else {
            System.out.println("Invalid Input...");
            teamRequest(loginView);
        }
    }

    private void allTeams(LoginView loginView) {
        System.out.println("*** Teams ***");
        HashMap<Integer, Team> teamRequest = adminController.allTeams();
        System.out.println("Team Id |       Team Name       | Contact No  |  Points  ");
        for (Map.Entry<Integer, Team> team : teamRequest.entrySet()) {
            System.out.print(team.getValue().getTeamId() + " ");
            System.out.print(team.getValue().getTeamName() + " ");
            System.out.print(team.getValue().getContactNo() + " ");
            System.out.println(team.getValue().getPoint()+"  \n");
        }
        System.out.println("Press 0 for Back");
        System.out.println("Press 1 for Players List");
        System.out.println("Press 2 for Deletion");
        switch (sc.nextInt()) {
            case 0:
                adminHomePage(loginView);
                break;
            case 1:
                System.out.println("Enter the Team Id");
                Player[] players = adminController.players(sc.nextInt());
                if (players == null) {
                    System.out.println("Entered Invalid Team Id...");
                    allTeams(loginView);
                } else {
                    players(players, loginView);
                    System.out.println("Press 0 for Back...");
                    int inp = sc.nextInt();
                    if (inp == 0) {
                        allTeams(loginView);
                    } else {
                        System.out.println("Invalid Input...");
                        allTeams(loginView);
                    }
                }
                break;
            case 2:
                System.out.println("Enter the Team Id : ");
                if (adminController.deleteTeam(sc.nextInt())) {
                    System.out.println("Deletion Success...");
                    allTeams(loginView);
                } else {
                    System.out.println("Invalid Team Id...");
                    allTeams(loginView);
                }
                break;
            default:
                System.out.println("invalid Input..");
                allTeams(loginView);
        }
    }

    private void players(Player[] players, LoginView loginView) {
        System.out.println("***  PLAYERS INFORMATION ***");
        System.out.println("S.NO |        NAME      |    AGE   |    TYPE   ");
        for (Player player : players) {
            System.out.print(player.getId() + "   ");
            System.out.print(player.getName() + "   ");
            System.out.print(player.getAge() + "   ");
            System.out.print(player.getType() + " \n");
        }
    }

    private void createMatch(LoginView loginView) {
        System.out.println("*** MATCH ALLOCATION ***");
        System.out.println("*** Teams ***");
        HashMap<Integer, Team> teamRequest = adminController.allTeams();
        System.out.println("Team Id |       Team Name       | Contact No    ");
        for (Map.Entry<Integer, Team> team : teamRequest.entrySet()) {
            System.out.print(team.getValue().getTeamId() + " ");
            System.out.print(team.getValue().getTeamName() + "\n ");
        }
        System.out.println("Tournament Name : ");
        String tournamentName = sc.next();
        System.out.println("Please, Select two teams for match from above...");
        System.out.println("Team Id : ");
        int team1 = sc.nextInt();
        System.out.println("Opponant Team Id : ");
        int team2 = sc.nextInt();
        System.out.println("Enter the Venue : ");
        String venue = sc.next();
        System.out.println("Enter the Time : ");
        String time = sc.next();
        System.out.println("Enter the Date  : ");
        String date = sc.next();
        System.out.println("Other Info : ");
        String otherInfo = sc.next();
        if (adminController.addEvent(tournamentName, team1, team2, venue, time, date, otherInfo)) {
            System.out.println("Event added successfully...");
            adminHomePage(loginView);
        } else {
            System.out.println("Entered Invalid Team Id...,Please try again ");
            adminHomePage(loginView);
        }
    }

    private void manageEvents(LoginView loginView) {
        System.out.println("***MANAGE EVENTS***");
        System.out.println("1)Manage Result");
        System.out.println("2)Update Event");
        System.out.println("3)Delete Event");
        System.out.println("4)Back");
        switch (sc.nextInt()) {
            case 1:
                manageResult(loginView);
                break;
            case 2:
                updateEvent(loginView);
                break;
            case 3:
                deleteEvent(loginView);
                break;
            case 4:
                adminHomePage(loginView);
                break;
            default:
                System.out.println("Invalid Input...");
                manageEvents(loginView);
        }
    }

    private void deleteEvent(LoginView loginView) {
        System.out.println("*** EVENT DELETION ***");
        HashMap<Integer, Match> events;
        events = adminController.getEvents();
        if (events != null) {
            System.out.println("Match No. |     Team     |  Opponent Team   |  venue  |  Date | Time | other Info ");
            for (Map.Entry<Integer, Match> event : events.entrySet()) {
                System.out.print(event.getKey() + "   ");
                System.out.println(event.getValue().getTeam1() + "   ");
                System.out.println(event.getValue().getTeam2() + "   ");
                System.out.println(event.getValue().getVenue() + "   ");
                System.out.println(event.getValue().getDate() + "   ");
                System.out.println(event.getValue().getTime() + "   ");
                System.out.println(event.getValue().getOtherInfo() + "   \n");
            }
            System.out.println("Enter the Match No to delete : ");
            int matchNo = sc.nextInt();
            if (adminController.deleteMatch(matchNo)) {
                System.out.println("Deletion Success...");
                manageEvents(loginView);
            } else {
                System.out.println("INvalid Match No...");
                manageEvents(loginView);
            }
        } else {
            System.out.println("Events Doesn't exist...");
            manageEvents(loginView);
        }
    }

    private void updateEvent(LoginView loginView) {
        System.out.println("*** EVENT UPDATION ***");
        HashMap<Integer, Match> events;
        events = adminController.getEvents();
        if (events != null) {
            System.out.println("Match No. |     Team     |  Opponent Team   |  venue  |  Date | Time | other Info ");
            for (Map.Entry<Integer, Match> event : events.entrySet()) {
                System.out.print(event.getKey() + "   ");
                System.out.println(event.getValue().getTeam1() + "   ");
                System.out.println(event.getValue().getTeam2() + "   ");
                System.out.println(event.getValue().getVenue() + "   ");
                System.out.println(event.getValue().getDate() + "   ");
                System.out.println(event.getValue().getTime() + "   ");
                System.out.println(event.getValue().getOtherInfo() + "   \n");
            }
            System.out.println("Enter the Match No to update : ");
            int matchNo = sc.nextInt();
            if (updateEvent(matchNo, loginView)) {
                System.out.println("Update Success...");
                manageEvents(loginView);
            } else {
                System.out.println("INvalid Match No...");
                manageEvents(loginView);
            }
        } else {
            System.out.println("Events Doesn't exist...");
            manageEvents(loginView);
        }

    }

    private boolean updateEvent(int matchNo, LoginView loginView) {
        System.out.println("*** UPDATION ***");
        System.out.println("1)Teams");
        System.out.println("2)Venue");
        System.out.println("3)Date");
        System.out.println("4)Time");
        System.out.println("5)Other info");
        System.out.println("6)Back");
        int input = sc.nextInt();
        switch (input) {
            case 1:
                teams(matchNo, loginView);
                break;
            case 2:
                venue(matchNo, loginView);
                break;
            case 3:
                date(matchNo, loginView);
                break;
            case 4:
                time(matchNo, loginView);
                break;
            case 5:
                otherInfo(matchNo, loginView);
                break;
            case 6:
                manageEvents(loginView);
                break;
            default:
                System.out.println("Invalid input...");

        }
        return false;
    }

    private void otherInfo(int matchNo, LoginView loginView) {
        System.out.println("Enter the new info : ");
        String otherInfo = sc.next();
        adminController.updateOtherInfo(matchNo, otherInfo);
        System.out.println("Updation Success...");
        updateEvent(matchNo, loginView);
    }

    private void time(int matchNo, LoginView loginView) {
        System.out.println("Enter the new time : ");
        String time = sc.next();
        adminController.updateTime(matchNo, time);
        System.out.println("Updation Success...");
        updateEvent(matchNo, loginView);
    }

    private void date(int matchNo, LoginView loginView) {
        System.out.println("Enter the new date : ");
        String date = sc.next();
        adminController.updateDate(matchNo, date);
        System.out.println("Updation Success...");
        updateEvent(matchNo, loginView);
    }

    private void venue(int matchNo, LoginView loginView) {
        System.out.println("Enter the new venue : ");
        String venue = sc.next();
        adminController.updateVenue(matchNo, venue);
        System.out.println("Updation Success...");
        updateEvent(matchNo, loginView);
    }

    private void teams(int matchNo, LoginView loginView) {
        System.out.println("For Opponent Team updation press 1,");
        System.out.println("Else press 2...");
        int input = sc.nextInt();
        if (input == 1) {
            System.out.println("Enter the new Opponent team id : ");
            if (adminController.updateOpponentTeam(sc.nextInt(), matchNo)) {
                System.out.println("Updation Success...");
                updateEvent(matchNo, loginView);
            } else {
                System.out.println("Invalid Id...");
                teams(matchNo, loginView);
            }
        } else if (input == 2) {
            System.out.println("Enter the team Id :");
            if (adminController.updateTeam(sc.nextInt(), matchNo)) {
                System.out.println("Updation Success...");
                updateEvent(matchNo, loginView);
            } else {
                System.out.println("Invalid Id...");
                teams(matchNo, loginView);
            }
        } else {
            System.out.println("invalid Input");
            updateEvent(matchNo, loginView);
        }
    }

    private void manageResult(LoginView loginView) {
        HashMap<Integer, Match> events;
        events = adminController.getEvents();
        if (events != null) {
            System.out.println("Match No. |     Team     |  Opponent Team   |  venue  |  Date | Time | other Info  |   Winner   | ");
            for (Map.Entry<Integer, Match> event : events.entrySet()) {
                System.out.print(event.getKey() + "   ");
                System.out.println(event.getValue().getTeam1() + "   ");
                System.out.println(event.getValue().getTeam2() + "   ");
                System.out.println(event.getValue().getVenue() + "   ");
                System.out.println(event.getValue().getDate() + "   ");
                System.out.println(event.getValue().getTime() + "   ");
                System.out.println(event.getValue().getOtherInfo() + "   ");
                System.out.println(event.getValue().getWinner() + "   ");
  
            }
         
            System.out.println("Enter the match Id : ");
            int matchId = sc.nextInt();
            System.out.println("Enter the result : ");
            String result = sc.next();
            if (adminController.manageResult(matchId, result)) {
                System.out.println("Result Updated...");
                manageEvents(loginView);
            } else {
                System.out.println("INvalid TeamId ...");
                manageResult(loginView);
            }
        } else {
            System.out.println("Event doesn't Exist..");
            manageEvents(loginView);
        }
    }
}
