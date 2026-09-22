package com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.utils;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Regex;

/* JADX INFO: compiled from: LangaugeUtils.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\n"}, d2 = {"isTextInLanguage", "", "text", "", "lang", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "dynamicThreshold", "", "length", "", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class LangaugeUtilsKt {

    /* JADX INFO: compiled from: LangaugeUtils.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LanguageEnum.values().length];
            try {
                iArr[LanguageEnum.ENGLISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LanguageEnum.TAMIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LanguageEnum.HINDI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LanguageEnum.MARATHI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LanguageEnum.TELUGU.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[LanguageEnum.KANNADA.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[LanguageEnum.MALAYALAM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[LanguageEnum.GUJARATI.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[LanguageEnum.PUNJABI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final double dynamicThreshold(int i) {
        if (i <= 5) {
            return 1.0d;
        }
        if (i <= 10) {
            return 0.95d;
        }
        if (i <= 25) {
            return 0.9d;
        }
        return i <= 50 ? 0.85d : 0.8d;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final boolean isTextInLanguage(String str, LanguageEnum languageEnum) throws NoWhenBranchMatchedException {
        String str2;
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(languageEnum, "lang");
        switch (WhenMappings.$EnumSwitchMapping$0[languageEnum.ordinal()]) {
            case 1:
                str2 = "A-Za-z";
                break;
            case 2:
                str2 = "\\u0B80-\\u0BFF";
                break;
            case 3:
            case 4:
                str2 = "\\u0900-\\u097F";
                break;
            case 5:
                str2 = "\\u0C00-\\u0C7F";
                break;
            case 6:
                str2 = "\\u0C80-\\u0CFF";
                break;
            case 7:
                str2 = "\\u0D00-\\u0D7F";
                break;
            case 8:
                str2 = "\\u0A80-\\u0AFF";
                break;
            case 9:
                str2 = "\\u0A00-\\u0A7F";
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        Regex regex = new Regex("[" + str2 + "\\p{N}]");
        Regex regex2 = new Regex("[\\p{P}\\p{S}]");
        int length = str.length();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if (!CharsKt.isWhitespace(cCharAt)) {
                String strValueOf = String.valueOf(cCharAt);
                if (!regex2.matches(strValueOf)) {
                    i++;
                    if (regex.matches(strValueOf)) {
                        i2++;
                    }
                }
            }
        }
        return i != 0 && ((double) i2) / ((double) i) >= dynamicThreshold(str.length());
    }
}
