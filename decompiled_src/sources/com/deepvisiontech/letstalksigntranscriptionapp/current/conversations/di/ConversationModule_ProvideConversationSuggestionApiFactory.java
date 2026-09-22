package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.api.ConversationSuggestionsApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConversationModule_ProvideConversationSuggestionApiFactory implements Factory<ConversationSuggestionsApi> {
    private final Provider<Retrofit> retrofitProvider;

    private ConversationModule_ProvideConversationSuggestionApiFactory(Provider<Retrofit> retrofitProvider) {
        this.retrofitProvider = retrofitProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConversationSuggestionsApi m1478get() {
        return provideConversationSuggestionApi((Retrofit) this.retrofitProvider.get());
    }

    public static ConversationModule_ProvideConversationSuggestionApiFactory create(Provider<Retrofit> retrofitProvider) {
        return new ConversationModule_ProvideConversationSuggestionApiFactory(retrofitProvider);
    }

    public static ConversationSuggestionsApi provideConversationSuggestionApi(Retrofit retrofit) {
        return (ConversationSuggestionsApi) Preconditions.checkNotNullFromProvides(ConversationModule.INSTANCE.provideConversationSuggestionApi(retrofit));
    }
}
