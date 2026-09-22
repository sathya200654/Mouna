package com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.MessageInputType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpeechRecognizerEvent.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/model/SpeechRecognizerEvent;", "", "Recognized", "Error", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/model/SpeechRecognizerEvent$Error;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/model/SpeechRecognizerEvent$Recognized;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SpeechRecognizerEvent {

    /* JADX INFO: compiled from: SpeechRecognizerEvent.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/model/SpeechRecognizerEvent$Recognized;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/model/SpeechRecognizerEvent;", "text", "", "processedText", "textLanguage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "processedTextLanguage", "userName", "inputType", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/MessageInputType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Ljava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/MessageInputType;)V", "getText", "()Ljava/lang/String;", "getProcessedText", "getTextLanguage", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "getProcessedTextLanguage", "getUserName", "getInputType", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/MessageInputType;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Recognized implements SpeechRecognizerEvent {
        public static final int $stable = 0;
        private final MessageInputType inputType;
        private final String processedText;
        private final LanguageEnum processedTextLanguage;
        private final String text;
        private final LanguageEnum textLanguage;
        private final String userName;

        public static /* synthetic */ Recognized copy$default(Recognized recognized, String str, String str2, LanguageEnum languageEnum, LanguageEnum languageEnum2, String str3, MessageInputType messageInputType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = recognized.text;
            }
            if ((i & 2) != 0) {
                str2 = recognized.processedText;
            }
            if ((i & 4) != 0) {
                languageEnum = recognized.textLanguage;
            }
            if ((i & 8) != 0) {
                languageEnum2 = recognized.processedTextLanguage;
            }
            if ((i & 16) != 0) {
                str3 = recognized.userName;
            }
            if ((i & 32) != 0) {
                messageInputType = recognized.inputType;
            }
            String str4 = str3;
            MessageInputType messageInputType2 = messageInputType;
            return recognized.copy(str, str2, languageEnum, languageEnum2, str4, messageInputType2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getProcessedText() {
            return this.processedText;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final LanguageEnum getTextLanguage() {
            return this.textLanguage;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final LanguageEnum getProcessedTextLanguage() {
            return this.processedTextLanguage;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getUserName() {
            return this.userName;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final MessageInputType getInputType() {
            return this.inputType;
        }

        public final Recognized copy(String text, String processedText, LanguageEnum textLanguage, LanguageEnum processedTextLanguage, String userName, MessageInputType inputType) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(processedText, "processedText");
            Intrinsics.checkNotNullParameter(textLanguage, "textLanguage");
            Intrinsics.checkNotNullParameter(processedTextLanguage, "processedTextLanguage");
            Intrinsics.checkNotNullParameter(userName, "userName");
            Intrinsics.checkNotNullParameter(inputType, "inputType");
            return new Recognized(text, processedText, textLanguage, processedTextLanguage, userName, inputType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Recognized)) {
                return false;
            }
            Recognized recognized = (Recognized) other;
            return Intrinsics.areEqual(this.text, recognized.text) && Intrinsics.areEqual(this.processedText, recognized.processedText) && this.textLanguage == recognized.textLanguage && this.processedTextLanguage == recognized.processedTextLanguage && Intrinsics.areEqual(this.userName, recognized.userName) && this.inputType == recognized.inputType;
        }

        public int hashCode() {
            return (((((((((this.text.hashCode() * 31) + this.processedText.hashCode()) * 31) + this.textLanguage.hashCode()) * 31) + this.processedTextLanguage.hashCode()) * 31) + this.userName.hashCode()) * 31) + this.inputType.hashCode();
        }

        public String toString() {
            return "Recognized(text=" + this.text + ", processedText=" + this.processedText + ", textLanguage=" + this.textLanguage + ", processedTextLanguage=" + this.processedTextLanguage + ", userName=" + this.userName + ", inputType=" + this.inputType + ")";
        }

        public Recognized(String str, String str2, LanguageEnum languageEnum, LanguageEnum languageEnum2, String str3, MessageInputType messageInputType) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(str2, "processedText");
            Intrinsics.checkNotNullParameter(languageEnum, "textLanguage");
            Intrinsics.checkNotNullParameter(languageEnum2, "processedTextLanguage");
            Intrinsics.checkNotNullParameter(str3, "userName");
            Intrinsics.checkNotNullParameter(messageInputType, "inputType");
            this.text = str;
            this.processedText = str2;
            this.textLanguage = languageEnum;
            this.processedTextLanguage = languageEnum2;
            this.userName = str3;
            this.inputType = messageInputType;
        }

        public final String getText() {
            return this.text;
        }

        public final String getProcessedText() {
            return this.processedText;
        }

        public final LanguageEnum getTextLanguage() {
            return this.textLanguage;
        }

        public final LanguageEnum getProcessedTextLanguage() {
            return this.processedTextLanguage;
        }

        public /* synthetic */ Recognized(String str, String str2, LanguageEnum languageEnum, LanguageEnum languageEnum2, String str3, MessageInputType messageInputType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, languageEnum, languageEnum2, (i & 16) != 0 ? "User" : str3, (i & 32) != 0 ? MessageInputType.SPOKEN : messageInputType);
        }

        public final String getUserName() {
            return this.userName;
        }

        public final MessageInputType getInputType() {
            return this.inputType;
        }
    }

    /* JADX INFO: compiled from: SpeechRecognizerEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/model/SpeechRecognizerEvent$Error;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/model/SpeechRecognizerEvent;", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/model/SpeechErrorType;", "debugMessage", "", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/model/SpeechErrorType;Ljava/lang/String;)V", "getType", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/model/SpeechErrorType;", "getDebugMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Error implements SpeechRecognizerEvent {
        public static final int $stable = 0;
        private final String debugMessage;
        private final SpeechErrorType type;

        public static /* synthetic */ Error copy$default(Error error, SpeechErrorType speechErrorType, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                speechErrorType = error.type;
            }
            if ((i & 2) != 0) {
                str = error.debugMessage;
            }
            return error.copy(speechErrorType, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final SpeechErrorType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getDebugMessage() {
            return this.debugMessage;
        }

        public final Error copy(SpeechErrorType type, String debugMessage) {
            Intrinsics.checkNotNullParameter(type, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            return new Error(type, debugMessage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return this.type == error.type && Intrinsics.areEqual(this.debugMessage, error.debugMessage);
        }

        public int hashCode() {
            int iHashCode = this.type.hashCode() * 31;
            String str = this.debugMessage;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Error(type=" + this.type + ", debugMessage=" + this.debugMessage + ")";
        }

        public Error(SpeechErrorType speechErrorType, String str) {
            Intrinsics.checkNotNullParameter(speechErrorType, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            this.type = speechErrorType;
            this.debugMessage = str;
        }

        public /* synthetic */ Error(SpeechErrorType speechErrorType, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(speechErrorType, (i & 2) != 0 ? null : str);
        }

        public final SpeechErrorType getType() {
            return this.type;
        }

        public final String getDebugMessage() {
            return this.debugMessage;
        }
    }
}
