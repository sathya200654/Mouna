package com.deepvisiontech.letstalksigntranscriptionapp.legacy.business.managers;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppReviewManager.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/legacy/business/managers/AppReviewManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "preferences", "Landroid/content/SharedPreferences;", "reviewManager", "Lcom/google/android/play/core/review/ReviewManager;", "showFeedBackDialogBoxIfEligible", "", "showReviewIfEligible", "activity", "Landroid/app/Activity;", "isEligibleForReview", "", "saveReviewTimestamp", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AppReviewManager {
    private static final String KEY_FIRST_REVIEW_TIMESTAMP = "first_review_timestamp";
    private static final String KEY_SECOND_REVIEW_TIMESTAMP = "second_review_timestamp";
    private static final long MONTH_IN_MILLIS = 2592000000L;
    private static final String REVIEW_PREFS = "app_review_prefs";
    private final Context context;
    private final SharedPreferences preferences;
    private final ReviewManager reviewManager;
    public static final int $stable = 8;

    public final void showFeedBackDialogBoxIfEligible() {
    }

    public AppReviewManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences(REVIEW_PREFS, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.preferences = sharedPreferences;
        ReviewManager reviewManagerCreate = ReviewManagerFactory.create(context);
        Intrinsics.checkNotNullExpressionValue(reviewManagerCreate, "create(...)");
        this.reviewManager = reviewManagerCreate;
    }

    public final void showReviewIfEligible(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (isEligibleForReview()) {
            Task taskRequestReviewFlow = this.reviewManager.requestReviewFlow();
            Intrinsics.checkNotNullExpressionValue(taskRequestReviewFlow, "requestReviewFlow(...)");
            taskRequestReviewFlow.addOnCompleteListener(new OnCompleteListener() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.legacy.business.managers.AppReviewManager$$ExternalSyntheticLambda1
                public final void onComplete(Task task) {
                    AppReviewManager.showReviewIfEligible$lambda$1(this.f$0, activity, task);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showReviewIfEligible$lambda$1(final AppReviewManager appReviewManager, Activity activity, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            Task taskLaunchReviewFlow = appReviewManager.reviewManager.launchReviewFlow(activity, (ReviewInfo) task.getResult());
            Intrinsics.checkNotNullExpressionValue(taskLaunchReviewFlow, "launchReviewFlow(...)");
            taskLaunchReviewFlow.addOnCompleteListener(new OnCompleteListener() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.legacy.business.managers.AppReviewManager$$ExternalSyntheticLambda0
                public final void onComplete(Task task2) {
                    AppReviewManager.showReviewIfEligible$lambda$1$lambda$0(this.f$0, task2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showReviewIfEligible$lambda$1$lambda$0(AppReviewManager appReviewManager, Task task) {
        Intrinsics.checkNotNullParameter(task, "it");
        appReviewManager.saveReviewTimestamp();
    }

    private final boolean isEligibleForReview() {
        long j = this.preferences.getLong(KEY_FIRST_REVIEW_TIMESTAMP, 0L);
        long j2 = this.preferences.getLong(KEY_SECOND_REVIEW_TIMESTAMP, 0L);
        if (j == 0) {
            return true;
        }
        return j2 == 0 && System.currentTimeMillis() - j >= MONTH_IN_MILLIS;
    }

    private final void saveReviewTimestamp() {
        long j = this.preferences.getLong(KEY_FIRST_REVIEW_TIMESTAMP, 0L);
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        if (j == 0) {
            editorEdit.putLong(KEY_FIRST_REVIEW_TIMESTAMP, System.currentTimeMillis());
        } else {
            editorEdit.putLong(KEY_SECOND_REVIEW_TIMESTAMP, System.currentTimeMillis());
        }
        editorEdit.apply();
    }
}
