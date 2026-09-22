package com.azure.core.util;

import com.azure.core.implementation.util.ReferenceManagerImpl;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface ReferenceManager {
    public static final ReferenceManager INSTANCE = new ReferenceManagerImpl();

    void register(Object obj, Runnable runnable);
}
