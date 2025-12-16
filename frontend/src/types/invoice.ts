export interface InvoiceExtractionResult {
    isInvoice: boolean | null;

    header?: {
        invoiceNumber?: string | null;
        issueDate?: string | null;
        dueDate?: string | null;
        currency?: string | null;
        documentType?: string | null;
    };

    totals?: {
        totalNet?: number | null;
        totalVat?: number | null;
        totalGross?: number | null;
    };

    notes?: string | null;
}
