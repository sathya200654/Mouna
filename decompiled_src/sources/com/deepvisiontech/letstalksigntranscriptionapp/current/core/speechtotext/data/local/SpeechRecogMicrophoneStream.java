package com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.local;

import com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.data.local.SharedAudioEngine;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.domain.AudioStreamListener;
import com.microsoft.cognitiveservices.speech.audio.AudioStreamFormat;
import com.microsoft.cognitiveservices.speech.audio.PullAudioInputStreamCallback;
import java.util.concurrent.LinkedBlockingDeque;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpeechRecogMicrophoneStream.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0006\u0010\u0014\u001a\u00020\u0010J\u0006\u0010\u0015\u001a\u00020\u0010J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/data/local/SpeechRecogMicrophoneStream;", "Lcom/microsoft/cognitiveservices/speech/audio/PullAudioInputStreamCallback;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/audiorecorder/domain/AudioStreamListener;", "sharedAudioEngine", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/audiorecorder/data/local/SharedAudioEngine;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/audiorecorder/data/local/SharedAudioEngine;)V", "format", "Lcom/microsoft/cognitiveservices/speech/audio/AudioStreamFormat;", "audioQueue", "Ljava/util/concurrent/LinkedBlockingDeque;", "", "isListening", "", "getFormat", "onAudioData", "", "audioData", "size", "", "startListening", "stopListening", "read", "bytes", "close", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SpeechRecogMicrophoneStream extends PullAudioInputStreamCallback implements AudioStreamListener {
    private static final int SAMPLE_RATE = 16000;
    private final LinkedBlockingDeque<byte[]> audioQueue;
    private final AudioStreamFormat format;
    private volatile boolean isListening;
    private final SharedAudioEngine sharedAudioEngine;
    public static final int $stable = 8;

    @Inject
    public SpeechRecogMicrophoneStream(SharedAudioEngine sharedAudioEngine) {
        Intrinsics.checkNotNullParameter(sharedAudioEngine, "sharedAudioEngine");
        this.sharedAudioEngine = sharedAudioEngine;
        AudioStreamFormat waveFormatPCM = AudioStreamFormat.getWaveFormatPCM(16000L, (short) 16, (short) 1);
        Intrinsics.checkNotNullExpressionValue(waveFormatPCM, "getWaveFormatPCM(...)");
        this.format = waveFormatPCM;
        this.audioQueue = new LinkedBlockingDeque<>();
    }

    public final AudioStreamFormat getFormat() {
        return this.format;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.domain.AudioStreamListener
    public void onAudioData(byte[] audioData, int size) {
        Intrinsics.checkNotNullParameter(audioData, "audioData");
        if (this.isListening) {
            this.audioQueue.offerLast(audioData);
        }
    }

    public final void startListening() {
        this.audioQueue.clear();
        this.isListening = true;
        this.sharedAudioEngine.addListener(this);
    }

    public final void stopListening() {
        this.isListening = false;
        this.sharedAudioEngine.removeListener(this);
        this.audioQueue.offerLast(new byte[0]);
    }

    @Override // com.microsoft.cognitiveservices.speech.audio.PullAudioInputStreamCallback
    public int read(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (!this.isListening && this.audioQueue.isEmpty()) {
            return 0;
        }
        try {
            byte[] bArrTakeFirst = this.audioQueue.takeFirst();
            Intrinsics.checkNotNull(bArrTakeFirst);
            if (bArrTakeFirst.length == 0) {
                return 0;
            }
            if (bArrTakeFirst.length > bytes.length) {
                System.arraycopy(bArrTakeFirst, 0, bytes, 0, bytes.length);
                this.audioQueue.offerFirst(ArraysKt.copyOfRange(bArrTakeFirst, bytes.length, bArrTakeFirst.length));
                return bytes.length;
            }
            System.arraycopy(bArrTakeFirst, 0, bytes, 0, bArrTakeFirst.length);
            return bArrTakeFirst.length;
        } catch (InterruptedException unused) {
            return 0;
        }
    }

    @Override // com.microsoft.cognitiveservices.speech.audio.PullAudioInputStreamCallback
    public void close() {
        stopListening();
    }
}
