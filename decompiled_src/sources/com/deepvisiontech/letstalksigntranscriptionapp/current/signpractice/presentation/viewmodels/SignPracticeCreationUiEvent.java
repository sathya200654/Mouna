package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignPracticeCreationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeCreationUiEvent;", "", "ErrorMessage", "Generated", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeCreationUiEvent$ErrorMessage;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeCreationUiEvent$Generated;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SignPracticeCreationUiEvent {

    /* JADX INFO: compiled from: SignPracticeCreationViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeCreationUiEvent$ErrorMessage;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeCreationUiEvent;", "messageRes", "", "formatArgs", "", "", "<init>", "(ILjava/util/List;)V", "getMessageRes", "()I", "getFormatArgs", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ErrorMessage implements SignPracticeCreationUiEvent {
        public static final int $stable = 8;
        private final List<Object> formatArgs;
        private final int messageRes;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ErrorMessage copy$default(ErrorMessage errorMessage, int i, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = errorMessage.messageRes;
            }
            if ((i2 & 2) != 0) {
                list = errorMessage.formatArgs;
            }
            return errorMessage.copy(i, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getMessageRes() {
            return this.messageRes;
        }

        public final List<Object> component2() {
            return this.formatArgs;
        }

        public final ErrorMessage copy(int messageRes, List<? extends Object> formatArgs) {
            Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
            return new ErrorMessage(messageRes, formatArgs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ErrorMessage)) {
                return false;
            }
            ErrorMessage errorMessage = (ErrorMessage) other;
            return this.messageRes == errorMessage.messageRes && Intrinsics.areEqual(this.formatArgs, errorMessage.formatArgs);
        }

        public int hashCode() {
            return (Integer.hashCode(this.messageRes) * 31) + this.formatArgs.hashCode();
        }

        public String toString() {
            return "ErrorMessage(messageRes=" + this.messageRes + ", formatArgs=" + this.formatArgs + ")";
        }

        public ErrorMessage(int i, List<? extends Object> list) {
            Intrinsics.checkNotNullParameter(list, "formatArgs");
            this.messageRes = i;
            this.formatArgs = list;
        }

        public final int getMessageRes() {
            return this.messageRes;
        }

        public /* synthetic */ ErrorMessage(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list);
        }

        public final List<Object> getFormatArgs() {
            return this.formatArgs;
        }
    }

    /* JADX INFO: compiled from: SignPracticeCreationViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeCreationUiEvent$Generated;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeCreationUiEvent;", "signPracticeId", "", "<init>", "(J)V", "getSignPracticeId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Generated implements SignPracticeCreationUiEvent {
        public static final int $stable = 0;
        private final long signPracticeId;

        public static /* synthetic */ Generated copy$default(Generated generated, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = generated.signPracticeId;
            }
            return generated.copy(j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getSignPracticeId() {
            return this.signPracticeId;
        }

        public final Generated copy(long signPracticeId) {
            return new Generated(signPracticeId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Generated) && this.signPracticeId == ((Generated) other).signPracticeId;
        }

        public int hashCode() {
            return Long.hashCode(this.signPracticeId);
        }

        public String toString() {
            return "Generated(signPracticeId=" + this.signPracticeId + ")";
        }

        public Generated(long j) {
            this.signPracticeId = j;
        }

        public final long getSignPracticeId() {
            return this.signPracticeId;
        }
    }
}
