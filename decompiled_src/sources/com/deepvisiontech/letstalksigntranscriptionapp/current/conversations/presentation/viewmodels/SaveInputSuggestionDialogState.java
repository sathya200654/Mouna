package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.CorrectionSuggestion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/SaveInputSuggestionDialogState;", "", "Show", "Hidden", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/SaveInputSuggestionDialogState$Hidden;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/SaveInputSuggestionDialogState$Show;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SaveInputSuggestionDialogState {

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/SaveInputSuggestionDialogState$Show;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/SaveInputSuggestionDialogState;", "correctionSuggestion", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/CorrectionSuggestion;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/CorrectionSuggestion;)V", "getCorrectionSuggestion", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/CorrectionSuggestion;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Show implements SaveInputSuggestionDialogState {
        public static final int $stable = 0;
        private final CorrectionSuggestion correctionSuggestion;

        public static /* synthetic */ Show copy$default(Show show, CorrectionSuggestion correctionSuggestion, int i, Object obj) {
            if ((i & 1) != 0) {
                correctionSuggestion = show.correctionSuggestion;
            }
            return show.copy(correctionSuggestion);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CorrectionSuggestion getCorrectionSuggestion() {
            return this.correctionSuggestion;
        }

        public final Show copy(CorrectionSuggestion correctionSuggestion) {
            Intrinsics.checkNotNullParameter(correctionSuggestion, "correctionSuggestion");
            return new Show(correctionSuggestion);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Show) && Intrinsics.areEqual(this.correctionSuggestion, ((Show) other).correctionSuggestion);
        }

        public int hashCode() {
            return this.correctionSuggestion.hashCode();
        }

        public String toString() {
            return "Show(correctionSuggestion=" + this.correctionSuggestion + ")";
        }

        public Show(CorrectionSuggestion correctionSuggestion) {
            Intrinsics.checkNotNullParameter(correctionSuggestion, "correctionSuggestion");
            this.correctionSuggestion = correctionSuggestion;
        }

        public final CorrectionSuggestion getCorrectionSuggestion() {
            return this.correctionSuggestion;
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/SaveInputSuggestionDialogState$Hidden;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/SaveInputSuggestionDialogState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Hidden implements SaveInputSuggestionDialogState {
        public static final int $stable = 0;
        public static final Hidden INSTANCE = new Hidden();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Hidden)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1771077093;
        }

        public String toString() {
            return "Hidden";
        }

        private Hidden() {
        }
    }
}
