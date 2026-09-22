package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels;

import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SplashScreenViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SplashScreenUiState;", "", "Loading", "NavigateToLoadingScreen", "NavigateToCredentialScreen", "Error", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SplashScreenUiState$Error;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SplashScreenUiState$Loading;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SplashScreenUiState$NavigateToCredentialScreen;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SplashScreenUiState$NavigateToLoadingScreen;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SplashScreenUiState {

    /* JADX INFO: compiled from: SplashScreenViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SplashScreenUiState$Loading;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SplashScreenUiState;", "<init>", "()V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Loading implements SplashScreenUiState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        private Loading() {
        }
    }

    /* JADX INFO: compiled from: SplashScreenViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SplashScreenUiState$NavigateToLoadingScreen;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SplashScreenUiState;", "<init>", "()V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class NavigateToLoadingScreen implements SplashScreenUiState {
        public static final int $stable = 0;
        public static final NavigateToLoadingScreen INSTANCE = new NavigateToLoadingScreen();

        private NavigateToLoadingScreen() {
        }
    }

    /* JADX INFO: compiled from: SplashScreenViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SplashScreenUiState$NavigateToCredentialScreen;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SplashScreenUiState;", "<init>", "()V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class NavigateToCredentialScreen implements SplashScreenUiState {
        public static final int $stable = 0;
        public static final NavigateToCredentialScreen INSTANCE = new NavigateToCredentialScreen();

        private NavigateToCredentialScreen() {
        }
    }

    /* JADX INFO: compiled from: SplashScreenViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SplashScreenUiState$Error;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SplashScreenUiState;", ResponseKeys.KEY_MESSAGE, "", "navigateToCredential", "", "<init>", "(Ljava/lang/String;Z)V", "getMessage", "()Ljava/lang/String;", "getNavigateToCredential", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Error implements SplashScreenUiState {
        public static final int $stable = 0;
        private final String message;
        private final boolean navigateToCredential;

        public static /* synthetic */ Error copy$default(Error error, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.message;
            }
            if ((i & 2) != 0) {
                z = error.navigateToCredential;
            }
            return error.copy(str, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getNavigateToCredential() {
            return this.navigateToCredential;
        }

        public final Error copy(String message, boolean navigateToCredential) {
            Intrinsics.checkNotNullParameter(message, ResponseKeys.KEY_MESSAGE);
            return new Error(message, navigateToCredential);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return Intrinsics.areEqual(this.message, error.message) && this.navigateToCredential == error.navigateToCredential;
        }

        public int hashCode() {
            return (this.message.hashCode() * 31) + Boolean.hashCode(this.navigateToCredential);
        }

        public String toString() {
            return "Error(message=" + this.message + ", navigateToCredential=" + this.navigateToCredential + ")";
        }

        public Error(String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, ResponseKeys.KEY_MESSAGE);
            this.message = str;
            this.navigateToCredential = z;
        }

        public /* synthetic */ Error(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? true : z);
        }

        public final String getMessage() {
            return this.message;
        }

        public final boolean getNavigateToCredential() {
            return this.navigateToCredential;
        }
    }
}
