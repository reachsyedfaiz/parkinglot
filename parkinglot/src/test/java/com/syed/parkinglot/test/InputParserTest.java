package com.syed.parkinglot.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.syed.parkinglot.InputParser;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class InputParserTest {
    InputParser inputParser = new InputParser();
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
    public void parseTextInput() throws Exception {
        //inputParser.parseTextInput("hello");
        //assertEquals("Invalidinput", outContent.toString().trim().replace(" ", ""));
        //inputParser.parseTextInput("seek");
        //inputParser.parseTextInput("park KA­01­HH­1234 White");
        inputParser.parseFileInput("C:\\Users\\sfahamed\\git\\parkinglot\\parkinglot\\src\\test\\java\\com\\syed\\parkinglot\\test\\input_file.txt");
        //String actualString = outContent.toString().trim();
        //assertTrue(actualString.contains("Sorry, parking lot is not created"));
    }

}