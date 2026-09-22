package com.google.firebase.inappmessaging.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import io.reactivex.BackpressureStrategy;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.subjects.BehaviorSubject;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class ForegroundNotifier implements Application.ActivityLifecycleCallbacks {
    public static final long DELAY_MILLIS = 1000;
    private Runnable check;
    private final Handler handler = new Handler();
    private boolean foreground = false;
    private boolean paused = true;
    private final BehaviorSubject<String> foregroundSubject = BehaviorSubject.create();

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public ConnectableFlowable<String> foregroundFlowable() {
        return this.foregroundSubject.toFlowable(BackpressureStrategy.BUFFER).publish();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.paused = false;
        boolean z = this.foreground;
        this.foreground = true;
        Runnable runnable = this.check;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        if (z) {
            return;
        }
        Logging.logi("went foreground");
        this.foregroundSubject.onNext(InAppMessageStreamManager.ON_FOREGROUND);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.paused = true;
        Runnable runnable = this.check;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        Handler handler = this.handler;
        Runnable runnable2 = new Runnable() { // from class: com.google.firebase.inappmessaging.internal.ForegroundNotifier$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m2008xa6082c71();
            }
        };
        this.check = runnable2;
        handler.postDelayed(runnable2, 1000L);
    }

    /* JADX INFO: renamed from: lambda$onActivityPaused$0$com-google-firebase-inappmessaging-internal-ForegroundNotifier, reason: not valid java name */
    /* synthetic */ void m2008xa6082c71() {
        boolean z = this.foreground;
        this.foreground = !(z && this.paused) && z;
    }
}
