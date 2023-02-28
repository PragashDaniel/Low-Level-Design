/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalmanagement.admin;

import com.hospitalmanagament.hospitalrepository.HospitalRepository;
import com.hospitalmanagement.dto.Doctor;
import com.hospitalmanagement.dto.Patient;
import java.util.HashMap;

/**
 *
 * @author welcome
 */
public class AdminModel implements AdminModelCallBack{

    AdminControllerModelCallBack adminController;
    AdminModel(AdminController adminController)
    {
        this.adminController=adminController;
    }
    
    @Override
    public void addDoctors(String name, String specialist, String time, byte slots, int fee) {
        HospitalRepository.getInstance().addDoctors(name,specialist,time,slots,fee);
    }

    @Override
    public HashMap<Integer, Doctor> getDoctorDetails() {
        return HospitalRepository.getInstance().getDoctorsDetails();
    }

    @Override
    public boolean updateName(int doctorId, String name) {
        return HospitalRepository.getInstance().updateName(doctorId,name);
    }

    @Override
    public boolean updateSpecialist(int doctorId, String specialist) {
        return HospitalRepository.getInstance().updateSpecialist(doctorId,specialist);
    }

    @Override
    public boolean updateTime(int doctorId, String time) {
        return HospitalRepository.getInstance().updateTime(doctorId,time);
    }

    @Override
    public boolean updateSlots(int doctorId, byte slot) {
        return HospitalRepository.getInstance().updateSlots(doctorId,slot);
    }

    @Override
    public boolean updateFee(int doctorId, int fee) {
        return HospitalRepository.getInstance().updateFee(doctorId,fee);
    }

    @Override
    public HashMap<Integer, Patient> getPatientsDetails() {
        return HospitalRepository.getInstance().getAllPatients();
    }

    @Override
    public void clearRecords() {
        HospitalRepository.getInstance().clearPatientsRecords();
    }
    
}
