export default function InvoiceLineItemsTable({
                                                  items,
                                              }: {
    items: any[];
}) {
    if (!items?.length) {
        return (
            <div className="rounded-2xl bg-white p-6 text-sm text-gray-500 shadow-sm">
                No line items found.
            </div>
        );
    }

    return (
        <div className="overflow-hidden rounded-2xl bg-white shadow-sm">
            <table className="w-full text-sm">
                <thead className="bg-gray-50 text-gray-600">
                <tr>
                    <th className="px-4 py-3 text-left">Description</th>
                    <th className="px-4 py-3 text-right">Qty</th>
                    <th className="px-4 py-3 text-right">Unit price</th>
                    <th className="px-4 py-3 text-right">Net amount</th>
                    <th className="px-4 py-3 text-right">VAT %</th>
                </tr>
                </thead>
                <tbody>
                {items.map((item, idx) => (
                    <tr
                        key={idx}
                        className="border-t last:border-b"
                    >
                        <td className="px-4 py-3">
                            {item.description}
                        </td>
                        <td className="px-4 py-3 text-right">
                            {item.quantity}
                        </td>
                        <td className="px-4 py-3 text-right">
                            {format(item.unitPrice)}
                        </td>
                        <td className="px-4 py-3 text-right font-medium">
                            {format(item.netAmount)}
                        </td>
                        <td className="px-4 py-3 text-right">
                            {item.vatRate ?? "—"}
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}

function format(value?: number) {
    if (value == null) return "—";
    return value.toFixed(2);
}
