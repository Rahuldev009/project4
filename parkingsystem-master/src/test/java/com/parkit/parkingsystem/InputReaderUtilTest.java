package com.parkit.parkingsystem;

import com.parkit.parkingsystem.util.InputReaderUtil;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class InputReaderUtilTest {
    private  static InputReaderUtil inputReaderUtil;






    @Test
    public void readSelectionTest(){
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        inputReaderUtil = new InputReaderUtil();

        assertEquals(1, inputReaderUtil.readSelection());


    }

    @Test
    public void readVehicleRegistrationNumberTest() throws Exception {

        String input = "ABCDEF";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        inputReaderUtil = new InputReaderUtil();

        assertEquals("ABCDEF", inputReaderUtil.readVehicleRegistrationNumber());

    }
}
