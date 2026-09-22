package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.summary;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationSummaryRequest.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/summary/ConversationSummaryRequest;", "", "deviceId", "", "gmailId", "customerId", "token", "content", "gWordCount", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getGmailId", "getCustomerId", "getToken", "getContent", "getGWordCount", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ConversationSummaryRequest {
    public static final int $stable = 0;
    private final String content;

    @SerializedName("customer_id")
    private final String customerId;

    @SerializedName("device_id")
    private final String deviceId;
    private final String gWordCount;

    @SerializedName("gmail_id")
    private final String gmailId;
    private final String token;

    public static /* synthetic */ ConversationSummaryRequest copy$default(ConversationSummaryRequest conversationSummaryRequest, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = conversationSummaryRequest.deviceId;
        }
        if ((i & 2) != 0) {
            str2 = conversationSummaryRequest.gmailId;
        }
        if ((i & 4) != 0) {
            str3 = conversationSummaryRequest.customerId;
        }
        if ((i & 8) != 0) {
            str4 = conversationSummaryRequest.token;
        }
        if ((i & 16) != 0) {
            str5 = conversationSummaryRequest.content;
        }
        if ((i & 32) != 0) {
            str6 = conversationSummaryRequest.gWordCount;
        }
        String str7 = str5;
        String str8 = str6;
        return conversationSummaryRequest.copy(str, str2, str3, str4, str7, str8);
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
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getGWordCount() {
        return this.gWordCount;
    }

    public final ConversationSummaryRequest copy(String deviceId, String gmailId, String customerId, String token, String content, String gWordCount) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(gmailId, "gmailId");
        Intrinsics.checkNotNullParameter(customerId, "customerId");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(gWordCount, "gWordCount");
        return new ConversationSummaryRequest(deviceId, gmailId, customerId, token, content, gWordCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationSummaryRequest)) {
            return false;
        }
        ConversationSummaryRequest conversationSummaryRequest = (ConversationSummaryRequest) other;
        return Intrinsics.areEqual(this.deviceId, conversationSummaryRequest.deviceId) && Intrinsics.areEqual(this.gmailId, conversationSummaryRequest.gmailId) && Intrinsics.areEqual(this.customerId, conversationSummaryRequest.customerId) && Intrinsics.areEqual(this.token, conversationSummaryRequest.token) && Intrinsics.areEqual(this.content, conversationSummaryRequest.content) && Intrinsics.areEqual(this.gWordCount, conversationSummaryRequest.gWordCount);
    }

    public int hashCode() {
        return (((((((((this.deviceId.hashCode() * 31) + this.gmailId.hashCode()) * 31) + this.customerId.hashCode()) * 31) + this.token.hashCode()) * 31) + this.content.hashCode()) * 31) + this.gWordCount.hashCode();
    }

    public String toString() {
        return "ConversationSummaryRequest(deviceId=" + this.deviceId + ", gmailId=" + this.gmailId + ", customerId=" + this.customerId + ", token=" + this.token + ", content=" + this.content + ", gWordCount=" + this.gWordCount + ")";
    }

    public ConversationSummaryRequest(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "deviceId");
        Intrinsics.checkNotNullParameter(str2, "gmailId");
        Intrinsics.checkNotNullParameter(str3, "customerId");
        Intrinsics.checkNotNullParameter(str4, "token");
        Intrinsics.checkNotNullParameter(str5, "content");
        Intrinsics.checkNotNullParameter(str6, "gWordCount");
        this.deviceId = str;
        this.gmailId = str2;
        this.customerId = str3;
        this.token = str4;
        this.content = str5;
        this.gWordCount = str6;
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

    public final String getContent() {
        return this.content;
    }

    public /* synthetic */ ConversationSummaryRequest(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, (i & 32) != 0 ? "300" : str6);
    }

    public final String getGWordCount() {
        return this.gWordCount;
    }
}
