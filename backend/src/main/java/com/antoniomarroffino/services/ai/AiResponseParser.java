package com.antoniomarroffino.services.ai;

import com.antoniomarroffino.exceptions.AiExtractionException;
import com.antoniomarroffino.models.dto.InvoiceExtractionResultDto;
import com.antoniomarroffino.utils.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class AiResponseParser {

    private static final ObjectMapper MAPPER = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);


    public static InvoiceExtractionResultDto parse(String aiRawResponse) {

        try {
            String json = JsonUtil.extractJsonFromGroqResponse(aiRawResponse);
            return MAPPER.readValue(json, InvoiceExtractionResultDto.class);

        } catch (Exception e) {
            throw new AiExtractionException(
                    "AI response could not be parsed as InvoiceExtractionResultDto", e
            );
        }
    }
}
