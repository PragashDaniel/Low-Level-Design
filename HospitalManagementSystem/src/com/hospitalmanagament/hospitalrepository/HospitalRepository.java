/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalmanagament.hospitalrepository;

import com.hospitalmanagement.dto.Doctor;
import com.hospitalmanagement.dto.Patient;
import java.util.HashMap;

/**
 *
 * @author welcome
 */
public class HospitalRepository {

    private static HospitalRepository hospitalRepository;
    private HashMap<Integer,Doctor> doctors=new HashMap<>();
    private HashMap<Integer,String> admin=new HashMap<>();
    private HashMap<Integer,Patient> patients=new HashMap<>();
    private static int doctorId,patientId;
    
    private HospitalRepository(){}
    public static HospitalRepository getInstance() {
      if(hospitalRepository==null)
      {
          hospitalRepository=new HospitalRepository();
          hospitalRepository.initialSetup();
      }
      return hospitalRepository;
    }

     private void initialSetup() {
         admin.put(1001, "admin");
     }
     
    public boolean checkAdminCredentials(int adminId, String password) {
        return admin.containsKey(adminId) && admin.get(adminId).equals(password);
    }

    public void addDoctors(String name, String specialist, String time, byte slots, int fee) {
        doctors.put(++doctorId, new Doctor(doctorId,name,specialist,time,slots,fee,null));
    }

    public HashMap<Integer, Doctor> getDoctorsDetails() {
        return doctors;
    }

    public boolean updateName(int doctorId, String name) {
        if(doctors.containsKey(doctorId)){
            doctors.get(doctorId).setName(name);return true;}
                    return false;
    }

    public boolean updateSpecialist(int doctorId, String specialist) {
        if(doctors.containsKey(doctorId)){
            doctors.get(doctorId).setSpecialist(specialist);return true;}
        return false;
    }

    public boolean updateTime(int doctorId, String time) {
        if(doctors.containsKey(doctorId)){
            doctors.get(doctorId).setTime(time);return true;}
        return false;
    }

    public boolean updateSlots(int doctorId, byte slot) {
        if(doctors.containsKey(doctorId)){
            doctors.get(doctorId).setSlots(slot);return true;}
        return false;
    }

    public boolean updateFee(int doctorId, int fee) {
        if(doctors.containsKey(doctorId)){
            doctors.get(doctorId).setFee(fee);return true;}
        return false;
    }

    public boolean register(String name, byte age, String problem, String date,int doctorId) {
        if(doctors.containsKey(doctorId))
        {
            patients.put(++patientId,new Patient(patientId,name,age,problem,date,false,doctorId));
            doctors.get(doctorId).setSlots((byte)(doctors.get(doctorId).getSlots()-1));
            return true;}
        return true;
    }

    public int getId() {
        return patientId;
    }

    public Patient getPatientDetail(int patientId) {
        if(patients.containsKey(patientId))
            return patients.get(patientId);
        return null;
    }

    public Doctor getDoctorsDetail(int id) {
        if(doctors.containsKey(id))
            return doctors.get(id);
        return null;
    }

    public void setNewPassword(int id,String password) {
        doctors.get(id).setPassword(password);
    }

    public boolean checkPassword(int id, String password) {
        return doctors.containsKey(id) && doctors.get(id).getPassword().equals(password);
    }

    public HashMap<Integer, Patient> getAllPatients() {
        return patients;
    }

    public boolean approve(int id) {
        if(patients.containsKey(id)){
            patients.get(id).setStatus(true);
            return true;}
        return false;
    }

    public void clearPatientsRecords() {
        this.patients.clear();
    }
    
}
