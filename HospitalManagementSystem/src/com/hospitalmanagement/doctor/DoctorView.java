/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalmanagement.doctor;

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
public class DoctorView implements DoctorViewCallBack{
    private Scanner sc = new Scanner(System.in);
    private DoctorControllerViewCallBack doctorControllerViewCallBack;
    public DoctorView()
    {
        this.doctorControllerViewCallBack=new DoctorController(this);
    }

    public void doctorHomePage(LoginView loginView,int id) {
        Doctor doctor=doctorControllerViewCallBack.getDoctorDetail(id);
        if(doctor!=null)
        {
            if(doctor.getPassword() == null)
            {
               System.out.println("Please, Set new Password : ");
               String password=sc.next();
               this.doctorControllerViewCallBack.setNewPassword(doctor.getId(),password);
               System.out.println("Password Successfully updated...");
               doctorHomePage(loginView,id);
            }
            else
            {
                System.out.println("Please, Enter the Password : ");
                if(this.doctorControllerViewCallBack.checkPassword(id,sc.next()))
                {
                    System.out.println("Successfullt Signed In...");
                    nextPage(loginView,id);
                }
                else
                {
                    System.out.println("Incorrect password...Try again...");
                    doctorHomePage(loginView,id);
                }
            }
        }
    }

    private void nextPage(LoginView loginView,int doctorId) {
        System.out.println("*** Paitents List *** ");
        HashMap<Integer,Patient> patients=this.doctorControllerViewCallBack.getAllPatients(doctorId);
        System.out.println("No. Of Paitents : "+patients.size());
        System.out.println("Id  |  Name  |  Age  |  Date  |  Problem  |   Status   |\n");
        for(Map.Entry<Integer,Patient> patient:patients.entrySet())
        {
            System.out.print(patient.getValue().getId()+"   ");
            System.out.print(patient.getValue().getName()+"   ");
            System.out.print(patient.getValue().getAge()+"   ");
            System.out.print(patient.getValue().getDate()+"   ");
            System.out.print(patient.getValue().getProblem()+"  ");
            System.out.println(patient.getValue().isStatus()?"Approved":"Not Approved"+(" \n"));
        }
        System.out.println("Press 0 for Back or SignOut else... continue");
        if(sc.nextInt()==0){ loginView.firstPage();return;}
        System.out.println("Please, Select the ID for Approve...");
        int id=sc.nextInt();
        if(this.doctorControllerViewCallBack.approve(id))
        {
            System.out.println("Approved...");
            nextPage(loginView,doctorId);
        }
        else
        {
            System.out.println("Id Invalid...");
            nextPage(loginView,doctorId);
        }
             
    }
}
