package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u0010\n\u001a\u00020\u0004J\u001b\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003HÂ\u0003J%\u0010\u0010\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R \u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationUserSelections;", "", "selections", "", "", "", "", "<init>", "(Ljava/util/Map;)V", "getOptionsForPage", "pageId", "toggleOption", "option", "getListForSubmission", "", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class NotificationUserSelections {
    public static final int $stable = 8;
    private final Map<Long, Set<String>> selections;

    /* JADX WARN: Illegal instructions before constructor call */
    public NotificationUserSelections() {
        Map map = null;
        this(map, 1, map);
    }

    private final Map<Long, Set<String>> component1() {
        return this.selections;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NotificationUserSelections copy$default(NotificationUserSelections notificationUserSelections, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = notificationUserSelections.selections;
        }
        return notificationUserSelections.copy(map);
    }

    public final NotificationUserSelections copy(Map<Long, ? extends Set<String>> selections) {
        Intrinsics.checkNotNullParameter(selections, "selections");
        return new NotificationUserSelections(selections);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof NotificationUserSelections) && Intrinsics.areEqual(this.selections, ((NotificationUserSelections) other).selections);
    }

    public int hashCode() {
        return this.selections.hashCode();
    }

    public String toString() {
        return "NotificationUserSelections(selections=" + this.selections + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NotificationUserSelections(Map<Long, ? extends Set<String>> map) {
        Intrinsics.checkNotNullParameter(map, "selections");
        this.selections = map;
    }

    public /* synthetic */ NotificationUserSelections(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Set<String> getOptionsForPage(long pageId) {
        Set<String> set = this.selections.get(Long.valueOf(pageId));
        return set == null ? SetsKt.emptySet() : set;
    }

    public final NotificationUserSelections toggleOption(long pageId, String option) {
        Set setPlus;
        Intrinsics.checkNotNullParameter(option, "option");
        Set<String> setEmptySet = this.selections.get(Long.valueOf(pageId));
        if (setEmptySet == null) {
            setEmptySet = SetsKt.emptySet();
        }
        if (setEmptySet.contains(option)) {
            setPlus = SetsKt.minus(setEmptySet, option);
        } else {
            setPlus = SetsKt.plus(setEmptySet, option);
        }
        return copy(MapsKt.plus(this.selections, TuplesKt.to(Long.valueOf(pageId), setPlus)));
    }

    public final List<String> getListForSubmission(long pageId) {
        Set<String> setEmptySet = this.selections.get(Long.valueOf(pageId));
        if (setEmptySet == null) {
            setEmptySet = SetsKt.emptySet();
        }
        return CollectionsKt.toList(setEmptySet);
    }
}
