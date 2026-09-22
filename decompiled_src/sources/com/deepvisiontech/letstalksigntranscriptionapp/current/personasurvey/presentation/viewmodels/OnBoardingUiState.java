package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OnBoardingViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00030\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u001b\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00030\u0006HÆ\u0003J5\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00030\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR#\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/presentation/viewmodels/OnBoardingUiState;", "", "pages", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/presentation/viewmodels/OnBoardingPages;", "finalSelection", "", "", "<init>", "(Ljava/util/List;Ljava/util/Map;)V", "getPages", "()Ljava/util/List;", "getFinalSelection", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class OnBoardingUiState {
    public static final int $stable = 8;
    private final Map<String, List<String>> finalSelection;
    private final List<OnBoardingPages> pages;

    /* JADX WARN: Multi-variable type inference failed */
    public OnBoardingUiState() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OnBoardingUiState copy$default(OnBoardingUiState onBoardingUiState, List list, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            list = onBoardingUiState.pages;
        }
        if ((i & 2) != 0) {
            map = onBoardingUiState.finalSelection;
        }
        return onBoardingUiState.copy(list, map);
    }

    public final List<OnBoardingPages> component1() {
        return this.pages;
    }

    public final Map<String, List<String>> component2() {
        return this.finalSelection;
    }

    public final OnBoardingUiState copy(List<? extends OnBoardingPages> pages, Map<String, ? extends List<String>> finalSelection) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(finalSelection, "finalSelection");
        return new OnBoardingUiState(pages, finalSelection);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnBoardingUiState)) {
            return false;
        }
        OnBoardingUiState onBoardingUiState = (OnBoardingUiState) other;
        return Intrinsics.areEqual(this.pages, onBoardingUiState.pages) && Intrinsics.areEqual(this.finalSelection, onBoardingUiState.finalSelection);
    }

    public int hashCode() {
        return (this.pages.hashCode() * 31) + this.finalSelection.hashCode();
    }

    public String toString() {
        return "OnBoardingUiState(pages=" + this.pages + ", finalSelection=" + this.finalSelection + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OnBoardingUiState(List<? extends OnBoardingPages> list, Map<String, ? extends List<String>> map) {
        Intrinsics.checkNotNullParameter(list, "pages");
        Intrinsics.checkNotNullParameter(map, "finalSelection");
        this.pages = list;
        this.finalSelection = map;
    }

    public /* synthetic */ OnBoardingUiState(List list, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.listOf(OnBoardingPages.ConsentPage.INSTANCE) : list, (i & 2) != 0 ? MapsKt.emptyMap() : map);
    }

    public final List<OnBoardingPages> getPages() {
        return this.pages;
    }

    public final Map<String, List<String>> getFinalSelection() {
        return this.finalSelection;
    }
}
