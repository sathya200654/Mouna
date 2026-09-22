package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.suggestion;

import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ApiContract;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CorrectionSuggestionResponse.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JM\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006 "}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/suggestion/CorrectionSuggestionResponse;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ApiContract;", "status", "", "errorCode", ResponseKeys.KEY_MESSAGE, "sentence1", "sentence2", "sentence3", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getStatus", "()Ljava/lang/String;", "getErrorCode", "getMessage", "getSentence1", "getSentence2", "getSentence3", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CorrectionSuggestionResponse implements ApiContract {
    public static final int $stable = 0;

    @SerializedName("error_code")
    private final String errorCode;
    private final String message;
    private final String sentence1;
    private final String sentence2;
    private final String sentence3;
    private final String status;

    public static /* synthetic */ CorrectionSuggestionResponse copy$default(CorrectionSuggestionResponse correctionSuggestionResponse, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = correctionSuggestionResponse.status;
        }
        if ((i & 2) != 0) {
            str2 = correctionSuggestionResponse.errorCode;
        }
        if ((i & 4) != 0) {
            str3 = correctionSuggestionResponse.message;
        }
        if ((i & 8) != 0) {
            str4 = correctionSuggestionResponse.sentence1;
        }
        if ((i & 16) != 0) {
            str5 = correctionSuggestionResponse.sentence2;
        }
        if ((i & 32) != 0) {
            str6 = correctionSuggestionResponse.sentence3;
        }
        String str7 = str5;
        String str8 = str6;
        return correctionSuggestionResponse.copy(str, str2, str3, str4, str7, str8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSentence1() {
        return this.sentence1;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSentence2() {
        return this.sentence2;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSentence3() {
        return this.sentence3;
    }

    public final CorrectionSuggestionResponse copy(String status, String errorCode, String message, String sentence1, String sentence2, String sentence3) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(message, ResponseKeys.KEY_MESSAGE);
        return new CorrectionSuggestionResponse(status, errorCode, message, sentence1, sentence2, sentence3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CorrectionSuggestionResponse)) {
            return false;
        }
        CorrectionSuggestionResponse correctionSuggestionResponse = (CorrectionSuggestionResponse) other;
        return Intrinsics.areEqual(this.status, correctionSuggestionResponse.status) && Intrinsics.areEqual(this.errorCode, correctionSuggestionResponse.errorCode) && Intrinsics.areEqual(this.message, correctionSuggestionResponse.message) && Intrinsics.areEqual(this.sentence1, correctionSuggestionResponse.sentence1) && Intrinsics.areEqual(this.sentence2, correctionSuggestionResponse.sentence2) && Intrinsics.areEqual(this.sentence3, correctionSuggestionResponse.sentence3);
    }

    public int hashCode() {
        int iHashCode = this.status.hashCode() * 31;
        String str = this.errorCode;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.message.hashCode()) * 31;
        String str2 = this.sentence1;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sentence2;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.sentence3;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "CorrectionSuggestionResponse(status=" + this.status + ", errorCode=" + this.errorCode + ", message=" + this.message + ", sentence1=" + this.sentence1 + ", sentence2=" + this.sentence2 + ", sentence3=" + this.sentence3 + ")";
    }

    public CorrectionSuggestionResponse(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "status");
        Intrinsics.checkNotNullParameter(str3, ResponseKeys.KEY_MESSAGE);
        this.status = str;
        this.errorCode = str2;
        this.message = str3;
        this.sentence1 = str4;
        this.sentence2 = str5;
        this.sentence3 = str6;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ApiContract
    public String getStatus() {
        return this.status;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ApiContract
    public String getErrorCode() {
        return this.errorCode;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getSentence1() {
        return this.sentence1;
    }

    public final String getSentence2() {
        return this.sentence2;
    }

    public final String getSentence3() {
        return this.sentence3;
    }
}
