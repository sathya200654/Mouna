package com.deepvisiontech.letstalksigntranscriptionapp.current.core.network.di;

import android.content.Context;
import android.net.ConnectivityManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.network.data.NetworkMonitor;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkDiModule.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0007¨\u0006\u000b"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/network/di/NetworkDiModule;", "", "<init>", "()V", "provideConnectivityManager", "Landroid/net/ConnectivityManager;", "context", "Landroid/content/Context;", "provideNetworkMonitor", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/network/data/NetworkMonitor;", "connectivityManager", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public final class NetworkDiModule {
    public static final int $stable = 0;
    public static final NetworkDiModule INSTANCE = new NetworkDiModule();

    private NetworkDiModule() {
    }

    @Provides
    public final ConnectivityManager provideConnectivityManager(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return (ConnectivityManager) systemService;
    }

    @Provides
    @Singleton
    public final NetworkMonitor provideNetworkMonitor(ConnectivityManager connectivityManager) {
        Intrinsics.checkNotNullParameter(connectivityManager, "connectivityManager");
        return new NetworkMonitor(connectivityManager);
    }
}
