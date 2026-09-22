package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMode;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsettings.VoiceOption;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.model.InterpretationMode;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.model.InterpretationSpeed;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_18_4_1.FastDoubleMath;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationSettingsViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\t\u0010/\u001a\u00020\fHÆ\u0003J\t\u00100\u001a\u00020\u000eHÆ\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0014HÆ\u0003Ju\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0012\u001a\u00020\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001J\u0013\u00105\u001a\u00020\b2\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u000208HÖ\u0001J\t\u00109\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u001cR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0012\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b)\u0010\u001c¨\u0006:"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsState;", "", "userLang", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "speakerLang", "conversationMode", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;", "isSpeakerDetectionEnabled", "", "activeInterpretationSpeed", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationSpeed;", "activeInterpretationMode", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationMode;", "activeConversationTranscriptionFontSize", "", "conversationTtsVoices", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsettings/VoiceOption;", "envSoundRecognizerState", "selectedVoice", "", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;ZLcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationSpeed;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationMode;FLjava/util/List;ZLjava/lang/String;)V", "getUserLang", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "getSpeakerLang", "getConversationMode", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;", "()Z", "getActiveInterpretationSpeed", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationSpeed;", "getActiveInterpretationMode", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationMode;", "getActiveConversationTranscriptionFontSize", "()F", "getConversationTtsVoices", "()Ljava/util/List;", "getEnvSoundRecognizerState", "getSelectedVoice", "()Ljava/lang/String;", "showSpeakerDetectionRow", "getShowSpeakerDetectionRow", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ConversationSettingsState {
    public static final int $stable = 8;
    private final float activeConversationTranscriptionFontSize;
    private final InterpretationMode activeInterpretationMode;
    private final InterpretationSpeed activeInterpretationSpeed;
    private final ConversationMode conversationMode;
    private final List<VoiceOption> conversationTtsVoices;
    private final boolean envSoundRecognizerState;
    private final boolean isSpeakerDetectionEnabled;
    private final String selectedVoice;
    private final LanguageEnum speakerLang;
    private final LanguageEnum userLang;

    public ConversationSettingsState() {
        this(null, null, null, false, null, null, 0.0f, null, false, null, FastDoubleMath.DOUBLE_EXPONENT_BIAS, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConversationSettingsState copy$default(ConversationSettingsState conversationSettingsState, LanguageEnum languageEnum, LanguageEnum languageEnum2, ConversationMode conversationMode, boolean z, InterpretationSpeed interpretationSpeed, InterpretationMode interpretationMode, float f, List list, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            languageEnum = conversationSettingsState.userLang;
        }
        if ((i & 2) != 0) {
            languageEnum2 = conversationSettingsState.speakerLang;
        }
        if ((i & 4) != 0) {
            conversationMode = conversationSettingsState.conversationMode;
        }
        if ((i & 8) != 0) {
            z = conversationSettingsState.isSpeakerDetectionEnabled;
        }
        if ((i & 16) != 0) {
            interpretationSpeed = conversationSettingsState.activeInterpretationSpeed;
        }
        if ((i & 32) != 0) {
            interpretationMode = conversationSettingsState.activeInterpretationMode;
        }
        if ((i & 64) != 0) {
            f = conversationSettingsState.activeConversationTranscriptionFontSize;
        }
        if ((i & 128) != 0) {
            list = conversationSettingsState.conversationTtsVoices;
        }
        if ((i & 256) != 0) {
            z2 = conversationSettingsState.envSoundRecognizerState;
        }
        if ((i & 512) != 0) {
            str = conversationSettingsState.selectedVoice;
        }
        boolean z3 = z2;
        String str2 = str;
        float f2 = f;
        List list2 = list;
        InterpretationSpeed interpretationSpeed2 = interpretationSpeed;
        InterpretationMode interpretationMode2 = interpretationMode;
        return conversationSettingsState.copy(languageEnum, languageEnum2, conversationMode, z, interpretationSpeed2, interpretationMode2, f2, list2, z3, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final LanguageEnum getUserLang() {
        return this.userLang;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getSelectedVoice() {
        return this.selectedVoice;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final LanguageEnum getSpeakerLang() {
        return this.speakerLang;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ConversationMode getConversationMode() {
        return this.conversationMode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsSpeakerDetectionEnabled() {
        return this.isSpeakerDetectionEnabled;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final InterpretationSpeed getActiveInterpretationSpeed() {
        return this.activeInterpretationSpeed;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final InterpretationMode getActiveInterpretationMode() {
        return this.activeInterpretationMode;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final float getActiveConversationTranscriptionFontSize() {
        return this.activeConversationTranscriptionFontSize;
    }

    public final List<VoiceOption> component8() {
        return this.conversationTtsVoices;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getEnvSoundRecognizerState() {
        return this.envSoundRecognizerState;
    }

    public final ConversationSettingsState copy(LanguageEnum userLang, LanguageEnum speakerLang, ConversationMode conversationMode, boolean isSpeakerDetectionEnabled, InterpretationSpeed activeInterpretationSpeed, InterpretationMode activeInterpretationMode, float activeConversationTranscriptionFontSize, List<VoiceOption> conversationTtsVoices, boolean envSoundRecognizerState, String selectedVoice) {
        Intrinsics.checkNotNullParameter(userLang, "userLang");
        Intrinsics.checkNotNullParameter(speakerLang, "speakerLang");
        Intrinsics.checkNotNullParameter(conversationMode, "conversationMode");
        Intrinsics.checkNotNullParameter(activeInterpretationSpeed, "activeInterpretationSpeed");
        Intrinsics.checkNotNullParameter(activeInterpretationMode, "activeInterpretationMode");
        Intrinsics.checkNotNullParameter(conversationTtsVoices, "conversationTtsVoices");
        return new ConversationSettingsState(userLang, speakerLang, conversationMode, isSpeakerDetectionEnabled, activeInterpretationSpeed, activeInterpretationMode, activeConversationTranscriptionFontSize, conversationTtsVoices, envSoundRecognizerState, selectedVoice);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationSettingsState)) {
            return false;
        }
        ConversationSettingsState conversationSettingsState = (ConversationSettingsState) other;
        return this.userLang == conversationSettingsState.userLang && this.speakerLang == conversationSettingsState.speakerLang && this.conversationMode == conversationSettingsState.conversationMode && this.isSpeakerDetectionEnabled == conversationSettingsState.isSpeakerDetectionEnabled && this.activeInterpretationSpeed == conversationSettingsState.activeInterpretationSpeed && this.activeInterpretationMode == conversationSettingsState.activeInterpretationMode && Float.compare(this.activeConversationTranscriptionFontSize, conversationSettingsState.activeConversationTranscriptionFontSize) == 0 && Intrinsics.areEqual(this.conversationTtsVoices, conversationSettingsState.conversationTtsVoices) && this.envSoundRecognizerState == conversationSettingsState.envSoundRecognizerState && Intrinsics.areEqual(this.selectedVoice, conversationSettingsState.selectedVoice);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((this.userLang.hashCode() * 31) + this.speakerLang.hashCode()) * 31) + this.conversationMode.hashCode()) * 31) + Boolean.hashCode(this.isSpeakerDetectionEnabled)) * 31) + this.activeInterpretationSpeed.hashCode()) * 31) + this.activeInterpretationMode.hashCode()) * 31) + Float.hashCode(this.activeConversationTranscriptionFontSize)) * 31) + this.conversationTtsVoices.hashCode()) * 31) + Boolean.hashCode(this.envSoundRecognizerState)) * 31;
        String str = this.selectedVoice;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ConversationSettingsState(userLang=" + this.userLang + ", speakerLang=" + this.speakerLang + ", conversationMode=" + this.conversationMode + ", isSpeakerDetectionEnabled=" + this.isSpeakerDetectionEnabled + ", activeInterpretationSpeed=" + this.activeInterpretationSpeed + ", activeInterpretationMode=" + this.activeInterpretationMode + ", activeConversationTranscriptionFontSize=" + this.activeConversationTranscriptionFontSize + ", conversationTtsVoices=" + this.conversationTtsVoices + ", envSoundRecognizerState=" + this.envSoundRecognizerState + ", selectedVoice=" + this.selectedVoice + ")";
    }

    public ConversationSettingsState(LanguageEnum languageEnum, LanguageEnum languageEnum2, ConversationMode conversationMode, boolean z, InterpretationSpeed interpretationSpeed, InterpretationMode interpretationMode, float f, List<VoiceOption> list, boolean z2, String str) {
        Intrinsics.checkNotNullParameter(languageEnum, "userLang");
        Intrinsics.checkNotNullParameter(languageEnum2, "speakerLang");
        Intrinsics.checkNotNullParameter(conversationMode, "conversationMode");
        Intrinsics.checkNotNullParameter(interpretationSpeed, "activeInterpretationSpeed");
        Intrinsics.checkNotNullParameter(interpretationMode, "activeInterpretationMode");
        Intrinsics.checkNotNullParameter(list, "conversationTtsVoices");
        this.userLang = languageEnum;
        this.speakerLang = languageEnum2;
        this.conversationMode = conversationMode;
        this.isSpeakerDetectionEnabled = z;
        this.activeInterpretationSpeed = interpretationSpeed;
        this.activeInterpretationMode = interpretationMode;
        this.activeConversationTranscriptionFontSize = f;
        this.conversationTtsVoices = list;
        this.envSoundRecognizerState = z2;
        this.selectedVoice = str;
    }

    public /* synthetic */ ConversationSettingsState(LanguageEnum languageEnum, LanguageEnum languageEnum2, ConversationMode conversationMode, boolean z, InterpretationSpeed interpretationSpeed, InterpretationMode interpretationMode, float f, List list, boolean z2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? LanguageEnum.ENGLISH : languageEnum, (i & 2) != 0 ? LanguageEnum.ENGLISH : languageEnum2, (i & 4) != 0 ? ConversationMode.ONE_TO_ONE : conversationMode, (i & 8) != 0 ? false : z, (i & 16) != 0 ? InterpretationSpeed.Fast : interpretationSpeed, (i & 32) != 0 ? InterpretationMode.QUICK : interpretationMode, (i & 64) != 0 ? 16.0f : f, (i & 128) != 0 ? CollectionsKt.emptyList() : list, (i & 256) != 0 ? false : z2, (i & 512) != 0 ? null : str);
    }

    public final LanguageEnum getUserLang() {
        return this.userLang;
    }

    public final LanguageEnum getSpeakerLang() {
        return this.speakerLang;
    }

    public final ConversationMode getConversationMode() {
        return this.conversationMode;
    }

    public final boolean isSpeakerDetectionEnabled() {
        return this.isSpeakerDetectionEnabled;
    }

    public final InterpretationSpeed getActiveInterpretationSpeed() {
        return this.activeInterpretationSpeed;
    }

    public final InterpretationMode getActiveInterpretationMode() {
        return this.activeInterpretationMode;
    }

    public final float getActiveConversationTranscriptionFontSize() {
        return this.activeConversationTranscriptionFontSize;
    }

    public final List<VoiceOption> getConversationTtsVoices() {
        return this.conversationTtsVoices;
    }

    public final boolean getEnvSoundRecognizerState() {
        return this.envSoundRecognizerState;
    }

    public final String getSelectedVoice() {
        return this.selectedVoice;
    }

    public final boolean getShowSpeakerDetectionRow() {
        return this.userLang == LanguageEnum.ENGLISH && this.speakerLang == LanguageEnum.ENGLISH && this.conversationMode == ConversationMode.MEETING;
    }
}
