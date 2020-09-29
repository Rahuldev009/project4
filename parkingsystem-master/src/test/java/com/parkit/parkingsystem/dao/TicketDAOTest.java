package com.parkit.parkingsystem.dao;

import com.parkit.parkingsystem.config.DataBaseConfig;
import com.parkit.parkingsystem.constants.DBConstants;
import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.model.ParkingSpot;
import com.parkit.parkingsystem.model.Ticket;
import com.parkit.parkingsystem.util.InputReaderUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.sql.*;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TicketDAOTest {

    public DataBaseConfig dataBaseConfig = new DataBaseConfig();
    Connection con;
    TicketDAO ticketDAO = new TicketDAO();

    Ticket ticket;

    @Mock
    private static DataBaseConfig dbConfig;

    @BeforeEach
    void setUp() {
        con = null;
        ticket = new Ticket();
        Date inTime = new Date();
        inTime.setTime( System.currentTimeMillis() - (  60 * 60 * 1000) );
        Date outTime = new Date();
        ParkingSpot parkingSpot = new ParkingSpot(1, ParkingType.CAR,false);
        ticket.setParkingSpot(parkingSpot);
        ticket.setId(101);
        ticket.setVehicleRegNumber("abc123");
        ticket.setPrice(100.0);
        ticket.setInTime(inTime);
        ticket.setOutTime(outTime);


    }


    @Test
    void saveTicketTest() throws SQLException, ClassNotFoundException {
        con = dataBaseConfig.getConnection();
        PreparedStatement ps = con.prepareStatement(DBConstants.SAVE_TICKET);
        //ID, PARKING_NUMBER, VEHICLE_REG_NUMBER, PRICE, IN_TIME, OUT_TIME)
        //ps.setInt(1,ticket.getId());
        ps.setInt(1,ticket.getParkingSpot().getId());
        ps.setString(2, ticket.getVehicleRegNumber());
        ps.setDouble(3, ticket.getPrice());
        ps.setTimestamp(4, new Timestamp(ticket.getInTime().getTime()));
        ps.setTimestamp(5, (ticket.getOutTime() == null)?null: (new Timestamp(ticket.getOutTime().getTime())) );
        boolean result = ps.execute();
        dataBaseConfig.closeConnection(con);
        assertEquals(result,ticketDAO.saveTicket(ticket));


    }

    @Test
    void getTicketTest() throws SQLException, ClassNotFoundException {
        con = dataBaseConfig.getConnection();
        Ticket ticket1 = null;
        PreparedStatement ps = con.prepareStatement(DBConstants.GET_TICKET);
        //ID, PARKING_NUMBER, VEHICLE_REG_NUMBER, PRICE, IN_TIME, OUT_TIME)
        ps.setString(1,"ABCDEF");
        ResultSet rs = ps.executeQuery();
       // boolean result = ps.execute();
        if(rs.next()){
            ticket1 = new Ticket();
            ParkingSpot parkingSpot = new ParkingSpot(rs.getInt(1), ParkingType.valueOf(rs.getString(6)),false);
            ticket1.setParkingSpot(parkingSpot);
            ticket1.setId(rs.getInt(2));
            ticket1.setVehicleRegNumber("ABCDEF");
            ticket1.setPrice(rs.getDouble(3));
            ticket1.setInTime(rs.getTimestamp(4));
            ticket1.setOutTime(rs.getTimestamp(5));
        }
        dataBaseConfig.closeResultSet(rs);
        dataBaseConfig.closePreparedStatement(ps);
        dataBaseConfig.closeConnection(con);
        assertEquals(ticket1,ticketDAO.getTicket("ABCDEF"));
    }



   /* @Test
    void updateTicket() throws SQLException, ClassNotFoundException {
        con = dataBaseConfig.getConnection();
        PreparedStatement ps = con.prepareStatement(DBConstants.UPDATE_TICKET);
        ps.setDouble(1, ticket.getPrice());
        ps.setTimestamp(2, new Timestamp(ticket.getOutTime().getTime()));
        ps.setInt(3,ticket.getId());
        boolean result = ps.execute();
        System.out.println("result  ==== "+ result);
        dataBaseConfig.closeConnection(con);
        assertEquals(result,ticketDAO.updateTicket(ticket));

    }*/

    @Test
    void isRecurringTest() throws SQLException, ClassNotFoundException {
        boolean isRecurring = false;
        con = dataBaseConfig.getConnection();
        PreparedStatement ps = con.prepareStatement(DBConstants.IS_RECURRING);
        ps.setString(1,ticket.getVehicleRegNumber());
        ResultSet rs = ps.executeQuery();
        isRecurring = rs.next();
        dataBaseConfig.closeConnection(con);
        assertEquals(isRecurring,ticketDAO.isRecurring(ticket.getVehicleRegNumber()));

    }



    @Test
    void retriveTicketInfoTest() throws SQLException, ClassNotFoundException {
        con = dataBaseConfig.getConnection();
        boolean isDataPresent = false;
        PreparedStatement ps = con.prepareStatement(DBConstants.RETRIVE_TICKET_INFO);
        ps.setString(1,ticket.getVehicleRegNumber());
        ResultSet rs = ps.executeQuery();
        isDataPresent = rs.next();
        dataBaseConfig.closeConnection(con);
        assertEquals(isDataPresent,ticketDAO.retriveTicketInfo(ticket.getVehicleRegNumber()));

    }
    @Test
    void retriveTicketInfoTestforException() throws SQLException, ClassNotFoundException {
        boolean isDataPresent = false;
       /* con = dataBaseConfig.getConnection();
        PreparedStatement ps = con.prepareStatement(DBConstants.RETRIVE_TICKET_INFO);
        ps.setString(1,"vhbvjhb");
        ResultSet rs = ps.executeQuery();
        isDataPresent = rs.next();
        dataBaseConfig.closeConnection(con);*/
        when(dbConfig.getConnection()).thenThrow(Exception.class);
        assertEquals(isDataPresent,ticketDAO.retriveTicketInfo("cdcdd"));

    }
}