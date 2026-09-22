package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.remote.dto;

import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ApiContract;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PersonaSurveySubmissionResponse.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/data/remote/dto/PersonaSurveySubmissionResponse;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ApiContract;", "status", "", "errorCode", ResponseKeys.KEY_MESSAGE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getStatus", "()Ljava/lang/String;", "getErrorCode", "getMessage", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PersonaSurveySubmissionResponse implements ApiContract {
    public static final int $stable = 0;

    @SerializedName("error_code")
    private final String errorCode;

    @SerializedName(ResponseKeys.KEY_MESSAGE)
    private final String message;

    @SerializedName("status")
    private final String status;

    public static /* synthetic */ PersonaSurveySubmissionResponse copy$default(PersonaSurveySubmissionResponse personaSurveySubmissionResponse, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = personaSurveySubmissionResponse.status;
        }
        if ((i & 2) != 0) {
            str2 = personaSurveySubmissionResponse.errorCode;
        }
        if ((i & 4) != 0) {
            str3 = personaSurveySubmissionResponse.message;
        }
        return personaSurveySubmissionResponse.copy(str, str2, str3);
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

    public final PersonaSurveySubmissionResponse copy(String status, String errorCode, String message) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(message, ResponseKeys.KEY_MESSAGE);
        return new PersonaSurveySubmissionResponse(status, errorCode, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PersonaSurveySubmissionResponse)) {
            return false;
        }
        PersonaSurveySubmissionResponse personaSurveySubmissionResponse = (PersonaSurveySubmissionResponse) other;
        return Intrinsics.areEqual(this.status, personaSurveySubmissionResponse.status) && Intrinsics.areEqual(this.errorCode, personaSurveySubmissionResponse.errorCode) && Intrinsics.areEqual(this.message, personaSurveySubmissionResponse.message);
    }

    public int hashCode() {
        int iHashCode = this.status.hashCode() * 31;
        String str = this.errorCode;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.message.hashCode();
    }

    public String toString() {
        return "PersonaSurveySubmissionResponse(status=" + this.status + ", errorCode=" + this.errorCode + ", message=" + this.message + ")";
    }

    public PersonaSurveySubmissionResponse(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "status");
        Intrinsics.checkNotNullParameter(str3, ResponseKeys.KEY_MESSAGE);
        this.status = str;
        this.errorCode = str2;
        this.message = str3;
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
}
