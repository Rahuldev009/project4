package com.parkit.parkingsystem.dao;

import com.parkit.parkingsystem.config.DataBaseConfig;
import com.parkit.parkingsystem.constants.DBConstants;
import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.model.ParkingSpot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ParkingSpotDAOTest {
    public DataBaseConfig dataBaseConfig = new DataBaseConfig();
    ParkingSpot parkingSpot = new ParkingSpot(1, ParkingType.CAR,false);
    ParkingSpotDAO parkingSpotDAO = new ParkingSpotDAO();
    Connection con = null;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getNextAvailableSlot() {
    }

    @Test
    void updateParkingTest() throws SQLException, ClassNotFoundException {
        con = dataBaseConfig.getConnection();
        PreparedStatement ps = con.prepareStatement(DBConstants.UPDATE_PARKING_SPOT);
        ps.setBoolean(1, parkingSpot.isAvailable());
        ps.setInt(2, parkingSpot.getId());
        int updateRowCount = ps.executeUpdate();
        dataBaseConfig.closePreparedStatement(ps);
       boolean result = (updateRowCount == 1);
        dataBaseConfig.closeConnection(con);
        assertEquals(result,parkingSpotDAO.updateParking(parkingSpot));
    }

    @Test
    void checkParking() throws SQLException, ClassNotFoundException {
        int result = -1;
        boolean resultReturn = true;
        con = dataBaseConfig.getConnection();
        PreparedStatement ps = con.prepareStatement(DBConstants.CHECK_PARKING);
        ps.setInt(1, parkingSpot.getId());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            result = rs.getInt(1);
        }
        if (result == 0)
        {
             resultReturn = false;
        }
        dataBaseConfig.closeConnection(con);
        assertEquals(resultReturn,parkingSpotDAO.checkParking(parkingSpot));

    }
}