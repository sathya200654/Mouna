package com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.di;

import android.content.Context;
import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class EngagementModule_ProvideEngagementRepositoryFactory implements Factory<EngagementRepository> {
    private final Provider<Context> contextProvider;

    private EngagementModule_ProvideEngagementRepositoryFactory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public EngagementRepository m1710get() {
        return provideEngagementRepository((Context) this.contextProvider.get());
    }

    public static EngagementModule_ProvideEngagementRepositoryFactory create(Provider<Context> contextProvider) {
        return new EngagementModule_ProvideEngagementRepositoryFactory(contextProvider);
    }

    public static EngagementRepository provideEngagementRepository(Context context) {
        return (EngagementRepository) Preconditions.checkNotNullFromProvides(EngagementModule.INSTANCE.provideEngagementRepository(context));
    }
}
