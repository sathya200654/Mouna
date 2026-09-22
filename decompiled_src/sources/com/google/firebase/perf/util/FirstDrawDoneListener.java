package com.google.firebase.perf.util;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class FirstDrawDoneListener implements ViewTreeObserver.OnDrawListener {
    private final Runnable callback;
    private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
    private final AtomicReference<View> viewReference;

    public static void registerForNextDraw(View view, Runnable runnable) {
        view.getViewTreeObserver().addOnDrawListener(new FirstDrawDoneListener(view, runnable));
    }

    /* JADX INFO: renamed from: com.google.firebase.perf.util.FirstDrawDoneListener$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnAttachStateChangeListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.getViewTreeObserver().addOnDrawListener(FirstDrawDoneListener.this);
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
        }
    }

    private FirstDrawDoneListener(View view, Runnable runnable) {
        this.viewReference = new AtomicReference<>(view);
        this.callback = runnable;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public void onDraw() {
        final View andSet = this.viewReference.getAndSet(null);
        if (andSet == null) {
            return;
        }
        andSet.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.google.firebase.perf.util.FirstDrawDoneListener$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f$0.m2153xe13ffe6d(andSet);
            }
        });
        this.mainThreadHandler.postAtFrontOfQueue(this.callback);
    }

    /* JADX INFO: renamed from: lambda$onDraw$0$com-google-firebase-perf-util-FirstDrawDoneListener, reason: not valid java name */
    /* synthetic */ void m2153xe13ffe6d(View view) {
        view.getViewTreeObserver().removeOnDrawListener(this);
    }

    private static boolean isAliveAndAttached(View view) {
        return view.getViewTreeObserver().isAlive() && isAttachedToWindow(view);
    }

    private static boolean isAttachedToWindow(View view) {
        return view.isAttachedToWindow();
    }
}
