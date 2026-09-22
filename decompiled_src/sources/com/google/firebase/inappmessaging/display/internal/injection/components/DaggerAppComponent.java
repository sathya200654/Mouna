package com.google.firebase.inappmessaging.display.internal.injection.components;

import android.app.Application;
import com.bumptech.glide.RequestManager;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay;
import com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay_Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.DoubleCheck;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.FiamAnimator;
import com.google.firebase.inappmessaging.display.internal.FiamAnimator_Factory;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader_Factory;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.RenewableTimer_Factory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.GlideModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.GlideModule_ProvidesGlideRequestManagerFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.HeadlessInAppMessagingModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class DaggerAppComponent {
    private DaggerAppComponent() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private GlideModule glideModule;
        private HeadlessInAppMessagingModule headlessInAppMessagingModule;
        private UniversalComponent universalComponent;

        private Builder() {
        }

        public Builder headlessInAppMessagingModule(HeadlessInAppMessagingModule headlessInAppMessagingModule) {
            this.headlessInAppMessagingModule = (HeadlessInAppMessagingModule) Preconditions.checkNotNull(headlessInAppMessagingModule);
            return this;
        }

        public Builder glideModule(GlideModule glideModule) {
            this.glideModule = (GlideModule) Preconditions.checkNotNull(glideModule);
            return this;
        }

        public Builder universalComponent(UniversalComponent universalComponent) {
            this.universalComponent = (UniversalComponent) Preconditions.checkNotNull(universalComponent);
            return this;
        }

        public AppComponent build() {
            Preconditions.checkBuilderRequirement(this.headlessInAppMessagingModule, HeadlessInAppMessagingModule.class);
            if (this.glideModule == null) {
                this.glideModule = new GlideModule();
            }
            Preconditions.checkBuilderRequirement(this.universalComponent, UniversalComponent.class);
            return new AppComponentImpl(this.headlessInAppMessagingModule, this.glideModule, this.universalComponent);
        }
    }

    private static final class AppComponentImpl implements AppComponent {
        private final AppComponentImpl appComponentImpl;
        private Provider<FiamAnimator> fiamAnimatorProvider;
        private Provider<FiamImageLoader> fiamImageLoaderProvider;
        private Provider<FiamWindowManager> fiamWindowManagerProvider;
        private Provider<FirebaseInAppMessagingDisplay> firebaseInAppMessagingDisplayProvider;
        private Provider<BindingWrapperFactory> inflaterClientProvider;
        private Provider<Map<String, Provider<InAppMessageLayoutConfig>>> myKeyStringMapProvider;
        private Provider<Application> providesApplicationProvider;
        private Provider<RequestManager> providesGlideRequestManagerProvider;
        private Provider<FirebaseInAppMessaging> providesHeadlesssSingletonProvider;

        private AppComponentImpl(HeadlessInAppMessagingModule headlessInAppMessagingModule, GlideModule glideModule, UniversalComponent universalComponent) {
            this.appComponentImpl = this;
            initialize(headlessInAppMessagingModule, glideModule, universalComponent);
        }

        private void initialize(HeadlessInAppMessagingModule headlessInAppMessagingModule, GlideModule glideModule, UniversalComponent universalComponent) {
            this.providesHeadlesssSingletonProvider = DoubleCheck.provider(HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory.create(headlessInAppMessagingModule));
            this.myKeyStringMapProvider = new MyKeyStringMapProvider(universalComponent);
            ProvidesApplicationProvider providesApplicationProvider = new ProvidesApplicationProvider(universalComponent);
            this.providesApplicationProvider = providesApplicationProvider;
            Provider<RequestManager> provider = DoubleCheck.provider(GlideModule_ProvidesGlideRequestManagerFactory.create(glideModule, providesApplicationProvider));
            this.providesGlideRequestManagerProvider = provider;
            this.fiamImageLoaderProvider = DoubleCheck.provider(FiamImageLoader_Factory.create(provider));
            this.fiamWindowManagerProvider = new FiamWindowManagerProvider(universalComponent);
            this.inflaterClientProvider = new InflaterClientProvider(universalComponent);
            this.fiamAnimatorProvider = DoubleCheck.provider(FiamAnimator_Factory.create());
            this.firebaseInAppMessagingDisplayProvider = DoubleCheck.provider(FirebaseInAppMessagingDisplay_Factory.create(this.providesHeadlesssSingletonProvider, this.myKeyStringMapProvider, this.fiamImageLoaderProvider, RenewableTimer_Factory.create(), RenewableTimer_Factory.create(), this.fiamWindowManagerProvider, this.providesApplicationProvider, this.inflaterClientProvider, this.fiamAnimatorProvider));
        }

        @Override // com.google.firebase.inappmessaging.display.internal.injection.components.AppComponent
        public FirebaseInAppMessagingDisplay providesFirebaseInAppMessagingUI() {
            return (FirebaseInAppMessagingDisplay) this.firebaseInAppMessagingDisplayProvider.get();
        }

        @Override // com.google.firebase.inappmessaging.display.internal.injection.components.AppComponent
        public FiamImageLoader fiamImageLoader() {
            return (FiamImageLoader) this.fiamImageLoaderProvider.get();
        }

        private static final class MyKeyStringMapProvider implements Provider<Map<String, Provider<InAppMessageLayoutConfig>>> {
            private final UniversalComponent universalComponent;

            MyKeyStringMapProvider(UniversalComponent universalComponent) {
                this.universalComponent = universalComponent;
            }

            public Map<String, Provider<InAppMessageLayoutConfig>> get() {
                return (Map) Preconditions.checkNotNullFromComponent(this.universalComponent.myKeyStringMap());
            }
        }

        private static final class ProvidesApplicationProvider implements Provider<Application> {
            private final UniversalComponent universalComponent;

            ProvidesApplicationProvider(UniversalComponent universalComponent) {
                this.universalComponent = universalComponent;
            }

            /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
            public Application m1974get() {
                return (Application) Preconditions.checkNotNullFromComponent(this.universalComponent.providesApplication());
            }
        }

        private static final class FiamWindowManagerProvider implements Provider<FiamWindowManager> {
            private final UniversalComponent universalComponent;

            FiamWindowManagerProvider(UniversalComponent universalComponent) {
                this.universalComponent = universalComponent;
            }

            /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
            public FiamWindowManager m1971get() {
                return (FiamWindowManager) Preconditions.checkNotNullFromComponent(this.universalComponent.fiamWindowManager());
            }
        }

        private static final class InflaterClientProvider implements Provider<BindingWrapperFactory> {
            private final UniversalComponent universalComponent;

            InflaterClientProvider(UniversalComponent universalComponent) {
                this.universalComponent = universalComponent;
            }

            /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
            public BindingWrapperFactory m1972get() {
                return (BindingWrapperFactory) Preconditions.checkNotNullFromComponent(this.universalComponent.inflaterClient());
            }
        }
    }
}
