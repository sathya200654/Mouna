package com.google.firebase.sessions;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class FirebaseSessionsComponent_MainModule_Companion_SessionConfigsDataStoreFactory implements Factory<DataStore<Preferences>> {
    private final Provider<Context> appContextProvider;

    public FirebaseSessionsComponent_MainModule_Companion_SessionConfigsDataStoreFactory(Provider<Context> provider) {
        this.appContextProvider = provider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public DataStore<Preferences> m2176get() {
        return sessionConfigsDataStore((Context) this.appContextProvider.get());
    }

    public static FirebaseSessionsComponent_MainModule_Companion_SessionConfigsDataStoreFactory create(Provider<Context> provider) {
        return new FirebaseSessionsComponent_MainModule_Companion_SessionConfigsDataStoreFactory(provider);
    }

    public static DataStore<Preferences> sessionConfigsDataStore(Context context) {
        return (DataStore) Preconditions.checkNotNullFromProvides(FirebaseSessionsComponent.MainModule.INSTANCE.sessionConfigsDataStore(context));
    }
}
