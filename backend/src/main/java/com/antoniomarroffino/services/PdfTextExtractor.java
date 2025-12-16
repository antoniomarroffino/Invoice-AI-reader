package com.antoniomarroffino.services;

import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.resteasy.reactive.multipart.FileUpload;

@ApplicationScoped
public class PdfTextExtractor {

    public String extractText(FileUpload file) {
        // PDFBox implementation (next step)
        return "";
    }
}
