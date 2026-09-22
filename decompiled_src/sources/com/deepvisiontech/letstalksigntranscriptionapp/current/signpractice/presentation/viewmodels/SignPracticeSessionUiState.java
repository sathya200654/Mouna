package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.core.media.MediaPlayerState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPractice;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignPracticeSessionViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeSessionUiState;", "", "Loading", "Success", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeSessionUiState$Loading;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeSessionUiState$Success;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SignPracticeSessionUiState {

    /* JADX INFO: compiled from: SignPracticeSessionViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeSessionUiState$Loading;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeSessionUiState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Loading implements SignPracticeSessionUiState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Loading)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1992154994;
        }

        public String toString() {
            return "Loading";
        }

        private Loading() {
        }
    }

    /* JADX INFO: compiled from: SignPracticeSessionViewModel.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeSessionUiState$Success;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeSessionUiState;", "signPractice", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPractice;", "mediaPlayerState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerState;", "isTranslatingSignPractice", "", "webViewState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPractice;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerState;ZLcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState;)V", "getSignPractice", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPractice;", "getMediaPlayerState", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerState;", "()Z", "getWebViewState", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Success implements SignPracticeSessionUiState {
        public static final int $stable = MediaPlayerState.$stable | SignPractice.$stable;
        private final boolean isTranslatingSignPractice;
        private final MediaPlayerState mediaPlayerState;
        private final SignPractice signPractice;
        private final WebViewState webViewState;

        public static /* synthetic */ Success copy$default(Success success, SignPractice signPractice, MediaPlayerState mediaPlayerState, boolean z, WebViewState webViewState, int i, Object obj) {
            if ((i & 1) != 0) {
                signPractice = success.signPractice;
            }
            if ((i & 2) != 0) {
                mediaPlayerState = success.mediaPlayerState;
            }
            if ((i & 4) != 0) {
                z = success.isTranslatingSignPractice;
            }
            if ((i & 8) != 0) {
                webViewState = success.webViewState;
            }
            return success.copy(signPractice, mediaPlayerState, z, webViewState);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final SignPractice getSignPractice() {
            return this.signPractice;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final MediaPlayerState getMediaPlayerState() {
            return this.mediaPlayerState;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsTranslatingSignPractice() {
            return this.isTranslatingSignPractice;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final WebViewState getWebViewState() {
            return this.webViewState;
        }

        public final Success copy(SignPractice signPractice, MediaPlayerState mediaPlayerState, boolean isTranslatingSignPractice, WebViewState webViewState) {
            Intrinsics.checkNotNullParameter(signPractice, "signPractice");
            Intrinsics.checkNotNullParameter(mediaPlayerState, "mediaPlayerState");
            Intrinsics.checkNotNullParameter(webViewState, "webViewState");
            return new Success(signPractice, mediaPlayerState, isTranslatingSignPractice, webViewState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return Intrinsics.areEqual(this.signPractice, success.signPractice) && Intrinsics.areEqual(this.mediaPlayerState, success.mediaPlayerState) && this.isTranslatingSignPractice == success.isTranslatingSignPractice && Intrinsics.areEqual(this.webViewState, success.webViewState);
        }

        public int hashCode() {
            return (((((this.signPractice.hashCode() * 31) + this.mediaPlayerState.hashCode()) * 31) + Boolean.hashCode(this.isTranslatingSignPractice)) * 31) + this.webViewState.hashCode();
        }

        public String toString() {
            return "Success(signPractice=" + this.signPractice + ", mediaPlayerState=" + this.mediaPlayerState + ", isTranslatingSignPractice=" + this.isTranslatingSignPractice + ", webViewState=" + this.webViewState + ")";
        }

        public Success(SignPractice signPractice, MediaPlayerState mediaPlayerState, boolean z, WebViewState webViewState) {
            Intrinsics.checkNotNullParameter(signPractice, "signPractice");
            Intrinsics.checkNotNullParameter(mediaPlayerState, "mediaPlayerState");
            Intrinsics.checkNotNullParameter(webViewState, "webViewState");
            this.signPractice = signPractice;
            this.mediaPlayerState = mediaPlayerState;
            this.isTranslatingSignPractice = z;
            this.webViewState = webViewState;
        }

        public /* synthetic */ Success(SignPractice signPractice, MediaPlayerState mediaPlayerState, boolean z, WebViewState webViewState, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(signPractice, mediaPlayerState, (i & 4) != 0 ? false : z, webViewState);
        }

        public final SignPractice getSignPractice() {
            return this.signPractice;
        }

        public final MediaPlayerState getMediaPlayerState() {
            return this.mediaPlayerState;
        }

        public final boolean isTranslatingSignPractice() {
            return this.isTranslatingSignPractice;
        }

        public final WebViewState getWebViewState() {
            return this.webViewState;
        }
    }
}
