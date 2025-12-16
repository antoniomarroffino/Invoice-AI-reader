import { useMutation } from "@tanstack/react-query";
import { extractInvoice } from "../api/invoice";
import type {InvoiceExtractionResult} from "../types/invoice";

export function useExtractInvoice() {
    return useMutation<InvoiceExtractionResult, Error, File>({
        mutationFn: (file: File) => extractInvoice(file),
    });
}
