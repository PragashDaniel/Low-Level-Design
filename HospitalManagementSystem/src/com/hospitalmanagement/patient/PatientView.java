/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalmanagement.patient;

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
public class PatientView implements PatientViewCallBack
{
    private Scanner sc = new Scanner(System.in);
    private PatientControllerViewCallBack patientController;
    public PatientView()
    {
        this.patientController=new PatientController(this);
    }
    
    public void registration(LoginView loginView) {
        HashMap<Integer,Doctor> doctors=patientController.getDoctors();
        if(doctors!=null)
        {
            System.out.println("Doctor ID |     Name    |    Specialis   |   Slots    |  Time  |   Fee");
            for(Map.Entry<Integer,Doctor> doctor:doctors.entrySet())
            {
                System.out.print(doctor.getValue().getId()+"   ");
                System.out.print(doctor.getValue().getName()+"   ");
                System.out.print(doctor.getValue().getSpecialist()+"   ");
                System.out.print(doctor.getValue().getSlots()+"   ");
                System.out.print(doctor.getValue().getTime()+"   ");
                System.out.print(doctor.getValue().getFee()+"   \n");
            }
            System.out.println("*** Registration ***");
            System.out.println("Enter the Paitent Name : ");
            String name=sc.next();
            System.out.println("Enter the Patient Age : ");
            byte age=sc.nextByte();
            System.out.println("Entet the Problem : ");
            String problem=sc.next();
            System.out.println("Enter the Date : ");
            String date=sc.next();
            System.out.println("*** Select Doctor by their Id ***");
            System.out.println("Please, Enter the doctor Id, you want to Consult : ");
            int doctorId=sc.nextInt();
            if(patientController.register(name,age,problem,date,doctorId)){
                System.out.println("Regitration Success...");
                System.out.println("Your Id : "+(patientController.getId()));
                loginView.patient(loginView);
            }
            else{System.out.println("Enter the valid age, try again...");
            registration(loginView);}
        }
        else
        {
            System.out.println("No Doctors Avalibale...");
            loginView.patient(loginView);
        }
        
    }

    public void checkDetails(LoginView loginView) {
        System.out.println("Enter your id to continue...");
        Patient patient=patientController.getPatientDetail(sc.nextInt());
        if(patient!=null)
        {
            System.out.println("Your Id : "+patient.getId());
            System.out.println("Patient Name :"+patient.getName());
            System.out.println("Patient Age : "+patient.getProblem());
            System.out.println("Date : "+patient.getDate());
            System.out.println("Status : "+(patient.isStatus()?"Appointed":"Not yet Appointed"));
        }
        else
        {
            System.out.println("Invalid Id...");
            loginView.patient(loginView);
        }
    }
    
}
