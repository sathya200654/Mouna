package com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: InterpretationMode.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationMode;", "", "webViewKey", "", "displayString", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getWebViewKey", "()Ljava/lang/String;", "getDisplayString", "QUICK", "NORMAL", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum InterpretationMode {
    QUICK("quick", "Quick"),
    NORMAL("normal", "Normal");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String displayString;
    private final String webViewKey;

    public static EnumEntries<InterpretationMode> getEntries() {
        return $ENTRIES;
    }

    InterpretationMode(String str, String str2) {
        this.webViewKey = str;
        this.displayString = str2;
    }

    public final String getDisplayString() {
        return this.displayString;
    }

    public final String getWebViewKey() {
        return this.webViewKey;
    }
}
