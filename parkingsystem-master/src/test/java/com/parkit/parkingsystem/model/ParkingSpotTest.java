package com.parkit.parkingsystem.model;

import com.parkit.parkingsystem.constants.ParkingType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingSpotTest {

    private static ParkingSpot parkingSpot;


    @BeforeEach
    void setUp() {
        parkingSpot = new ParkingSpot(10,ParkingType.CAR,false);

    }



    @AfterEach
    void tearDown() {
    }



    @Test
    void setIdTest() {
        parkingSpot.setId(123);
        assertEquals(123,parkingSpot.getId());
    }



    @Test
    void setParkingTypeTest() {
        parkingSpot.setParkingType(ParkingType.BIKE);
        assertEquals(ParkingType.BIKE,parkingSpot.getParkingType());
    }

    @Test
    void isAvailableTest() {
        assertEquals(false,parkingSpot.isAvailable());
    }


    @Test
    void HashCodeTest() {
        assertEquals(10,parkingSpot.hashCode());
    }

    @Test
    void testEquals() {
    }
}