package com.google.firebase.inappmessaging.internal.injection.components;

import android.app.Application;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging_Factory;
import com.google.firebase.inappmessaging.dagger.internal.DoubleCheck;
import com.google.firebase.inappmessaging.dagger.internal.InstanceFactory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.AbtIntegrationHelper;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import com.google.firebase.inappmessaging.internal.ApiClient;
import com.google.firebase.inappmessaging.internal.CampaignCacheClient;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory_Factory;
import com.google.firebase.inappmessaging.internal.GrpcClient;
import com.google.firebase.inappmessaging.internal.GrpcClient_Factory;
import com.google.firebase.inappmessaging.internal.ImpressionStorageClient;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager_Factory;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.inappmessaging.internal.ProviderInstaller;
import com.google.firebase.inappmessaging.internal.RateLimiterClient;
import com.google.firebase.inappmessaging.internal.Schedulers;
import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import com.google.firebase.inappmessaging.internal.TestDeviceHelper;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesApiClientFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesDataCollectionHelperFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesFirebaseAppFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesFirebaseInstallationsFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesSharedPreferencesUtilsFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesTestDeviceHelperFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule_ProvidesApiKeyHeadersFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.TransportClientModule_ProvidesMetricsLoggerClientFactory;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServingGrpc;
import io.grpc.Channel;
import io.grpc.Metadata;
import io.reactivex.flowables.ConnectableFlowable;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class DaggerAppComponent {
    private DaggerAppComponent() {
    }

    public static AppComponent.Builder builder() {
        return new Builder();
    }

    private static final class Builder implements AppComponent.Builder {
        private AbtIntegrationHelper abtIntegrationHelper;
        private ApiClientModule apiClientModule;
        private GrpcClientModule grpcClientModule;
        private TransportFactory transportFactory;
        private UniversalComponent universalComponent;

        private Builder() {
        }

        @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent.Builder
        public Builder abtIntegrationHelper(AbtIntegrationHelper abtIntegrationHelper) {
            this.abtIntegrationHelper = (AbtIntegrationHelper) Preconditions.checkNotNull(abtIntegrationHelper);
            return this;
        }

        @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent.Builder
        public Builder apiClientModule(ApiClientModule apiClientModule) {
            this.apiClientModule = (ApiClientModule) Preconditions.checkNotNull(apiClientModule);
            return this;
        }

        @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent.Builder
        public Builder grpcClientModule(GrpcClientModule grpcClientModule) {
            this.grpcClientModule = (GrpcClientModule) Preconditions.checkNotNull(grpcClientModule);
            return this;
        }

        @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent.Builder
        public Builder universalComponent(UniversalComponent universalComponent) {
            this.universalComponent = (UniversalComponent) Preconditions.checkNotNull(universalComponent);
            return this;
        }

        @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent.Builder
        public Builder transportFactory(TransportFactory transportFactory) {
            this.transportFactory = (TransportFactory) Preconditions.checkNotNull(transportFactory);
            return this;
        }

        @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent.Builder
        public AppComponent build() {
            Preconditions.checkBuilderRequirement(this.abtIntegrationHelper, AbtIntegrationHelper.class);
            Preconditions.checkBuilderRequirement(this.apiClientModule, ApiClientModule.class);
            Preconditions.checkBuilderRequirement(this.grpcClientModule, GrpcClientModule.class);
            Preconditions.checkBuilderRequirement(this.universalComponent, UniversalComponent.class);
            Preconditions.checkBuilderRequirement(this.transportFactory, TransportFactory.class);
            return new AppComponentImpl(this.apiClientModule, this.grpcClientModule, this.universalComponent, this.abtIntegrationHelper, this.transportFactory);
        }
    }

    private static final class AppComponentImpl implements AppComponent {
        private Provider<AbtIntegrationHelper> abtIntegrationHelperProvider;
        private Provider<AnalyticsConnector> analyticsConnectorProvider;
        private Provider<AnalyticsEventsManager> analyticsEventsManagerProvider;
        private final ApiClientModule apiClientModule;
        private final AppComponentImpl appComponentImpl;
        private Provider<ConnectableFlowable<String>> appForegroundEventFlowableProvider;
        private Provider<RateLimit> appForegroundRateLimitProvider;
        private Provider<Application> applicationProvider;
        private Provider<Executor> blockingExecutorProvider;
        private Provider<CampaignCacheClient> campaignCacheClientProvider;
        private Provider<Clock> clockProvider;
        private Provider<DeveloperListenerManager> developerListenerManagerProvider;
        private Provider<DisplayCallbacksFactory> displayCallbacksFactoryProvider;
        private Provider<Subscriber> firebaseEventsSubscriberProvider;
        private Provider<FirebaseInAppMessaging> firebaseInAppMessagingProvider;
        private Provider<Channel> gRPCChannelProvider;
        private Provider<GrpcClient> grpcClientProvider;
        private Provider<ImpressionStorageClient> impressionStorageClientProvider;
        private Provider<InAppMessageStreamManager> inAppMessageStreamManagerProvider;
        private Provider<Executor> lightWeightExecutorProvider;
        private Provider<ConnectableFlowable<String>> programmaticContextualTriggerFlowableProvider;
        private Provider<ProgramaticContextualTriggers> programmaticContextualTriggersProvider;
        private Provider<ProviderInstaller> providerInstallerProvider;
        private Provider<ApiClient> providesApiClientProvider;
        private Provider<Metadata> providesApiKeyHeadersProvider;
        private Provider<DataCollectionHelper> providesDataCollectionHelperProvider;
        private Provider<FirebaseApp> providesFirebaseAppProvider;
        private Provider<FirebaseInstallationsApi> providesFirebaseInstallationsProvider;
        private Provider<InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub> providesInAppMessagingSdkServingStubProvider;
        private Provider<MetricsLoggerClient> providesMetricsLoggerClientProvider;
        private Provider<SharedPreferencesUtils> providesSharedPreferencesUtilsProvider;
        private Provider<TestDeviceHelper> providesTestDeviceHelperProvider;
        private Provider<RateLimiterClient> rateLimiterClientProvider;
        private Provider<Schedulers> schedulersProvider;
        private Provider<TransportFactory> transportFactoryProvider;
        private final UniversalComponent universalComponent;

        private AppComponentImpl(ApiClientModule apiClientModule, GrpcClientModule grpcClientModule, UniversalComponent universalComponent, AbtIntegrationHelper abtIntegrationHelper, TransportFactory transportFactory) {
            this.appComponentImpl = this;
            this.universalComponent = universalComponent;
            this.apiClientModule = apiClientModule;
            initialize(apiClientModule, grpcClientModule, universalComponent, abtIntegrationHelper, transportFactory);
        }

        private DataCollectionHelper dataCollectionHelper() {
            ApiClientModule apiClientModule = this.apiClientModule;
            return ApiClientModule_ProvidesDataCollectionHelperFactory.providesDataCollectionHelper(apiClientModule, ApiClientModule_ProvidesSharedPreferencesUtilsFactory.providesSharedPreferencesUtils(apiClientModule), (Subscriber) Preconditions.checkNotNullFromComponent(this.universalComponent.firebaseEventsSubscriber()));
        }

        private void initialize(ApiClientModule apiClientModule, GrpcClientModule grpcClientModule, UniversalComponent universalComponent, AbtIntegrationHelper abtIntegrationHelper, TransportFactory transportFactory) {
            this.appForegroundEventFlowableProvider = new AppForegroundEventFlowableProvider(universalComponent);
            this.programmaticContextualTriggerFlowableProvider = new ProgrammaticContextualTriggerFlowableProvider(universalComponent);
            this.campaignCacheClientProvider = new CampaignCacheClientProvider(universalComponent);
            this.clockProvider = new ClockProvider(universalComponent);
            this.gRPCChannelProvider = new GRPCChannelProvider(universalComponent);
            GrpcClientModule_ProvidesApiKeyHeadersFactory grpcClientModule_ProvidesApiKeyHeadersFactoryCreate = GrpcClientModule_ProvidesApiKeyHeadersFactory.create(grpcClientModule);
            this.providesApiKeyHeadersProvider = grpcClientModule_ProvidesApiKeyHeadersFactoryCreate;
            Provider<InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub> provider = DoubleCheck.provider(GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory.create(grpcClientModule, this.gRPCChannelProvider, grpcClientModule_ProvidesApiKeyHeadersFactoryCreate));
            this.providesInAppMessagingSdkServingStubProvider = provider;
            this.grpcClientProvider = DoubleCheck.provider(GrpcClient_Factory.create(provider));
            this.applicationProvider = new ApplicationProvider(universalComponent);
            ProviderInstallerProvider providerInstallerProvider = new ProviderInstallerProvider(universalComponent);
            this.providerInstallerProvider = providerInstallerProvider;
            this.providesApiClientProvider = DoubleCheck.provider(ApiClientModule_ProvidesApiClientFactory.create(apiClientModule, this.grpcClientProvider, this.applicationProvider, providerInstallerProvider));
            this.analyticsEventsManagerProvider = new AnalyticsEventsManagerProvider(universalComponent);
            this.schedulersProvider = new SchedulersProvider(universalComponent);
            this.impressionStorageClientProvider = new ImpressionStorageClientProvider(universalComponent);
            this.rateLimiterClientProvider = new RateLimiterClientProvider(universalComponent);
            this.appForegroundRateLimitProvider = new AppForegroundRateLimitProvider(universalComponent);
            ApiClientModule_ProvidesSharedPreferencesUtilsFactory apiClientModule_ProvidesSharedPreferencesUtilsFactoryCreate = ApiClientModule_ProvidesSharedPreferencesUtilsFactory.create(apiClientModule);
            this.providesSharedPreferencesUtilsProvider = apiClientModule_ProvidesSharedPreferencesUtilsFactoryCreate;
            this.providesTestDeviceHelperProvider = ApiClientModule_ProvidesTestDeviceHelperFactory.create(apiClientModule, apiClientModule_ProvidesSharedPreferencesUtilsFactoryCreate);
            this.providesFirebaseInstallationsProvider = ApiClientModule_ProvidesFirebaseInstallationsFactory.create(apiClientModule);
            FirebaseEventsSubscriberProvider firebaseEventsSubscriberProvider = new FirebaseEventsSubscriberProvider(universalComponent);
            this.firebaseEventsSubscriberProvider = firebaseEventsSubscriberProvider;
            this.providesDataCollectionHelperProvider = ApiClientModule_ProvidesDataCollectionHelperFactory.create(apiClientModule, this.providesSharedPreferencesUtilsProvider, firebaseEventsSubscriberProvider);
            this.abtIntegrationHelperProvider = InstanceFactory.create(abtIntegrationHelper);
            BlockingExecutorProvider blockingExecutorProvider = new BlockingExecutorProvider(universalComponent);
            this.blockingExecutorProvider = blockingExecutorProvider;
            this.inAppMessageStreamManagerProvider = DoubleCheck.provider(InAppMessageStreamManager_Factory.create(this.appForegroundEventFlowableProvider, this.programmaticContextualTriggerFlowableProvider, this.campaignCacheClientProvider, this.clockProvider, this.providesApiClientProvider, this.analyticsEventsManagerProvider, this.schedulersProvider, this.impressionStorageClientProvider, this.rateLimiterClientProvider, this.appForegroundRateLimitProvider, this.providesTestDeviceHelperProvider, this.providesFirebaseInstallationsProvider, this.providesDataCollectionHelperProvider, this.abtIntegrationHelperProvider, blockingExecutorProvider));
            this.programmaticContextualTriggersProvider = new ProgrammaticContextualTriggersProvider(universalComponent);
            this.providesFirebaseAppProvider = ApiClientModule_ProvidesFirebaseAppFactory.create(apiClientModule);
            this.transportFactoryProvider = InstanceFactory.create(transportFactory);
            this.analyticsConnectorProvider = new AnalyticsConnectorProvider(universalComponent);
            DeveloperListenerManagerProvider developerListenerManagerProvider = new DeveloperListenerManagerProvider(universalComponent);
            this.developerListenerManagerProvider = developerListenerManagerProvider;
            Provider<MetricsLoggerClient> provider2 = DoubleCheck.provider(TransportClientModule_ProvidesMetricsLoggerClientFactory.create(this.providesFirebaseAppProvider, this.transportFactoryProvider, this.analyticsConnectorProvider, this.providesFirebaseInstallationsProvider, this.clockProvider, developerListenerManagerProvider, this.blockingExecutorProvider));
            this.providesMetricsLoggerClientProvider = provider2;
            this.displayCallbacksFactoryProvider = DisplayCallbacksFactory_Factory.create(this.impressionStorageClientProvider, this.clockProvider, this.schedulersProvider, this.rateLimiterClientProvider, this.campaignCacheClientProvider, this.appForegroundRateLimitProvider, provider2, this.providesDataCollectionHelperProvider);
            LightWeightExecutorProvider lightWeightExecutorProvider = new LightWeightExecutorProvider(universalComponent);
            this.lightWeightExecutorProvider = lightWeightExecutorProvider;
            this.firebaseInAppMessagingProvider = DoubleCheck.provider(FirebaseInAppMessaging_Factory.create(this.inAppMessageStreamManagerProvider, this.programmaticContextualTriggersProvider, this.providesDataCollectionHelperProvider, this.providesFirebaseInstallationsProvider, this.displayCallbacksFactoryProvider, this.developerListenerManagerProvider, lightWeightExecutorProvider));
        }

        @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent
        public FirebaseInAppMessaging providesFirebaseInAppMessaging() {
            return (FirebaseInAppMessaging) this.firebaseInAppMessagingProvider.get();
        }

        @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent
        public DisplayCallbacksFactory displayCallbacksFactory() {
            return new DisplayCallbacksFactory((ImpressionStorageClient) Preconditions.checkNotNullFromComponent(this.universalComponent.impressionStorageClient()), (Clock) Preconditions.checkNotNullFromComponent(this.universalComponent.clock()), (Schedulers) Preconditions.checkNotNullFromComponent(this.universalComponent.schedulers()), (RateLimiterClient) Preconditions.checkNotNullFromComponent(this.universalComponent.rateLimiterClient()), (CampaignCacheClient) Preconditions.checkNotNullFromComponent(this.universalComponent.campaignCacheClient()), (RateLimit) Preconditions.checkNotNullFromComponent(this.universalComponent.appForegroundRateLimit()), (MetricsLoggerClient) this.providesMetricsLoggerClientProvider.get(), dataCollectionHelper());
        }

        private static final class AppForegroundEventFlowableProvider implements Provider<ConnectableFlowable<String>> {
            private final UniversalComponent universalComponent;

            AppForegroundEventFlowableProvider(UniversalComponent universalComponent) {
                this.universalComponent = universalComponent;
            }

            /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
            public ConnectableFlowable<String> m2051get() {
                return (ConnectableFlowable) Preconditions.checkNotNullFromComponent(this.universalComponent.appForegroundEventFlowable());
            }
        }

        private static final class ProgrammaticContextualTriggerFlowableProvider implements Provider<ConnectableFlowable<String>> {
            private final UniversalComponent universalComponent;

            ProgrammaticContextualTriggerFlowableProvider(UniversalComponent universalComponent) {
                this.universalComponent = universalComponent;
            }

            /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
            public ConnectableFlowable<String> m2062get() {
                return (ConnectableFlowable) Preconditions.checkNotNullFromComponent(this.universalComponent.programmaticContextualTriggerFlowable());
            }
        }

        private static final class CampaignCacheClientProvider implements Provider<CampaignCacheClient> {
            private final UniversalComponent universalComponent;

            CampaignCacheClientProvider(UniversalComponent universalComponent) {
                this.universalComponent = universalComponent;
            }

            /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
            public CampaignCacheClient m2055get() {
                return (CampaignCacheClient) Preconditions.checkNotNullFromComponent(this.universalComponent.campaignCacheClient());
            }
        }

        private static final class ClockProvider implements Provider<Clock> {
            private final UniversalComponent universalComponent;

            ClockProvider(UniversalComponent universalComponent) {
                this.universalComponent = universalComponent;
            }

            /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
            public Clock m2056get() {
                return (Clock) Preconditions.checkNotNullFromComponent(this.universalComponent.clock());
            }
        }

        private static final class GRPCChannelProvider implements Provider<Channel> {
            private final UniversalComponent universalComponent;

            GRPCChannelProvider(UniversalComponent universalComponent) {
                this.universalComponent = universalComponent;
            }

            /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
            public Channel m2059get() {
                return (Channel) Preconditions.checkNotNullFromComponent(this.universalComponent.gRPCChannel());
            }
        }

        private static final class ApplicationProvider implements Provider<Application> {
            private final UniversalComponent universalComponent;

            ApplicationProvider(UniversalComponent universalComponent) {
                this.universalComponent = universalComponent;
            }

            /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
            public Application m2053get() {
                return (Application) Preconditions.checkNotNullFromComponent(this.universalComponent.application());
            }
        }

        private static final class ProviderInstallerProvider implements Provider<ProviderInstaller> {
            private final UniversalComponent universalComponent;

            ProviderInstallerProvider(UniversalComponent universalComponent) {
                this.universalComponent = universalComponent;
            }

            /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
            public ProviderInstaller m2064get() {
                return (ProviderInstaller) Preconditions.checkNotNullFromComponent(this.universalComponent.providerInstaller());
            }
        }

        private static final class AnalyticsEventsManagerProvider implements Provider<AnalyticsEventsManager> {
            private final UniversalComponent universalComponent;

            AnalyticsEventsManagerProvider(UniversalComponent universalComponent) {
                this.universalComponent = universalComponent;
            }

            /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
            public AnalyticsEventsManager m2050get() {
                return (AnalyticsEventsManager) Preconditions.checkNotNullFromComponent(this.universalComponent.analyticsEventsManager());
            }
        }

        private static final class SchedulersProvider implements Provider<Schedulers> {
            private final UniversalComponent universalComponent;

            SchedulersProvider(UniversalComponent universalComponent) {
                this.universalComponent = universalComponent;
            }

            /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
            public Schedulers m2066get() {
                return (Schedulers) Preconditions.checkNotNullFromComponent(this.universalComponent.schedulers());
            }
        }

        private static final class ImpressionStorageClientProvider implements Provider<ImpressionStorageClient> {
            private final UniversalComponent universalComponent;

            ImpressionStorageClientProvider(UniversalComponent universalComponent) {
                this.universalComponent = universalComponent;
            }

            /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
            public ImpressionStorageClient m2060get() {
                return (ImpressionStorageClient) Preconditions.checkNotNullFromComponent(this.universalComponent.impressionStorageClient());
            }
        }

        private static final class RateLimiterClientProvider implements Provider<RateLimiterClient> {
            private final UniversalComponent universalComponent;

            RateLimiterClientProvider(UniversalComponent universalComponent) {
                this.universalComponent = universalComponent;
            }

            /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
            public RateLimiterClient m2065get() {
                return (RateLimiterClient) Preconditions.checkNotNullFromComponent(this.universalComponent.rateLimiterClient());
            }
        }

        private static final class AppForegroundRateLimitProvider implements Provider<RateLimit> {
            private final UniversalComponent universalComponent;

            AppForegroundRateLimitProvider(UniversalComponent universalComponent) {
                this.universalComponent = universalComponent;
            }

            /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
            public RateLimit m2052get() {
                return (RateLimit) Preconditions.checkNotNullFromComponent(this.universalComponent.appForegroundRateLimit());
            }
        }

        private static final class FirebaseEventsSubscriberProvider implements Provider<Subscriber> {
            private final UniversalComponent universalComponent;

            FirebaseEventsSubscriberProvider(UniversalComponent universalComponent) {
                this.universalComponent = universalComponent;
            }

            /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
            public Subscriber m2058get() {
                return (Subscriber) Preconditions.checkNotNullFromComponent(this.universalComponent.firebaseEventsSubscriber());
            }
        }

        private static final class BlockingExecutorProvider implements Provider<Executor> {
            private final UniversalComponent universalComponent;

            BlockingExecutorProvider(UniversalComponent universalComponent) {
                this.universalComponent = universalComponent;
            }

            public Executor get() {
                return (Executor) Preconditions.checkNotNullFromComponent(this.universalComponent.blockingExecutor());
            }
        }

        private static final class ProgrammaticContextualTriggersProvider implements Provider<ProgramaticContextualTriggers> {
            private final UniversalComponent universalComponent;

            ProgrammaticContextualTriggersProvider(UniversalComponent universalComponent) {
                this.universalComponent = universalComponent;
            }

            /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
            public ProgramaticContextualTriggers m2063get() {
                return (ProgramaticContextualTriggers) Preconditions.checkNotNullFromComponent(this.universalComponent.programmaticContextualTriggers());
            }
        }

        private static final class AnalyticsConnectorProvider implements Provider<AnalyticsConnector> {
            private final UniversalComponent universalComponent;

            AnalyticsConnectorProvider(UniversalComponent universalComponent) {
                this.universalComponent = universalComponent;
            }

            /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
            public AnalyticsConnector m2049get() {
                return (AnalyticsConnector) Preconditions.checkNotNullFromComponent(this.universalComponent.analyticsConnector());
            }
        }

        private static final class DeveloperListenerManagerProvider implements Provider<DeveloperListenerManager> {
            private final UniversalComponent universalComponent;

            DeveloperListenerManagerProvider(UniversalComponent universalComponent) {
                this.universalComponent = universalComponent;
            }

            /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
            public DeveloperListenerManager m2057get() {
                return (DeveloperListenerManager) Preconditions.checkNotNullFromComponent(this.universalComponent.developerListenerManager());
            }
        }

        private static final class LightWeightExecutorProvider implements Provider<Executor> {
            private final UniversalComponent universalComponent;

            LightWeightExecutorProvider(UniversalComponent universalComponent) {
                this.universalComponent = universalComponent;
            }

            public Executor get() {
                return (Executor) Preconditions.checkNotNullFromComponent(this.universalComponent.lightWeightExecutor());
            }
        }
    }
}
