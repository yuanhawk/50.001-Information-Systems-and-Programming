package com.example.norman_lee.myapplication.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {

    @Test
    public void checkInvalidInput_isNumberFormatException() {
        assertEquals(Utils.checkInvalidInputs(""), Utils.Input.NFE);
    }

}