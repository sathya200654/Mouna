package com.google.mlkit.genai.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;

/* JADX INFO: compiled from: com.google.mlkit:genai-common@@1.0.0-beta1 */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class GenAiUtils {
    private GenAiUtils() {
    }

    public static boolean isAiCoreCompatible(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.aicore", 0).versionCode >= 193575;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }
}
