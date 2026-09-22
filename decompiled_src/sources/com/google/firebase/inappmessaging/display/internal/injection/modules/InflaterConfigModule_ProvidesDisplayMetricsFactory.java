package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import android.util.DisplayMetrics;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class InflaterConfigModule_ProvidesDisplayMetricsFactory implements Factory<DisplayMetrics> {
    private final Provider<Application> applicationProvider;
    private final InflaterConfigModule module;

    public InflaterConfigModule_ProvidesDisplayMetricsFactory(InflaterConfigModule inflaterConfigModule, Provider<Application> provider) {
        this.module = inflaterConfigModule;
        this.applicationProvider = provider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public DisplayMetrics m1982get() {
        return providesDisplayMetrics(this.module, (Application) this.applicationProvider.get());
    }

    public static InflaterConfigModule_ProvidesDisplayMetricsFactory create(InflaterConfigModule inflaterConfigModule, Provider<Application> provider) {
        return new InflaterConfigModule_ProvidesDisplayMetricsFactory(inflaterConfigModule, provider);
    }

    public static DisplayMetrics providesDisplayMetrics(InflaterConfigModule inflaterConfigModule, Application application) {
        return (DisplayMetrics) Preconditions.checkNotNullFromProvides(inflaterConfigModule.providesDisplayMetrics(application));
    }
}
