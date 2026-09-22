package com.azure.core.util.polling;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class LongRunningOperationStatus extends ExpandableStringEnum<LongRunningOperationStatus> {
    public static final LongRunningOperationStatus FAILED;
    public static final LongRunningOperationStatus IN_PROGRESS;
    public static final LongRunningOperationStatus NOT_STARTED;
    private static final Map<String, LongRunningOperationStatus> OPERATION_STATUS_MAP;
    public static final LongRunningOperationStatus SUCCESSFULLY_COMPLETED;
    public static final LongRunningOperationStatus USER_CANCELLED;
    private boolean completed;

    @Deprecated
    public LongRunningOperationStatus() {
    }

    static {
        LongRunningOperationStatus longRunningOperationStatusFromString = fromString("NOT_STARTED", false);
        NOT_STARTED = longRunningOperationStatusFromString;
        LongRunningOperationStatus longRunningOperationStatusFromString2 = fromString("IN_PROGRESS", false);
        IN_PROGRESS = longRunningOperationStatusFromString2;
        LongRunningOperationStatus longRunningOperationStatusFromString3 = fromString("SUCCESSFULLY_COMPLETED", true);
        SUCCESSFULLY_COMPLETED = longRunningOperationStatusFromString3;
        LongRunningOperationStatus longRunningOperationStatusFromString4 = fromString("FAILED", true);
        FAILED = longRunningOperationStatusFromString4;
        LongRunningOperationStatus longRunningOperationStatusFromString5 = fromString("USER_CANCELLED", true);
        USER_CANCELLED = longRunningOperationStatusFromString5;
        HashMap map = new HashMap();
        map.put(longRunningOperationStatusFromString.toString(), longRunningOperationStatusFromString);
        map.put(longRunningOperationStatusFromString2.toString(), longRunningOperationStatusFromString2);
        map.put(longRunningOperationStatusFromString3.toString(), longRunningOperationStatusFromString3);
        map.put(longRunningOperationStatusFromString4.toString(), longRunningOperationStatusFromString4);
        map.put(longRunningOperationStatusFromString5.toString(), longRunningOperationStatusFromString5);
        OPERATION_STATUS_MAP = Collections.unmodifiableMap(map);
    }

    public static LongRunningOperationStatus fromString(String str, boolean z) {
        if (str == null) {
            return null;
        }
        Map<String, LongRunningOperationStatus> map = OPERATION_STATUS_MAP;
        LongRunningOperationStatus longRunningOperationStatus = map != null ? map.get(str) : null;
        if (longRunningOperationStatus != null && longRunningOperationStatus.isComplete() != z) {
            throw new IllegalArgumentException(String.format("Cannot set complete status %s for operation status %s", Boolean.valueOf(z), str));
        }
        LongRunningOperationStatus longRunningOperationStatus2 = (LongRunningOperationStatus) fromString(str, LongRunningOperationStatus.class);
        longRunningOperationStatus2.completed = z;
        return longRunningOperationStatus2;
    }

    public boolean isComplete() {
        return this.completed;
    }
}
