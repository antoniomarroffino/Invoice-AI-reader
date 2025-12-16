package com.antoniomarroffino.models.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceHeaderDto {

    /** Invoice number / document ID */
    @JsonAlias({
            "invoiceNumber",
            "invoice_no",
            "invoiceId",
            "documentNumber",
            "documentId",
            "number"
    })
    public String invoiceNumber;

    /** Issue date */
    @JsonAlias({
            "issueDate",
            "invoiceDate",
            "billDate",
            "documentDate",
            "date"
    })
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate issueDate;

    /** Due date */
    @JsonAlias({
            "dueDate",
            "paymentDueDate",
            "due_date",
            "paymentDate",
            "expiryDate"
    })
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate dueDate;

    /** Currency (e.g. CHF, EUR) */
    @JsonAlias({
            "currency",
            "currencyCode",
            "isoCurrency",
            "currency_code"
    })
    public String currency;

    /** Document type (INVOICE, CREDIT_NOTE, etc.) */
    @JsonAlias({
            "documentType",
            "invoiceType",
            "type",
            "docType"
    })
    public String documentType;
}
