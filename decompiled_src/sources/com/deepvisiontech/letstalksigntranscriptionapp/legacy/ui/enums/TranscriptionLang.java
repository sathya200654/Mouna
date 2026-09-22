package com.deepvisiontech.letstalksigntranscriptionapp.legacy.ui.enums;

import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TranscriptionLang.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0013"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/legacy/ui/enums/TranscriptionLang;", "", "lang", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getLang", "()Ljava/lang/String;", "English", "Tamil", "Hindi", "Telugu", "Kannada", "Malayalam", "Gujarati", "Marathi", "Punjabi", "getLocale", "Ljava/util/Locale;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum TranscriptionLang {
    English("en"),
    Tamil("ta-IN"),
    Hindi("hi-IN"),
    Telugu("te-IN"),
    Kannada("kn-IN"),
    Malayalam("ml-IN"),
    Gujarati("gu-IN"),
    Marathi("mr-IN"),
    Punjabi("pa-IN");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String lang;

    public static EnumEntries<TranscriptionLang> getEntries() {
        return $ENTRIES;
    }

    TranscriptionLang(String str) {
        this.lang = str;
    }

    public final String getLang() {
        return this.lang;
    }

    public final Locale getLocale() {
        List listSplit$default = StringsKt.split$default(this.lang, new String[]{"-"}, false, 0, 6, (Object) null);
        if (Intrinsics.areEqual(this.lang, "en")) {
            return new Locale("en", "IN");
        }
        return new Locale((String) listSplit$default.get(0), (String) listSplit$default.get(1));
    }
}
