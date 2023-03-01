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
interface ManageFlightsModelCallBack {

    public void manageFlights(int input, LoginView loginView);

    public void addNewFlight(Integer flightId, String flightName, String from,
            String to, int bSeats, int bPrice, int fSeats, int fPrice, int eSeats,
            int ePrice, long contNo, String DT, LoginView loginView);

    public void deleteExistingFlight(int input, LoginView loginView);

    public ResultSet avaliableFlightsList();

    public boolean updateFlightName(int flightId, String flightName);

    public boolean updateFlightFrom(int flightId, String flightFrom);

    public boolean updateFlightTo(int flightId, String flightTo);

    public boolean updateFlightDT(int flightId, String flightDT);

    public boolean updateFlightBSeats(int flightId, int businessSeats);

    public boolean updateFlightBP(int flightId, int businessPrice);

    public boolean updateFirstClassSeats(int flightId, int firstClassSeats);

    public boolean updateFirstClassPrice(int flightId, int firstClassPrice);

    public boolean updateFlightEconomicSeats(int flightId, int economicSeats);

    public boolean updateEconomicPrice(int flightId, int ePrice);

    public boolean updateContNo(int flightId, String contNo);

    public ResultSet getFlightDetails();

    public ResultSet getPassengerByFlight(int flightId);

    public ResultSet getFlightById(int flightId);

}
