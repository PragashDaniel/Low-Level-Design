/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.repository;

import com.bank.dto.Admin;
import com.bank.dto.User;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author welcome
 */
public class BankRepository {
    
    private HashMap<Integer, Long> amount = new HashMap<>();
    private HashMap<Integer, String> branch = new HashMap<>();
    private HashMap<Integer, User> user = new HashMap<>();
    private HashMap<Integer, Admin> admin = new HashMap<>();
    private static BankRepository bankRepoInstance;
    private static Integer userId = 0;
    
    private BankRepository() {
    }
    
    public static BankRepository getInstance() {
        if (bankRepoInstance == null) {
            bankRepoInstance = new BankRepository();
            bankRepoInstance.initialSetup();
        }
        return bankRepoInstance;
    }
    
    void initialSetup() {
        defaultBranches();
        defaultadmins();
    }
    
    void defaultBranches() {
        branch.put(1, "Tirunelveli");
        branch.put(2, "Tenkasi");
        branch.put(3, "Madurai");
        branch.put(4, "Chennai");
        branch.put(5, "Covai");
    }
    
    void defaultadmins() {
        admin.put(1001, new Admin(1001, "Pragash Daniel P", "root"));
        admin.put(1002, new Admin(1002, "Livis Roy", "root"));
    }
    
    public HashMap<Integer, String> branches() {
        return branch;
    }
    
    public HashMap<Integer, User> registeredUser() {
        return user;
    }
    
    public void addData(String firstName, String lastName, Date dob, Long mobileNo, Integer gender, Integer branch, String password, String reEnteredPassword) {
        user.put(++userId, new User(userId, firstName, lastName, dob, mobileNo, gender, this.branch.get(branch), password, reEnteredPassword,false));
    }
    
    public int getId() {
        return userId;
    }
    
    public User getDetail(int id) {
        return user.get(id);
    }
    
    public void editUserName(String firstName, String lastName, int id) {
        user.get(id).setFirstName(firstName);
        user.get(id).setLastName(lastName);
    }
    
    public void editDOB(Date dob, int id) {
        user.get(id).setDob(dob);
    }
    
    public void editMobileNo(long mobileNumber, int id) {
        
        user.get(id).setMobileNo(mobileNumber);
        
    }
    
    public void editBranch(Integer branch, int id) {
        user.get(id).setBranch(this.branch.get(branch));
    }
    
    public void editGender(Integer gender, int id) {
        
        user.get(id).setBranch((gender == 1) ? "Female" : "Male");
        
    }
    
    public boolean checkStatus(int id) {
        if(user.containsKey(id))
            return user.get(id).getStatus();       
        return false;
    }
    
    public boolean deposit(int id, long amount) {
        this.amount.put(id, amount);
        return true;
    }
    
    public long getBalance(int id) {
        if(amount.get(id)!=null)
            return this.amount.get(id);
        else 
            return 0;
    }
    
    public void setAmount(int id, long balance) {
        this.amount.put(id, balance);
    }
    
    public boolean checkBranch(int branch) {
        return this.branch.containsKey(branch);
    }
    
    public boolean containsAdminId(int adminId) {
        return admin.containsKey(adminId);
    }
    
    public boolean containsAdminPassword(int adminId, String adminPassword) {
        return admin.get(adminId).getAdminPassword().equals(adminPassword);
    }

    public HashMap<Integer,Long> getTotalBankBalanceList() {
        return amount;
    }

    public HashMap<Integer,User> getUsers() {
        return user;
    }

    public boolean deleteUser(int userId) {
        if(user.containsKey(userId))
        {
            user.remove(userId);
            return true;
        }
        return false;
    }

    public boolean approveUser(int id) {
        if(user.containsKey(id))
        {
            user.get(id).setStatus(true);
            return true;
        }
        else 
            return false;
    }

    public boolean checkId(int id, int receiverId, long amount) 
    {
        return user.containsKey(id) && user.containsKey(receiverId);
    }
    
}
