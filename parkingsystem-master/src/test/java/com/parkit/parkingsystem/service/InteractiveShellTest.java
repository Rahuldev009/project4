package com.parkit.parkingsystem.service;

import com.parkit.parkingsystem.dao.ParkingSpotDAO;
import com.parkit.parkingsystem.dao.TicketDAO;
import com.parkit.parkingsystem.service.InteractiveShell;
import com.parkit.parkingsystem.util.InputReaderUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InteractiveShellTest {
    private static InteractiveShell interactiveShell;
    InputReaderUtil inputReaderUtil ;
    ParkingSpotDAO parkingSpotDAO = new ParkingSpotDAO();
    TicketDAO ticketDAO = new TicketDAO();
    ParkingService parkingService = new ParkingService(inputReaderUtil, parkingSpotDAO, ticketDAO);
    boolean continueApp = true;


    @BeforeEach
    void setUp() {



    }

    @AfterEach
    void tearDown() {
    }

  /*  @Test
    void loadInterfaceTest() {
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        inputReaderUtil = new InputReaderUtil();
        InteractiveShell.loadInterface();


    }*/


}