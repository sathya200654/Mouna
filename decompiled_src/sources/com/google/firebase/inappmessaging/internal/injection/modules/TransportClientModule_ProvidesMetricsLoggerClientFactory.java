package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class TransportClientModule_ProvidesMetricsLoggerClientFactory implements Factory<MetricsLoggerClient> {
    private final Provider<AnalyticsConnector> analyticsConnectorProvider;
    private final Provider<FirebaseApp> appProvider;
    private final Provider<Executor> blockingExecutorProvider;
    private final Provider<Clock> clockProvider;
    private final Provider<DeveloperListenerManager> developerListenerManagerProvider;
    private final Provider<FirebaseInstallationsApi> firebaseInstallationsProvider;
    private final Provider<TransportFactory> transportFactoryProvider;

    public TransportClientModule_ProvidesMetricsLoggerClientFactory(Provider<FirebaseApp> provider, Provider<TransportFactory> provider2, Provider<AnalyticsConnector> provider3, Provider<FirebaseInstallationsApi> provider4, Provider<Clock> provider5, Provider<DeveloperListenerManager> provider6, Provider<Executor> provider7) {
        this.appProvider = provider;
        this.transportFactoryProvider = provider2;
        this.analyticsConnectorProvider = provider3;
        this.firebaseInstallationsProvider = provider4;
        this.clockProvider = provider5;
        this.developerListenerManagerProvider = provider6;
        this.blockingExecutorProvider = provider7;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public MetricsLoggerClient m2098get() {
        return providesMetricsLoggerClient((FirebaseApp) this.appProvider.get(), (TransportFactory) this.transportFactoryProvider.get(), (AnalyticsConnector) this.analyticsConnectorProvider.get(), (FirebaseInstallationsApi) this.firebaseInstallationsProvider.get(), (Clock) this.clockProvider.get(), (DeveloperListenerManager) this.developerListenerManagerProvider.get(), (Executor) this.blockingExecutorProvider.get());
    }

    public static TransportClientModule_ProvidesMetricsLoggerClientFactory create(Provider<FirebaseApp> provider, Provider<TransportFactory> provider2, Provider<AnalyticsConnector> provider3, Provider<FirebaseInstallationsApi> provider4, Provider<Clock> provider5, Provider<DeveloperListenerManager> provider6, Provider<Executor> provider7) {
        return new TransportClientModule_ProvidesMetricsLoggerClientFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static MetricsLoggerClient providesMetricsLoggerClient(FirebaseApp firebaseApp, TransportFactory transportFactory, AnalyticsConnector analyticsConnector, FirebaseInstallationsApi firebaseInstallationsApi, Clock clock, DeveloperListenerManager developerListenerManager, Executor executor) {
        return (MetricsLoggerClient) Preconditions.checkNotNullFromProvides(TransportClientModule.providesMetricsLoggerClient(firebaseApp, transportFactory, analyticsConnector, firebaseInstallationsApi, clock, developerListenerManager, executor));
    }
}
