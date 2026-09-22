package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CorrectionSuggestion.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/CorrectionSuggestion;", "", "id", "", "sentence", "", "language", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "<init>", "(ILjava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;)V", "getId", "()I", "getSentence", "()Ljava/lang/String;", "getLanguage", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CorrectionSuggestion {
    public static final int $stable = 0;
    private final int id;
    private final LanguageEnum language;
    private final String sentence;

    public static /* synthetic */ CorrectionSuggestion copy$default(CorrectionSuggestion correctionSuggestion, int i, String str, LanguageEnum languageEnum, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = correctionSuggestion.id;
        }
        if ((i2 & 2) != 0) {
            str = correctionSuggestion.sentence;
        }
        if ((i2 & 4) != 0) {
            languageEnum = correctionSuggestion.language;
        }
        return correctionSuggestion.copy(i, str, languageEnum);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSentence() {
        return this.sentence;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final LanguageEnum getLanguage() {
        return this.language;
    }

    public final CorrectionSuggestion copy(int id, String sentence, LanguageEnum language) {
        Intrinsics.checkNotNullParameter(sentence, "sentence");
        Intrinsics.checkNotNullParameter(language, "language");
        return new CorrectionSuggestion(id, sentence, language);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CorrectionSuggestion)) {
            return false;
        }
        CorrectionSuggestion correctionSuggestion = (CorrectionSuggestion) other;
        return this.id == correctionSuggestion.id && Intrinsics.areEqual(this.sentence, correctionSuggestion.sentence) && this.language == correctionSuggestion.language;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.id) * 31) + this.sentence.hashCode()) * 31) + this.language.hashCode();
    }

    public String toString() {
        return "CorrectionSuggestion(id=" + this.id + ", sentence=" + this.sentence + ", language=" + this.language + ")";
    }

    public CorrectionSuggestion(int i, String str, LanguageEnum languageEnum) {
        Intrinsics.checkNotNullParameter(str, "sentence");
        Intrinsics.checkNotNullParameter(languageEnum, "language");
        this.id = i;
        this.sentence = str;
        this.language = languageEnum;
    }

    public final int getId() {
        return this.id;
    }

    public final String getSentence() {
        return this.sentence;
    }

    public final LanguageEnum getLanguage() {
        return this.language;
    }
}
