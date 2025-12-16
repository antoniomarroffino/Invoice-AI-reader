package com.antoniomarroffino.services;

import com.antoniomarroffino.models.dto.InvoiceExtractionResultDto;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AiExtractionService {

    public InvoiceExtractionResultDto extractInvoice(String invoiceText) {
        // Prompt + Groq call
        // Parse JSON
        // Return DTO
        return new InvoiceExtractionResultDto();
    }
}
