package com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager;

import android.content.Context;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.SettingsRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class WebViewManagerImpl_Factory implements Factory<WebViewManagerImpl> {
    private final Provider<Context> contextProvider;
    private final Provider<CoroutineDispatcher> defaultDispatcherProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;

    private WebViewManagerImpl_Factory(Provider<SettingsRepository> settingsRepositoryProvider, Provider<CoroutineDispatcher> defaultDispatcherProvider, Provider<Context> contextProvider) {
        this.settingsRepositoryProvider = settingsRepositoryProvider;
        this.defaultDispatcherProvider = defaultDispatcherProvider;
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public WebViewManagerImpl m1709get() {
        return newInstance((SettingsRepository) this.settingsRepositoryProvider.get(), (CoroutineDispatcher) this.defaultDispatcherProvider.get(), (Context) this.contextProvider.get());
    }

    public static WebViewManagerImpl_Factory create(Provider<SettingsRepository> settingsRepositoryProvider, Provider<CoroutineDispatcher> defaultDispatcherProvider, Provider<Context> contextProvider) {
        return new WebViewManagerImpl_Factory(settingsRepositoryProvider, defaultDispatcherProvider, contextProvider);
    }

    public static WebViewManagerImpl newInstance(SettingsRepository settingsRepository, CoroutineDispatcher defaultDispatcher, Context context) {
        return new WebViewManagerImpl(settingsRepository, defaultDispatcher, context);
    }
}
