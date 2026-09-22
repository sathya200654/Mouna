package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.model.InterpretationMode;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.model.InterpretationSpeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationSettingsViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/SettingsFlow;", "", "interpretationMode", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationMode;", "interpretationSpeed", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationSpeed;", "environmentRecognitionState", "", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationMode;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationSpeed;Z)V", "getInterpretationMode", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationMode;", "getInterpretationSpeed", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationSpeed;", "getEnvironmentRecognitionState", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SettingsFlow {
    public static final int $stable = 0;
    private final boolean environmentRecognitionState;
    private final InterpretationMode interpretationMode;
    private final InterpretationSpeed interpretationSpeed;

    public static /* synthetic */ SettingsFlow copy$default(SettingsFlow settingsFlow, InterpretationMode interpretationMode, InterpretationSpeed interpretationSpeed, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            interpretationMode = settingsFlow.interpretationMode;
        }
        if ((i & 2) != 0) {
            interpretationSpeed = settingsFlow.interpretationSpeed;
        }
        if ((i & 4) != 0) {
            z = settingsFlow.environmentRecognitionState;
        }
        return settingsFlow.copy(interpretationMode, interpretationSpeed, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final InterpretationMode getInterpretationMode() {
        return this.interpretationMode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final InterpretationSpeed getInterpretationSpeed() {
        return this.interpretationSpeed;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getEnvironmentRecognitionState() {
        return this.environmentRecognitionState;
    }

    public final SettingsFlow copy(InterpretationMode interpretationMode, InterpretationSpeed interpretationSpeed, boolean environmentRecognitionState) {
        Intrinsics.checkNotNullParameter(interpretationMode, "interpretationMode");
        Intrinsics.checkNotNullParameter(interpretationSpeed, "interpretationSpeed");
        return new SettingsFlow(interpretationMode, interpretationSpeed, environmentRecognitionState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsFlow)) {
            return false;
        }
        SettingsFlow settingsFlow = (SettingsFlow) other;
        return this.interpretationMode == settingsFlow.interpretationMode && this.interpretationSpeed == settingsFlow.interpretationSpeed && this.environmentRecognitionState == settingsFlow.environmentRecognitionState;
    }

    public int hashCode() {
        return (((this.interpretationMode.hashCode() * 31) + this.interpretationSpeed.hashCode()) * 31) + Boolean.hashCode(this.environmentRecognitionState);
    }

    public String toString() {
        return "SettingsFlow(interpretationMode=" + this.interpretationMode + ", interpretationSpeed=" + this.interpretationSpeed + ", environmentRecognitionState=" + this.environmentRecognitionState + ")";
    }

    public SettingsFlow(InterpretationMode interpretationMode, InterpretationSpeed interpretationSpeed, boolean z) {
        Intrinsics.checkNotNullParameter(interpretationMode, "interpretationMode");
        Intrinsics.checkNotNullParameter(interpretationSpeed, "interpretationSpeed");
        this.interpretationMode = interpretationMode;
        this.interpretationSpeed = interpretationSpeed;
        this.environmentRecognitionState = z;
    }

    public final InterpretationMode getInterpretationMode() {
        return this.interpretationMode;
    }

    public final InterpretationSpeed getInterpretationSpeed() {
        return this.interpretationSpeed;
    }

    public final boolean getEnvironmentRecognitionState() {
        return this.environmentRecognitionState;
    }
}
