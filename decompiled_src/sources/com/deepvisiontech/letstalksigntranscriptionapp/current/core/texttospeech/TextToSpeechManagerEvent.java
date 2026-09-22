package com.deepvisiontech.letstalksigntranscriptionapp.current.core.texttospeech;

import android.net.Uri;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextToSpeechManager.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerEvent;", "", "Error", "SynthesisResult", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerEvent$Error;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerEvent$SynthesisResult;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface TextToSpeechManagerEvent {

    /* JADX INFO: compiled from: TextToSpeechManager.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerEvent$Error;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerEvent;", "InitializationFailed", "LanguageNotSupported", "OperationFailed", "SynthesisFailed", "SynthesisInProgress", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerEvent$Error$InitializationFailed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerEvent$Error$LanguageNotSupported;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerEvent$Error$OperationFailed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerEvent$Error$SynthesisFailed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerEvent$Error$SynthesisInProgress;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Error extends TextToSpeechManagerEvent {

        /* JADX INFO: compiled from: TextToSpeechManager.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerEvent$Error$InitializationFailed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerEvent$Error;", "reason", "", "<init>", "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class InitializationFailed implements Error {
            public static final int $stable = 0;
            private final String reason;

            public static /* synthetic */ InitializationFailed copy$default(InitializationFailed initializationFailed, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = initializationFailed.reason;
                }
                return initializationFailed.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getReason() {
                return this.reason;
            }

            public final InitializationFailed copy(String reason) {
                Intrinsics.checkNotNullParameter(reason, "reason");
                return new InitializationFailed(reason);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof InitializationFailed) && Intrinsics.areEqual(this.reason, ((InitializationFailed) other).reason);
            }

            public int hashCode() {
                return this.reason.hashCode();
            }

            public String toString() {
                return "InitializationFailed(reason=" + this.reason + ")";
            }

            public InitializationFailed(String str) {
                Intrinsics.checkNotNullParameter(str, "reason");
                this.reason = str;
            }

            public final String getReason() {
                return this.reason;
            }
        }

        /* JADX INFO: compiled from: TextToSpeechManager.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerEvent$Error$LanguageNotSupported;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerEvent$Error;", "locale", "Ljava/util/Locale;", "<init>", "(Ljava/util/Locale;)V", "getLocale", "()Ljava/util/Locale;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LanguageNotSupported implements Error {
            public static final int $stable = 8;
            private final Locale locale;

            public static /* synthetic */ LanguageNotSupported copy$default(LanguageNotSupported languageNotSupported, Locale locale, int i, Object obj) {
                if ((i & 1) != 0) {
                    locale = languageNotSupported.locale;
                }
                return languageNotSupported.copy(locale);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Locale getLocale() {
                return this.locale;
            }

            public final LanguageNotSupported copy(Locale locale) {
                Intrinsics.checkNotNullParameter(locale, "locale");
                return new LanguageNotSupported(locale);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof LanguageNotSupported) && Intrinsics.areEqual(this.locale, ((LanguageNotSupported) other).locale);
            }

            public int hashCode() {
                return this.locale.hashCode();
            }

            public String toString() {
                return "LanguageNotSupported(locale=" + this.locale + ")";
            }

            public LanguageNotSupported(Locale locale) {
                Intrinsics.checkNotNullParameter(locale, "locale");
                this.locale = locale;
            }

            public final Locale getLocale() {
                return this.locale;
            }
        }

        /* JADX INFO: compiled from: TextToSpeechManager.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerEvent$Error$OperationFailed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerEvent$Error;", "reason", "", "<init>", "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OperationFailed implements Error {
            public static final int $stable = 0;
            private final String reason;

            public static /* synthetic */ OperationFailed copy$default(OperationFailed operationFailed, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = operationFailed.reason;
                }
                return operationFailed.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getReason() {
                return this.reason;
            }

            public final OperationFailed copy(String reason) {
                Intrinsics.checkNotNullParameter(reason, "reason");
                return new OperationFailed(reason);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof OperationFailed) && Intrinsics.areEqual(this.reason, ((OperationFailed) other).reason);
            }

            public int hashCode() {
                return this.reason.hashCode();
            }

            public String toString() {
                return "OperationFailed(reason=" + this.reason + ")";
            }

            public OperationFailed(String str) {
                Intrinsics.checkNotNullParameter(str, "reason");
                this.reason = str;
            }

            public final String getReason() {
                return this.reason;
            }
        }

        /* JADX INFO: compiled from: TextToSpeechManager.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerEvent$Error$SynthesisFailed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerEvent$Error;", "utteranceId", "", "errorCode", "", "<init>", "(Ljava/lang/String;I)V", "getUtteranceId", "()Ljava/lang/String;", "getErrorCode", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SynthesisFailed implements Error {
            public static final int $stable = 0;
            private final int errorCode;
            private final String utteranceId;

            public static /* synthetic */ SynthesisFailed copy$default(SynthesisFailed synthesisFailed, String str, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = synthesisFailed.utteranceId;
                }
                if ((i2 & 2) != 0) {
                    i = synthesisFailed.errorCode;
                }
                return synthesisFailed.copy(str, i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getUtteranceId() {
                return this.utteranceId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getErrorCode() {
                return this.errorCode;
            }

            public final SynthesisFailed copy(String utteranceId, int errorCode) {
                return new SynthesisFailed(utteranceId, errorCode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SynthesisFailed)) {
                    return false;
                }
                SynthesisFailed synthesisFailed = (SynthesisFailed) other;
                return Intrinsics.areEqual(this.utteranceId, synthesisFailed.utteranceId) && this.errorCode == synthesisFailed.errorCode;
            }

            public int hashCode() {
                String str = this.utteranceId;
                return ((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.errorCode);
            }

            public String toString() {
                return "SynthesisFailed(utteranceId=" + this.utteranceId + ", errorCode=" + this.errorCode + ")";
            }

            public SynthesisFailed(String str, int i) {
                this.utteranceId = str;
                this.errorCode = i;
            }

            public final int getErrorCode() {
                return this.errorCode;
            }

            public final String getUtteranceId() {
                return this.utteranceId;
            }
        }

        /* JADX INFO: compiled from: TextToSpeechManager.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerEvent$Error$SynthesisInProgress;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerEvent$Error;", "<init>", "()V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class SynthesisInProgress implements Error {
            public static final int $stable = 0;
            public static final SynthesisInProgress INSTANCE = new SynthesisInProgress();

            private SynthesisInProgress() {
            }
        }
    }

    /* JADX INFO: compiled from: TextToSpeechManager.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerEvent$SynthesisResult;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerEvent;", "uri", "Landroid/net/Uri;", "utteranceId", "", "<init>", "(Landroid/net/Uri;Ljava/lang/String;)V", "getUri", "()Landroid/net/Uri;", "getUtteranceId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SynthesisResult implements TextToSpeechManagerEvent {
        public static final int $stable = 8;
        private final Uri uri;
        private final String utteranceId;

        public static /* synthetic */ SynthesisResult copy$default(SynthesisResult synthesisResult, Uri uri, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                uri = synthesisResult.uri;
            }
            if ((i & 2) != 0) {
                str = synthesisResult.utteranceId;
            }
            return synthesisResult.copy(uri, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Uri getUri() {
            return this.uri;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUtteranceId() {
            return this.utteranceId;
        }

        public final SynthesisResult copy(Uri uri, String utteranceId) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(utteranceId, "utteranceId");
            return new SynthesisResult(uri, utteranceId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SynthesisResult)) {
                return false;
            }
            SynthesisResult synthesisResult = (SynthesisResult) other;
            return Intrinsics.areEqual(this.uri, synthesisResult.uri) && Intrinsics.areEqual(this.utteranceId, synthesisResult.utteranceId);
        }

        public int hashCode() {
            return (this.uri.hashCode() * 31) + this.utteranceId.hashCode();
        }

        public String toString() {
            return "SynthesisResult(uri=" + this.uri + ", utteranceId=" + this.utteranceId + ")";
        }

        public SynthesisResult(Uri uri, String str) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(str, "utteranceId");
            this.uri = uri;
            this.utteranceId = str;
        }

        public final Uri getUri() {
            return this.uri;
        }

        public final String getUtteranceId() {
            return this.utteranceId;
        }
    }
}
