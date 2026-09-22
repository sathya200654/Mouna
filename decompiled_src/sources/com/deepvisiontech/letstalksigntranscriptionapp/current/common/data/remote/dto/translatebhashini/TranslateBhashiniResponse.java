package com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.remote.dto.translatebhashini;

import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ApiContract;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TranslateBhashiniResponse.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/remote/dto/translatebhashini/TranslateBhashiniResponse;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ApiContract;", "status", "", "errorCode", ResponseKeys.KEY_MESSAGE, Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getStatus", "()Ljava/lang/String;", "getErrorCode", "getMessage", "getData", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TranslateBhashiniResponse implements ApiContract {
    public static final int $stable = 0;

    @SerializedName(Constants.ScionAnalytics.MessageType.DATA_MESSAGE)
    private final String data;

    @SerializedName("error_code")
    private final String errorCode;

    @SerializedName(ResponseKeys.KEY_MESSAGE)
    private final String message;

    @SerializedName("status")
    private final String status;

    public static /* synthetic */ TranslateBhashiniResponse copy$default(TranslateBhashiniResponse translateBhashiniResponse, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = translateBhashiniResponse.status;
        }
        if ((i & 2) != 0) {
            str2 = translateBhashiniResponse.errorCode;
        }
        if ((i & 4) != 0) {
            str3 = translateBhashiniResponse.message;
        }
        if ((i & 8) != 0) {
            str4 = translateBhashiniResponse.data;
        }
        return translateBhashiniResponse.copy(str, str2, str3, str4);
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
    public final String getData() {
        return this.data;
    }

    public final TranslateBhashiniResponse copy(String status, String errorCode, String message, String data) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(message, ResponseKeys.KEY_MESSAGE);
        Intrinsics.checkNotNullParameter(data, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        return new TranslateBhashiniResponse(status, errorCode, message, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TranslateBhashiniResponse)) {
            return false;
        }
        TranslateBhashiniResponse translateBhashiniResponse = (TranslateBhashiniResponse) other;
        return Intrinsics.areEqual(this.status, translateBhashiniResponse.status) && Intrinsics.areEqual(this.errorCode, translateBhashiniResponse.errorCode) && Intrinsics.areEqual(this.message, translateBhashiniResponse.message) && Intrinsics.areEqual(this.data, translateBhashiniResponse.data);
    }

    public int hashCode() {
        int iHashCode = this.status.hashCode() * 31;
        String str = this.errorCode;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.message.hashCode()) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "TranslateBhashiniResponse(status=" + this.status + ", errorCode=" + this.errorCode + ", message=" + this.message + ", data=" + this.data + ")";
    }

    public TranslateBhashiniResponse(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "status");
        Intrinsics.checkNotNullParameter(str3, ResponseKeys.KEY_MESSAGE);
        Intrinsics.checkNotNullParameter(str4, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        this.status = str;
        this.errorCode = str2;
        this.message = str3;
        this.data = str4;
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

    public final String getData() {
        return this.data;
    }
}
