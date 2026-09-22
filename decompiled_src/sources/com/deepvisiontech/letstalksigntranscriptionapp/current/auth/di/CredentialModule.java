package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.di;

import android.content.Context;
import androidx.credentials.CredentialManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.CredentialRepositoryImpl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.CredentialRepository;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CredentialModule.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0007¨\u0006\u000b"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/di/CredentialModule;", "", "<init>", "()V", "provideCredentialManager", "Landroidx/credentials/CredentialManager;", "context", "Landroid/content/Context;", "provideCredentialRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/CredentialRepository;", "credentialManager", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public final class CredentialModule {
    public static final int $stable = 0;
    public static final CredentialModule INSTANCE = new CredentialModule();

    private CredentialModule() {
    }

    @Provides
    @Singleton
    public final CredentialManager provideCredentialManager(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return CredentialManager.Companion.create(context);
    }

    @Provides
    @Singleton
    public final CredentialRepository provideCredentialRepository(CredentialManager credentialManager) {
        Intrinsics.checkNotNullParameter(credentialManager, "credentialManager");
        return new CredentialRepositoryImpl(credentialManager);
    }
}
