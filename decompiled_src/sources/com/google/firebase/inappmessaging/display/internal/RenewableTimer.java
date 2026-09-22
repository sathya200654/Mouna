package com.google.firebase.inappmessaging.display.internal;

import android.os.CountDownTimer;
import javax.inject.Inject;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class RenewableTimer {
    private CountDownTimer mCountDownTimer;

    public interface Callback {
        void onFinish();
    }

    @Inject
    RenewableTimer() {
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.firebase.inappmessaging.display.internal.RenewableTimer$1] */
    public void start(final Callback callback, long j, long j2) {
        this.mCountDownTimer = new CountDownTimer(j, j2) { // from class: com.google.firebase.inappmessaging.display.internal.RenewableTimer.1
            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                callback.onFinish();
            }
        }.start();
    }

    public void cancel() {
        CountDownTimer countDownTimer = this.mCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mCountDownTimer = null;
        }
    }
}
