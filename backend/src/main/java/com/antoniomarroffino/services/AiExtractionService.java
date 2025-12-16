package com.antoniomarroffino.services;

import com.antoniomarroffino.client.GroqClient;
import com.antoniomarroffino.exceptions.AiExtractionException;
import com.antoniomarroffino.models.dto.InvoiceExtractionResultDto;
import com.antoniomarroffino.services.ai.AiResponseParser;
import com.antoniomarroffino.services.ai.PromptBuilder;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AiExtractionService {

    @Inject
    GroqClient groqClient;

    public InvoiceExtractionResultDto extractInvoice(String invoiceText) {

        if (invoiceText == null || invoiceText.isBlank()) {
            throw new AiExtractionException("Invoice text is empty");
        }

        String prompt = PromptBuilder.buildInvoiceExtractionPrompt(invoiceText);

        String aiResponse = groqClient.chat(prompt);

        return AiResponseParser.parse(aiResponse);
    }
}
