package com.antoniomarroffino.models.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceTotalsDto {

    /** Total net amount */
    @JsonAlias({
            "totalNet",
            "netTotal",
            "netAmount",
            "subtotal",
            "subTotal"
    })
    public BigDecimal totalNet;

    /** Total VAT amount */
    @JsonAlias({
            "totalVat",
            "vatTotal",
            "taxTotal",
            "totalTax",
            "vatAmount"
    })
    public BigDecimal totalVat;

    /** Total gross amount */
    @JsonAlias({
            "totalGross",
            "grossTotal",
            "grandTotal",
            "total",
            "amountDue",
            "totalAmount"
    })
    public BigDecimal totalGross;
}
