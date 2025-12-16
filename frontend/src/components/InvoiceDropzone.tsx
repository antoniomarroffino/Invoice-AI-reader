import { useRef, useState } from "react";

type Props = {
    onFileSelected: (file: File) => void;
};

export default function InvoiceDropzone({ onFileSelected }: Props) {
    const inputRef = useRef<HTMLInputElement>(null);
    const [isDragging, setIsDragging] = useState(false);
    const [file, setFile] = useState<File | null>(null);

    const handleFile = (selected: File) => {
        if (selected.type !== "application/pdf") {
            alert("Only PDF files are allowed");
            return;
        }
        setFile(selected);
        onFileSelected(selected);
    };

    return (
        <div
            className={`flex cursor-pointer flex-col items-center justify-center rounded-2xl border-2 border-dashed p-10 transition
        ${
                isDragging
                    ? "border-purple-500 bg-purple-50"
                    : "border-gray-300 hover:border-purple-400 hover:bg-gray-50"
            }`}
            onClick={() => inputRef.current?.click()}
            onDragOver={(e) => {
                e.preventDefault();
                setIsDragging(true);
            }}
            onDragLeave={() => setIsDragging(false)}
            onDrop={(e) => {
                e.preventDefault();
                setIsDragging(false);
                const dropped = e.dataTransfer.files[0];
                if (dropped) handleFile(dropped);
            }}
        >
            <input
                ref={inputRef}
                type="file"
                accept="application/pdf"
                className="hidden"
                onChange={(e) => {
                    const f = e.target.files?.[0];
                    if (f) handleFile(f);
                }}
            />

            <div className="text-5xl">📄</div>

            {file ? (
                <p className="mt-4 font-medium text-purple-700">
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
    );
}
