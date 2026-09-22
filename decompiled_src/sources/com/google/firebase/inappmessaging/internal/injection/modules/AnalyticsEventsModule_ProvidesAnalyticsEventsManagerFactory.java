package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory implements Factory<AnalyticsEventsManager> {
    private final Provider<AnalyticsConnector> analyticsConnectorProvider;
    private final AnalyticsEventsModule module;

    public AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory(AnalyticsEventsModule analyticsEventsModule, Provider<AnalyticsConnector> provider) {
        this.module = analyticsEventsModule;
        this.analyticsConnectorProvider = provider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public AnalyticsEventsManager m2068get() {
        return providesAnalyticsEventsManager(this.module, (AnalyticsConnector) this.analyticsConnectorProvider.get());
    }

    public static AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory create(AnalyticsEventsModule analyticsEventsModule, Provider<AnalyticsConnector> provider) {
        return new AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory(analyticsEventsModule, provider);
    }

    public static AnalyticsEventsManager providesAnalyticsEventsManager(AnalyticsEventsModule analyticsEventsModule, AnalyticsConnector analyticsConnector) {
        return (AnalyticsEventsManager) Preconditions.checkNotNullFromProvides(analyticsEventsModule.providesAnalyticsEventsManager(analyticsConnector));
    }
}
