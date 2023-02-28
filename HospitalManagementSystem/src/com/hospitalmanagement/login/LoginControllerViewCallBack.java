/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalmanagement.login;

/**
 *
 * @author welcome
 */
public interface LoginControllerViewCallBack {

    public boolean checkAdminCredentials(int adminId, String adminPassword);
    
}
