import InvoiceDropzone from "../components/InvoiceDropzone";
import PageContainer from "../components/PageContainer";

export default function Home() {
    return (
        <PageContainer>
            {/* Header */}
            <div className="mb-14 text-center">
                <h1 className="mb-4 text-5xl font-extrabold tracking-tight text-gray-900">
                    Invoice AI Reader
                </h1>

                <p className="mx-auto max-w-2xl text-lg text-gray-600">
                    Upload an invoice PDF and automatically extract structured data using AI.
                </p>
            </div>

            {/* Main Card */}
            <div className="mx-auto max-w-2xl rounded-3xl bg-white p-10 shadow-xl">
                <InvoiceDropzone
                    onFileSelected={(file) => {
                        console.log("PDF selected:", file);
                    }}
                />

                <p className="mt-6 text-center text-sm text-gray-500">
                    Supported format: PDF · Swiss invoices recommended
                </p>
            </div>
        </PageContainer>
    );
}
