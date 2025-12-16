package com.antoniomarroffino.services;

import org.jboss.resteasy.reactive.multipart.FileUpload;

public interface IPdfTextExtractor {

    /**
     * Extracts textual content from a PDF file.
     *
     * @param file uploaded PDF
     * @return extracted text (never null)
     */
    String extractText(FileUpload file);
}
