package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.remote.dto;

import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ApiContract;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GeneratePracticeResponse.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012JR\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\bHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012¨\u0006#"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/data/remote/dto/GeneratePracticeResponse;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ApiContract;", "status", "", "errorCode", ResponseKeys.KEY_MESSAGE, "essay", "totalContentSize", "", "usedTokenSize", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getStatus", "()Ljava/lang/String;", "getErrorCode", "getMessage", "getEssay", "getTotalContentSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUsedTokenSize", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/data/remote/dto/GeneratePracticeResponse;", "equals", "", "other", "", "hashCode", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class GeneratePracticeResponse implements ApiContract {
    public static final int $stable = 0;

    @SerializedName("error_code")
    private final String errorCode;

    @SerializedName("essay")
    private final String essay;

    @SerializedName(ResponseKeys.KEY_MESSAGE)
    private final String message;

    @SerializedName("status")
    private final String status;

    @SerializedName("totalContentSize")
    private final Integer totalContentSize;

    @SerializedName("usedTokenSize")
    private final Integer usedTokenSize;

    public static /* synthetic */ GeneratePracticeResponse copy$default(GeneratePracticeResponse generatePracticeResponse, String str, String str2, String str3, String str4, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = generatePracticeResponse.status;
        }
        if ((i & 2) != 0) {
            str2 = generatePracticeResponse.errorCode;
        }
        if ((i & 4) != 0) {
            str3 = generatePracticeResponse.message;
        }
        if ((i & 8) != 0) {
            str4 = generatePracticeResponse.essay;
        }
        if ((i & 16) != 0) {
            num = generatePracticeResponse.totalContentSize;
        }
        if ((i & 32) != 0) {
            num2 = generatePracticeResponse.usedTokenSize;
        }
        Integer num3 = num;
        Integer num4 = num2;
        return generatePracticeResponse.copy(str, str2, str3, str4, num3, num4);
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
    public final String getEssay() {
        return this.essay;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getTotalContentSize() {
        return this.totalContentSize;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getUsedTokenSize() {
        return this.usedTokenSize;
    }

    public final GeneratePracticeResponse copy(String status, String errorCode, String message, String essay, Integer totalContentSize, Integer usedTokenSize) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(message, ResponseKeys.KEY_MESSAGE);
        return new GeneratePracticeResponse(status, errorCode, message, essay, totalContentSize, usedTokenSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GeneratePracticeResponse)) {
            return false;
        }
        GeneratePracticeResponse generatePracticeResponse = (GeneratePracticeResponse) other;
        return Intrinsics.areEqual(this.status, generatePracticeResponse.status) && Intrinsics.areEqual(this.errorCode, generatePracticeResponse.errorCode) && Intrinsics.areEqual(this.message, generatePracticeResponse.message) && Intrinsics.areEqual(this.essay, generatePracticeResponse.essay) && Intrinsics.areEqual(this.totalContentSize, generatePracticeResponse.totalContentSize) && Intrinsics.areEqual(this.usedTokenSize, generatePracticeResponse.usedTokenSize);
    }

    public int hashCode() {
        int iHashCode = this.status.hashCode() * 31;
        String str = this.errorCode;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.message.hashCode()) * 31;
        String str2 = this.essay;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.totalContentSize;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.usedTokenSize;
        return iHashCode4 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "GeneratePracticeResponse(status=" + this.status + ", errorCode=" + this.errorCode + ", message=" + this.message + ", essay=" + this.essay + ", totalContentSize=" + this.totalContentSize + ", usedTokenSize=" + this.usedTokenSize + ")";
    }

    public GeneratePracticeResponse(String str, String str2, String str3, String str4, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(str, "status");
        Intrinsics.checkNotNullParameter(str3, ResponseKeys.KEY_MESSAGE);
        this.status = str;
        this.errorCode = str2;
        this.message = str3;
        this.essay = str4;
        this.totalContentSize = num;
        this.usedTokenSize = num2;
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

    public final String getEssay() {
        return this.essay;
    }

    public final Integer getTotalContentSize() {
        return this.totalContentSize;
    }

    public final Integer getUsedTokenSize() {
        return this.usedTokenSize;
    }
}
