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
public class PatientController implements PatientControllerViewCallBack,PatientControllerModelCallBack {

    private PatientViewCallBack patientViewCallBack;
    private PatientModelCallBack patientModelCallBack;
    
    PatientController(PatientView patientView) {
        this.patientViewCallBack=patientView;
        this.patientModelCallBack=new PatientModel(this);
    }

    @Override
    public boolean register(String name, byte age, String problem, String date,int doctorId) {
        if(age>=1 && age<=100)
            return patientModelCallBack.register(name,age,problem,date,doctorId);
        return false;
        
    }

    @Override
    public int getId() {
        return patientModelCallBack.getId();
    }

    @Override
    public Patient getPatientDetail(int patientId) {
        return patientModelCallBack.getPatientDetail(patientId);
    }

    @Override
    public HashMap<Integer, Doctor> getDoctors() {
        return this.patientModelCallBack.getDoctors();
    }
    
}
