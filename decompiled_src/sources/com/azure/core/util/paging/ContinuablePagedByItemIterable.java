package com.azure.core.util.paging;

import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.paging.ContinuablePage;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Predicate;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class ContinuablePagedByItemIterable<C, T, P extends ContinuablePage<C, T>> implements Iterable<T> {
    private final Predicate<C> continuationPredicate;
    private final C continuationToken;
    private final PageRetriever<C, P> pageRetriever;
    private final PageRetrieverSync<C, P> pageRetrieverSync;
    private final Integer preferredPageSize;

    ContinuablePagedByItemIterable(PageRetriever<C, P> pageRetriever, C c, Predicate<C> predicate, Integer num) {
        this.pageRetriever = pageRetriever;
        this.continuationToken = c;
        this.continuationPredicate = predicate;
        this.preferredPageSize = num;
        this.pageRetrieverSync = null;
    }

    ContinuablePagedByItemIterable(PageRetrieverSync<C, P> pageRetrieverSync, C c, Predicate<C> predicate, Integer num) {
        this.pageRetrieverSync = pageRetrieverSync;
        this.continuationToken = c;
        this.continuationPredicate = predicate;
        this.preferredPageSize = num;
        this.pageRetriever = null;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        if (this.pageRetriever != null) {
            return new ContinuablePagedByItemIterator(this.pageRetriever, this.continuationToken, this.continuationPredicate, this.preferredPageSize);
        }
        return new ContinuablePagedByItemIterator(this.pageRetrieverSync, this.continuationToken, this.continuationPredicate, this.preferredPageSize);
    }

    private static final class ContinuablePagedByItemIterator<C, T, P extends ContinuablePage<C, T>> extends ContinuablePagedByIteratorBase<C, T, P, T> {
        private static final ClientLogger LOGGER = new ClientLogger((Class<?>) ContinuablePagedByItemIterator.class);
        private volatile Iterator<T> currentPage;
        private volatile Queue<Iterator<T>> pages;

        ContinuablePagedByItemIterator(PageRetriever<C, P> pageRetriever, C c, Predicate<C> predicate, Integer num) {
            super(pageRetriever, new ContinuationState(c, predicate), num, LOGGER);
            this.pages = new ConcurrentLinkedQueue();
            requestPage();
        }

        ContinuablePagedByItemIterator(PageRetrieverSync<C, P> pageRetrieverSync, C c, Predicate<C> predicate, Integer num) {
            super(pageRetrieverSync, new ContinuationState(c, predicate), num, LOGGER);
            this.pages = new ConcurrentLinkedQueue();
            requestPage();
        }

        @Override // com.azure.core.util.paging.ContinuablePagedByIteratorBase
        boolean needToRequestPage() {
            return (this.currentPage == null || !this.currentPage.hasNext()) && this.pages.peek() == null;
        }

        @Override // com.azure.core.util.paging.ContinuablePagedByIteratorBase
        public boolean isNextAvailable() {
            return (this.currentPage != null && this.currentPage.hasNext()) || this.pages.peek() != null;
        }

        @Override // com.azure.core.util.paging.ContinuablePagedByIteratorBase
        T getNext() {
            if ((this.currentPage == null || !this.currentPage.hasNext()) && this.pages.peek() != null) {
                this.currentPage = this.pages.poll();
            }
            return this.currentPage.next();
        }

        @Override // com.azure.core.util.paging.ContinuablePagedByIteratorBase
        void addPage(P p) {
            Iterator<T> it = p.getElements().iterator();
            if (it.hasNext()) {
                this.pages.add(it);
            }
        }
    }
}
