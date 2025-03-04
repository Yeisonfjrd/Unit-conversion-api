package com.unitconverter.core;

public class UnitConverterException extends RuntimeException {
    public UnitConverterException(String message) {
        super(message);
    }

    public UnitConverterException(String message, Throwable cause) {
        super(message, cause);
    }
}