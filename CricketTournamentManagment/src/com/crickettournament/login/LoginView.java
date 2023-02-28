/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crickettournament.login;

import com.crickettournament.admin.AdminView;
import com.crickettournament.dto.Player;
import com.crickettournament.user.UserView;
import java.util.Scanner;

/**
 *
 * @author welcome
 */
public class LoginView implements LoginViewCallBack{

    private Scanner sc = new Scanner(System.in);
    private LoginControllerViewCallBack loginController;

    public LoginView() {
        loginController = new LoginController(this);
    }

    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        loginView.firstPage();
    }

    public void firstPage() {
        System.out.println("*** Welcome ***");
        System.out.println("1)Admin");
        System.out.println("2)User");
        System.out.println("3)Exit");
        System.out.println("Please, Enter a option to continue...");
        int input = sc.nextInt();
        if (input == 1) {
            adminLogin();
        } else if (input == 2) {
            user();
        } else if (input == 3) {
            exit();
        } else {
            invalidFirstPageInput();
        }
    }

    private void adminLogin() {
        System.out.println("---------Welcome to Admin Login---------");
        System.out.println("Please,Enter your Admin Id : ");
        int adminId = sc.nextInt();
        System.out.println("Please, Enter your Passowrd : ");
        String adminPassword = sc.next();
        if (loginController.checkAdminCredentials(adminId, adminPassword)) {
            System.out.println("Login Successfull....");
            AdminView adminView = new AdminView();
            adminView.adminHomePage(this);
        } else {
            System.out.println("Invalid Credentials...");
            firstPage();
        }
    }

    private void user() {
        System.out.println("---------Welcome User-----------");
        System.out.println("1)Sign In");
        System.out.println("2)Sign Up");
        System.out.println("3)Exit");
        try {
            int input = sc.nextInt();
            if (input == 1) {
                userSignIn();
            } else if (input == 2) {
                userSignUp();
            } else if (input == 3) {
                exit();
            } else {
                invalidInputUser();
            }
        } catch (Exception e) {
            System.out.println("Invalid Input,Try Again...");
            firstPage();
        }
    }

    private void exit() {
        System.out.println("Exit...");
        // firstPage();
    }

    private void invalidFirstPageInput() {
        System.out.println("Invalid Input...");
        firstPage();
    }

    private void userSignIn() {
        System.out.println("*** Welcome for Sign In ***");
        try {
            System.out.println("Pease, Enter the Team Id : ");
            int userId = sc.nextInt();
            System.out.println("Please, Enter the password : ");
            String password = sc.next();
            if (loginController.checkUserCredentials(userId, password)) {
                System.out.println("Sign In Success...");
                UserView userView = new UserView();
                userView.userHomePage(this, userId);
            } else {
                System.out.println("Invalid Credentials, Please try again or Sign Up");
                user();
            }
        } catch (Exception e) {
            System.out.println("Ivalid Input,Try Again...");
            user();
        }
    }

    private void userSignUp() {
        System.out.println("*** Welcome for SignUp ***");
        System.out.println("   TEAM NAME  ");
        System.out.println("First Name : ");
        String fN = sc.next();
        System.out.println("Middle Name : ");
        String mN = sc.next();
        System.out.println("Last Name : ");
        String lN = sc.next();
        String teamName = fN + mN + lN;
        System.out.println("Contact No. : ");
        long contNo = sc.nextLong();
        System.out.println("No.Of Players(Max-22) : ");
        byte nop = sc.nextByte();
        if (loginController.checkNOP(nop)) {
            System.out.println("No.Of Players must be in the range(Max-22)");
            user();
            return;
        }
        Player[] players = new Player[nop];
        addPlayers(players, nop, 0);
        System.out.println("Password : ");
        String password = sc.next();
        System.out.println("Re-Enter Password :");
        String reEnteredPassword = sc.next();
        loginController.addPlayers(teamName, contNo, nop, players, password, reEnteredPassword);
    }

    Player[] addPlayers(Player players[], byte nop, int id) {
        for (int i = id; i < nop; i++) {
            String name;
            byte age;
            String type;
            if (i == 0) {
                System.out.println("Enter the name of team captain : ");
                name = sc.next();
                name = name + " (C)";
            } else {
                System.out.println("Enter the next Player Name : ");
                name = sc.next();
            }
            System.out.println("Enter the player Age : ");
            age = sc.nextByte();
            System.out.println("Enter the Playe Type : ");
            type = sc.next();
            if (loginController.checkPlayerAge(age)) {
                players[i] = new Player(i + 1, name, age, type);
            } else {
                System.out.println("Player Age must be greater than 17 and less than 36, Try Again...");
                addPlayers(players, nop, i);
                return players;
            }
        }
        return players;
    }

    public void inputMismatch() {
        System.out.println("Please Check your Password or Contact No(must 10 digit)...");
        userSignUp();
    }

    public void signUpSuccess(int teamId) {
        System.out.println("Signed Up Successfully... ");
        System.out.println("Your Team Id : " + teamId);
        firstPage();
    }

    private void invalidInputUser() {
        System.out.println("Invalid Input...");
        user();
    }

}
