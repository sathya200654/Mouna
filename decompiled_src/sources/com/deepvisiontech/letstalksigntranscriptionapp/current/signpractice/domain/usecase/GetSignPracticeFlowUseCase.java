package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPractice;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.repository.SignPracticeRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: GetSignPracticeFlowUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/usecase/GetSignPracticeFlowUseCase;", "", "signPracticeRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/repository/SignPracticeRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/repository/SignPracticeRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPractice;", "id", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetSignPracticeFlowUseCase {
    public static final int $stable = 8;
    private final SignPracticeRepository signPracticeRepository;

    @Inject
    public GetSignPracticeFlowUseCase(SignPracticeRepository signPracticeRepository) {
        Intrinsics.checkNotNullParameter(signPracticeRepository, "signPracticeRepository");
        this.signPracticeRepository = signPracticeRepository;
    }

    public final Flow<SignPractice> invoke(long id) {
        return this.signPracticeRepository.getPracticeFlow(id);
    }
}
