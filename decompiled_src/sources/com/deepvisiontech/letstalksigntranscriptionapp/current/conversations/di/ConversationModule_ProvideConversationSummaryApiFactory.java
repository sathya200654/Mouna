package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.api.ConversationSummaryApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConversationModule_ProvideConversationSummaryApiFactory implements Factory<ConversationSummaryApi> {
    private final Provider<Retrofit> retrofitProvider;

    private ConversationModule_ProvideConversationSummaryApiFactory(Provider<Retrofit> retrofitProvider) {
        this.retrofitProvider = retrofitProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConversationSummaryApi m1480get() {
        return provideConversationSummaryApi((Retrofit) this.retrofitProvider.get());
    }

    public static ConversationModule_ProvideConversationSummaryApiFactory create(Provider<Retrofit> retrofitProvider) {
        return new ConversationModule_ProvideConversationSummaryApiFactory(retrofitProvider);
    }

    public static ConversationSummaryApi provideConversationSummaryApi(Retrofit retrofit) {
        return (ConversationSummaryApi) Preconditions.checkNotNullFromProvides(ConversationModule.INSTANCE.provideConversationSummaryApi(retrofit));
    }
}
