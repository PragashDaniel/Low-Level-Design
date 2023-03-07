/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.useraccount;


import com.bank.dto.User;
import com.bank.login.LoginView;
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
public class UserAccountView extends Validation implements UserAccountViewCallBack{
    private Scanner sc = new Scanner(System.in);
    private UserAccountControllerViewCallBack userAccountController;
    
    public UserAccountView()
    {
        userAccountController =new UserAccountController(this);
    }
    public void userHomePage(LoginView loginView,int id)
    {
        System.out.println("*** Welcome to User HomePage***");
        System.out.println("1) Your Details ");
        System.out.println("2) Check Account Details");
        System.out.println("3) Sign Out");
        System.out.println("Please, Select an option to continue...");
        int input=sc.nextInt();
        userAccountController.selectedModule(input,id,loginView);
    }    

    public void yourDetails(int id,LoginView loginView) {
        User user=userAccountController.getDetail(id);
        System.out.println("*** YOUR DETAILS ***");
        System.out.println("Name : "+user.getFirstName()+" "+user.getLastName());
        System.out.println("Date of Birth : "+user.getDob());
        System.out.println("Mobile No : "+user.getMobileNo());
        System.out.println("Brance : "+user.getBranch());
        System.out.println("Status : "+((user.getStatus()==true)?"Approved":"Not Approved"));
        System.out.println("TO EDIT INFO, Press 1");
        System.out.println("For Back press 2");
        int input=sc.nextInt();
        userAccountController.next(input,id,loginView);
    }

    public void editInfo(int id,LoginView loginView) {
        System.out.println("Please select an field to edit... ");
        System.out.println("1) Name");
        System.out.println("2) Date of Birth ");
        System.out.println("3) Mobile No");
        System.out.println("4) Brance");
        System.out.println("5) Gender");
        System.out.println("Enter a option : ");
        userAccountController.editInfo(sc.nextInt(),id,loginView);
        System.out.println("Updation Success... ");
        yourDetails(id,loginView);
    }

    public void invalidInput(int id,LoginView loginView) {
        System.out.println("Please, Enter the valid input");
        userHomePage(loginView,id);
    }

    public void editUserName(int id) {
        System.out.println("Please Enter your new User Name ");
        System.out.println("Enter First Name :");
        String firstName=sc.next();
        System.out.println("Enter Last Name : ");
        String lastName=sc.next();
        if(checkName(firstName) && checkName(lastName))
        {   userAccountController.editUserName(firstName,lastName,id);}
        else{
             System.out.println("*** Invalid Name *** ");
             editUserName(id);
        }
    }

    public void editDOB(int id,LoginView loginView) {
       System.out.println("Please Enter your new Date of Birth : ");
       Date dob;
       String DOB=sc.next();
        try {
            dob = new SimpleDateFormat("dd/MM/yyyy").parse(DOB);
            userAccountController.editDOB(dob,id);
        } catch (ParseException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Entered invald Syntax for date, Please try again..");
            editInfo(id,loginView);
        }
    }

    public void editMobileNo(int id) {
        System.out.println("Please Enter you new Mobile Number : ");
        long mobileNumber=sc.nextLong();
        if(checkMobile(mobileNumber))
            userAccountController.editMobileNo(mobileNumber,id);
        else
        {    System.out.println("Invalid mobile No ");editMobileNo(id);}
            
    }

    public void editBrance(int id,LoginView loginView) {
        System.out.println("*** Brance List ***");
        for(int i=1;i<=userAccountController.branches().size();i++)
        {
            System.out.println(i+") "+userAccountController.branches().get(i));
        }
        System.out.println("Please, Enter your new Brance : ");
        Integer brance=sc.nextInt();
        userAccountController.editBranch(brance,id,loginView);
    }

    public void editGender(int id) {
         System.out.println("Please, Select Gender \n"+
                           "Press 1 for female\n"+
                           "Press 2 for male\n");
        Integer gender=sc.nextInt();
        if(checkGender(gender))
            userAccountController.editGender(gender,id);
        else
        { System.out.println("Invalid Gender ");
            editGender(id);}
    }

    public void checkAccountDetails(int id, LoginView loginView) {
        System.out.println("*** ACCOUNT DETAILS ***");
        System.out.println("1) Deposit Money");
        System.out.println("2) Withdrawal Money");
        System.out.println("3) Account Balance");
        System.out.println("4) Money Transfer");
        System.out.println("5) Back");
        System.out.println("Please,Enter an option...");
        userAccountController.accountDetailSelection(sc.nextInt(),id,loginView);
    }

    public void deposit(int id, LoginView loginView) {
        System.out.println("*** Deposit Money *** ");
        System.out.println("Please, Enter the amount : ");
        long amount=sc.nextLong();
        userAccountController.deposit(id,amount,loginView);
    }

    public void depositSuccess(int id, LoginView loginView,long amount)
    {
        System.out.println("Amount "+amount+" Credited Successfully...");
        checkAccountDetails(id,loginView);
    }
    
    public void permissionDenied(int id, LoginView loginView) {
        System.out.println("You don't have permission to access this module\n"
                        + "Check your status in Details Pages\n");
        userHomePage(loginView,id);
    }

    public void limitReached(int id, LoginView loginView) {
        System.out.println("Amount Limit must be above ZERO and below 25000,\nPlease Try angain...");
        deposit(id,loginView);
    }

    public void withdraw(int id, LoginView loginView) {
        System.out.println("*** WITHDRAWAL ***");
        System.out.println("Please, Enter the amount : ");
        long amount=sc.nextLong();
        userAccountController.withdraw(id,amount,loginView);
    }

    public void unableToWithdraw(int id, LoginView loginView) {
        System.out.println("Minimum withdraw amount must be Above 100 and Below 10000,\nAmount must be multiple of 100"
                + "\nPlease Try angain...");
        withdraw(id,loginView);
    }

    public void withdrawSuccess(int id,long amount,LoginView loginView) {
        System.out.println("Amount "+amount+" debited Successfully...");
        checkAccountDetails(id,loginView);
    }

    public void balanceLow(int id,LoginView loginView) {
        System.out.println("Account must have atleast Rs: 500 ");
        System.out.println("Minimum balance reached...");
        withdraw(id,loginView);
    }

    public void accountBalance(int id,LoginView loginView) {
        System.out.println("Your A/C Balance : "+(userAccountController.accountBalance(id)));
        checkAccountDetails(id,loginView);
    }

    public void invalidAccountDetailSelection(int id, LoginView loginView) {
        System.out.println("Please, Select an valid option ");
        checkAccountDetails(id,loginView);
    }

    public void logout(int id, LoginView loginView) {
        System.out.println("Signed out...");
        loginView.firstPage();
    }

    public void unableToEditBranch(int id,LoginView loginView) {
        System.out.println("Invalid Selection...");
        editBrance(id,loginView);
        
     }

    @Override
    public void moneyTransfer(int id, LoginView loginView) {
        System.out.println("*** Welcome for Money Transfer ***");
        System.out.println("Please, Enter the Id of Receiver : ");
        int receiverId=sc.nextInt();
        System.out.println("Please, Enter the amount to be Trasfer : ");
        long amount=sc.nextLong();
        userAccountController.moneyTransfer(id,loginView,receiverId,amount);
    }

    @Override
    public void unableToTransfer(int id, LoginView loginView) {
        System.out.println("Minimum amount must be Above 100 and Below 10000,\nAmount must be multiple of 100"
                + "\nPlease Try angain...");
        moneyTransfer(id,loginView);
    }

    @Override
    public void moneyTransferedSuccess(int id, LoginView loginView) {
        System.out.println("Money Transfered Successfully.....");
        checkAccountDetails(id,loginView);
    }

    @Override
    public void monerTransferedFailed(int id, LoginView loginView) {
        System.out.println("Entered id Invalid, Please try again...");
        moneyTransfer(id,loginView);
        
    }

    

    
}
