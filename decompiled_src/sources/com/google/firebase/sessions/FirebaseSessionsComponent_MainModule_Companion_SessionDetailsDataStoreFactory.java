package com.google.firebase.sessions;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class FirebaseSessionsComponent_MainModule_Companion_SessionDetailsDataStoreFactory implements Factory<DataStore<Preferences>> {
    private final Provider<Context> appContextProvider;

    public FirebaseSessionsComponent_MainModule_Companion_SessionDetailsDataStoreFactory(Provider<Context> provider) {
        this.appContextProvider = provider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public DataStore<Preferences> m2177get() {
        return sessionDetailsDataStore((Context) this.appContextProvider.get());
    }

    public static FirebaseSessionsComponent_MainModule_Companion_SessionDetailsDataStoreFactory create(Provider<Context> provider) {
        return new FirebaseSessionsComponent_MainModule_Companion_SessionDetailsDataStoreFactory(provider);
    }

    public static DataStore<Preferences> sessionDetailsDataStore(Context context) {
        return (DataStore) Preconditions.checkNotNullFromProvides(FirebaseSessionsComponent.MainModule.INSTANCE.sessionDetailsDataStore(context));
    }
}
