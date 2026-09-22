package com.google.firebase.inappmessaging;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public enum EventType implements Internal.EnumLite {
    UNKNOWN_EVENT_TYPE(0),
    IMPRESSION_EVENT_TYPE(1),
    CLICK_EVENT_TYPE(2);

    public static final int CLICK_EVENT_TYPE_VALUE = 2;
    public static final int IMPRESSION_EVENT_TYPE_VALUE = 1;
    public static final int UNKNOWN_EVENT_TYPE_VALUE = 0;
    private static final Internal.EnumLiteMap<EventType> internalValueMap = new Internal.EnumLiteMap<EventType>() { // from class: com.google.firebase.inappmessaging.EventType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public EventType findValueByNumber(int i) {
            return EventType.forNumber(i);
        }
    };
    private final int value;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static EventType valueOf(int i) {
        return forNumber(i);
    }

    public static EventType forNumber(int i) {
        if (i == 0) {
            return UNKNOWN_EVENT_TYPE;
        }
        if (i == 1) {
            return IMPRESSION_EVENT_TYPE;
        }
        if (i != 2) {
            return null;
        }
        return CLICK_EVENT_TYPE;
    }

    public static Internal.EnumLiteMap<EventType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return EventTypeVerifier.INSTANCE;
    }

    private static final class EventTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new EventTypeVerifier();

        private EventTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return EventType.forNumber(i) != null;
        }
    }

    EventType(int i) {
        this.value = i;
    }
}
