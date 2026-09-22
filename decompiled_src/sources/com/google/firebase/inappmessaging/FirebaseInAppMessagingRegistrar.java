package com.google.firebase.inappmessaging;

import android.app.Application;
import android.content.Context;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.component.AbtComponent;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.datatransport.LegacyTransportBackend;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.internal.AbtIntegrationHelper;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent;
import com.google.firebase.inappmessaging.internal.injection.components.DaggerUniversalComponent;
import com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent;
import com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ExecutorsModule;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule;
import com.google.firebase.inject.Deferred;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class FirebaseInAppMessagingRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-fiam";
    private Qualified<Executor> backgroundExecutor = Qualified.qualified(Background.class, Executor.class);
    private Qualified<Executor> blockingExecutor = Qualified.qualified(Blocking.class, Executor.class);
    private Qualified<Executor> lightWeightExecutor = Qualified.qualified(Lightweight.class, Executor.class);
    private Qualified<TransportFactory> legacyTransportFactory = Qualified.qualified(LegacyTransportBackend.class, TransportFactory.class);

    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(FirebaseInAppMessaging.class).name(LIBRARY_NAME).add(Dependency.required(Context.class)).add(Dependency.required(FirebaseInstallationsApi.class)).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(AbtComponent.class)).add(Dependency.deferred(AnalyticsConnector.class)).add(Dependency.required(this.legacyTransportFactory)).add(Dependency.required(Subscriber.class)).add(Dependency.required(this.backgroundExecutor)).add(Dependency.required(this.blockingExecutor)).add(Dependency.required(this.lightWeightExecutor)).factory(new ComponentFactory() { // from class: com.google.firebase.inappmessaging.FirebaseInAppMessagingRegistrar$$ExternalSyntheticLambda0
            public final Object create(ComponentContainer componentContainer) {
                return this.f$0.providesFirebaseInAppMessaging(componentContainer);
            }
        }).eagerInDefaultApp().build(), LibraryVersionComponent.create(LIBRARY_NAME, "21.0.2"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FirebaseInAppMessaging providesFirebaseInAppMessaging(ComponentContainer componentContainer) {
        FirebaseApp firebaseApp = (FirebaseApp) componentContainer.get(FirebaseApp.class);
        FirebaseInstallationsApi firebaseInstallationsApi = (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class);
        Deferred deferred = componentContainer.getDeferred(AnalyticsConnector.class);
        Subscriber subscriber = (Subscriber) componentContainer.get(Subscriber.class);
        UniversalComponent universalComponentBuild = DaggerUniversalComponent.builder().applicationModule(new ApplicationModule((Application) firebaseApp.getApplicationContext())).appMeasurementModule(new AppMeasurementModule(deferred, subscriber)).analyticsEventsModule(new AnalyticsEventsModule()).programmaticContextualTriggerFlowableModule(new ProgrammaticContextualTriggerFlowableModule(new ProgramaticContextualTriggers())).executorsModule(new ExecutorsModule((Executor) componentContainer.get(this.lightWeightExecutor), (Executor) componentContainer.get(this.backgroundExecutor), (Executor) componentContainer.get(this.blockingExecutor))).build();
        return DaggerAppComponent.builder().abtIntegrationHelper(new AbtIntegrationHelper(((AbtComponent) componentContainer.get(AbtComponent.class)).get("fiam"), (Executor) componentContainer.get(this.blockingExecutor))).apiClientModule(new ApiClientModule(firebaseApp, firebaseInstallationsApi, universalComponentBuild.clock())).grpcClientModule(new GrpcClientModule(firebaseApp)).universalComponent(universalComponentBuild).transportFactory((TransportFactory) componentContainer.get(this.legacyTransportFactory)).build().providesFirebaseInAppMessaging();
    }
}
