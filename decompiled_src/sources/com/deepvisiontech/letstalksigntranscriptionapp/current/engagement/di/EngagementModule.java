package com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.di;

import android.content.Context;
import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.data.repository.EngagementRepositoryImpl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EngagementModule.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/di/EngagementModule;", "", "<init>", "()V", "provideEngagementRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/domain/repository/EngagementRepository;", "context", "Landroid/content/Context;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public final class EngagementModule {
    public static final int $stable = 0;
    public static final EngagementModule INSTANCE = new EngagementModule();

    private EngagementModule() {
    }

    @Provides
    @Singleton
    public final EngagementRepository provideEngagementRepository(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new EngagementRepositoryImpl(context);
    }
}
