package com.unitconverter.converters;

import com.unitconverter.core.UnitConverterException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WeightConverterTest {

    @Test
    public void testConvertPoundsToKilograms() {
        double result = WeightConverter.convert(10, "pound", "kilogram");
        assertEquals(4.5359237, result, 0.0001, "10 libras deben ser 4.5359237 kilogramos");
    }

    @Test
    public void testConvertKilogramsToPounds() {
        double result = WeightConverter.convert(5, "kilogram", "pound");
        assertEquals(11.0231, result, 0.0001, "5 kilogramos deben ser 11.0231 libras");
    }

    @Test
    public void testConvertOuncesToGrams() {
        double result = WeightConverter.convert(10, "ounce", "gram");
        assertEquals(283.495, result, 0.001, "10 onzas deben ser 283.495 gramos");
    }

    @Test
    public void testDirectConversionMethods() {
        assertEquals(4.5359237, WeightConverter.poundsToKilograms(10), 0.0001);
        assertEquals(10, WeightConverter.kilogramsToPounds(4.5359237), 0.0001);
        assertEquals(283.495, WeightConverter.ouncesToGrams(10), 0.001);
    }

    @Test
    public void testCaseInsensitiveUnits() {
        double result = WeightConverter.convert(10, "Pound", "Kilogram");
        assertEquals(4.5359237, result, 0.0001, "Conversión debe ser insensible a mayúsculas");
    }

    @Test
    public void testAlternativeUnitNotations() {
        double resultLb = WeightConverter.convert(10, "lb", "kilogram");
        assertEquals(4.5359237, resultLb, 0.0001, "Debe aceptar notación corta 'lb'");

        double resultKg = WeightConverter.convert(10, "kg", "pound");
        assertEquals(22.0462, resultKg, 0.0001, "Debe aceptar notación corta 'kg'");
    }

    @Test
    public void testInvalidUnit() {
        assertThrows(UnitConverterException.class, 
            () -> WeightConverter.convert(10, "invalid", "kilogram"), 
            "Debe lanzar excepción para unidades inválidas");
    }
}