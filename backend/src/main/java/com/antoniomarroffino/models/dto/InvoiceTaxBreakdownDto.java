package com.antoniomarroffino.models.dto;

import java.math.BigDecimal;

public class InvoiceTaxBreakdownDto {

    /** VAT rate (e.g. 7.7, 20) */
    public BigDecimal vatRate;

    /** Taxable base amount */
    public BigDecimal taxableAmount;

    /** VAT amount */
    public BigDecimal vatAmount;
}
