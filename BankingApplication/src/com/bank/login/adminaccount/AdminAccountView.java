/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.login.adminaccount;

import com.bank.dto.User;
import com.bank.login.LoginView;
import com.bankutil.Validation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author welcome
 */
public class AdminAccountView extends Validation implements AdminAccountViewCallBack {

    private Scanner sc = new Scanner(System.in);
    private AdminAccountControllerViewCallBack adminAccountController;

    public AdminAccountView() {
        this.adminAccountController = new AdminAccountController(this);
    }

    public void firstPage(LoginView loginView) {
        System.out.println("*** Welcome to Admin HomePage ***");
        System.out.println("1) View Request");
        System.out.println("2) Manage Users");
        System.out.println("3) Show Users By Branch");
        System.out.println("4) Total Bank Balance");
        System.out.println("5) Sign Out");
        System.out.println("Please, Enter an Option : ");
        adminAccountController.firstPageSeletion(sc.nextInt(), loginView);
    }

    public void invalidInput(LoginView loginView) {
        System.out.println("Entered Invalid Input, Please try again...");
        firstPage(loginView);
    }

    public void signOut(LoginView loginView) {
        System.out.println("Signed Out successfully...");
        loginView.firstPage();
    }

    public void totalBankBalance(LoginView loginView) {
        System.out.println("*** Total Bank Amount *** ");
        System.out.println(adminAccountController.totalBankBalance());
        firstPage(loginView);
    }

    public void showUsers(LoginView loginView) {

        System.out.println("*** Branch List ***");
        HashMap<Integer, String> branches = adminAccountController.branchList();
        for (int i = 1; i <= branches.size(); i++) {
            System.out.println(i + ") " + branches.get(i));
        }
        System.out.println("Please, Select a branch : ");
        int branch = sc.nextInt();
        HashMap<Integer, User> userByBranch = adminAccountController.showUsersByBranch(branch, loginView);
        if (userByBranch == null) {
            invalidBranch(loginView);
        } else {
            System.out.println("*** Details of the User *** ");
            System.out.println("| User Id |      Name       | Date of Birth | Mobile No. | Gender | Branch |");
            for (Map.Entry<Integer,User> user:userByBranch.entrySet()) {
                if (user.getValue().getStatus()) {
                    System.out.print(user.getValue().getUserId());
                    System.out.print("       " + user.getValue().getFirstName() + " " + user.getValue().getLastName());
                    System.out.print(" " + user.getValue().getDob());
                    System.out.print("    " + user.getValue().getMobileNo());
                    System.out.print("   " + user.getValue().getGender());
                    System.out.print(" " + user.getValue().getBranch() + "\n");
                }
            }
            firstPage(loginView);
        }
    }

    void invalidBranch(LoginView loginView) {
        System.out.println("*** INVALID BRANCH SELECTION *** ");
        showUsers(loginView);
    }

    public void manageUser(LoginView loginView) {
        System.out.println("*** Branch List ***");
        HashMap<Integer, String> branches = adminAccountController.branchList();
        for (int i = 1; i <= branches.size(); i++) {
            System.out.println(i + ") " + branches.get(i));
        }
        System.out.println("Please, Select a branch : ");
        int branch = sc.nextInt();
        HashMap<Integer, User> userByBranch = adminAccountController.showUsersByBranch(branch, loginView);
        if (userByBranch == null) {
            invalidBranch(loginView);
        } else {
            System.out.println("*** Details of the User *** ");
            System.out.println("| User Id |      Name       | Date of Birth | Mobile No. | Gender | Branch |");
            for(Map.Entry<Integer,User> user:userByBranch.entrySet()) {
                if (user.getValue().getStatus()) {
                    System.out.print(user.getValue().getUserId());
                    System.out.print("       " + user.getValue().getFirstName() + " " + user.getValue().getLastName());
                    System.out.print(" " + user.getValue().getDob());
                    System.out.print("    " + user.getValue().getMobileNo());
                    System.out.print("   " + user.getValue().getGender());
                    System.out.print(" " + user.getValue().getBranch() + "\n");
                }
            }
            System.out.println("\nPress 1 for add new user... ");
            System.out.println("Press 0 for delete user... ");
            System.out.println("Press 10 for back ...");
            int input = sc.nextInt();
            if (input == 10) {
                firstPage(loginView);
            } else if (input != 1 && input != 0) {
                System.out.println("Invalid Input...");
                firstPage(loginView);
            } else if (input == 0) {
                System.out.println("Enter the UserId : ");
                int userId = sc.nextInt();
                adminAccountController.checkForManage(input, userId, loginView);
            } else if (input == 1) {
                adminAccountController.checkForManage(input, 0, loginView);
            }
        }
    }

    public void invalidInputForManage(LoginView loginView) {
        System.out.println("Invalid Input to manage...");
        firstPage(loginView);
    }

    public void deletionSuccess(LoginView loginView) {
        System.out.println("Data Successfully deleted...");
        firstPage(loginView);
    }

    public void deletionUnsuccess(LoginView loginView) {
        System.out.println("User Id doesn,t exits... ,Please try again with another id");
        manageUser(loginView);
    }

    void addNewUser(LoginView loginView) {
        System.out.println("*** Welcome for Adding New User ***");
        System.out.println("Please, Enter the First Name of User: ");
        String firstName = sc.next();
        if (!AdminAccountView.checkName(firstName)) {
            invalidName(loginView);
            return;
        }
        System.out.println("Please, Enter the Last Name of User: ");
        String lastName = sc.next();
        if (!AdminAccountView.checkName(lastName)) {
            invalidName(loginView);
            return;
        }
        System.out.println("Please, Enter the Date of Birth(dd/MM/yyyy) : ");
        Date dob;
        String DOB = sc.next();
        try {
            dob = new SimpleDateFormat("dd/MM/yyyy").parse(DOB);
        } catch (ParseException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Entered invald Syntax for date, Please try again..");
            addNewUser(loginView);
            return;
        }
        System.out.println("Please, Enter the Mobile Number : ");
        long mobileNo;
        try {
            mobileNo = sc.nextLong();
            if (!AdminAccountView.checkMobile(mobileNo)) {
                invalidNumber(loginView);
                return;
            }
        } catch (Exception e) {
            System.out.println("Must contain Numbers only");
            addNewUser(loginView);
            return;
        }

        System.out.println("Please, Select Gender of User \n"
                + "Press 1 for female\n"
                + "Press 2 for male");
        Integer gender = sc.nextInt();
        LoginView.checkGender(gender);
        System.out.println("*** Branch List ***");
        for (int i = 1; i <= adminAccountController.brances().size(); i++) {
            System.out.println(i + ") " + adminAccountController.brances().get(i));
        }
        System.out.println("Please, Enter the User's branch  : ");
        int branch = sc.nextInt();
        adminAccountController.checkBranch(branch, loginView);
        System.out.println("Please, Enter new password : ");
        String password = sc.next();
        System.out.println("Please, Re-enter new password : ");
        String reEnteredPassword = sc.next();
        if (adminAccountController.addData(firstName, lastName, dob, mobileNo, gender, branch, password, reEnteredPassword)) {
            System.out.println("Data added Successfully...");
            System.out.println("Your Login Id : " + adminAccountController.getId());
            firstPage(loginView);
        } else {
            System.out.println("Unable to add data Please try again.....");
            addNewUser(loginView);
        }
    }

    public void add(LoginView loginView) {
        addNewUser(loginView);
    }

    private void invalidName(LoginView loginView) {
        System.out.println("Invalid Name Entry Please, try again");
        addNewUser(loginView);
    }

    private void invalidNumber(LoginView loginView) {
        System.out.println("Invalid Number, Please, Try again...");
        addNewUser(loginView);
    }

    public void invalidBranchId(LoginView loginView) {
        System.out.println("Please, Select the valid branch... ");
        addNewUser(loginView);
    }

    public void userRequest(LoginView loginView) {
        System.out.println("*** Branch List ***");
        HashMap<Integer, String> branches = adminAccountController.branchList();
        for (int i = 1; i <= branches.size(); i++) {
            System.out.println(i + ") " + branches.get(i));
        }
        System.out.println("Please, Select a branch : ");
        int branch = sc.nextInt();
        HashMap<Integer, User> userByBranch = adminAccountController.userRequest(branch,loginView);
        if (userByBranch == null) {
            invalidBranch(loginView);
        } else {
            System.out.println("*** Details of the User *** ");
            System.out.println("| User Id |      Name       | Date of Birth | Mobile No. | Gender | Branch");
            for (Map.Entry<Integer,User> user:userByBranch.entrySet()) {
                    System.out.print(user.getValue().getUserId());
                    System.out.print("       " + user.getValue().getFirstName() + " " + user.getValue().getLastName());
                    System.out.print(" " + user.getValue().getDob());
                    System.out.print("    " + user.getValue().getMobileNo());
                    System.out.print("   " + user.getValue().getGender());
                    System.out.print(" " + user.getValue().getBranch() + "\n");
            }
            System.out.println("\nPress 1 for Approval");
            System.out.println("Press 2 for Not Approval");
            System.out.println("Press 3 for back");
            int input = sc.nextInt();
            if (input == 1) {
                System.out.println("Enter the userID : ");
                int id = sc.nextInt();
                adminAccountController.approveUser(id, loginView);
            } else if (input == 2) {
                System.out.println("User Not Approved");
                userRequest(loginView);
            } else if (input == 3) {
                firstPage(loginView);
            } else {
                System.out.println("Invalid input");
                firstPage(loginView);
            }
        }

    }

    public void approved(LoginView loginView) {
        System.out.println("User Succesfully Approved...");
        firstPage(loginView);
    }

}
