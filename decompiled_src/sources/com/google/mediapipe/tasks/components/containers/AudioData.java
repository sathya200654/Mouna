package com.google.mediapipe.tasks.components.containers;

import android.media.AudioFormat;
import android.media.AudioRecord;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class AudioData {
    private static final String TAG = "AudioData";
    private final FloatRingBuffer buffer;
    private final AudioDataFormat format;

    public static AudioData create(AudioDataFormat format, int sampleCounts) {
        return new AudioData(format, sampleCounts);
    }

    public static AudioData create(AudioFormat format, int sampleCounts) {
        return new AudioData(AudioDataFormat.create(format), sampleCounts);
    }

    public static abstract class AudioDataFormat {
        private static final int DEFAULT_NUM_OF_CHANNELS = 1;

        public abstract int getNumOfChannels();

        public abstract float getSampleRate();

        public static AudioDataFormat create(AudioFormat format) {
            return builder().setNumOfChannels(format.getChannelCount()).setSampleRate(format.getSampleRate()).build();
        }

        public static Builder builder() {
            return new AutoValue_AudioData_AudioDataFormat.Builder().setNumOfChannels(1);
        }

        public static abstract class Builder {
            abstract AudioDataFormat autoBuild();

            public abstract Builder setNumOfChannels(int value);

            public abstract Builder setSampleRate(float value);

            public AudioDataFormat build() {
                AudioDataFormat audioDataFormatAutoBuild = autoBuild();
                if (audioDataFormatAutoBuild.getNumOfChannels() <= 0) {
                    throw new IllegalArgumentException("Number of channels should be greater than 0");
                }
                if (audioDataFormatAutoBuild.getSampleRate() > 0.0f) {
                    return audioDataFormatAutoBuild;
                }
                throw new IllegalArgumentException("Sample rate should be greater than 0");
            }
        }
    }

    public void load(float[] src) {
        load(src, 0, src.length);
    }

    public void load(float[] src, int offsetInFloat, int sizeInFloat) {
        if (sizeInFloat % this.format.getNumOfChannels() != 0) {
            throw new IllegalArgumentException(String.format("Size (%d) needs to be a multiplier of the number of channels (%d)", Integer.valueOf(sizeInFloat), Integer.valueOf(this.format.getNumOfChannels())));
        }
        this.buffer.load(src, offsetInFloat, sizeInFloat);
    }

    public void load(short[] src) {
        load(src, 0, src.length);
    }

    public void load(short[] src, int offsetInShort, int sizeInShort) {
        if (offsetInShort + sizeInShort > src.length) {
            throw new IllegalArgumentException(String.format("Index out of range. offset (%d) + size (%d) should <= newData.length (%d)", Integer.valueOf(offsetInShort), Integer.valueOf(sizeInShort), Integer.valueOf(src.length)));
        }
        float[] fArr = new float[sizeInShort];
        for (int i = 0; i < sizeInShort; i++) {
            fArr[i] = (src[i + offsetInShort] * 1.0f) / 32767.0f;
        }
        load(fArr);
    }

    public int load(AudioRecord record) {
        int i;
        if (!this.format.equals(AudioDataFormat.create(record.getFormat()))) {
            throw new IllegalArgumentException("Incompatible audio format.");
        }
        if (record.getAudioFormat() == 4) {
            int channelCount = record.getChannelCount() * record.getBufferSizeInFrames();
            float[] fArr = new float[channelCount];
            i = record.read(fArr, 0, channelCount, 1);
            if (i > 0) {
                load(fArr, 0, i);
                return i;
            }
        } else if (record.getAudioFormat() == 2) {
            int channelCount2 = record.getChannelCount() * record.getBufferSizeInFrames();
            short[] sArr = new short[channelCount2];
            i = record.read(sArr, 0, channelCount2, 1);
            if (i > 0) {
                load(sArr, 0, i);
                return i;
            }
        } else {
            throw new IllegalArgumentException("Unsupported encoding. Requires ENCODING_PCM_16BIT or ENCODING_PCM_FLOAT.");
        }
        if (i == -6) {
            throw new IllegalStateException("AudioRecord.ERROR_DEAD_OBJECT");
        }
        if (i == -3) {
            throw new IllegalStateException("AudioRecord.ERROR_INVALID_OPERATION");
        }
        if (i == -2) {
            throw new IllegalStateException("AudioRecord.ERROR_BAD_VALUE");
        }
        if (i != -1) {
            return 0;
        }
        throw new IllegalStateException("AudioRecord.ERROR");
    }

    public float[] getBuffer() {
        float[] fArr = new float[this.buffer.getCapacity()];
        this.buffer.getBuffer().asFloatBuffer().get(fArr);
        return fArr;
    }

    public AudioDataFormat getFormat() {
        return this.format;
    }

    public int getBufferLength() {
        return this.buffer.getCapacity() / this.format.getNumOfChannels();
    }

    private AudioData(AudioDataFormat format, int sampleCounts) {
        this.format = format;
        this.buffer = new FloatRingBuffer(sampleCounts * format.getNumOfChannels());
    }

    private static class FloatRingBuffer {
        private final float[] buffer;
        private int nextIndex = 0;

        public FloatRingBuffer(int flatSize) {
            this.buffer = new float[flatSize];
        }

        public void load(float[] newData, int offset, int size) {
            if (offset + size > newData.length) {
                throw new IllegalArgumentException(String.format("Index out of range. offset (%d) + size (%d) should <= newData.length (%d)", Integer.valueOf(offset), Integer.valueOf(size), Integer.valueOf(newData.length)));
            }
            float[] fArr = this.buffer;
            if (size > fArr.length) {
                offset += size - fArr.length;
                size = fArr.length;
            }
            int i = this.nextIndex;
            if (i + size < fArr.length) {
                System.arraycopy(newData, offset, fArr, i, size);
            } else {
                int length = fArr.length - i;
                System.arraycopy(newData, offset, fArr, i, length);
                System.arraycopy(newData, offset + length, this.buffer, 0, size - length);
            }
            this.nextIndex = (this.nextIndex + size) % this.buffer.length;
        }

        public ByteBuffer getBuffer() {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.buffer.length * 4);
            byteBufferAllocate.order(ByteOrder.nativeOrder());
            FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocate.asFloatBuffer();
            float[] fArr = this.buffer;
            int i = this.nextIndex;
            floatBufferAsFloatBuffer.put(fArr, i, fArr.length - i);
            floatBufferAsFloatBuffer.put(this.buffer, 0, this.nextIndex);
            byteBufferAllocate.rewind();
            return byteBufferAllocate;
        }

        public int getCapacity() {
            return this.buffer.length;
        }
    }
}
