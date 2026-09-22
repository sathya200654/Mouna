package com.google.firebase.sessions;

import android.content.Context;
import com.google.firebase.sessions.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class SessionLifecycleServiceBinderImpl_Factory implements Factory<SessionLifecycleServiceBinderImpl> {
    private final Provider<Context> appContextProvider;

    public SessionLifecycleServiceBinderImpl_Factory(Provider<Context> provider) {
        this.appContextProvider = provider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SessionLifecycleServiceBinderImpl m2185get() {
        return newInstance((Context) this.appContextProvider.get());
    }

    public static SessionLifecycleServiceBinderImpl_Factory create(Provider<Context> provider) {
        return new SessionLifecycleServiceBinderImpl_Factory(provider);
    }

    public static SessionLifecycleServiceBinderImpl newInstance(Context context) {
        return new SessionLifecycleServiceBinderImpl(context);
    }
}
