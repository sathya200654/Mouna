package com.google.firebase.inappmessaging.display.internal.injection.modules;

import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class InflaterModule_InAppMessageLayoutConfigFactory implements Factory<InAppMessageLayoutConfig> {
    private final InflaterModule module;

    public InflaterModule_InAppMessageLayoutConfigFactory(InflaterModule inflaterModule) {
        this.module = inflaterModule;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public InAppMessageLayoutConfig m1987get() {
        return inAppMessageLayoutConfig(this.module);
    }

    public static InflaterModule_InAppMessageLayoutConfigFactory create(InflaterModule inflaterModule) {
        return new InflaterModule_InAppMessageLayoutConfigFactory(inflaterModule);
    }

    public static InAppMessageLayoutConfig inAppMessageLayoutConfig(InflaterModule inflaterModule) {
        return (InAppMessageLayoutConfig) Preconditions.checkNotNullFromProvides(inflaterModule.inAppMessageLayoutConfig());
    }
}
