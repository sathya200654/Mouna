package com.azure.core.util.paging;

import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.paging.ContinuablePage;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
abstract class ContinuablePagedByIteratorBase<C, T, P extends ContinuablePage<C, T>, E> implements Iterator<E> {
    private final ContinuationState<C> continuationState;
    private final Integer defaultPageSize;
    private volatile boolean done;
    private final ClientLogger logger;
    private final PageRetriever<C, P> pageRetriever;
    private final PageRetrieverSync<C, P> pageRetrieverSync;

    abstract void addPage(P p);

    abstract E getNext();

    abstract boolean isNextAvailable();

    abstract boolean needToRequestPage();

    ContinuablePagedByIteratorBase(PageRetriever<C, P> pageRetriever, ContinuationState<C> continuationState, Integer num, ClientLogger clientLogger) {
        this.continuationState = continuationState;
        this.pageRetriever = pageRetriever;
        this.defaultPageSize = num;
        this.logger = clientLogger;
        this.pageRetrieverSync = null;
    }

    ContinuablePagedByIteratorBase(PageRetrieverSync<C, P> pageRetrieverSync, ContinuationState<C> continuationState, Integer num, ClientLogger clientLogger) {
        this.continuationState = continuationState;
        this.pageRetrieverSync = pageRetrieverSync;
        this.defaultPageSize = num;
        this.logger = clientLogger;
        this.pageRetriever = null;
    }

    @Override // java.util.Iterator
    public E next() {
        if (!hasNext()) {
            throw this.logger.logExceptionAsError(new NoSuchElementException("Iterator contains no more elements."));
        }
        return getNext();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (!this.done && needToRequestPage()) {
            requestPage();
        }
        return isNextAvailable();
    }

    synchronized void requestPage() {
        ContinuablePage continuablePage;
        boolean z = false;
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        if (this.pageRetriever != null) {
            if (!isNextAvailable() && !this.done) {
                this.pageRetriever.get(this.continuationState.getLastContinuationToken(), this.defaultPageSize).map(new Function() { // from class: com.azure.core.util.paging.ContinuablePagedByIteratorBase$$ExternalSyntheticLambda0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.f$0.m1242x3d4f9496(atomicBoolean, (ContinuablePage) obj);
                    }
                }).blockLast();
            }
            return;
        } else {
            PageRetrieverSync<C, P> pageRetrieverSync = this.pageRetrieverSync;
            if (pageRetrieverSync != null && (continuablePage = (ContinuablePage) pageRetrieverSync.getPage(this.continuationState.getLastContinuationToken(), this.defaultPageSize)) != null) {
                receivePage(atomicBoolean, continuablePage);
            }
        }
        if (this.done || (!atomicBoolean.get() && !isNextAvailable())) {
            z = true;
        }
        this.done = z;
    }

    /* JADX INFO: renamed from: lambda$requestPage$0$com-azure-core-util-paging-ContinuablePagedByIteratorBase, reason: not valid java name */
    /* synthetic */ ContinuablePage m1242x3d4f9496(AtomicBoolean atomicBoolean, ContinuablePage continuablePage) {
        receivePage(atomicBoolean, continuablePage);
        return continuablePage;
    }

    private void receivePage(AtomicBoolean atomicBoolean, P p) {
        atomicBoolean.set(true);
        addPage(p);
        this.continuationState.setLastContinuationToken((C) p.getContinuationToken());
        this.done = this.continuationState.isDone();
    }
}
