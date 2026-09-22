package com.azure.core.util.paging;

import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.paging.ContinuablePage;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.reactivestreams.Publisher;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class ContinuablePagedFluxCore<C, T, P extends ContinuablePage<C, T>> extends ContinuablePagedFlux<C, T, P> {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) ContinuablePagedFluxCore.class);
    final Integer defaultPageSize;
    final Supplier<PageRetriever<C, P>> pageRetrieverProvider;

    protected ContinuablePagedFluxCore(Supplier<PageRetriever<C, P>> supplier) {
        this(supplier, null, null);
    }

    protected ContinuablePagedFluxCore(Supplier<PageRetriever<C, P>> supplier, int i) {
        this(supplier, Integer.valueOf(i), null);
    }

    protected ContinuablePagedFluxCore(Supplier<PageRetriever<C, P>> supplier, Integer num, Predicate<C> predicate) {
        super(predicate);
        this.pageRetrieverProvider = (Supplier) Objects.requireNonNull(supplier, "'pageRetrieverProvider' function cannot be null.");
        if (num != null && num.intValue() <= 0) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'pageSize' must be greater than 0 required but provided: " + num));
        }
        this.defaultPageSize = num;
    }

    public Integer getPageSize() {
        return this.defaultPageSize;
    }

    @Override // com.azure.core.util.paging.ContinuablePagedFlux
    public Flux<P> byPage() {
        return byPage(this.pageRetrieverProvider, null, this.defaultPageSize);
    }

    @Override // com.azure.core.util.paging.ContinuablePagedFlux
    public Flux<P> byPage(C c) {
        if (c == null) {
            return Flux.empty();
        }
        return byPage(this.pageRetrieverProvider, c, this.defaultPageSize);
    }

    @Override // com.azure.core.util.paging.ContinuablePagedFlux
    public Flux<P> byPage(int i) {
        if (i <= 0) {
            return Flux.error(new IllegalArgumentException("preferredPageSize > 0 required but provided: " + i));
        }
        return byPage(this.pageRetrieverProvider, null, Integer.valueOf(i));
    }

    @Override // com.azure.core.util.paging.ContinuablePagedFlux
    public Flux<P> byPage(C c, int i) {
        if (i <= 0) {
            return Flux.error(new IllegalArgumentException("preferredPageSize > 0 required but provided: " + i));
        }
        if (c == null) {
            return Flux.empty();
        }
        return byPage(this.pageRetrieverProvider, c, Integer.valueOf(i));
    }

    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        byPage(this.pageRetrieverProvider, null, this.defaultPageSize).flatMap(new Function() { // from class: com.azure.core.util.paging.ContinuablePagedFluxCore$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ContinuablePagedFluxCore.lambda$subscribe$0((ContinuablePage) obj);
            }
        }).subscribe(coreSubscriber);
    }

    static /* synthetic */ Publisher lambda$subscribe$0(ContinuablePage continuablePage) {
        return continuablePage.getElements() == null ? Flux.empty() : Flux.fromIterable(continuablePage.getElements());
    }

    private Flux<P> byPage(final Supplier<PageRetriever<C, P>> supplier, final C c, final Integer num) {
        return Flux.defer(new Supplier() { // from class: com.azure.core.util.paging.ContinuablePagedFluxCore$$ExternalSyntheticLambda3
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1244x1641960b(supplier, c, num);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$byPage$1$com-azure-core-util-paging-ContinuablePagedFluxCore, reason: not valid java name */
    /* synthetic */ Publisher m1244x1641960b(Supplier supplier, Object obj, Integer num) {
        return retrievePages(new ContinuationState<>(obj, getContinuationPredicate()), (PageRetriever) supplier.get(), num);
    }

    private Flux<P> retrievePages(final ContinuationState<C> continuationState, final PageRetriever<C, P> pageRetriever, final Integer num) {
        return m1245xd292c954(continuationState, pageRetriever, num).expand(new Function() { // from class: com.azure.core.util.paging.ContinuablePagedFluxCore$$ExternalSyntheticLambda4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1246x5fcd7ad5(continuationState, pageRetriever, num, (ContinuablePage) obj);
            }
        }, 4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: lambda$retrievePages$3$com-azure-core-util-paging-ContinuablePagedFluxCore, reason: not valid java name */
    /* synthetic */ Publisher m1246x5fcd7ad5(final ContinuationState continuationState, final PageRetriever pageRetriever, final Integer num, ContinuablePage continuablePage) {
        continuationState.setLastContinuationToken(continuablePage.getContinuationToken());
        return Flux.defer(new Supplier() { // from class: com.azure.core.util.paging.ContinuablePagedFluxCore$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1245xd292c954(continuationState, pageRetriever, num);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: retrievePage, reason: merged with bridge method [inline-methods] */
    public Flux<P> m1245xd292c954(final ContinuationState<C> continuationState, PageRetriever<C, P> pageRetriever, Integer num) {
        if (continuationState.isDone()) {
            return Flux.empty();
        }
        return pageRetriever.get(continuationState.getLastContinuationToken(), num).switchIfEmpty(Mono.fromRunnable(new Runnable() { // from class: com.azure.core.util.paging.ContinuablePagedFluxCore$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                continuationState.setLastContinuationToken(null);
            }
        }));
    }
}
