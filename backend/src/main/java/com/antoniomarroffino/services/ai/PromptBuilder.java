package com.antoniomarroffino.services.ai;

import com.antoniomarroffino.models.dto.InvoiceExtractionResultDto;
import com.antoniomarroffino.utils.JsonSchemaGenerator;

public class PromptBuilder {

    private PromptBuilder() {}

    public static String buildInvoiceExtractionPrompt(String invoiceText) {

        return """
        You are an expert system for invoice data extraction.

        Extract ONLY the information explicitly present in the invoice text.
        Do NOT guess.
        Do NOT infer missing values.
        If a field is not present, return null.

        Return ONLY valid JSON.
        Do NOT add explanations.

        The JSON must match EXACTLY this structure:

        %s

        Invoice text:
        ----------------
        %s
        ----------------
        """
                .formatted(
                        JsonSchemaGenerator.generate(InvoiceExtractionResultDto.class),
                        invoiceText
                );
    }
}
