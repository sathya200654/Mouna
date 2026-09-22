package com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview;

import android.content.Context;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.SettingsRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: compiled from: WebViewModule.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/WebViewModule;", "", "<init>", "()V", "providesWebViewManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;", "context", "Landroid/content/Context;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "settingsRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/repository/SettingsRepository;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public final class WebViewModule {
    public static final int $stable = 0;
    public static final WebViewModule INSTANCE = new WebViewModule();

    private WebViewModule() {
    }

    @Provides
    @Singleton
    public final WebViewManager providesWebViewManager(@ApplicationContext Context context, CoroutineDispatcher defaultDispatcher, SettingsRepository settingsRepository) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(defaultDispatcher, "defaultDispatcher");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        return new WebViewManagerImpl(settingsRepository, defaultDispatcher, context);
    }
}
