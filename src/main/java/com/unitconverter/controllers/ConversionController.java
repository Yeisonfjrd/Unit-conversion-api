package com.unitconverter.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unitconverter.converters.LengthConverter;
import com.unitconverter.converters.TemperatureConverter;
import com.unitconverter.converters.VolumeConverter;
import com.unitconverter.converters.WeightConverter;

@RestController
@RequestMapping("/api/convert")
public class ConversionController {

    @GetMapping("/{type}/{value}/{fromUnit}/{toUnit}")
    public double convert(
        @PathVariable String type,
        @PathVariable double value,
        @PathVariable String fromUnit,
        @PathVariable String toUnit
    ) {
        try {
            switch (type.toLowerCase()) {
                case "length":
                    return LengthConverter.convert(value, fromUnit, toUnit);
                case "weight":
                    return WeightConverter.convert(value, fromUnit, toUnit);
                case "temperature":
                    return TemperatureConverter.convert(value, fromUnit, toUnit);
                case "volume":
                    return VolumeConverter.convert(value, fromUnit, toUnit);
                default:
                    throw new IllegalArgumentException("Invalid conversion type: " + type);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Error converting units: " + e.getMessage());
        }
    }
} 