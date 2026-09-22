package com.deepvisiontech.letstalksigntranscriptionapp.current.core.texttospeech;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.speech.tts.Voice;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.legacy.ui.enums.TranscriptionLang;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.io.File;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: TextToSpeechManager.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Singleton
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u001e\b\u0007\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J,\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010'\u001a\u00020\u001cJ\u0012\u0010(\u001a\u00020\u001a2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&J\u0006\u0010)\u001a\u00020\u001aJ\u001e\u0010*\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020+2\u0006\u0010,\u001a\u00020\"J\u0006\u0010-\u001a\u00020\u001aJ\u0006\u0010.\u001a\u00020\u001aJ\u0010\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u000201H\u0016R\u0010\u0010\u0003\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f¨\u00063"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManager;", "Landroid/speech/tts/TextToSpeech$OnInitListener;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "tts", "Landroid/speech/tts/TextToSpeech;", "currentSynthesisFile", "Ljava/io/File;", "_textToSpeechManagerState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerState;", "textToSpeechManagerState", "Lkotlinx/coroutines/flow/StateFlow;", "getTextToSpeechManagerState", "()Lkotlinx/coroutines/flow/StateFlow;", "_textToSpeechManagerEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerEvent;", "textToSpeechManagerEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getTextToSpeechManagerEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "onInit", "", "status", "", "utteranceProgressListener", "com/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManager$utteranceProgressListener$1", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManager$utteranceProgressListener$1;", "speakText", "text", "", "lang", "Lcom/deepvisiontech/letstalksigntranscriptionapp/legacy/ui/enums/TranscriptionLang;", "voice", "Landroid/speech/tts/Voice;", "queueMode", "repeatLast", "stopSpeaking", "synthesizeToFile", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "utteranceId", "cancelSynthesis", "shutdown", "onStop", "owner", "Landroidx/lifecycle/LifecycleOwner;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TextToSpeechManager implements TextToSpeech.OnInitListener, DefaultLifecycleObserver {
    private static final String TAG = "TextToSpeechManager";
    private final MutableSharedFlow<TextToSpeechManagerEvent> _textToSpeechManagerEvent;
    private final MutableStateFlow<TextToSpeechManagerState> _textToSpeechManagerState;

    @ApplicationContext
    private final Context context;
    private File currentSynthesisFile;
    private final SharedFlow<TextToSpeechManagerEvent> textToSpeechManagerEvent;
    private final StateFlow<TextToSpeechManagerState> textToSpeechManagerState;
    private TextToSpeech tts;
    private final TextToSpeechManager$utteranceProgressListener$1 utteranceProgressListener;
    public static final int $stable = 8;

    public void onCreate(LifecycleOwner lifecycleOwner) {
        super.onCreate(lifecycleOwner);
    }

    public void onDestroy(LifecycleOwner lifecycleOwner) {
        super.onDestroy(lifecycleOwner);
    }

    public void onPause(LifecycleOwner lifecycleOwner) {
        super.onPause(lifecycleOwner);
    }

    public void onResume(LifecycleOwner lifecycleOwner) {
        super.onResume(lifecycleOwner);
    }

    public void onStart(LifecycleOwner lifecycleOwner) {
        super.onStart(lifecycleOwner);
    }

    /* JADX WARN: Type inference failed for: r11v6, types: [com.deepvisiontech.letstalksigntranscriptionapp.current.core.texttospeech.TextToSpeechManager$utteranceProgressListener$1] */
    @Inject
    public TextToSpeechManager(@ApplicationContext Context context) {
        Object value;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        StateFlow<TextToSpeechManagerState> stateFlowMutableStateFlow = StateFlowKt.MutableStateFlow(new TextToSpeechManagerState(false, false, false, null, null, null, 63, null));
        this._textToSpeechManagerState = stateFlowMutableStateFlow;
        this.textToSpeechManagerState = stateFlowMutableStateFlow;
        SharedFlow<TextToSpeechManagerEvent> sharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 1, (BufferOverflow) null, 5, (Object) null);
        this._textToSpeechManagerEvent = sharedFlowMutableSharedFlow$default;
        this.textToSpeechManagerEvent = sharedFlowMutableSharedFlow$default;
        try {
            this.tts = new TextToSpeech(context, this);
        } catch (Exception e) {
            this._textToSpeechManagerEvent.tryEmit(new TextToSpeechManagerEvent.Error.InitializationFailed("Failed to instantiate TextToSpeech: " + e.getMessage()));
            MutableStateFlow<TextToSpeechManagerState> mutableStateFlow = this._textToSpeechManagerState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, TextToSpeechManagerState.copy$default((TextToSpeechManagerState) value, false, false, false, null, null, null, 62, null)));
        }
        this.utteranceProgressListener = new UtteranceProgressListener() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.texttospeech.TextToSpeechManager$utteranceProgressListener$1
            @Override // android.speech.tts.UtteranceProgressListener
            public void onStart(String utteranceId) {
                Object value2;
                MutableStateFlow mutableStateFlow2 = this.this$0._textToSpeechManagerState;
                do {
                    value2 = mutableStateFlow2.getValue();
                } while (!mutableStateFlow2.compareAndSet(value2, TextToSpeechManagerState.copy$default((TextToSpeechManagerState) value2, false, true, false, null, null, null, 61, null)));
            }

            @Override // android.speech.tts.UtteranceProgressListener
            public void onDone(String utteranceId) {
                Object value2;
                Intrinsics.checkNotNullParameter(utteranceId, "utteranceId");
                File file = this.this$0.currentSynthesisFile;
                if (file != null) {
                    MutableSharedFlow mutableSharedFlow = this.this$0._textToSpeechManagerEvent;
                    Uri uriFromFile = Uri.fromFile(file);
                    Intrinsics.checkNotNullExpressionValue(uriFromFile, "fromFile(...)");
                    mutableSharedFlow.tryEmit(new TextToSpeechManagerEvent.SynthesisResult(uriFromFile, utteranceId));
                }
                MutableStateFlow mutableStateFlow2 = this.this$0._textToSpeechManagerState;
                do {
                    value2 = mutableStateFlow2.getValue();
                } while (!mutableStateFlow2.compareAndSet(value2, TextToSpeechManagerState.copy$default((TextToSpeechManagerState) value2, false, false, false, null, null, null, 57, null)));
                this.this$0.currentSynthesisFile = null;
            }

            @Override // android.speech.tts.UtteranceProgressListener
            @Deprecated(message = "Deprecated in Java")
            public void onError(String utteranceId) {
                onError(utteranceId, -1);
            }

            @Override // android.speech.tts.UtteranceProgressListener
            public void onError(String utteranceId, int errorCode) {
                Object value2;
                this.this$0._textToSpeechManagerEvent.tryEmit(new TextToSpeechManagerEvent.Error.SynthesisFailed(utteranceId, errorCode));
                File file = this.this$0.currentSynthesisFile;
                if (file != null) {
                    file.delete();
                }
                this.this$0.currentSynthesisFile = null;
                MutableStateFlow mutableStateFlow2 = this.this$0._textToSpeechManagerState;
                do {
                    value2 = mutableStateFlow2.getValue();
                } while (!mutableStateFlow2.compareAndSet(value2, TextToSpeechManagerState.copy$default((TextToSpeechManagerState) value2, false, false, false, null, null, null, 57, null)));
            }
        };
    }

    public final StateFlow<TextToSpeechManagerState> getTextToSpeechManagerState() {
        return this.textToSpeechManagerState;
    }

    public final SharedFlow<TextToSpeechManagerEvent> getTextToSpeechManagerEvent() {
        return this.textToSpeechManagerEvent;
    }

    @Override // android.speech.tts.TextToSpeech.OnInitListener
    public void onInit(int status) {
        Object value;
        List listEmptyList;
        Object value2;
        if (status == 0) {
            TextToSpeech textToSpeech = this.tts;
            if (textToSpeech != null) {
                textToSpeech.setOnUtteranceProgressListener(this.utteranceProgressListener);
                try {
                    Set<Voice> voices = textToSpeech.getVoices();
                    if (voices == null || (listEmptyList = CollectionsKt.toList(voices)) == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                } catch (Exception unused) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                List list = listEmptyList;
                MutableStateFlow<TextToSpeechManagerState> mutableStateFlow = this._textToSpeechManagerState;
                do {
                    value2 = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value2, TextToSpeechManagerState.copy$default((TextToSpeechManagerState) value2, true, false, false, null, null, list, 30, null)));
                return;
            }
            return;
        }
        this._textToSpeechManagerEvent.tryEmit(new TextToSpeechManagerEvent.Error.InitializationFailed("TTS engine failed to initialize with status: " + status));
        MutableStateFlow<TextToSpeechManagerState> mutableStateFlow2 = this._textToSpeechManagerState;
        do {
            value = mutableStateFlow2.getValue();
        } while (!mutableStateFlow2.compareAndSet(value, TextToSpeechManagerState.copy$default((TextToSpeechManagerState) value, false, false, false, null, null, null, 62, null)));
    }

    public static /* synthetic */ void speakText$default(TextToSpeechManager textToSpeechManager, String str, TranscriptionLang transcriptionLang, Voice voice, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            voice = null;
        }
        if ((i2 & 8) != 0) {
            i = 0;
        }
        textToSpeechManager.speakText(str, transcriptionLang, voice, i);
    }

    public final void speakText(String text, TranscriptionLang lang, Voice voice, int queueMode) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(lang, "lang");
        TextToSpeech textToSpeech = this.tts;
        if (!((TextToSpeechManagerState) this._textToSpeechManagerState.getValue()).isInitialized() || textToSpeech == null) {
            this._textToSpeechManagerEvent.tryEmit(new TextToSpeechManagerEvent.Error.OperationFailed("Text To Speech not initialized."));
            return;
        }
        int language = textToSpeech.setLanguage(lang.getLocale());
        if (language == -2 || language == -1) {
            this._textToSpeechManagerEvent.tryEmit(new TextToSpeechManagerEvent.Error.LanguageNotSupported(lang.getLocale()));
            return;
        }
        if (voice != null) {
            try {
                textToSpeech.setVoice(voice);
            } catch (Exception unused) {
            }
        }
        textToSpeech.speak(text, queueMode, null, "speak_" + System.currentTimeMillis());
        MutableStateFlow<TextToSpeechManagerState> mutableStateFlow = this._textToSpeechManagerState;
        while (true) {
            Object value = mutableStateFlow.getValue();
            String str = text;
            TranscriptionLang transcriptionLang = lang;
            if (mutableStateFlow.compareAndSet(value, TextToSpeechManagerState.copy$default((TextToSpeechManagerState) value, false, false, false, str, transcriptionLang, null, 39, null))) {
                return;
            }
            text = str;
            lang = transcriptionLang;
        }
    }

    public static /* synthetic */ void repeatLast$default(TextToSpeechManager textToSpeechManager, Voice voice, int i, Object obj) {
        if ((i & 1) != 0) {
            voice = null;
        }
        textToSpeechManager.repeatLast(voice);
    }

    public final void repeatLast(Voice voice) {
        TextToSpeechManagerState textToSpeechManagerState = (TextToSpeechManagerState) this._textToSpeechManagerState.getValue();
        if (StringsKt.isBlank(textToSpeechManagerState.getLastSpokenText())) {
            return;
        }
        speakText$default(this, textToSpeechManagerState.getLastSpokenText(), textToSpeechManagerState.getLastSpokenTextLanguage(), voice, 0, 8, null);
    }

    public final void stopSpeaking() {
        Object value;
        if (((TextToSpeechManagerState) this._textToSpeechManagerState.getValue()).isSpeaking()) {
            TextToSpeech textToSpeech = this.tts;
            if (textToSpeech != null) {
                textToSpeech.stop();
            }
            MutableStateFlow<TextToSpeechManagerState> mutableStateFlow = this._textToSpeechManagerState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, TextToSpeechManagerState.copy$default((TextToSpeechManagerState) value, false, false, false, null, null, null, 61, null)));
        }
    }

    public final void synthesizeToFile(String text, LanguageEnum lang, String utteranceId) {
        Object value;
        TextToSpeechManagerState textToSpeechManagerStateCopy$default;
        Object value2;
        Object value3;
        Object value4;
        Object value5;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(utteranceId, "utteranceId");
        TextToSpeech textToSpeech = this.tts;
        if (!((TextToSpeechManagerState) this._textToSpeechManagerState.getValue()).isInitialized() || textToSpeech == null) {
            this._textToSpeechManagerEvent.tryEmit(new TextToSpeechManagerEvent.Error.OperationFailed("TTS engine is not initialized."));
            return;
        }
        MutableStateFlow<TextToSpeechManagerState> mutableStateFlow = this._textToSpeechManagerState;
        boolean z = false;
        do {
            value = mutableStateFlow.getValue();
            textToSpeechManagerStateCopy$default = (TextToSpeechManagerState) value;
            if (textToSpeechManagerStateCopy$default.isSynthesizing()) {
                this._textToSpeechManagerEvent.tryEmit(TextToSpeechManagerEvent.Error.SynthesisInProgress.INSTANCE);
            } else {
                textToSpeechManagerStateCopy$default = TextToSpeechManagerState.copy$default(textToSpeechManagerStateCopy$default, false, false, true, null, null, null, 59, null);
                z = true;
            }
        } while (!mutableStateFlow.compareAndSet(value, textToSpeechManagerStateCopy$default));
        if (z) {
            int language = textToSpeech.setLanguage(lang.getLocale());
            if (language == -2 || language == -1) {
                this._textToSpeechManagerEvent.tryEmit(new TextToSpeechManagerEvent.Error.LanguageNotSupported(lang.getLocale()));
                MutableStateFlow<TextToSpeechManagerState> mutableStateFlow2 = this._textToSpeechManagerState;
                do {
                    value2 = mutableStateFlow2.getValue();
                } while (!mutableStateFlow2.compareAndSet(value2, TextToSpeechManagerState.copy$default((TextToSpeechManagerState) value2, false, false, false, null, null, null, 59, null)));
                return;
            }
            File externalFilesDir = this.context.getExternalFilesDir("audio");
            if (externalFilesDir == null) {
                this._textToSpeechManagerEvent.tryEmit(new TextToSpeechManagerEvent.Error.OperationFailed("External storage is not available."));
                MutableStateFlow<TextToSpeechManagerState> mutableStateFlow3 = this._textToSpeechManagerState;
                do {
                    value5 = mutableStateFlow3.getValue();
                } while (!mutableStateFlow3.compareAndSet(value5, TextToSpeechManagerState.copy$default((TextToSpeechManagerState) value5, false, false, false, null, null, null, 59, null)));
                return;
            }
            try {
                externalFilesDir.mkdirs();
                File fileCreateTempFile = File.createTempFile("synthesis_" + utteranceId + "_", ".wav", externalFilesDir);
                this.currentSynthesisFile = fileCreateTempFile;
                Bundle bundle = new Bundle();
                bundle.putString("utteranceId", utteranceId);
                if (textToSpeech.synthesizeToFile(text, bundle, fileCreateTempFile, utteranceId) == -1) {
                    this._textToSpeechManagerEvent.tryEmit(new TextToSpeechManagerEvent.Error.OperationFailed("The TTS engine could not start the synthesis."));
                    File file = this.currentSynthesisFile;
                    if (file != null) {
                        file.delete();
                    }
                    this.currentSynthesisFile = null;
                    MutableStateFlow<TextToSpeechManagerState> mutableStateFlow4 = this._textToSpeechManagerState;
                    do {
                        value4 = mutableStateFlow4.getValue();
                    } while (!mutableStateFlow4.compareAndSet(value4, TextToSpeechManagerState.copy$default((TextToSpeechManagerState) value4, false, false, false, null, null, null, 59, null)));
                }
            } catch (Exception e) {
                this._textToSpeechManagerEvent.tryEmit(new TextToSpeechManagerEvent.Error.OperationFailed("Failed to start synthesis: " + e.getMessage()));
                File file2 = this.currentSynthesisFile;
                if (file2 != null) {
                    file2.delete();
                }
                this.currentSynthesisFile = null;
                MutableStateFlow<TextToSpeechManagerState> mutableStateFlow5 = this._textToSpeechManagerState;
                do {
                    value3 = mutableStateFlow5.getValue();
                } while (!mutableStateFlow5.compareAndSet(value3, TextToSpeechManagerState.copy$default((TextToSpeechManagerState) value3, false, false, false, null, null, null, 59, null)));
            }
        }
    }

    public final void cancelSynthesis() {
        Object value;
        if (((TextToSpeechManagerState) this._textToSpeechManagerState.getValue()).isSynthesizing()) {
            TextToSpeech textToSpeech = this.tts;
            if (textToSpeech != null) {
                textToSpeech.stop();
            }
            File file = this.currentSynthesisFile;
            if (file != null) {
                file.delete();
            }
            this.currentSynthesisFile = null;
            MutableStateFlow<TextToSpeechManagerState> mutableStateFlow = this._textToSpeechManagerState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, TextToSpeechManagerState.copy$default((TextToSpeechManagerState) value, false, false, false, null, null, null, 57, null)));
        }
    }

    public final void shutdown() {
        TextToSpeech textToSpeech = this.tts;
        if (textToSpeech != null) {
            textToSpeech.stop();
        }
        TextToSpeech textToSpeech2 = this.tts;
        if (textToSpeech2 != null) {
            textToSpeech2.shutdown();
        }
        this.tts = null;
        File file = this.currentSynthesisFile;
        if (file != null) {
            file.delete();
        }
        this.currentSynthesisFile = null;
        this._textToSpeechManagerState.setValue(new TextToSpeechManagerState(false, false, false, null, null, null, 63, null));
    }

    public void onStop(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        shutdown();
    }
}
