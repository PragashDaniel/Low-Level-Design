/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalmanagement.doctor;

import com.hospitalmanagament.hospitalrepository.HospitalRepository;
import com.hospitalmanagement.dto.Doctor;
import com.hospitalmanagement.dto.Patient;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author welcome
 */
public class DoctorModel implements DoctorModelCallBack{

    private DoctorControllerModelCallBack doctorControllerModelCallBack;
    
    DoctorModel(DoctorController doctorController) {
        this.doctorControllerModelCallBack=doctorController;
    }

    public Doctor getDoctorDetail(int id) {
        return HospitalRepository.getInstance().getDoctorsDetail(id);
    }

    @Override
    public void setNewPassword(int id,String password) {
        HospitalRepository.getInstance().setNewPassword(id,password);
    }

    @Override
    public boolean checkPassword(int id, String password) {
        return HospitalRepository.getInstance().checkPassword(id,password);
    }

    @Override
    public HashMap<Integer, Patient> getAllPatients(int id) {
         HashMap<Integer, Patient> patients=HospitalRepository.getInstance().getAllPatients();
         HashMap<Integer,Patient> particularPatients=new HashMap<>();
         for(Map.Entry<Integer,Patient> p:patients.entrySet())
         {
             if(p.getValue().doctorId()==id)
                 particularPatients.put(p.getKey(),p.getValue());
         }
         return particularPatients;
    }

    @Override
    public boolean approve(int id) {
        return HospitalRepository.getInstance().approve(id);
    }
    
}
