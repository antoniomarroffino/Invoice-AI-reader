import { useState } from "react";
import InvoiceHeaderCard from "./InvoiceHeaderCard";
import InvoicePartiesCard from "./InvoicePartiesCard";
import InvoiceTotalsCard from "./InvoiceTotalsCard";
import InvoiceLineItemsTable from "./InvoiceLineItemsTable";
import InvoiceTaxesCard from "./InvoiceTaxesCard";
import InvoiceRawJson from "./InvoiceRawJson";

export default function InvoiceResult({ data }: { data: any }) {
    const [view, setView] = useState<"structured" | "json">("structured");

    return (
        <div className="space-y-6">
            {/* Toggle */}
            <div className="flex justify-end gap-2">
                <button
                    onClick={() => setView("structured")}
                    className={`rounded-lg px-4 py-2 text-sm font-medium ${
                        view === "structured"
                            ? "bg-purple-600 text-white"
                            : "bg-white text-gray-600"
                    }`}
                >
                    Structured
                </button>
                <button
                    onClick={() => setView("json")}
                    className={`rounded-lg px-4 py-2 text-sm font-medium ${
                        view === "json"
                            ? "bg-purple-600 text-white"
                            : "bg-white text-gray-600"
                    }`}
                >
                    JSON
                </button>
            </div>

            {view === "structured" ? (
                <>
                    <InvoiceHeaderCard header={data.header} />
                    <InvoicePartiesCard
                        seller={data.seller}
                        buyer={data.buyer}
                    />
                    <InvoiceTotalsCard totals={data.totals} />
                    <InvoiceLineItemsTable items={data.lineItems} />
                    <InvoiceTaxesCard taxes={data.taxes} />
                </>
            ) : (
                <InvoiceRawJson data={data} />
            )}
        </div>
    );
}
