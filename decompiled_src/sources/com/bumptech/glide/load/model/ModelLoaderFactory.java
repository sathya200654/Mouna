package com.bumptech.glide.load.model;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface ModelLoaderFactory<T, Y> {
    ModelLoader<T, Y> build(MultiModelLoaderFactory multiModelLoaderFactory);

    void teardown();
}
