package com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.entities;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EnvironmentSoundHistoryEntity.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/data/local/entities/EnvironmentSoundHistoryEntity;", "", "id", "", Constants.ScionAnalytics.PARAM_LABEL, "", "confidence", "", "timestamp", "<init>", "(JLjava/lang/String;FJ)V", "getId", "()J", "getLabel", "()Ljava/lang/String;", "getConfidence", "()F", "getTimestamp", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class EnvironmentSoundHistoryEntity {
    public static final int $stable = 0;
    private final float confidence;
    private final long id;
    private final String label;
    private final long timestamp;

    public static /* synthetic */ EnvironmentSoundHistoryEntity copy$default(EnvironmentSoundHistoryEntity environmentSoundHistoryEntity, long j, String str, float f, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = environmentSoundHistoryEntity.id;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            str = environmentSoundHistoryEntity.label;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            f = environmentSoundHistoryEntity.confidence;
        }
        float f2 = f;
        if ((i & 8) != 0) {
            j2 = environmentSoundHistoryEntity.timestamp;
        }
        return environmentSoundHistoryEntity.copy(j3, str2, f2, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getConfidence() {
        return this.confidence;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final EnvironmentSoundHistoryEntity copy(long id, String label, float confidence, long timestamp) {
        Intrinsics.checkNotNullParameter(label, Constants.ScionAnalytics.PARAM_LABEL);
        return new EnvironmentSoundHistoryEntity(id, label, confidence, timestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnvironmentSoundHistoryEntity)) {
            return false;
        }
        EnvironmentSoundHistoryEntity environmentSoundHistoryEntity = (EnvironmentSoundHistoryEntity) other;
        return this.id == environmentSoundHistoryEntity.id && Intrinsics.areEqual(this.label, environmentSoundHistoryEntity.label) && Float.compare(this.confidence, environmentSoundHistoryEntity.confidence) == 0 && this.timestamp == environmentSoundHistoryEntity.timestamp;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.id) * 31) + this.label.hashCode()) * 31) + Float.hashCode(this.confidence)) * 31) + Long.hashCode(this.timestamp);
    }

    public String toString() {
        return "EnvironmentSoundHistoryEntity(id=" + this.id + ", label=" + this.label + ", confidence=" + this.confidence + ", timestamp=" + this.timestamp + ")";
    }

    public EnvironmentSoundHistoryEntity(long j, String str, float f, long j2) {
        Intrinsics.checkNotNullParameter(str, Constants.ScionAnalytics.PARAM_LABEL);
        this.id = j;
        this.label = str;
        this.confidence = f;
        this.timestamp = j2;
    }

    public /* synthetic */ EnvironmentSoundHistoryEntity(long j, String str, float f, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, str, f, j2);
    }

    public final long getId() {
        return this.id;
    }

    public final String getLabel() {
        return this.label;
    }

    public final float getConfidence() {
        return this.confidence;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }
}
