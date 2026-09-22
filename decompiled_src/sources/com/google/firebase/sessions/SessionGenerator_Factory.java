package com.google.firebase.sessions;

import com.google.firebase.sessions.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class SessionGenerator_Factory implements Factory<SessionGenerator> {
    private final Provider<TimeProvider> timeProvider;
    private final Provider<UuidGenerator> uuidGeneratorProvider;

    public SessionGenerator_Factory(Provider<TimeProvider> provider, Provider<UuidGenerator> provider2) {
        this.timeProvider = provider;
        this.uuidGeneratorProvider = provider2;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SessionGenerator m2184get() {
        return newInstance((TimeProvider) this.timeProvider.get(), (UuidGenerator) this.uuidGeneratorProvider.get());
    }

    public static SessionGenerator_Factory create(Provider<TimeProvider> provider, Provider<UuidGenerator> provider2) {
        return new SessionGenerator_Factory(provider, provider2);
    }

    public static SessionGenerator newInstance(TimeProvider timeProvider, UuidGenerator uuidGenerator) {
        return new SessionGenerator(timeProvider, uuidGenerator);
    }
}
