package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Singleton
public class ProviderInstaller {
    private final Application application;

    @Inject
    ProviderInstaller(Application application) {
        this.application = application;
    }

    public void install() {
        try {
            com.google.android.gms.security.ProviderInstaller.installIfNeeded(this.application);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        }
    }
}
