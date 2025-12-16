import { useRef, useState } from "react";

type Props = {
    onFileSelected: (file: File) => void;
    disabled?: boolean;
};

export default function InvoiceDropzone({
                                            onFileSelected,
                                            disabled = false,
                                        }: Props) {
    const inputRef = useRef<HTMLInputElement>(null);
    const [isDragging, setIsDragging] = useState(false);
    const [file, setFile] = useState<File | null>(null);
    const [error, setError] = useState<string | null>(null);

    const handleFile = (selected: File) => {
        if (disabled) return;

        if (selected.type !== "application/pdf") {
            setError("Only PDF files are allowed");
            return;
        }

        setError(null);
        setFile(selected);
        onFileSelected(selected);
    };

    return (
        <div className="w-full">
            <div
                className={`flex cursor-pointer flex-col items-center justify-center rounded-2xl border-2 border-dashed p-10 transition
                ${
                    disabled
                        ? "cursor-not-allowed border-gray-200 bg-gray-100 opacity-60"
                        : isDragging
                            ? "border-purple-500 bg-purple-50"
                            : "border-gray-300 hover:border-purple-400 hover:bg-gray-50"
                }`}
                onClick={() => !disabled && inputRef.current?.click()}
                onDragOver={(e) => {
                    if (disabled) return;
                    e.preventDefault();
                    setIsDragging(true);
                }}
                onDragLeave={() => setIsDragging(false)}
                onDrop={(e) => {
                    if (disabled) return;
                    e.preventDefault();
                    setIsDragging(false);
                    const dropped = e.dataTransfer.files?.[0];
                    if (dropped) handleFile(dropped);
                }}
            >
                <input
                    ref={inputRef}
                    type="file"
                    accept="application/pdf"
                    className="hidden"
                    disabled={disabled}
                    onChange={(e) => {
                        const f = e.target.files?.[0];
                        if (f) handleFile(f);
                    }}
                />

                <div className="text-5xl">📄</div>

                {file ? (
                    <p className="mt-4 truncate font-medium text-purple-700">
                        {file.name}
                    </p>
                ) : (
                    <>
                        <p className="mt-4 text-lg font-semibold">
                            Drop your invoice PDF here
                        </p>
                        <p className="text-sm text-gray-500">
                            or click to browse
                        </p>
                    </>
                )}
            </div>

            {error && (
                <p className="mt-2 text-sm text-red-600 text-center">
                    {error}
                </p>
            )}
        </div>
    );
}
