package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model;

import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: NotificationResponseType.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationResponseType;", "", "displayText", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDisplayText", "()Ljava/lang/String;", "NONE", "ACCEPT", "DECLINE", "SUBMIT_LIST", "REDIRECT_LINK", "DISMISS", "SKIP", "MARK_AS_READ", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum NotificationResponseType {
    NONE("None"),
    ACCEPT(HttpHeaders.ACCEPT),
    DECLINE("Decline"),
    SUBMIT_LIST("Submit"),
    REDIRECT_LINK("Redirect"),
    DISMISS("Dismiss"),
    SKIP("Skip"),
    MARK_AS_READ("Mark As Read");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String displayText;

    public static EnumEntries<NotificationResponseType> getEntries() {
        return $ENTRIES;
    }

    NotificationResponseType(String str) {
        this.displayText = str;
    }

    public final String getDisplayText() {
        return this.displayText;
    }
}
