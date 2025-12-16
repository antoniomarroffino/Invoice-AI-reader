package com.antoniomarroffino.services.ai;

import com.antoniomarroffino.exceptions.AiExtractionException;
import com.antoniomarroffino.models.dto.InvoiceExtractionResultDto;
import com.antoniomarroffino.utils.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AiResponseParser {

    private static final ObjectMapper MAPPER = new ObjectMapper();

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
