package com.google.firebase.inappmessaging.display.internal.injection.modules;

import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class InflaterModule_ProvidesBannerMessageFactory implements Factory<InAppMessage> {
    private final InflaterModule module;

    public InflaterModule_ProvidesBannerMessageFactory(InflaterModule inflaterModule) {
        this.module = inflaterModule;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public InAppMessage m1988get() {
        return providesBannerMessage(this.module);
    }

    public static InflaterModule_ProvidesBannerMessageFactory create(InflaterModule inflaterModule) {
        return new InflaterModule_ProvidesBannerMessageFactory(inflaterModule);
    }

    public static InAppMessage providesBannerMessage(InflaterModule inflaterModule) {
        return (InAppMessage) Preconditions.checkNotNullFromProvides(inflaterModule.providesBannerMessage());
    }
}
