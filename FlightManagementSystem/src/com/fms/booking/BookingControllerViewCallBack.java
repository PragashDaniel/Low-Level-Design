/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fms.booking;

import java.sql.ResultSet;

/**
 *
 * @author welcome
 */
public interface BookingControllerViewCallBack 
{

    public ResultSet avaliableFlightList();

    public int getPrice(int flightId, String seat);

    public boolean bookFlight(int flightId, String name, String dob, String mobNo, String seat,String cls,String price, int amount);

    public boolean cancelBooking(int nextInt,String price,String seat,int flightId);

    public ResultSet getpassengerDetails(int passengerId);

    public ResultSet getFlightDetail(int aInt);
    
}
