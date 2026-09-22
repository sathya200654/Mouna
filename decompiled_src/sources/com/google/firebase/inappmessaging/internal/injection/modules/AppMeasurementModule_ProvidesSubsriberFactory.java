package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class AppMeasurementModule_ProvidesSubsriberFactory implements Factory<Subscriber> {
    private final AppMeasurementModule module;

    public AppMeasurementModule_ProvidesSubsriberFactory(AppMeasurementModule appMeasurementModule) {
        this.module = appMeasurementModule;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public Subscriber m2076get() {
        return providesSubsriber(this.module);
    }

    public static AppMeasurementModule_ProvidesSubsriberFactory create(AppMeasurementModule appMeasurementModule) {
        return new AppMeasurementModule_ProvidesSubsriberFactory(appMeasurementModule);
    }

    public static Subscriber providesSubsriber(AppMeasurementModule appMeasurementModule) {
        return (Subscriber) Preconditions.checkNotNullFromProvides(appMeasurementModule.providesSubsriber());
    }
}
