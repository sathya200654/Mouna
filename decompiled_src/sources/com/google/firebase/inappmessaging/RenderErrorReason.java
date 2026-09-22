package com.google.firebase.inappmessaging;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public enum RenderErrorReason implements Internal.EnumLite {
    UNSPECIFIED_RENDER_ERROR(0),
    IMAGE_FETCH_ERROR(1),
    IMAGE_DISPLAY_ERROR(2),
    IMAGE_UNSUPPORTED_FORMAT(3);

    public static final int IMAGE_DISPLAY_ERROR_VALUE = 2;
    public static final int IMAGE_FETCH_ERROR_VALUE = 1;
    public static final int IMAGE_UNSUPPORTED_FORMAT_VALUE = 3;
    public static final int UNSPECIFIED_RENDER_ERROR_VALUE = 0;
    private static final Internal.EnumLiteMap<RenderErrorReason> internalValueMap = new Internal.EnumLiteMap<RenderErrorReason>() { // from class: com.google.firebase.inappmessaging.RenderErrorReason.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public RenderErrorReason findValueByNumber(int i) {
            return RenderErrorReason.forNumber(i);
        }
    };
    private final int value;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static RenderErrorReason valueOf(int i) {
        return forNumber(i);
    }

    public static RenderErrorReason forNumber(int i) {
        if (i == 0) {
            return UNSPECIFIED_RENDER_ERROR;
        }
        if (i == 1) {
            return IMAGE_FETCH_ERROR;
        }
        if (i == 2) {
            return IMAGE_DISPLAY_ERROR;
        }
        if (i != 3) {
            return null;
        }
        return IMAGE_UNSUPPORTED_FORMAT;
    }

    public static Internal.EnumLiteMap<RenderErrorReason> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return RenderErrorReasonVerifier.INSTANCE;
    }

    private static final class RenderErrorReasonVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new RenderErrorReasonVerifier();

        private RenderErrorReasonVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return RenderErrorReason.forNumber(i) != null;
        }
    }

    RenderErrorReason(int i) {
        this.value = i;
    }
}
