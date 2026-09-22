package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import com.google.common.net.HttpHeaders;
import kotlin.Metadata;

/* JADX INFO: compiled from: ConversationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiEvent;", "", "Error", HttpHeaders.WARNING, "RequestMicrophonePermission", "NavigateToDocumentScanner", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiEvent$Error;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiEvent$NavigateToDocumentScanner;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiEvent$RequestMicrophonePermission;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiEvent$Warning;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ConversationUiEvent {

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiEvent$Error;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiEvent;", "errorMessageRes", "", "<init>", "(I)V", "getErrorMessageRes", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Error implements ConversationUiEvent {
        public static final int $stable = 0;
        private final int errorMessageRes;

        public static /* synthetic */ Error copy$default(Error error, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = error.errorMessageRes;
            }
            return error.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getErrorMessageRes() {
            return this.errorMessageRes;
        }

        public final Error copy(int errorMessageRes) {
            return new Error(errorMessageRes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && this.errorMessageRes == ((Error) other).errorMessageRes;
        }

        public int hashCode() {
            return Integer.hashCode(this.errorMessageRes);
        }

        public String toString() {
            return "Error(errorMessageRes=" + this.errorMessageRes + ")";
        }

        public Error(int i) {
            this.errorMessageRes = i;
        }

        public final int getErrorMessageRes() {
            return this.errorMessageRes;
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiEvent$Warning;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiEvent;", "warningMessage", "", "<init>", "(I)V", "getWarningMessage", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Warning implements ConversationUiEvent {
        public static final int $stable = 0;
        private final int warningMessage;

        public static /* synthetic */ Warning copy$default(Warning warning, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = warning.warningMessage;
            }
            return warning.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getWarningMessage() {
            return this.warningMessage;
        }

        public final Warning copy(int warningMessage) {
            return new Warning(warningMessage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Warning) && this.warningMessage == ((Warning) other).warningMessage;
        }

        public int hashCode() {
            return Integer.hashCode(this.warningMessage);
        }

        public String toString() {
            return "Warning(warningMessage=" + this.warningMessage + ")";
        }

        public Warning(int i) {
            this.warningMessage = i;
        }

        public final int getWarningMessage() {
            return this.warningMessage;
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiEvent$RequestMicrophonePermission;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class RequestMicrophonePermission implements ConversationUiEvent {
        public static final int $stable = 0;
        public static final RequestMicrophonePermission INSTANCE = new RequestMicrophonePermission();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RequestMicrophonePermission)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 498621368;
        }

        public String toString() {
            return "RequestMicrophonePermission";
        }

        private RequestMicrophonePermission() {
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiEvent$NavigateToDocumentScanner;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NavigateToDocumentScanner implements ConversationUiEvent {
        public static final int $stable = 0;
        public static final NavigateToDocumentScanner INSTANCE = new NavigateToDocumentScanner();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NavigateToDocumentScanner)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1032190233;
        }

        public String toString() {
            return "NavigateToDocumentScanner";
        }

        private NavigateToDocumentScanner() {
        }
    }
}
