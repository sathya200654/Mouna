package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels;

import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CredentialViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/CredentialScreenUiEvent;", "", "<init>", "()V", "Error", "NavigateToNextScreen", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/CredentialScreenUiEvent$Error;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/CredentialScreenUiEvent$NavigateToNextScreen;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class CredentialScreenUiEvent {
    public static final int $stable = 0;

    public /* synthetic */ CredentialScreenUiEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: CredentialViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/CredentialScreenUiEvent$Error;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/CredentialScreenUiEvent;", ResponseKeys.KEY_MESSAGE, "", "<init>", "(I)V", "getMessage", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Error extends CredentialScreenUiEvent {
        public static final int $stable = 0;
        private final int message;

        public static /* synthetic */ Error copy$default(Error error, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = error.message;
            }
            return error.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getMessage() {
            return this.message;
        }

        public final Error copy(int message) {
            return new Error(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && this.message == ((Error) other).message;
        }

        public int hashCode() {
            return Integer.hashCode(this.message);
        }

        public String toString() {
            return "Error(message=" + this.message + ")";
        }

        public Error(int i) {
            super(null);
            this.message = i;
        }

        public final int getMessage() {
            return this.message;
        }
    }

    private CredentialScreenUiEvent() {
    }

    /* JADX INFO: compiled from: CredentialViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/CredentialScreenUiEvent$NavigateToNextScreen;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/CredentialScreenUiEvent;", "<init>", "()V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class NavigateToNextScreen extends CredentialScreenUiEvent {
        public static final int $stable = 0;
        public static final NavigateToNextScreen INSTANCE = new NavigateToNextScreen();

        private NavigateToNextScreen() {
            super(null);
        }
    }
}
