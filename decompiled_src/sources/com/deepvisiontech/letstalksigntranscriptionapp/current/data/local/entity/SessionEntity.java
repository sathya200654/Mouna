package com.deepvisiontech.letstalksigntranscriptionapp.current.data.local.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SessionEntity.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/data/local/entity/SessionEntity;", "", "sessionId", "", "sessionName", "summary", "summaryDateTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSessionId", "()Ljava/lang/String;", "getSessionName", "getSummary", "getSummaryDateTime", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SessionEntity {
    public static final int $stable = 0;
    private final String sessionId;
    private final String sessionName;
    private final String summary;
    private final String summaryDateTime;

    public static /* synthetic */ SessionEntity copy$default(SessionEntity sessionEntity, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sessionEntity.sessionId;
        }
        if ((i & 2) != 0) {
            str2 = sessionEntity.sessionName;
        }
        if ((i & 4) != 0) {
            str3 = sessionEntity.summary;
        }
        if ((i & 8) != 0) {
            str4 = sessionEntity.summaryDateTime;
        }
        return sessionEntity.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSessionName() {
        return this.sessionName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSummary() {
        return this.summary;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSummaryDateTime() {
        return this.summaryDateTime;
    }

    public final SessionEntity copy(String sessionId, String sessionName, String summary, String summaryDateTime) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(sessionName, "sessionName");
        return new SessionEntity(sessionId, sessionName, summary, summaryDateTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionEntity)) {
            return false;
        }
        SessionEntity sessionEntity = (SessionEntity) other;
        return Intrinsics.areEqual(this.sessionId, sessionEntity.sessionId) && Intrinsics.areEqual(this.sessionName, sessionEntity.sessionName) && Intrinsics.areEqual(this.summary, sessionEntity.summary) && Intrinsics.areEqual(this.summaryDateTime, sessionEntity.summaryDateTime);
    }

    public int hashCode() {
        int iHashCode = ((this.sessionId.hashCode() * 31) + this.sessionName.hashCode()) * 31;
        String str = this.summary;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.summaryDateTime;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "SessionEntity(sessionId=" + this.sessionId + ", sessionName=" + this.sessionName + ", summary=" + this.summary + ", summaryDateTime=" + this.summaryDateTime + ")";
    }

    public SessionEntity(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(str2, "sessionName");
        this.sessionId = str;
        this.sessionName = str2;
        this.summary = str3;
        this.summaryDateTime = str4;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getSessionName() {
        return this.sessionName;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getSummaryDateTime() {
        return this.summaryDateTime;
    }
}
