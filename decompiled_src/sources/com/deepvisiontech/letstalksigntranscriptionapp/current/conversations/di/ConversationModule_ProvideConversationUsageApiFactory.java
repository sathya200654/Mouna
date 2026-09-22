package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.api.ConversationUsageApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConversationModule_ProvideConversationUsageApiFactory implements Factory<ConversationUsageApi> {
    private final Provider<Retrofit> retrofitProvider;

    private ConversationModule_ProvideConversationUsageApiFactory(Provider<Retrofit> retrofitProvider) {
        this.retrofitProvider = retrofitProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConversationUsageApi m1481get() {
        return provideConversationUsageApi((Retrofit) this.retrofitProvider.get());
    }

    public static ConversationModule_ProvideConversationUsageApiFactory create(Provider<Retrofit> retrofitProvider) {
        return new ConversationModule_ProvideConversationUsageApiFactory(retrofitProvider);
    }

    public static ConversationUsageApi provideConversationUsageApi(Retrofit retrofit) {
        return (ConversationUsageApi) Preconditions.checkNotNullFromProvides(ConversationModule.INSTANCE.provideConversationUsageApi(retrofit));
    }
}
