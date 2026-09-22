package com.google.firebase.sessions.settings;

import android.content.Context;
import com.google.firebase.sessions.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class LocalOverrideSettings_Factory implements Factory<LocalOverrideSettings> {
    private final Provider<Context> appContextProvider;

    public LocalOverrideSettings_Factory(Provider<Context> provider) {
        this.appContextProvider = provider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public LocalOverrideSettings m2188get() {
        return newInstance((Context) this.appContextProvider.get());
    }

    public static LocalOverrideSettings_Factory create(Provider<Context> provider) {
        return new LocalOverrideSettings_Factory(provider);
    }

    public static LocalOverrideSettings newInstance(Context context) {
        return new LocalOverrideSettings(context);
    }
}
