package com.deepvisiontech.letstalksigntranscriptionapp.current.core.texttospeech;

import android.speech.tts.Voice;
import com.deepvisiontech.letstalksigntranscriptionapp.legacy.ui.enums.TranscriptionLang;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextToSpeechManager.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JK\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerState;", "", "isInitialized", "", "isSpeaking", "isSynthesizing", "lastSpokenText", "", "lastSpokenTextLanguage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/legacy/ui/enums/TranscriptionLang;", "voices", "", "Landroid/speech/tts/Voice;", "<init>", "(ZZZLjava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/legacy/ui/enums/TranscriptionLang;Ljava/util/List;)V", "()Z", "getLastSpokenText", "()Ljava/lang/String;", "getLastSpokenTextLanguage", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/legacy/ui/enums/TranscriptionLang;", "getVoices", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TextToSpeechManagerState {
    public static final int $stable = 8;
    private final boolean isInitialized;
    private final boolean isSpeaking;
    private final boolean isSynthesizing;
    private final String lastSpokenText;
    private final TranscriptionLang lastSpokenTextLanguage;
    private final List<Voice> voices;

    public TextToSpeechManagerState() {
        this(false, false, false, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextToSpeechManagerState copy$default(TextToSpeechManagerState textToSpeechManagerState, boolean z, boolean z2, boolean z3, String str, TranscriptionLang transcriptionLang, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = textToSpeechManagerState.isInitialized;
        }
        if ((i & 2) != 0) {
            z2 = textToSpeechManagerState.isSpeaking;
        }
        if ((i & 4) != 0) {
            z3 = textToSpeechManagerState.isSynthesizing;
        }
        if ((i & 8) != 0) {
            str = textToSpeechManagerState.lastSpokenText;
        }
        if ((i & 16) != 0) {
            transcriptionLang = textToSpeechManagerState.lastSpokenTextLanguage;
        }
        if ((i & 32) != 0) {
            list = textToSpeechManagerState.voices;
        }
        TranscriptionLang transcriptionLang2 = transcriptionLang;
        List list2 = list;
        return textToSpeechManagerState.copy(z, z2, z3, str, transcriptionLang2, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsInitialized() {
        return this.isInitialized;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsSpeaking() {
        return this.isSpeaking;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsSynthesizing() {
        return this.isSynthesizing;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLastSpokenText() {
        return this.lastSpokenText;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final TranscriptionLang getLastSpokenTextLanguage() {
        return this.lastSpokenTextLanguage;
    }

    public final List<Voice> component6() {
        return this.voices;
    }

    public final TextToSpeechManagerState copy(boolean isInitialized, boolean isSpeaking, boolean isSynthesizing, String lastSpokenText, TranscriptionLang lastSpokenTextLanguage, List<? extends Voice> voices) {
        Intrinsics.checkNotNullParameter(lastSpokenText, "lastSpokenText");
        Intrinsics.checkNotNullParameter(lastSpokenTextLanguage, "lastSpokenTextLanguage");
        Intrinsics.checkNotNullParameter(voices, "voices");
        return new TextToSpeechManagerState(isInitialized, isSpeaking, isSynthesizing, lastSpokenText, lastSpokenTextLanguage, voices);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextToSpeechManagerState)) {
            return false;
        }
        TextToSpeechManagerState textToSpeechManagerState = (TextToSpeechManagerState) other;
        return this.isInitialized == textToSpeechManagerState.isInitialized && this.isSpeaking == textToSpeechManagerState.isSpeaking && this.isSynthesizing == textToSpeechManagerState.isSynthesizing && Intrinsics.areEqual(this.lastSpokenText, textToSpeechManagerState.lastSpokenText) && this.lastSpokenTextLanguage == textToSpeechManagerState.lastSpokenTextLanguage && Intrinsics.areEqual(this.voices, textToSpeechManagerState.voices);
    }

    public int hashCode() {
        return (((((((((Boolean.hashCode(this.isInitialized) * 31) + Boolean.hashCode(this.isSpeaking)) * 31) + Boolean.hashCode(this.isSynthesizing)) * 31) + this.lastSpokenText.hashCode()) * 31) + this.lastSpokenTextLanguage.hashCode()) * 31) + this.voices.hashCode();
    }

    public String toString() {
        return "TextToSpeechManagerState(isInitialized=" + this.isInitialized + ", isSpeaking=" + this.isSpeaking + ", isSynthesizing=" + this.isSynthesizing + ", lastSpokenText=" + this.lastSpokenText + ", lastSpokenTextLanguage=" + this.lastSpokenTextLanguage + ", voices=" + this.voices + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextToSpeechManagerState(boolean z, boolean z2, boolean z3, String str, TranscriptionLang transcriptionLang, List<? extends Voice> list) {
        Intrinsics.checkNotNullParameter(str, "lastSpokenText");
        Intrinsics.checkNotNullParameter(transcriptionLang, "lastSpokenTextLanguage");
        Intrinsics.checkNotNullParameter(list, "voices");
        this.isInitialized = z;
        this.isSpeaking = z2;
        this.isSynthesizing = z3;
        this.lastSpokenText = str;
        this.lastSpokenTextLanguage = transcriptionLang;
        this.voices = list;
    }

    public final boolean isInitialized() {
        return this.isInitialized;
    }

    public final boolean isSpeaking() {
        return this.isSpeaking;
    }

    public final boolean isSynthesizing() {
        return this.isSynthesizing;
    }

    public /* synthetic */ TextToSpeechManagerState(boolean z, boolean z2, boolean z3, String str, TranscriptionLang transcriptionLang, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? "" : str, (i & 16) != 0 ? TranscriptionLang.English : transcriptionLang, (i & 32) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getLastSpokenText() {
        return this.lastSpokenText;
    }

    public final TranscriptionLang getLastSpokenTextLanguage() {
        return this.lastSpokenTextLanguage;
    }

    public final List<Voice> getVoices() {
        return this.voices;
    }
}
