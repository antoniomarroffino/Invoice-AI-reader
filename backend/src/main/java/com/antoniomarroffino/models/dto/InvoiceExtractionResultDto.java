package com.antoniomarroffino.models.dto;

import java.util.List;

public class InvoiceExtractionResultDto {

    public InvoiceHeaderDto header;
    public InvoiceTotalsDto totals;

    public InvoicePartyDto seller;
    public InvoicePartyDto buyer;

    public List<InvoiceLineItemDto> lineItems;
    public List<InvoiceTaxBreakdownDto> taxes;

    public InvoicePaymentDetailsDto payment;

    /**
     * True if the document looks like a valid invoice.
     * False if the document is not an invoice or is unreadable.
     */
    public Boolean isInvoice;

    /**
     * Optional notes extracted from the document (e.g. legal notes).
     */
    public String notes;
}
