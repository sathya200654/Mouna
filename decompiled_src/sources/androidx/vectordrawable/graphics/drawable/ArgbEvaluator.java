package androidx.vectordrawable.graphics.drawable;

import android.animation.TypeEvaluator;
import com.google.firebase.perf.util.Constants;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class ArgbEvaluator implements TypeEvaluator {
    private static final ArgbEvaluator sInstance = new ArgbEvaluator();

    public static ArgbEvaluator getInstance() {
        return sInstance;
    }

    @Override // android.animation.TypeEvaluator
    public Object evaluate(float f, Object obj, Object obj2) {
        int iIntValue = ((Integer) obj).intValue();
        float f2 = ((iIntValue >> 24) & Constants.MAX_HOST_LENGTH) / 255.0f;
        float f3 = ((iIntValue >> 16) & Constants.MAX_HOST_LENGTH) / 255.0f;
        float f4 = ((iIntValue >> 8) & Constants.MAX_HOST_LENGTH) / 255.0f;
        float f5 = (iIntValue & Constants.MAX_HOST_LENGTH) / 255.0f;
        int iIntValue2 = ((Integer) obj2).intValue();
        float f6 = ((iIntValue2 >> 24) & Constants.MAX_HOST_LENGTH) / 255.0f;
        float f7 = ((iIntValue2 >> 16) & Constants.MAX_HOST_LENGTH) / 255.0f;
        float f8 = ((iIntValue2 >> 8) & Constants.MAX_HOST_LENGTH) / 255.0f;
        float f9 = (iIntValue2 & Constants.MAX_HOST_LENGTH) / 255.0f;
        float fPow = (float) Math.pow(f3, 2.2d);
        float fPow2 = (float) Math.pow(f4, 2.2d);
        float fPow3 = (float) Math.pow(f5, 2.2d);
        float fPow4 = (float) Math.pow(f7, 2.2d);
        float f10 = f2 + ((f6 - f2) * f);
        float fPow5 = fPow2 + ((((float) Math.pow(f8, 2.2d)) - fPow2) * f);
        float fPow6 = fPow3 + (f * (((float) Math.pow(f9, 2.2d)) - fPow3));
        float fPow7 = ((float) Math.pow(fPow + ((fPow4 - fPow) * f), 0.45454545454545453d)) * 255.0f;
        float fPow8 = ((float) Math.pow(fPow5, 0.45454545454545453d)) * 255.0f;
        return Integer.valueOf(Math.round(((float) Math.pow(fPow6, 0.45454545454545453d)) * 255.0f) | (Math.round(fPow7) << 16) | (Math.round(f10 * 255.0f) << 24) | (Math.round(fPow8) << 8));
    }
}
