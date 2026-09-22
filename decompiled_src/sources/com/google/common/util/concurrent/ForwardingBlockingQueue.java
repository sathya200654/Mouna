package com.google.common.util.concurrent;

import com.google.common.collect.ForwardingQueue;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingBlockingQueue<E> extends ForwardingQueue<E> implements BlockingQueue<E> {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: delegate, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public abstract BlockingQueue<E> m1915delegate();

    protected ForwardingBlockingQueue() {
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> c, int maxElements) {
        return m1915delegate().drainTo(c, maxElements);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> c) {
        return m1915delegate().drainTo(c);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        return m1915delegate().offer(e, timeout, unit);
    }

    @Override // java.util.concurrent.BlockingQueue
    @CheckForNull
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        return m1915delegate().poll(timeout, unit);
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e) throws InterruptedException {
        m1915delegate().put(e);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return m1915delegate().remainingCapacity();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        return m1915delegate().take();
    }
}
