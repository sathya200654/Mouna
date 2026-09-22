package com.deepvisiontech.letstalksigntranscriptionapp.current.core.shareintent.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.core.shareintent.data.ShareIntentManagerImpl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.shareintent.domain.ShareIntentManager;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;

/* JADX INFO: compiled from: ShareIntentModule.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/shareintent/di/ShareIntentModule;", "", "<init>", "()V", "provideShareIntentManger", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/shareintent/domain/ShareIntentManager;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public final class ShareIntentModule {
    public static final int $stable = 0;
    public static final ShareIntentModule INSTANCE = new ShareIntentModule();

    private ShareIntentModule() {
    }

    @Provides
    @Singleton
    public final ShareIntentManager provideShareIntentManger() {
        return new ShareIntentManagerImpl();
    }
}
