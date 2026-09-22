package com.azure.core.http.rest;

import com.azure.core.util.paging.PageRetrieverSync;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class PagedIterable<T> extends PagedIterableBase<T, PagedResponse<T>> {
    private final Function<Integer, PagedResponse<T>> firstPageRetriever;
    private final BiFunction<String, Integer, PagedResponse<T>> nextPageRetriever;
    private final PagedFlux<T> pagedFlux;

    static /* synthetic */ PagedResponse lambda$new$0(String str, Integer num) {
        return null;
    }

    public PagedIterable(PagedFlux<T> pagedFlux) {
        super(pagedFlux);
        this.pagedFlux = pagedFlux;
        this.firstPageRetriever = null;
        this.nextPageRetriever = null;
    }

    public PagedIterable(Supplier<PagedResponse<T>> supplier) {
        this(supplier, (Function) null);
    }

    public PagedIterable(Function<Integer, PagedResponse<T>> function) {
        this(function, new BiFunction() { // from class: com.azure.core.http.rest.PagedIterable$$ExternalSyntheticLambda1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return PagedIterable.lambda$new$0((String) obj, (Integer) obj2);
            }
        });
    }

    public PagedIterable(final Supplier<PagedResponse<T>> supplier, final Function<String, PagedResponse<T>> function) {
        this(new Supplier() { // from class: com.azure.core.http.rest.PagedIterable$$ExternalSyntheticLambda5
            @Override // java.util.function.Supplier
            public final Object get() {
                return PagedIterable.lambda$new$2(supplier, function);
            }
        }, new Function() { // from class: com.azure.core.http.rest.PagedIterable$$ExternalSyntheticLambda6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return PagedIterable.lambda$new$3(supplier, (Integer) obj);
            }
        }, new BiFunction() { // from class: com.azure.core.http.rest.PagedIterable$$ExternalSyntheticLambda7
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return PagedIterable.lambda$new$4(function, (String) obj, (Integer) obj2);
            }
        });
    }

    static /* synthetic */ PageRetrieverSync lambda$new$2(final Supplier supplier, final Function function) {
        return new PageRetrieverSync() { // from class: com.azure.core.http.rest.PagedIterable$$ExternalSyntheticLambda0
            @Override // com.azure.core.util.paging.PageRetrieverSync
            public final Object getPage(Object obj, Integer num) {
                return PagedIterable.lambda$new$1(supplier, function, (String) obj, num);
            }
        };
    }

    static /* synthetic */ PagedResponse lambda$new$1(Supplier supplier, Function function, String str, Integer num) {
        if (str == null) {
            return (PagedResponse) supplier.get();
        }
        return (PagedResponse) function.apply(str);
    }

    static /* synthetic */ PagedResponse lambda$new$3(Supplier supplier, Integer num) {
        return (PagedResponse) supplier.get();
    }

    static /* synthetic */ PagedResponse lambda$new$4(Function function, String str, Integer num) {
        return (PagedResponse) function.apply(str);
    }

    public PagedIterable(final Function<Integer, PagedResponse<T>> function, final BiFunction<String, Integer, PagedResponse<T>> biFunction) {
        this(new Supplier() { // from class: com.azure.core.http.rest.PagedIterable$$ExternalSyntheticLambda4
            @Override // java.util.function.Supplier
            public final Object get() {
                return PagedIterable.lambda$new$6(function, biFunction);
            }
        }, function, biFunction);
    }

    static /* synthetic */ PageRetrieverSync lambda$new$6(final Function function, final BiFunction biFunction) {
        return new PageRetrieverSync() { // from class: com.azure.core.http.rest.PagedIterable$$ExternalSyntheticLambda2
            @Override // com.azure.core.util.paging.PageRetrieverSync
            public final Object getPage(Object obj, Integer num) {
                return PagedIterable.lambda$new$5(function, biFunction, (String) obj, num);
            }
        };
    }

    static /* synthetic */ PagedResponse lambda$new$5(Function function, BiFunction biFunction, String str, Integer num) {
        if (str == null) {
            return (PagedResponse) function.apply(num);
        }
        return (PagedResponse) biFunction.apply(str, num);
    }

    public <S> PagedIterable<S> mapPage(final Function<T, S> function) {
        PagedFlux<T> pagedFlux = this.pagedFlux;
        if (pagedFlux != null) {
            return new PagedIterable<>(pagedFlux.mapPage(function));
        }
        return new PagedIterable<>(new Function() { // from class: com.azure.core.http.rest.PagedIterable$$ExternalSyntheticLambda8
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1144lambda$mapPage$7$comazurecorehttprestPagedIterable(function, (Integer) obj);
            }
        }, new BiFunction() { // from class: com.azure.core.http.rest.PagedIterable$$ExternalSyntheticLambda9
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return this.f$0.m1145lambda$mapPage$8$comazurecorehttprestPagedIterable(function, (String) obj, (Integer) obj2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$mapPage$7$com-azure-core-http-rest-PagedIterable, reason: not valid java name */
    /* synthetic */ PagedResponse m1144lambda$mapPage$7$comazurecorehttprestPagedIterable(Function function, Integer num) {
        return mapPagedResponse(this.firstPageRetriever.apply(num), function);
    }

    /* JADX INFO: renamed from: lambda$mapPage$8$com-azure-core-http-rest-PagedIterable, reason: not valid java name */
    /* synthetic */ PagedResponse m1145lambda$mapPage$8$comazurecorehttprestPagedIterable(Function function, String str, Integer num) {
        return mapPagedResponse(this.nextPageRetriever.apply(str, num), function);
    }

    private PagedIterable(Supplier<PageRetrieverSync<String, PagedResponse<T>>> supplier, Function<Integer, PagedResponse<T>> function, BiFunction<String, Integer, PagedResponse<T>> biFunction) {
        super(supplier);
        this.pagedFlux = null;
        this.firstPageRetriever = function;
        this.nextPageRetriever = biFunction;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <S> PagedResponse<S> mapPagedResponse(final PagedResponse<T> pagedResponse, Function<T, S> function) {
        if (pagedResponse == null) {
            return null;
        }
        return new PagedResponseBase(pagedResponse.getRequest(), pagedResponse.getStatusCode(), pagedResponse.getHeaders(), (List) pagedResponse.getValue().stream().map(function).collect(Collectors.toCollection(new Supplier() { // from class: com.azure.core.http.rest.PagedIterable$$ExternalSyntheticLambda3
            @Override // java.util.function.Supplier
            public final Object get() {
                return PagedIterable.lambda$mapPagedResponse$9(pagedResponse);
            }
        })), pagedResponse.getContinuationToken(), null);
    }

    static /* synthetic */ ArrayList lambda$mapPagedResponse$9(PagedResponse pagedResponse) {
        return new ArrayList(pagedResponse.getValue().size());
    }
}
