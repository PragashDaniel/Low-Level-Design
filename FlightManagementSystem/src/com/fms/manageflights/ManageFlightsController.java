/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fms.manageflights;

import com.fms.login.LoginView;
import java.sql.ResultSet;
/**
 *
 * @author welcome
 */
public class ManageFlightsController implements ManageFlightsControllerCallBack,ManageFlightControllerModelCallBack
{
    private ManageFlightsViewCallBack manageFlightsView;
    private ManageFlightsModelCallBack manageFlightModel;
    
    public ManageFlightsController(ManageFlightsView manageFlightsView)
    {
        this.manageFlightModel=new ManageFlightsModel(this);
        this.manageFlightsView=manageFlightsView;
    }

    public void manageFlights(int input,LoginView loginView) {
        manageFlightModel.manageFlights(input,loginView);
    }

    public void addFlights(LoginView loginView) {
        manageFlightsView.addFlights(loginView);
    }

    public void addNewFlight(Integer flightId, String flightName, String from, 
                            String to,int bSeats,int bPrice,int fSeats,int fPrice,
                            int eSeats,int ePrice,long contNo,String DT, LoginView loginView) {
        manageFlightModel.addNewFlight(flightId,flightName,from,to,bSeats,bPrice,
                                        fSeats,fPrice,eSeats,ePrice,contNo,DT,loginView);
    }

    public void flightAdded(LoginView loginView) {
        manageFlightsView.flightAdded(loginView);
    }

    public void invalidFlightEntry(LoginView loginView) {
        manageFlightsView.invalidFlightEntry(loginView);
    }

    public void deleteFlights(LoginView loginView) {
        manageFlightsView.deleteFlights(loginView);
    }

    public void deleteExistingFlight(int input,LoginView loginView) {
        manageFlightModel.deleteExistingFlight(input,loginView);
    }

    public void deletionSuccess(LoginView loginView) {
        manageFlightsView.deletionSuccess(loginView);
    }

    public void deletionUnsuccess(LoginView loginView) {
        manageFlightsView.deletionUnsuccess(loginView);
    }

    public void availableFlights(LoginView loginView) {
        manageFlightsView.availableFlights(loginView);
    }

    public ResultSet avaliableFlightList() {
       return  manageFlightModel.avaliableFlightsList();
    }

    public void inValid(LoginView loginView) {
        manageFlightsView.inValid(loginView);
    }

    @Override
    public void back(LoginView loginView) {
        manageFlightsView.back(loginView);
    }
    
    @Override
    public boolean updateFlightName(int flightId, String flightName) {
        return manageFlightModel.updateFlightName(flightId,flightName);
    }

    @Override
    public boolean updateFlightFrom(int flightId, String flightFrom) {
        return manageFlightModel.updateFlightFrom(flightId,flightFrom);
    }

    @Override
    public boolean updateFlightTo(int flightId, String flightTo) {
        return manageFlightModel.updateFlightTo(flightId,flightTo);
    }

    @Override
    public boolean updateFlightDT(int flightId, String flightDT) {
        return manageFlightModel.updateFlightDT(flightId,flightDT);
    }

    @Override
    public boolean updateFlightBSeats(int flightId, int businessSeats) {
        return manageFlightModel.updateFlightBSeats(flightId,businessSeats);
    }

    @Override
    public boolean updateFlightBP(int flightId, int businessPrice) {
        return manageFlightModel.updateFlightBP(flightId,businessPrice);
    }

    @Override
    public boolean updateFristClassSeats(int flightId, int firstClassSeats) {
        return manageFlightModel.updateFirstClassSeats(flightId,firstClassSeats);
    }

    @Override
    public boolean updateFirstClassPrice(int flightId, int firstClassPrice) {
        return manageFlightModel.updateFirstClassPrice(flightId,firstClassPrice);
    }

    @Override
    public boolean updateFlightEconomicSeats(int flightId, int economicSeats) {
        return manageFlightModel.updateFlightEconomicSeats(flightId,economicSeats);
    }

    @Override
    public boolean updateEconomicPrice(int flightId,int ePrice) {
        return manageFlightModel.updateEconomicPrice(flightId,ePrice);
    }

    @Override
    public boolean updateContNo(int flightId,String contNo) {
        return manageFlightModel.updateContNo(flightId,contNo);
    }

    @Override
    public void viewPassengerDetails(LoginView loginView) {
        this.manageFlightsView.viewPassengerDetails(loginView);
    }

    @Override
    public ResultSet getFlightDetails() {
        return this.manageFlightModel.getFlightDetails();
    }

    @Override
    public ResultSet getPassengerByFlight(int flightId) {
        return this.manageFlightModel.getPassengerByFlight(flightId);
    }

    @Override
    public ResultSet getFlightById(int flightId) {
        return this.manageFlightModel.getFlightById(flightId);
    }
}
