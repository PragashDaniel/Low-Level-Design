/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fms.booking;

import com.fms.login.LoginView;
import java.sql.ResultSet;

/**
 *
 * @author welcome
 */
public class BookingController implements BookingControllerViewCallBack,BookingControllerModelCallBack{

    private  BookingModelCallBack bookingModel;
    private BookingViewCallBack bookingView;
    
    public BookingController(BookingView bookingView)
    {
        this.bookingView=bookingView;
        this.bookingModel=new BookingModel(this);
    }


    public void bookedUnsuccess(LoginView loginView) {
        bookingView.unSuccess(loginView);
    }
    
    @Override
    public ResultSet avaliableFlightList() {
        return this.bookingModel.availableFlightList();
    }

    @Override
    public int getPrice(int flightId, String seat) {
        return this.bookingModel.getPrice(flightId,seat);
    }

    @Override
    public boolean bookFlight(int flightId, String name, String dob, String mobNo, String seat,String cls,String price, int amount) {
        if(mobNo.length()!=10)
            return false;
        return this.bookingModel.bookFlight(flightId, name, dob,mobNo, seat ,cls,price,amount);
    }


    @Override
    public void bookedSuccess(int passengerId, String name, String dob, String mobNo, String cls, int amount, String flightName) {
        this.bookingView.bookedSuccess(passengerId,name,dob,mobNo,cls,amount,flightName);
    }

    @Override
    public boolean cancelBooking(int passengerId,String price,String seat,int flightId) {
        return this.bookingModel.cancelBooking(passengerId,price,seat,flightId);
    }

    @Override
    public ResultSet getpassengerDetails(int passengerId) {
        return this.bookingModel.getPassengerDetails(passengerId);
    }

    @Override
    public ResultSet getFlightDetail(int flightId) {
        return this.bookingModel.getFlightDetail(flightId);
    }


}
