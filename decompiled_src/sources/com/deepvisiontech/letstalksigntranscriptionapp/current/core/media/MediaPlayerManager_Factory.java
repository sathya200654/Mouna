package com.deepvisiontech.letstalksigntranscriptionapp.current.core.media;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class MediaPlayerManager_Factory implements Factory<MediaPlayerManager> {
    private final Provider<Context> contextProvider;

    private MediaPlayerManager_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public MediaPlayerManager m1689get() {
        return newInstance((Context) this.contextProvider.get());
    }

    public static MediaPlayerManager_Factory create(Provider<Context> contextProvider) {
        return new MediaPlayerManager_Factory(contextProvider);
    }

    public static MediaPlayerManager newInstance(Context context) {
        return new MediaPlayerManager(context);
    }
}
