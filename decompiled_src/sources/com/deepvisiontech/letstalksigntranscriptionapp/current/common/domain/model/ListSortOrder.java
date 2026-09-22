package com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: ListSortOrder.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/ListSortOrder;", "", "<init>", "(Ljava/lang/String;I)V", "BY_TIME_ASC", "BY_TIME_DESC", "BY_NAME_ASC", "BY_NAME_DESC", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum ListSortOrder {
    BY_TIME_ASC,
    BY_TIME_DESC,
    BY_NAME_ASC,
    BY_NAME_DESC;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<ListSortOrder> getEntries() {
        return $ENTRIES;
    }
}
