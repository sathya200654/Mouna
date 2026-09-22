package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.ocr;

import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ApiContract;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OcrResponseDto.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/ocr/OcrResponseDto;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ApiContract;", "status", "", "errorCode", ResponseKeys.KEY_MESSAGE, Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/ocr/OcrDataDto;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/ocr/OcrDataDto;)V", "getStatus", "()Ljava/lang/String;", "getErrorCode", "getMessage", "getData", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/ocr/OcrDataDto;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class OcrResponseDto implements ApiContract {
    public static final int $stable = 0;
    private final OcrDataDto data;

    @SerializedName("error_code")
    private final String errorCode;
    private final String message;
    private final String status;

    public static /* synthetic */ OcrResponseDto copy$default(OcrResponseDto ocrResponseDto, String str, String str2, String str3, OcrDataDto ocrDataDto, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ocrResponseDto.status;
        }
        if ((i & 2) != 0) {
            str2 = ocrResponseDto.errorCode;
        }
        if ((i & 4) != 0) {
            str3 = ocrResponseDto.message;
        }
        if ((i & 8) != 0) {
            ocrDataDto = ocrResponseDto.data;
        }
        return ocrResponseDto.copy(str, str2, str3, ocrDataDto);
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
    public final OcrDataDto getData() {
        return this.data;
    }

    public final OcrResponseDto copy(String status, String errorCode, String message, OcrDataDto data) {
        Intrinsics.checkNotNullParameter(status, "status");
        return new OcrResponseDto(status, errorCode, message, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OcrResponseDto)) {
            return false;
        }
        OcrResponseDto ocrResponseDto = (OcrResponseDto) other;
        return Intrinsics.areEqual(this.status, ocrResponseDto.status) && Intrinsics.areEqual(this.errorCode, ocrResponseDto.errorCode) && Intrinsics.areEqual(this.message, ocrResponseDto.message) && Intrinsics.areEqual(this.data, ocrResponseDto.data);
    }

    public int hashCode() {
        int iHashCode = this.status.hashCode() * 31;
        String str = this.errorCode;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.message;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        OcrDataDto ocrDataDto = this.data;
        return iHashCode3 + (ocrDataDto != null ? ocrDataDto.hashCode() : 0);
    }

    public String toString() {
        return "OcrResponseDto(status=" + this.status + ", errorCode=" + this.errorCode + ", message=" + this.message + ", data=" + this.data + ")";
    }

    public OcrResponseDto(String str, String str2, String str3, OcrDataDto ocrDataDto) {
        Intrinsics.checkNotNullParameter(str, "status");
        this.status = str;
        this.errorCode = str2;
        this.message = str3;
        this.data = ocrDataDto;
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

    public final OcrDataDto getData() {
        return this.data;
    }
}
