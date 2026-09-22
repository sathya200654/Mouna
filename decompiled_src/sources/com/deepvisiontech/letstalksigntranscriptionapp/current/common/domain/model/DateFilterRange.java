package com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DateFilterRange.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/DateFilterRange;", "", "startDate", "", "endDate", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;)V", "getStartDate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEndDate", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/DateFilterRange;", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DateFilterRange {
    public static final int $stable = 0;
    private final Long endDate;
    private final Long startDate;

    /* JADX WARN: Illegal instructions before constructor call */
    public DateFilterRange() {
        Long l = null;
        this(l, l, 3, l);
    }

    public static /* synthetic */ DateFilterRange copy$default(DateFilterRange dateFilterRange, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = dateFilterRange.startDate;
        }
        if ((i & 2) != 0) {
            l2 = dateFilterRange.endDate;
        }
        return dateFilterRange.copy(l, l2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getStartDate() {
        return this.startDate;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getEndDate() {
        return this.endDate;
    }

    public final DateFilterRange copy(Long startDate, Long endDate) {
        return new DateFilterRange(startDate, endDate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DateFilterRange)) {
            return false;
        }
        DateFilterRange dateFilterRange = (DateFilterRange) other;
        return Intrinsics.areEqual(this.startDate, dateFilterRange.startDate) && Intrinsics.areEqual(this.endDate, dateFilterRange.endDate);
    }

    public int hashCode() {
        Long l = this.startDate;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        Long l2 = this.endDate;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        return "DateFilterRange(startDate=" + this.startDate + ", endDate=" + this.endDate + ")";
    }

    public DateFilterRange(Long l, Long l2) {
        this.startDate = l;
        this.endDate = l2;
    }

    public /* synthetic */ DateFilterRange(Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2);
    }

    public final Long getStartDate() {
        return this.startDate;
    }

    public final Long getEndDate() {
        return this.endDate;
    }
}
