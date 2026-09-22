package com.azure.core.util.paging;

import com.azure.core.util.IterableStream;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.paging.ContinuablePage;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class ContinuablePagedIterable<C, T, P extends ContinuablePage<C, T>> extends IterableStream<T> {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) ContinuablePagedIterable.class);
    private final int batchSize;
    private final Predicate<C> continuationPredicate;
    final Integer defaultPageSize;
    private final Supplier<PageRetrieverSync<C, P>> pageRetrieverSyncProvider;
    private final ContinuablePagedFlux<C, T, P> pagedFlux;

    public ContinuablePagedIterable(ContinuablePagedFlux<C, T, P> continuablePagedFlux) {
        this(continuablePagedFlux, 1);
    }

    public ContinuablePagedIterable(ContinuablePagedFlux<C, T, P> continuablePagedFlux, int i) {
        super(continuablePagedFlux);
        this.pagedFlux = continuablePagedFlux;
        this.batchSize = i;
        this.defaultPageSize = null;
        this.continuationPredicate = null;
        this.pageRetrieverSyncProvider = null;
    }

    public ContinuablePagedIterable(Supplier<PageRetrieverSync<C, P>> supplier, Integer num, Predicate<C> predicate) {
        super(new ContinuablePagedByItemIterable(supplier.get(), (Object) null, predicate, num));
        this.pageRetrieverSyncProvider = (Supplier) Objects.requireNonNull(supplier, "'pageRetrieverSyncProvider' function cannot be null.");
        if (num != null && num.intValue() <= 0) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'pageSize' must be greater than 0 required but provided: " + num));
        }
        this.continuationPredicate = predicate == null ? new Predicate() { // from class: com.azure.core.util.paging.ContinuablePagedIterable$$ExternalSyntheticLambda7
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Objects.nonNull(obj);
            }
        } : predicate;
        this.defaultPageSize = num;
        this.batchSize = 1;
        this.pagedFlux = null;
    }

    @Override // com.azure.core.util.IterableStream
    public Stream<T> stream() {
        return StreamSupport.stream(iterableByItemInternal().spliterator(), false);
    }

    /* JADX INFO: renamed from: lambda$streamByPage$0$com-azure-core-util-paging-ContinuablePagedIterable, reason: not valid java name */
    /* synthetic */ Stream m1252xba7ec1b4() {
        return this.pagedFlux.byPage().toStream(this.batchSize);
    }

    public Stream<P> streamByPage() {
        return streamByPageInternal(null, null, new Supplier() { // from class: com.azure.core.util.paging.ContinuablePagedIterable$$ExternalSyntheticLambda6
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1252xba7ec1b4();
            }
        });
    }

    public Stream<P> streamByPage(final C c) {
        return streamByPageInternal(c, null, new Supplier() { // from class: com.azure.core.util.paging.ContinuablePagedIterable$$ExternalSyntheticLambda2
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1253x47b97335(c);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$streamByPage$1$com-azure-core-util-paging-ContinuablePagedIterable, reason: not valid java name */
    /* synthetic */ Stream m1253x47b97335(Object obj) {
        return this.pagedFlux.byPage(obj).toStream(this.batchSize);
    }

    public Stream<P> streamByPage(final int i) {
        return streamByPageInternal(null, Integer.valueOf(i), new Supplier() { // from class: com.azure.core.util.paging.ContinuablePagedIterable$$ExternalSyntheticLambda3
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1254xd4f424b6(i);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$streamByPage$2$com-azure-core-util-paging-ContinuablePagedIterable, reason: not valid java name */
    /* synthetic */ Stream m1254xd4f424b6(int i) {
        return this.pagedFlux.byPage(i).toStream(this.batchSize);
    }

    public Stream<P> streamByPage(final C c, final int i) {
        return streamByPageInternal(c, Integer.valueOf(i), new Supplier() { // from class: com.azure.core.util.paging.ContinuablePagedIterable$$ExternalSyntheticLambda4
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1255x622ed637(c, i);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$streamByPage$3$com-azure-core-util-paging-ContinuablePagedIterable, reason: not valid java name */
    /* synthetic */ Stream m1255x622ed637(Object obj, int i) {
        return this.pagedFlux.byPage(obj, i).toStream(this.batchSize);
    }

    @Override // com.azure.core.util.IterableStream, java.lang.Iterable
    public Iterator<T> iterator() {
        return iterableByItemInternal().iterator();
    }

    public Iterable<P> iterableByPage() {
        return iterableByPageInternal(null, null, new Supplier() { // from class: com.azure.core.util.paging.ContinuablePagedIterable$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1248xf2eb2a6a();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$iterableByPage$4$com-azure-core-util-paging-ContinuablePagedIterable, reason: not valid java name */
    /* synthetic */ Iterable m1248xf2eb2a6a() {
        return this.pagedFlux.byPage().toIterable(this.batchSize);
    }

    public Iterable<P> iterableByPage(final C c) {
        return iterableByPageInternal(c, null, new Supplier() { // from class: com.azure.core.util.paging.ContinuablePagedIterable$$ExternalSyntheticLambda5
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1249x8025dbeb(c);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$iterableByPage$5$com-azure-core-util-paging-ContinuablePagedIterable, reason: not valid java name */
    /* synthetic */ Iterable m1249x8025dbeb(Object obj) {
        return this.pagedFlux.byPage(obj).toIterable(this.batchSize);
    }

    public Iterable<P> iterableByPage(final int i) {
        return iterableByPageInternal(null, Integer.valueOf(i), new Supplier() { // from class: com.azure.core.util.paging.ContinuablePagedIterable$$ExternalSyntheticLambda8
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1250xd608d6c(i);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$iterableByPage$6$com-azure-core-util-paging-ContinuablePagedIterable, reason: not valid java name */
    /* synthetic */ Iterable m1250xd608d6c(int i) {
        return this.pagedFlux.byPage(i).toIterable(this.batchSize);
    }

    public Iterable<P> iterableByPage(final C c, final int i) {
        return iterableByPageInternal(c, Integer.valueOf(i), new Supplier() { // from class: com.azure.core.util.paging.ContinuablePagedIterable$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1251x9a9b3eed(c, i);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$iterableByPage$7$com-azure-core-util-paging-ContinuablePagedIterable, reason: not valid java name */
    /* synthetic */ Iterable m1251x9a9b3eed(Object obj, int i) {
        return this.pagedFlux.byPage(obj, i).toIterable(this.batchSize);
    }

    private Stream<P> streamByPageInternal(C c, Integer num, Supplier<Stream<P>> supplier) {
        ContinuablePagedFlux<C, T, P> continuablePagedFlux = this.pagedFlux;
        if (continuablePagedFlux == null) {
            return StreamSupport.stream(iterableByPageInternal(c, num, null).spliterator(), false);
        }
        if (continuablePagedFlux instanceof ContinuablePagedFluxCore) {
            return StreamSupport.stream(iterableByPageInternal(c, num, null).spliterator(), false);
        }
        return supplier.get();
    }

    private Iterable<P> iterableByPageInternal(C c, Integer num, Supplier<Iterable<P>> supplier) {
        ContinuablePagedFlux<C, T, P> continuablePagedFlux = this.pagedFlux;
        if (continuablePagedFlux == null) {
            return new ContinuablePagedByPageIterable(this.pageRetrieverSyncProvider.get(), c, this.continuationPredicate, num);
        }
        if (continuablePagedFlux instanceof ContinuablePagedFluxCore) {
            ContinuablePagedFluxCore continuablePagedFluxCore = (ContinuablePagedFluxCore) continuablePagedFlux;
            return new ContinuablePagedByPageIterable(continuablePagedFluxCore.pageRetrieverProvider.get(), c, continuablePagedFluxCore.getContinuationPredicate(), num);
        }
        return supplier.get();
    }

    private Iterable<T> iterableByItemInternal() {
        ContinuablePagedFlux<C, T, P> continuablePagedFlux = this.pagedFlux;
        if (continuablePagedFlux == null) {
            return new ContinuablePagedByItemIterable(this.pageRetrieverSyncProvider.get(), (Object) null, this.continuationPredicate, (Integer) null);
        }
        if (continuablePagedFlux instanceof ContinuablePagedFluxCore) {
            ContinuablePagedFluxCore continuablePagedFluxCore = (ContinuablePagedFluxCore) continuablePagedFlux;
            return new ContinuablePagedByItemIterable(continuablePagedFluxCore.pageRetrieverProvider.get(), (Object) null, continuablePagedFluxCore.getContinuationPredicate(), (Integer) null);
        }
        return continuablePagedFlux.toIterable(this.batchSize);
    }
}
