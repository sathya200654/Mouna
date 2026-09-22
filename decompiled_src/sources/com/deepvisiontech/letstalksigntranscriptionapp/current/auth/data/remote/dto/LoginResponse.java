package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.remote.dto;

import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ApiContract;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoginResponse.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/data/remote/dto/LoginResponse;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ApiContract;", "status", "", "success", "", ResponseKeys.KEY_MESSAGE, "token", "errorCode", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getStatus", "()Ljava/lang/String;", "getSuccess", "()Z", "getMessage", "getToken", "getErrorCode", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class LoginResponse implements ApiContract {
    public static final int $stable = 0;

    @SerializedName("error_code")
    private final String errorCode;
    private final String message;
    private final String status;
    private final boolean success;
    private final String token;

    public static /* synthetic */ LoginResponse copy$default(LoginResponse loginResponse, String str, boolean z, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loginResponse.status;
        }
        if ((i & 2) != 0) {
            z = loginResponse.success;
        }
        if ((i & 4) != 0) {
            str2 = loginResponse.message;
        }
        if ((i & 8) != 0) {
            str3 = loginResponse.token;
        }
        if ((i & 16) != 0) {
            str4 = loginResponse.errorCode;
        }
        String str5 = str4;
        String str6 = str2;
        return loginResponse.copy(str, z, str6, str3, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    public final LoginResponse copy(String status, boolean success, String message, String token, String errorCode) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(message, ResponseKeys.KEY_MESSAGE);
        Intrinsics.checkNotNullParameter(token, "token");
        return new LoginResponse(status, success, message, token, errorCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoginResponse)) {
            return false;
        }
        LoginResponse loginResponse = (LoginResponse) other;
        return Intrinsics.areEqual(this.status, loginResponse.status) && this.success == loginResponse.success && Intrinsics.areEqual(this.message, loginResponse.message) && Intrinsics.areEqual(this.token, loginResponse.token) && Intrinsics.areEqual(this.errorCode, loginResponse.errorCode);
    }

    public int hashCode() {
        int iHashCode = ((((((this.status.hashCode() * 31) + Boolean.hashCode(this.success)) * 31) + this.message.hashCode()) * 31) + this.token.hashCode()) * 31;
        String str = this.errorCode;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "LoginResponse(status=" + this.status + ", success=" + this.success + ", message=" + this.message + ", token=" + this.token + ", errorCode=" + this.errorCode + ")";
    }

    public LoginResponse(String str, boolean z, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "status");
        Intrinsics.checkNotNullParameter(str2, ResponseKeys.KEY_MESSAGE);
        Intrinsics.checkNotNullParameter(str3, "token");
        this.status = str;
        this.success = z;
        this.message = str2;
        this.token = str3;
        this.errorCode = str4;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ApiContract
    public String getStatus() {
        return this.status;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getToken() {
        return this.token;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ApiContract
    public String getErrorCode() {
        return this.errorCode;
    }
}
