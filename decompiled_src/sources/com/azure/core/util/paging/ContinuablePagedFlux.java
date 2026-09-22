package com.azure.core.util.paging;

import com.azure.core.util.paging.ContinuablePage;
import java.util.Objects;
import java.util.function.Predicate;
import reactor.core.publisher.Flux;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class ContinuablePagedFlux<C, T, P extends ContinuablePage<C, T>> extends Flux<T> {
    private final Predicate<C> continuationPredicate;

    public abstract Flux<P> byPage();

    public abstract Flux<P> byPage(int i);

    public abstract Flux<P> byPage(C c);

    public abstract Flux<P> byPage(C c, int i);

    public ContinuablePagedFlux() {
        this(new Predicate() { // from class: com.azure.core.util.paging.ContinuablePagedFlux$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Objects.nonNull(obj);
            }
        });
    }

    protected ContinuablePagedFlux(Predicate<C> predicate) {
        this.continuationPredicate = predicate == null ? new Predicate() { // from class: com.azure.core.util.paging.ContinuablePagedFlux$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Objects.nonNull(obj);
            }
        } : predicate;
    }

    protected final Predicate<C> getContinuationPredicate() {
        return this.continuationPredicate;
    }
}
