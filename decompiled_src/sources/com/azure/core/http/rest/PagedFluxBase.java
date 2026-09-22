package com.azure.core.http.rest;

import com.azure.core.http.rest.PagedResponse;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.paging.ContinuablePagedFluxCore;
import com.azure.core.util.paging.PageRetriever;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Deprecated
public class PagedFluxBase<T, P extends PagedResponse<T>> extends ContinuablePagedFluxCore<String, T, P> {
    public PagedFluxBase(Supplier<Mono<P>> supplier) {
        this(supplier, new Function() { // from class: com.azure.core.http.rest.PagedFluxBase$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.empty();
            }
        });
    }

    public PagedFluxBase(final Supplier<Mono<P>> supplier, final Function<String, Mono<P>> function) {
        this(new Supplier() { // from class: com.azure.core.http.rest.PagedFluxBase$$ExternalSyntheticLambda3
            @Override // java.util.function.Supplier
            public final Object get() {
                return PagedFluxBase.lambda$new$2(supplier, function);
            }
        }, true);
    }

    static /* synthetic */ PageRetriever lambda$new$2(final Supplier supplier, final Function function) {
        return new PageRetriever() { // from class: com.azure.core.http.rest.PagedFluxBase$$ExternalSyntheticLambda1
            @Override // com.azure.core.util.paging.PageRetriever
            public final Flux get(Object obj, Integer num) {
                return PagedFluxBase.lambda$new$1(supplier, function, (String) obj, num);
            }
        };
    }

    static /* synthetic */ Flux lambda$new$1(Supplier supplier, Function function, String str, Integer num) {
        if (str == null) {
            return ((Mono) supplier.get()).flux();
        }
        return ((Mono) function.apply(str)).flux();
    }

    PagedFluxBase(Supplier<PageRetriever<String, P>> supplier, boolean z) {
        super(supplier, null, new Predicate() { // from class: com.azure.core.http.rest.PagedFluxBase$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return PagedFluxBase.lambda$new$3((String) obj);
            }
        });
    }

    static /* synthetic */ boolean lambda$new$3(String str) {
        return !CoreUtils.isNullOrEmpty(str);
    }

    @Override // com.azure.core.util.paging.ContinuablePagedFluxCore, com.azure.core.util.paging.ContinuablePagedFlux
    public Flux<P> byPage() {
        return super.byPage();
    }

    @Override // com.azure.core.util.paging.ContinuablePagedFluxCore, com.azure.core.util.paging.ContinuablePagedFlux
    public Flux<P> byPage(String str) {
        return super.byPage(str);
    }

    @Override // com.azure.core.util.paging.ContinuablePagedFluxCore
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        super.subscribe(coreSubscriber);
    }
}
