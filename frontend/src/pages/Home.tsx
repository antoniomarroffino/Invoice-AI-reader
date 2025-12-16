import InvoiceDropzone from "../components/InvoiceDropzone";
import PageContainer from "../components/PageContainer";
import InvoiceResult from "../components/InvoiceResult";
import { useExtractInvoice } from "../hooks/useExtractInvoice";
import {Spinner} from "../components/general/Spinner.tsx";
import {ResultSkeleton} from "../components/general/ResultSkeleton.tsx";
import {ResultPlaceholder} from "../components/general/ResultPlaceholder.tsx";

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
                        onExtract={(file) => extractInvoice(file)}
                        disabled={isPending}
                    />

                    {/* Loading */}
                    {isPending && (
                        <div className="mt-6 flex items-center justify-center gap-2 text-sm text-blue-600">
                            <Spinner />
                            Extracting invoice data…
                        </div>
                    )}

                    {/* Error */}
                    {isError && (
                        <p className="mt-6 text-center text-sm text-red-600">
                            {error instanceof Error
                                ? error.message
                                : "Unexpected error occurred"}
                        </p>
                    )}

                    <p className="mt-6 text-center text-sm text-gray-500">
                        Supported format: PDF · Best results with digital invoices
                    </p>
                </div>

                {/* RIGHT — Result */}
                <div className="relative rounded-3xl border border-dashed border-gray-300 bg-gray-50 p-10">
                    <h2 className="mb-6 text-2xl font-bold text-gray-800">
                        AI extraction result
                    </h2>

                    {isPending && !data && (
                        <ResultSkeleton />
                    )}

                    {!isPending && data && (
                        <InvoiceResult data={data} />
                    )}

                    {!isPending && !data && !isError && (
                        <ResultPlaceholder />
                    )}
                </div>
            </div>
        </PageContainer>
    );
}
