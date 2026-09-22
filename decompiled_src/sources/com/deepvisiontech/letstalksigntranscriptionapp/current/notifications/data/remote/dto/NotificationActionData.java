package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.remote.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationActionData.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J/\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/remote/dto/NotificationActionData;", "", "response", "", "optionList", "", "userMailId", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getResponse", "()Ljava/lang/String;", "getOptionList", "()Ljava/util/List;", "getUserMailId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class NotificationActionData {
    public static final int $stable = 8;

    @SerializedName("optionList")
    private final List<String> optionList;

    @SerializedName("response")
    private final String response;

    @SerializedName("userMailId")
    private final String userMailId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NotificationActionData copy$default(NotificationActionData notificationActionData, String str, List list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = notificationActionData.response;
        }
        if ((i & 2) != 0) {
            list = notificationActionData.optionList;
        }
        if ((i & 4) != 0) {
            str2 = notificationActionData.userMailId;
        }
        return notificationActionData.copy(str, list, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getResponse() {
        return this.response;
    }

    public final List<String> component2() {
        return this.optionList;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUserMailId() {
        return this.userMailId;
    }

    public final NotificationActionData copy(String response, List<String> optionList, String userMailId) {
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(userMailId, "userMailId");
        return new NotificationActionData(response, optionList, userMailId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationActionData)) {
            return false;
        }
        NotificationActionData notificationActionData = (NotificationActionData) other;
        return Intrinsics.areEqual(this.response, notificationActionData.response) && Intrinsics.areEqual(this.optionList, notificationActionData.optionList) && Intrinsics.areEqual(this.userMailId, notificationActionData.userMailId);
    }

    public int hashCode() {
        int iHashCode = this.response.hashCode() * 31;
        List<String> list = this.optionList;
        return ((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + this.userMailId.hashCode();
    }

    public String toString() {
        return "NotificationActionData(response=" + this.response + ", optionList=" + this.optionList + ", userMailId=" + this.userMailId + ")";
    }

    public NotificationActionData(String str, List<String> list, String str2) {
        Intrinsics.checkNotNullParameter(str, "response");
        Intrinsics.checkNotNullParameter(str2, "userMailId");
        this.response = str;
        this.optionList = list;
        this.userMailId = str2;
    }

    public /* synthetic */ NotificationActionData(String str, List list, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : list, str2);
    }

    public final String getResponse() {
        return this.response;
    }

    public final List<String> getOptionList() {
        return this.optionList;
    }

    public final String getUserMailId() {
        return this.userMailId;
    }
}
