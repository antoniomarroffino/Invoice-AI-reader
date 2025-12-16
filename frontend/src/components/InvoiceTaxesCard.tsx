export default function InvoiceTaxesCard({ taxes }: { taxes: any[] }) {
    if (!taxes?.length) {
        return (
            <div className="rounded-2xl bg-white p-6 text-sm text-gray-500 shadow-sm">
                No tax breakdown available.
            </div>
        );
    }

    return (
        <div className="rounded-2xl bg-white p-6 shadow-sm">
            <h3 className="mb-4 text-lg font-semibold text-gray-800">
                Tax breakdown
            </h3>

            <div className="space-y-3 text-sm">
                {taxes.map((tax, idx) => (
                    <div
                        key={idx}
                        className="flex items-center justify-between rounded-lg bg-gray-50 px-4 py-3"
                    >
                        <span>
                            VAT {tax.vatRate}%
                        </span>
                        <span className="font-medium">
                            {tax.vatAmount?.toFixed(2)}
                        </span>
                    </div>
                ))}
            </div>
        </div>
    );
}
