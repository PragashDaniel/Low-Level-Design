/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalmanagement.patient;

import com.hospitalmanagament.hospitalrepository.HospitalRepository;
import com.hospitalmanagement.dto.Doctor;
import com.hospitalmanagement.dto.Patient;
import java.util.HashMap;

/**
 *
 * @author welcome
 */
public class PatientModel implements PatientModelCallBack{

    private PatientControllerModelCallBack patientControllerModelCallBack; 
    PatientModel(PatientController patientController) {
        this.patientControllerModelCallBack=patientController;
    }

    @Override
    public boolean register(String name, byte age, String problem, String date,int doctorId) {
        if(HospitalRepository.getInstance().getDoctorsDetail(doctorId).getSlots()>0)
            return HospitalRepository.getInstance().register(name,age,problem,date,doctorId);
        return false;
    }

    @Override
    public int getId() {
        return HospitalRepository.getInstance().getId();
    }

    @Override
    public Patient getPatientDetail(int patientId) {
        return HospitalRepository.getInstance().getPatientDetail(patientId);
    }

    @Override
    public HashMap<Integer, Doctor> getDoctors() {
        return HospitalRepository.getInstance().getDoctorsDetails();
    }
    
}
