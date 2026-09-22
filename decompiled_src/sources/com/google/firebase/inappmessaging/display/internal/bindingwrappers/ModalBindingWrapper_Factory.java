package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.view.LayoutInflater;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.model.InAppMessage;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ModalBindingWrapper_Factory implements Factory<ModalBindingWrapper> {
    private final Provider<InAppMessageLayoutConfig> configProvider;
    private final Provider<LayoutInflater> inflaterProvider;
    private final Provider<InAppMessage> messageProvider;

    public ModalBindingWrapper_Factory(Provider<InAppMessageLayoutConfig> provider, Provider<LayoutInflater> provider2, Provider<InAppMessage> provider3) {
        this.configProvider = provider;
        this.inflaterProvider = provider2;
        this.messageProvider = provider3;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ModalBindingWrapper m1970get() {
        return newInstance((InAppMessageLayoutConfig) this.configProvider.get(), (LayoutInflater) this.inflaterProvider.get(), (InAppMessage) this.messageProvider.get());
    }

    public static ModalBindingWrapper_Factory create(Provider<InAppMessageLayoutConfig> provider, Provider<LayoutInflater> provider2, Provider<InAppMessage> provider3) {
        return new ModalBindingWrapper_Factory(provider, provider2, provider3);
    }

    public static ModalBindingWrapper newInstance(InAppMessageLayoutConfig inAppMessageLayoutConfig, LayoutInflater layoutInflater, InAppMessage inAppMessage) {
        return new ModalBindingWrapper(inAppMessageLayoutConfig, layoutInflater, inAppMessage);
    }
}
