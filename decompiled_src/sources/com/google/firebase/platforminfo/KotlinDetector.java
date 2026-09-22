package com.google.firebase.platforminfo;

import kotlin.KotlinVersion;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class KotlinDetector {
    private KotlinDetector() {
    }

    public static String detectVersion() {
        try {
            return KotlinVersion.CURRENT.toString();
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }
}
