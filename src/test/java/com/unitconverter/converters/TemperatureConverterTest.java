package com.unitconverter.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.unitconverter.core.UnitConverterException;

public class TemperatureConverterTest {

    @Test
    public void testConvertCelsiusToFahrenheit() {
        double result = TemperatureConverter.convert(0, "celsius", "fahrenheit");
        assertEquals(32, result, 0.0001, "0°C debe ser 32°F");
        
        result = TemperatureConverter.convert(100, "celsius", "fahrenheit");
        assertEquals(212, result, 0.0001, "100°C debe ser 212°F");
    }

    @Test
    public void testConvertFahrenheitToCelsius() {
        double result = TemperatureConverter.convert(32, "fahrenheit", "celsius");
        assertEquals(0, result, 0.0001, "32°F debe ser 0°C");
        
        result = TemperatureConverter.convert(212, "fahrenheit", "celsius");
        assertEquals(100, result, 0.0001, "212°F debe ser 100°C");
    }

    @Test
    public void testConvertCelsiusToKelvin() {
        double result = TemperatureConverter.convert(0, "celsius", "kelvin");
        assertEquals(273.15, result, 0.0001, "0°C debe ser 273.15K");
        
        result = TemperatureConverter.convert(100, "celsius", "kelvin");
        assertEquals(373.15, result, 0.0001, "100°C debe ser 373.15K");
    }

    @Test
    public void testDirectConversionMethods() {
        assertEquals(32, TemperatureConverter.celsiusToFahrenheit(0), 0.0001);
        assertEquals(0, TemperatureConverter.fahrenheitToCelsius(32), 0.0001);
        assertEquals(273.15, TemperatureConverter.celsiusToKelvin(0), 0.0001);
    }

    @Test
    public void testCaseInsensitiveUnits() {
        double result = TemperatureConverter.convert(0, "Celsius", "Fahrenheit");
        assertEquals(32, result, 0.0001, "Conversión debe ser insensible a mayúsculas");
    }

    @Test
    public void testAlternativeUnitNotations() {
        double resultCtoF = TemperatureConverter.convert(0, "c", "f");
        assertEquals(32, resultCtoF, 0.0001, "Debe aceptar notación corta 'c'");

        double resultFtoK = TemperatureConverter.convert(32, "f", "k");
        assertEquals(273.15, resultFtoK, 0.0001, "Debe aceptar notación corta 'f'");
    }

    @Test
    public void testInvalidUnit() {
        assertThrows(UnitConverterException.class, 
            () -> TemperatureConverter.convert(10, "invalid", "celsius"), 
            "Debe lanzar excepción para unidades inválidas");
    }

    @Test
    public void testSameUnitConversion() {
        double result = TemperatureConverter.convert(25, "celsius", "celsius");
        assertEquals(25, result, 0.0001, "Conversión a la misma unidad debe devolver el mismo valor");
    }
}