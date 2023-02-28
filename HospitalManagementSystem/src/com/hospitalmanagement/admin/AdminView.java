/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalmanagement.admin;

import com.hospitalmanagement.dto.Doctor;
import com.hospitalmanagement.dto.Patient;
import com.hospitalmanagement.login.LoginView;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author welcome
 */
public class AdminView implements AdminViewCallBack {

    private Scanner sc = new Scanner(System.in);
    private AdminControllerViewCallBack adminController;
    
    public AdminView()
    {
        this.adminController=new AdminController(this);
    }
    
    public void adminHomePage(LoginView loginView) {
        System.out.println("*** Welcome for ADMIN HOMEPAGE ***");
        System.out.println("1)Add Doctor");
        System.out.println("2)Manage Doctor");
        System.out.println("3)Manage Patients");
        System.out.println("4)Sign Out");
        System.out.println("Please, Enter a option to continue...");
        switch(sc.nextInt())
        {
            case 1:
                addDoctors(loginView);
                break;
            case 2:
                manageDoctor(loginView);
                break;
            case 3:
                managePatients(loginView);
                break;
            case 4:
                loginView.firstPage();
                break;
            default:
                System.out.println("Invalid Input...");
                adminHomePage(loginView);
        }
    }

    private void addDoctors(LoginView loginView) {
        System.out.println("***** ADD DOCTORS *****");
        System.out.println("Name of the Doctor : ");
        String name=sc.next();
        System.out.println("Specialist : ");
        String specialist=sc.next();
        System.out.println("Time : ");
        String time=sc.next();
        System.out.println("No. Of Slots : ");
        byte slots=sc.nextByte();
        System.out.println("Fee : ");
        int fee=sc.nextInt();
        adminController.addDoctors(name,specialist,time,slots,fee);
        System.out.println("Doctor details added success fully...");
        adminHomePage(loginView);
    }

    private void manageDoctor(LoginView loginView) {
        HashMap<Integer,Doctor> doctors=adminController.getDoctorDetails();
        System.out.println("Doctor ID   |     Name      |    Specialist    |   Time   | Slots  | Fee  |");
        for(Map.Entry<Integer,Doctor> doctor:doctors.entrySet())
        {
            System.out.print(doctor.getValue().getId()+"  ");
            System.out.print(doctor.getValue().getName()+"  ");
            System.out.print(doctor.getValue().getSpecialist()+"  ");
            System.out.print(doctor.getValue().getTime()+"  ");
            System.out.print(doctor.getValue().getSlots()+"  ");
            System.out.print(doctor.getValue().getFee()+"  \n");
        }
        System.out.println("*** Manage Doctor Details ***");
        System.out.println("1)Name ");
        System.out.println("2)Specialist");
        System.out.println("3)Time");
        System.out.println("4)Slots");
        System.out.println("5)Fee");
        System.out.println("6)Back");
        System.out.println("Enter an option...");
        int doctorId;
        switch(sc.nextInt())
        {
            case 1:
                System.out.println("Enter the Doctor Id : ");
                doctorId=sc.nextInt();
                System.out.println("Enter the new name : ");
                adminController.updateName(doctorId,sc.next(),loginView);
                System.out.println("Updation success....");
                manageDoctor(loginView);
                break;
            case 2:
                System.out.println("Enter the Doctor Id : ");
                doctorId=sc.nextInt();
                System.out.println("Enter the Specialist : ");
                adminController.updateSpecialist(doctorId,sc.next(),loginView);
                System.out.println("Updation success....");
                manageDoctor(loginView);
                break;
            case 3:
                System.out.println("Enter the Doctor Id : ");
                doctorId=sc.nextInt();
                System.out.println("Enter the Time : ");
                adminController.updateTime(doctorId,sc.next(),loginView);
                System.out.println("Updation success....");
                manageDoctor(loginView);
                break;
            case 4:
                System.out.println("Enter the Doctor Id : ");
                doctorId=sc.nextInt();
                System.out.println("Enter the slots : ");
                adminController.updateSlots(doctorId,sc.nextByte(),loginView);
                System.out.println("Updation success....");
                manageDoctor(loginView);
                break;
            case 5:
                System.out.println("Enter the Doctor Id : ");
                doctorId=sc.nextInt();
                System.out.println("Enter the Fee : ");
                adminController.updateFee(doctorId,sc.nextInt(),loginView);
                System.out.println("Updation success....");
                manageDoctor(loginView);
                break;
            case 6:
                adminHomePage(loginView);
                break;
            default:
                System.out.println("InValid Input...");
                manageDoctor(loginView);
        }
    }

    @Override
    public void updateFailed(LoginView loginView) {
        System.out.println("Invalid Id...");
        manageDoctor(loginView);
    }

    private void managePatients(LoginView loginView) {
        System.out.println("*** Patients List ***");
        HashMap<Integer,Patient> patients=adminController.getPatientsDetails();
        System.out.println("Id  |  Name    |  Age  |   Date  |    Problem   | ");
        for(Map.Entry<Integer,Patient> patient:patients.entrySet())
        {
            if(patient.getValue().isStatus())
            {
                System.out.print(patient.getValue().getId()+"   ");
                System.out.print(patient.getValue().getName()+"   ");
                System.out.print(patient.getValue().getAge()+"   ");
                System.out.print(patient.getValue().getDate()+"   ");
                System.out.print(patient.getValue().getProblem()+"   \n");
            }
        }
        System.out.println("Press 1 for Delete Records...");
        System.out.println("Press 0 for back...");
        switch(sc.nextInt())
        {
            case 1:
                this.adminController.clearRecords();
                break;
            case 0:
                adminHomePage(loginView);
                break;
            default:
                System.out.println("Invalid Input...");
                managePatients(loginView);
                break;
        }
    }
    
}
