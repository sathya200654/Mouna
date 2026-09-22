package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.response;

import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationError.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0006\u0007\bR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0003\t\n\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/response/ConversationError;", "", ResponseKeys.KEY_MESSAGE, "", "getMessage", "()Ljava/lang/String;", "GeneralError", "NetworkError", "UnknownError", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/response/ConversationError$GeneralError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/response/ConversationError$NetworkError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/response/ConversationError$UnknownError;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ConversationError {
    String getMessage();

    /* JADX INFO: compiled from: ConversationError.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/response/ConversationError$GeneralError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/response/ConversationError;", ResponseKeys.KEY_MESSAGE, "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class GeneralError implements ConversationError {
        public static final int $stable = 0;
        private final String message;

        public static /* synthetic */ GeneralError copy$default(GeneralError generalError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = generalError.message;
            }
            return generalError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final GeneralError copy(String message) {
            Intrinsics.checkNotNullParameter(message, ResponseKeys.KEY_MESSAGE);
            return new GeneralError(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof GeneralError) && Intrinsics.areEqual(this.message, ((GeneralError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "GeneralError(message=" + this.message + ")";
        }

        public GeneralError(String str) {
            Intrinsics.checkNotNullParameter(str, ResponseKeys.KEY_MESSAGE);
            this.message = str;
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.response.ConversationError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: ConversationError.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/response/ConversationError$NetworkError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/response/ConversationError;", ResponseKeys.KEY_MESSAGE, "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NetworkError implements ConversationError {
        public static final int $stable = 0;
        private final String message;

        public static /* synthetic */ NetworkError copy$default(NetworkError networkError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = networkError.message;
            }
            return networkError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final NetworkError copy(String message) {
            Intrinsics.checkNotNullParameter(message, ResponseKeys.KEY_MESSAGE);
            return new NetworkError(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NetworkError) && Intrinsics.areEqual(this.message, ((NetworkError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "NetworkError(message=" + this.message + ")";
        }

        public NetworkError(String str) {
            Intrinsics.checkNotNullParameter(str, ResponseKeys.KEY_MESSAGE);
            this.message = str;
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.response.ConversationError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: ConversationError.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/response/ConversationError$UnknownError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/response/ConversationError;", ResponseKeys.KEY_MESSAGE, "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UnknownError implements ConversationError {
        public static final int $stable = 0;
        private final String message;

        public static /* synthetic */ UnknownError copy$default(UnknownError unknownError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unknownError.message;
            }
            return unknownError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final UnknownError copy(String message) {
            Intrinsics.checkNotNullParameter(message, ResponseKeys.KEY_MESSAGE);
            return new UnknownError(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof UnknownError) && Intrinsics.areEqual(this.message, ((UnknownError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "UnknownError(message=" + this.message + ")";
        }

        public UnknownError(String str) {
            Intrinsics.checkNotNullParameter(str, ResponseKeys.KEY_MESSAGE);
            this.message = str;
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.response.ConversationError
        public String getMessage() {
            return this.message;
        }
    }
}
