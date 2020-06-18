package com.syed.parkinglot.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.Environment;

import com.syed.parkinglot.ParkingLot;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class ParkingLotTest {
    ParkingLot parkingLot = new ParkingLot();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
    @Test
    public void createParkingLot() throws Exception {
        parkingLot.createParkingLot("10");
        assertEquals(10, parkingLot.MAX_SIZE);
        assertEquals(10, parkingLot.availableSlotList.size());
    }

    @Test
    public void park() throws Exception {
        parkingLot.park("KA-01-HH-1234", "White");
        parkingLot.park("KA-01-HH-5678", "Black");
        parkingLot.createParkingLot("6");
        parkingLot.park("KA-01-HH-1234", "White");
        parkingLot.park("KA-01-HH-5678", "Black");
        assertEquals(4, parkingLot.availableSlotList.size());
    }

    @Test
    public void seek() throws Exception {
        parkingLot.createParkingLot("6");
        parkingLot.park("KA-01-HH-1234", "White");
        parkingLot.seek("1");
        String actualString = outContent.toString().trim().replace(" ", "");
        assertTrue(actualString.contains("Createdparkinglotwith6slots"));
        
       
    }
}