/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalmanagement.admin;

import com.hospitalmanagement.dto.Doctor;
import com.hospitalmanagement.dto.Patient;
import java.util.HashMap;

/**
 *
 * @author welcome
 */
public interface AdminModelCallBack {

    public void addDoctors(String name, String specialist, String time, byte slots, int fee);

    public HashMap<Integer, Doctor> getDoctorDetails();

    public boolean updateName(int doctorId, String name);

    public boolean updateSpecialist(int doctorId, String Specialist);

    public boolean updateTime(int doctorId, String time);

    public boolean updateSlots(int doctorId, byte slot);

    public boolean updateFee(int doctorId, int fee);

    public HashMap<Integer, Patient> getPatientsDetails();

    public void clearRecords();
    
}
