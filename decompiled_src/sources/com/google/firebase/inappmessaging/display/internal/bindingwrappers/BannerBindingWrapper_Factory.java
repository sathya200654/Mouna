package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.view.LayoutInflater;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.model.InAppMessage;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class BannerBindingWrapper_Factory implements Factory<BannerBindingWrapper> {
    private final Provider<InAppMessageLayoutConfig> configProvider;
    private final Provider<LayoutInflater> inflaterProvider;
    private final Provider<InAppMessage> messageProvider;

    public BannerBindingWrapper_Factory(Provider<InAppMessageLayoutConfig> provider, Provider<LayoutInflater> provider2, Provider<InAppMessage> provider3) {
        this.configProvider = provider;
        this.inflaterProvider = provider2;
        this.messageProvider = provider3;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public BannerBindingWrapper m1967get() {
        return newInstance((InAppMessageLayoutConfig) this.configProvider.get(), (LayoutInflater) this.inflaterProvider.get(), (InAppMessage) this.messageProvider.get());
    }

    public static BannerBindingWrapper_Factory create(Provider<InAppMessageLayoutConfig> provider, Provider<LayoutInflater> provider2, Provider<InAppMessage> provider3) {
        return new BannerBindingWrapper_Factory(provider, provider2, provider3);
    }

    public static BannerBindingWrapper newInstance(InAppMessageLayoutConfig inAppMessageLayoutConfig, LayoutInflater layoutInflater, InAppMessage inAppMessage) {
        return new BannerBindingWrapper(inAppMessageLayoutConfig, layoutInflater, inAppMessage);
    }
}
