package com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.remote.dto;

import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ApiContract;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoUploadSuccessResponse.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/data/remote/dto/VideoUploadSuccessResponse;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ApiContract;", ResponseKeys.KEY_MESSAGE, "", "status", "errorCode", "fileUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getStatus", "getErrorCode", "getFileUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class VideoUploadSuccessResponse implements ApiContract {
    public static final int $stable = 0;

    @SerializedName("error_code")
    private final String errorCode;

    @SerializedName("file_url")
    private final String fileUrl;

    @SerializedName(ResponseKeys.KEY_MESSAGE)
    private final String message;
    private final String status;

    public static /* synthetic */ VideoUploadSuccessResponse copy$default(VideoUploadSuccessResponse videoUploadSuccessResponse, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = videoUploadSuccessResponse.message;
        }
        if ((i & 2) != 0) {
            str2 = videoUploadSuccessResponse.status;
        }
        if ((i & 4) != 0) {
            str3 = videoUploadSuccessResponse.errorCode;
        }
        if ((i & 8) != 0) {
            str4 = videoUploadSuccessResponse.fileUrl;
        }
        return videoUploadSuccessResponse.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFileUrl() {
        return this.fileUrl;
    }

    public final VideoUploadSuccessResponse copy(String message, String status, String errorCode, String fileUrl) {
        Intrinsics.checkNotNullParameter(message, ResponseKeys.KEY_MESSAGE);
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(fileUrl, "fileUrl");
        return new VideoUploadSuccessResponse(message, status, errorCode, fileUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoUploadSuccessResponse)) {
            return false;
        }
        VideoUploadSuccessResponse videoUploadSuccessResponse = (VideoUploadSuccessResponse) other;
        return Intrinsics.areEqual(this.message, videoUploadSuccessResponse.message) && Intrinsics.areEqual(this.status, videoUploadSuccessResponse.status) && Intrinsics.areEqual(this.errorCode, videoUploadSuccessResponse.errorCode) && Intrinsics.areEqual(this.fileUrl, videoUploadSuccessResponse.fileUrl);
    }

    public int hashCode() {
        int iHashCode = ((this.message.hashCode() * 31) + this.status.hashCode()) * 31;
        String str = this.errorCode;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.fileUrl.hashCode();
    }

    public String toString() {
        return "VideoUploadSuccessResponse(message=" + this.message + ", status=" + this.status + ", errorCode=" + this.errorCode + ", fileUrl=" + this.fileUrl + ")";
    }

    public VideoUploadSuccessResponse(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, ResponseKeys.KEY_MESSAGE);
        Intrinsics.checkNotNullParameter(str2, "status");
        Intrinsics.checkNotNullParameter(str4, "fileUrl");
        this.message = str;
        this.status = str2;
        this.errorCode = str3;
        this.fileUrl = str4;
    }

    public final String getMessage() {
        return this.message;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ApiContract
    public String getStatus() {
        return this.status;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ApiContract
    public String getErrorCode() {
        return this.errorCode;
    }

    public final String getFileUrl() {
        return this.fileUrl;
    }
}
