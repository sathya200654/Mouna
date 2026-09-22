package com.google.firebase.inappmessaging.display.internal.injection.modules;

import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory implements Factory<FirebaseInAppMessaging> {
    private final HeadlessInAppMessagingModule module;

    public HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory(HeadlessInAppMessagingModule headlessInAppMessagingModule) {
        this.module = headlessInAppMessagingModule;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public FirebaseInAppMessaging m1977get() {
        return providesHeadlesssSingleton(this.module);
    }

    public static HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory create(HeadlessInAppMessagingModule headlessInAppMessagingModule) {
        return new HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory(headlessInAppMessagingModule);
    }

    public static FirebaseInAppMessaging providesHeadlesssSingleton(HeadlessInAppMessagingModule headlessInAppMessagingModule) {
        return (FirebaseInAppMessaging) Preconditions.checkNotNullFromProvides(headlessInAppMessagingModule.providesHeadlesssSingleton());
    }
}
