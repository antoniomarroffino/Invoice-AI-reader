package com.antoniomarroffino.models.dto;

import java.time.LocalDate;

public class InvoiceHeaderDto {

    /** Invoice number / document ID */
    public String invoiceNumber;

    /** Issue date */
    public LocalDate issueDate;

    /** Due date */
    public LocalDate dueDate;

    /** Currency (e.g. CHF, EUR) */
    public String currency;

    /** Document type (INVOICE, CREDIT_NOTE, etc.) */
    public String documentType;
}
