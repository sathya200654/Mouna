package com.google.mediapipe.framework;

import com.google.protobuf.MessageLite;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class PacketCreator {
    private static final int GL_RGBA = 6408;
    protected Graph mediapipeGraph;

    private native long nativeCreateAudioPacket(long context, byte[] data, int offset, int numChannels, int numSamples);

    private native long nativeCreateAudioPacketDirect(long context, ByteBuffer data, int numChannels, int numSamples);

    private native long nativeCreateBool(long context, boolean value);

    private native long nativeCreateCalculatorOptions(long context, byte[] data);

    private native long nativeCreateCameraIntrinsics(long context, float fx, float fy, float cx, float cy, float width, float height);

    private native long nativeCreateCpuImage(long context, ByteBuffer buffer, int width, int height, int rowBytes, int numChannels);

    private native long nativeCreateFloat32(long context, float value);

    private native long nativeCreateFloat32Array(long context, float[] data);

    private native long nativeCreateFloat32Vector(long context, float[] data);

    private native long nativeCreateFloat64(long context, double value);

    private native long nativeCreateFloatImageFrame(long context, FloatBuffer buffer, int width, int height);

    private native long nativeCreateGpuBuffer(long context, int name, int width, int height, int format, TextureReleaseCallback releaseCallback, int sync);

    private native long nativeCreateGpuImage(long context, int name, int width, int height, int format, TextureReleaseCallback releaseCallback);

    private native long nativeCreateGrayscaleImage(long context, ByteBuffer buffer, int width, int height);

    private native long nativeCreateInt16(long context, short value);

    private native long nativeCreateInt32(long context, int value);

    private native long nativeCreateInt32Array(long context, int[] data);

    private native long nativeCreateInt32Pair(long context, int first, int second);

    private native long nativeCreateInt64(long context, long value);

    private native long nativeCreateMatrix(long context, int rows, int cols, float[] data);

    private native long nativeCreateProto(long context, ProtoUtil.SerializedMessage data);

    private native long nativeCreateReferencePacket(long context, long packet);

    private native long nativeCreateRgbImage(long context, ByteBuffer buffer, int width, int height);

    private native long nativeCreateRgbImageFromRgba(long context, ByteBuffer buffer, int width, int height);

    private native long nativeCreateRgbaImageFrame(long context, ByteBuffer buffer, int width, int height);

    private native long nativeCreateString(long context, String value);

    private native long nativeCreateStringFromByteArray(long context, byte[] data);

    private native long nativeCreateTimeSeriesHeader(long context, int numChannels, double sampleRate);

    private native long nativeCreateVideoHeader(long context, int width, int height);

    public enum SyncMode {
        NO_SYNC(0),
        SYNC(1),
        MAYBE_SYNC_OR_FINISH(2);

        private final int value;

        SyncMode(int value) {
            this.value = value;
        }
    }

    public PacketCreator(Graph context) {
        this.mediapipeGraph = context;
    }

    public Packet createReferencePacket(Packet packet) {
        return Packet.create(nativeCreateReferencePacket(this.mediapipeGraph.getNativeHandle(), packet.getNativeHandle()));
    }

    public Packet createRgbImage(ByteBuffer buffer, int width, int height) {
        int i = (((width * 3) + 3) / 4) * 4 * height;
        if (i != buffer.capacity()) {
            throw new IllegalArgumentException("The size of the buffer should be: " + i + " but is " + buffer.capacity());
        }
        return Packet.create(nativeCreateRgbImage(this.mediapipeGraph.getNativeHandle(), buffer, width, height));
    }

    public Packet createAudioPacket(byte[] data, int numChannels, int numSamples) {
        checkAudioDataSize(data.length, numChannels, numSamples);
        return Packet.create(nativeCreateAudioPacket(this.mediapipeGraph.getNativeHandle(), data, 0, numChannels, numSamples));
    }

    public Packet createAudioPacket(ByteBuffer data, int numChannels, int numSamples) {
        checkAudioDataSize(data.remaining(), numChannels, numSamples);
        if (data.isDirect()) {
            return Packet.create(nativeCreateAudioPacketDirect(this.mediapipeGraph.getNativeHandle(), data.slice(), numChannels, numSamples));
        }
        if (data.hasArray()) {
            return Packet.create(nativeCreateAudioPacket(this.mediapipeGraph.getNativeHandle(), data.array(), data.arrayOffset() + data.position(), numChannels, numSamples));
        }
        throw new IllegalArgumentException("Data must be either a direct byte buffer or be backed by a byte array.");
    }

    private static void checkAudioDataSize(int length, int numChannels, int numSamples) {
        int i = numChannels * numSamples * 2;
        if (i != length) {
            throw new IllegalArgumentException("Please check the audio data size, has to be num_channels * num_samples * 2 = " + i + " but was " + length);
        }
    }

    public Packet createRgbImageFromRgba(ByteBuffer buffer, int width, int height) {
        int i = width * height * 4;
        if (i != buffer.capacity()) {
            throw new IllegalArgumentException("The size of the buffer should be: " + i + " but is " + buffer.capacity());
        }
        return Packet.create(nativeCreateRgbImageFromRgba(this.mediapipeGraph.getNativeHandle(), buffer, width, height));
    }

    public Packet createGrayscaleImage(ByteBuffer buffer, int width, int height) {
        int i = width * height;
        if (i != buffer.capacity()) {
            throw new IllegalArgumentException("The size of the buffer should be: " + i + " but is " + buffer.capacity());
        }
        return Packet.create(nativeCreateGrayscaleImage(this.mediapipeGraph.getNativeHandle(), buffer, width, height));
    }

    public Packet createRgbaImageFrame(ByteBuffer buffer, int width, int height) {
        int i = width * height * 4;
        if (buffer.capacity() != i) {
            throw new IllegalArgumentException("The size of the buffer should be: " + i + " but is " + buffer.capacity());
        }
        return Packet.create(nativeCreateRgbaImageFrame(this.mediapipeGraph.getNativeHandle(), buffer, width, height));
    }

    public Packet createFloatImageFrame(FloatBuffer buffer, int width, int height) {
        int i = width * height * 4;
        if (buffer.capacity() != i) {
            throw new IllegalArgumentException("The size of the buffer should be: " + i + " but is " + buffer.capacity());
        }
        return Packet.create(nativeCreateFloatImageFrame(this.mediapipeGraph.getNativeHandle(), buffer, width, height));
    }

    public Packet createInt16(short value) {
        return Packet.create(nativeCreateInt16(this.mediapipeGraph.getNativeHandle(), value));
    }

    public Packet createInt32(int value) {
        return Packet.create(nativeCreateInt32(this.mediapipeGraph.getNativeHandle(), value));
    }

    public Packet createInt64(long value) {
        return Packet.create(nativeCreateInt64(this.mediapipeGraph.getNativeHandle(), value));
    }

    public Packet createFloat32(float value) {
        return Packet.create(nativeCreateFloat32(this.mediapipeGraph.getNativeHandle(), value));
    }

    public Packet createFloat64(double value) {
        return Packet.create(nativeCreateFloat64(this.mediapipeGraph.getNativeHandle(), value));
    }

    public Packet createBool(boolean value) {
        return Packet.create(nativeCreateBool(this.mediapipeGraph.getNativeHandle(), value));
    }

    public Packet createString(String value) {
        return Packet.create(nativeCreateString(this.mediapipeGraph.getNativeHandle(), value));
    }

    public Packet createInt16Vector(short[] data) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Packet createInt32Vector(int[] data) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Packet createInt64Vector(long[] data) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Packet createFloat32Vector(float[] data) {
        return Packet.create(nativeCreateFloat32Vector(this.mediapipeGraph.getNativeHandle(), data));
    }

    public Packet createFloat64Vector(double[] data) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Packet createInt32Array(int[] data) {
        return Packet.create(nativeCreateInt32Array(this.mediapipeGraph.getNativeHandle(), data));
    }

    public Packet createInt32Pair(int first, int second) {
        return Packet.create(nativeCreateInt32Pair(this.mediapipeGraph.getNativeHandle(), first, second));
    }

    public Packet createFloat32Array(float[] data) {
        return Packet.create(nativeCreateFloat32Array(this.mediapipeGraph.getNativeHandle(), data));
    }

    public Packet createByteArray(byte[] data) {
        return Packet.create(nativeCreateStringFromByteArray(this.mediapipeGraph.getNativeHandle(), data));
    }

    public Packet createVideoHeader(int width, int height) {
        return Packet.create(nativeCreateVideoHeader(this.mediapipeGraph.getNativeHandle(), width, height));
    }

    public Packet createTimeSeriesHeader(int numChannels, double sampleRate) {
        return Packet.create(nativeCreateTimeSeriesHeader(this.mediapipeGraph.getNativeHandle(), numChannels, sampleRate));
    }

    public Packet createMatrix(int rows, int cols, float[] data) {
        return Packet.create(nativeCreateMatrix(this.mediapipeGraph.getNativeHandle(), rows, cols, data));
    }

    public Packet createSerializedProto(MessageLite message) {
        return Packet.create(nativeCreateStringFromByteArray(this.mediapipeGraph.getNativeHandle(), message.toByteArray()));
    }

    public Packet createCalculatorOptions(MessageLite message) {
        return Packet.create(nativeCreateCalculatorOptions(this.mediapipeGraph.getNativeHandle(), message.toByteArray()));
    }

    public Packet createProto(MessageLite message) {
        return Packet.create(nativeCreateProto(this.mediapipeGraph.getNativeHandle(), ProtoUtil.pack(message)));
    }

    public Packet createCameraIntrinsics(float fx, float fy, float cx, float cy, float width, float height) {
        return Packet.create(nativeCreateCameraIntrinsics(this.mediapipeGraph.getNativeHandle(), fx, fy, cx, cy, width, height));
    }

    public Packet createGpuBuffer(int name, int width, int height, int format, TextureReleaseCallback releaseCallback, SyncMode syncMode) {
        return Packet.create(nativeCreateGpuBuffer(this.mediapipeGraph.getNativeHandle(), name, width, height, format, releaseCallback, syncMode.value));
    }

    public Packet createGpuBuffer(int name, int width, int height, int format, TextureReleaseCallback releaseCallback) {
        return createGpuBuffer(name, width, height, format, releaseCallback, SyncMode.NO_SYNC);
    }

    public Packet createGpuBuffer(int name, int width, int height, TextureReleaseCallback releaseCallback, SyncMode syncMode) {
        return createGpuBuffer(name, width, height, GL_RGBA, releaseCallback, syncMode);
    }

    public Packet createGpuBuffer(int name, int width, int height, TextureReleaseCallback releaseCallback) {
        return createGpuBuffer(name, width, height, releaseCallback, SyncMode.NO_SYNC);
    }

    @Deprecated
    public Packet createGpuBuffer(int name, int width, int height) {
        return createGpuBuffer(name, width, height, GL_RGBA, (TextureReleaseCallback) null);
    }

    public Packet createGpuBuffer(TextureFrame frame, SyncMode syncMode) {
        return Packet.create(nativeCreateGpuBuffer(this.mediapipeGraph.getNativeHandle(), frame.getTextureName(), frame.getWidth(), frame.getHeight(), frame.getFormat(), frame, syncMode.value));
    }

    public Packet createGpuBuffer(TextureFrame frame) {
        return createGpuBuffer(frame, SyncMode.NO_SYNC);
    }

    public Packet createImage(TextureFrame frame) {
        return Packet.create(nativeCreateGpuImage(this.mediapipeGraph.getNativeHandle(), frame.getTextureName(), frame.getWidth(), frame.getHeight(), frame.getFormat(), frame));
    }

    /* JADX WARN: Code duplicated, block: B:14:0x001c  */
    /* JADX WARN: Code duplicated, block: B:16:0x0030  */
    public Packet createImage(ByteBuffer buffer, int width, int height, int numChannels) {
        int i;
        int i2;
        int i3;
        if (numChannels != 4) {
            if (numChannels == 3) {
                i2 = 4 * (((width * 3) + 3) / 4);
            } else {
                if (numChannels != 1) {
                    throw new IllegalArgumentException("Channels should be: 1, 3, or 4, but is " + numChannels);
                }
                i = width;
            }
            i3 = i * height;
            if (buffer.capacity() == i3) {
                throw new IllegalArgumentException("The size of the buffer should be: " + i3 + " but is " + buffer.capacity());
            }
            return Packet.create(nativeCreateCpuImage(this.mediapipeGraph.getNativeHandle(), buffer, width, height, i, numChannels));
        }
        i2 = width * 4;
        i = i2;
        i3 = i * height;
        if (buffer.capacity() == i3) {
            throw new IllegalArgumentException("The size of the buffer should be: " + i3 + " but is " + buffer.capacity());
        }
        return Packet.create(nativeCreateCpuImage(this.mediapipeGraph.getNativeHandle(), buffer, width, height, i, numChannels));
    }

    private void releaseWithSyncToken(long nativeSyncToken, TextureReleaseCallback releaseCallback) {
        releaseCallback.release(new GraphGlSyncToken(nativeSyncToken));
    }
}
