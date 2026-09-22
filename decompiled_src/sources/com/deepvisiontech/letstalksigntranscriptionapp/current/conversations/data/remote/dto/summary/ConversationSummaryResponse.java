package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.summary;

import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ApiContract;
import com.google.firebase.messaging.Constants;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationSummaryResponse.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/summary/ConversationSummaryResponse;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ApiContract;", "status", "", "errorCode", ResponseKeys.KEY_MESSAGE, Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Lcom/google/gson/JsonElement;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonElement;)V", "getStatus", "()Ljava/lang/String;", "getErrorCode", "getMessage", "getData", "()Lcom/google/gson/JsonElement;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ConversationSummaryResponse implements ApiContract {
    public static final int $stable = 8;
    private final JsonElement data;

    @SerializedName("error_code")
    private final String errorCode;
    private final String message;
    private final String status;

    public static /* synthetic */ ConversationSummaryResponse copy$default(ConversationSummaryResponse conversationSummaryResponse, String str, String str2, String str3, JsonElement jsonElement, int i, Object obj) {
        if ((i & 1) != 0) {
            str = conversationSummaryResponse.status;
        }
        if ((i & 2) != 0) {
            str2 = conversationSummaryResponse.errorCode;
        }
        if ((i & 4) != 0) {
            str3 = conversationSummaryResponse.message;
        }
        if ((i & 8) != 0) {
            jsonElement = conversationSummaryResponse.data;
        }
        return conversationSummaryResponse.copy(str, str2, str3, jsonElement);
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
    public final JsonElement getData() {
        return this.data;
    }

    public final ConversationSummaryResponse copy(String status, String errorCode, String message, JsonElement data) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(message, ResponseKeys.KEY_MESSAGE);
        Intrinsics.checkNotNullParameter(data, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        return new ConversationSummaryResponse(status, errorCode, message, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationSummaryResponse)) {
            return false;
        }
        ConversationSummaryResponse conversationSummaryResponse = (ConversationSummaryResponse) other;
        return Intrinsics.areEqual(this.status, conversationSummaryResponse.status) && Intrinsics.areEqual(this.errorCode, conversationSummaryResponse.errorCode) && Intrinsics.areEqual(this.message, conversationSummaryResponse.message) && Intrinsics.areEqual(this.data, conversationSummaryResponse.data);
    }

    public int hashCode() {
        int iHashCode = this.status.hashCode() * 31;
        String str = this.errorCode;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.message.hashCode()) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "ConversationSummaryResponse(status=" + this.status + ", errorCode=" + this.errorCode + ", message=" + this.message + ", data=" + this.data + ")";
    }

    public ConversationSummaryResponse(String str, String str2, String str3, JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(str, "status");
        Intrinsics.checkNotNullParameter(str3, ResponseKeys.KEY_MESSAGE);
        Intrinsics.checkNotNullParameter(jsonElement, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        this.status = str;
        this.errorCode = str2;
        this.message = str3;
        this.data = jsonElement;
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

    public final JsonElement getData() {
        return this.data;
    }
}
