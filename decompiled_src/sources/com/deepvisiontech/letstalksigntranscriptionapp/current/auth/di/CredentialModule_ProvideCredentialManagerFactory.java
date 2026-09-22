package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.di;

import android.content.Context;
import androidx.credentials.CredentialManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class CredentialModule_ProvideCredentialManagerFactory implements Factory<CredentialManager> {
    private final Provider<Context> contextProvider;

    private CredentialModule_ProvideCredentialManagerFactory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public CredentialManager m1363get() {
        return provideCredentialManager((Context) this.contextProvider.get());
    }

    public static CredentialModule_ProvideCredentialManagerFactory create(Provider<Context> contextProvider) {
        return new CredentialModule_ProvideCredentialManagerFactory(contextProvider);
    }

    public static CredentialManager provideCredentialManager(Context context) {
        return (CredentialManager) Preconditions.checkNotNullFromProvides(CredentialModule.INSTANCE.provideCredentialManager(context));
    }
}
