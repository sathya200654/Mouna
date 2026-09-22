package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.view.LayoutInflater;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class InflaterModule_ProvidesInflaterserviceFactory implements Factory<LayoutInflater> {
    private final InflaterModule module;

    public InflaterModule_ProvidesInflaterserviceFactory(InflaterModule inflaterModule) {
        this.module = inflaterModule;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public LayoutInflater m1989get() {
        return providesInflaterservice(this.module);
    }

    public static InflaterModule_ProvidesInflaterserviceFactory create(InflaterModule inflaterModule) {
        return new InflaterModule_ProvidesInflaterserviceFactory(inflaterModule);
    }

    public static LayoutInflater providesInflaterservice(InflaterModule inflaterModule) {
        return (LayoutInflater) Preconditions.checkNotNullFromProvides(inflaterModule.providesInflaterservice());
    }
}
