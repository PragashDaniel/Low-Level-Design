/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalmanagement.patient;

import com.hospitalmanagement.dto.Doctor;
import com.hospitalmanagement.dto.Patient;
import java.util.HashMap;

/**
 *
 * @author welcome
 */
public interface PatientModelCallBack {

    public boolean register(String name, byte age, String problem, String date,int doctorId);

    public int getId();

    public Patient getPatientDetail(int patientId);

    public HashMap<Integer, Doctor> getDoctors();
    
}
