package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import android.speech.tts.Voice;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.model.InterpretationMode;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.model.InterpretationSpeed;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationSettingsViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\n\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\u0082\u0001\n\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction;", "", "OnSetConversationVoice", "OnSpeakSampleText", "OnSetConversationInputLanguage", "OnSetInterpretationModeUseCase", "OnToggleEnvironmentSignRecognizerState", "OnSetInterpretationSpeedUseCase", "OnSetConversationTranscriptionFontSize", "OnResetUserPersonaSurvey", "OnToggleSpeakerDetection", "OnRedirectActionClicked", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction$OnRedirectActionClicked;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction$OnResetUserPersonaSurvey;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction$OnSetConversationInputLanguage;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction$OnSetConversationTranscriptionFontSize;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction$OnSetConversationVoice;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction$OnSetInterpretationModeUseCase;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction$OnSetInterpretationSpeedUseCase;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction$OnSpeakSampleText;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction$OnToggleEnvironmentSignRecognizerState;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction$OnToggleSpeakerDetection;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ConversationSettingsAction {

    /* JADX INFO: compiled from: ConversationSettingsViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction$OnSetConversationVoice;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction;", "voice", "Landroid/speech/tts/Voice;", "<init>", "(Landroid/speech/tts/Voice;)V", "getVoice", "()Landroid/speech/tts/Voice;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnSetConversationVoice implements ConversationSettingsAction {
        public static final int $stable = 8;
        private final Voice voice;

        public static /* synthetic */ OnSetConversationVoice copy$default(OnSetConversationVoice onSetConversationVoice, Voice voice, int i, Object obj) {
            if ((i & 1) != 0) {
                voice = onSetConversationVoice.voice;
            }
            return onSetConversationVoice.copy(voice);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Voice getVoice() {
            return this.voice;
        }

        public final OnSetConversationVoice copy(Voice voice) {
            return new OnSetConversationVoice(voice);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnSetConversationVoice) && Intrinsics.areEqual(this.voice, ((OnSetConversationVoice) other).voice);
        }

        public int hashCode() {
            Voice voice = this.voice;
            if (voice == null) {
                return 0;
            }
            return voice.hashCode();
        }

        public String toString() {
            return "OnSetConversationVoice(voice=" + this.voice + ")";
        }

        public OnSetConversationVoice(Voice voice) {
            this.voice = voice;
        }

        public final Voice getVoice() {
            return this.voice;
        }
    }

    /* JADX INFO: compiled from: ConversationSettingsViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction$OnSpeakSampleText;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction;", "voice", "Landroid/speech/tts/Voice;", "<init>", "(Landroid/speech/tts/Voice;)V", "getVoice", "()Landroid/speech/tts/Voice;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnSpeakSampleText implements ConversationSettingsAction {
        public static final int $stable = 8;
        private final Voice voice;

        public static /* synthetic */ OnSpeakSampleText copy$default(OnSpeakSampleText onSpeakSampleText, Voice voice, int i, Object obj) {
            if ((i & 1) != 0) {
                voice = onSpeakSampleText.voice;
            }
            return onSpeakSampleText.copy(voice);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Voice getVoice() {
            return this.voice;
        }

        public final OnSpeakSampleText copy(Voice voice) {
            return new OnSpeakSampleText(voice);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnSpeakSampleText) && Intrinsics.areEqual(this.voice, ((OnSpeakSampleText) other).voice);
        }

        public int hashCode() {
            Voice voice = this.voice;
            if (voice == null) {
                return 0;
            }
            return voice.hashCode();
        }

        public String toString() {
            return "OnSpeakSampleText(voice=" + this.voice + ")";
        }

        public OnSpeakSampleText(Voice voice) {
            this.voice = voice;
        }

        public final Voice getVoice() {
            return this.voice;
        }
    }

    /* JADX INFO: compiled from: ConversationSettingsViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction$OnSetConversationInputLanguage;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction;", "language", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;)V", "getLanguage", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnSetConversationInputLanguage implements ConversationSettingsAction {
        public static final int $stable = 0;
        private final LanguageEnum language;

        public static /* synthetic */ OnSetConversationInputLanguage copy$default(OnSetConversationInputLanguage onSetConversationInputLanguage, LanguageEnum languageEnum, int i, Object obj) {
            if ((i & 1) != 0) {
                languageEnum = onSetConversationInputLanguage.language;
            }
            return onSetConversationInputLanguage.copy(languageEnum);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final LanguageEnum getLanguage() {
            return this.language;
        }

        public final OnSetConversationInputLanguage copy(LanguageEnum language) {
            Intrinsics.checkNotNullParameter(language, "language");
            return new OnSetConversationInputLanguage(language);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnSetConversationInputLanguage) && this.language == ((OnSetConversationInputLanguage) other).language;
        }

        public int hashCode() {
            return this.language.hashCode();
        }

        public String toString() {
            return "OnSetConversationInputLanguage(language=" + this.language + ")";
        }

        public OnSetConversationInputLanguage(LanguageEnum languageEnum) {
            Intrinsics.checkNotNullParameter(languageEnum, "language");
            this.language = languageEnum;
        }

        public final LanguageEnum getLanguage() {
            return this.language;
        }
    }

    /* JADX INFO: compiled from: ConversationSettingsViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction$OnSetInterpretationModeUseCase;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction;", "interpretationMode", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationMode;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationMode;)V", "getInterpretationMode", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationMode;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnSetInterpretationModeUseCase implements ConversationSettingsAction {
        public static final int $stable = 0;
        private final InterpretationMode interpretationMode;

        public static /* synthetic */ OnSetInterpretationModeUseCase copy$default(OnSetInterpretationModeUseCase onSetInterpretationModeUseCase, InterpretationMode interpretationMode, int i, Object obj) {
            if ((i & 1) != 0) {
                interpretationMode = onSetInterpretationModeUseCase.interpretationMode;
            }
            return onSetInterpretationModeUseCase.copy(interpretationMode);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final InterpretationMode getInterpretationMode() {
            return this.interpretationMode;
        }

        public final OnSetInterpretationModeUseCase copy(InterpretationMode interpretationMode) {
            Intrinsics.checkNotNullParameter(interpretationMode, "interpretationMode");
            return new OnSetInterpretationModeUseCase(interpretationMode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnSetInterpretationModeUseCase) && this.interpretationMode == ((OnSetInterpretationModeUseCase) other).interpretationMode;
        }

        public int hashCode() {
            return this.interpretationMode.hashCode();
        }

        public String toString() {
            return "OnSetInterpretationModeUseCase(interpretationMode=" + this.interpretationMode + ")";
        }

        public OnSetInterpretationModeUseCase(InterpretationMode interpretationMode) {
            Intrinsics.checkNotNullParameter(interpretationMode, "interpretationMode");
            this.interpretationMode = interpretationMode;
        }

        public final InterpretationMode getInterpretationMode() {
            return this.interpretationMode;
        }
    }

    /* JADX INFO: compiled from: ConversationSettingsViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction$OnToggleEnvironmentSignRecognizerState;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction;", RemoteConfigConstants.ResponseFieldKey.STATE, "", "<init>", "(Z)V", "getState", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnToggleEnvironmentSignRecognizerState implements ConversationSettingsAction {
        public static final int $stable = 0;
        private final boolean state;

        public static /* synthetic */ OnToggleEnvironmentSignRecognizerState copy$default(OnToggleEnvironmentSignRecognizerState onToggleEnvironmentSignRecognizerState, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = onToggleEnvironmentSignRecognizerState.state;
            }
            return onToggleEnvironmentSignRecognizerState.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getState() {
            return this.state;
        }

        public final OnToggleEnvironmentSignRecognizerState copy(boolean state) {
            return new OnToggleEnvironmentSignRecognizerState(state);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnToggleEnvironmentSignRecognizerState) && this.state == ((OnToggleEnvironmentSignRecognizerState) other).state;
        }

        public int hashCode() {
            return Boolean.hashCode(this.state);
        }

        public String toString() {
            return "OnToggleEnvironmentSignRecognizerState(state=" + this.state + ")";
        }

        public OnToggleEnvironmentSignRecognizerState(boolean z) {
            this.state = z;
        }

        public final boolean getState() {
            return this.state;
        }
    }

    /* JADX INFO: compiled from: ConversationSettingsViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction$OnSetInterpretationSpeedUseCase;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction;", "interpretationSpeed", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationSpeed;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationSpeed;)V", "getInterpretationSpeed", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationSpeed;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnSetInterpretationSpeedUseCase implements ConversationSettingsAction {
        public static final int $stable = 0;
        private final InterpretationSpeed interpretationSpeed;

        public static /* synthetic */ OnSetInterpretationSpeedUseCase copy$default(OnSetInterpretationSpeedUseCase onSetInterpretationSpeedUseCase, InterpretationSpeed interpretationSpeed, int i, Object obj) {
            if ((i & 1) != 0) {
                interpretationSpeed = onSetInterpretationSpeedUseCase.interpretationSpeed;
            }
            return onSetInterpretationSpeedUseCase.copy(interpretationSpeed);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final InterpretationSpeed getInterpretationSpeed() {
            return this.interpretationSpeed;
        }

        public final OnSetInterpretationSpeedUseCase copy(InterpretationSpeed interpretationSpeed) {
            Intrinsics.checkNotNullParameter(interpretationSpeed, "interpretationSpeed");
            return new OnSetInterpretationSpeedUseCase(interpretationSpeed);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnSetInterpretationSpeedUseCase) && this.interpretationSpeed == ((OnSetInterpretationSpeedUseCase) other).interpretationSpeed;
        }

        public int hashCode() {
            return this.interpretationSpeed.hashCode();
        }

        public String toString() {
            return "OnSetInterpretationSpeedUseCase(interpretationSpeed=" + this.interpretationSpeed + ")";
        }

        public OnSetInterpretationSpeedUseCase(InterpretationSpeed interpretationSpeed) {
            Intrinsics.checkNotNullParameter(interpretationSpeed, "interpretationSpeed");
            this.interpretationSpeed = interpretationSpeed;
        }

        public final InterpretationSpeed getInterpretationSpeed() {
            return this.interpretationSpeed;
        }
    }

    /* JADX INFO: compiled from: ConversationSettingsViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction$OnSetConversationTranscriptionFontSize;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction;", "size", "", "<init>", "(F)V", "getSize", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnSetConversationTranscriptionFontSize implements ConversationSettingsAction {
        public static final int $stable = 0;
        private final float size;

        public static /* synthetic */ OnSetConversationTranscriptionFontSize copy$default(OnSetConversationTranscriptionFontSize onSetConversationTranscriptionFontSize, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = onSetConversationTranscriptionFontSize.size;
            }
            return onSetConversationTranscriptionFontSize.copy(f);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getSize() {
            return this.size;
        }

        public final OnSetConversationTranscriptionFontSize copy(float size) {
            return new OnSetConversationTranscriptionFontSize(size);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnSetConversationTranscriptionFontSize) && Float.compare(this.size, ((OnSetConversationTranscriptionFontSize) other).size) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.size);
        }

        public String toString() {
            return "OnSetConversationTranscriptionFontSize(size=" + this.size + ")";
        }

        public OnSetConversationTranscriptionFontSize(float f) {
            this.size = f;
        }

        public final float getSize() {
            return this.size;
        }
    }

    /* JADX INFO: compiled from: ConversationSettingsViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction$OnResetUserPersonaSurvey;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnResetUserPersonaSurvey implements ConversationSettingsAction {
        public static final int $stable = 0;
        public static final OnResetUserPersonaSurvey INSTANCE = new OnResetUserPersonaSurvey();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnResetUserPersonaSurvey)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1339734296;
        }

        public String toString() {
            return "OnResetUserPersonaSurvey";
        }

        private OnResetUserPersonaSurvey() {
        }
    }

    /* JADX INFO: compiled from: ConversationSettingsViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction$OnToggleSpeakerDetection;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnToggleSpeakerDetection implements ConversationSettingsAction {
        public static final int $stable = 0;
        public static final OnToggleSpeakerDetection INSTANCE = new OnToggleSpeakerDetection();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnToggleSpeakerDetection)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1342560442;
        }

        public String toString() {
            return "OnToggleSpeakerDetection";
        }

        private OnToggleSpeakerDetection() {
        }
    }

    /* JADX INFO: compiled from: ConversationSettingsViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction$OnRedirectActionClicked;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction;", "analyticsEvent", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;)V", "getAnalyticsEvent", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnRedirectActionClicked implements ConversationSettingsAction {
        public static final int $stable = 0;
        private final AnalyticsEvent analyticsEvent;

        public static /* synthetic */ OnRedirectActionClicked copy$default(OnRedirectActionClicked onRedirectActionClicked, AnalyticsEvent analyticsEvent, int i, Object obj) {
            if ((i & 1) != 0) {
                analyticsEvent = onRedirectActionClicked.analyticsEvent;
            }
            return onRedirectActionClicked.copy(analyticsEvent);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AnalyticsEvent getAnalyticsEvent() {
            return this.analyticsEvent;
        }

        public final OnRedirectActionClicked copy(AnalyticsEvent analyticsEvent) {
            Intrinsics.checkNotNullParameter(analyticsEvent, "analyticsEvent");
            return new OnRedirectActionClicked(analyticsEvent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnRedirectActionClicked) && Intrinsics.areEqual(this.analyticsEvent, ((OnRedirectActionClicked) other).analyticsEvent);
        }

        public int hashCode() {
            return this.analyticsEvent.hashCode();
        }

        public String toString() {
            return "OnRedirectActionClicked(analyticsEvent=" + this.analyticsEvent + ")";
        }

        public OnRedirectActionClicked(AnalyticsEvent analyticsEvent) {
            Intrinsics.checkNotNullParameter(analyticsEvent, "analyticsEvent");
            this.analyticsEvent = analyticsEvent;
        }

        public final AnalyticsEvent getAnalyticsEvent() {
            return this.analyticsEvent;
        }
    }
}
