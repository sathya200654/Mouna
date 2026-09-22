package com.google.firebase.sessions.settings;

import com.google.firebase.sessions.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class SessionsSettings_Factory implements Factory<SessionsSettings> {
    private final Provider<SettingsProvider> localOverrideSettingsProvider;
    private final Provider<SettingsProvider> remoteSettingsProvider;

    public SessionsSettings_Factory(Provider<SettingsProvider> provider, Provider<SettingsProvider> provider2) {
        this.localOverrideSettingsProvider = provider;
        this.remoteSettingsProvider = provider2;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SessionsSettings m2193get() {
        return newInstance((SettingsProvider) this.localOverrideSettingsProvider.get(), (SettingsProvider) this.remoteSettingsProvider.get());
    }

    public static SessionsSettings_Factory create(Provider<SettingsProvider> provider, Provider<SettingsProvider> provider2) {
        return new SessionsSettings_Factory(provider, provider2);
    }

    public static SessionsSettings newInstance(SettingsProvider settingsProvider, SettingsProvider settingsProvider2) {
        return new SessionsSettings(settingsProvider, settingsProvider2);
    }
}
