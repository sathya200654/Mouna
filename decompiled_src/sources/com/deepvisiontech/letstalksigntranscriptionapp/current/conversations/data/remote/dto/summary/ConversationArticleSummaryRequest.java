package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.summary;

import com.azure.core.implementation.logging.LoggingKeys;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationArticleSummaryRequest.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/summary/ConversationArticleSummaryRequest;", "", "deviceId", "", "gmailId", "customerId", "token", LoggingKeys.URL_KEY, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getGmailId", "getCustomerId", "getToken", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ConversationArticleSummaryRequest {
    public static final int $stable = 0;

    @SerializedName("customer_id")
    private final String customerId;

    @SerializedName("device_id")
    private final String deviceId;

    @SerializedName("gmail_id")
    private final String gmailId;
    private final String token;
    private final String url;

    public static /* synthetic */ ConversationArticleSummaryRequest copy$default(ConversationArticleSummaryRequest conversationArticleSummaryRequest, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = conversationArticleSummaryRequest.deviceId;
        }
        if ((i & 2) != 0) {
            str2 = conversationArticleSummaryRequest.gmailId;
        }
        if ((i & 4) != 0) {
            str3 = conversationArticleSummaryRequest.customerId;
        }
        if ((i & 8) != 0) {
            str4 = conversationArticleSummaryRequest.token;
        }
        if ((i & 16) != 0) {
            str5 = conversationArticleSummaryRequest.url;
        }
        String str6 = str5;
        String str7 = str3;
        return conversationArticleSummaryRequest.copy(str, str2, str7, str4, str6);
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
    public final String getUrl() {
        return this.url;
    }

    public final ConversationArticleSummaryRequest copy(String deviceId, String gmailId, String customerId, String token, String url) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(gmailId, "gmailId");
        Intrinsics.checkNotNullParameter(customerId, "customerId");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(url, LoggingKeys.URL_KEY);
        return new ConversationArticleSummaryRequest(deviceId, gmailId, customerId, token, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationArticleSummaryRequest)) {
            return false;
        }
        ConversationArticleSummaryRequest conversationArticleSummaryRequest = (ConversationArticleSummaryRequest) other;
        return Intrinsics.areEqual(this.deviceId, conversationArticleSummaryRequest.deviceId) && Intrinsics.areEqual(this.gmailId, conversationArticleSummaryRequest.gmailId) && Intrinsics.areEqual(this.customerId, conversationArticleSummaryRequest.customerId) && Intrinsics.areEqual(this.token, conversationArticleSummaryRequest.token) && Intrinsics.areEqual(this.url, conversationArticleSummaryRequest.url);
    }

    public int hashCode() {
        return (((((((this.deviceId.hashCode() * 31) + this.gmailId.hashCode()) * 31) + this.customerId.hashCode()) * 31) + this.token.hashCode()) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "ConversationArticleSummaryRequest(deviceId=" + this.deviceId + ", gmailId=" + this.gmailId + ", customerId=" + this.customerId + ", token=" + this.token + ", url=" + this.url + ")";
    }

    public ConversationArticleSummaryRequest(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "deviceId");
        Intrinsics.checkNotNullParameter(str2, "gmailId");
        Intrinsics.checkNotNullParameter(str3, "customerId");
        Intrinsics.checkNotNullParameter(str4, "token");
        Intrinsics.checkNotNullParameter(str5, LoggingKeys.URL_KEY);
        this.deviceId = str;
        this.gmailId = str2;
        this.customerId = str3;
        this.token = str4;
        this.url = str5;
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

    public final String getUrl() {
        return this.url;
    }
}
