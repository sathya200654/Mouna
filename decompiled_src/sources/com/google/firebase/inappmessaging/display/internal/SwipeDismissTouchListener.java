package com.google.firebase.inappmessaging.display.internal;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class SwipeDismissTouchListener implements View.OnTouchListener {
    private long mAnimationTime;
    private DismissCallbacks mDismissCallbacks;
    private float mDownX;
    private float mDownY;
    private int mMaxFlingVelocity;
    private int mMinFlingVelocity;
    private int mSlop;
    private boolean mSwiping;
    private int mSwipingSlop;
    private Object mToken;
    private float mTranslationX;
    private VelocityTracker mVelocityTracker;
    private View mView;
    private int mViewWidth = 1;

    public interface DismissCallbacks {
        boolean canDismiss(Object obj);

        void onDismiss(View view, Object obj);
    }

    public SwipeDismissTouchListener(View view, Object obj, DismissCallbacks dismissCallbacks) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        this.mSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mAnimationTime = view.getContext().getResources().getInteger(R.integer.config_shortAnimTime);
        this.mView = view;
        this.mToken = obj;
        this.mDismissCallbacks = dismissCallbacks;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        motionEvent.offsetLocation(this.mTranslationX, 0.0f);
        if (this.mViewWidth < 2) {
            this.mViewWidth = this.mView.getWidth();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mDownX = motionEvent.getRawX();
            this.mDownY = motionEvent.getRawY();
            if (this.mDismissCallbacks.canDismiss(this.mToken)) {
                VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
                this.mVelocityTracker = velocityTrackerObtain;
                velocityTrackerObtain.addMovement(motionEvent);
            }
            return false;
        }
        boolean z2 = true;
        if (actionMasked != 1) {
            if (actionMasked != 2) {
                if (actionMasked == 3 && this.mVelocityTracker != null) {
                    startCancelAnimation();
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    this.mTranslationX = 0.0f;
                    this.mDownX = 0.0f;
                    this.mDownY = 0.0f;
                    this.mSwiping = false;
                }
            } else {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    float rawX = motionEvent.getRawX() - this.mDownX;
                    float rawY = motionEvent.getRawY() - this.mDownY;
                    if (Math.abs(rawX) > this.mSlop && Math.abs(rawY) < Math.abs(rawX) / 2.0f) {
                        this.mSwiping = true;
                        this.mSwipingSlop = rawX > 0.0f ? this.mSlop : -this.mSlop;
                        this.mView.getParent().requestDisallowInterceptTouchEvent(true);
                        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                        motionEventObtain.setAction((motionEvent.getActionIndex() << 8) | 3);
                        this.mView.onTouchEvent(motionEventObtain);
                        motionEventObtain.recycle();
                    }
                    if (this.mSwiping) {
                        this.mTranslationX = rawX;
                        setTranslationX(rawX - this.mSwipingSlop);
                        setAlpha(Math.max(0.0f, Math.min(1.0f, 1.0f - ((Math.abs(rawX) * 2.0f) / this.mViewWidth))));
                        return true;
                    }
                }
            }
        } else if (this.mVelocityTracker != null) {
            float rawX2 = motionEvent.getRawX() - this.mDownX;
            this.mVelocityTracker.addMovement(motionEvent);
            this.mVelocityTracker.computeCurrentVelocity(1000);
            float xVelocity = this.mVelocityTracker.getXVelocity();
            float fAbs = Math.abs(xVelocity);
            float fAbs2 = Math.abs(this.mVelocityTracker.getYVelocity());
            if (Math.abs(rawX2) > this.mViewWidth / 2 && this.mSwiping) {
                z = rawX2 > 0.0f;
            } else if (this.mMinFlingVelocity > fAbs || fAbs > this.mMaxFlingVelocity || fAbs2 >= fAbs || fAbs2 >= fAbs || !this.mSwiping) {
                z = false;
                z2 = false;
            } else {
                z2 = ((xVelocity > 0.0f ? 1 : (xVelocity == 0.0f ? 0 : -1)) < 0) == ((rawX2 > 0.0f ? 1 : (rawX2 == 0.0f ? 0 : -1)) < 0);
                z = this.mVelocityTracker.getXVelocity() > 0.0f;
            }
            if (z2) {
                startDismissAnimation(z);
            } else if (this.mSwiping) {
                startCancelAnimation();
            }
            VelocityTracker velocityTracker2 = this.mVelocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
            }
            this.mVelocityTracker = null;
            this.mTranslationX = 0.0f;
            this.mDownX = 0.0f;
            this.mDownY = 0.0f;
            this.mSwiping = false;
        }
        return false;
    }

    protected void setTranslationX(float f) {
        this.mView.setTranslationX(f);
    }

    protected float getTranslationX() {
        return this.mView.getTranslationX();
    }

    protected void setAlpha(float f) {
        this.mView.setAlpha(f);
    }

    protected void startDismissAnimation(boolean z) {
        animateTo(z ? this.mViewWidth : -this.mViewWidth, 0.0f, new AnimatorListenerAdapter() { // from class: com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SwipeDismissTouchListener.this.performDismiss();
            }
        });
    }

    protected void startCancelAnimation() {
        animateTo(0.0f, 1.0f, null);
    }

    private void animateTo(float f, float f2, AnimatorListenerAdapter animatorListenerAdapter) {
        final float translationX = getTranslationX();
        final float f3 = f - translationX;
        final float alpha = this.mView.getAlpha();
        final float f4 = f2 - alpha;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(this.mAnimationTime);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = translationX + (valueAnimator.getAnimatedFraction() * f3);
                float animatedFraction2 = alpha + (valueAnimator.getAnimatedFraction() * f4);
                SwipeDismissTouchListener.this.setTranslationX(animatedFraction);
                SwipeDismissTouchListener.this.setAlpha(animatedFraction2);
            }
        });
        if (animatorListenerAdapter != null) {
            valueAnimatorOfFloat.addListener(animatorListenerAdapter);
        }
        valueAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performDismiss() {
        final ViewGroup.LayoutParams layoutParams = this.mView.getLayoutParams();
        final int height = this.mView.getHeight();
        ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(this.mAnimationTime);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SwipeDismissTouchListener.this.mDismissCallbacks.onDismiss(SwipeDismissTouchListener.this.mView, SwipeDismissTouchListener.this.mToken);
                SwipeDismissTouchListener.this.mView.setAlpha(1.0f);
                SwipeDismissTouchListener.this.mView.setTranslationX(0.0f);
                layoutParams.height = height;
                SwipeDismissTouchListener.this.mView.setLayoutParams(layoutParams);
            }
        });
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SwipeDismissTouchListener.this.mView.setLayoutParams(layoutParams);
            }
        });
        duration.start();
    }
}
