/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalmanagement.login;

import com.hospitalmanagement.admin.AdminView;
import com.hospitalmanagement.doctor.DoctorView;
import com.hospitalmanagement.patient.PatientView;
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
        System.out.println("2)Doctor");
        System.out.println("3)Patient");
        System.out.println("4)Exit");
        System.out.println("Please, Enter a option to continue...");
        int input = sc.nextInt();
        switch(input)
        {
            case 1:
                admin();
                break;
            case 2:
                doctor(this);
                break;
            case 3:
                patient(this);
                break;
            case 4:
                exit();
                break;
            default:
                invalidFirstPageInput();
                break;
        }
    }

    private void invalidFirstPageInput() {
        System.out.println("Entered Invalid input...");
        firstPage();
    }

    private void exit() {
        System.out.println("Exit...");
    }

    private void admin() {
        System.out.println("*** Admin Login ***");
        System.out.println("Enter the admin Id : ");
        int adminId=sc.nextInt();
        System.out.println("Enter the admin Password : ");
        String adminPassword=sc.next();
        if(loginController.checkAdminCredentials(adminId,adminPassword))
        {
            System.out.println("Login in success....");
            AdminView adminView=new AdminView();
            adminView.adminHomePage(this);
        }
        else 
        {
            System.out.println("InValid Credentials....");
            firstPage();
        }
    }

    public void patient(LoginView loginView) {
        System.out.println("*** WElCOME ***");
        System.out.println("1)Register");
        System.out.println("2)Check Details");
        System.out.println("3)Back");
        System.out.println("Enter an option...");
        PatientView patientView=new PatientView();
        switch(sc.nextInt())
        {
            case 1:
                patientView.registration(loginView);
                System.out.println("Registration Success...");
                patient(loginView);
                break;
            case 2:
                patientView.checkDetails(loginView);
                break;
            case 3:
                firstPage();
                break;
            default:
                System.out.println("Invalid Input...");
                patient(loginView);
        }
    }

    private void doctor(LoginView loginView) {
        System.out.println("Welcome for Doctor Login ");
        System.out.println("Please, Enter your Id : ");
        int id=sc.nextInt();
        DoctorView doctorView=new DoctorView();
        doctorView.doctorHomePage(loginView,id);
    }
}
