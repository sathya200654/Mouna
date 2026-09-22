package com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.data.local;

import android.media.AudioFormat;
import android.media.AudioRecord;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.domain.AudioStreamListener;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedAudioEngine.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Singleton
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fJ\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\u0013J\b\u0010\u0017\u001a\u00020\u0007H\u0007J\u0006\u0010\u0018\u001a\u00020\u0013J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u000fH\u0002J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000fH\u0002J\b\u0010\u001f\u001a\u00020\u0013H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/audiorecorder/data/local/SharedAudioEngine;", "", "<init>", "()V", "audioRecord", "Landroid/media/AudioRecord;", "isRecording", "", "recordingThread", "Ljava/lang/Thread;", "listeners", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/audiorecorder/domain/AudioStreamListener;", "listenersLock", "sampleRate", "", "channelConfig", "audioFormat", "addListener", "", "listener", "removeListener", "clearListeners", "startEngine", "stopEngine", "readAudioLoop", "bufferSize", "broadcastAudio", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "size", "releaseHardware", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SharedAudioEngine {
    public static final int $stable = 8;
    private AudioRecord audioRecord;
    private volatile boolean isRecording;
    private Thread recordingThread;
    private final List<AudioStreamListener> listeners = new ArrayList();
    private final Object listenersLock = new Object();
    private final int sampleRate = 16000;
    private final int channelConfig = 16;
    private final int audioFormat = 2;

    @Inject
    public SharedAudioEngine() {
    }

    public final void addListener(AudioStreamListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.listenersLock) {
            if (!this.listeners.contains(listener)) {
                this.listeners.add(listener);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void removeListener(AudioStreamListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.listenersLock) {
            this.listeners.remove(listener);
        }
    }

    public final void clearListeners() {
        synchronized (this.listenersLock) {
            this.listeners.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean startEngine() {
        if (this.isRecording) {
            return true;
        }
        final int iMax = Math.max(AudioRecord.getMinBufferSize(this.sampleRate, this.channelConfig, this.audioFormat), 3200);
        try {
            AudioRecord audioRecordBuild = new AudioRecord.Builder().setAudioSource(6).setAudioFormat(new AudioFormat.Builder().setSampleRate(this.sampleRate).setEncoding(this.audioFormat).setChannelMask(this.channelConfig).build()).setBufferSizeInBytes(iMax).build();
            this.audioRecord = audioRecordBuild;
            if (audioRecordBuild == null || audioRecordBuild.getState() != 1) {
                releaseHardware();
                return false;
            }
            AudioRecord audioRecord = this.audioRecord;
            if (audioRecord != null) {
                audioRecord.startRecording();
            }
            this.isRecording = true;
            Thread thread = new Thread(new Runnable() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.data.local.SharedAudioEngine$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.readAudioLoop(iMax);
                }
            });
            thread.setPriority(10);
            thread.start();
            this.recordingThread = thread;
            return true;
        } catch (Exception unused) {
            releaseHardware();
            return false;
        }
    }

    public final void stopEngine() throws InterruptedException {
        if (this.isRecording) {
            this.isRecording = false;
            try {
                AudioRecord audioRecord = this.audioRecord;
                if (audioRecord != null) {
                    audioRecord.stop();
                }
            } catch (Exception unused) {
            }
            Thread thread = this.recordingThread;
            if (thread != null) {
                thread.join(200L);
            }
            this.recordingThread = null;
            releaseHardware();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void readAudioLoop(int bufferSize) {
        byte[] bArr = new byte[bufferSize];
        while (this.isRecording) {
            try {
                AudioRecord audioRecord = this.audioRecord;
                if (audioRecord == null) {
                    return;
                }
                int i = audioRecord.read(bArr, 0, bufferSize);
                if (i > 0) {
                    byte[] bArrCopyOf = Arrays.copyOf(bArr, i);
                    Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
                    broadcastAudio(bArrCopyOf, i);
                } else if (i < 0) {
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
    }

    private final void broadcastAudio(byte[] data, int size) {
        synchronized (this.listenersLock) {
            Iterator<AudioStreamListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onAudioData(data, size);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void releaseHardware() {
        try {
            AudioRecord audioRecord = this.audioRecord;
            if (audioRecord != null) {
                audioRecord.release();
            }
        } catch (Exception unused) {
        } finally {
            this.audioRecord = null;
        }
    }
}
