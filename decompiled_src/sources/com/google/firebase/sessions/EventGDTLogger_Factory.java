package com.google.firebase.sessions;

import com.google.android.datatransport.TransportFactory;
import com.google.firebase.sessions.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class EventGDTLogger_Factory implements Factory<EventGDTLogger> {
    private final Provider<com.google.firebase.inject.Provider<TransportFactory>> transportFactoryProvider;

    public EventGDTLogger_Factory(Provider<com.google.firebase.inject.Provider<TransportFactory>> provider) {
        this.transportFactoryProvider = provider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public EventGDTLogger m2172get() {
        return newInstance((com.google.firebase.inject.Provider) this.transportFactoryProvider.get());
    }

    public static EventGDTLogger_Factory create(Provider<com.google.firebase.inject.Provider<TransportFactory>> provider) {
        return new EventGDTLogger_Factory(provider);
    }

    public static EventGDTLogger newInstance(com.google.firebase.inject.Provider<TransportFactory> provider) {
        return new EventGDTLogger(provider);
    }
}
