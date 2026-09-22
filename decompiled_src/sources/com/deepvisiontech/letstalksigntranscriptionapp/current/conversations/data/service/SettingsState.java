package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationSpeechRecognizerService.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/SettingsState;", "", "conversationMode", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;", "userLanguage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "speakerLanguage", "isSpeakerDetectionEnabled", "", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Z)V", "getConversationMode", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;", "getUserLanguage", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "getSpeakerLanguage", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
final /* data */ class SettingsState {
    private final ConversationMode conversationMode;
    private final boolean isSpeakerDetectionEnabled;
    private final LanguageEnum speakerLanguage;
    private final LanguageEnum userLanguage;

    public static /* synthetic */ SettingsState copy$default(SettingsState settingsState, ConversationMode conversationMode, LanguageEnum languageEnum, LanguageEnum languageEnum2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            conversationMode = settingsState.conversationMode;
        }
        if ((i & 2) != 0) {
            languageEnum = settingsState.userLanguage;
        }
        if ((i & 4) != 0) {
            languageEnum2 = settingsState.speakerLanguage;
        }
        if ((i & 8) != 0) {
            z = settingsState.isSpeakerDetectionEnabled;
        }
        return settingsState.copy(conversationMode, languageEnum, languageEnum2, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ConversationMode getConversationMode() {
        return this.conversationMode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final LanguageEnum getUserLanguage() {
        return this.userLanguage;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final LanguageEnum getSpeakerLanguage() {
        return this.speakerLanguage;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsSpeakerDetectionEnabled() {
        return this.isSpeakerDetectionEnabled;
    }

    public final SettingsState copy(ConversationMode conversationMode, LanguageEnum userLanguage, LanguageEnum speakerLanguage, boolean isSpeakerDetectionEnabled) {
        Intrinsics.checkNotNullParameter(conversationMode, "conversationMode");
        Intrinsics.checkNotNullParameter(userLanguage, "userLanguage");
        Intrinsics.checkNotNullParameter(speakerLanguage, "speakerLanguage");
        return new SettingsState(conversationMode, userLanguage, speakerLanguage, isSpeakerDetectionEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsState)) {
            return false;
        }
        SettingsState settingsState = (SettingsState) other;
        return this.conversationMode == settingsState.conversationMode && this.userLanguage == settingsState.userLanguage && this.speakerLanguage == settingsState.speakerLanguage && this.isSpeakerDetectionEnabled == settingsState.isSpeakerDetectionEnabled;
    }

    public int hashCode() {
        return (((((this.conversationMode.hashCode() * 31) + this.userLanguage.hashCode()) * 31) + this.speakerLanguage.hashCode()) * 31) + Boolean.hashCode(this.isSpeakerDetectionEnabled);
    }

    public String toString() {
        return "SettingsState(conversationMode=" + this.conversationMode + ", userLanguage=" + this.userLanguage + ", speakerLanguage=" + this.speakerLanguage + ", isSpeakerDetectionEnabled=" + this.isSpeakerDetectionEnabled + ")";
    }

    public SettingsState(ConversationMode conversationMode, LanguageEnum languageEnum, LanguageEnum languageEnum2, boolean z) {
        Intrinsics.checkNotNullParameter(conversationMode, "conversationMode");
        Intrinsics.checkNotNullParameter(languageEnum, "userLanguage");
        Intrinsics.checkNotNullParameter(languageEnum2, "speakerLanguage");
        this.conversationMode = conversationMode;
        this.userLanguage = languageEnum;
        this.speakerLanguage = languageEnum2;
        this.isSpeakerDetectionEnabled = z;
    }

    public final ConversationMode getConversationMode() {
        return this.conversationMode;
    }

    public final LanguageEnum getUserLanguage() {
        return this.userLanguage;
    }

    public final LanguageEnum getSpeakerLanguage() {
        return this.speakerLanguage;
    }

    public final boolean isSpeakerDetectionEnabled() {
        return this.isSpeakerDetectionEnabled;
    }
}
