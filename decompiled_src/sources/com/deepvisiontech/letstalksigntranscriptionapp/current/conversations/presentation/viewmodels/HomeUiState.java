package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: HomeViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/HomeUiState;", "", "languageBoxShown", "", "<init>", "(Z)V", "getLanguageBoxShown", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class HomeUiState {
    public static final int $stable = 0;
    private final boolean languageBoxShown;

    public HomeUiState() {
        this(false, 1, null);
    }

    public static /* synthetic */ HomeUiState copy$default(HomeUiState homeUiState, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = homeUiState.languageBoxShown;
        }
        return homeUiState.copy(z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLanguageBoxShown() {
        return this.languageBoxShown;
    }

    public final HomeUiState copy(boolean languageBoxShown) {
        return new HomeUiState(languageBoxShown);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof HomeUiState) && this.languageBoxShown == ((HomeUiState) other).languageBoxShown;
    }

    public int hashCode() {
        return Boolean.hashCode(this.languageBoxShown);
    }

    public String toString() {
        return "HomeUiState(languageBoxShown=" + this.languageBoxShown + ")";
    }

    public HomeUiState(boolean z) {
        this.languageBoxShown = z;
    }

    public /* synthetic */ HomeUiState(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final boolean getLanguageBoxShown() {
        return this.languageBoxShown;
    }
}
