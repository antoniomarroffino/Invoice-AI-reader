export default function InvoiceRawJson({ data }: { data: any }) {
    return (
        <pre className="max-h-[600px] overflow-auto rounded-2xl bg-gray-900 p-6 text-xs text-green-200">
            {JSON.stringify(data, null, 2)}
        </pre>
    );
}
