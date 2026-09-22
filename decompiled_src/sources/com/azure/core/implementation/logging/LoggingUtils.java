package com.azure.core.implementation.logging;

import com.azure.core.util.CoreUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class LoggingUtils {
    private static final char CR = '\r';
    private static final char LF = '\n';

    private LoggingUtils() {
    }

    public static String removeNewLinesFromLogMessage(String str) {
        if (!CoreUtils.isNullOrEmpty(str)) {
            StringBuilder sb = null;
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (str.charAt(i2) == '\r' || str.charAt(i2) == '\n') {
                    if (sb == null) {
                        sb = new StringBuilder(str.length());
                    }
                    if (i != i2) {
                        sb.append((CharSequence) str, i, i2);
                    }
                    i = i2 + 1;
                }
            }
            if (sb != null) {
                sb.append((CharSequence) str, i, str.length());
                return sb.toString();
            }
        }
        return str;
    }

    public static boolean doesArgsHaveThrowable(Object... objArr) {
        if (objArr.length == 0) {
            return false;
        }
        return objArr[objArr.length - 1] instanceof Throwable;
    }

    public static Object[] removeThrowable(Object... objArr) {
        return Arrays.copyOf(objArr, objArr.length - 1);
    }
}
