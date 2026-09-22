package com.google.firebase.sessions;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import com.google.firebase.sessions.dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class SessionDatastoreImpl_Factory implements Factory<SessionDatastoreImpl> {
    private final Provider<CoroutineContext> backgroundDispatcherProvider;
    private final Provider<DataStore<Preferences>> dataStoreProvider;

    public SessionDatastoreImpl_Factory(Provider<CoroutineContext> provider, Provider<DataStore<Preferences>> provider2) {
        this.backgroundDispatcherProvider = provider;
        this.dataStoreProvider = provider2;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SessionDatastoreImpl m2182get() {
        return newInstance((CoroutineContext) this.backgroundDispatcherProvider.get(), (DataStore) this.dataStoreProvider.get());
    }

    public static SessionDatastoreImpl_Factory create(Provider<CoroutineContext> provider, Provider<DataStore<Preferences>> provider2) {
        return new SessionDatastoreImpl_Factory(provider, provider2);
    }

    public static SessionDatastoreImpl newInstance(CoroutineContext coroutineContext, DataStore<Preferences> dataStore) {
        return new SessionDatastoreImpl(coroutineContext, dataStore);
    }
}
