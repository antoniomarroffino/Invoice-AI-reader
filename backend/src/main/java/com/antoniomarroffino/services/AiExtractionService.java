package com.antoniomarroffino.services;

import com.antoniomarroffino.client.GroqClient;
import com.antoniomarroffino.exceptions.AiExtractionException;
import com.antoniomarroffino.models.dto.InvoiceExtractionResultDto;
import com.antoniomarroffino.services.ai.AiResponseParser;
import com.antoniomarroffino.services.ai.PromptBuilder;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

@ApplicationScoped
public class AiExtractionService {

    private static final Logger LOG = Logger.getLogger(AiExtractionService.class);

    @Inject
    GroqClient groqClient;

    public InvoiceExtractionResultDto extractInvoice(String invoiceText) {

        if (invoiceText == null || invoiceText.isBlank()) {
            LOG.warn("AI extraction aborted: invoice text is empty");
            throw new AiExtractionException("Invoice text is empty");
        }

        LOG.debugf(
                "Starting AI extraction. Invoice text length: %d characters",
                invoiceText.length()
        );

        // 1. Build prompt
        String prompt = PromptBuilder.buildInvoiceExtractionPrompt(invoiceText);

        LOG.debugf(
                "AI prompt built successfully (length: %d characters)",
                prompt.length()
        );

        // 2. Call Groq
        LOG.info("Calling Groq AI for invoice extraction...");
        String aiResponse = groqClient.chat(prompt);

        if (aiResponse == null || aiResponse.isBlank()) {
            LOG.error("Groq returned an empty response");
            throw new AiExtractionException("AI returned an empty response");
        }

        LOG.debugf(
                "Raw AI response received (length: %d characters)",
                aiResponse.length()
        );

        // 3. Parse response
        try {
            InvoiceExtractionResultDto result =
                    AiResponseParser.parse(aiResponse);

            LOG.info("AI invoice extraction completed successfully");
            return result;

        } catch (Exception e) {
            LOG.error("Failed to parse AI response", e);
            throw new AiExtractionException("Failed to parse AI response", e);
        }
    }
}
