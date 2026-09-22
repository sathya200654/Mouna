package com.azure.core.util.paging;

import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.paging.ContinuablePage;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Predicate;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class ContinuablePagedByPageIterable<C, T, P extends ContinuablePage<C, T>> implements Iterable<P> {
    private final Predicate<C> continuationPredicate;
    private final C continuationToken;
    private final PageRetriever<C, P> pageRetriever;
    private final PageRetrieverSync<C, P> pageRetrieverSync;
    private final Integer preferredPageSize;

    ContinuablePagedByPageIterable(PageRetriever<C, P> pageRetriever, C c, Predicate<C> predicate, Integer num) {
        this.pageRetriever = pageRetriever;
        this.continuationToken = c;
        this.continuationPredicate = predicate;
        this.preferredPageSize = num;
        this.pageRetrieverSync = null;
    }

    ContinuablePagedByPageIterable(PageRetrieverSync<C, P> pageRetrieverSync, C c, Predicate<C> predicate, Integer num) {
        this.pageRetrieverSync = pageRetrieverSync;
        this.continuationToken = c;
        this.continuationPredicate = predicate;
        this.preferredPageSize = num;
        this.pageRetriever = null;
    }

    @Override // java.lang.Iterable
    public Iterator<P> iterator() {
        if (this.pageRetriever != null) {
            return new ContinuablePagedByPageIterator(this.pageRetriever, this.continuationToken, this.continuationPredicate, this.preferredPageSize);
        }
        return new ContinuablePagedByPageIterator(this.pageRetrieverSync, this.continuationToken, this.continuationPredicate, this.preferredPageSize);
    }

    private static final class ContinuablePagedByPageIterator<C, T, P extends ContinuablePage<C, T>> extends ContinuablePagedByIteratorBase<C, T, P, P> {
        private static final ClientLogger LOGGER = new ClientLogger((Class<?>) ContinuablePagedByPageIterator.class);
        private volatile Queue<P> pages;

        ContinuablePagedByPageIterator(PageRetriever<C, P> pageRetriever, C c, Predicate<C> predicate, Integer num) {
            super(pageRetriever, new ContinuationState(c, predicate), num, LOGGER);
            this.pages = new ConcurrentLinkedQueue();
            requestPage();
        }

        ContinuablePagedByPageIterator(PageRetrieverSync<C, P> pageRetrieverSync, C c, Predicate<C> predicate, Integer num) {
            super(pageRetrieverSync, new ContinuationState(c, predicate), num, LOGGER);
            this.pages = new ConcurrentLinkedQueue();
            requestPage();
        }

        @Override // com.azure.core.util.paging.ContinuablePagedByIteratorBase
        boolean needToRequestPage() {
            return this.pages.peek() == null;
        }

        @Override // com.azure.core.util.paging.ContinuablePagedByIteratorBase
        public boolean isNextAvailable() {
            return this.pages.peek() != null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.azure.core.util.paging.ContinuablePagedByIteratorBase
        public P getNext() {
            return this.pages.poll();
        }

        @Override // com.azure.core.util.paging.ContinuablePagedByIteratorBase
        void addPage(P p) {
            this.pages.add(p);
        }
    }
}
