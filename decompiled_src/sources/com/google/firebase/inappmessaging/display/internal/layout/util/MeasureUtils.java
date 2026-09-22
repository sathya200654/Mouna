package com.google.firebase.inappmessaging.display.internal.layout.util;

import android.view.View;
import com.google.common.primitives.Ints;
import com.google.firebase.inappmessaging.display.internal.Logging;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class MeasureUtils {
    public static void measureAtMost(View view, int i, int i2) {
        measure(view, i, i2, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public static void measureExactly(View view, int i, int i2) {
        measure(view, i, i2, Ints.MAX_POWER_OF_TWO, Ints.MAX_POWER_OF_TWO);
    }

    public static void measureFullWidth(View view, int i, int i2) {
        measure(view, i, i2, Ints.MAX_POWER_OF_TWO, Integer.MIN_VALUE);
    }

    public static void measureFullHeight(View view, int i, int i2) {
        measure(view, i, i2, Integer.MIN_VALUE, Ints.MAX_POWER_OF_TWO);
    }

    private static void measure(View view, int i, int i2, int i3, int i4) {
        Logging.logdPair("\tdesired (w,h)", view.getMeasuredWidth(), view.getMeasuredHeight());
        if (view.getVisibility() == 8) {
            i = 0;
            i2 = 0;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(i, i3), View.MeasureSpec.makeMeasureSpec(i2, i4));
        Logging.logdPair("\tactual (w,h)", view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
