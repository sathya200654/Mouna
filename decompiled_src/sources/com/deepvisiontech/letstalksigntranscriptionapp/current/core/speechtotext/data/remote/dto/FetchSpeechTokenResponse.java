package com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.remote.dto;

import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ApiContract;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FetchSpeechTokenResponse.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J=\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/data/remote/dto/FetchSpeechTokenResponse;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ApiContract;", "status", "", "errorCode", "token", ResponseKeys.KEY_MESSAGE, "region", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getStatus", "()Ljava/lang/String;", "getErrorCode", "getToken", "getMessage", "getRegion", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FetchSpeechTokenResponse implements ApiContract {
    public static final int $stable = 0;

    @SerializedName("error_code")
    private final String errorCode;
    private final String message;
    private final String region;
    private final String status;
    private final String token;

    public static /* synthetic */ FetchSpeechTokenResponse copy$default(FetchSpeechTokenResponse fetchSpeechTokenResponse, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fetchSpeechTokenResponse.status;
        }
        if ((i & 2) != 0) {
            str2 = fetchSpeechTokenResponse.errorCode;
        }
        if ((i & 4) != 0) {
            str3 = fetchSpeechTokenResponse.token;
        }
        if ((i & 8) != 0) {
            str4 = fetchSpeechTokenResponse.message;
        }
        if ((i & 16) != 0) {
            str5 = fetchSpeechTokenResponse.region;
        }
        String str6 = str5;
        String str7 = str3;
        return fetchSpeechTokenResponse.copy(str, str2, str7, str4, str6);
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
    public final String getToken() {
        return this.token;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getRegion() {
        return this.region;
    }

    public final FetchSpeechTokenResponse copy(String status, String errorCode, String token, String message, String region) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(message, ResponseKeys.KEY_MESSAGE);
        Intrinsics.checkNotNullParameter(region, "region");
        return new FetchSpeechTokenResponse(status, errorCode, token, message, region);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FetchSpeechTokenResponse)) {
            return false;
        }
        FetchSpeechTokenResponse fetchSpeechTokenResponse = (FetchSpeechTokenResponse) other;
        return Intrinsics.areEqual(this.status, fetchSpeechTokenResponse.status) && Intrinsics.areEqual(this.errorCode, fetchSpeechTokenResponse.errorCode) && Intrinsics.areEqual(this.token, fetchSpeechTokenResponse.token) && Intrinsics.areEqual(this.message, fetchSpeechTokenResponse.message) && Intrinsics.areEqual(this.region, fetchSpeechTokenResponse.region);
    }

    public int hashCode() {
        int iHashCode = this.status.hashCode() * 31;
        String str = this.errorCode;
        return ((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.token.hashCode()) * 31) + this.message.hashCode()) * 31) + this.region.hashCode();
    }

    public String toString() {
        return "FetchSpeechTokenResponse(status=" + this.status + ", errorCode=" + this.errorCode + ", token=" + this.token + ", message=" + this.message + ", region=" + this.region + ")";
    }

    public FetchSpeechTokenResponse(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "status");
        Intrinsics.checkNotNullParameter(str3, "token");
        Intrinsics.checkNotNullParameter(str4, ResponseKeys.KEY_MESSAGE);
        Intrinsics.checkNotNullParameter(str5, "region");
        this.status = str;
        this.errorCode = str2;
        this.token = str3;
        this.message = str4;
        this.region = str5;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ApiContract
    public String getStatus() {
        return this.status;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ApiContract
    public String getErrorCode() {
        return this.errorCode;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getRegion() {
        return this.region;
    }
}
