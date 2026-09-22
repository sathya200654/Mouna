package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository;

import android.content.Context;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.api.ConversationUsageApi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConversationUsageRepositoryImpl_Factory implements Factory<ConversationUsageRepositoryImpl> {
    private final Provider<Context> contextProvider;
    private final Provider<ConversationUsageApi> conversationUsageApiProvider;

    private ConversationUsageRepositoryImpl_Factory(Provider<Context> contextProvider, Provider<ConversationUsageApi> conversationUsageApiProvider) {
        this.contextProvider = contextProvider;
        this.conversationUsageApiProvider = conversationUsageApiProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConversationUsageRepositoryImpl m1468get() {
        return newInstance((Context) this.contextProvider.get(), (ConversationUsageApi) this.conversationUsageApiProvider.get());
    }

    public static ConversationUsageRepositoryImpl_Factory create(Provider<Context> contextProvider, Provider<ConversationUsageApi> conversationUsageApiProvider) {
        return new ConversationUsageRepositoryImpl_Factory(contextProvider, conversationUsageApiProvider);
    }

    public static ConversationUsageRepositoryImpl newInstance(Context context, ConversationUsageApi conversationUsageApi) {
        return new ConversationUsageRepositoryImpl(context, conversationUsageApi);
    }
}
