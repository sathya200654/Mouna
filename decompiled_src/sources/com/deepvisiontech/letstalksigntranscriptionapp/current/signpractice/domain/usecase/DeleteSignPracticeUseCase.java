package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.utils.FileHandlingUtilsKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPractice;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.repository.SignPracticeRepository;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeleteSignPracticeUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0086B¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/usecase/DeleteSignPracticeUseCase;", "", "signPracticeRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/repository/SignPracticeRepository;", "analyticsManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/repository/SignPracticeRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "signPractices", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPractice;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeleteSignPracticeUseCase {
    public static final int $stable = 8;
    private final AnalyticsManager analyticsManager;
    private final SignPracticeRepository signPracticeRepository;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.DeleteSignPracticeUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: DeleteSignPracticeUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.DeleteSignPracticeUseCase", f = "DeleteSignPracticeUseCase.kt", i = {0}, l = {17}, m = "invoke", n = {"signPractices"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeleteSignPracticeUseCase.this.invoke(null, (Continuation) this);
        }
    }

    @Inject
    public DeleteSignPracticeUseCase(SignPracticeRepository signPracticeRepository, AnalyticsManager analyticsManager) {
        Intrinsics.checkNotNullParameter(signPracticeRepository, "signPracticeRepository");
        Intrinsics.checkNotNullParameter(analyticsManager, "analyticsManager");
        this.signPracticeRepository = signPracticeRepository;
        this.analyticsManager = analyticsManager;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object invoke(List<SignPractice> list, Continuation<? super ResponseResource<Unit>> continuation) throws NoWhenBranchMatchedException {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objDeletePractices = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objDeletePractices);
            SignPracticeRepository signPracticeRepository = this.signPracticeRepository;
            anonymousClass1.L$0 = list;
            anonymousClass1.label = 1;
            objDeletePractices = signPracticeRepository.deletePractices(list, anonymousClass1);
            if (objDeletePractices == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list = (List) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objDeletePractices);
        }
        ResponseResource responseResource = (ResponseResource) objDeletePractices;
        if (!(responseResource instanceof ResponseResource.Success)) {
            if (responseResource instanceof ResponseResource.Error) {
                return responseResource;
            }
            if (Intrinsics.areEqual(responseResource, ResponseResource.Loading.INSTANCE)) {
                return ResponseResource.Loading.INSTANCE;
            }
            throw new NoWhenBranchMatchedException();
        }
        ((ResponseResource.Success) responseResource).getData();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            FileHandlingUtilsKt.deleteFileFromUri(((SignPractice) it.next()).getUri());
        }
        this.analyticsManager.logEvent(AnalyticsEvent.SignPracticeDeleted.INSTANCE);
        return new ResponseResource.Success(Unit.INSTANCE);
    }
}
