package com.antoniomarroffino.utils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

public final class JsonSchemaGenerator {

    private JsonSchemaGenerator() {
    }

    public static String generate(Class<?> clazz) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");

        Field[] fields = clazz.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];

            sb.append("  \"")
                    .append(field.getName())
                    .append("\": ")
                    .append(typeToExample(field.getType()));

            if (i < fields.length - 1) {
                sb.append(",");
            }
            sb.append("\n");
        }

        sb.append("}");
        return sb.toString();
    }

    private static String typeToExample(Class<?> type) {

        if (type.equals(String.class)) {
            return "\"string or null\"";
        }

        if (Number.class.isAssignableFrom(type)) {
            return "number or null";
        }

        if (type.equals(Boolean.class) || type.equals(boolean.class)) {
            return "boolean or null";
        }

        if (type.isEnum()) {
            return Arrays.stream(type.getEnumConstants())
                    .map(Object::toString)
                    .collect(Collectors.joining(", ", "\"", "\""));
        }

        if (type.isArray() || java.util.List.class.isAssignableFrom(type)) {
            return "[ ... ]";
        }

        // Nested object
        return "{ ... }";
    }
}
