/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fms.booking;


import com.fms.repository.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author welcome
 */
public class BookingModel implements BookingModelCallBack{

    private BookingControllerModelCallBack bookingController;
    public BookingModel(BookingController bookingController)
    {
        this.bookingController=bookingController;
        
    }

    @Override
    public ResultSet availableFlightList() {
        try {
            return Repository.getInstance().getAvailableFlights();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BookingModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int getPrice(int flightId, String price) {
        try {
            return Repository.getInstance().getPrice(flightId,price);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BookingModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public boolean bookFlight(int flightId, String name, String dob, String mobNo, String seat, String cls,String price, int amount) {
        try {
            ResultSet rs=Repository.getInstance().getFlightDetailById(flightId);
            String flightName;
            if(rs.next())
            {   
                flightName=rs.getString(2);
                int passengerId=Repository.getInstance().bookFlight(name,dob,mobNo,amount,flightName,cls,flightId,price,seat);
                if(passengerId!=0)
                {
                    this.bookingController.bookedSuccess(passengerId,name,dob,mobNo,cls,amount,flightName);
                    return true;
                }
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BookingModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean cancelBooking(int passengerId,String price,String seat,int flightId) {
        try {
            return Repository.getInstance().cancelBooking(passengerId,price,seat,flightId);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BookingModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ResultSet getPassengerDetails(int passengerId) {
        try {
            return  Repository.getInstance().getPasssengerDetails(passengerId);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BookingModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ResultSet getFlightDetail(int flightId) {
         try {
            return  Repository.getInstance().getFlightById(flightId);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BookingModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
