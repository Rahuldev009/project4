package com.parkit.parkingsystem.config;

import com.parkit.parkingsystem.model.ParkingSpot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class DataBaseConfigTest {


    private static final Logger logger = LogManager.getLogger("DataBaseConfig");
    Connection con;

    @Mock
    private static DataBaseConfig dataBaseConfig;


    @BeforeEach
    void setUp() {
        dataBaseConfig = new DataBaseConfig();

    }

    @Test
    void getConnection() {
    }

    @Test
    void closeConnectionTest() {


    }


    @Test
    void closePreparedStatement() {
    }

    @Test
    void closeResultSet() {
    }
}