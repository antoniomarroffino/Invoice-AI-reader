package com.antoniomarroffino.services;

import com.antoniomarroffino.exceptions.PdfTextExtractionException;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import java.io.IOException;
import java.nio.file.Path;

@ApplicationScoped
public class PdfTextExtractor implements IPdfTextExtractor {

    @Override
    public String extractText(FileUpload file) {

        Path pdfPath = file.filePath();

        try (PDDocument document = PDDocument.load(pdfPath.toFile())) {

            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition(true);

            String text = stripper.getText(document).trim();

            if (text.isEmpty()) {
                throw new PdfTextExtractionException(
                        "The PDF does not contain extractable text (scanned document detected)"
                );
            }

            return normalize(text);

        } catch (IOException e) {
            throw new PdfTextExtractionException(
                    "Failed to extract text from PDF", e
            );
        }
    }

    private String normalize(String text) {
        return text
                .replace("\r\n", "\n")
                .replace("\r", "\n")
                .replaceAll("[ \\t]+", " ")
                .trim();
    }
}
