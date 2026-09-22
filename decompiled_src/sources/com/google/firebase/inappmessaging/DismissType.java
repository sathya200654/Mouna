package com.google.firebase.inappmessaging;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public enum DismissType implements Internal.EnumLite {
    UNKNOWN_DISMISS_TYPE(0),
    AUTO(1),
    CLICK(2),
    SWIPE(3);

    public static final int AUTO_VALUE = 1;
    public static final int CLICK_VALUE = 2;
    public static final int SWIPE_VALUE = 3;
    public static final int UNKNOWN_DISMISS_TYPE_VALUE = 0;
    private static final Internal.EnumLiteMap<DismissType> internalValueMap = new Internal.EnumLiteMap<DismissType>() { // from class: com.google.firebase.inappmessaging.DismissType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public DismissType findValueByNumber(int i) {
            return DismissType.forNumber(i);
        }
    };
    private final int value;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static DismissType valueOf(int i) {
        return forNumber(i);
    }

    public static DismissType forNumber(int i) {
        if (i == 0) {
            return UNKNOWN_DISMISS_TYPE;
        }
        if (i == 1) {
            return AUTO;
        }
        if (i == 2) {
            return CLICK;
        }
        if (i != 3) {
            return null;
        }
        return SWIPE;
    }

    public static Internal.EnumLiteMap<DismissType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return DismissTypeVerifier.INSTANCE;
    }

    private static final class DismissTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new DismissTypeVerifier();

        private DismissTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return DismissType.forNumber(i) != null;
        }
    }

    DismissType(int i) {
        this.value = i;
    }
}
