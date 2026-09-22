package com.deepvisiontech.letstalksigntranscriptionapp.current.core.media;

import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaPlayerManager.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerEvent;", "", "Error", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerEvent$Error;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface MediaPlayerEvent {

    /* JADX INFO: compiled from: MediaPlayerManager.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerEvent$Error;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerEvent;", "SourceError", "RenderError", "UnexpectedError", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerEvent$Error$RenderError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerEvent$Error$SourceError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerEvent$Error$UnexpectedError;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Error extends MediaPlayerEvent {

        /* JADX INFO: compiled from: MediaPlayerManager.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerEvent$Error$SourceError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerEvent$Error;", ResponseKeys.KEY_MESSAGE, "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SourceError implements Error {
            public static final int $stable = 0;
            private final String message;

            public static /* synthetic */ SourceError copy$default(SourceError sourceError, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = sourceError.message;
                }
                return sourceError.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getMessage() {
                return this.message;
            }

            public final SourceError copy(String message) {
                Intrinsics.checkNotNullParameter(message, ResponseKeys.KEY_MESSAGE);
                return new SourceError(message);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SourceError) && Intrinsics.areEqual(this.message, ((SourceError) other).message);
            }

            public int hashCode() {
                return this.message.hashCode();
            }

            public String toString() {
                return "SourceError(message=" + this.message + ")";
            }

            public SourceError(String str) {
                Intrinsics.checkNotNullParameter(str, ResponseKeys.KEY_MESSAGE);
                this.message = str;
            }

            public final String getMessage() {
                return this.message;
            }
        }

        /* JADX INFO: compiled from: MediaPlayerManager.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerEvent$Error$RenderError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerEvent$Error;", ResponseKeys.KEY_MESSAGE, "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RenderError implements Error {
            public static final int $stable = 0;
            private final String message;

            public static /* synthetic */ RenderError copy$default(RenderError renderError, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = renderError.message;
                }
                return renderError.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getMessage() {
                return this.message;
            }

            public final RenderError copy(String message) {
                Intrinsics.checkNotNullParameter(message, ResponseKeys.KEY_MESSAGE);
                return new RenderError(message);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof RenderError) && Intrinsics.areEqual(this.message, ((RenderError) other).message);
            }

            public int hashCode() {
                return this.message.hashCode();
            }

            public String toString() {
                return "RenderError(message=" + this.message + ")";
            }

            public RenderError(String str) {
                Intrinsics.checkNotNullParameter(str, ResponseKeys.KEY_MESSAGE);
                this.message = str;
            }

            public final String getMessage() {
                return this.message;
            }
        }

        /* JADX INFO: compiled from: MediaPlayerManager.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerEvent$Error$UnexpectedError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerEvent$Error;", ResponseKeys.KEY_MESSAGE, "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UnexpectedError implements Error {
            public static final int $stable = 0;
            private final String message;

            public static /* synthetic */ UnexpectedError copy$default(UnexpectedError unexpectedError, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = unexpectedError.message;
                }
                return unexpectedError.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getMessage() {
                return this.message;
            }

            public final UnexpectedError copy(String message) {
                Intrinsics.checkNotNullParameter(message, ResponseKeys.KEY_MESSAGE);
                return new UnexpectedError(message);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UnexpectedError) && Intrinsics.areEqual(this.message, ((UnexpectedError) other).message);
            }

            public int hashCode() {
                return this.message.hashCode();
            }

            public String toString() {
                return "UnexpectedError(message=" + this.message + ")";
            }

            public UnexpectedError(String str) {
                Intrinsics.checkNotNullParameter(str, ResponseKeys.KEY_MESSAGE);
                this.message = str;
            }

            public final String getMessage() {
                return this.message;
            }
        }
    }
}
