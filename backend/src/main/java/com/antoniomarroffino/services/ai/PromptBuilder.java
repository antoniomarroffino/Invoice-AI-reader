package com.antoniomarroffino.services.ai;

import com.antoniomarroffino.models.dto.InvoiceExtractionResultDto;
import com.antoniomarroffino.utils.JsonSchemaGenerator;

public class PromptBuilder {

    private PromptBuilder() {}

    public static String buildInvoiceExtractionPrompt(String invoiceText) {

        return """
    You are a strict data extraction engine.

    Your task is to extract invoice data and output a JSON object that MUST
    conform EXACTLY to the schema provided below.

    CRITICAL RULES (MANDATORY):
    1. The output JSON MUST match the schema EXACTLY.
    2. You MUST NOT add new fields.
    3. You MUST NOT rename fields.
    4. You MUST NOT use alternative or synonymous field names.
    5. If the invoice uses a different wording, you MUST internally map it
       to the correct schema field WITHOUT changing the schema.
    6. If a value is missing or unclear, set the field to null.
    7. Do NOT guess or infer values.
    8. Output ONLY valid JSON.

    JSON SCHEMA:
    %s

    INVOICE TEXT:
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
