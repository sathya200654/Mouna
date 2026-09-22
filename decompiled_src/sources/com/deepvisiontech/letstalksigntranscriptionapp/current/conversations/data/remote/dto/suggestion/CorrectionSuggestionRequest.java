package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.suggestion;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CorrectionSuggestionRequest.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/suggestion/CorrectionSuggestionRequest;", "", "deviceId", "", "gmailId", "customerId", "token", "inputLang", "sentence", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getGmailId", "getCustomerId", "getToken", "getInputLang", "getSentence", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CorrectionSuggestionRequest {
    public static final int $stable = 0;

    @SerializedName("customer_id")
    private final String customerId;

    @SerializedName("device_id")
    private final String deviceId;

    @SerializedName("gmail_id")
    private final String gmailId;

    @SerializedName("input_lang")
    private final String inputLang;

    @SerializedName("sentence_to_correct")
    private final String sentence;
    private final String token;

    public static /* synthetic */ CorrectionSuggestionRequest copy$default(CorrectionSuggestionRequest correctionSuggestionRequest, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = correctionSuggestionRequest.deviceId;
        }
        if ((i & 2) != 0) {
            str2 = correctionSuggestionRequest.gmailId;
        }
        if ((i & 4) != 0) {
            str3 = correctionSuggestionRequest.customerId;
        }
        if ((i & 8) != 0) {
            str4 = correctionSuggestionRequest.token;
        }
        if ((i & 16) != 0) {
            str5 = correctionSuggestionRequest.inputLang;
        }
        if ((i & 32) != 0) {
            str6 = correctionSuggestionRequest.sentence;
        }
        String str7 = str5;
        String str8 = str6;
        return correctionSuggestionRequest.copy(str, str2, str3, str4, str7, str8);
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

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getInputLang() {
        return this.inputLang;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSentence() {
        return this.sentence;
    }

    public final CorrectionSuggestionRequest copy(String deviceId, String gmailId, String customerId, String token, String inputLang, String sentence) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(gmailId, "gmailId");
        Intrinsics.checkNotNullParameter(customerId, "customerId");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(inputLang, "inputLang");
        Intrinsics.checkNotNullParameter(sentence, "sentence");
        return new CorrectionSuggestionRequest(deviceId, gmailId, customerId, token, inputLang, sentence);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CorrectionSuggestionRequest)) {
            return false;
        }
        CorrectionSuggestionRequest correctionSuggestionRequest = (CorrectionSuggestionRequest) other;
        return Intrinsics.areEqual(this.deviceId, correctionSuggestionRequest.deviceId) && Intrinsics.areEqual(this.gmailId, correctionSuggestionRequest.gmailId) && Intrinsics.areEqual(this.customerId, correctionSuggestionRequest.customerId) && Intrinsics.areEqual(this.token, correctionSuggestionRequest.token) && Intrinsics.areEqual(this.inputLang, correctionSuggestionRequest.inputLang) && Intrinsics.areEqual(this.sentence, correctionSuggestionRequest.sentence);
    }

    public int hashCode() {
        return (((((((((this.deviceId.hashCode() * 31) + this.gmailId.hashCode()) * 31) + this.customerId.hashCode()) * 31) + this.token.hashCode()) * 31) + this.inputLang.hashCode()) * 31) + this.sentence.hashCode();
    }

    public String toString() {
        return "CorrectionSuggestionRequest(deviceId=" + this.deviceId + ", gmailId=" + this.gmailId + ", customerId=" + this.customerId + ", token=" + this.token + ", inputLang=" + this.inputLang + ", sentence=" + this.sentence + ")";
    }

    public CorrectionSuggestionRequest(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "deviceId");
        Intrinsics.checkNotNullParameter(str2, "gmailId");
        Intrinsics.checkNotNullParameter(str3, "customerId");
        Intrinsics.checkNotNullParameter(str4, "token");
        Intrinsics.checkNotNullParameter(str5, "inputLang");
        Intrinsics.checkNotNullParameter(str6, "sentence");
        this.deviceId = str;
        this.gmailId = str2;
        this.customerId = str3;
        this.token = str4;
        this.inputLang = str5;
        this.sentence = str6;
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

    public final String getInputLang() {
        return this.inputLang;
    }

    public final String getSentence() {
        return this.sentence;
    }
}
