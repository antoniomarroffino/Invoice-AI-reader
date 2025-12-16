package com.antoniomarroffino.models.dto;

public class InvoicePaymentDetailsDto {

    /** Payment method (e.g. BANK_TRANSFER) */
    public String method;

    /** IBAN for payment */
    public String iban;

    /** Payment reference */
    public String reference;

    /** QR reference or structured reference if present */
    public String structuredReference;
}
