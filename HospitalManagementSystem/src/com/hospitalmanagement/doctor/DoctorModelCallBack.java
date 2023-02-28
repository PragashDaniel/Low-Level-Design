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
public interface DoctorModelCallBack {

    public Doctor getDoctorDetail(int id);

    public void setNewPassword(int id,String password);

    public boolean checkPassword(int id, String password);

    public HashMap<Integer, Patient> getAllPatients(int id);

    public boolean approve(int id);

    
}
