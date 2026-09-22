package com.deepvisiontech.letstalksigntranscriptionapp.current;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.notificationintent.domain.repository.NotificationIntentManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.shareintent.domain.ShareIntentManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<NotificationIntentManager> notificationIntentManagerProvider;
    private final Provider<ShareIntentManager> shareIntentManagerProvider;
    private final Provider<WebViewManager> webViewManagerProvider;

    private MainActivity_MembersInjector(Provider<AnalyticsManager> analyticsManagerProvider, Provider<WebViewManager> webViewManagerProvider, Provider<ShareIntentManager> shareIntentManagerProvider, Provider<NotificationIntentManager> notificationIntentManagerProvider) {
        this.analyticsManagerProvider = analyticsManagerProvider;
        this.webViewManagerProvider = webViewManagerProvider;
        this.shareIntentManagerProvider = shareIntentManagerProvider;
        this.notificationIntentManagerProvider = notificationIntentManagerProvider;
    }

    public static MembersInjector<MainActivity> create(Provider<AnalyticsManager> analyticsManagerProvider, Provider<WebViewManager> webViewManagerProvider, Provider<ShareIntentManager> shareIntentManagerProvider, Provider<NotificationIntentManager> notificationIntentManagerProvider) {
        return new MainActivity_MembersInjector(analyticsManagerProvider, webViewManagerProvider, shareIntentManagerProvider, notificationIntentManagerProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MainActivity instance) {
        injectAnalyticsManager(instance, (AnalyticsManager) this.analyticsManagerProvider.get());
        injectWebViewManager(instance, (WebViewManager) this.webViewManagerProvider.get());
        injectShareIntentManager(instance, (ShareIntentManager) this.shareIntentManagerProvider.get());
        injectNotificationIntentManager(instance, (NotificationIntentManager) this.notificationIntentManagerProvider.get());
    }

    public static void injectAnalyticsManager(MainActivity instance, AnalyticsManager analyticsManager) {
        instance.analyticsManager = analyticsManager;
    }

    public static void injectWebViewManager(MainActivity instance, WebViewManager webViewManager) {
        instance.webViewManager = webViewManager;
    }

    public static void injectShareIntentManager(MainActivity instance, ShareIntentManager shareIntentManager) {
        instance.shareIntentManager = shareIntentManager;
    }

    public static void injectNotificationIntentManager(MainActivity instance, NotificationIntentManager notificationIntentManager) {
        instance.notificationIntentManager = notificationIntentManager;
    }
}
