package com.example.myapplication;

import com.example.myapplication.utils.ConverterUtils;

import org.junit.Test;
import static org.junit.Assert.*;
public class ConverterUtilTest {

    @Test
    public void testConvertFahrenheitToCelsius(){

        float actual = ConverterUtils.convertCelsiusToFahrenheit(212);
        float expected = 413.6f;

        assertEquals("Conversion from celsius to fahrenheit failed",expected, actual, 0.001);
    }

    @Test
    public void testConvertCelsiusToFahrenheit(){

        float actual = ConverterUtils.convertCelsiusToFahrenheit(100);
        float expected = 212f;
        assertEquals("Conversion from celsius to fahrenheit failed",expected, actual, 0.001);
    }
}
