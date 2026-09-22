package com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation;

import kotlin.Metadata;

/* JADX INFO: compiled from: NetworkUnavailableViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/feature/network/presentation/NetworkUnavailableEvent;", "", "NavigateToAuthGraph", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/feature/network/presentation/NetworkUnavailableEvent$NavigateToAuthGraph;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface NetworkUnavailableEvent {

    /* JADX INFO: compiled from: NetworkUnavailableViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/feature/network/presentation/NetworkUnavailableEvent$NavigateToAuthGraph;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/feature/network/presentation/NetworkUnavailableEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NavigateToAuthGraph implements NetworkUnavailableEvent {
        public static final int $stable = 0;
        public static final NavigateToAuthGraph INSTANCE = new NavigateToAuthGraph();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NavigateToAuthGraph)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -828080732;
        }

        public String toString() {
            return "NavigateToAuthGraph";
        }

        private NavigateToAuthGraph() {
        }
    }
}
