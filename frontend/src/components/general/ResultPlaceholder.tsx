export function ResultPlaceholder() {
    return (
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
                        Identify key invoice fields (amounts, dates, supplier)
                    </li>
                    <li>Normalize the data into a structured format</li>
                    <li>
                        Return a clean JSON response ready for automation
                    </li>
                </ul>

                <p className="mt-6 text-sm text-gray-500">
                    The extracted data will appear here as soon as processing is
                    completed.
                </p>
            </div>
        </div>
    );
}
