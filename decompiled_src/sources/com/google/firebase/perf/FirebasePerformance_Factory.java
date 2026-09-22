package com.google.firebase.perf;

import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class FirebasePerformance_Factory implements Factory<FirebasePerformance> {
    private final Provider<ConfigResolver> configResolverProvider;
    private final Provider<FirebaseApp> firebaseAppProvider;
    private final Provider<FirebaseInstallationsApi> firebaseInstallationsApiProvider;
    private final Provider<com.google.firebase.inject.Provider<RemoteConfigComponent>> firebaseRemoteConfigProvider;
    private final Provider<RemoteConfigManager> remoteConfigManagerProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<com.google.firebase.inject.Provider<TransportFactory>> transportFactoryProvider;

    public FirebasePerformance_Factory(Provider<FirebaseApp> provider, Provider<com.google.firebase.inject.Provider<RemoteConfigComponent>> provider2, Provider<FirebaseInstallationsApi> provider3, Provider<com.google.firebase.inject.Provider<TransportFactory>> provider4, Provider<RemoteConfigManager> provider5, Provider<ConfigResolver> provider6, Provider<SessionManager> provider7) {
        this.firebaseAppProvider = provider;
        this.firebaseRemoteConfigProvider = provider2;
        this.firebaseInstallationsApiProvider = provider3;
        this.transportFactoryProvider = provider4;
        this.remoteConfigManagerProvider = provider5;
        this.configResolverProvider = provider6;
        this.sessionManagerProvider = provider7;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public FirebasePerformance m2129get() {
        return newInstance((FirebaseApp) this.firebaseAppProvider.get(), (com.google.firebase.inject.Provider) this.firebaseRemoteConfigProvider.get(), (FirebaseInstallationsApi) this.firebaseInstallationsApiProvider.get(), (com.google.firebase.inject.Provider) this.transportFactoryProvider.get(), (RemoteConfigManager) this.remoteConfigManagerProvider.get(), (ConfigResolver) this.configResolverProvider.get(), (SessionManager) this.sessionManagerProvider.get());
    }

    public static FirebasePerformance_Factory create(Provider<FirebaseApp> provider, Provider<com.google.firebase.inject.Provider<RemoteConfigComponent>> provider2, Provider<FirebaseInstallationsApi> provider3, Provider<com.google.firebase.inject.Provider<TransportFactory>> provider4, Provider<RemoteConfigManager> provider5, Provider<ConfigResolver> provider6, Provider<SessionManager> provider7) {
        return new FirebasePerformance_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static FirebasePerformance newInstance(FirebaseApp firebaseApp, com.google.firebase.inject.Provider<RemoteConfigComponent> provider, FirebaseInstallationsApi firebaseInstallationsApi, com.google.firebase.inject.Provider<TransportFactory> provider2, RemoteConfigManager remoteConfigManager, ConfigResolver configResolver, SessionManager sessionManager) {
        return new FirebasePerformance(firebaseApp, provider, firebaseInstallationsApi, provider2, remoteConfigManager, configResolver, sessionManager);
    }
}
