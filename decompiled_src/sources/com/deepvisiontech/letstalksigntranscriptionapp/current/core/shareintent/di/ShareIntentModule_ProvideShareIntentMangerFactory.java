package com.deepvisiontech.letstalksigntranscriptionapp.current.core.shareintent.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.core.shareintent.domain.ShareIntentManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ShareIntentModule_ProvideShareIntentMangerFactory implements Factory<ShareIntentManager> {
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ShareIntentManager m1695get() {
        return provideShareIntentManger();
    }

    public static ShareIntentModule_ProvideShareIntentMangerFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ShareIntentManager provideShareIntentManger() {
        return (ShareIntentManager) Preconditions.checkNotNullFromProvides(ShareIntentModule.INSTANCE.provideShareIntentManger());
    }

    private static final class InstanceHolder {
        static final ShareIntentModule_ProvideShareIntentMangerFactory INSTANCE = new ShareIntentModule_ProvideShareIntentMangerFactory();

        private InstanceHolder() {
        }
    }
}
