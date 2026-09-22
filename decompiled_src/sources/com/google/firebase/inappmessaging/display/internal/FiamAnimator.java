package com.google.firebase.inappmessaging.display.internal;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Application;
import android.graphics.Point;
import android.view.View;
import javax.inject.Inject;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class FiamAnimator {

    public interface AnimationCompleteListener {
        void onComplete();
    }

    @Inject
    FiamAnimator() {
    }

    public void slideIntoView(final Application application, final View view, Position position) {
        view.setAlpha(0.0f);
        Point point = Position.getPoint(position, view);
        view.animate().translationX(point.x).translationY(point.y).setDuration(1L).setListener(new AnimatorListenerAdapter() { // from class: com.google.firebase.inappmessaging.display.internal.FiamAnimator.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.animate().translationX(0.0f).translationY(0.0f).alpha(1.0f).setDuration(application.getResources().getInteger(R.integer.config_longAnimTime)).setListener(null);
            }
        });
    }

    public void slideOutOfView(Application application, View view, Position position, final AnimationCompleteListener animationCompleteListener) {
        Point point = Position.getPoint(position, view);
        view.animate().translationX(point.x).translationY(point.y).setDuration(application.getResources().getInteger(R.integer.config_longAnimTime)).setListener(new AnimatorListenerAdapter() { // from class: com.google.firebase.inappmessaging.display.internal.FiamAnimator.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animationCompleteListener.onComplete();
            }
        });
    }

    public enum Position {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM;

        /* JADX INFO: Access modifiers changed from: private */
        public static Point getPoint(Position position, View view) {
            view.measure(-2, -2);
            int i = AnonymousClass3.$SwitchMap$com$google$firebase$inappmessaging$display$internal$FiamAnimator$Position[position.ordinal()];
            if (i == 1) {
                return new Point(view.getMeasuredWidth() * (-1), 0);
            }
            if (i == 2) {
                return new Point(view.getMeasuredWidth(), 0);
            }
            if (i == 3) {
                return new Point(0, view.getMeasuredHeight() * (-1));
            }
            if (i == 4) {
                return new Point(0, view.getMeasuredHeight());
            }
            return new Point(0, view.getMeasuredHeight() * (-1));
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.inappmessaging.display.internal.FiamAnimator$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$inappmessaging$display$internal$FiamAnimator$Position;

        static {
            int[] iArr = new int[Position.values().length];
            $SwitchMap$com$google$firebase$inappmessaging$display$internal$FiamAnimator$Position = iArr;
            try {
                iArr[Position.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$display$internal$FiamAnimator$Position[Position.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$display$internal$FiamAnimator$Position[Position.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$display$internal$FiamAnimator$Position[Position.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
