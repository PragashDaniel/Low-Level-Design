/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fms.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author welcome
 */
public class Repository {

    static private Repository repoInstance;
    private Connection con;

    private Repository() {
    }

    ;
    public static Repository getInstance() throws ClassNotFoundException, SQLException {
        if (repoInstance == null) {
            repoInstance = new Repository();
            repoInstance.dbConnection();
        }
        return repoInstance;
    }

    void dbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanagementsystem", "root", "pass123");
    }

    public boolean checkAdmin(Integer adminId, String passWord) throws SQLException {
        String query = "select password from admin where adminid =" + adminId;
        ResultSet rs = con.createStatement().executeQuery(query);
        if (rs.next()) {
            return rs.getString("password").equals(passWord);
        }
        return false;
    }

    public boolean checkUserCredentials(int userId, String passWord) throws SQLException {
        String query = "select password from user where userid =" + userId;
        ResultSet rs = con.createStatement().executeQuery(query);
        if (rs.next()) {
            return rs.getString("password").equals(passWord);
        }
        return false;
    }

    public int addUserData(String userName, String userDOB, String userMobileNo, Integer gender, String password) throws SQLException {
        String query = "INSERT INTO user VALUES(?,?,?,?,?,?)";
        String user = "select userid from userid";
        ResultSet rs = con.createStatement().executeQuery(user);
        rs.next();
        int userId = rs.getInt(1);
        String updateId = "UPDATE userid SET userid=?";
        PreparedStatement ps1 = con.prepareStatement(updateId);
        ps1.setInt(1, userId + 1);
        ps1.executeUpdate();
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, userId);
        ps.setString(2, userName);
        ps.setString(3, userMobileNo);
        ps.setString(4, password);
        ps.setString(5, gender == 2 ? "M" : "F");
        ps.setString(6, userDOB);
        if (ps.executeUpdate() != 0) {
            return userId;
        }
        return -1;
    }

    public boolean addNewFlight(Integer flightId, String flightName, String from,
            String to, int bSeats, int bPrice, int fSeats, int fPrice, int eSeats,
            int ePrice, long contNo, String DT) throws SQLException {
        String query = "INSERT INTO flight VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, flightId);
        ps.setString(2, flightName);
        ps.setString(3, from);
        ps.setString(4, to);
        ps.setString(5, DT);
        ps.setInt(6, bSeats);
        ps.setInt(7, bPrice);
        ps.setInt(8, fSeats);
        ps.setInt(9, fPrice);
        ps.setInt(10, eSeats);
        ps.setInt(11, ePrice);
        ps.setString(12, String.valueOf(contNo));
        return ps.executeUpdate() != 0;
    }

    public boolean deleteExistingFlight(int input) throws SQLException {
        String query = "DELETE FROM flight WHERE flightid=" + input;
        return con.prepareStatement(query).executeUpdate() != 0;
    }

    public ResultSet getAvailableFlights() throws SQLException {
        String query = "SELECT * FROM flight";
        ResultSet rs = con.createStatement().executeQuery(query);
        return rs;
    }

    public boolean cancelTicket(String passengerName, int flightId) {
        return true;
    }

    public boolean updateFlightName(int flightId, String flightName) throws SQLException {
        String query = "UPDATE FLIGHT SET flightname='" + flightName + "' WHERE flightid=" + flightId;
        return con.prepareStatement(query).executeUpdate() != 0;
    }

    public boolean updateFlightFrom(int flightId, String flightFrom) throws SQLException {
        String query = "UPDATE FLIGHT SET from='" + flightFrom + "' WHERE flightid=" + flightId;
        return con.prepareStatement(query).executeUpdate() != 0;

    }

    public boolean updateFlightTo(int flightId, String flightTo) throws SQLException {
        String query = "UPDATE FLIGHT SET to='" + flightTo + "' WHERE flightid=" + flightId;
        return con.prepareStatement(query).executeUpdate() != 0;
    }

    public boolean updateFlightDT(int flightId, String flightDT) throws SQLException {
        String query = "UPDATE FLIGHT SET dateandtime='" + flightDT + "' WHERE flightid=" + flightId;
        return con.prepareStatement(query).executeUpdate() != 0;
    }

    public boolean updateFlightBSeats(int flightId, int businessSeats) throws SQLException {
        String query = "UPDATE FLIGHT SET bseats='" + businessSeats + "' WHERE flightid=" + flightId;
        return con.prepareStatement(query).executeUpdate() != 0;
    }

    public boolean updateFlightBP(int flightId, int businessPrice) throws SQLException {
        String query = "UPDATE FLIGHT SET bprice='" + businessPrice + "' WHERE flightid=" + flightId;
        return con.prepareStatement(query).executeUpdate() != 0;
    }

    public boolean updateFirstClassSeats(int flightId, int firstClassSeats) throws SQLException {
        String query = "UPDATE FLIGHT SET fseats='" + firstClassSeats + "' WHERE flightid=" + flightId;
        return con.prepareStatement(query).executeUpdate() != 0;
    }

    public boolean updateFirstClassPrice(int flightId, int firstClassPrice) throws SQLException {
        String query = "UPDATE FLIGHT SET fprice='" + firstClassPrice + "' WHERE flightid=" + flightId;
        return con.prepareStatement(query).executeUpdate() != 0;
    }

    public boolean updateContNo(int flightId, String contNo) throws SQLException {
        String query = "UPDATE FLIGHT SET contno='" + contNo + "' WHERE flightid=" + flightId;
        return con.prepareStatement(query).executeUpdate() != 0;
    }

    public boolean updateEconomicePrice(int flightId, int ePrice) throws SQLException {
        String query = "UPDATE FLIGHT SET eprice='" + ePrice + "' WHERE flightid=" + flightId;
        return con.prepareStatement(query).executeUpdate() != 0;
    }

    public boolean updateFlightEconomicSeats(int flightId, int economicSeats) throws SQLException {
        String query = "UPDATE FLIGHT SET eseats='" + economicSeats + "' WHERE flightid=" + flightId;
        return con.prepareStatement(query).executeUpdate() != 0;
    }

    public int getPrice(int flightId, String price) throws SQLException {
        String query = "SELECT " + price + " FROM flight where flightid=" + flightId;
        ResultSet rs = con.createStatement().executeQuery(query);
        if (rs.next()) {
            System.out.println(rs.getInt(price));
            return rs.getInt(price);

        }
        return -1;
    }

    public ResultSet getFlightDetailById(int flightId) throws SQLException {
        String query = "Select * from flight where flightid=" + flightId;
        ResultSet rs = con.createStatement().executeQuery(query);
        return rs;
    }

    public int bookFlight(String name, String dob, String mobNo, int amount, String flightName, String cls, int flightId, String price, String seat) throws SQLException {
        String passenger = "select passengerid from passengerid";
        ResultSet rs = con.createStatement().executeQuery(passenger);
        rs.next();
        int passengerId = rs.getInt(1);
        String updateId = "UPDATE passengerid SET passengerid=?";
        PreparedStatement ps1 = con.prepareStatement(updateId);
        ps1.setInt(1, passengerId + 1);
        ps1.executeUpdate();
        String query = "INSERT INTO passenger VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, passengerId);
        ps.setString(2, name);
        ps.setString(3, dob);
        ps.setString(4, mobNo);
        ps.setString(5, flightName);
        ps.setString(6, cls);
        ps.setInt(7, flightId);
        ps.setInt(8, amount);

        String getSeats = "select " + seat + " from flight where flightid=" + flightId;
        ResultSet getSeat = con.createStatement().executeQuery(getSeats);
        getSeat.next();
        int currentSeat = getSeat.getInt(seat) - 1;

        String updateSeat = "UPDATE flight SET " + seat + " = " + currentSeat + " where flightid=" + flightId;
        PreparedStatement pSeat = con.prepareStatement(updateSeat);

        String getPrice = "select " + price + " from flight where flightid=" + flightId;
        ResultSet getFlightPrice = con.prepareStatement(getPrice).executeQuery();
        getFlightPrice.next();
        int currentPrice = getFlightPrice.getInt(price) + 100;

        String updatePrice = "UPDATE flight SET " + price + " = " + currentPrice + " where flightid=" + flightId;
        PreparedStatement pPrice = con.prepareStatement(updatePrice);

        if (ps.executeUpdate() != 0 && pSeat.executeUpdate() != 0 && pPrice.executeUpdate() != 0) {
            return passengerId;
        }
        return 0;
    }

    public boolean cancelBooking(int passengerFlightId, String price, String seat, int flightId) throws SQLException {
        String query = "DELETE FROM passenger where id=" + passengerFlightId;
        PreparedStatement ps = con.prepareStatement(query);

        String passenger = "select passengerid from passengerid";
        ResultSet rs = con.createStatement().executeQuery(passenger);
        rs.next();
        int passengerId = rs.getInt(1);
        String updateId = "UPDATE passengerid SET passengerid=?";
        PreparedStatement ps1 = con.prepareStatement(updateId);
        ps1.setInt(1, passengerId - 1);
        ps1.executeUpdate();

        String getSeats = "select " + seat + " from flight where flightid=" + flightId;
        ResultSet getSeat = con.createStatement().executeQuery(getSeats);
        getSeat.next();
        int currentSeat = getSeat.getInt(seat) + 1;

        String updateSeat = "UPDATE flight SET " + seat + " = " + currentSeat + " where flightid=" + flightId;
        PreparedStatement pSeat = con.prepareStatement(updateSeat);

        String getPrice = "select " + price + " from flight where flightid=" + flightId;
        ResultSet getFlightPrice = con.prepareStatement(getPrice).executeQuery();
        getFlightPrice.next();
        int currentPrice = getFlightPrice.getInt(price) - 100;

        String updatePrice = "UPDATE flight SET " + price + " = " + currentPrice + " where flightid=" + flightId;
        PreparedStatement pPrice = con.prepareStatement(updatePrice);

        return ps.executeUpdate() != 0 && pSeat.executeUpdate() != 0 && pPrice.executeUpdate() != 0;
    }

    public ResultSet getPassengerByFlight(int flightId) throws SQLException {
        String query = "select * from passenger where flightid=" + flightId;
        ResultSet rs = con.createStatement().executeQuery(query);
        return rs;
    }

    public ResultSet getFlightById(int flightId) throws SQLException {
        String query = "select * from flight where flightid=" + flightId;
        ResultSet rs = con.createStatement().executeQuery(query);
        return rs;
    }

    public ResultSet getPasssengerDetails(int passengerId) throws SQLException {
        String query = "select * from passenger where id=" + passengerId;
        ResultSet rs = con.createStatement().executeQuery(query);
        return rs;
    }
}
