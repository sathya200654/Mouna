package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase;

import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FetchAndSaveMailIdUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/usecase/FetchAndSaveMailResult;", "", "Success", "Error", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/usecase/FetchAndSaveMailResult$Error;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/usecase/FetchAndSaveMailResult$Success;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface FetchAndSaveMailResult {

    /* JADX INFO: compiled from: FetchAndSaveMailIdUseCase.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/usecase/FetchAndSaveMailResult$Success;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/usecase/FetchAndSaveMailResult;", "<init>", "()V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Success implements FetchAndSaveMailResult {
        public static final int $stable = 0;
        public static final Success INSTANCE = new Success();

        private Success() {
        }
    }

    /* JADX INFO: compiled from: FetchAndSaveMailIdUseCase.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/usecase/FetchAndSaveMailResult$Error;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/usecase/FetchAndSaveMailResult;", ResponseKeys.KEY_MESSAGE, "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Error implements FetchAndSaveMailResult {
        public static final int $stable = 0;
        private final String message;

        public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.message;
            }
            return error.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Error copy(String message) {
            Intrinsics.checkNotNullParameter(message, ResponseKeys.KEY_MESSAGE);
            return new Error(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && Intrinsics.areEqual(this.message, ((Error) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "Error(message=" + this.message + ")";
        }

        public Error(String str) {
            Intrinsics.checkNotNullParameter(str, ResponseKeys.KEY_MESSAGE);
            this.message = str;
        }

        public final String getMessage() {
            return this.message;
        }
    }
}
