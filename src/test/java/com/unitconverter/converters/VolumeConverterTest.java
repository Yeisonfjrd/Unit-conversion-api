package com.unitconverter.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.unitconverter.core.UnitConverterException;

public class VolumeConverterTest {

    @Test
    public void testConvertGallonsToLiters() {
        double result = VolumeConverter.convert(1, "gallon", "liter");
        assertEquals(3.78541, result, 0.0001, "1 galón debe ser 3.78541 litros");
    }

    @Test
    public void testConvertLitersToGallons() {
        double result = VolumeConverter.convert(3.78541, "liter", "gallon");
        assertEquals(1, result, 0.0001, "3.78541 litros deben ser 1 galón");
    }

    @Test
    public void testConvertMillilitersToLiters() {
        double result = VolumeConverter.convert(500, "milliliter", "liter");
        assertEquals(0.5, result, 0.0001, "500 mililitros deben ser 0.5 litros");
    }

    @Test
    public void testDirectConversionMethods() {
        assertEquals(3.78541, VolumeConverter.gallonsToLiters(1), 0.0001);
        assertEquals(1, VolumeConverter.litersToGallons(3.78541), 0.0001);
        assertEquals(0.5, VolumeConverter.millilitersToLiters(500), 0.0001);
    }

    @Test
    public void testCaseInsensitiveUnits() {
        double result = VolumeConverter.convert(1, "Gallon", "Liter");
        assertEquals(3.78541, result, 0.0001, "Conversión debe ser insensible a mayúsculas");
    }

    @Test
    public void testAlternativeUnitNotations() {
        double resultMl = VolumeConverter.convert(1000, "ml", "liter");
        assertEquals(1, resultMl, 0.0001, "Debe aceptar notación corta 'ml'");

        double resultCc = VolumeConverter.convert(500, "cc", "milliliter");
        assertEquals(500, resultCc, 0.0001, "Debe aceptar notación 'cc'");
    }

    @Test
    public void testInvalidUnit() {
        assertThrows(UnitConverterException.class, 
            () -> VolumeConverter.convert(10, "invalid", "liter"), 
            "Debe lanzar excepción para unidades inválidas");
    }
}