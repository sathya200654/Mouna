package com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview;

import android.content.Context;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.SettingsRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class WebViewModule_ProvidesWebViewManagerFactory implements Factory<WebViewManager> {
    private final Provider<Context> contextProvider;
    private final Provider<CoroutineDispatcher> defaultDispatcherProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;

    private WebViewModule_ProvidesWebViewManagerFactory(Provider<Context> contextProvider, Provider<CoroutineDispatcher> defaultDispatcherProvider, Provider<SettingsRepository> settingsRepositoryProvider) {
        this.contextProvider = contextProvider;
        this.defaultDispatcherProvider = defaultDispatcherProvider;
        this.settingsRepositoryProvider = settingsRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public WebViewManager m1708get() {
        return providesWebViewManager((Context) this.contextProvider.get(), (CoroutineDispatcher) this.defaultDispatcherProvider.get(), (SettingsRepository) this.settingsRepositoryProvider.get());
    }

    public static WebViewModule_ProvidesWebViewManagerFactory create(Provider<Context> contextProvider, Provider<CoroutineDispatcher> defaultDispatcherProvider, Provider<SettingsRepository> settingsRepositoryProvider) {
        return new WebViewModule_ProvidesWebViewManagerFactory(contextProvider, defaultDispatcherProvider, settingsRepositoryProvider);
    }

    public static WebViewManager providesWebViewManager(Context context, CoroutineDispatcher defaultDispatcher, SettingsRepository settingsRepository) {
        return (WebViewManager) Preconditions.checkNotNullFromProvides(WebViewModule.INSTANCE.providesWebViewManager(context, defaultDispatcher, settingsRepository));
    }
}
