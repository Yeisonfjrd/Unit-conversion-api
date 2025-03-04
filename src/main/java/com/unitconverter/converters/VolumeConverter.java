package com.unitconverter.converters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.unitconverter.core.UnitConverterException;

public class VolumeConverter {
    private static final Map<String, Double> CONVERSION_FACTORS = new HashMap<>();

    private static final Set<String> VALID_UNITS = new HashSet<>();

    static {
        CONVERSION_FACTORS.put("liter", 1.0);
        CONVERSION_FACTORS.put("litre", 1.0);
        CONVERSION_FACTORS.put("milliliter", 0.001);
        CONVERSION_FACTORS.put("ml", 0.001);
        CONVERSION_FACTORS.put("gallon", 3.78541);  // Galón estadounidense
        CONVERSION_FACTORS.put("us_gallon", 3.78541);
        CONVERSION_FACTORS.put("cubic_meter", 1000.0);
        CONVERSION_FACTORS.put("cubic_centimeter", 0.001);
        CONVERSION_FACTORS.put("cc", 0.001);
        CONVERSION_FACTORS.put("cup", 0.236588);
        CONVERSION_FACTORS.put("fluid_ounce", 0.0295735);
        CONVERSION_FACTORS.put("fl_oz", 0.0295735);

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

        double valueInLiters = value * CONVERSION_FACTORS.get(fromUnit);
        return valueInLiters / CONVERSION_FACTORS.get(toUnit);
    }

    /**
     * @param unit
     * @throws UnitConverterException
     */
    private static void validateUnit(String unit) {
        if (!VALID_UNITS.contains(unit)) {
            throw new UnitConverterException("Unidad de volumen no válida: " + unit);
        }
    }

    public static double gallonsToLiters(double gallons) {
        return convert(gallons, "gallon", "liter");
    }

    public static double litersToGallons(double liters) {
        return convert(liters, "liter", "gallon");
    }

    public static double millilitersToLiters(double milliliters) {
        return convert(milliliters, "milliliter", "liter");
    }
}