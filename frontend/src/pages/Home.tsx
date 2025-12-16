import InvoiceDropzone from "../components/InvoiceDropzone";
import PageContainer from "../components/PageContainer";
import { useExtractInvoice } from "../hooks/useExtractInvoice";

export default function Home() {
    const {
        mutate: extractInvoice,
        data,
        isPending,
        isError,
        error,
    } = useExtractInvoice();

    return (
        <PageContainer>
            {/* Header */}
            <div className="mb-16 text-center">
                <h1 className="mb-4 text-5xl font-extrabold tracking-tight text-gray-900">
                    Invoice AI Reader
                </h1>

                <p className="mx-auto max-w-3xl text-lg text-gray-600">
                    Upload an invoice PDF and let artificial intelligence extract
                    structured, machine-readable data in seconds.
                </p>
            </div>

            {/* Main Layout */}
            <div className="grid grid-cols-1 gap-10 lg:grid-cols-2">
                {/* LEFT — Upload */}
                <div className="rounded-3xl bg-white p-10 shadow-xl">
                    <h2 className="mb-6 text-2xl font-bold text-gray-800">
                        Upload invoice
                    </h2>

                    <InvoiceDropzone
                        onFileSelected={(file) => extractInvoice(file)}
                        disabled={isPending}
                    />

                    {isPending && (
                        <p className="mt-6 text-center text-sm text-blue-600">
                            Extracting invoice data…
                        </p>
                    )}

                    {isError && (
                        <p className="mt-6 text-center text-sm text-red-600">
                            {error?.message}
                        </p>
                    )}

                    <p className="mt-6 text-center text-sm text-gray-500">
                        Supported format: PDF · Best results with digital invoices
                    </p>
                </div>

                {/* RIGHT — Result / Info */}
                <div className="relative rounded-3xl border border-dashed border-gray-300 bg-gray-50 p-10">
                    <h2 className="mb-4 text-2xl font-bold text-gray-800">
                        AI extraction result
                    </h2>

                    {/* Result */}
                    {data ? (
                        <pre className="overflow-auto rounded-2xl bg-white p-6 text-sm shadow-sm">
                            {JSON.stringify(data, null, 2)}
                        </pre>
                    ) : (
                        <div className="flex h-full flex-col justify-center">
                            <div className="rounded-2xl bg-white p-6 shadow-sm">
                                <p className="mb-3 text-sm font-semibold text-purple-600">
                                    How it works
                                </p>

                                <p className="mb-4 text-gray-600">
                                    Once you upload an invoice, the system will:
                                </p>

                                <ul className="list-inside list-disc space-y-2 text-gray-600">
                                    <li>Read the PDF content securely</li>
                                    <li>
                                        Identify key invoice fields (amounts, dates,
                                        supplier)
                                    </li>
                                    <li>Normalize the data into a structured format</li>
                                    <li>
                                        Return a clean JSON response ready for
                                        automation
                                    </li>
                                </ul>

                                <p className="mt-6 text-sm text-gray-500">
                                    The extracted data will appear here as soon as
                                    processing is completed.
                                </p>
                            </div>
                        </div>
                    )}
                </div>
            </div>
        </PageContainer>
    );
}
