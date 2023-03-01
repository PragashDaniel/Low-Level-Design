/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fms.login;

import com.fms.booking.BookingView;
import com.fms.manageflights.ManageFlightsView;
import java.sql.SQLException;
import java.util.Scanner;


/**
 *
 * @author welcome
 */
public class LoginView implements LoginViewCallBack{

    private Scanner sc = new Scanner(System.in);
    private LoginControllerViewCallBack loginController;
    
    
    public LoginView() {
        this.loginController = new LoginController(this);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
       LoginView loginView=new LoginView();
       loginView.firstPage();
    }
    public void firstPage() {
        System.out.println("*** Welcome ***");
        System.out.println("1)Admin");
        System.out.println("2)User");
        System.out.println("3)Exit");
        System.out.println("For Admin Press 1 ");
        System.out.println("For User Press 2 ");
        int input = sc.nextInt();
        loginController.loginAdmin(input);
    }

    public void admin() {
        System.out.println("***Admin Login Page ***");
        System.out.println("Enter admin Id : ");
        int adminId = sc.nextInt();
        System.out.println("Enter admin Password : ");
        String adminPassword = sc.next();
        loginController.checkLogin(adminId, adminPassword);
    }

    public void user() {
        System.out.println("*** User ***");
        System.out.println("1) Sign In");
        System.out.println("2) Sign Up");
        System.out.println("3) Back");
        int input = sc.nextInt();
        loginController.checkUser(input);
    }

    public void signIn() {
        System.out.println("*** Welcome for Sign In ***");
        System.out.println("Enter the user id : ");
        int userId = sc.nextInt();
        System.out.println("Enter the password : ");
        String userPassword = sc.next();
        loginController.checkUserCredentials(userId, userPassword);
    }

    public void signUp() {
        System.out.println("*** Welcome for Registration ***");
        System.out.println("Enter the User Name : ");
        String userName=sc.next();
        System.out.println("Enter your Date of Birth : ");
        String dob=sc.next();
        System.out.println("Enter your Mobile Number : ");
        String userMobileNo=sc.next();
        System.out.println("Select Gender \n"+
                           "Press 1 for female\n"+
                           "Press 2 for male\n");
        Integer userGender=sc.nextInt();
        System.out.println("Enter new password : ");
        String userPassword=sc.next();
        System.out.println("Re-enter new password : ");
        String reEnteredPassword=sc.next();
        loginController.addData(userName,dob,userMobileNo,userGender,userPassword,reEnteredPassword);
    }

    public void adminLoginSuccess() {
        System.out.println("Login Successfull...");
        ManageFlightsView manageFlightsView=new ManageFlightsView(); 
        manageFlightsView.firstPage(this);
    }

    public void adminLoginFailed() {
        System.out.println("Invalid Credentials....");
        admin();
    }

    public void userLoginSuccess(int userId) {
        System.out.println("*** Welcome User ***");
        BookingView bookingView=new BookingView();
        bookingView.firstPage(this);
    }

    public void userLoginFailed() {
        System.out.println("Invalid Credentials.... ");
        firstPage();
    }

    public void passwordMismatch() {
        System.out.println("Password Mismatched ...\n\n");
        signUp();
    }

    public void dataAddedFailed() {
        System.out.println("Unable to Insert Data, Please try again ");
        signUp();
    }

    public void dataAddedSuccessfully(int userId) {
        System.out.println("Data Succesfully Inserted...\n");
         System.out.println("Your  id : "+userId);
        signIn();
    }


    public void inValidUser() {
        System.out.println("Invalid Entry... \n ");
        user();
    }

    public void inValidAdmin() {
        System.out.println("Invalid Entry... \n");
        firstPage();
    }

    public void exit() {
        System.out.println("Exit...");
    }

    public void back() {
        firstPage();
    }
    
    
}
