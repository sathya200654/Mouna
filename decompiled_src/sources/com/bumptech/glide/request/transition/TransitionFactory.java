package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface TransitionFactory<R> {
    Transition<R> build(DataSource dataSource, boolean z);
}
