package com.antoniomarroffino.models.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceLineItemDto {

    /** Description of the item or service */
    @JsonAlias({
            "description",
            "itemDescription",
            "serviceDescription",
            "name",
            "item",
            "label"
    })
    public String description;

    /** Quantity */
    @JsonAlias({
            "quantity",
            "qty",
            "amount",
            "count",
            "units"
    })
    public BigDecimal quantity;

    /** Unit price (net) */
    @JsonAlias({
            "unitPrice",
            "pricePerUnit",
            "unit_cost",
            "unitCost",
            "price"
    })
    public BigDecimal unitPrice;

    /** Net amount for this line */
    @JsonAlias({
            "netAmount",
            "lineTotal",
            "total",
            "amount",
            "netTotal"
    })
    public BigDecimal netAmount;

    /** VAT rate applied (e.g. 7.7) */
    @JsonAlias({
            "vatRate",
            "taxRate",
            "vat",
            "tax",
            "vatPercent",
            "taxPercent"
    })
    public BigDecimal vatRate;
}
