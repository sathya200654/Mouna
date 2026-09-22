package com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.utils;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.model.VibrationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VibrationHelper.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"triggerVibration", "", "context", "Landroid/content/Context;", "vibrationLevel", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/model/VibrationLevel;", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class VibrationHelperKt {

    /* JADX INFO: compiled from: VibrationHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VibrationLevel.values().length];
            try {
                iArr[VibrationLevel.HIGH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VibrationLevel.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VibrationLevel.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final void triggerVibration(Context context, VibrationLevel vibrationLevel) throws NoWhenBranchMatchedException {
        Vibrator defaultVibrator;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(vibrationLevel, "vibrationLevel");
        if (vibrationLevel == VibrationLevel.NONE) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            Object systemService = context.getSystemService("vibrator_manager");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.VibratorManager");
            defaultVibrator = ((VibratorManager) systemService).getDefaultVibrator();
        } else {
            Object systemService2 = context.getSystemService("vibrator");
            Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.os.Vibrator");
            defaultVibrator = (Vibrator) systemService2;
        }
        Intrinsics.checkNotNull(defaultVibrator);
        int i = WhenMappings.$EnumSwitchMapping$0[vibrationLevel.ordinal()];
        if (i == 1) {
            defaultVibrator.vibrate(VibrationEffect.createWaveform(new long[]{0, 500, 200, 500}, -1));
        } else if (i == 2) {
            defaultVibrator.vibrate(VibrationEffect.createOneShot(300L, -1));
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
    }
}
