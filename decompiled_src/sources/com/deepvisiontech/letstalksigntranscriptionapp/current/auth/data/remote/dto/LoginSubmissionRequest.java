package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.remote.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoginSubmissionRequest.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/data/remote/dto/LoginSubmissionRequest;", "", "deviceId", "", "gmailId", "customerId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getGmailId", "getCustomerId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class LoginSubmissionRequest {
    public static final int $stable = 0;

    @SerializedName("customer_id")
    private final String customerId;

    @SerializedName("device_id")
    private final String deviceId;

    @SerializedName("gmail_id")
    private final String gmailId;

    public static /* synthetic */ LoginSubmissionRequest copy$default(LoginSubmissionRequest loginSubmissionRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loginSubmissionRequest.deviceId;
        }
        if ((i & 2) != 0) {
            str2 = loginSubmissionRequest.gmailId;
        }
        if ((i & 4) != 0) {
            str3 = loginSubmissionRequest.customerId;
        }
        return loginSubmissionRequest.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGmailId() {
        return this.gmailId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCustomerId() {
        return this.customerId;
    }

    public final LoginSubmissionRequest copy(String deviceId, String gmailId, String customerId) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(gmailId, "gmailId");
        Intrinsics.checkNotNullParameter(customerId, "customerId");
        return new LoginSubmissionRequest(deviceId, gmailId, customerId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoginSubmissionRequest)) {
            return false;
        }
        LoginSubmissionRequest loginSubmissionRequest = (LoginSubmissionRequest) other;
        return Intrinsics.areEqual(this.deviceId, loginSubmissionRequest.deviceId) && Intrinsics.areEqual(this.gmailId, loginSubmissionRequest.gmailId) && Intrinsics.areEqual(this.customerId, loginSubmissionRequest.customerId);
    }

    public int hashCode() {
        return (((this.deviceId.hashCode() * 31) + this.gmailId.hashCode()) * 31) + this.customerId.hashCode();
    }

    public String toString() {
        return "LoginSubmissionRequest(deviceId=" + this.deviceId + ", gmailId=" + this.gmailId + ", customerId=" + this.customerId + ")";
    }

    public LoginSubmissionRequest(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "deviceId");
        Intrinsics.checkNotNullParameter(str2, "gmailId");
        Intrinsics.checkNotNullParameter(str3, "customerId");
        this.deviceId = str;
        this.gmailId = str2;
        this.customerId = str3;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getGmailId() {
        return this.gmailId;
    }

    public final String getCustomerId() {
        return this.customerId;
    }
}
