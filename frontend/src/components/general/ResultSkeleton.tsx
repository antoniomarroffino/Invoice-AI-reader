export function ResultSkeleton() {
    return (
        <div className="space-y-4">
            <SkeletonBlock />
            <SkeletonBlock />
            <SkeletonBlock />
        </div>
    );
}

export function SkeletonBlock() {
    return (
        <div className="h-24 animate-pulse rounded-2xl bg-white shadow-sm" />
    );
}
