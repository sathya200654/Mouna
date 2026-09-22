package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeComplexity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeDomain;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeType;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeWordCount;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignPracticeCreationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003J\t\u0010*\u001a\u00020\u000fHÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011HÆ\u0003Ji\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011HÆ\u0001J\u0013\u0010-\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00062"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeCreationUiState;", "", "isLoading", "", "isGenerating", "practiceName", "", "practiceTopic", "practiceComplexity", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeComplexity;", "wordCount", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeWordCount;", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeType;", "language", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "domains", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeDomain;", "<init>", "(ZZLjava/lang/String;Ljava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeComplexity;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeWordCount;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeType;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Ljava/util/List;)V", "()Z", "getPracticeName", "()Ljava/lang/String;", "getPracticeTopic", "getPracticeComplexity", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeComplexity;", "getWordCount", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeWordCount;", "getType", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeType;", "getLanguage", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "getDomains", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SignPracticeCreationUiState {
    public static final int $stable = 8;
    private final List<SignPracticeDomain> domains;
    private final boolean isGenerating;
    private final boolean isLoading;
    private final LanguageEnum language;
    private final SignPracticeComplexity practiceComplexity;
    private final String practiceName;
    private final String practiceTopic;
    private final SignPracticeType type;
    private final SignPracticeWordCount wordCount;

    public SignPracticeCreationUiState() {
        this(false, false, null, null, null, null, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SignPracticeCreationUiState copy$default(SignPracticeCreationUiState signPracticeCreationUiState, boolean z, boolean z2, String str, String str2, SignPracticeComplexity signPracticeComplexity, SignPracticeWordCount signPracticeWordCount, SignPracticeType signPracticeType, LanguageEnum languageEnum, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = signPracticeCreationUiState.isLoading;
        }
        if ((i & 2) != 0) {
            z2 = signPracticeCreationUiState.isGenerating;
        }
        if ((i & 4) != 0) {
            str = signPracticeCreationUiState.practiceName;
        }
        if ((i & 8) != 0) {
            str2 = signPracticeCreationUiState.practiceTopic;
        }
        if ((i & 16) != 0) {
            signPracticeComplexity = signPracticeCreationUiState.practiceComplexity;
        }
        if ((i & 32) != 0) {
            signPracticeWordCount = signPracticeCreationUiState.wordCount;
        }
        if ((i & 64) != 0) {
            signPracticeType = signPracticeCreationUiState.type;
        }
        if ((i & 128) != 0) {
            languageEnum = signPracticeCreationUiState.language;
        }
        if ((i & 256) != 0) {
            list = signPracticeCreationUiState.domains;
        }
        LanguageEnum languageEnum2 = languageEnum;
        List list2 = list;
        SignPracticeWordCount signPracticeWordCount2 = signPracticeWordCount;
        SignPracticeType signPracticeType2 = signPracticeType;
        SignPracticeComplexity signPracticeComplexity2 = signPracticeComplexity;
        String str3 = str;
        return signPracticeCreationUiState.copy(z, z2, str3, str2, signPracticeComplexity2, signPracticeWordCount2, signPracticeType2, languageEnum2, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsGenerating() {
        return this.isGenerating;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPracticeName() {
        return this.practiceName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPracticeTopic() {
        return this.practiceTopic;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final SignPracticeComplexity getPracticeComplexity() {
        return this.practiceComplexity;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final SignPracticeWordCount getWordCount() {
        return this.wordCount;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final SignPracticeType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final LanguageEnum getLanguage() {
        return this.language;
    }

    public final List<SignPracticeDomain> component9() {
        return this.domains;
    }

    public final SignPracticeCreationUiState copy(boolean isLoading, boolean isGenerating, String practiceName, String practiceTopic, SignPracticeComplexity practiceComplexity, SignPracticeWordCount wordCount, SignPracticeType type, LanguageEnum language, List<SignPracticeDomain> domains) {
        Intrinsics.checkNotNullParameter(practiceName, "practiceName");
        Intrinsics.checkNotNullParameter(practiceTopic, "practiceTopic");
        Intrinsics.checkNotNullParameter(practiceComplexity, "practiceComplexity");
        Intrinsics.checkNotNullParameter(wordCount, "wordCount");
        Intrinsics.checkNotNullParameter(type, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(domains, "domains");
        return new SignPracticeCreationUiState(isLoading, isGenerating, practiceName, practiceTopic, practiceComplexity, wordCount, type, language, domains);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignPracticeCreationUiState)) {
            return false;
        }
        SignPracticeCreationUiState signPracticeCreationUiState = (SignPracticeCreationUiState) other;
        return this.isLoading == signPracticeCreationUiState.isLoading && this.isGenerating == signPracticeCreationUiState.isGenerating && Intrinsics.areEqual(this.practiceName, signPracticeCreationUiState.practiceName) && Intrinsics.areEqual(this.practiceTopic, signPracticeCreationUiState.practiceTopic) && this.practiceComplexity == signPracticeCreationUiState.practiceComplexity && this.wordCount == signPracticeCreationUiState.wordCount && this.type == signPracticeCreationUiState.type && this.language == signPracticeCreationUiState.language && Intrinsics.areEqual(this.domains, signPracticeCreationUiState.domains);
    }

    public int hashCode() {
        return (((((((((((((((Boolean.hashCode(this.isLoading) * 31) + Boolean.hashCode(this.isGenerating)) * 31) + this.practiceName.hashCode()) * 31) + this.practiceTopic.hashCode()) * 31) + this.practiceComplexity.hashCode()) * 31) + this.wordCount.hashCode()) * 31) + this.type.hashCode()) * 31) + this.language.hashCode()) * 31) + this.domains.hashCode();
    }

    public String toString() {
        return "SignPracticeCreationUiState(isLoading=" + this.isLoading + ", isGenerating=" + this.isGenerating + ", practiceName=" + this.practiceName + ", practiceTopic=" + this.practiceTopic + ", practiceComplexity=" + this.practiceComplexity + ", wordCount=" + this.wordCount + ", type=" + this.type + ", language=" + this.language + ", domains=" + this.domains + ")";
    }

    public SignPracticeCreationUiState(boolean z, boolean z2, String str, String str2, SignPracticeComplexity signPracticeComplexity, SignPracticeWordCount signPracticeWordCount, SignPracticeType signPracticeType, LanguageEnum languageEnum, List<SignPracticeDomain> list) {
        Intrinsics.checkNotNullParameter(str, "practiceName");
        Intrinsics.checkNotNullParameter(str2, "practiceTopic");
        Intrinsics.checkNotNullParameter(signPracticeComplexity, "practiceComplexity");
        Intrinsics.checkNotNullParameter(signPracticeWordCount, "wordCount");
        Intrinsics.checkNotNullParameter(signPracticeType, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        Intrinsics.checkNotNullParameter(languageEnum, "language");
        Intrinsics.checkNotNullParameter(list, "domains");
        this.isLoading = z;
        this.isGenerating = z2;
        this.practiceName = str;
        this.practiceTopic = str2;
        this.practiceComplexity = signPracticeComplexity;
        this.wordCount = signPracticeWordCount;
        this.type = signPracticeType;
        this.language = languageEnum;
        this.domains = list;
    }

    public /* synthetic */ SignPracticeCreationUiState(boolean z, boolean z2, String str, String str2, SignPracticeComplexity signPracticeComplexity, SignPracticeWordCount signPracticeWordCount, SignPracticeType signPracticeType, LanguageEnum languageEnum, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? SignPracticeComplexity.MEDIUM : signPracticeComplexity, (i & 32) != 0 ? SignPracticeWordCount.MEDIUM : signPracticeWordCount, (i & 64) != 0 ? SignPracticeType.FORMAL : signPracticeType, (i & 128) != 0 ? LanguageEnum.ENGLISH : languageEnum, (i & 256) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final boolean isGenerating() {
        return this.isGenerating;
    }

    public final String getPracticeName() {
        return this.practiceName;
    }

    public final String getPracticeTopic() {
        return this.practiceTopic;
    }

    public final SignPracticeComplexity getPracticeComplexity() {
        return this.practiceComplexity;
    }

    public final SignPracticeWordCount getWordCount() {
        return this.wordCount;
    }

    public final SignPracticeType getType() {
        return this.type;
    }

    public final LanguageEnum getLanguage() {
        return this.language;
    }

    public final List<SignPracticeDomain> getDomains() {
        return this.domains;
    }
}
