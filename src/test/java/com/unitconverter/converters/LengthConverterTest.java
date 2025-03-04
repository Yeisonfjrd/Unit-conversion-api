package com.unitconverter.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.unitconverter.core.UnitConverterException;

public class LengthConverterTest {

    @Test
    public void testConvertFeetToMeters() {
        double result = LengthConverter.convert(10, "foot", "meter");
        assertEquals(3.048, result, 0.001, "10 pies deben ser 3.048 metros");
    }

    @Test
    public void testConvertMetersToFeet() {
        double result = LengthConverter.convert(3.048, "meter", "foot");
        assertEquals(10, result, 0.001, "3.048 metros deben ser 10 pies");
    }

    @Test
    public void testConvertInchesToCentimeters() {
        double result = LengthConverter.convert(10, "inch", "centimeter");
        assertEquals(25.4, result, 0.001, "10 pulgadas deben ser 25.4 centímetros");
    }

    @Test
    public void testDirectConversionMethods() {
        assertEquals(3.048, LengthConverter.feetToMeters(10), 0.001);
        assertEquals(10, LengthConverter.metersToFeet(3.048), 0.001);
        assertEquals(25.4, LengthConverter.inchesToCentimeters(10), 0.001);
    }

    @Test
    public void testCaseInsensitiveUnits() {
        double result = LengthConverter.convert(10, "Foot", "Meter");
        assertEquals(3.048, result, 0.001, "Conversión debe ser insensible a mayúsculas");
    }

    @Test
    public void testInvalidUnit() {
        assertThrows(UnitConverterException.class, 
            () -> LengthConverter.convert(10, "invalid", "meter"), 
            "Debe lanzar excepción para unidades inválidas");
    }
}