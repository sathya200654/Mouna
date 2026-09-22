package com.azure.core.implementation.util;

import java.lang.ref.PhantomReference;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class CleanableReference<T> extends PhantomReference<T> {
    private final Runnable cleanupAction;
    private final CleanableReference<?> cleanupList;
    CleanableReference<?> next;
    CleanableReference<?> previous;

    /* JADX WARN: Multi-variable type inference failed */
    CleanableReference() {
        super(null, null);
        this.previous = this;
        this.next = this;
        this.cleanupAction = null;
        this.cleanupList = this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    CleanableReference(T t, Runnable runnable, ReferenceManagerImpl referenceManagerImpl) {
        super(t, referenceManagerImpl.getQueue());
        this.previous = this;
        this.next = this;
        this.cleanupAction = runnable;
        this.cleanupList = referenceManagerImpl.getCleanableReferenceList();
        insert();
    }

    public void clean() {
        if (remove()) {
            super.clear();
            this.cleanupAction.run();
        }
    }

    @Override // java.lang.ref.Reference
    public void clear() {
        if (remove()) {
            super.clear();
        }
    }

    boolean hasRemaining() {
        boolean z;
        synchronized (this.cleanupList) {
            CleanableReference<?> cleanableReference = this.cleanupList;
            z = cleanableReference != cleanableReference.next;
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void insert() {
        synchronized (this.cleanupList) {
            CleanableReference<?> cleanableReference = this.cleanupList;
            this.previous = cleanableReference;
            CleanableReference<?> cleanableReference2 = cleanableReference.next;
            this.next = cleanableReference2;
            cleanableReference2.previous = this;
            cleanableReference.next = this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean remove() {
        synchronized (this.cleanupList) {
            CleanableReference<?> cleanableReference = this.next;
            if (cleanableReference == this) {
                return false;
            }
            cleanableReference.previous = this.previous;
            this.previous.next = cleanableReference;
            this.previous = this;
            this.next = this;
            return true;
        }
    }
}
