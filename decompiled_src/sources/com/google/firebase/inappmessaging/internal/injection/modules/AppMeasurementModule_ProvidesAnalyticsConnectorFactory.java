package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class AppMeasurementModule_ProvidesAnalyticsConnectorFactory implements Factory<AnalyticsConnector> {
    private final AppMeasurementModule module;

    public AppMeasurementModule_ProvidesAnalyticsConnectorFactory(AppMeasurementModule appMeasurementModule) {
        this.module = appMeasurementModule;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public AnalyticsConnector m2075get() {
        return providesAnalyticsConnector(this.module);
    }

    public static AppMeasurementModule_ProvidesAnalyticsConnectorFactory create(AppMeasurementModule appMeasurementModule) {
        return new AppMeasurementModule_ProvidesAnalyticsConnectorFactory(appMeasurementModule);
    }

    public static AnalyticsConnector providesAnalyticsConnector(AppMeasurementModule appMeasurementModule) {
        return (AnalyticsConnector) Preconditions.checkNotNullFromProvides(appMeasurementModule.providesAnalyticsConnector());
    }
}
