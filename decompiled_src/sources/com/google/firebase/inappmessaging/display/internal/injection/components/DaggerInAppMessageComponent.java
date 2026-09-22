package com.google.firebase.inappmessaging.display.internal.injection.components;

import android.view.LayoutInflater;
import com.google.firebase.inappmessaging.display.dagger.internal.DoubleCheck;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BannerBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BannerBindingWrapper_Factory;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.CardBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.CardBindingWrapper_Factory;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.ImageBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.ImageBindingWrapper_Factory;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.ModalBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.ModalBindingWrapper_Factory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule_InAppMessageLayoutConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule_ProvidesBannerMessageFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule_ProvidesInflaterserviceFactory;
import com.google.firebase.inappmessaging.model.InAppMessage;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class DaggerInAppMessageComponent {
    private DaggerInAppMessageComponent() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private InflaterModule inflaterModule;

        private Builder() {
        }

        public Builder inflaterModule(InflaterModule inflaterModule) {
            this.inflaterModule = (InflaterModule) Preconditions.checkNotNull(inflaterModule);
            return this;
        }

        public InAppMessageComponent build() {
            Preconditions.checkBuilderRequirement(this.inflaterModule, InflaterModule.class);
            return new InAppMessageComponentImpl(this.inflaterModule);
        }
    }

    private static final class InAppMessageComponentImpl implements InAppMessageComponent {
        private Provider<BannerBindingWrapper> bannerBindingWrapperProvider;
        private Provider<CardBindingWrapper> cardBindingWrapperProvider;
        private Provider<ImageBindingWrapper> imageBindingWrapperProvider;
        private final InAppMessageComponentImpl inAppMessageComponentImpl;
        private Provider<InAppMessageLayoutConfig> inAppMessageLayoutConfigProvider;
        private Provider<ModalBindingWrapper> modalBindingWrapperProvider;
        private Provider<InAppMessage> providesBannerMessageProvider;
        private Provider<LayoutInflater> providesInflaterserviceProvider;

        private InAppMessageComponentImpl(InflaterModule inflaterModule) {
            this.inAppMessageComponentImpl = this;
            initialize(inflaterModule);
        }

        private void initialize(InflaterModule inflaterModule) {
            this.inAppMessageLayoutConfigProvider = DoubleCheck.provider(InflaterModule_InAppMessageLayoutConfigFactory.create(inflaterModule));
            this.providesInflaterserviceProvider = DoubleCheck.provider(InflaterModule_ProvidesInflaterserviceFactory.create(inflaterModule));
            InflaterModule_ProvidesBannerMessageFactory inflaterModule_ProvidesBannerMessageFactoryCreate = InflaterModule_ProvidesBannerMessageFactory.create(inflaterModule);
            this.providesBannerMessageProvider = inflaterModule_ProvidesBannerMessageFactoryCreate;
            this.imageBindingWrapperProvider = DoubleCheck.provider(ImageBindingWrapper_Factory.create(this.inAppMessageLayoutConfigProvider, this.providesInflaterserviceProvider, inflaterModule_ProvidesBannerMessageFactoryCreate));
            this.modalBindingWrapperProvider = DoubleCheck.provider(ModalBindingWrapper_Factory.create(this.inAppMessageLayoutConfigProvider, this.providesInflaterserviceProvider, this.providesBannerMessageProvider));
            this.bannerBindingWrapperProvider = DoubleCheck.provider(BannerBindingWrapper_Factory.create(this.inAppMessageLayoutConfigProvider, this.providesInflaterserviceProvider, this.providesBannerMessageProvider));
            this.cardBindingWrapperProvider = DoubleCheck.provider(CardBindingWrapper_Factory.create(this.inAppMessageLayoutConfigProvider, this.providesInflaterserviceProvider, this.providesBannerMessageProvider));
        }

        @Override // com.google.firebase.inappmessaging.display.internal.injection.components.InAppMessageComponent
        public ImageBindingWrapper imageBindingWrapper() {
            return (ImageBindingWrapper) this.imageBindingWrapperProvider.get();
        }

        @Override // com.google.firebase.inappmessaging.display.internal.injection.components.InAppMessageComponent
        public ModalBindingWrapper modalBindingWrapper() {
            return (ModalBindingWrapper) this.modalBindingWrapperProvider.get();
        }

        @Override // com.google.firebase.inappmessaging.display.internal.injection.components.InAppMessageComponent
        public BannerBindingWrapper bannerBindingWrapper() {
            return (BannerBindingWrapper) this.bannerBindingWrapperProvider.get();
        }

        @Override // com.google.firebase.inappmessaging.display.internal.injection.components.InAppMessageComponent
        public CardBindingWrapper cardBindingWrapper() {
            return (CardBindingWrapper) this.cardBindingWrapperProvider.get();
        }
    }
}
