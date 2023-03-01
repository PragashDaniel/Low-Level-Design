
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fms.manageflights;

import com.fms.login.LoginView;

/**
 *
 * @author welcome
 */
interface ManageFlightControllerModelCallBack {

    public void addFlights(LoginView loginView);

    public void deleteFlights(LoginView loginView);

    public void availableFlights(LoginView loginView);

    public void inValid(LoginView loginView);

    public void flightAdded(LoginView loginView);

    public void invalidFlightEntry(LoginView loginView);

    public void deletionSuccess(LoginView loginView);

    public void deletionUnsuccess(LoginView loginView);

    public void back(LoginView loginView);

    public void viewPassengerDetails(LoginView loginView);
    
}
