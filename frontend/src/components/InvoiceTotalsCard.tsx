export default function InvoiceTotalsCard({ totals }: { totals: any }) {
    return (
        <div className="grid grid-cols-3 gap-4">
            <Total label="Net" value={totals.totalNet} />
            <Total label="VAT" value={totals.totalVat} />
            <Total label="Gross" value={totals.totalGross} highlight />
        </div>
    );
}

function Total({
                   label,
                   value,
                   highlight,
               }: {
    label: string;
    value: number;
    highlight?: boolean;
}) {
    return (
        <div
            className={`rounded-2xl p-6 text-center shadow-sm ${
                highlight ? "bg-purple-600 text-white" : "bg-white"
            }`}
        >
            <p className="text-sm opacity-80">{label}</p>
            <p className="mt-2 text-2xl font-bold">{value?.toFixed(2)}</p>
        </div>
    );
}
