package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationSettingsViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\fHÆ\u0003JG\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsFlow;", "", "userLang", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "speakerLanguage", "isSpeakerDetectionEnabled", "", "selectedVoice", "", "transcriptionFontSize", "", "conversationMode", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;ZLjava/lang/String;FLcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;)V", "getUserLang", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "getSpeakerLanguage", "()Z", "getSelectedVoice", "()Ljava/lang/String;", "getTranscriptionFontSize", "()F", "getConversationMode", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ConversationSettingsFlow {
    public static final int $stable = 0;
    private final ConversationMode conversationMode;
    private final boolean isSpeakerDetectionEnabled;
    private final String selectedVoice;
    private final LanguageEnum speakerLanguage;
    private final float transcriptionFontSize;
    private final LanguageEnum userLang;

    public static /* synthetic */ ConversationSettingsFlow copy$default(ConversationSettingsFlow conversationSettingsFlow, LanguageEnum languageEnum, LanguageEnum languageEnum2, boolean z, String str, float f, ConversationMode conversationMode, int i, Object obj) {
        if ((i & 1) != 0) {
            languageEnum = conversationSettingsFlow.userLang;
        }
        if ((i & 2) != 0) {
            languageEnum2 = conversationSettingsFlow.speakerLanguage;
        }
        if ((i & 4) != 0) {
            z = conversationSettingsFlow.isSpeakerDetectionEnabled;
        }
        if ((i & 8) != 0) {
            str = conversationSettingsFlow.selectedVoice;
        }
        if ((i & 16) != 0) {
            f = conversationSettingsFlow.transcriptionFontSize;
        }
        if ((i & 32) != 0) {
            conversationMode = conversationSettingsFlow.conversationMode;
        }
        float f2 = f;
        ConversationMode conversationMode2 = conversationMode;
        return conversationSettingsFlow.copy(languageEnum, languageEnum2, z, str, f2, conversationMode2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final LanguageEnum getUserLang() {
        return this.userLang;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final LanguageEnum getSpeakerLanguage() {
        return this.speakerLanguage;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsSpeakerDetectionEnabled() {
        return this.isSpeakerDetectionEnabled;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSelectedVoice() {
        return this.selectedVoice;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getTranscriptionFontSize() {
        return this.transcriptionFontSize;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ConversationMode getConversationMode() {
        return this.conversationMode;
    }

    public final ConversationSettingsFlow copy(LanguageEnum userLang, LanguageEnum speakerLanguage, boolean isSpeakerDetectionEnabled, String selectedVoice, float transcriptionFontSize, ConversationMode conversationMode) {
        Intrinsics.checkNotNullParameter(userLang, "userLang");
        Intrinsics.checkNotNullParameter(speakerLanguage, "speakerLanguage");
        Intrinsics.checkNotNullParameter(conversationMode, "conversationMode");
        return new ConversationSettingsFlow(userLang, speakerLanguage, isSpeakerDetectionEnabled, selectedVoice, transcriptionFontSize, conversationMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationSettingsFlow)) {
            return false;
        }
        ConversationSettingsFlow conversationSettingsFlow = (ConversationSettingsFlow) other;
        return this.userLang == conversationSettingsFlow.userLang && this.speakerLanguage == conversationSettingsFlow.speakerLanguage && this.isSpeakerDetectionEnabled == conversationSettingsFlow.isSpeakerDetectionEnabled && Intrinsics.areEqual(this.selectedVoice, conversationSettingsFlow.selectedVoice) && Float.compare(this.transcriptionFontSize, conversationSettingsFlow.transcriptionFontSize) == 0 && this.conversationMode == conversationSettingsFlow.conversationMode;
    }

    public int hashCode() {
        int iHashCode = ((((this.userLang.hashCode() * 31) + this.speakerLanguage.hashCode()) * 31) + Boolean.hashCode(this.isSpeakerDetectionEnabled)) * 31;
        String str = this.selectedVoice;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Float.hashCode(this.transcriptionFontSize)) * 31) + this.conversationMode.hashCode();
    }

    public String toString() {
        return "ConversationSettingsFlow(userLang=" + this.userLang + ", speakerLanguage=" + this.speakerLanguage + ", isSpeakerDetectionEnabled=" + this.isSpeakerDetectionEnabled + ", selectedVoice=" + this.selectedVoice + ", transcriptionFontSize=" + this.transcriptionFontSize + ", conversationMode=" + this.conversationMode + ")";
    }

    public ConversationSettingsFlow(LanguageEnum languageEnum, LanguageEnum languageEnum2, boolean z, String str, float f, ConversationMode conversationMode) {
        Intrinsics.checkNotNullParameter(languageEnum, "userLang");
        Intrinsics.checkNotNullParameter(languageEnum2, "speakerLanguage");
        Intrinsics.checkNotNullParameter(conversationMode, "conversationMode");
        this.userLang = languageEnum;
        this.speakerLanguage = languageEnum2;
        this.isSpeakerDetectionEnabled = z;
        this.selectedVoice = str;
        this.transcriptionFontSize = f;
        this.conversationMode = conversationMode;
    }

    public final LanguageEnum getUserLang() {
        return this.userLang;
    }

    public final LanguageEnum getSpeakerLanguage() {
        return this.speakerLanguage;
    }

    public final boolean isSpeakerDetectionEnabled() {
        return this.isSpeakerDetectionEnabled;
    }

    public final String getSelectedVoice() {
        return this.selectedVoice;
    }

    public final float getTranscriptionFontSize() {
        return this.transcriptionFontSize;
    }

    public final ConversationMode getConversationMode() {
        return this.conversationMode;
    }
}
