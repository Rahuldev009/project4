package com.parkit.parkingsystem;

import com.parkit.parkingsystem.util.InputReaderUtil;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class InputReaderUtilTest {
    private  static InputReaderUtil inputReaderUtil;


    @BeforeAll
    private static void setUp() {
    inputReaderUtil = new InputReaderUtil();
    }

   // @BeforeEach
   // private void setUpPerTest() {

   // }

    @Test
    public void readSelectionTest(){




       // int input = inputReaderUtil.readSelection();
    System.out.println("This is the readSelection output" +  inputReaderUtil.readSelection());
        //assertEquals(inputReaderUtil.readSelection(),1);



    }

    @Test
    public void readVehicleRegistrationNumberTest() throws Exception {
       // InputOutput inputOutput= new InputOutput();

        String input = "add5";
       InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("add5", inputReaderUtil.readVehicleRegistrationNumber());

    }
}
