/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fms.booking;

import com.fms.login.LoginView;

/**
 *
 * @author welcome
 */
public interface BookingViewCallBack 
{
    public void unSuccess(LoginView loginView);

    public void bookedSuccess(int passengerId, String name, String dob, String mobNo, String cls, int amount, String flightName);
    
}
