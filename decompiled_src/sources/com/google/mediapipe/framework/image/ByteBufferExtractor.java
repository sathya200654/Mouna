package com.google.mediapipe.framework.image;

import android.graphics.Bitmap;
import com.google.firebase.perf.util.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class ByteBufferExtractor {
    public static ByteBuffer extract(MPImage image) {
        MPImageContainer container = image.getContainer();
        if (container.getImageProperties().getStorageType() == 2) {
            return ((ByteBufferImageContainer) container).getByteBuffer().asReadOnlyBuffer().order(ByteOrder.nativeOrder());
        }
        throw new IllegalArgumentException("Extract ByteBuffer from a MPImage created by objects other than Bytebuffer is not supported");
    }

    public static ByteBuffer extract(MPImage image, int targetFormat) {
        MPImageContainer container = image.getContainer(MPImageProperties.builder().setStorageType(2).setImageFormat(targetFormat).build());
        if (container != null) {
            return ((ByteBufferImageContainer) container).getByteBuffer().asReadOnlyBuffer().order(ByteOrder.nativeOrder());
        }
        MPImageContainer container2 = image.getContainer(2);
        if (container2 != null) {
            ByteBufferImageContainer byteBufferImageContainer = (ByteBufferImageContainer) container2;
            return convertByteBuffer(byteBufferImageContainer.getByteBuffer(), byteBufferImageContainer.getImageFormat(), targetFormat).asReadOnlyBuffer().order(ByteOrder.nativeOrder());
        }
        MPImageContainer container3 = image.getContainer(1);
        if (container3 != null) {
            ByteBuffer byteBufferAsReadOnlyBuffer = extractByteBufferFromBitmap(((BitmapImageContainer) container3).getBitmap(), targetFormat).asReadOnlyBuffer();
            image.addContainer(new ByteBufferImageContainer(byteBufferAsReadOnlyBuffer, targetFormat));
            return byteBufferAsReadOnlyBuffer;
        }
        throw new IllegalArgumentException("Extracting ByteBuffer from a MPImage created by objects other than Bitmap or Bytebuffer is not supported");
    }

    static abstract class Result {
        public abstract ByteBuffer buffer();

        public abstract int format();

        Result() {
        }

        static Result create(ByteBuffer buffer, int imageFormat) {
            return new AutoValue_ByteBufferExtractor_Result(buffer, imageFormat);
        }
    }

    static Result extractInRecommendedFormat(MPImage image) {
        MPImageContainer container = image.getContainer(1);
        if (container != null) {
            Bitmap bitmap = ((BitmapImageContainer) container).getBitmap();
            int iAdviseImageFormat = adviseImageFormat(bitmap);
            Result resultCreate = Result.create(extractByteBufferFromBitmap(bitmap, iAdviseImageFormat).asReadOnlyBuffer(), iAdviseImageFormat);
            image.addContainer(new ByteBufferImageContainer(resultCreate.buffer(), resultCreate.format()));
            return resultCreate;
        }
        MPImageContainer container2 = image.getContainer(2);
        if (container2 != null) {
            ByteBufferImageContainer byteBufferImageContainer = (ByteBufferImageContainer) container2;
            return Result.create(byteBufferImageContainer.getByteBuffer().asReadOnlyBuffer(), byteBufferImageContainer.getImageFormat());
        }
        throw new IllegalArgumentException("Extract ByteBuffer from a MPImage created by objects other than Bitmap or Bytebuffer is not supported");
    }

    private static int adviseImageFormat(Bitmap bitmap) {
        if (bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
            return 1;
        }
        throw new IllegalArgumentException(String.format("Extracting ByteBuffer from a MPImage created by a Bitmap in config %s is not supported", bitmap.getConfig()));
    }

    private static ByteBuffer extractByteBufferFromBitmap(Bitmap bitmap, int imageFormat) {
        if (bitmap.isPremultiplied()) {
            throw new IllegalArgumentException("Extracting ByteBuffer from a MPImage created by a premultiplied Bitmap is not supported");
        }
        if (bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
            if (imageFormat == 1) {
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(bitmap.getByteCount());
                bitmap.copyPixelsToBuffer(byteBufferAllocateDirect);
                byteBufferAllocateDirect.rewind();
                return byteBufferAllocateDirect;
            }
            if (imageFormat == 2) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int i = width * height;
                int[] iArr = new int[i];
                bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
                ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(i * 3);
                byteBufferAllocateDirect2.order(ByteOrder.nativeOrder());
                for (int i2 = 0; i2 < i; i2++) {
                    int i3 = iArr[i2];
                    byteBufferAllocateDirect2.put((byte) ((i3 >> 16) & Constants.MAX_HOST_LENGTH));
                    byteBufferAllocateDirect2.put((byte) ((i3 >> 8) & Constants.MAX_HOST_LENGTH));
                    byteBufferAllocateDirect2.put((byte) (i3 & Constants.MAX_HOST_LENGTH));
                }
                byteBufferAllocateDirect2.rewind();
                return byteBufferAllocateDirect2;
            }
        }
        throw new IllegalArgumentException(String.format("Extracting ByteBuffer from a MPImage created by Bitmap and convert from %s to format %d is not supported", bitmap.getConfig(), Integer.valueOf(imageFormat)));
    }

    private static ByteBuffer convertByteBuffer(ByteBuffer source, int sourceFormat, int targetFormat) {
        if (sourceFormat == 2 && targetFormat == 1) {
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect((source.capacity() / 3) * 4);
            byte[] bArr = new byte[byteBufferAllocateDirect.capacity()];
            source.get(bArr, 0, source.capacity());
            source.rewind();
            int iCapacity = source.capacity();
            int iCapacity2 = byteBufferAllocateDirect.capacity();
            while (iCapacity != iCapacity2) {
                bArr[iCapacity2 - 1] = -1;
                bArr[iCapacity2 - 2] = bArr[iCapacity - 1];
                bArr[iCapacity2 - 3] = bArr[iCapacity - 2];
                iCapacity2 -= 4;
                iCapacity -= 3;
                bArr[iCapacity2] = bArr[iCapacity];
            }
            byteBufferAllocateDirect.put(bArr, 0, byteBufferAllocateDirect.capacity());
            byteBufferAllocateDirect.rewind();
            return byteBufferAllocateDirect;
        }
        if (sourceFormat == 1 && targetFormat == 2) {
            ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect((source.capacity() / 4) * 3);
            int iCapacity3 = source.capacity();
            byte[] bArr2 = new byte[iCapacity3];
            source.get(bArr2, 0, source.capacity());
            source.rewind();
            int i = 0;
            for (int i2 = 0; i2 < iCapacity3; i2 += 4) {
                bArr2[i] = bArr2[i2];
                int i3 = i + 2;
                bArr2[i + 1] = bArr2[i2 + 1];
                i += 3;
                bArr2[i3] = bArr2[i2 + 2];
            }
            byteBufferAllocateDirect2.put(bArr2, 0, byteBufferAllocateDirect2.capacity());
            byteBufferAllocateDirect2.rewind();
            return byteBufferAllocateDirect2;
        }
        throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Convert bytebuffer image format from %d to %d is not supported", Integer.valueOf(sourceFormat), Integer.valueOf(targetFormat)));
    }

    private ByteBufferExtractor() {
    }
}
