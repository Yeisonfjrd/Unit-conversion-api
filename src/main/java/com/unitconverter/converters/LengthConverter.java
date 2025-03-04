package com.unitconverter.converters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.unitconverter.core.UnitConverterException;

public class LengthConverter {
    private static final Map<String, Double> CONVERSION_FACTORS = new HashMap<>();

    private static final Set<String> VALID_UNITS = new HashSet<>();

    static {
        CONVERSION_FACTORS.put("meter", 1.0);
        CONVERSION_FACTORS.put("metre", 1.0);
        CONVERSION_FACTORS.put("foot", 0.3048);
        CONVERSION_FACTORS.put("feet", 0.3048);
        CONVERSION_FACTORS.put("inch", 0.0254);
        CONVERSION_FACTORS.put("inches", 0.0254);
        CONVERSION_FACTORS.put("yard", 0.9144);
        CONVERSION_FACTORS.put("kilometer", 1000.0);
        CONVERSION_FACTORS.put("mile", 1609.344);
        CONVERSION_FACTORS.put("centimeter", 0.01);
        CONVERSION_FACTORS.put("millimeter", 0.001);
        VALID_UNITS.addAll(CONVERSION_FACTORS.keySet());
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

        double valueInMeters = value * CONVERSION_FACTORS.get(fromUnit);

        return valueInMeters / CONVERSION_FACTORS.get(toUnit);
    }

    /**
     * @param unit
     * @throws UnitConverterException
     */
    private static void validateUnit(String unit) {
        if (!VALID_UNITS.contains(unit)) {
            throw new UnitConverterException("Unidad de longitud no válida: " + unit);
        }
    }

    public static double feetToMeters(double feet) {
        return convert(feet, "foot", "meter");
    }

    public static double metersToFeet(double meters) {
        return convert(meters, "meter", "foot");
    }

    public static double inchesToCentimeters(double inches) {
        return convert(inches, "inch", "centimeter");
    }
}