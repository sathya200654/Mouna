package com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel;

import kotlin.Metadata;

/* JADX INFO: compiled from: AppViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/app/presentation/viewmodel/AppUiAction;", "", "OnShareAppDialogDismiss", "OnShareAppDialogShared", "LogOut", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/app/presentation/viewmodel/AppUiAction$LogOut;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/app/presentation/viewmodel/AppUiAction$OnShareAppDialogDismiss;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/app/presentation/viewmodel/AppUiAction$OnShareAppDialogShared;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AppUiAction {

    /* JADX INFO: compiled from: AppViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/app/presentation/viewmodel/AppUiAction$OnShareAppDialogDismiss;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/app/presentation/viewmodel/AppUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnShareAppDialogDismiss implements AppUiAction {
        public static final int $stable = 0;
        public static final OnShareAppDialogDismiss INSTANCE = new OnShareAppDialogDismiss();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnShareAppDialogDismiss)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1821534711;
        }

        public String toString() {
            return "OnShareAppDialogDismiss";
        }

        private OnShareAppDialogDismiss() {
        }
    }

    /* JADX INFO: compiled from: AppViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/app/presentation/viewmodel/AppUiAction$OnShareAppDialogShared;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/app/presentation/viewmodel/AppUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnShareAppDialogShared implements AppUiAction {
        public static final int $stable = 0;
        public static final OnShareAppDialogShared INSTANCE = new OnShareAppDialogShared();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnShareAppDialogShared)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1847534330;
        }

        public String toString() {
            return "OnShareAppDialogShared";
        }

        private OnShareAppDialogShared() {
        }
    }

    /* JADX INFO: compiled from: AppViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/app/presentation/viewmodel/AppUiAction$LogOut;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/app/presentation/viewmodel/AppUiAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class LogOut implements AppUiAction {
        public static final int $stable = 0;
        public static final LogOut INSTANCE = new LogOut();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LogOut)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 793942850;
        }

        public String toString() {
            return "LogOut";
        }

        private LogOut() {
        }
    }
}
