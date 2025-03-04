package com.unitconverter.converters;

import java.util.HashSet;
import java.util.Set;

import com.unitconverter.core.UnitConverterException;

public class TemperatureConverter {
    private static final Set<String> VALID_UNITS = new HashSet<>();

    static {
        VALID_UNITS.add("celsius");
        VALID_UNITS.add("fahrenheit");
        VALID_UNITS.add("kelvin");
        VALID_UNITS.add("c");
        VALID_UNITS.add("f");
        VALID_UNITS.add("k");
    }

    /**
     * @param value
     * @param fromUnit
     * @param toUnit
     * @return
     * @throws UnitConverterException
     */
    public static double convert(double value, String fromUnit, String toUnit) {
        fromUnit = fromUnit.toLowerCase();
        toUnit = toUnit.toLowerCase();

        validateUnit(fromUnit);
        validateUnit(toUnit);

        if (fromUnit.equals(toUnit)) {
            return value;
        }

        double valueInCelsius = convertToCelsius(value, fromUnit);

        return convertFromCelsius(valueInCelsius, toUnit);
    }

    private static double convertToCelsius(double value, String fromUnit) {
        switch (fromUnit) {
            case "celsius":
            case "c":
                return value;
            case "fahrenheit":
            case "f":
                return (value - 32) * 5.0 / 9.0;
            case "kelvin":
            case "k":
                return value - 273.15;
            default:
                throw new UnitConverterException("Unidad de temperatura no válida: " + fromUnit);
        }
    }

    private static double convertFromCelsius(double valueInCelsius, String toUnit) {
        switch (toUnit) {
            case "celsius":
            case "c":
                return valueInCelsius;
            case "fahrenheit":
            case "f":
                return (valueInCelsius * 9.0 / 5.0) + 32;
            case "kelvin":
            case "k":
                return valueInCelsius + 273.15;
            default:
                throw new UnitConverterException("Unidad de temperatura no válida: " + toUnit);
        }
    }

    /**
     * @param unit
     * @throws UnitConverterException
     */
    private static void validateUnit(String unit) {
        if (!VALID_UNITS.contains(unit)) {
            throw new UnitConverterException("Unidad de temperatura no válida: " + unit);
        }
    }

    public static double celsiusToFahrenheit(double celsius) {
        return convert(celsius, "celsius", "fahrenheit");
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return convert(fahrenheit, "fahrenheit", "celsius");
    }

    public static double celsiusToKelvin(double celsius) {
        return convert(celsius, "celsius", "kelvin");
    }
}