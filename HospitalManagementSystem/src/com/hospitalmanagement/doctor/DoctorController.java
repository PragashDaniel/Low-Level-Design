/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalmanagement.doctor;

import com.hospitalmanagement.dto.Doctor;
import com.hospitalmanagement.dto.Patient;
import java.util.HashMap;

/**
 *
 * @author welcome
 */
public class DoctorController implements DoctorControllerViewCallBack,DoctorControllerModelCallBack{

    private DoctorViewCallBack doctorViewCallBack;
    private DoctorModelCallBack doctorModelCallBack;
    
    DoctorController(DoctorView doctorView) {
        this.doctorViewCallBack=doctorView;
        this.doctorModelCallBack=new DoctorModel(this);
    }

    @Override
    public Doctor getDoctorDetail(int id) {
        return doctorModelCallBack.getDoctorDetail(id);
    }

    @Override
    public void setNewPassword(int id,String password) {
        this.doctorModelCallBack.setNewPassword(id,password);
    }

    @Override
    public boolean checkPassword(int id, String password) {
        return this.doctorModelCallBack.checkPassword(id,password);
    }

    @Override
    public HashMap<Integer, Patient> getAllPatients(int id) {
        return this.doctorModelCallBack.getAllPatients(id);
    }

    @Override
    public boolean approve(int id) {
        return this.doctorModelCallBack.approve(id);
    }
    
}
