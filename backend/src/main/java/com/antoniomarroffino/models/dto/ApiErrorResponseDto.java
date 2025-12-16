package com.antoniomarroffino.models.dto;

import java.time.OffsetDateTime;
import java.util.Map;

public class ApiErrorResponseDto {

    public OffsetDateTime timestamp;
    public int status;
    public String error;
    public String message;
    public String path;

    /**
     * Optional extra details (e.g. validation errors).
     */
    public Map<String, Object> details;

    public static ApiErrorResponseDto of(int status, String error, String message, String path) {
        ApiErrorResponseDto r = new ApiErrorResponseDto();
        r.timestamp = OffsetDateTime.now();
        r.status = status;
        r.error = error;
        r.message = message;
        r.path = path;
        return r;
    }

    public ApiErrorResponseDto withDetails(Map<String, Object> details) {
        this.details = details;
        return this;
    }
}
