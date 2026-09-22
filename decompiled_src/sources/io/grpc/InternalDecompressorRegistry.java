package io.grpc;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class InternalDecompressorRegistry {
    private InternalDecompressorRegistry() {
    }

    public static byte[] getRawAdvertisedMessageEncodings(DecompressorRegistry decompressorRegistry) {
        return decompressorRegistry.getRawAdvertisedMessageEncodings();
    }
}
