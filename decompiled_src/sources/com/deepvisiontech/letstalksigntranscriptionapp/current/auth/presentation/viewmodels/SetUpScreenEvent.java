package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SetUpViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SetUpScreenEvent;", "", "NavigateToOnBoarding", "NavigateToHome", "NavigateToNotification", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SetUpScreenEvent$NavigateToHome;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SetUpScreenEvent$NavigateToNotification;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SetUpScreenEvent$NavigateToOnBoarding;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SetUpScreenEvent {

    /* JADX INFO: compiled from: SetUpViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SetUpScreenEvent$NavigateToOnBoarding;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SetUpScreenEvent;", "<init>", "()V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class NavigateToOnBoarding implements SetUpScreenEvent {
        public static final int $stable = 0;
        public static final NavigateToOnBoarding INSTANCE = new NavigateToOnBoarding();

        private NavigateToOnBoarding() {
        }
    }

    /* JADX INFO: compiled from: SetUpViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SetUpScreenEvent$NavigateToHome;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SetUpScreenEvent;", "<init>", "()V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class NavigateToHome implements SetUpScreenEvent {
        public static final int $stable = 0;
        public static final NavigateToHome INSTANCE = new NavigateToHome();

        private NavigateToHome() {
        }
    }

    /* JADX INFO: compiled from: SetUpViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SetUpScreenEvent$NavigateToNotification;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SetUpScreenEvent;", "notificationId", "", "<init>", "(Ljava/lang/String;)V", "getNotificationId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NavigateToNotification implements SetUpScreenEvent {
        public static final int $stable = 0;
        private final String notificationId;

        public static /* synthetic */ NavigateToNotification copy$default(NavigateToNotification navigateToNotification, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = navigateToNotification.notificationId;
            }
            return navigateToNotification.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getNotificationId() {
            return this.notificationId;
        }

        public final NavigateToNotification copy(String notificationId) {
            Intrinsics.checkNotNullParameter(notificationId, "notificationId");
            return new NavigateToNotification(notificationId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NavigateToNotification) && Intrinsics.areEqual(this.notificationId, ((NavigateToNotification) other).notificationId);
        }

        public int hashCode() {
            return this.notificationId.hashCode();
        }

        public String toString() {
            return "NavigateToNotification(notificationId=" + this.notificationId + ")";
        }

        public NavigateToNotification(String str) {
            Intrinsics.checkNotNullParameter(str, "notificationId");
            this.notificationId = str;
        }

        public final String getNotificationId() {
            return this.notificationId;
        }
    }
}
