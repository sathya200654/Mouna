package com.google.firebase.inappmessaging;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public enum FetchErrorReason implements Internal.EnumLite {
    UNSPECIFIED_FETCH_ERROR(0),
    SERVER_ERROR(1),
    CLIENT_ERROR(2),
    NETWORK_ERROR(3);

    public static final int CLIENT_ERROR_VALUE = 2;
    public static final int NETWORK_ERROR_VALUE = 3;
    public static final int SERVER_ERROR_VALUE = 1;
    public static final int UNSPECIFIED_FETCH_ERROR_VALUE = 0;
    private static final Internal.EnumLiteMap<FetchErrorReason> internalValueMap = new Internal.EnumLiteMap<FetchErrorReason>() { // from class: com.google.firebase.inappmessaging.FetchErrorReason.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public FetchErrorReason findValueByNumber(int i) {
            return FetchErrorReason.forNumber(i);
        }
    };
    private final int value;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static FetchErrorReason valueOf(int i) {
        return forNumber(i);
    }

    public static FetchErrorReason forNumber(int i) {
        if (i == 0) {
            return UNSPECIFIED_FETCH_ERROR;
        }
        if (i == 1) {
            return SERVER_ERROR;
        }
        if (i == 2) {
            return CLIENT_ERROR;
        }
        if (i != 3) {
            return null;
        }
        return NETWORK_ERROR;
    }

    public static Internal.EnumLiteMap<FetchErrorReason> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return FetchErrorReasonVerifier.INSTANCE;
    }

    private static final class FetchErrorReasonVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new FetchErrorReasonVerifier();

        private FetchErrorReasonVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return FetchErrorReason.forNumber(i) != null;
        }
    }

    FetchErrorReason(int i) {
        this.value = i;
    }
}
