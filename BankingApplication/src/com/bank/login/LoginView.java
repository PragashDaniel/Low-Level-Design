/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.login;


import com.bank.login.adminaccount.AdminAccountView;
import com.bank.useraccount.UserAccountView;
import com.bankutil.Validation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author welcome
 */
public class LoginView extends Validation implements LoginViewCallBack{

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
        loginController.login(input);
    }

    public void adminLogin() {
        System.out.println("*** Admin ***");
        System.out.println("Please, Sign In to continue...");
        System.out.println("Please, Enter the admin Id : ");
        int adminId = sc.nextInt();
        System.out.println("Please, Enter the password : ");
        String adminPassword = sc.next();
        if (loginController.checkAdminCredentials(adminId, adminPassword)) 
        {
            System.out.println("Successfully Signed In...");
            AdminAccountView adminAccountView=new AdminAccountView();
            adminAccountView.firstPage(this);
        }
        else
        {   
            System.out.println("Invalid Credentials...");
            firstPage();
        }
        
    }

    public void user() {
        System.out.println("*** User ***");
        System.out.println("1) Sign In");
        System.out.println("2) Sign Up");
        System.out.println("3) Back");
        System.out.println("Please, Enter a option to continue...");
        int input = sc.nextInt();
        loginController.check(input);
    }

    public void exit() {
        System.out.println("Exit...");
    }

    public void invalidInput() {
        System.out.println("Enter invalid input ");
        firstPage();
    }

    public void userSignIn() {
        System.out.println("*** Welcome for Sign In ***");
        System.out.println("Enter the user Id : ");
        Integer userId = sc.nextInt();
        System.out.println("Enter the password : ");
        String userPassword = sc.next();
        if (!loginController.checkUserCredentials(userId, userPassword)) {
            System.out.println("Invalid Credentials...");
            user();
        } else {
            System.out.println("Successfully Signed In...");
            UserAccountView userAccountView = new UserAccountView();
            userAccountView.userHomePage(this, userId);
        }

    }

    public void userSignUp() {
        System.out.println("*** Welcome for Registration ***");
        System.out.println("Please, Enter the First Name : ");
        String firstName = sc.next();
        if (!checkName(firstName)) {
            invalidName();return;
        }
        System.out.println("Please, Enter the Last Name : ");
        String lastName = sc.next();
        if (!checkName(lastName)) {
            invalidName();return;
        }
        System.out.println("Please, Enter your Date of Birth(dd/MM/yyyy) : ");
        Date dob;
        String DOB = sc.next();
        try {
            dob = new SimpleDateFormat("dd/MM/yyyy").parse(DOB);
        } catch (ParseException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Entered invald Syntax for date, Please try again..");
            user();
            return;
        }
        System.out.println("Please, Enter your Mobile Number : ");
        long mobileNo;
        try {
            mobileNo = sc.nextLong();
            if (!LoginView.checkMobile(mobileNo)) {
                invalidNumber();
                userSignUp();
            }
        } catch (Exception e) {
            System.out.println("Must contain Numbers only");
            userSignUp();
            return;
        }

        System.out.println("Please, Select Gender \n"
                + "Press 1 for female\n"
                + "Press 2 for male");
        Integer gender = sc.nextInt();
        System.out.println("*** Branch List ***");
        for (int i = 1; i <= loginController.brances().size(); i++) {
            System.out.println(i + ") " + loginController.brances().get(i));
        }
        System.out.println("Please, Enter branch  : ");
        int branch = sc.nextInt();
        loginController.checkBranch(branch);
        System.out.println("Please, Enter new password : ");
        String password = sc.next();
        System.out.println("Please, Re-enter new password : ");
        String reEnteredPassword = sc.next();
        if (loginController.addData(firstName, lastName, dob, mobileNo, gender, branch, password, reEnteredPassword)) {
            System.out.println("Data added Successfully...");
            System.out.println("Your Login Id : " + loginController.getId());
            firstPage();
        }
    }

    public void passwordMismatch() {
        System.out.println("*** Entered Password and Re-Entered Password Mismatch ***");
        unableToAdd();
    }

    public void unableToAdd() {
        System.out.println("Please, Try again...");
        userSignUp();
    }

    public void invalidName() {
        System.out.println("Name must contains.. only words(a-z or A-Z), try again...");
        userSignUp();
    }

    public void invalidNumber() {
        System.out.println("Number must contains 10 digits...");
        userSignUp();
    }

    public void invalidGender() {
        System.out.println("Gender must 1 or 2");
        userSignUp();
    }

    public void invalidBranch() {
        System.out.println("Choosen invalid branch...");
        userSignUp();
    }

}
