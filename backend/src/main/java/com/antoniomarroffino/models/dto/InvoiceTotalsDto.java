package com.antoniomarroffino.models.dto;

import java.math.BigDecimal;

public class InvoiceTotalsDto {

    /** Total net amount */
    public BigDecimal totalNet;

    /** Total VAT amount */
    public BigDecimal totalVat;

    /** Total gross amount */
    public BigDecimal totalGross;
}
