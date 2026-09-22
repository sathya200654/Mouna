package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import io.reactivex.flowables.ConnectableFlowable;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory implements Factory<ConnectableFlowable<String>> {
    private final Provider<AnalyticsEventsManager> analyticsEventsManagerProvider;
    private final AnalyticsEventsModule module;

    public AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory(AnalyticsEventsModule analyticsEventsModule, Provider<AnalyticsEventsManager> provider) {
        this.module = analyticsEventsModule;
        this.analyticsEventsManagerProvider = provider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConnectableFlowable<String> m2067get() {
        return providesAnalyticsConnectorEvents(this.module, (AnalyticsEventsManager) this.analyticsEventsManagerProvider.get());
    }

    public static AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory create(AnalyticsEventsModule analyticsEventsModule, Provider<AnalyticsEventsManager> provider) {
        return new AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory(analyticsEventsModule, provider);
    }

    public static ConnectableFlowable<String> providesAnalyticsConnectorEvents(AnalyticsEventsModule analyticsEventsModule, AnalyticsEventsManager analyticsEventsManager) {
        return (ConnectableFlowable) Preconditions.checkNotNullFromProvides(analyticsEventsModule.providesAnalyticsConnectorEvents(analyticsEventsManager));
    }
}
