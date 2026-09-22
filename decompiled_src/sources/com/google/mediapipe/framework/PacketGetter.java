package com.google.mediapipe.framework;

import com.google.common.base.Preconditions;
import com.google.common.flogger.FluentLogger;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class PacketGetter {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    private static native byte[] nativeGetAudioData(long nativePacketHandle);

    private static native boolean nativeGetBool(long nativePacketHandle);

    private static native byte[] nativeGetBytes(long nativePacketHandle);

    private static native float nativeGetFloat32(long nativePacketHandle);

    private static native float[] nativeGetFloat32Vector(long nativePacketHandle);

    private static native double nativeGetFloat64(long nativePacketHandle);

    private static native double[] nativeGetFloat64Vector(long nativePacketHandle);

    private static native long nativeGetGpuBuffer(long nativePacketHandle, boolean waitOnCpu);

    private static native int nativeGetGpuBufferName(long nativePacketHandle);

    private static native boolean nativeGetImageData(long nativePacketHandle, ByteBuffer buffer);

    private static native ByteBuffer nativeGetImageDataDirect(long nativePacketHandle);

    private static native int nativeGetImageHeight(long nativePacketHandle);

    private static native int nativeGetImageHeightFromImageList(long nativePacketHandle);

    private static native boolean nativeGetImageList(long nativePacketHandle, ByteBuffer[] bufferArray, boolean deepCopy);

    private static native int nativeGetImageListSize(long nativePacketHandle);

    private static native int nativeGetImageNumChannels(long nativePacketHandle);

    private static native int nativeGetImageWidth(long nativePacketHandle);

    private static native int nativeGetImageWidthFromImageList(long nativePacketHandle);

    private static native short nativeGetInt16(long nativePacketHandle);

    private static native short[] nativeGetInt16Vector(long nativePacketHandle);

    private static native int nativeGetInt32(long nativePacketHandle);

    private static native int[] nativeGetInt32Vector(long nativePacketHandle);

    private static native long nativeGetInt64(long nativePacketHandle);

    private static native long[] nativeGetInt64Vector(long nativePacketHandle);

    private static native int nativeGetMatrixCols(long nativePacketHandle);

    private static native float[] nativeGetMatrixData(long nativePacketHandle);

    private static native int nativeGetMatrixRows(long nativePacketHandle);

    private static native long nativeGetPacketFromReference(long nativePacketHandle);

    private static native long[] nativeGetPairPackets(long nativePacketHandle);

    private static native void nativeGetProto(long nativePacketHandle, ProtoUtil.SerializedMessage result);

    private static native byte[] nativeGetProtoBytes(long nativePacketHandle);

    private static native byte[][] nativeGetProtoVector(long nativePacketHandle);

    private static native boolean nativeGetRgbaFromRgb(long nativePacketHandle, ByteBuffer buffer);

    private static native String nativeGetString(long nativePacketHandle);

    private static native int nativeGetTimeSeriesHeaderNumChannels(long nativepackethandle);

    private static native double nativeGetTimeSeriesHeaderSampleRate(long nativepackethandle);

    private static native long[] nativeGetVectorPackets(long nativePacketHandle);

    private static native int nativeGetVideoHeaderHeight(long nativepackethandle);

    private static native int nativeGetVideoHeaderWidth(long nativepackethandle);

    public static class PacketPair {
        public final Packet first;
        public final Packet second;

        public PacketPair(Packet first, Packet second) {
            this.first = first;
            this.second = second;
        }
    }

    public static Packet getPacketFromReference(final Packet referencePacket) {
        return Packet.create(nativeGetPacketFromReference(referencePacket.getNativeHandle()));
    }

    public static PacketPair getPairOfPackets(final Packet packet) {
        long[] jArrNativeGetPairPackets = nativeGetPairPackets(packet.getNativeHandle());
        return new PacketPair(Packet.create(jArrNativeGetPairPackets[0]), Packet.create(jArrNativeGetPairPackets[1]));
    }

    public static List<Packet> getVectorOfPackets(final Packet packet) {
        long[] jArrNativeGetVectorPackets = nativeGetVectorPackets(packet.getNativeHandle());
        ArrayList arrayList = new ArrayList(jArrNativeGetVectorPackets.length);
        for (long j : jArrNativeGetVectorPackets) {
            arrayList.add(Packet.create(j));
        }
        return arrayList;
    }

    public static short getInt16(final Packet packet) {
        return nativeGetInt16(packet.getNativeHandle());
    }

    public static int getInt32(final Packet packet) {
        return nativeGetInt32(packet.getNativeHandle());
    }

    public static long getInt64(final Packet packet) {
        return nativeGetInt64(packet.getNativeHandle());
    }

    public static float getFloat32(final Packet packet) {
        return nativeGetFloat32(packet.getNativeHandle());
    }

    public static double getFloat64(final Packet packet) {
        return nativeGetFloat64(packet.getNativeHandle());
    }

    public static boolean getBool(final Packet packet) {
        return nativeGetBool(packet.getNativeHandle());
    }

    public static String getString(final Packet packet) {
        return nativeGetString(packet.getNativeHandle());
    }

    public static byte[] getBytes(final Packet packet) {
        return nativeGetBytes(packet.getNativeHandle());
    }

    public static byte[] getProtoBytes(final Packet packet) {
        return nativeGetProtoBytes(packet.getNativeHandle());
    }

    public static <T extends MessageLite> T getProto(Packet packet, T t) throws InvalidProtocolBufferException {
        ProtoUtil.SerializedMessage serializedMessage = new ProtoUtil.SerializedMessage();
        nativeGetProto(packet.getNativeHandle(), serializedMessage);
        return (T) ProtoUtil.unpack(serializedMessage, t);
    }

    public static <T extends MessageLite> T getProto(final Packet packet, Parser<T> messageParser) {
        ProtoUtil.SerializedMessage serializedMessage = new ProtoUtil.SerializedMessage();
        nativeGetProto(packet.getNativeHandle(), serializedMessage);
        try {
            return messageParser.parseFrom(serializedMessage.value);
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Deprecated
    public static <T extends MessageLite> T getProto(Packet packet, Class<T> cls) throws InvalidProtocolBufferException {
        return (T) getProto(packet, Internal.getDefaultInstance(cls));
    }

    public static short[] getInt16Vector(final Packet packet) {
        return nativeGetInt16Vector(packet.getNativeHandle());
    }

    public static int[] getInt32Vector(final Packet packet) {
        return nativeGetInt32Vector(packet.getNativeHandle());
    }

    public static long[] getInt64Vector(final Packet packet) {
        return nativeGetInt64Vector(packet.getNativeHandle());
    }

    public static float[] getFloat32Vector(final Packet packet) {
        return nativeGetFloat32Vector(packet.getNativeHandle());
    }

    public static double[] getFloat64Vector(final Packet packet) {
        return nativeGetFloat64Vector(packet.getNativeHandle());
    }

    public static <T> List<T> getProtoVector(final Packet packet, Parser<T> messageParser) {
        byte[][] bArrNativeGetProtoVector = nativeGetProtoVector(packet.getNativeHandle());
        Preconditions.checkNotNull(bArrNativeGetProtoVector, "Vector of protocol buffer objects should not be null!");
        try {
            ArrayList arrayList = new ArrayList();
            for (byte[] bArr : bArrNativeGetProtoVector) {
                arrayList.add(messageParser.parseFrom(bArr));
            }
            return arrayList;
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static <T extends MessageLite> List<T> getProtoVector(final Packet packet, T defaultInstance) {
        return getProtoVector(packet, defaultInstance.getParserForType());
    }

    public static int getImageWidth(final Packet packet) {
        return nativeGetImageWidth(packet.getNativeHandle());
    }

    public static int getImageHeight(final Packet packet) {
        return nativeGetImageHeight(packet.getNativeHandle());
    }

    public static int getImageNumChannels(final Packet packet) {
        return nativeGetImageNumChannels(packet.getNativeHandle());
    }

    public static boolean getImageData(final Packet packet, ByteBuffer buffer) {
        return nativeGetImageData(packet.getNativeHandle(), buffer);
    }

    @Nullable
    public static ByteBuffer getImageDataDirectly(final Packet packet) {
        return nativeGetImageDataDirect(packet.getNativeHandle()).asReadOnlyBuffer();
    }

    public static int getImageListSize(final Packet packet) {
        return nativeGetImageListSize(packet.getNativeHandle());
    }

    public static int getImageWidthFromImageList(final Packet packet) {
        return nativeGetImageWidthFromImageList(packet.getNativeHandle());
    }

    public static int getImageHeightFromImageList(final Packet packet) {
        return nativeGetImageHeightFromImageList(packet.getNativeHandle());
    }

    public static boolean getImageList(final Packet packet, ByteBuffer[] buffersArray, boolean deepCopy) {
        return nativeGetImageList(packet.getNativeHandle(), buffersArray, deepCopy);
    }

    public static boolean getRgbaFromRgb(final Packet packet, ByteBuffer buffer) {
        return nativeGetRgbaFromRgb(packet.getNativeHandle(), buffer);
    }

    public static byte[] getAudioByteData(final Packet packet) {
        return nativeGetAudioData(packet.getNativeHandle());
    }

    public static int getAudioDataNumChannels(final Packet packet) {
        return nativeGetMatrixRows(packet.getNativeHandle());
    }

    public static int getAudioDataNumSamples(final Packet packet) {
        return nativeGetMatrixCols(packet.getNativeHandle());
    }

    public static int getTimeSeriesHeaderNumChannels(final Packet packet) {
        return nativeGetTimeSeriesHeaderNumChannels(packet.getNativeHandle());
    }

    public static double getTimeSeriesHeaderSampleRate(final Packet packet) {
        return nativeGetTimeSeriesHeaderSampleRate(packet.getNativeHandle());
    }

    public static int getVideoHeaderWidth(final Packet packet) {
        return nativeGetVideoHeaderWidth(packet.getNativeHandle());
    }

    public static int getVideoHeaderHeight(final Packet packet) {
        return nativeGetVideoHeaderHeight(packet.getNativeHandle());
    }

    public static float[] getMatrixData(final Packet packet) {
        return nativeGetMatrixData(packet.getNativeHandle());
    }

    public static int getMatrixRows(final Packet packet) {
        return nativeGetMatrixRows(packet.getNativeHandle());
    }

    public static int getMatrixCols(final Packet packet) {
        return nativeGetMatrixCols(packet.getNativeHandle());
    }

    @Deprecated
    public static int getGpuBufferName(final Packet packet) {
        return nativeGetGpuBufferName(packet.getNativeHandle());
    }

    public static GraphTextureFrame getTextureFrame(final Packet packet) {
        return new GraphTextureFrame(nativeGetGpuBuffer(packet.getNativeHandle(), true), packet.getTimestamp());
    }

    public static GraphTextureFrame getTextureFrameDeferredSync(final Packet packet) {
        return new GraphTextureFrame(nativeGetGpuBuffer(packet.getNativeHandle(), false), packet.getTimestamp(), true);
    }

    private PacketGetter() {
    }
}
