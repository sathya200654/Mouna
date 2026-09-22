package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\fHÆ\u0003JG\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010 \u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0018¨\u0006%"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationScreenSettingsState;", "", "conversationMode", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;", "userLang", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "speakerLang", "transcriptFontSize", "", "selectedVoiceId", "", "isSpeakerDetectionEnabled", "", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;FLjava/lang/String;Z)V", "getConversationMode", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;", "getUserLang", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "getSpeakerLang", "getTranscriptFontSize", "()F", "getSelectedVoiceId", "()Ljava/lang/String;", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ConversationScreenSettingsState {
    public static final int $stable = 0;
    private final ConversationMode conversationMode;
    private final boolean isSpeakerDetectionEnabled;
    private final String selectedVoiceId;
    private final LanguageEnum speakerLang;
    private final float transcriptFontSize;
    private final LanguageEnum userLang;

    public static /* synthetic */ ConversationScreenSettingsState copy$default(ConversationScreenSettingsState conversationScreenSettingsState, ConversationMode conversationMode, LanguageEnum languageEnum, LanguageEnum languageEnum2, float f, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            conversationMode = conversationScreenSettingsState.conversationMode;
        }
        if ((i & 2) != 0) {
            languageEnum = conversationScreenSettingsState.userLang;
        }
        if ((i & 4) != 0) {
            languageEnum2 = conversationScreenSettingsState.speakerLang;
        }
        if ((i & 8) != 0) {
            f = conversationScreenSettingsState.transcriptFontSize;
        }
        if ((i & 16) != 0) {
            str = conversationScreenSettingsState.selectedVoiceId;
        }
        if ((i & 32) != 0) {
            z = conversationScreenSettingsState.isSpeakerDetectionEnabled;
        }
        String str2 = str;
        boolean z2 = z;
        return conversationScreenSettingsState.copy(conversationMode, languageEnum, languageEnum2, f, str2, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ConversationMode getConversationMode() {
        return this.conversationMode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final LanguageEnum getUserLang() {
        return this.userLang;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final LanguageEnum getSpeakerLang() {
        return this.speakerLang;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getTranscriptFontSize() {
        return this.transcriptFontSize;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSelectedVoiceId() {
        return this.selectedVoiceId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsSpeakerDetectionEnabled() {
        return this.isSpeakerDetectionEnabled;
    }

    public final ConversationScreenSettingsState copy(ConversationMode conversationMode, LanguageEnum userLang, LanguageEnum speakerLang, float transcriptFontSize, String selectedVoiceId, boolean isSpeakerDetectionEnabled) {
        Intrinsics.checkNotNullParameter(conversationMode, "conversationMode");
        Intrinsics.checkNotNullParameter(userLang, "userLang");
        Intrinsics.checkNotNullParameter(speakerLang, "speakerLang");
        return new ConversationScreenSettingsState(conversationMode, userLang, speakerLang, transcriptFontSize, selectedVoiceId, isSpeakerDetectionEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationScreenSettingsState)) {
            return false;
        }
        ConversationScreenSettingsState conversationScreenSettingsState = (ConversationScreenSettingsState) other;
        return this.conversationMode == conversationScreenSettingsState.conversationMode && this.userLang == conversationScreenSettingsState.userLang && this.speakerLang == conversationScreenSettingsState.speakerLang && Float.compare(this.transcriptFontSize, conversationScreenSettingsState.transcriptFontSize) == 0 && Intrinsics.areEqual(this.selectedVoiceId, conversationScreenSettingsState.selectedVoiceId) && this.isSpeakerDetectionEnabled == conversationScreenSettingsState.isSpeakerDetectionEnabled;
    }

    public int hashCode() {
        int iHashCode = ((((((this.conversationMode.hashCode() * 31) + this.userLang.hashCode()) * 31) + this.speakerLang.hashCode()) * 31) + Float.hashCode(this.transcriptFontSize)) * 31;
        String str = this.selectedVoiceId;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isSpeakerDetectionEnabled);
    }

    public String toString() {
        return "ConversationScreenSettingsState(conversationMode=" + this.conversationMode + ", userLang=" + this.userLang + ", speakerLang=" + this.speakerLang + ", transcriptFontSize=" + this.transcriptFontSize + ", selectedVoiceId=" + this.selectedVoiceId + ", isSpeakerDetectionEnabled=" + this.isSpeakerDetectionEnabled + ")";
    }

    public ConversationScreenSettingsState(ConversationMode conversationMode, LanguageEnum languageEnum, LanguageEnum languageEnum2, float f, String str, boolean z) {
        Intrinsics.checkNotNullParameter(conversationMode, "conversationMode");
        Intrinsics.checkNotNullParameter(languageEnum, "userLang");
        Intrinsics.checkNotNullParameter(languageEnum2, "speakerLang");
        this.conversationMode = conversationMode;
        this.userLang = languageEnum;
        this.speakerLang = languageEnum2;
        this.transcriptFontSize = f;
        this.selectedVoiceId = str;
        this.isSpeakerDetectionEnabled = z;
    }

    public /* synthetic */ ConversationScreenSettingsState(ConversationMode conversationMode, LanguageEnum languageEnum, LanguageEnum languageEnum2, float f, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ConversationMode.ONE_TO_ONE : conversationMode, languageEnum, languageEnum2, f, str, z);
    }

    public final ConversationMode getConversationMode() {
        return this.conversationMode;
    }

    public final LanguageEnum getUserLang() {
        return this.userLang;
    }

    public final LanguageEnum getSpeakerLang() {
        return this.speakerLang;
    }

    public final float getTranscriptFontSize() {
        return this.transcriptFontSize;
    }

    public final String getSelectedVoiceId() {
        return this.selectedVoiceId;
    }

    public final boolean isSpeakerDetectionEnabled() {
        return this.isSpeakerDetectionEnabled;
    }
}
