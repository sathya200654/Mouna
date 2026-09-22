package com.azure.core.implementation.util;

import com.azure.core.util.BinaryData;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class BinaryDataHelper {
    private static BinaryDataAccessor accessor;

    public interface BinaryDataAccessor {
        BinaryData createBinaryData(BinaryDataContent binaryDataContent);

        BinaryDataContent getContent(BinaryData binaryData);
    }

    public static void setAccessor(BinaryDataAccessor binaryDataAccessor) {
        accessor = binaryDataAccessor;
    }

    public static BinaryData createBinaryData(BinaryDataContent binaryDataContent) {
        ensureAccessorSet();
        return accessor.createBinaryData(binaryDataContent);
    }

    public static BinaryDataContent getContent(BinaryData binaryData) {
        ensureAccessorSet();
        return accessor.getContent(binaryData);
    }

    private static void ensureAccessorSet() {
        if (accessor == null) {
            BinaryData.fromString("");
        }
    }
}
