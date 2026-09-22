package com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LanguageEnum.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0015\u001a\u00020\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0017"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "", RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE, "", "displayText", "speakText", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLanguageCode", "()Ljava/lang/String;", "getDisplayText", "getSpeakText", "ENGLISH", "TAMIL", "HINDI", "TELUGU", "KANNADA", "MALAYALAM", "GUJARATI", "MARATHI", "PUNJABI", "getLocale", "Ljava/util/Locale;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum LanguageEnum {
    ENGLISH("en", "English", "Speak in English"),
    TAMIL("ta-IN", "தமிழ்", "தமிழில் பேசவும்"),
    HINDI("hi-IN", "हिंदी", "हिंदी में बोलें"),
    TELUGU("te-IN", "తెలుగు", "తెలుగులో మాట్లాడండి"),
    KANNADA("kn-IN", "ಕನ್ನಡ", "ಕನ್ನಡದಲ್ಲಿ ಮಾತನಾಡಿ"),
    MALAYALAM("ml-IN", "മലയാളം", "മലയാളത്തിൽ സംസാരിക്കുക"),
    GUJARATI("gu-IN", "ગુજરાતી", "ગુજરાતીમાં બોલો"),
    MARATHI("mr-IN", "मराठी", "मराठीत बोला"),
    PUNJABI("pa-IN", "ਪੰਜਾਬੀ", "ਪੰਜਾਬੀ ਵਿੱਚ ਬੋਲੋ");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String displayText;
    private final String languageCode;
    private final String speakText;

    public static EnumEntries<LanguageEnum> getEntries() {
        return $ENTRIES;
    }

    LanguageEnum(String str, String str2, String str3) {
        this.languageCode = str;
        this.displayText = str2;
        this.speakText = str3;
    }

    public final String getLanguageCode() {
        return this.languageCode;
    }

    public final String getDisplayText() {
        return this.displayText;
    }

    public final String getSpeakText() {
        return this.speakText;
    }

    public final Locale getLocale() {
        List listSplit$default = StringsKt.split$default(this.languageCode, new String[]{"-"}, false, 0, 6, (Object) null);
        if (Intrinsics.areEqual(this.languageCode, "en")) {
            return new Locale("en", "IN");
        }
        return new Locale((String) listSplit$default.get(0), (String) listSplit$default.get(1));
    }
}
