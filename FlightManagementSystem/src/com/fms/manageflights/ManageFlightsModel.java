/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fms.manageflights;

import com.fms.login.LoginView;
import com.fms.repository.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author welcome
 */
public class ManageFlightsModel implements ManageFlightsModelCallBack
{
    private ManageFlightControllerModelCallBack manageFlightsController;
    public ManageFlightsModel(ManageFlightsController manageFlightsController)
    {
        this.manageFlightsController=manageFlightsController;
    }

    @Override
    public void manageFlights(int input,LoginView loginView) {
        if(input==1)
        {manageFlightsController.addFlights(loginView);}
        else if(input==2)
        {manageFlightsController.deleteFlights(loginView);}
        else if(input==3)
        {manageFlightsController.availableFlights(loginView);}
        else if(input==4)
        {manageFlightsController.viewPassengerDetails(loginView);}
        else if(input==5)
        {manageFlightsController.back(loginView);}
        else  
        {manageFlightsController.inValid(loginView);}
    }

    @Override
    public void addNewFlight(Integer flightId, String flightName, String from, 
                        String to,int bSeats,int bPrice,int fSeats,int fPrice,int eSeats,
                        int ePrice,long contNo,String DT,LoginView loginView) {
        try {
            if(Repository.getInstance().addNewFlight(flightId,flightName,from,to,bSeats,bPrice,
                    fSeats,fPrice,eSeats,ePrice,contNo,DT))
                manageFlightsController.flightAdded(loginView);
            else
                manageFlightsController.invalidFlightEntry(loginView);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageFlightsModel.class.getName()).log(Level.SEVERE, null, ex);
            manageFlightsController.invalidFlightEntry(loginView);
        }
    }

    @Override
    public void deleteExistingFlight(int input,LoginView loginView) {
        try {
            if(Repository.getInstance().deleteExistingFlight(input))
                manageFlightsController.deletionSuccess(loginView);
            else
                manageFlightsController.deletionUnsuccess(loginView);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageFlightsModel.class.getName()).log(Level.SEVERE, null, ex);
            manageFlightsController.deletionUnsuccess(loginView);
        }
    }

    @Override
    public ResultSet avaliableFlightsList() {
        try {
            return Repository.getInstance().getAvailableFlights();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageFlightsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean updateFlightName(int flightId, String flightName) {
        try {
            return Repository.getInstance().updateFlightName(flightId,flightName);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageFlightsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateFlightFrom(int flightId, String flightFrom) {
        try {
            return Repository.getInstance().updateFlightFrom(flightId,flightFrom);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageFlightsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateFlightTo(int flightId, String flightTo) {
        try {
            return Repository.getInstance().updateFlightTo(flightId,flightTo);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageFlightsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateFlightDT(int flightId, String flightDT) {
        try {
            return Repository.getInstance().updateFlightDT(flightId,flightDT);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageFlightsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateFlightBSeats(int flightId, int businessSeats) {
        try {
            return Repository.getInstance().updateFlightBSeats(flightId,businessSeats);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageFlightsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateFlightBP(int flightId, int businessPrice) {
        try {
            return Repository.getInstance().updateFlightBP(flightId,businessPrice);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageFlightsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateFirstClassSeats(int flightId, int firstClassSeats) {
        try {
            return Repository.getInstance().updateFirstClassSeats(flightId,firstClassSeats);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageFlightsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateFirstClassPrice(int flightId, int firstClassPrice) {
        try {
            return Repository.getInstance().updateFirstClassPrice(flightId,firstClassPrice);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageFlightsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateFlightEconomicSeats(int flightId, int economicSeats) {
        try {
            return Repository.getInstance().updateFlightEconomicSeats(flightId,economicSeats);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageFlightsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateEconomicPrice(int flightId, int ePrice) {
        try {
            return Repository.getInstance().updateEconomicePrice(flightId,ePrice);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageFlightsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateContNo(int flightId, String contNo) {
        try {
            return Repository.getInstance().updateContNo(flightId,contNo);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageFlightsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ResultSet getFlightDetails() {
        try {
            return Repository.getInstance().getAvailableFlights();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageFlightsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ResultSet getPassengerByFlight(int flightId) {
        try {
            return Repository.getInstance().getPassengerByFlight(flightId);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageFlightsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ResultSet getFlightById(int flightId) {
        try {
            return Repository.getInstance().getFlightById(flightId);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageFlightsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
}
