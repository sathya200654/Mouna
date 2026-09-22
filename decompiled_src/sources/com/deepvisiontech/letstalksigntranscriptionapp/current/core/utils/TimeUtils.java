package com.deepvisiontech.letstalksigntranscriptionapp.current.core.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DateTimeUtils.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u001a\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n¨\u0006\r"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/utils/TimeUtils;", "", "<init>", "()V", "millisToDateString", "", "millis", "", "pattern", "zone", "Ljava/time/ZoneId;", "millisToIsoUtc", "nowAsString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TimeUtils {
    public static final int $stable = 0;
    public static final TimeUtils INSTANCE = new TimeUtils();

    private TimeUtils() {
    }

    public static /* synthetic */ String millisToDateString$default(TimeUtils timeUtils, long j, String str, ZoneId zoneId, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "dd-MM-yyyy";
        }
        if ((i & 4) != 0) {
            zoneId = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(zoneId, "systemDefault(...)");
        }
        return timeUtils.millisToDateString(j, str, zoneId);
    }

    public final String millisToDateString(long millis, String pattern, ZoneId zone) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(zone, "zone");
        String str = Instant.ofEpochMilli(millis).atZone(zone).format(DateTimeFormatter.ofPattern(pattern));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final String millisToIsoUtc(long millis) {
        String str = Instant.ofEpochMilli(millis).atZone(ZoneId.of("UTC")).format(DateTimeFormatter.ISO_INSTANT);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static /* synthetic */ String nowAsString$default(TimeUtils timeUtils, String str, ZoneId zoneId, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        if ((i & 2) != 0) {
            zoneId = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(zoneId, "systemDefault(...)");
        }
        return timeUtils.nowAsString(str, zoneId);
    }

    public final String nowAsString(String pattern, ZoneId zone) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(zone, "zone");
        return millisToDateString(System.currentTimeMillis(), pattern, zone);
    }
}
