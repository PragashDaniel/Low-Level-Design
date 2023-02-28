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
public class AdminController implements AdminControllerViewCallBack,AdminControllerModelCallBack{

    private AdminViewCallBack adminView;
    private AdminModelCallBack adminModel;
    
    AdminController(AdminView adminView)
    {
        this.adminView=adminView;
        this.adminModel=new AdminModel(this);
    }
    
    @Override
    public void addDoctors(String name, String specialist, String time, byte slots, int fee) {
        adminModel.addDoctors(name,specialist,time,slots,fee);
    }

    @Override
    public HashMap<Integer, Doctor> getDoctorDetails() {
        return adminModel.getDoctorDetails();
    }

    @Override
    public void updateName(int doctorId, String name,LoginView loginView) {
        if(adminModel.updateName(doctorId,name))
            return;
        adminView.updateFailed(loginView);
    }

    @Override
    public void updateSpecialist(int doctorId, String Specialist,LoginView loginView) {
        if(adminModel.updateSpecialist(doctorId,Specialist))
            return;
        adminView.updateFailed(loginView);
    }

    @Override
    public void updateTime(int doctorId, String time,LoginView loginView) {
        if(adminModel.updateTime(doctorId,time))
            return;
        adminView.updateFailed(loginView);
    }

    @Override
    public void updateSlots(int doctorId, byte slot,LoginView loginView) {
        if(adminModel.updateSlots(doctorId,slot))
            return;
        adminView.updateFailed(loginView);
    }

    @Override
    public void updateFee(int doctorId, int fee,LoginView loginView) {
        if(adminModel.updateFee(doctorId,fee))
            return;
        adminView.updateFailed(loginView);
    }

    @Override
    public HashMap<Integer, Patient> getPatientsDetails() {
        return this.adminModel.getPatientsDetails();
    }

    @Override
    public void clearRecords() {
        this.adminModel.clearRecords();
    }
    
}
