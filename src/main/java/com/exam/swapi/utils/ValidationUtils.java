package com.exam.swapi.utils;

import com.exam.swapi.exception.BadRequestException;

public class ValidationUtils {
    public static final String FIELD_REQUIRED = "El campo '%s' es obligatorio.";
    public static final String FIELD_POSITIVE = "El campo '%s' debe ser mayor que cero.";
    public static final String FIELD_NOT_EMPTY = "El campo '%s' no puede estar vacío.";
    private ValidationUtils() {}

    public static void requirePositive(int value, String fieldName) {
        if (value <= 0) {
            throw new BadRequestException(String.format(FIELD_POSITIVE, fieldName));
        }
    }

    public static void requireNonNull(Object value, String fieldName) {
        if (value == null) {
            throw new BadRequestException(String.format(FIELD_REQUIRED, fieldName));
        }
    }

    public static void requireNotEmpty(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new BadRequestException(String.format(FIELD_NOT_EMPTY, fieldName));
        }
    }

    public static String sanitizeParam(String value) {
        return value == null ? null : value.trim();
    }
}
