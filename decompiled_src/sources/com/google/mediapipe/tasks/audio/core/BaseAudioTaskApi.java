package com.google.mediapipe.tasks.audio.core;

import android.media.AudioRecord;
import com.google.mediapipe.framework.MediaPipeException;
import com.google.mediapipe.tasks.components.containers.AudioData;
import com.google.mediapipe.tasks.core.TaskResult;
import com.google.mediapipe.tasks.core.TaskRunner;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class BaseAudioTaskApi implements AutoCloseable {
    private static final int BUFFER_SIZE_MULTIPLEIER = 2;
    private static final int FLOAT_BYTES = 4;
    private static final long MICROSECONDS_PER_MILLISECOND = 1000;
    private static final long PRESTREAM_TIMESTAMP = -9223372036854775806L;
    private final String audioStreamName;
    private double defaultSampleRate = -1.0d;
    private final TaskRunner runner;
    private final RunningMode runningMode;
    private final String sampleRateStreamName;

    static {
        System.loadLibrary("mediapipe_tasks_jni");
    }

    public BaseAudioTaskApi(TaskRunner runner, RunningMode runningMode, String audioStreamName, String sampleRateStreamName) {
        this.runner = runner;
        this.runningMode = runningMode;
        this.audioStreamName = audioStreamName;
        this.sampleRateStreamName = sampleRateStreamName;
    }

    protected TaskResult processAudioClip(AudioData audioClip) {
        if (this.runningMode != RunningMode.AUDIO_CLIPS) {
            throw new MediaPipeException(MediaPipeException.StatusCode.FAILED_PRECONDITION.ordinal(), "Task is not initialized with the audio clips mode. Current running mode:" + this.runningMode.name());
        }
        HashMap map = new HashMap();
        map.put(this.audioStreamName, this.runner.getPacketCreator().createMatrix(audioClip.getFormat().getNumOfChannels(), audioClip.getBufferLength(), audioClip.getBuffer()));
        map.put(this.sampleRateStreamName, this.runner.getPacketCreator().createFloat64(audioClip.getFormat().getSampleRate()));
        return this.runner.process(map);
    }

    protected void checkOrSetSampleRate(double sampleRate) {
        if (this.runningMode != RunningMode.AUDIO_STREAM) {
            throw new MediaPipeException(MediaPipeException.StatusCode.FAILED_PRECONDITION.ordinal(), "Task is not initialized with the audio stream mode. Current running mode:" + this.runningMode.name());
        }
        double d = this.defaultSampleRate;
        if (d > 0.0d) {
            if (Double.compare(sampleRate, d) != 0) {
                throw new MediaPipeException(MediaPipeException.StatusCode.INVALID_ARGUMENT.ordinal(), "The input audio sample rate: " + sampleRate + " is inconsistent with the previously provided: " + this.defaultSampleRate);
            }
        } else {
            HashMap map = new HashMap();
            map.put(this.sampleRateStreamName, this.runner.getPacketCreator().createFloat64(sampleRate));
            this.runner.send(map, PRESTREAM_TIMESTAMP);
            this.defaultSampleRate = sampleRate;
        }
    }

    protected void sendAudioStreamData(AudioData audioClip, long timestampMs) {
        if (this.runningMode != RunningMode.AUDIO_STREAM) {
            throw new MediaPipeException(MediaPipeException.StatusCode.FAILED_PRECONDITION.ordinal(), "Task is not initialized with the audio stream mode. Current running mode:" + this.runningMode.name());
        }
        HashMap map = new HashMap();
        map.put(this.audioStreamName, this.runner.getPacketCreator().createMatrix(audioClip.getFormat().getNumOfChannels(), audioClip.getBufferLength(), audioClip.getBuffer()));
        this.runner.send(map, timestampMs * 1000);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.runner.close();
    }

    public AudioRecord createAudioRecord(int numChannels, int sampleRate, int requiredInputBufferSize) {
        int i;
        if (numChannels == 1) {
            i = 16;
        } else {
            if (numChannels != 2) {
                throw new IllegalArgumentException("getAudioRecord method only supports 1 or 2 audio channels.");
            }
            i = 12;
        }
        int i2 = i;
        int minBufferSize = AudioRecord.getMinBufferSize(sampleRate, i2, 4);
        if (minBufferSize == -1 || minBufferSize == -2) {
            throw new IllegalStateException(String.format("AudioRecord.getMinBufferSize failed. Returned: %d", Integer.valueOf(minBufferSize)));
        }
        AudioRecord audioRecord = new AudioRecord(6, sampleRate, i2, 4, Math.max(minBufferSize, requiredInputBufferSize * 8));
        if (audioRecord.getState() == 1) {
            return audioRecord;
        }
        throw new IllegalStateException(String.format("AudioRecordfailed to initialize", new Object[0]));
    }

    public AudioRecord createAudioRecord() {
        return createAudioRecord(1, 16000, 16000);
    }
}
