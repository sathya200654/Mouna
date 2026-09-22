package com.squareup.wire.internal;

import java.time.Duration;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DurationJsonFormatter.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0014\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003H\u0016¨\u0006\t"}, d2 = {"Lcom/squareup/wire/internal/DurationJsonFormatter;", "Lcom/squareup/wire/internal/JsonFormatter;", "Ljava/time/Duration;", "Lcom/squareup/wire/Duration;", "()V", "fromString", "value", "", "toStringOrNumber", "wire-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DurationJsonFormatter implements JsonFormatter<Duration> {
    public static final DurationJsonFormatter INSTANCE = new DurationJsonFormatter();

    private DurationJsonFormatter() {
    }

    @Override // com.squareup.wire.internal.JsonFormatter
    public String toStringOrNumber(Duration value) {
        String str;
        Intrinsics.checkNotNullParameter(value, "value");
        long seconds = value.getSeconds();
        int nano = value.getNano();
        if (seconds < 0) {
            if (seconds == Long.MIN_VALUE) {
                str = "-922337203685477580";
                seconds = 8;
            } else {
                seconds = -seconds;
                str = "-";
            }
            if (nano != 0) {
                seconds--;
                nano = 1000000000 - nano;
            }
        } else {
            str = "";
        }
        if (nano == 0) {
            String str2 = String.format("%s%ds", Arrays.copyOf(new Object[]{str, Long.valueOf(seconds)}, 2));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            return str2;
        }
        if (nano % 1000000 == 0) {
            String str3 = String.format("%s%d.%03ds", Arrays.copyOf(new Object[]{str, Long.valueOf(seconds), Long.valueOf(((long) nano) / 1000000)}, 3));
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            return str3;
        }
        if (nano % 1000 == 0) {
            String str4 = String.format("%s%d.%06ds", Arrays.copyOf(new Object[]{str, Long.valueOf(seconds), Long.valueOf(((long) nano) / 1000)}, 3));
            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
            return str4;
        }
        String str5 = String.format("%s%d.%09ds", Arrays.copyOf(new Object[]{str, Long.valueOf(seconds), Long.valueOf(nano)}, 3));
        Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
        return str5;
    }

    @Override // com.squareup.wire.internal.JsonFormatter
    public Duration fromString(String value) {
        int i;
        Intrinsics.checkNotNullParameter(value, "value");
        String str = value;
        int iIndexOf$default = StringsKt.indexOf$default(str, 's', 0, false, 6, (Object) null);
        if (iIndexOf$default != value.length() - 1) {
            throw new NumberFormatException();
        }
        int iIndexOf$default2 = StringsKt.indexOf$default(str, '.', 0, false, 6, (Object) null);
        if (iIndexOf$default2 == -1) {
            String strSubstring = value.substring(0, iIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            Duration durationOfSeconds = Duration.ofSeconds(Long.parseLong(strSubstring));
            Intrinsics.checkNotNullExpressionValue(durationOfSeconds, "ofSeconds(...)");
            return durationOfSeconds;
        }
        String strSubstring2 = value.substring(0, iIndexOf$default2);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        long j = Long.parseLong(strSubstring2);
        int i2 = iIndexOf$default2 + 1;
        String strSubstring3 = value.substring(i2, iIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
        long j2 = Long.parseLong(strSubstring3);
        if (StringsKt.startsWith$default(value, "-", false, 2, (Object) null)) {
            j2 = -j2;
        }
        int i3 = iIndexOf$default - i2;
        int i4 = i3;
        while (true) {
            if (i4 >= 9) {
                break;
            }
            j2 *= (long) 10;
            i4++;
        }
        for (i = 9; i < i3; i++) {
            j2 /= (long) 10;
        }
        Duration durationOfSeconds2 = Duration.ofSeconds(j, j2);
        Intrinsics.checkNotNullExpressionValue(durationOfSeconds2, "ofSeconds(...)");
        return durationOfSeconds2;
    }
}
