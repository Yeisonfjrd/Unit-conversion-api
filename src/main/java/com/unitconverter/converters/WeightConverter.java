package com.unitconverter.converters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.unitconverter.core.UnitConverterException;

public class WeightConverter {
    private static final Map<String, Double> CONVERSION_FACTORS = new HashMap<>();
    
    private static final Set<String> VALID_UNITS = new HashSet<>();

    static {
        CONVERSION_FACTORS.put("kilogram", 1.0);
        CONVERSION_FACTORS.put("kg", 1.0);
        CONVERSION_FACTORS.put("gram", 0.001);
        CONVERSION_FACTORS.put("milligram", 0.000001);
        CONVERSION_FACTORS.put("pound", 0.45359237);
        CONVERSION_FACTORS.put("lb", 0.45359237);
        CONVERSION_FACTORS.put("ounce", 0.0283495);
        CONVERSION_FACTORS.put("oz", 0.0283495);
        CONVERSION_FACTORS.put("ton", 1000.0);
        CONVERSION_FACTORS.put("metric_ton", 1000.0);
        CONVERSION_FACTORS.put("stone", 6.35029);

        VALID_UNITS.addAll(CONVERSION_FACTORS.keySet());
    }

    /**
     * 
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

        double valueInKilograms = value * CONVERSION_FACTORS.get(fromUnit);
        return valueInKilograms / CONVERSION_FACTORS.get(toUnit);
    }

    /**
     * @param unit
     * @throws UnitConverterException
     */
    private static void validateUnit(String unit) {
        if (!VALID_UNITS.contains(unit)) {
            throw new UnitConverterException("Unidad de peso no válida: " + unit);
        }
    }

    public static double poundsToKilograms(double pounds) {
        return convert(pounds, "pound", "kilogram");
    }

    public static double kilogramsToPounds(double kilograms) {
        return convert(kilograms, "kilogram", "pound");
    }

    public static double ouncesToGrams(double ounces) {
        return convert(ounces, "ounce", "gram");
    }
}