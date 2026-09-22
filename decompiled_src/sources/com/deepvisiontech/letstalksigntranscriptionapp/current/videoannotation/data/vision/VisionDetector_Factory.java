package com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.vision;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class VisionDetector_Factory implements Factory<VisionDetector> {
    private final Provider<Context> contextProvider;

    private VisionDetector_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public VisionDetector m1864get() {
        return newInstance((Context) this.contextProvider.get());
    }

    public static VisionDetector_Factory create(Provider<Context> contextProvider) {
        return new VisionDetector_Factory(contextProvider);
    }

    public static VisionDetector newInstance(Context context) {
        return new VisionDetector(context);
    }
}
