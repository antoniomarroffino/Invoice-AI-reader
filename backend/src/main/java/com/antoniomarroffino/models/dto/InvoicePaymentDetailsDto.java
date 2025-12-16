package com.antoniomarroffino.models.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoicePaymentDetailsDto {

    /** Payment method (e.g. BANK_TRANSFER) */
    @JsonAlias({
            "method",
            "paymentMethod",
            "paymentType",
            "payment_mode",
            "payment"
    })
    public String method;

    /** IBAN for payment */
    @JsonAlias({
            "iban",
            "ibanNumber",
            "bankAccount",
            "bankIban",
            "accountNumber"
    })
    public String iban;

    /** Payment reference */
    @JsonAlias({
            "reference",
            "paymentReference",
            "ref",
            "message",
            "purpose"
    })
    public String reference;

    /** QR reference or structured reference if present */
    @JsonAlias({
            "structuredReference",
            "qrReference",
            "qrRef",
            "structuredRef",
            "referenceStructured"
    })
    public String structuredReference;
}
