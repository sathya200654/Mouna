package com.deepvisiontech.letstalksigntranscriptionapp.current.core.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DateTimeUtils.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t\u001a\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003¨\u0006\u0010"}, d2 = {"dateTimeFormatter", "Ljava/time/format/DateTimeFormatter;", "getDateTimeFormatter", "()Ljava/time/format/DateTimeFormatter;", "dateFormatter", "getDateFormatter", "convertMillisToLocalDateTimeString", "", "millis", "", "convertMillisToLocalDateString", "convertMillisToLocalDateTime", "Ljava/time/LocalDateTime;", "formatDate", "date", "Ljava/time/LocalDate;", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DateTimeUtilsKt {
    private static final DateTimeFormatter dateFormatter;
    private static final DateTimeFormatter dateTimeFormatter;

    static {
        DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("dd-MM-yy hh:mm a");
        Intrinsics.checkNotNullExpressionValue(dateTimeFormatterOfPattern, "ofPattern(...)");
        dateTimeFormatter = dateTimeFormatterOfPattern;
        DateTimeFormatter dateTimeFormatterOfPattern2 = DateTimeFormatter.ofPattern("dd-MM-yy");
        Intrinsics.checkNotNullExpressionValue(dateTimeFormatterOfPattern2, "ofPattern(...)");
        dateFormatter = dateTimeFormatterOfPattern2;
    }

    public static final DateTimeFormatter getDateTimeFormatter() {
        return dateTimeFormatter;
    }

    public static final DateTimeFormatter getDateFormatter() {
        return dateFormatter;
    }

    public static final String convertMillisToLocalDateTimeString(long j) {
        String str = LocalDateTime.ofInstant(Instant.ofEpochMilli(j), ZoneId.systemDefault()).format(dateTimeFormatter);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final String convertMillisToLocalDateString(long j) {
        String str = LocalDateTime.ofInstant(Instant.ofEpochMilli(j), ZoneId.systemDefault()).format(dateFormatter);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final LocalDateTime convertMillisToLocalDateTime(long j) {
        LocalDateTime localDateTimeOfInstant = LocalDateTime.ofInstant(Instant.ofEpochMilli(j), ZoneId.systemDefault());
        Intrinsics.checkNotNullExpressionValue(localDateTimeOfInstant, "ofInstant(...)");
        return localDateTimeOfInstant;
    }

    public static final String formatDate(LocalDate localDate) {
        Intrinsics.checkNotNullParameter(localDate, "date");
        String str = localDate.format(DateTimeFormatter.ofPattern("dd-MM-yy", Locale.getDefault()));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
