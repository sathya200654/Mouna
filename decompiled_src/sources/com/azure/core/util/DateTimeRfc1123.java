package com.azure.core.util;

import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.nio.charset.StandardCharsets;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class DateTimeRfc1123 {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) DateTimeRfc1123.class);
    private final OffsetDateTime dateTime;

    public DateTimeRfc1123(OffsetDateTime offsetDateTime) {
        this.dateTime = offsetDateTime;
    }

    public DateTimeRfc1123(String str) {
        this.dateTime = parse(str);
    }

    public OffsetDateTime getDateTime() {
        return this.dateTime;
    }

    @JsonCreator
    static DateTimeRfc1123 fromString(String str) {
        if (CoreUtils.isNullOrEmpty(str)) {
            return null;
        }
        return new DateTimeRfc1123(str);
    }

    private static OffsetDateTime parse(String str) {
        try {
            return OffsetDateTime.of(LocalDateTime.of(parseInt(str, 12, 16), parseMonth(str), parseInt(str, 5, 7), parseInt(str, 17, 19), parseInt(str, 20, 22), parseInt(str, 23, 25), 0), ZoneOffset.UTC);
        } catch (IllegalArgumentException | IndexOutOfBoundsException | DateTimeException unused) {
            return OffsetDateTime.parse(str, DateTimeFormatter.RFC_1123_DATE_TIME);
        }
    }

    private static int parseInt(String str, int i, int i2) {
        int i3 = 0;
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt < '0' || cCharAt > '9') {
                throw LOGGER.logExceptionAsError(new DateTimeException("Invalid date time: " + str));
            }
            i3 = (i3 * 10) + (cCharAt - '0');
            i++;
        }
        return i3;
    }

    private static Month parseMonth(CharSequence charSequence) {
        char cCharAt = charSequence.charAt(8);
        if (cCharAt == 'A') {
            char cCharAt2 = charSequence.charAt(10);
            if (cCharAt2 == 'g') {
                return Month.AUGUST;
            }
            if (cCharAt2 == 'r') {
                return Month.APRIL;
            }
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("Unknown month " + ((Object) charSequence)));
        }
        if (cCharAt == 'D') {
            return Month.DECEMBER;
        }
        if (cCharAt == 'F') {
            return Month.FEBRUARY;
        }
        if (cCharAt == 'J') {
            char cCharAt3 = charSequence.charAt(9);
            if (cCharAt3 == 'a') {
                return Month.JANUARY;
            }
            if (cCharAt3 == 'u') {
                char cCharAt4 = charSequence.charAt(10);
                if (cCharAt4 == 'l') {
                    return Month.JULY;
                }
                if (cCharAt4 == 'n') {
                    return Month.JUNE;
                }
                throw LOGGER.logExceptionAsError(new IllegalArgumentException("Unknown month " + ((Object) charSequence)));
            }
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("Unknown month " + ((Object) charSequence)));
        }
        if (cCharAt != 'S') {
            switch (cCharAt) {
                case 'M':
                    char cCharAt5 = charSequence.charAt(10);
                    if (cCharAt5 == 'r') {
                        return Month.MARCH;
                    }
                    if (cCharAt5 == 'y') {
                        return Month.MAY;
                    }
                    throw LOGGER.logExceptionAsError(new IllegalArgumentException("Unknown month " + ((Object) charSequence)));
                case 'N':
                    return Month.NOVEMBER;
                case 'O':
                    return Month.OCTOBER;
                default:
                    throw LOGGER.logExceptionAsError(new IllegalArgumentException("Unknown month " + ((Object) charSequence)));
            }
        }
        return Month.SEPTEMBER;
    }

    public static String toRfc1123String(OffsetDateTime offsetDateTime) {
        OffsetDateTime offsetDateTimeWithOffsetSameInstant = offsetDateTime.withOffsetSameInstant(ZoneOffset.UTC);
        byte[] bArr = new byte[29];
        DayOfWeek dayOfWeek = offsetDateTimeWithOffsetSameInstant.getDayOfWeek();
        switch (AnonymousClass1.$SwitchMap$java$time$DayOfWeek[dayOfWeek.ordinal()]) {
            case 1:
                bArr[0] = 77;
                bArr[1] = 111;
                bArr[2] = 110;
                break;
            case 2:
                bArr[0] = 84;
                bArr[1] = 117;
                bArr[2] = 101;
                break;
            case 3:
                bArr[0] = 87;
                bArr[1] = 101;
                bArr[2] = 100;
                break;
            case 4:
                bArr[0] = 84;
                bArr[1] = 104;
                bArr[2] = 117;
                break;
            case 5:
                bArr[0] = 70;
                bArr[1] = 114;
                bArr[2] = 105;
                break;
            case 6:
                bArr[0] = 83;
                bArr[1] = 97;
                bArr[2] = 116;
                break;
            case 7:
                bArr[0] = 83;
                bArr[1] = 117;
                bArr[2] = 110;
                break;
            default:
                throw LOGGER.logExceptionAsError(new IllegalArgumentException("Unknown day of week " + dayOfWeek));
        }
        bArr[3] = 44;
        bArr[4] = 32;
        zeroPad(offsetDateTimeWithOffsetSameInstant.getDayOfMonth(), bArr, 5);
        bArr[7] = 32;
        Month month = offsetDateTimeWithOffsetSameInstant.getMonth();
        switch (AnonymousClass1.$SwitchMap$java$time$Month[month.ordinal()]) {
            case 1:
                bArr[8] = 74;
                bArr[9] = 97;
                bArr[10] = 110;
                break;
            case 2:
                bArr[8] = 70;
                bArr[9] = 101;
                bArr[10] = 98;
                break;
            case 3:
                bArr[8] = 77;
                bArr[9] = 97;
                bArr[10] = 114;
                break;
            case 4:
                bArr[8] = 65;
                bArr[9] = 112;
                bArr[10] = 114;
                break;
            case 5:
                bArr[8] = 77;
                bArr[9] = 97;
                bArr[10] = 121;
                break;
            case 6:
                bArr[8] = 74;
                bArr[9] = 117;
                bArr[10] = 110;
                break;
            case 7:
                bArr[8] = 74;
                bArr[9] = 117;
                bArr[10] = 108;
                break;
            case 8:
                bArr[8] = 65;
                bArr[9] = 117;
                bArr[10] = 103;
                break;
            case 9:
                bArr[8] = 83;
                bArr[9] = 101;
                bArr[10] = 112;
                break;
            case 10:
                bArr[8] = 79;
                bArr[9] = 99;
                bArr[10] = 116;
                break;
            case 11:
                bArr[8] = 78;
                bArr[9] = 111;
                bArr[10] = 118;
                break;
            case 12:
                bArr[8] = 68;
                bArr[9] = 101;
                bArr[10] = 99;
                break;
            default:
                throw LOGGER.logExceptionAsError(new IllegalArgumentException("Unknown month " + month));
        }
        bArr[11] = 32;
        int year = offsetDateTimeWithOffsetSameInstant.getYear();
        int i = year / 1000;
        bArr[12] = (byte) (i + 48);
        int i2 = year - (i * 1000);
        int i3 = i2 / 100;
        bArr[13] = (byte) (i3 + 48);
        int i4 = i2 - (i3 * 100);
        int i5 = i4 / 10;
        bArr[14] = (byte) (i5 + 48);
        bArr[15] = (byte) ((i4 - (i5 * 10)) + 48);
        bArr[16] = 32;
        zeroPad(offsetDateTimeWithOffsetSameInstant.getHour(), bArr, 17);
        bArr[19] = 58;
        zeroPad(offsetDateTimeWithOffsetSameInstant.getMinute(), bArr, 20);
        bArr[22] = 58;
        zeroPad(offsetDateTimeWithOffsetSameInstant.getSecond(), bArr, 23);
        bArr[25] = 32;
        bArr[26] = 71;
        bArr[27] = 77;
        bArr[28] = 84;
        return new String(bArr, StandardCharsets.UTF_8);
    }

    /* JADX INFO: renamed from: com.azure.core.util.DateTimeRfc1123$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$time$DayOfWeek;
        static final /* synthetic */ int[] $SwitchMap$java$time$Month;

        static {
            int[] iArr = new int[Month.values().length];
            $SwitchMap$java$time$Month = iArr;
            try {
                iArr[Month.JANUARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$time$Month[Month.FEBRUARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$time$Month[Month.MARCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$time$Month[Month.APRIL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$time$Month[Month.MAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$time$Month[Month.JUNE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$time$Month[Month.JULY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$java$time$Month[Month.AUGUST.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$java$time$Month[Month.SEPTEMBER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$java$time$Month[Month.OCTOBER.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$java$time$Month[Month.NOVEMBER.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$java$time$Month[Month.DECEMBER.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            int[] iArr2 = new int[DayOfWeek.values().length];
            $SwitchMap$java$time$DayOfWeek = iArr2;
            try {
                iArr2[DayOfWeek.MONDAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$java$time$DayOfWeek[DayOfWeek.TUESDAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$java$time$DayOfWeek[DayOfWeek.WEDNESDAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$java$time$DayOfWeek[DayOfWeek.THURSDAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$java$time$DayOfWeek[DayOfWeek.FRIDAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$java$time$DayOfWeek[DayOfWeek.SATURDAY.ordinal()] = 6;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$java$time$DayOfWeek[DayOfWeek.SUNDAY.ordinal()] = 7;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    private static void zeroPad(int i, byte[] bArr, int i2) {
        if (i < 10) {
            bArr[i2] = 48;
            bArr[i2 + 1] = (byte) (i + 48);
        } else {
            int i3 = i / 10;
            bArr[i2] = (byte) (i3 + 48);
            bArr[i2 + 1] = (byte) ((i - (i3 * 10)) + 48);
        }
    }

    public String toString() {
        return toRfc1123String(this.dateTime);
    }

    public int hashCode() {
        return this.dateTime.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof DateTimeRfc1123)) {
            return this.dateTime.equals(((DateTimeRfc1123) obj).getDateTime());
        }
        return false;
    }
}
