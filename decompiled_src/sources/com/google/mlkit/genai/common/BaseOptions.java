package com.google.mlkit.genai.common;

import com.google.android.gms.internal.mlkit_genai_common.zzb;

/* JADX INFO: compiled from: com.google.mlkit:genai-common@@1.0.0-beta1 */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class BaseOptions {
    public abstract Integer getTargetVersion();

    public int getTargetVersionOrDefault() {
        return ((Integer) zzb.zzb(getTargetVersion()).zza(-1)).intValue();
    }
}
