package com.antoniomarroffino.models.dto;

import java.math.BigDecimal;

public class InvoiceLineItemDto {

    /** Description of the item or service */
    public String description;

    /** Quantity */
    public BigDecimal quantity;

    /** Unit price (net) */
    public BigDecimal unitPrice;

    /** Net amount for this line */
    public BigDecimal netAmount;

    /** VAT rate applied (e.g. 7.7) */
    public BigDecimal vatRate;
}
