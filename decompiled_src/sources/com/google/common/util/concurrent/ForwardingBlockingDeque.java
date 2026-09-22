package com.google.common.util.concurrent;

import com.google.common.collect.ForwardingDeque;
import java.util.Collection;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingBlockingDeque<E> extends ForwardingDeque<E> implements BlockingDeque<E> {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: delegate, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public abstract BlockingDeque<E> m1912delegate();

    protected ForwardingBlockingDeque() {
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return m1912delegate().remainingCapacity();
    }

    @Override // java.util.concurrent.BlockingDeque
    public void putFirst(E e) throws InterruptedException {
        m1912delegate().putFirst(e);
    }

    @Override // java.util.concurrent.BlockingDeque
    public void putLast(E e) throws InterruptedException {
        m1912delegate().putLast(e);
    }

    @Override // java.util.concurrent.BlockingDeque
    public boolean offerFirst(E e, long timeout, TimeUnit unit) throws InterruptedException {
        return m1912delegate().offerFirst(e, timeout, unit);
    }

    @Override // java.util.concurrent.BlockingDeque
    public boolean offerLast(E e, long timeout, TimeUnit unit) throws InterruptedException {
        return m1912delegate().offerLast(e, timeout, unit);
    }

    @Override // java.util.concurrent.BlockingDeque
    public E takeFirst() throws InterruptedException {
        return m1912delegate().takeFirst();
    }

    @Override // java.util.concurrent.BlockingDeque
    public E takeLast() throws InterruptedException {
        return m1912delegate().takeLast();
    }

    @Override // java.util.concurrent.BlockingDeque
    @CheckForNull
    public E pollFirst(long timeout, TimeUnit unit) throws InterruptedException {
        return m1912delegate().pollFirst(timeout, unit);
    }

    @Override // java.util.concurrent.BlockingDeque
    @CheckForNull
    public E pollLast(long timeout, TimeUnit unit) throws InterruptedException {
        return m1912delegate().pollLast(timeout, unit);
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public void put(E e) throws InterruptedException {
        m1912delegate().put(e);
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        return m1912delegate().offer(e, timeout, unit);
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        return m1912delegate().take();
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    @CheckForNull
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        return m1912delegate().poll(timeout, unit);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> c) {
        return m1912delegate().drainTo(c);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> c, int maxElements) {
        return m1912delegate().drainTo(c, maxElements);
    }
}
