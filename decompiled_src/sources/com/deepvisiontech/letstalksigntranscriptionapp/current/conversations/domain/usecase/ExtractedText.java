package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExtractTextFromImageUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/ExtractedText;", "", "text", "", "textLanguage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "<init>", "(Ljava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;)V", "getText", "()Ljava/lang/String;", "getTextLanguage", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ExtractedText {
    public static final int $stable = 0;
    private final String text;
    private final LanguageEnum textLanguage;

    public static /* synthetic */ ExtractedText copy$default(ExtractedText extractedText, String str, LanguageEnum languageEnum, int i, Object obj) {
        if ((i & 1) != 0) {
            str = extractedText.text;
        }
        if ((i & 2) != 0) {
            languageEnum = extractedText.textLanguage;
        }
        return extractedText.copy(str, languageEnum);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final LanguageEnum getTextLanguage() {
        return this.textLanguage;
    }

    public final ExtractedText copy(String text, LanguageEnum textLanguage) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(textLanguage, "textLanguage");
        return new ExtractedText(text, textLanguage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExtractedText)) {
            return false;
        }
        ExtractedText extractedText = (ExtractedText) other;
        return Intrinsics.areEqual(this.text, extractedText.text) && this.textLanguage == extractedText.textLanguage;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.textLanguage.hashCode();
    }

    public String toString() {
        return "ExtractedText(text=" + this.text + ", textLanguage=" + this.textLanguage + ")";
    }

    public ExtractedText(String str, LanguageEnum languageEnum) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(languageEnum, "textLanguage");
        this.text = str;
        this.textLanguage = languageEnum;
    }

    public final String getText() {
        return this.text;
    }

    public final LanguageEnum getTextLanguage() {
        return this.textLanguage;
    }
}
