package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.util.DisplayMetrics;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory implements Factory<InAppMessageLayoutConfig> {
    private final Provider<DisplayMetrics> displayMetricsProvider;
    private final InflaterConfigModule module;

    public InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory(InflaterConfigModule inflaterConfigModule, Provider<DisplayMetrics> provider) {
        this.module = inflaterConfigModule;
        this.displayMetricsProvider = provider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public InAppMessageLayoutConfig m1986get() {
        return providesPortraitImageLayoutConfig(this.module, (DisplayMetrics) this.displayMetricsProvider.get());
    }

    public static InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory create(InflaterConfigModule inflaterConfigModule, Provider<DisplayMetrics> provider) {
        return new InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory(inflaterConfigModule, provider);
    }

    public static InAppMessageLayoutConfig providesPortraitImageLayoutConfig(InflaterConfigModule inflaterConfigModule, DisplayMetrics displayMetrics) {
        return (InAppMessageLayoutConfig) Preconditions.checkNotNullFromProvides(inflaterConfigModule.providesPortraitImageLayoutConfig(displayMetrics));
    }
}
