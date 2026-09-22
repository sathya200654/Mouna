package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Module
public class TransportClientModule {
    private static final String TRANSPORT_NAME = "FIREBASE_INAPPMESSAGING";

    static /* synthetic */ byte[] lambda$providesMetricsLoggerClient$0(byte[] bArr) {
        return bArr;
    }

    @Provides
    static MetricsLoggerClient providesMetricsLoggerClient(FirebaseApp firebaseApp, TransportFactory transportFactory, AnalyticsConnector analyticsConnector, FirebaseInstallationsApi firebaseInstallationsApi, Clock clock, DeveloperListenerManager developerListenerManager, Executor executor) {
        final Transport transport = transportFactory.getTransport(TRANSPORT_NAME, byte[].class, new Transformer() { // from class: com.google.firebase.inappmessaging.internal.injection.modules.TransportClientModule$$ExternalSyntheticLambda0
            public final Object apply(Object obj) {
                return TransportClientModule.lambda$providesMetricsLoggerClient$0((byte[]) obj);
            }
        });
        return new MetricsLoggerClient(new MetricsLoggerClient.EngagementMetricsLoggerInterface() { // from class: com.google.firebase.inappmessaging.internal.injection.modules.TransportClientModule$$ExternalSyntheticLambda1
            @Override // com.google.firebase.inappmessaging.internal.MetricsLoggerClient.EngagementMetricsLoggerInterface
            public final void logEvent(byte[] bArr) {
                transport.send(Event.ofData(bArr));
            }
        }, analyticsConnector, firebaseApp, firebaseInstallationsApi, clock, developerListenerManager, executor);
    }
}
