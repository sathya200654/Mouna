package com.azure.core.http.rest;

import com.azure.core.util.paging.PageRetriever;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class PagedFlux<T> extends PagedFluxBase<T, PagedResponse<T>> {
    public PagedFlux(Supplier<Mono<PagedResponse<T>>> supplier) {
        this(supplier, new Function() { // from class: com.azure.core.http.rest.PagedFlux$$ExternalSyntheticLambda6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.empty();
            }
        });
    }

    public PagedFlux(Function<Integer, Mono<PagedResponse<T>>> function) {
        this(function, new BiFunction() { // from class: com.azure.core.http.rest.PagedFlux$$ExternalSyntheticLambda8
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Mono.empty();
            }
        });
    }

    public PagedFlux(final Supplier<Mono<PagedResponse<T>>> supplier, final Function<String, Mono<PagedResponse<T>>> function) {
        this(new Supplier() { // from class: com.azure.core.http.rest.PagedFlux$$ExternalSyntheticLambda4
            @Override // java.util.function.Supplier
            public final Object get() {
                return PagedFlux.lambda$new$3(supplier, function);
            }
        }, true);
    }

    static /* synthetic */ PageRetriever lambda$new$3(final Supplier supplier, final Function function) {
        return new PageRetriever() { // from class: com.azure.core.http.rest.PagedFlux$$ExternalSyntheticLambda3
            @Override // com.azure.core.util.paging.PageRetriever
            public final Flux get(Object obj, Integer num) {
                return PagedFlux.lambda$new$2(supplier, function, (String) obj, num);
            }
        };
    }

    static /* synthetic */ Flux lambda$new$2(Supplier supplier, Function function, String str, Integer num) {
        if (str == null) {
            return ((Mono) supplier.get()).flux();
        }
        return ((Mono) function.apply(str)).flux();
    }

    public PagedFlux(final Function<Integer, Mono<PagedResponse<T>>> function, final BiFunction<String, Integer, Mono<PagedResponse<T>>> biFunction) {
        this(new Supplier() { // from class: com.azure.core.http.rest.PagedFlux$$ExternalSyntheticLambda7
            @Override // java.util.function.Supplier
            public final Object get() {
                return PagedFlux.lambda$new$5(function, biFunction);
            }
        }, true);
    }

    static /* synthetic */ PageRetriever lambda$new$5(final Function function, final BiFunction biFunction) {
        return new PageRetriever() { // from class: com.azure.core.http.rest.PagedFlux$$ExternalSyntheticLambda0
            @Override // com.azure.core.util.paging.PageRetriever
            public final Flux get(Object obj, Integer num) {
                return PagedFlux.lambda$new$4(function, biFunction, (String) obj, num);
            }
        };
    }

    static /* synthetic */ Flux lambda$new$4(Function function, BiFunction biFunction, String str, Integer num) {
        if (str == null) {
            return ((Mono) function.apply(num)).flux();
        }
        return ((Mono) biFunction.apply(str, num)).flux();
    }

    private PagedFlux(Supplier<PageRetriever<String, PagedResponse<T>>> supplier, boolean z) {
        super(supplier, z);
    }

    public static <T> PagedFlux<T> create(Supplier<PageRetriever<String, PagedResponse<T>>> supplier) {
        return new PagedFlux<>((Supplier) supplier, true);
    }

    /* JADX INFO: renamed from: lambda$mapPage$7$com-azure-core-http-rest-PagedFlux, reason: not valid java name */
    /* synthetic */ PageRetriever m1143lambda$mapPage$7$comazurecorehttprestPagedFlux(final Function function) {
        return new PageRetriever() { // from class: com.azure.core.http.rest.PagedFlux$$ExternalSyntheticLambda1
            @Override // com.azure.core.util.paging.PageRetriever
            public final Flux get(Object obj, Integer num) {
                return this.f$0.m1142lambda$mapPage$6$comazurecorehttprestPagedFlux(function, (String) obj, num);
            }
        };
    }

    @Deprecated
    public <S> PagedFlux<S> mapPage(final Function<T, S> function) {
        return create(new Supplier() { // from class: com.azure.core.http.rest.PagedFlux$$ExternalSyntheticLambda5
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1143lambda$mapPage$7$comazurecorehttprestPagedFlux(function);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$mapPage$6$com-azure-core-http-rest-PagedFlux, reason: not valid java name */
    /* synthetic */ Flux m1142lambda$mapPage$6$comazurecorehttprestPagedFlux(Function function, String str, Integer num) {
        return (str == null ? byPage() : byPage(str)).map(mapPagedResponse(function));
    }

    static /* synthetic */ PagedResponse lambda$mapPagedResponse$8(Function function, PagedResponse pagedResponse) {
        return new PagedResponseBase(pagedResponse.getRequest(), pagedResponse.getStatusCode(), pagedResponse.getHeaders(), (List) pagedResponse.getValue().stream().map(function).collect(Collectors.toList()), pagedResponse.getContinuationToken(), null);
    }

    private <S> Function<PagedResponse<T>, PagedResponse<S>> mapPagedResponse(final Function<T, S> function) {
        return new Function() { // from class: com.azure.core.http.rest.PagedFlux$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return PagedFlux.lambda$mapPagedResponse$8(function, (PagedResponse) obj);
            }
        };
    }
}
