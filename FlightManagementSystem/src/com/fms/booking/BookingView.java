/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fms.booking;

import com.fms.login.LoginView;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author welcome
 */
public class BookingView implements BookingViewCallBack {
    
    private BookingControllerViewCallBack bookingController;
    private Scanner sc=new Scanner(System.in);
    public BookingView()
    {
        this.bookingController=new BookingController(this);
    }
    public void firstPage(LoginView loginView) throws SQLException
    {
        System.out.println("-----------Welcome for Flight Booking-------------");
        System.out.println("1)Book");
        System.out.println("2)Cancel");
        System.out.println("3)View Booking Details");
        System.out.println("4)Sign Out");
        switch(sc.nextInt())
        {
            case 1:
            try {
                booking(loginView);
            } catch (SQLException ex) {
                Logger.getLogger(BookingView.class.getName()).log(Level.SEVERE, null, ex);
                firstPage(loginView);
            }
            break;
            case 2:
                cancel(loginView);
                break;
            case 3:
                viewBookingDetails(loginView);
                break;
            case 4:
                loginView.firstPage();
                break;
            default:
                System.out.println("Invalid Input...");
                firstPage(loginView);
        }
    }
    void booking(LoginView loginView) throws SQLException
    {
        ResultSet rs = bookingController.avaliableFlightList();
        System.out.println("*** Available Flights ***");
        System.out.println("Flight ID |" + "    Flight Name   |" + "   From   |" + "   To  |" + "     Date and Time  |"
                + "  Business Seats | BPrice | First Class Seats | FPrice | Ecnomice Class Seats | EPrice |    Contact   |");
        while (rs.next()) {
            System.out.print(rs.getString(1) + "   \t");
            System.out.print(rs.getString(2) + "   \t");
            System.out.print(rs.getString(3) + "   \t");
            System.out.print(rs.getString(4) + "   \t");
            System.out.print(rs.getString(5) + "   \t");
            System.out.print(rs.getString(6) + "   \t");
            System.out.print(rs.getString(7) + "   \t");
            System.out.print(rs.getString(8) + "   \t");
            System.out.print(rs.getString(9) + "   \t");
            System.out.print(rs.getString(10) + "   \t");
            System.out.print(rs.getString(11) + "   \t");
            System.out.print(rs.getString(12) + "   \n");
        }
        System.out.println("For back press 0,else to continue press any number...");
        if(sc.nextInt()==0)
        {firstPage(loginView);return;}
        System.out.println("For Booking Please Enter the flight ID : ");
        int flightId=sc.nextInt();
        System.out.println("Enter Passenger details...");
        System.out.println("Enter the name of Passenger : ");
        String name=sc.next();
        System.out.println("Enter the Date of Birth : ");
        String dob=sc.next();
        System.out.println("Enter the Mobile No : ");
        String mobNo=sc.next();
        System.out.println("Please Select the type of the Seat...");
        System.out.println("1)Business Class");
        System.out.println("2)First Class ");
        System.out.println("3)Economy Class");
        int no=sc.nextInt();
        String price,seat,cls;
        if(no==1){ price="bprice";seat="bseats";cls="BC";}
        else{ price=no==2?"fprice":"eprice";seat=no==2?"fseats":"eseats";cls=no==2?"FC":"EC";}
        int flightPrice=this.bookingController.getPrice(flightId,price);
        System.out.println("Your Booking Price : "+flightPrice);
        System.out.println("Please Pay the amount to continue...");
        int amount=sc.nextInt();
        if(amount==flightPrice)
        {
            System.out.println("To confirm booking press 1...");
            if(sc.nextInt()==1)
            {
                if(bookingController.bookFlight(flightId,name,dob,mobNo,seat,cls,price,amount))
                {
                    System.out.println("Booking Success...");
                    firstPage(loginView);
                }
                else
                    unSuccess(loginView);
            }
            else {
            System.out.println("Invalid Input try Again...");booking(loginView);}
        }else
        {
             System.out.println("Incorrect amount Entered...,Try again");
             booking(loginView);
        }
    }

    public void unSuccess(LoginView loginView)  {
        try {
            System.out.println("Unable to Book,Please enter the valid details..");
            firstPage(loginView);
        } catch (SQLException ex) {
            Logger.getLogger(BookingView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void bookedSuccess(int passengerId, String name, String dob, String mobNo, String cls, int amount, String flightName) {
        System.out.println("Your Id : "+passengerId);
        System.out.println("Name : "+name);
        System.out.println("Date of Birth : "+dob);
        System.out.println("Mobile Number : "+mobNo);
        System.out.println("Class : "+cls);
        System.out.println("Amount Paid : "+amount);
        System.out.println("Flight Name : "+flightName);
    }

    private void cancel(LoginView loginView) throws SQLException {
        System.out.println(" *** Welcom For Cancelation *** ");
        System.out.println("Please, Enter Your Passenger Id : ");
        int passengerId=sc.nextInt();
        System.out.println("Please Select the type of the Seat...");
        System.out.println("1)Business Class");
        System.out.println("2)First Class ");
        System.out.println("3)Economy Class");
        int no=sc.nextInt();
        String price,seat;
        if(no==1){ price="bprice";seat="bseats";}
        else{ price=no==2?"fprice":"eprice";seat=no==2?"fseats":"eseats";}
        System.out.println("Please, Enter the flightId : ");
        int flightId=sc.nextInt();
        if(this.bookingController.cancelBooking(passengerId,price,seat,flightId))
        {
            System.out.println("Canceled Successfully...");
            System.out.println("Money Refunded...");
            firstPage(loginView);
        }
        else
        {
            System.out.println("Invalid Passenger Id...");
            firstPage(loginView);
        }
    }

    private void viewBookingDetails(LoginView loginView) throws SQLException {
        System.out.println("Please, Enter the Passenger Id : ");
        int passengerId=sc.nextInt();
        ResultSet rs=this.bookingController.getpassengerDetails(passengerId);boolean next=rs.next();
        ResultSet flight=this.bookingController.getFlightDetail(rs.getInt(7));
        if(next && flight.next())
        {
            System.out.println("Passenger Id : "+rs.getInt(1));
            System.out.println("Passenger Name : "+rs.getString(2));
            System.out.println("Passenger DOB :"+rs.getString(3));
            System.out.println("Cont. No : "+rs.getString(4));
            System.out.println("Flight Name : "+rs.getString(5));
            System.out.println("Class : "+rs.getString(6));
            System.out.println("From :"+flight.getString(3));
            System.out.println("To : "+flight.getString(4));
            System.out.println("Date and Time : "+flight.getString(5));
            System.out.println("Amount Paid : "+rs.getString(8));
            firstPage(loginView);
        }
        else 
        {
            System.out.println("Invalid Input...");
            firstPage(loginView);
        }
    }

    
}
