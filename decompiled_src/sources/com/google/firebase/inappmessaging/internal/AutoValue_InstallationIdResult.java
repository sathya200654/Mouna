package com.google.firebase.inappmessaging.internal;

import com.google.firebase.installations.InstallationTokenResult;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_InstallationIdResult extends InstallationIdResult {
    private final String installationId;
    private final InstallationTokenResult installationTokenResult;

    AutoValue_InstallationIdResult(String str, InstallationTokenResult installationTokenResult) {
        if (str == null) {
            throw new NullPointerException("Null installationId");
        }
        this.installationId = str;
        if (installationTokenResult == null) {
            throw new NullPointerException("Null installationTokenResult");
        }
        this.installationTokenResult = installationTokenResult;
    }

    @Override // com.google.firebase.inappmessaging.internal.InstallationIdResult
    String installationId() {
        return this.installationId;
    }

    @Override // com.google.firebase.inappmessaging.internal.InstallationIdResult
    InstallationTokenResult installationTokenResult() {
        return this.installationTokenResult;
    }

    public String toString() {
        return "InstallationIdResult{installationId=" + this.installationId + ", installationTokenResult=" + this.installationTokenResult + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstallationIdResult) {
            InstallationIdResult installationIdResult = (InstallationIdResult) obj;
            if (this.installationId.equals(installationIdResult.installationId()) && this.installationTokenResult.equals(installationIdResult.installationTokenResult())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.installationTokenResult.hashCode() ^ ((this.installationId.hashCode() ^ 1000003) * 1000003);
    }
}
