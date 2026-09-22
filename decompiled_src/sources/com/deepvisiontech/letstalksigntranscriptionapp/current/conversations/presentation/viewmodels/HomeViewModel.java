package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import androidx.lifecycle.ViewModel;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: HomeViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/HomeUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "updateLanguageBoxShownState", "", RemoteConfigConstants.ResponseFieldKey.STATE, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HomeViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<HomeUiState> _uiState;
    private final StateFlow<HomeUiState> uiState;

    @Inject
    public HomeViewModel() {
        StateFlow<HomeUiState> stateFlowMutableStateFlow = StateFlowKt.MutableStateFlow(new HomeUiState(false, 1, null));
        this._uiState = stateFlowMutableStateFlow;
        this.uiState = stateFlowMutableStateFlow;
    }

    public final StateFlow<HomeUiState> getUiState() {
        return this.uiState;
    }

    public final void updateLanguageBoxShownState(boolean state) {
        Object value;
        MutableStateFlow<HomeUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ((HomeUiState) value).copy(state)));
    }
}
