package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMessage;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMode;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.ConversationSuggestion;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.CorrectionSuggestion;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.SuggestionCategory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:$\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%\u0082\u0001$&'()*+,-./0123456789:;<=>?@ABCDEFGHI¨\u0006JÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "", "OnInterpretSpeech", "OnRequestMicrophonePermissionForInterpretation", "OnStopInterpretationAndTranscription", "OnInterpretInputText", "OnTtsSpeakAndSaveMessage", "OnSendButtonClicked", "OnCorrectionSuggestionChosenForTts", "OnTtsSpeak", "OnTtsRepeat", "OnTtsDrawerClose", "OnClearInputText", "OnSummarize", "OnCorrectionSuggestionSelect", "OnShowCorrectionSuggestionSaveDialogBox", "OnCorrectionSuggestionSaveDismiss", "OnSaveCorrectionSuggestion", "OnDeleteSuggestion", "OnDeleteCategory", "OnShowDrawer", "OnHideDrawer", "OnToggleInputSuggestion", "OnSwitchConversationMode", "OnInterpretScannedDocument", "OnOpenDocumentScanner", "OnBubbleLongPress", "OnInputTextChange", "OnSearchQueryChange", "UpdateConversationName", "OnToggleWebViewMinimization", "OnRestoreWebView", "OnShowSpeakerLanguageDialog", "OnSetSpeakerLanguageAndStartInterpretation", "OnMicrophonePermissionGranted", "OnMinimizeWebView", "OnSetSpeakerLanguage", "OnSetUserLanguage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnBubbleLongPress;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnClearInputText;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnCorrectionSuggestionChosenForTts;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnCorrectionSuggestionSaveDismiss;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnCorrectionSuggestionSelect;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnDeleteCategory;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnDeleteSuggestion;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnHideDrawer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnInputTextChange;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnInterpretInputText;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnInterpretScannedDocument;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnInterpretSpeech;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnMicrophonePermissionGranted;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnMinimizeWebView;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnOpenDocumentScanner;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnRequestMicrophonePermissionForInterpretation;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnRestoreWebView;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnSaveCorrectionSuggestion;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnSearchQueryChange;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnSendButtonClicked;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnSetSpeakerLanguage;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnSetSpeakerLanguageAndStartInterpretation;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnSetUserLanguage;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnShowCorrectionSuggestionSaveDialogBox;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnShowDrawer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnShowSpeakerLanguageDialog;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnStopInterpretationAndTranscription;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnSummarize;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnSwitchConversationMode;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnToggleInputSuggestion;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnToggleWebViewMinimization;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnTtsDrawerClose;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnTtsRepeat;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnTtsSpeak;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnTtsSpeakAndSaveMessage;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$UpdateConversationName;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ConversationUiAction {

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnInterpretSpeech;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnInterpretSpeech implements ConversationUiAction {
        public static final int $stable = 0;
        public static final OnInterpretSpeech INSTANCE = new OnInterpretSpeech();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnInterpretSpeech)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 857324724;
        }

        public String toString() {
            return "OnInterpretSpeech";
        }

        private OnInterpretSpeech() {
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnRequestMicrophonePermissionForInterpretation;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnRequestMicrophonePermissionForInterpretation implements ConversationUiAction {
        public static final int $stable = 0;
        public static final OnRequestMicrophonePermissionForInterpretation INSTANCE = new OnRequestMicrophonePermissionForInterpretation();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnRequestMicrophonePermissionForInterpretation)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 2014740996;
        }

        public String toString() {
            return "OnRequestMicrophonePermissionForInterpretation";
        }

        private OnRequestMicrophonePermissionForInterpretation() {
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnStopInterpretationAndTranscription;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnStopInterpretationAndTranscription implements ConversationUiAction {
        public static final int $stable = 0;
        public static final OnStopInterpretationAndTranscription INSTANCE = new OnStopInterpretationAndTranscription();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnStopInterpretationAndTranscription)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1451005376;
        }

        public String toString() {
            return "OnStopInterpretationAndTranscription";
        }

        private OnStopInterpretationAndTranscription() {
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnInterpretInputText;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnInterpretInputText implements ConversationUiAction {
        public static final int $stable = 0;
        public static final OnInterpretInputText INSTANCE = new OnInterpretInputText();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnInterpretInputText)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1740242693;
        }

        public String toString() {
            return "OnInterpretInputText";
        }

        private OnInterpretInputText() {
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnTtsSpeakAndSaveMessage;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "string", "", "<init>", "(Ljava/lang/String;)V", "getString", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnTtsSpeakAndSaveMessage implements ConversationUiAction {
        public static final int $stable = 0;
        private final String string;

        public static /* synthetic */ OnTtsSpeakAndSaveMessage copy$default(OnTtsSpeakAndSaveMessage onTtsSpeakAndSaveMessage, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = onTtsSpeakAndSaveMessage.string;
            }
            return onTtsSpeakAndSaveMessage.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getString() {
            return this.string;
        }

        public final OnTtsSpeakAndSaveMessage copy(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            return new OnTtsSpeakAndSaveMessage(string);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnTtsSpeakAndSaveMessage) && Intrinsics.areEqual(this.string, ((OnTtsSpeakAndSaveMessage) other).string);
        }

        public int hashCode() {
            return this.string.hashCode();
        }

        public String toString() {
            return "OnTtsSpeakAndSaveMessage(string=" + this.string + ")";
        }

        public OnTtsSpeakAndSaveMessage(String str) {
            Intrinsics.checkNotNullParameter(str, "string");
            this.string = str;
        }

        public final String getString() {
            return this.string;
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnSendButtonClicked;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnSendButtonClicked implements ConversationUiAction {
        public static final int $stable = 0;
        private final String text;

        public static /* synthetic */ OnSendButtonClicked copy$default(OnSendButtonClicked onSendButtonClicked, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = onSendButtonClicked.text;
            }
            return onSendButtonClicked.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final OnSendButtonClicked copy(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new OnSendButtonClicked(text);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnSendButtonClicked) && Intrinsics.areEqual(this.text, ((OnSendButtonClicked) other).text);
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return "OnSendButtonClicked(text=" + this.text + ")";
        }

        public OnSendButtonClicked(String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            this.text = str;
        }

        public final String getText() {
            return this.text;
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnCorrectionSuggestionChosenForTts;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnCorrectionSuggestionChosenForTts implements ConversationUiAction {
        public static final int $stable = 0;
        private final String text;

        public static /* synthetic */ OnCorrectionSuggestionChosenForTts copy$default(OnCorrectionSuggestionChosenForTts onCorrectionSuggestionChosenForTts, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = onCorrectionSuggestionChosenForTts.text;
            }
            return onCorrectionSuggestionChosenForTts.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final OnCorrectionSuggestionChosenForTts copy(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new OnCorrectionSuggestionChosenForTts(text);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnCorrectionSuggestionChosenForTts) && Intrinsics.areEqual(this.text, ((OnCorrectionSuggestionChosenForTts) other).text);
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return "OnCorrectionSuggestionChosenForTts(text=" + this.text + ")";
        }

        public OnCorrectionSuggestionChosenForTts(String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            this.text = str;
        }

        public final String getText() {
            return this.text;
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnTtsSpeak;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "string", "", "language", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "<init>", "(Ljava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;)V", "getString", "()Ljava/lang/String;", "getLanguage", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnTtsSpeak implements ConversationUiAction {
        public static final int $stable = 0;
        private final LanguageEnum language;
        private final String string;

        public static /* synthetic */ OnTtsSpeak copy$default(OnTtsSpeak onTtsSpeak, String str, LanguageEnum languageEnum, int i, Object obj) {
            if ((i & 1) != 0) {
                str = onTtsSpeak.string;
            }
            if ((i & 2) != 0) {
                languageEnum = onTtsSpeak.language;
            }
            return onTtsSpeak.copy(str, languageEnum);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getString() {
            return this.string;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final LanguageEnum getLanguage() {
            return this.language;
        }

        public final OnTtsSpeak copy(String string, LanguageEnum language) {
            Intrinsics.checkNotNullParameter(string, "string");
            Intrinsics.checkNotNullParameter(language, "language");
            return new OnTtsSpeak(string, language);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnTtsSpeak)) {
                return false;
            }
            OnTtsSpeak onTtsSpeak = (OnTtsSpeak) other;
            return Intrinsics.areEqual(this.string, onTtsSpeak.string) && this.language == onTtsSpeak.language;
        }

        public int hashCode() {
            return (this.string.hashCode() * 31) + this.language.hashCode();
        }

        public String toString() {
            return "OnTtsSpeak(string=" + this.string + ", language=" + this.language + ")";
        }

        public OnTtsSpeak(String str, LanguageEnum languageEnum) {
            Intrinsics.checkNotNullParameter(str, "string");
            Intrinsics.checkNotNullParameter(languageEnum, "language");
            this.string = str;
            this.language = languageEnum;
        }

        public final LanguageEnum getLanguage() {
            return this.language;
        }

        public final String getString() {
            return this.string;
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnTtsRepeat;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnTtsRepeat implements ConversationUiAction {
        public static final int $stable = 0;
        public static final OnTtsRepeat INSTANCE = new OnTtsRepeat();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnTtsRepeat)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 341841299;
        }

        public String toString() {
            return "OnTtsRepeat";
        }

        private OnTtsRepeat() {
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnTtsDrawerClose;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnTtsDrawerClose implements ConversationUiAction {
        public static final int $stable = 0;
        public static final OnTtsDrawerClose INSTANCE = new OnTtsDrawerClose();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnTtsDrawerClose)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 760952463;
        }

        public String toString() {
            return "OnTtsDrawerClose";
        }

        private OnTtsDrawerClose() {
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnClearInputText;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnClearInputText implements ConversationUiAction {
        public static final int $stable = 0;
        public static final OnClearInputText INSTANCE = new OnClearInputText();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnClearInputText)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -334536891;
        }

        public String toString() {
            return "OnClearInputText";
        }

        private OnClearInputText() {
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnSummarize;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnSummarize implements ConversationUiAction {
        public static final int $stable = 0;
        public static final OnSummarize INSTANCE = new OnSummarize();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnSummarize)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -663558810;
        }

        public String toString() {
            return "OnSummarize";
        }

        private OnSummarize() {
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnCorrectionSuggestionSelect;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "suggestion", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/CorrectionSuggestion;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/CorrectionSuggestion;)V", "getSuggestion", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/CorrectionSuggestion;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnCorrectionSuggestionSelect implements ConversationUiAction {
        public static final int $stable = 0;
        private final CorrectionSuggestion suggestion;

        public static /* synthetic */ OnCorrectionSuggestionSelect copy$default(OnCorrectionSuggestionSelect onCorrectionSuggestionSelect, CorrectionSuggestion correctionSuggestion, int i, Object obj) {
            if ((i & 1) != 0) {
                correctionSuggestion = onCorrectionSuggestionSelect.suggestion;
            }
            return onCorrectionSuggestionSelect.copy(correctionSuggestion);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CorrectionSuggestion getSuggestion() {
            return this.suggestion;
        }

        public final OnCorrectionSuggestionSelect copy(CorrectionSuggestion suggestion) {
            Intrinsics.checkNotNullParameter(suggestion, "suggestion");
            return new OnCorrectionSuggestionSelect(suggestion);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnCorrectionSuggestionSelect) && Intrinsics.areEqual(this.suggestion, ((OnCorrectionSuggestionSelect) other).suggestion);
        }

        public int hashCode() {
            return this.suggestion.hashCode();
        }

        public String toString() {
            return "OnCorrectionSuggestionSelect(suggestion=" + this.suggestion + ")";
        }

        public OnCorrectionSuggestionSelect(CorrectionSuggestion correctionSuggestion) {
            Intrinsics.checkNotNullParameter(correctionSuggestion, "suggestion");
            this.suggestion = correctionSuggestion;
        }

        public final CorrectionSuggestion getSuggestion() {
            return this.suggestion;
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnShowCorrectionSuggestionSaveDialogBox;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "suggestion", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/CorrectionSuggestion;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/CorrectionSuggestion;)V", "getSuggestion", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/CorrectionSuggestion;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnShowCorrectionSuggestionSaveDialogBox implements ConversationUiAction {
        public static final int $stable = 0;
        private final CorrectionSuggestion suggestion;

        public static /* synthetic */ OnShowCorrectionSuggestionSaveDialogBox copy$default(OnShowCorrectionSuggestionSaveDialogBox onShowCorrectionSuggestionSaveDialogBox, CorrectionSuggestion correctionSuggestion, int i, Object obj) {
            if ((i & 1) != 0) {
                correctionSuggestion = onShowCorrectionSuggestionSaveDialogBox.suggestion;
            }
            return onShowCorrectionSuggestionSaveDialogBox.copy(correctionSuggestion);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CorrectionSuggestion getSuggestion() {
            return this.suggestion;
        }

        public final OnShowCorrectionSuggestionSaveDialogBox copy(CorrectionSuggestion suggestion) {
            Intrinsics.checkNotNullParameter(suggestion, "suggestion");
            return new OnShowCorrectionSuggestionSaveDialogBox(suggestion);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnShowCorrectionSuggestionSaveDialogBox) && Intrinsics.areEqual(this.suggestion, ((OnShowCorrectionSuggestionSaveDialogBox) other).suggestion);
        }

        public int hashCode() {
            return this.suggestion.hashCode();
        }

        public String toString() {
            return "OnShowCorrectionSuggestionSaveDialogBox(suggestion=" + this.suggestion + ")";
        }

        public OnShowCorrectionSuggestionSaveDialogBox(CorrectionSuggestion correctionSuggestion) {
            Intrinsics.checkNotNullParameter(correctionSuggestion, "suggestion");
            this.suggestion = correctionSuggestion;
        }

        public final CorrectionSuggestion getSuggestion() {
            return this.suggestion;
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnCorrectionSuggestionSaveDismiss;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnCorrectionSuggestionSaveDismiss implements ConversationUiAction {
        public static final int $stable = 0;
        public static final OnCorrectionSuggestionSaveDismiss INSTANCE = new OnCorrectionSuggestionSaveDismiss();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnCorrectionSuggestionSaveDismiss)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1730576560;
        }

        public String toString() {
            return "OnCorrectionSuggestionSaveDismiss";
        }

        private OnCorrectionSuggestionSaveDismiss() {
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnSaveCorrectionSuggestion;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "suggestion", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/CorrectionSuggestion;", "category", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/SuggestionCategory;", "categoryName", "", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/CorrectionSuggestion;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/SuggestionCategory;Ljava/lang/String;)V", "getSuggestion", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/CorrectionSuggestion;", "getCategory", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/SuggestionCategory;", "getCategoryName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnSaveCorrectionSuggestion implements ConversationUiAction {
        public static final int $stable = 0;
        private final SuggestionCategory category;
        private final String categoryName;
        private final CorrectionSuggestion suggestion;

        public static /* synthetic */ OnSaveCorrectionSuggestion copy$default(OnSaveCorrectionSuggestion onSaveCorrectionSuggestion, CorrectionSuggestion correctionSuggestion, SuggestionCategory suggestionCategory, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                correctionSuggestion = onSaveCorrectionSuggestion.suggestion;
            }
            if ((i & 2) != 0) {
                suggestionCategory = onSaveCorrectionSuggestion.category;
            }
            if ((i & 4) != 0) {
                str = onSaveCorrectionSuggestion.categoryName;
            }
            return onSaveCorrectionSuggestion.copy(correctionSuggestion, suggestionCategory, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CorrectionSuggestion getSuggestion() {
            return this.suggestion;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final SuggestionCategory getCategory() {
            return this.category;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getCategoryName() {
            return this.categoryName;
        }

        public final OnSaveCorrectionSuggestion copy(CorrectionSuggestion suggestion, SuggestionCategory category, String categoryName) {
            Intrinsics.checkNotNullParameter(suggestion, "suggestion");
            Intrinsics.checkNotNullParameter(categoryName, "categoryName");
            return new OnSaveCorrectionSuggestion(suggestion, category, categoryName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnSaveCorrectionSuggestion)) {
                return false;
            }
            OnSaveCorrectionSuggestion onSaveCorrectionSuggestion = (OnSaveCorrectionSuggestion) other;
            return Intrinsics.areEqual(this.suggestion, onSaveCorrectionSuggestion.suggestion) && Intrinsics.areEqual(this.category, onSaveCorrectionSuggestion.category) && Intrinsics.areEqual(this.categoryName, onSaveCorrectionSuggestion.categoryName);
        }

        public int hashCode() {
            int iHashCode = this.suggestion.hashCode() * 31;
            SuggestionCategory suggestionCategory = this.category;
            return ((iHashCode + (suggestionCategory == null ? 0 : suggestionCategory.hashCode())) * 31) + this.categoryName.hashCode();
        }

        public String toString() {
            return "OnSaveCorrectionSuggestion(suggestion=" + this.suggestion + ", category=" + this.category + ", categoryName=" + this.categoryName + ")";
        }

        public OnSaveCorrectionSuggestion(CorrectionSuggestion correctionSuggestion, SuggestionCategory suggestionCategory, String str) {
            Intrinsics.checkNotNullParameter(correctionSuggestion, "suggestion");
            Intrinsics.checkNotNullParameter(str, "categoryName");
            this.suggestion = correctionSuggestion;
            this.category = suggestionCategory;
            this.categoryName = str;
        }

        public final SuggestionCategory getCategory() {
            return this.category;
        }

        public final String getCategoryName() {
            return this.categoryName;
        }

        public final CorrectionSuggestion getSuggestion() {
            return this.suggestion;
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnDeleteSuggestion;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "suggestion", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/ConversationSuggestion;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/ConversationSuggestion;)V", "getSuggestion", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/ConversationSuggestion;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnDeleteSuggestion implements ConversationUiAction {
        public static final int $stable = 0;
        private final ConversationSuggestion suggestion;

        public static /* synthetic */ OnDeleteSuggestion copy$default(OnDeleteSuggestion onDeleteSuggestion, ConversationSuggestion conversationSuggestion, int i, Object obj) {
            if ((i & 1) != 0) {
                conversationSuggestion = onDeleteSuggestion.suggestion;
            }
            return onDeleteSuggestion.copy(conversationSuggestion);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ConversationSuggestion getSuggestion() {
            return this.suggestion;
        }

        public final OnDeleteSuggestion copy(ConversationSuggestion suggestion) {
            Intrinsics.checkNotNullParameter(suggestion, "suggestion");
            return new OnDeleteSuggestion(suggestion);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnDeleteSuggestion) && Intrinsics.areEqual(this.suggestion, ((OnDeleteSuggestion) other).suggestion);
        }

        public int hashCode() {
            return this.suggestion.hashCode();
        }

        public String toString() {
            return "OnDeleteSuggestion(suggestion=" + this.suggestion + ")";
        }

        public OnDeleteSuggestion(ConversationSuggestion conversationSuggestion) {
            Intrinsics.checkNotNullParameter(conversationSuggestion, "suggestion");
            this.suggestion = conversationSuggestion;
        }

        public final ConversationSuggestion getSuggestion() {
            return this.suggestion;
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnDeleteCategory;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "category", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/SuggestionCategory;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/SuggestionCategory;)V", "getCategory", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/SuggestionCategory;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnDeleteCategory implements ConversationUiAction {
        public static final int $stable = 0;
        private final SuggestionCategory category;

        public static /* synthetic */ OnDeleteCategory copy$default(OnDeleteCategory onDeleteCategory, SuggestionCategory suggestionCategory, int i, Object obj) {
            if ((i & 1) != 0) {
                suggestionCategory = onDeleteCategory.category;
            }
            return onDeleteCategory.copy(suggestionCategory);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final SuggestionCategory getCategory() {
            return this.category;
        }

        public final OnDeleteCategory copy(SuggestionCategory category) {
            Intrinsics.checkNotNullParameter(category, "category");
            return new OnDeleteCategory(category);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnDeleteCategory) && Intrinsics.areEqual(this.category, ((OnDeleteCategory) other).category);
        }

        public int hashCode() {
            return this.category.hashCode();
        }

        public String toString() {
            return "OnDeleteCategory(category=" + this.category + ")";
        }

        public OnDeleteCategory(SuggestionCategory suggestionCategory) {
            Intrinsics.checkNotNullParameter(suggestionCategory, "category");
            this.category = suggestionCategory;
        }

        public final SuggestionCategory getCategory() {
            return this.category;
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnShowDrawer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "drawer", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationDrawer;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationDrawer;)V", "getDrawer", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationDrawer;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnShowDrawer implements ConversationUiAction {
        public static final int $stable = 8;
        private final ConversationDrawer drawer;

        public static /* synthetic */ OnShowDrawer copy$default(OnShowDrawer onShowDrawer, ConversationDrawer conversationDrawer, int i, Object obj) {
            if ((i & 1) != 0) {
                conversationDrawer = onShowDrawer.drawer;
            }
            return onShowDrawer.copy(conversationDrawer);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ConversationDrawer getDrawer() {
            return this.drawer;
        }

        public final OnShowDrawer copy(ConversationDrawer drawer) {
            Intrinsics.checkNotNullParameter(drawer, "drawer");
            return new OnShowDrawer(drawer);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnShowDrawer) && Intrinsics.areEqual(this.drawer, ((OnShowDrawer) other).drawer);
        }

        public int hashCode() {
            return this.drawer.hashCode();
        }

        public String toString() {
            return "OnShowDrawer(drawer=" + this.drawer + ")";
        }

        public OnShowDrawer(ConversationDrawer conversationDrawer) {
            Intrinsics.checkNotNullParameter(conversationDrawer, "drawer");
            this.drawer = conversationDrawer;
        }

        public final ConversationDrawer getDrawer() {
            return this.drawer;
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnHideDrawer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnHideDrawer implements ConversationUiAction {
        public static final int $stable = 0;
        public static final OnHideDrawer INSTANCE = new OnHideDrawer();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnHideDrawer)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1139806542;
        }

        public String toString() {
            return "OnHideDrawer";
        }

        private OnHideDrawer() {
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnToggleInputSuggestion;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnToggleInputSuggestion implements ConversationUiAction {
        public static final int $stable = 0;
        public static final OnToggleInputSuggestion INSTANCE = new OnToggleInputSuggestion();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnToggleInputSuggestion)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1452695583;
        }

        public String toString() {
            return "OnToggleInputSuggestion";
        }

        private OnToggleInputSuggestion() {
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnSwitchConversationMode;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "mode", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;)V", "getMode", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnSwitchConversationMode implements ConversationUiAction {
        public static final int $stable = 0;
        private final ConversationMode mode;

        public static /* synthetic */ OnSwitchConversationMode copy$default(OnSwitchConversationMode onSwitchConversationMode, ConversationMode conversationMode, int i, Object obj) {
            if ((i & 1) != 0) {
                conversationMode = onSwitchConversationMode.mode;
            }
            return onSwitchConversationMode.copy(conversationMode);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ConversationMode getMode() {
            return this.mode;
        }

        public final OnSwitchConversationMode copy(ConversationMode mode) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            return new OnSwitchConversationMode(mode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnSwitchConversationMode) && this.mode == ((OnSwitchConversationMode) other).mode;
        }

        public int hashCode() {
            return this.mode.hashCode();
        }

        public String toString() {
            return "OnSwitchConversationMode(mode=" + this.mode + ")";
        }

        public OnSwitchConversationMode(ConversationMode conversationMode) {
            Intrinsics.checkNotNullParameter(conversationMode, "mode");
            this.mode = conversationMode;
        }

        public final ConversationMode getMode() {
            return this.mode;
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnInterpretScannedDocument;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "scannedText", "", "<init>", "(Ljava/lang/String;)V", "getScannedText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnInterpretScannedDocument implements ConversationUiAction {
        public static final int $stable = 0;
        private final String scannedText;

        public static /* synthetic */ OnInterpretScannedDocument copy$default(OnInterpretScannedDocument onInterpretScannedDocument, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = onInterpretScannedDocument.scannedText;
            }
            return onInterpretScannedDocument.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getScannedText() {
            return this.scannedText;
        }

        public final OnInterpretScannedDocument copy(String scannedText) {
            Intrinsics.checkNotNullParameter(scannedText, "scannedText");
            return new OnInterpretScannedDocument(scannedText);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnInterpretScannedDocument) && Intrinsics.areEqual(this.scannedText, ((OnInterpretScannedDocument) other).scannedText);
        }

        public int hashCode() {
            return this.scannedText.hashCode();
        }

        public String toString() {
            return "OnInterpretScannedDocument(scannedText=" + this.scannedText + ")";
        }

        public OnInterpretScannedDocument(String str) {
            Intrinsics.checkNotNullParameter(str, "scannedText");
            this.scannedText = str;
        }

        public final String getScannedText() {
            return this.scannedText;
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnOpenDocumentScanner;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnOpenDocumentScanner implements ConversationUiAction {
        public static final int $stable = 0;
        public static final OnOpenDocumentScanner INSTANCE = new OnOpenDocumentScanner();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnOpenDocumentScanner)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1150820706;
        }

        public String toString() {
            return "OnOpenDocumentScanner";
        }

        private OnOpenDocumentScanner() {
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnBubbleLongPress;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "conversationMessage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;)V", "getConversationMessage", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnBubbleLongPress implements ConversationUiAction {
        public static final int $stable = 0;
        private final ConversationMessage conversationMessage;

        public static /* synthetic */ OnBubbleLongPress copy$default(OnBubbleLongPress onBubbleLongPress, ConversationMessage conversationMessage, int i, Object obj) {
            if ((i & 1) != 0) {
                conversationMessage = onBubbleLongPress.conversationMessage;
            }
            return onBubbleLongPress.copy(conversationMessage);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ConversationMessage getConversationMessage() {
            return this.conversationMessage;
        }

        public final OnBubbleLongPress copy(ConversationMessage conversationMessage) {
            Intrinsics.checkNotNullParameter(conversationMessage, "conversationMessage");
            return new OnBubbleLongPress(conversationMessage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnBubbleLongPress) && Intrinsics.areEqual(this.conversationMessage, ((OnBubbleLongPress) other).conversationMessage);
        }

        public int hashCode() {
            return this.conversationMessage.hashCode();
        }

        public String toString() {
            return "OnBubbleLongPress(conversationMessage=" + this.conversationMessage + ")";
        }

        public OnBubbleLongPress(ConversationMessage conversationMessage) {
            Intrinsics.checkNotNullParameter(conversationMessage, "conversationMessage");
            this.conversationMessage = conversationMessage;
        }

        public final ConversationMessage getConversationMessage() {
            return this.conversationMessage;
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnInputTextChange;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnInputTextChange implements ConversationUiAction {
        public static final int $stable = 0;
        private final String text;

        /* JADX WARN: Illegal instructions before constructor call */
        public OnInputTextChange() {
            String str = null;
            this(str, 1, str);
        }

        public static /* synthetic */ OnInputTextChange copy$default(OnInputTextChange onInputTextChange, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = onInputTextChange.text;
            }
            return onInputTextChange.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final OnInputTextChange copy(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new OnInputTextChange(text);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnInputTextChange) && Intrinsics.areEqual(this.text, ((OnInputTextChange) other).text);
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return "OnInputTextChange(text=" + this.text + ")";
        }

        public OnInputTextChange(String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            this.text = str;
        }

        public /* synthetic */ OnInputTextChange(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        public final String getText() {
            return this.text;
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnSearchQueryChange;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "query", "", "<init>", "(Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnSearchQueryChange implements ConversationUiAction {
        public static final int $stable = 0;
        private final String query;

        public static /* synthetic */ OnSearchQueryChange copy$default(OnSearchQueryChange onSearchQueryChange, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = onSearchQueryChange.query;
            }
            return onSearchQueryChange.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getQuery() {
            return this.query;
        }

        public final OnSearchQueryChange copy(String query) {
            Intrinsics.checkNotNullParameter(query, "query");
            return new OnSearchQueryChange(query);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnSearchQueryChange) && Intrinsics.areEqual(this.query, ((OnSearchQueryChange) other).query);
        }

        public int hashCode() {
            return this.query.hashCode();
        }

        public String toString() {
            return "OnSearchQueryChange(query=" + this.query + ")";
        }

        public OnSearchQueryChange(String str) {
            Intrinsics.checkNotNullParameter(str, "query");
            this.query = str;
        }

        public final String getQuery() {
            return this.query;
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$UpdateConversationName;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "newName", "", "<init>", "(Ljava/lang/String;)V", "getNewName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UpdateConversationName implements ConversationUiAction {
        public static final int $stable = 0;
        private final String newName;

        public static /* synthetic */ UpdateConversationName copy$default(UpdateConversationName updateConversationName, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = updateConversationName.newName;
            }
            return updateConversationName.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getNewName() {
            return this.newName;
        }

        public final UpdateConversationName copy(String newName) {
            Intrinsics.checkNotNullParameter(newName, "newName");
            return new UpdateConversationName(newName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof UpdateConversationName) && Intrinsics.areEqual(this.newName, ((UpdateConversationName) other).newName);
        }

        public int hashCode() {
            return this.newName.hashCode();
        }

        public String toString() {
            return "UpdateConversationName(newName=" + this.newName + ")";
        }

        public UpdateConversationName(String str) {
            Intrinsics.checkNotNullParameter(str, "newName");
            this.newName = str;
        }

        public final String getNewName() {
            return this.newName;
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnToggleWebViewMinimization;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnToggleWebViewMinimization implements ConversationUiAction {
        public static final int $stable = 0;
        public static final OnToggleWebViewMinimization INSTANCE = new OnToggleWebViewMinimization();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnToggleWebViewMinimization)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1296808344;
        }

        public String toString() {
            return "OnToggleWebViewMinimization";
        }

        private OnToggleWebViewMinimization() {
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnRestoreWebView;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnRestoreWebView implements ConversationUiAction {
        public static final int $stable = 0;
        public static final OnRestoreWebView INSTANCE = new OnRestoreWebView();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnRestoreWebView)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 261237926;
        }

        public String toString() {
            return "OnRestoreWebView";
        }

        private OnRestoreWebView() {
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnShowSpeakerLanguageDialog;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnShowSpeakerLanguageDialog implements ConversationUiAction {
        public static final int $stable = 0;
        public static final OnShowSpeakerLanguageDialog INSTANCE = new OnShowSpeakerLanguageDialog();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnShowSpeakerLanguageDialog)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1857377223;
        }

        public String toString() {
            return "OnShowSpeakerLanguageDialog";
        }

        private OnShowSpeakerLanguageDialog() {
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnSetSpeakerLanguageAndStartInterpretation;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "speakerLang", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;)V", "getSpeakerLang", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnSetSpeakerLanguageAndStartInterpretation implements ConversationUiAction {
        public static final int $stable = 0;
        private final LanguageEnum speakerLang;

        public static /* synthetic */ OnSetSpeakerLanguageAndStartInterpretation copy$default(OnSetSpeakerLanguageAndStartInterpretation onSetSpeakerLanguageAndStartInterpretation, LanguageEnum languageEnum, int i, Object obj) {
            if ((i & 1) != 0) {
                languageEnum = onSetSpeakerLanguageAndStartInterpretation.speakerLang;
            }
            return onSetSpeakerLanguageAndStartInterpretation.copy(languageEnum);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final LanguageEnum getSpeakerLang() {
            return this.speakerLang;
        }

        public final OnSetSpeakerLanguageAndStartInterpretation copy(LanguageEnum speakerLang) {
            Intrinsics.checkNotNullParameter(speakerLang, "speakerLang");
            return new OnSetSpeakerLanguageAndStartInterpretation(speakerLang);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnSetSpeakerLanguageAndStartInterpretation) && this.speakerLang == ((OnSetSpeakerLanguageAndStartInterpretation) other).speakerLang;
        }

        public int hashCode() {
            return this.speakerLang.hashCode();
        }

        public String toString() {
            return "OnSetSpeakerLanguageAndStartInterpretation(speakerLang=" + this.speakerLang + ")";
        }

        public OnSetSpeakerLanguageAndStartInterpretation(LanguageEnum languageEnum) {
            Intrinsics.checkNotNullParameter(languageEnum, "speakerLang");
            this.speakerLang = languageEnum;
        }

        public final LanguageEnum getSpeakerLang() {
            return this.speakerLang;
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnMicrophonePermissionGranted;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnMicrophonePermissionGranted implements ConversationUiAction {
        public static final int $stable = 0;
        public static final OnMicrophonePermissionGranted INSTANCE = new OnMicrophonePermissionGranted();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnMicrophonePermissionGranted)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -108646713;
        }

        public String toString() {
            return "OnMicrophonePermissionGranted";
        }

        private OnMicrophonePermissionGranted() {
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnMinimizeWebView;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnMinimizeWebView implements ConversationUiAction {
        public static final int $stable = 0;
        public static final OnMinimizeWebView INSTANCE = new OnMinimizeWebView();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnMinimizeWebView)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -462995456;
        }

        public String toString() {
            return "OnMinimizeWebView";
        }

        private OnMinimizeWebView() {
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnSetSpeakerLanguage;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "speakerLang", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;)V", "getSpeakerLang", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnSetSpeakerLanguage implements ConversationUiAction {
        public static final int $stable = 0;
        private final LanguageEnum speakerLang;

        public static /* synthetic */ OnSetSpeakerLanguage copy$default(OnSetSpeakerLanguage onSetSpeakerLanguage, LanguageEnum languageEnum, int i, Object obj) {
            if ((i & 1) != 0) {
                languageEnum = onSetSpeakerLanguage.speakerLang;
            }
            return onSetSpeakerLanguage.copy(languageEnum);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final LanguageEnum getSpeakerLang() {
            return this.speakerLang;
        }

        public final OnSetSpeakerLanguage copy(LanguageEnum speakerLang) {
            Intrinsics.checkNotNullParameter(speakerLang, "speakerLang");
            return new OnSetSpeakerLanguage(speakerLang);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnSetSpeakerLanguage) && this.speakerLang == ((OnSetSpeakerLanguage) other).speakerLang;
        }

        public int hashCode() {
            return this.speakerLang.hashCode();
        }

        public String toString() {
            return "OnSetSpeakerLanguage(speakerLang=" + this.speakerLang + ")";
        }

        public OnSetSpeakerLanguage(LanguageEnum languageEnum) {
            Intrinsics.checkNotNullParameter(languageEnum, "speakerLang");
            this.speakerLang = languageEnum;
        }

        public final LanguageEnum getSpeakerLang() {
            return this.speakerLang;
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnSetUserLanguage;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "userLang", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;)V", "getUserLang", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnSetUserLanguage implements ConversationUiAction {
        public static final int $stable = 0;
        private final LanguageEnum userLang;

        public static /* synthetic */ OnSetUserLanguage copy$default(OnSetUserLanguage onSetUserLanguage, LanguageEnum languageEnum, int i, Object obj) {
            if ((i & 1) != 0) {
                languageEnum = onSetUserLanguage.userLang;
            }
            return onSetUserLanguage.copy(languageEnum);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final LanguageEnum getUserLang() {
            return this.userLang;
        }

        public final OnSetUserLanguage copy(LanguageEnum userLang) {
            Intrinsics.checkNotNullParameter(userLang, "userLang");
            return new OnSetUserLanguage(userLang);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnSetUserLanguage) && this.userLang == ((OnSetUserLanguage) other).userLang;
        }

        public int hashCode() {
            return this.userLang.hashCode();
        }

        public String toString() {
            return "OnSetUserLanguage(userLang=" + this.userLang + ")";
        }

        public OnSetUserLanguage(LanguageEnum languageEnum) {
            Intrinsics.checkNotNullParameter(languageEnum, "userLang");
            this.userLang = languageEnum;
        }

        public final LanguageEnum getUserLang() {
            return this.userLang;
        }
    }
}
