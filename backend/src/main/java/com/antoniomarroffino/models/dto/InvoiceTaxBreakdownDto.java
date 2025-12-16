package com.antoniomarroffino.models.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceTaxBreakdownDto {

    /** VAT rate (e.g. 7.7, 20) */
    @JsonAlias({
            "vatRate",
            "taxRate",
            "vat",
            "tax",
            "rate",
            "percentage"
    })
    public BigDecimal vatRate;

    /** Taxable base amount */
    @JsonAlias({
            "taxableAmount",
            "taxBase",
            "baseAmount",
            "netAmount",
            "taxableBase"
    })
    public BigDecimal taxableAmount;

    /** VAT amount */
    @JsonAlias({
            "vatAmount",
            "taxAmount",
            "vatValue",
            "taxValue",
            "vatTotal"
    })
    public BigDecimal vatAmount;
}
