package com.azure.core.util.paging;

import java.util.function.Predicate;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
class ContinuationState<C> {
    private final Predicate<C> continuationPredicate;
    private boolean isDone;
    private C lastContinuationToken;

    ContinuationState(C c, Predicate<C> predicate) {
        this.lastContinuationToken = c;
        this.continuationPredicate = predicate;
    }

    void setLastContinuationToken(C c) {
        this.isDone = !this.continuationPredicate.test(c);
        this.lastContinuationToken = c;
    }

    C getLastContinuationToken() {
        return this.lastContinuationToken;
    }

    boolean isDone() {
        return this.isDone;
    }
}
