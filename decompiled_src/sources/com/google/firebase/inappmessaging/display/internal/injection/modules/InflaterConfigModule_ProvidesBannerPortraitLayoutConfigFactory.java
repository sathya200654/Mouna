package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.util.DisplayMetrics;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class InflaterConfigModule_ProvidesBannerPortraitLayoutConfigFactory implements Factory<InAppMessageLayoutConfig> {
    private final Provider<DisplayMetrics> displayMetricsProvider;
    private final InflaterConfigModule module;

    public InflaterConfigModule_ProvidesBannerPortraitLayoutConfigFactory(InflaterConfigModule inflaterConfigModule, Provider<DisplayMetrics> provider) {
        this.module = inflaterConfigModule;
        this.displayMetricsProvider = provider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public InAppMessageLayoutConfig m1979get() {
        return providesBannerPortraitLayoutConfig(this.module, (DisplayMetrics) this.displayMetricsProvider.get());
    }

    public static InflaterConfigModule_ProvidesBannerPortraitLayoutConfigFactory create(InflaterConfigModule inflaterConfigModule, Provider<DisplayMetrics> provider) {
        return new InflaterConfigModule_ProvidesBannerPortraitLayoutConfigFactory(inflaterConfigModule, provider);
    }

    public static InAppMessageLayoutConfig providesBannerPortraitLayoutConfig(InflaterConfigModule inflaterConfigModule, DisplayMetrics displayMetrics) {
        return (InAppMessageLayoutConfig) Preconditions.checkNotNullFromProvides(inflaterConfigModule.providesBannerPortraitLayoutConfig(displayMetrics));
    }
}
