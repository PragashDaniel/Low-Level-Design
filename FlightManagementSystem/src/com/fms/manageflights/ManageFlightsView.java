/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fms.manageflights;

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
public class ManageFlightsView implements ManageFlightsViewCallBack {

    private ManageFlightsControllerCallBack manageFlightsController;
    private Scanner sc = new Scanner(System.in);

    public ManageFlightsView() {
        this.manageFlightsController = new ManageFlightsController(this);
    }

    public void firstPage(LoginView loginView) {
        System.out.println("*** Welcome to FLIGHT MANAGEMENT SYSTEM  *** ");
        System.out.println("1)Add new Flights");
        System.out.println("2)Delete Flights");
        System.out.println("3)View Available Filghts");
        System.out.println("4)View Passengers Detils");
        System.out.println("5)Back");
        System.out.println("Enter a value to continue(E.g : 1)");
        int input = sc.nextInt();
        manageFlightsController.manageFlights(input, loginView);
    }

    public void addFlights(LoginView loginView) {
        System.out.println("*** Add new Flights *** ");
        System.out.println("Enter Flight ID :");
        Integer flightId = sc.nextInt();
        System.out.println("Enter the Name of the flight : ");
        String flightName = sc.next();
        System.out.println("From : ");
        String from = sc.next();
        System.out.println("To : ");
        String to = sc.next();
        System.out.println("Date & Time :  ");
        String DT = sc.next();
        System.out.println("Enter No. Of. Business Class Seats : ");
        int bSeats = sc.nextInt();
        System.out.println("Enter the price for Business Class Seats  : ");
        int bPrice = sc.nextInt();
        System.out.println("Enter No. Of. First Class Seats : ");
        int fSeats = sc.nextInt();
        System.out.println("Enter the price for First Class Seats  : ");
        int fPrice = sc.nextInt();
        System.out.println("Enter No. Of. Economic Seats : ");
        int eSeats = sc.nextInt();
        System.out.println("Enter the price for Economic Class Seats  : ");
        int ePrice = sc.nextInt();
        System.out.println("Enter the contact No. : ");
        long contNo = sc.nextLong();
        manageFlightsController.addNewFlight(flightId, flightName, from, to, bSeats, bPrice,
                fSeats, fPrice, eSeats, ePrice, contNo, DT, loginView);
    }

    public void flightAdded(LoginView loginView) {
        System.out.println("Flight Added SuccessFully... ");
        firstPage(loginView);
    }

    public void invalidFlightEntry(LoginView loginView) {
        System.out.println("Invalid Entry ..., Please try again");
        addFlights(loginView);
    }

    public void deleteFlights(LoginView loginView) {
        System.out.println("*** Delete Flight ***");
        System.out.println("Enter the flight id : ");
        manageFlightsController.deleteExistingFlight(sc.nextInt(), loginView);
    }

    public void deletionSuccess(LoginView loginView) {
        System.out.println("Data Successfully deleted...");
        firstPage(loginView);
    }

    public void deletionUnsuccess(LoginView loginView) {
        System.out.println("Unable to delete data, Please try again...");
        deleteFlights(loginView);
    }

    public void availableFlights(LoginView loginView) {
        ResultSet rs = manageFlightsController.avaliableFlightList();
        System.out.println("*** Available Flights ***");
        System.out.println("Flight ID |" + "    Flight Name   |" + "   From   |" + "   To  |" + "     Date and Time  |"
                + "  Business Seats | BPrice | First Class Seats | FPrice | Ecnomice Class Seats | EPrice |    Contact   |");
        try {
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
            System.out.println("For Update Press 1");
            System.out.println("For Back Press 2");
            if (sc.nextInt() == 1) {
                System.out.println("Enter the flight Id to update :  ");
                int flightId = sc.nextInt();
                System.out.println("1)FlightName");
                System.out.println("2)From");
                System.out.println("3)To");
                System.out.println("4)Date and Time");
                System.out.println("5)Business Seats");
                System.out.println("6)BPrice");
                System.out.println("7)First Class Seats");
                System.out.println("8)FPrice");
                System.out.println("9)Economic Seats");
                System.out.println("10)EP");
                System.out.println("11)Contact No");
                switch (sc.nextInt()) {
                    case 1:
                        System.out.println("Enter the new Flight Name : ");
                        String flightName = sc.next();
                        if (manageFlightsController.updateFlightName(flightId, flightName)) {
                            System.out.println("Updation Success...");
                            availableFlights(loginView);
                        }
                        else{System.out.println("Invalid Input...");availableFlights(loginView);}
                        break;
                    case 2:
                        System.out.println("Enter the new From : ");
                        String flightFrom = sc.next();
                        if (manageFlightsController.updateFlightFrom(flightId, flightFrom)) {
                            System.out.println("Updation Success...");
                            availableFlights(loginView);
                        }
                        else{System.out.println("Invalid Input...");availableFlights(loginView);}
                        break;
                    case 3:
                        System.out.println("Enter the new TO :");
                        String flightTo = sc.next();
                        if (manageFlightsController.updateFlightTo(flightId, flightTo)) {
                            System.out.println("Updation Success...");
                            availableFlights(loginView);
                        }
                        else{System.out.println("Invalid Input...");availableFlights(loginView);}
                        break;
                    case 4:
                        System.out.println("Enter the new Date & Time :");
                        String flightDT = sc.next();
                        if (manageFlightsController.updateFlightDT(flightId, flightDT)) {
                            System.out.println("Updation Success...");
                            availableFlights(loginView);
                        }
                        else{System.out.println("Invalid Input...");availableFlights(loginView);}
                        break;
                    case 5:
                        System.out.println("Enter the new Business Seats :");
                        int businessSeats = sc.nextInt();
                        if (manageFlightsController.updateFlightBSeats(flightId, businessSeats)) {
                            System.out.println("Updation Success...");
                            availableFlights(loginView);
                        }
                        else{System.out.println("Invalid Input...");availableFlights(loginView);}
                        break;
                    case 6:
                        System.out.println("Enter the new BP :");
                        int businessPrice = sc.nextInt();
                        if (manageFlightsController.updateFlightBP(flightId, businessPrice)) {
                            System.out.println("Updation Success...");
                            availableFlights(loginView);
                        }
                        else{System.out.println("Invalid Input...");availableFlights(loginView);}
                        break;
                    case 7:
                        System.out.println("Enter the new First Class Seats :");
                        int firstClassSeats = sc.nextInt();
                        if (manageFlightsController.updateFristClassSeats(flightId, firstClassSeats)) {
                            System.out.println("Updation Success...");
                            availableFlights(loginView);
                        }
                        else{System.out.println("Invalid Input...");availableFlights(loginView);}
                        break;
                    case 8:
                        System.out.println("Enter the new FPrice :");
                        int firstClassPrice = sc.nextInt();
                        if (manageFlightsController.updateFirstClassPrice(flightId, firstClassPrice)) {
                            System.out.println("Updation Success...");
                            availableFlights(loginView);
                        }
                        else{System.out.println("Invalid Input...");availableFlights(loginView);}
                        break;
                    case 9:
                        System.out.println("Enter the new Economic Class seats :  :");
                        int economicSeats = sc.nextInt();
                        if (manageFlightsController.updateFlightEconomicSeats(flightId, economicSeats)) {
                            System.out.println("Updation Success...");
                            availableFlights(loginView);
                        }
                        else{System.out.println("Invalid Input...");availableFlights(loginView);}
                        break;
                    case 10:
                        System.out.println("Enter the new EPrice :");
                        int ePrice = sc.nextInt();
                        if (manageFlightsController.updateEconomicPrice(flightId, ePrice)) {
                            System.out.println("Updation Success...");
                            availableFlights(loginView);
                        }
                        else{System.out.println("Invalid Input...");availableFlights(loginView);}
                        break;
                    case 11:
                        System.out.println("Enter the new Contact No  :");
                        String contNo = sc.next();
                        if (manageFlightsController.updateContNo(flightId, contNo)) {
                            System.out.println("Updation Success...");
                            availableFlights(loginView);
                        }
                        else{System.out.println("Invalid Input...");availableFlights(loginView);}
                        break;
                    default:
                        System.out.println("Invalid Input..");
                        availableFlights(loginView);
                }
            } else {
                firstPage(loginView);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManageFlightsView.class.getName()).log(Level.SEVERE, null, ex);
            firstPage(loginView);
        }
    }

    public void inValid(LoginView loginView) {
        System.out.println("Invalid Input ...");
        firstPage(loginView);
    }

    @Override
    public void back(LoginView loginView) {
        loginView.firstPage();
    }

    @Override
    public void viewPassengerDetails(LoginView loginView) {
        System.out.println("*** Flight List ***");
       ResultSet rs=this.manageFlightsController.getFlightDetails();
       System.out.println("Flight ID |" + "    Flight Name   |" + "   From   |" + "   To  |" + "     Date and Time  |"
                + "  Business Seats | BPrice | First Class Seats | FPrice | Ecnomice Class Seats | EPrice |    Contact   |");
        try {
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
        } catch (SQLException ex) {
            Logger.getLogger(ManageFlightsView.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Please Enter an flight id to see the passenger details : ");
        int flightId=sc.nextInt();
        ResultSet passengerList=this.manageFlightsController.getPassengerByFlight(flightId);
        ResultSet flightList= manageFlightsController.getFlightById(flightId);
        System.out.println("Passenger Id |     Name   |    DOB    |  Cont. No.   |   From  |  To  |  Date and Time  |  Seat   |");
        try {
            flightList.next();
            while(passengerList.next())
            {
                System.out.print(passengerList.getInt(1)+"\t");
                System.out.print(passengerList.getString(2)+"\t  ");
                System.out.print(passengerList.getString(3)+"  \t");
                System.out.print(passengerList.getString(4)+"\t");
                System.out.print(flightList.getString(3)+"\t");
                System.out.print(flightList.getString(4)+"\t");
                System.out.print(flightList.getString(5)+"\t");
                System.out.print(passengerList.getString(6)+"\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManageFlightsView.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("For Back press 0 ");
        if(sc.nextInt()==0)
            firstPage(loginView);
        else {
            System.out.println("Invalid Input...");firstPage(loginView);}
    }
}
