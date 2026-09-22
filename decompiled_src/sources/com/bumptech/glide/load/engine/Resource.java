package com.bumptech.glide.load.engine;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface Resource<Z> {
    Z get();

    Class<Z> getResourceClass();

    int getSize();

    void recycle();
}
