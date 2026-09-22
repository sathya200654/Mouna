package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.suggestion;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InputSuggestionRequest.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/suggestion/InputSuggestionRequest;", "", "deviceId", "", "gmailId", "customerId", "token", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getGmailId", "getCustomerId", "getToken", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class InputSuggestionRequest {
    public static final int $stable = 0;

    @SerializedName("customer_id")
    private final String customerId;

    @SerializedName("device_id")
    private final String deviceId;

    @SerializedName("gmail_id")
    private final String gmailId;
    private final String token;

    public static /* synthetic */ InputSuggestionRequest copy$default(InputSuggestionRequest inputSuggestionRequest, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inputSuggestionRequest.deviceId;
        }
        if ((i & 2) != 0) {
            str2 = inputSuggestionRequest.gmailId;
        }
        if ((i & 4) != 0) {
            str3 = inputSuggestionRequest.customerId;
        }
        if ((i & 8) != 0) {
            str4 = inputSuggestionRequest.token;
        }
        return inputSuggestionRequest.copy(str, str2, str3, str4);
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

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public final InputSuggestionRequest copy(String deviceId, String gmailId, String customerId, String token) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(gmailId, "gmailId");
        Intrinsics.checkNotNullParameter(customerId, "customerId");
        Intrinsics.checkNotNullParameter(token, "token");
        return new InputSuggestionRequest(deviceId, gmailId, customerId, token);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InputSuggestionRequest)) {
            return false;
        }
        InputSuggestionRequest inputSuggestionRequest = (InputSuggestionRequest) other;
        return Intrinsics.areEqual(this.deviceId, inputSuggestionRequest.deviceId) && Intrinsics.areEqual(this.gmailId, inputSuggestionRequest.gmailId) && Intrinsics.areEqual(this.customerId, inputSuggestionRequest.customerId) && Intrinsics.areEqual(this.token, inputSuggestionRequest.token);
    }

    public int hashCode() {
        return (((((this.deviceId.hashCode() * 31) + this.gmailId.hashCode()) * 31) + this.customerId.hashCode()) * 31) + this.token.hashCode();
    }

    public String toString() {
        return "InputSuggestionRequest(deviceId=" + this.deviceId + ", gmailId=" + this.gmailId + ", customerId=" + this.customerId + ", token=" + this.token + ")";
    }

    public InputSuggestionRequest(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "deviceId");
        Intrinsics.checkNotNullParameter(str2, "gmailId");
        Intrinsics.checkNotNullParameter(str3, "customerId");
        Intrinsics.checkNotNullParameter(str4, "token");
        this.deviceId = str;
        this.gmailId = str2;
        this.customerId = str3;
        this.token = str4;
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

    public final String getToken() {
        return this.token;
    }
}
