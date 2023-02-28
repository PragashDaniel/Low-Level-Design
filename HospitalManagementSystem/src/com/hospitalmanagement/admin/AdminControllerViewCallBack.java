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

/**
 *
 * @author welcome
 */
public interface AdminControllerViewCallBack {

    public void addDoctors(String name, String specialist, String time, byte slots, int fee);

    public HashMap<Integer, Doctor> getDoctorDetails();

    public void updateName(int doctorId, String next,LoginView loginView);

    public void updateSpecialist(int doctorId, String next,LoginView loginView);

    public void updateTime(int doctorId, String next,LoginView loginView);

    public void updateSlots(int doctorId,byte  next,LoginView loginView);

    public void updateFee(int doctorId, int nextInt,LoginView loginView);

    public HashMap<Integer, Patient> getPatientsDetails();

    public void clearRecords();
    
}
