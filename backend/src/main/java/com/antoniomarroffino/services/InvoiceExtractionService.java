package com.antoniomarroffino.services;

import com.antoniomarroffino.models.dto.InvoiceExtractionResultDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.resteasy.reactive.multipart.FileUpload;

@ApplicationScoped
public class InvoiceExtractionService implements IInvoiceExtractionService {

    @Inject
    PdfTextExtractor pdfTextExtractor;

    @Inject
    AiExtractionService aiExtractionService;

    public InvoiceExtractionResultDto extract(FileUpload file) {

        validateFile(file);

        // 1. PDF → text
        String text = pdfTextExtractor.extractText(file);

        // 2. text → AI → DTO
        return aiExtractionService.extractInvoice(text);
    }

    private void validateFile(FileUpload file) {
        if (file == null || file.filePath() == null) {
            throw new IllegalArgumentException("Missing invoice file");
        }

        if (!"application/pdf".equals(file.contentType())) {
            throw new IllegalArgumentException("Only PDF files are supported");
        }
    }
}
