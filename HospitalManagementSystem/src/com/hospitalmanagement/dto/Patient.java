/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalmanagement.dto;

/**
 *
 * @author welcome
 */
public class Patient {
    private int id;
    private String name;
    private byte age;
    private String problem;
    private String date;
    private boolean status;
    private int doctorId;

    public Patient(int id,String name,byte age,String problem,String date,boolean status,int doctorId)  
    {
        this.id=id;
        this.name=name;
        this.age=age;
        this.problem=problem;
        this.date=date;
        this.status=status;
        this.doctorId=doctorId;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String Problem) {
        this.problem = Problem;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int doctorId() {
        return doctorId;
    }

    public void setPatientId(int patientId) {
        this.doctorId = patientId;
    }
    
}
