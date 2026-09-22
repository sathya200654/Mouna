package com.deepvisiontech.letstalksigntranscriptionapp.legacy.business.helpers;

import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.google.firebase.perf.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VibrationControlsHelper.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"vibrateStrong", "", "Landroid/content/Context;", "duration", "", "amplitude", "", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class VibrationControlsHelperKt {
    public static /* synthetic */ void vibrateStrong$default(Context context, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = 200;
        }
        if ((i2 & 2) != 0) {
            i = Constants.MAX_HOST_LENGTH;
        }
        vibrateStrong(context, j, i);
    }

    public static final void vibrateStrong(Context context, long j, int i) {
        VibrationEffect vibrationEffectCreateOneShot;
        Intrinsics.checkNotNullParameter(context, "<this>");
        Vibrator vibrator = (Vibrator) context.getSystemService(Vibrator.class);
        if (vibrator != null && vibrator.hasVibrator()) {
            if (vibrator.hasAmplitudeControl()) {
                vibrationEffectCreateOneShot = VibrationEffect.createOneShot(j, i);
            } else {
                vibrationEffectCreateOneShot = VibrationEffect.createOneShot(j, -1);
            }
            vibrator.vibrate(vibrationEffectCreateOneShot);
        }
    }
}
