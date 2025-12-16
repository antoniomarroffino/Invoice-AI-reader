package com.antoniomarroffino.services;

import com.antoniomarroffino.exceptions.InvalidInvoiceFileException;
import com.antoniomarroffino.models.dto.InvoiceExtractionResultDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.resteasy.reactive.multipart.FileUpload;

@ApplicationScoped
public class InvoiceExtractionService implements IInvoiceExtractionService {

    @Inject
    IPdfTextExtractor pdfTextExtractor;

    @Inject
    AiExtractionService aiExtractionService;

    @Override
    public InvoiceExtractionResultDto extract(FileUpload file) {

        validateFile(file);

        // 1. PDF → text
        String text = pdfTextExtractor.extractText(file);

        // 2. text → AI → DTO
        return aiExtractionService.extractInvoice(text);
    }

    private void validateFile(FileUpload file) {

        if (file == null || file.filePath() == null) {
            throw new InvalidInvoiceFileException(
                    "Missing invoice PDF file"
            );
        }

        if (!"application/pdf".equalsIgnoreCase(file.contentType())) {
            throw new InvalidInvoiceFileException(
                    "Only PDF files are supported"
            );
        }
    }
}
