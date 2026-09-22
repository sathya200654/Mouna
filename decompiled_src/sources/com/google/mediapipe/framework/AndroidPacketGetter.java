package com.google.mediapipe.framework;

import android.graphics.Bitmap;
import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class AndroidPacketGetter {
    public static Bitmap getBitmap(Packet packet) {
        int imageNumChannels = PacketGetter.getImageNumChannels(packet);
        if (imageNumChannels == 1) {
            return getBitmapFromGray8(packet);
        }
        if (imageNumChannels == 3) {
            return getBitmapFromRgb(packet);
        }
        if (imageNumChannels == 4) {
            return getBitmapFromRgba(packet);
        }
        throw new UnsupportedOperationException("Unsupported number of channels: " + imageNumChannels);
    }

    public static Bitmap getBitmapFromGray8(Packet packet) {
        int imageWidth = PacketGetter.getImageWidth(packet);
        int imageHeight = PacketGetter.getImageHeight(packet);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(imageWidth, imageHeight, Bitmap.Config.ALPHA_8);
        copyGray8ToBitmap(packet, bitmapCreateBitmap, imageWidth, imageHeight);
        return bitmapCreateBitmap;
    }

    public static void copyGray8ToBitmap(Packet packet, Bitmap inBitmap) {
        Preconditions.checkArgument(inBitmap.isMutable(), "Input bitmap should be mutable.");
        Preconditions.checkArgument(inBitmap.getConfig() == Bitmap.Config.ALPHA_8, "Input bitmap should be of type ALPHA_8.");
        int imageWidth = PacketGetter.getImageWidth(packet);
        int imageHeight = PacketGetter.getImageHeight(packet);
        Preconditions.checkArgument(inBitmap.getByteCount() == imageWidth * imageHeight, "Input bitmap size mismatch.");
        copyGray8ToBitmap(packet, inBitmap, imageWidth, imageHeight);
    }

    private static void copyGray8ToBitmap(Packet packet, Bitmap mutableBitmap, int width, int height) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(width * height);
        Preconditions.checkState(PacketGetter.getImageData(packet, byteBufferAllocateDirect), String.format(Locale.getDefault(), "Got error from getImageData, returning null Bitmap. Image width %d, height %d", Integer.valueOf(width), Integer.valueOf(height)));
        mutableBitmap.copyPixelsFromBuffer(byteBufferAllocateDirect);
    }

    public static Bitmap getBitmapFromRgb(Packet packet) {
        int imageWidth = PacketGetter.getImageWidth(packet);
        int imageHeight = PacketGetter.getImageHeight(packet);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(imageWidth, imageHeight, Bitmap.Config.ARGB_8888);
        copyRgbToBitmap(packet, bitmapCreateBitmap, imageWidth, imageHeight);
        return bitmapCreateBitmap;
    }

    public static void copyRgbToBitmap(Packet packet, Bitmap inBitmap) {
        Preconditions.checkArgument(inBitmap.isMutable(), "Input bitmap should be mutable.");
        Preconditions.checkArgument(inBitmap.getConfig() == Bitmap.Config.ARGB_8888, "Input bitmap should be of type ARGB_8888.");
        int imageWidth = PacketGetter.getImageWidth(packet);
        int imageHeight = PacketGetter.getImageHeight(packet);
        Preconditions.checkArgument(inBitmap.getByteCount() == (imageWidth * imageHeight) * 4, "Input bitmap size mismatch.");
        copyRgbToBitmap(packet, inBitmap, imageWidth, imageHeight);
    }

    private static void copyRgbToBitmap(Packet packet, Bitmap mutableBitmap, int width, int height) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(width * height * 4);
        PacketGetter.getRgbaFromRgb(packet, byteBufferAllocateDirect);
        mutableBitmap.copyPixelsFromBuffer(byteBufferAllocateDirect);
    }

    public static Bitmap getBitmapFromRgba(Packet packet) {
        int imageWidth = PacketGetter.getImageWidth(packet);
        int imageHeight = PacketGetter.getImageHeight(packet);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(imageWidth, imageHeight, Bitmap.Config.ARGB_8888);
        copyRgbaToBitmap(packet, bitmapCreateBitmap, imageWidth, imageHeight);
        return bitmapCreateBitmap;
    }

    public static void copyRgbaToBitmap(Packet packet, Bitmap inBitmap) {
        Preconditions.checkArgument(inBitmap.isMutable(), "Input bitmap should be mutable.");
        Preconditions.checkArgument(inBitmap.getConfig() == Bitmap.Config.ARGB_8888, "Input bitmap should be of type ARGB_8888.");
        int imageWidth = PacketGetter.getImageWidth(packet);
        int imageHeight = PacketGetter.getImageHeight(packet);
        Preconditions.checkArgument(inBitmap.getByteCount() == (imageWidth * imageHeight) * 4, "Input bitmap size mismatch.");
        copyRgbaToBitmap(packet, inBitmap, imageWidth, imageHeight);
    }

    private static void copyRgbaToBitmap(Packet packet, Bitmap mutableBitmap, int width, int height) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(width * height * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        Preconditions.checkState(PacketGetter.getImageData(packet, byteBufferAllocateDirect), String.format(Locale.getDefault(), "Got error from getImageData, returning null Bitmap. Image width %d, height %d", Integer.valueOf(width), Integer.valueOf(height)));
        mutableBitmap.copyPixelsFromBuffer(byteBufferAllocateDirect);
    }

    private AndroidPacketGetter() {
    }
}
