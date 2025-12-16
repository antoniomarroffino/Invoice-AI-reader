import type {InvoiceExtractionResult} from "../types/invoice";

const API_BASE_URL = import.meta.env.VITE_API_BASE_URL ?? "http://localhost:8080/api";

export async function extractInvoice(
    file: File
): Promise<InvoiceExtractionResult> {
    const formData = new FormData();
    formData.append("file", file);

    const response = await fetch(`${API_BASE_URL}/invoices/extract`, {
        method: "POST",
        body: formData,
    });

    if (!response.ok) {
        const errorBody = await response.json().catch(() => null);

        const message =
            errorBody?.message ??
            `Invoice extraction failed (${response.status})`;

        throw new Error(message);
    }

    return response.json();
}
