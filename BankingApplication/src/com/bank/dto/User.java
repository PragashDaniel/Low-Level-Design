/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.dto;

import java.util.Date;

/**
 *
 * @author welcome
 */
public class User{

    private Integer Id;
    private String firstName;
    private String lastName;
    private Date dob;
    private Long mobileNo;
    private String gender;
    private String branch;
    private String password;
    private boolean status;
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public User(Integer userId,String firstName, String lastName, Date dob, Long mobileNo, 
                Integer gender, String branch, String password, String reEnteredPassword,boolean status) {
        this.Id=userId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.dob=dob;
        this.mobileNo=mobileNo;
        this.gender=(gender==1)?"Female":"Male";
        this.branch=branch;
        this.password=password;
        this.status=status;
        }

    public User(Integer userId,String firstName, String lastName, Date dob, Long mobileNo, 
                String gender, String branch)
    {
        this.Id=userId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.dob=dob;
        this.mobileNo=mobileNo;
        this.gender=gender;
        this.branch=branch;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public Date getDob() {
        return dob;
    }


    public Long getMobileNo() {
        return mobileNo;
    }


    public String getGender() {
        return gender;
    }


    public String getBranch() {
        return branch;
    }


    public String getPassword() {
        return password;
    }


    public Integer getUserId() {
        return Id;
    }


    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
}
