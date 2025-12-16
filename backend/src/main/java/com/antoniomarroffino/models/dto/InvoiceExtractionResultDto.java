package com.antoniomarroffino.models.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceExtractionResultDto {

    /** Invoice header / metadata */
    @JsonAlias({
            "header",
            "invoiceHeader",
            "documentHeader",
            "metadata"
    })
    public InvoiceHeaderDto header;

    /** Totals section */
    @JsonAlias({
            "totals",
            "summary",
            "amounts",
            "totalAmounts"
    })
    public InvoiceTotalsDto totals;

    /** Seller / supplier */
    @JsonAlias({
            "seller",
            "supplier",
            "issuer",
            "vendor",
            "from"
    })
    public InvoicePartyDto seller;

    /** Buyer / customer */
    @JsonAlias({
            "buyer",
            "customer",
            "client",
            "billTo",
            "to"
    })
    public InvoicePartyDto buyer;

    /** Line items */
    @JsonAlias({
            "lineItems",
            "items",
            "lines",
            "invoiceLines",
            "details"
    })
    public List<InvoiceLineItemDto> lineItems;

    /** VAT / tax breakdown */
    @JsonAlias({
            "taxes",
            "taxBreakdown",
            "vatBreakdown",
            "taxSummary",
            "vatSummary"
    })
    public List<InvoiceTaxBreakdownDto> taxes;

    /** Payment details */
    @JsonAlias({
            "payment",
            "paymentDetails",
            "paymentInfo",
            "paymentMethod"
    })
    public InvoicePaymentDetailsDto payment;

    /**
     * True if the document looks like a valid invoice.
     * False if the document is not an invoice or is unreadable.
     */
    @JsonAlias({
            "isInvoice",
            "validInvoice",
            "isValidInvoice",
            "invoiceDetected"
    })
    public Boolean isInvoice;

    /**
     * Optional notes extracted from the document (e.g. legal notes).
     */
    @JsonAlias({
            "notes",
            "remarks",
            "comments",
            "additionalNotes"
    })
    public String notes;
}
