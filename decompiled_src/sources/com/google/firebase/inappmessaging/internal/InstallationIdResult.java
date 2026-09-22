package com.google.firebase.inappmessaging.internal;

import com.google.firebase.installations.InstallationTokenResult;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class InstallationIdResult {
    abstract String installationId();

    abstract InstallationTokenResult installationTokenResult();

    public static InstallationIdResult create(String str, InstallationTokenResult installationTokenResult) {
        return new AutoValue_InstallationIdResult(str, installationTokenResult);
    }
}
