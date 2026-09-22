package com.google.mlkit.genai.common;

import com.google.android.gms.internal.mlkit_genai_common.zzb;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: com.google.mlkit:genai-common@@1.0.0-beta1 */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class BaseRequest {

    /* JADX INFO: compiled from: com.google.mlkit:genai-common@@1.0.0-beta1 */
    @Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
    public @interface OverrideRequestKind {
    }

    public abstract Integer getOverrideRequestKind();

    public int getOverrideRequestKindOrDefault() {
        return ((Integer) zzb.zzb(getOverrideRequestKind()).zza(0)).intValue();
    }
}
