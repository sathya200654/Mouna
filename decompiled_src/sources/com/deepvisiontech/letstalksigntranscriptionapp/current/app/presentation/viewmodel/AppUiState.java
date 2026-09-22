package com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel;

import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.model.EnvironmentSound;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/app/presentation/viewmodel/AppUiState;", "", "userPersonaId", "", "environmentSound", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/model/EnvironmentSound;", "isShareAppDialogVisible", "", "isEnvSoundEnabled", "<init>", "(Ljava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/model/EnvironmentSound;ZZ)V", "getUserPersonaId", "()Ljava/lang/String;", "getEnvironmentSound", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/model/EnvironmentSound;", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AppUiState {
    public static final int $stable = 0;
    private final EnvironmentSound environmentSound;
    private final boolean isEnvSoundEnabled;
    private final boolean isShareAppDialogVisible;
    private final String userPersonaId;

    public AppUiState() {
        this(null, null, false, false, 15, null);
    }

    public static /* synthetic */ AppUiState copy$default(AppUiState appUiState, String str, EnvironmentSound environmentSound, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appUiState.userPersonaId;
        }
        if ((i & 2) != 0) {
            environmentSound = appUiState.environmentSound;
        }
        if ((i & 4) != 0) {
            z = appUiState.isShareAppDialogVisible;
        }
        if ((i & 8) != 0) {
            z2 = appUiState.isEnvSoundEnabled;
        }
        return appUiState.copy(str, environmentSound, z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUserPersonaId() {
        return this.userPersonaId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final EnvironmentSound getEnvironmentSound() {
        return this.environmentSound;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsShareAppDialogVisible() {
        return this.isShareAppDialogVisible;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsEnvSoundEnabled() {
        return this.isEnvSoundEnabled;
    }

    public final AppUiState copy(String userPersonaId, EnvironmentSound environmentSound, boolean isShareAppDialogVisible, boolean isEnvSoundEnabled) {
        return new AppUiState(userPersonaId, environmentSound, isShareAppDialogVisible, isEnvSoundEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppUiState)) {
            return false;
        }
        AppUiState appUiState = (AppUiState) other;
        return Intrinsics.areEqual(this.userPersonaId, appUiState.userPersonaId) && Intrinsics.areEqual(this.environmentSound, appUiState.environmentSound) && this.isShareAppDialogVisible == appUiState.isShareAppDialogVisible && this.isEnvSoundEnabled == appUiState.isEnvSoundEnabled;
    }

    public int hashCode() {
        String str = this.userPersonaId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        EnvironmentSound environmentSound = this.environmentSound;
        return ((((iHashCode + (environmentSound != null ? environmentSound.hashCode() : 0)) * 31) + Boolean.hashCode(this.isShareAppDialogVisible)) * 31) + Boolean.hashCode(this.isEnvSoundEnabled);
    }

    public String toString() {
        return "AppUiState(userPersonaId=" + this.userPersonaId + ", environmentSound=" + this.environmentSound + ", isShareAppDialogVisible=" + this.isShareAppDialogVisible + ", isEnvSoundEnabled=" + this.isEnvSoundEnabled + ")";
    }

    public AppUiState(String str, EnvironmentSound environmentSound, boolean z, boolean z2) {
        this.userPersonaId = str;
        this.environmentSound = environmentSound;
        this.isShareAppDialogVisible = z;
        this.isEnvSoundEnabled = z2;
    }

    public /* synthetic */ AppUiState(String str, EnvironmentSound environmentSound, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : environmentSound, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2);
    }

    public final String getUserPersonaId() {
        return this.userPersonaId;
    }

    public final EnvironmentSound getEnvironmentSound() {
        return this.environmentSound;
    }

    public final boolean isShareAppDialogVisible() {
        return this.isShareAppDialogVisible;
    }

    public final boolean isEnvSoundEnabled() {
        return this.isEnvSoundEnabled;
    }
}
