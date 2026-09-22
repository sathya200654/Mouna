package com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager;

import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebViewManagerImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewEvent;", "", "Error", "WebViewLoadFailed", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewEvent$Error;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewEvent$WebViewLoadFailed;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface WebViewEvent {

    /* JADX INFO: compiled from: WebViewManagerImpl.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewEvent$Error;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewEvent;", "error", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", ResponseKeys.KEY_MESSAGE, "", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;Ljava/lang/String;)V", "getError", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Error implements WebViewEvent {
        public static final int $stable = 8;
        private final AppError error;
        private final String message;

        public static /* synthetic */ Error copy$default(Error error, AppError appError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                appError = error.error;
            }
            if ((i & 2) != 0) {
                str = error.message;
            }
            return error.copy(appError, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AppError getError() {
            return this.error;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Error copy(AppError error, String message) {
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(message, ResponseKeys.KEY_MESSAGE);
            return new Error(error, message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return Intrinsics.areEqual(this.error, error.error) && Intrinsics.areEqual(this.message, error.message);
        }

        public int hashCode() {
            return (this.error.hashCode() * 31) + this.message.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.error + ", message=" + this.message + ")";
        }

        public Error(AppError appError, String str) {
            Intrinsics.checkNotNullParameter(appError, "error");
            Intrinsics.checkNotNullParameter(str, ResponseKeys.KEY_MESSAGE);
            this.error = appError;
            this.message = str;
        }

        public final AppError getError() {
            return this.error;
        }

        public final String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: WebViewManagerImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewEvent$WebViewLoadFailed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewEvent;", "<init>", "()V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class WebViewLoadFailed implements WebViewEvent {
        public static final int $stable = 0;
        public static final WebViewLoadFailed INSTANCE = new WebViewLoadFailed();

        private WebViewLoadFailed() {
        }
    }
}
