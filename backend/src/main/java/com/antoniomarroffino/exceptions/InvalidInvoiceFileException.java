package com.antoniomarroffino.exceptions;

public class InvalidInvoiceFileException extends RuntimeException {

    public InvalidInvoiceFileException(String message) {
        super(message);
    }
}
