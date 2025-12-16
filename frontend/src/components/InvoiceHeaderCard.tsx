export default function InvoiceHeaderCard({ header }: { header: any }) {
    return (
        <div className="rounded-2xl bg-white p-6 shadow-sm">
            <h3 className="mb-4 text-lg font-semibold text-gray-800">
                Invoice header
            </h3>

            <div className="grid grid-cols-2 gap-4 text-sm">
                <Field label="Invoice #" value={header.invoiceNumber} />
                <Field label="Issue date" value={header.issueDate} />
                <Field label="Currency" value={header.currency} />
                <Field label="Type" value={header.documentType} />
            </div>
        </div>
    );
}

function Field({ label, value }: { label: string; value?: string }) {
    return (
        <div>
            <p className="text-gray-500">{label}</p>
            <p className="font-medium text-gray-900">{value ?? "—"}</p>
        </div>
    );
}
