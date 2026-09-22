package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.ProxyAnalyticsConnector;
import com.google.firebase.inject.Deferred;
import javax.inject.Singleton;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Module
public class AppMeasurementModule {
    private final AnalyticsConnector analyticsConnector;
    private final Subscriber firebaseEventsSubscriber;

    public AppMeasurementModule(Deferred<AnalyticsConnector> deferred, Subscriber subscriber) {
        this.analyticsConnector = new ProxyAnalyticsConnector(deferred);
        this.firebaseEventsSubscriber = subscriber;
    }

    @Provides
    @Singleton
    AnalyticsConnector providesAnalyticsConnector() {
        return this.analyticsConnector;
    }

    @Provides
    @Singleton
    Subscriber providesSubsriber() {
        return this.firebaseEventsSubscriber;
    }
}
