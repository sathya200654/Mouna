package com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.entities.EnvironmentSoundHistoryEntity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.repository.EnvironmentSoundHistoryRepository;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: EnvironmentSoundHistoryViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001f\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/presentation/viewmodel/EnvironmentSoundHistoryViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/repository/EnvironmentSoundHistoryRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/repository/EnvironmentSoundHistoryRepository;)V", "history", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/data/local/entities/EnvironmentSoundHistoryEntity;", "getHistory", "()Lkotlinx/coroutines/flow/StateFlow;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EnvironmentSoundHistoryViewModel extends ViewModel {
    public static final int $stable = 8;
    private final StateFlow<List<EnvironmentSoundHistoryEntity>> history;

    @Inject
    public EnvironmentSoundHistoryViewModel(EnvironmentSoundHistoryRepository environmentSoundHistoryRepository) {
        Intrinsics.checkNotNullParameter(environmentSoundHistoryRepository, "repository");
        this.history = FlowKt.stateIn(environmentSoundHistoryRepository.getHistory(), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object) null), (Object) null);
    }

    public final StateFlow<List<EnvironmentSoundHistoryEntity>> getHistory() {
        return this.history;
    }
}
