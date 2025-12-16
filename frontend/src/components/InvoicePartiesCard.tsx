export default function InvoicePartiesCard({
                                               seller,
                                               buyer,
                                           }: {
    seller: any;
    buyer: any;
}) {
    return (
        <div className="grid grid-cols-1 gap-6 md:grid-cols-2">
            <PartyCard title="Seller" party={seller} />
            <PartyCard title="Buyer" party={buyer} />
        </div>
    );
}

function PartyCard({ title, party }: { title: string; party: any }) {
    return (
        <div className="rounded-2xl bg-white p-6 shadow-sm">
            <h3 className="mb-4 text-lg font-semibold text-gray-800">
                {title}
            </h3>

            <div className="space-y-2 text-sm">
                <Field label="Name" value={party?.name} />
                <Field label="VAT number" value={party?.vatNumber} />
                <Field label="Address" value={party?.address} />
                <Field label="Country" value={party?.country} />
                <Field label="IBAN" value={party?.iban} />
                <Field label="Contact" value={party?.contact} />
            </div>
        </div>
    );
}

function Field({ label, value }: { label: string; value?: string }) {
    return (
        <div>
            <span className="text-gray-500">{label}: </span>
            <span className="font-medium text-gray-900">
                {value ?? "—"}
            </span>
        </div>
    );
}
