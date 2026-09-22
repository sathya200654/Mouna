package com.google.firebase.sessions.settings;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import com.google.firebase.sessions.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class SettingsCache_Factory implements Factory<SettingsCache> {
    private final Provider<DataStore<Preferences>> dataStoreProvider;

    public SettingsCache_Factory(Provider<DataStore<Preferences>> provider) {
        this.dataStoreProvider = provider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SettingsCache m2194get() {
        return newInstance((DataStore) this.dataStoreProvider.get());
    }

    public static SettingsCache_Factory create(Provider<DataStore<Preferences>> provider) {
        return new SettingsCache_Factory(provider);
    }

    public static SettingsCache newInstance(DataStore<Preferences> dataStore) {
        return new SettingsCache(dataStore);
    }
}
