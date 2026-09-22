package com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.remote.dto.translatebhashini;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TranslateBhashiniRequest.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JO\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\""}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/remote/dto/translatebhashini/TranslateBhashiniRequest;", "", "customerId", "", "token", "deviceId", "gmailId", "text", "inputLang", "targetLang", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCustomerId", "()Ljava/lang/String;", "getToken", "getDeviceId", "getGmailId", "getText", "getInputLang", "getTargetLang", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TranslateBhashiniRequest {
    public static final int $stable = 0;

    @SerializedName("customer_id")
    private final String customerId;

    @SerializedName("device_id")
    private final String deviceId;

    @SerializedName("gmail_id")
    private final String gmailId;
    private final String inputLang;
    private final String targetLang;
    private final String text;
    private final String token;

    public static /* synthetic */ TranslateBhashiniRequest copy$default(TranslateBhashiniRequest translateBhashiniRequest, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = translateBhashiniRequest.customerId;
        }
        if ((i & 2) != 0) {
            str2 = translateBhashiniRequest.token;
        }
        if ((i & 4) != 0) {
            str3 = translateBhashiniRequest.deviceId;
        }
        if ((i & 8) != 0) {
            str4 = translateBhashiniRequest.gmailId;
        }
        if ((i & 16) != 0) {
            str5 = translateBhashiniRequest.text;
        }
        if ((i & 32) != 0) {
            str6 = translateBhashiniRequest.inputLang;
        }
        if ((i & 64) != 0) {
            str7 = translateBhashiniRequest.targetLang;
        }
        String str8 = str6;
        String str9 = str7;
        String str10 = str5;
        String str11 = str3;
        return translateBhashiniRequest.copy(str, str2, str11, str4, str10, str8, str9);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCustomerId() {
        return this.customerId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getGmailId() {
        return this.gmailId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getInputLang() {
        return this.inputLang;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTargetLang() {
        return this.targetLang;
    }

    public final TranslateBhashiniRequest copy(String customerId, String token, String deviceId, String gmailId, String text, String inputLang, String targetLang) {
        Intrinsics.checkNotNullParameter(customerId, "customerId");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(gmailId, "gmailId");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(inputLang, "inputLang");
        Intrinsics.checkNotNullParameter(targetLang, "targetLang");
        return new TranslateBhashiniRequest(customerId, token, deviceId, gmailId, text, inputLang, targetLang);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TranslateBhashiniRequest)) {
            return false;
        }
        TranslateBhashiniRequest translateBhashiniRequest = (TranslateBhashiniRequest) other;
        return Intrinsics.areEqual(this.customerId, translateBhashiniRequest.customerId) && Intrinsics.areEqual(this.token, translateBhashiniRequest.token) && Intrinsics.areEqual(this.deviceId, translateBhashiniRequest.deviceId) && Intrinsics.areEqual(this.gmailId, translateBhashiniRequest.gmailId) && Intrinsics.areEqual(this.text, translateBhashiniRequest.text) && Intrinsics.areEqual(this.inputLang, translateBhashiniRequest.inputLang) && Intrinsics.areEqual(this.targetLang, translateBhashiniRequest.targetLang);
    }

    public int hashCode() {
        return (((((((((((this.customerId.hashCode() * 31) + this.token.hashCode()) * 31) + this.deviceId.hashCode()) * 31) + this.gmailId.hashCode()) * 31) + this.text.hashCode()) * 31) + this.inputLang.hashCode()) * 31) + this.targetLang.hashCode();
    }

    public String toString() {
        return "TranslateBhashiniRequest(customerId=" + this.customerId + ", token=" + this.token + ", deviceId=" + this.deviceId + ", gmailId=" + this.gmailId + ", text=" + this.text + ", inputLang=" + this.inputLang + ", targetLang=" + this.targetLang + ")";
    }

    public TranslateBhashiniRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, "customerId");
        Intrinsics.checkNotNullParameter(str2, "token");
        Intrinsics.checkNotNullParameter(str3, "deviceId");
        Intrinsics.checkNotNullParameter(str4, "gmailId");
        Intrinsics.checkNotNullParameter(str5, "text");
        Intrinsics.checkNotNullParameter(str6, "inputLang");
        Intrinsics.checkNotNullParameter(str7, "targetLang");
        this.customerId = str;
        this.token = str2;
        this.deviceId = str3;
        this.gmailId = str4;
        this.text = str5;
        this.inputLang = str6;
        this.targetLang = str7;
    }

    public final String getCustomerId() {
        return this.customerId;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getGmailId() {
        return this.gmailId;
    }

    public final String getText() {
        return this.text;
    }

    public final String getInputLang() {
        return this.inputLang;
    }

    public final String getTargetLang() {
        return this.targetLang;
    }
}
