import { ReactNode } from "react";

type Props = {
    children: ReactNode;
};

export default function PageContainer({ children }: Props) {
    return (
        <div className="min-h-screen bg-gradient-to-br from-purple-50 via-white to-purple-100">
            <div className="mx-auto max-w-5xl px-6 py-20">
                {children}
            </div>
        </div>
    );
}
