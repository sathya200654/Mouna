package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.api.ConversationOcrApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConversationModule_ProvideConversationOcrApiFactory implements Factory<ConversationOcrApi> {
    private final Provider<Retrofit> retrofitProvider;

    private ConversationModule_ProvideConversationOcrApiFactory(Provider<Retrofit> retrofitProvider) {
        this.retrofitProvider = retrofitProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConversationOcrApi m1474get() {
        return provideConversationOcrApi((Retrofit) this.retrofitProvider.get());
    }

    public static ConversationModule_ProvideConversationOcrApiFactory create(Provider<Retrofit> retrofitProvider) {
        return new ConversationModule_ProvideConversationOcrApiFactory(retrofitProvider);
    }

    public static ConversationOcrApi provideConversationOcrApi(Retrofit retrofit) {
        return (ConversationOcrApi) Preconditions.checkNotNullFromProvides(ConversationModule.INSTANCE.provideConversationOcrApi(retrofit));
    }
}
