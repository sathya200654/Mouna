package com.google.mediapipe.tasks.core;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
class ModelResourcesCache {
    private final long nativeHandle = nativeCreateModelResourcesCache();
    private final AtomicBoolean isHandleValid = new AtomicBoolean(true);

    private native long nativeCreateModelResourcesCache();

    private native void nativeReleaseModelResourcesCache(long nativeHandle);

    public boolean isHandleValid() {
        return this.isHandleValid.get();
    }

    public long getNativeHandle() {
        if (this.isHandleValid.get()) {
            return this.nativeHandle;
        }
        return 0L;
    }

    public void release() {
        if (this.isHandleValid.compareAndSet(true, false)) {
            nativeReleaseModelResourcesCache(this.nativeHandle);
        }
    }
}
