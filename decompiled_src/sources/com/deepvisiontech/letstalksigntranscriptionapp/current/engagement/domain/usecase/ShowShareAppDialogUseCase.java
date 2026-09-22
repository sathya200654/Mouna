package com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.repository.AppUsageRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: ShowShareAppDialogUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/domain/usecase/ShowShareAppDialogUseCase;", "", "appUsageRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/repository/AppUsageRepository;", "engagementRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/domain/repository/EngagementRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/repository/AppUsageRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/domain/repository/EngagementRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ShowShareAppDialogUseCase {
    public static final int $stable = 0;
    public static final int APP_OPEN_THRESHOLD = 9;
    private final AppUsageRepository appUsageRepository;
    private final EngagementRepository engagementRepository;

    @Inject
    public ShowShareAppDialogUseCase(AppUsageRepository appUsageRepository, EngagementRepository engagementRepository) {
        Intrinsics.checkNotNullParameter(appUsageRepository, "appUsageRepository");
        Intrinsics.checkNotNullParameter(engagementRepository, "engagementRepository");
        this.appUsageRepository = appUsageRepository;
        this.engagementRepository = engagementRepository;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.usecase.ShowShareAppDialogUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: ShowShareAppDialogUseCase.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", "", "usage", "", "lastShownDate", "Ljava/time/LocalDate;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.usecase.ShowShareAppDialogUseCase$invoke$1", f = "ShowShareAppDialogUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function3<Integer, LocalDate, Continuation<? super Boolean>, Object> {
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
        }

        public final Object invoke(int i, LocalDate localDate, Continuation<? super Boolean> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.I$0 = i;
            anonymousClass1.L$0 = localDate;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke(((Number) obj).intValue(), (LocalDate) obj2, (Continuation<? super Boolean>) obj3);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0032  */
        public final Object invokeSuspend(Object obj) {
            boolean z;
            int i = this.I$0;
            LocalDate localDate = (LocalDate) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            boolean z2 = false;
            boolean z3 = i > 9;
            if (localDate != null) {
                if (ChronoUnit.DAYS.between(localDate, LocalDate.now()) > 28) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = true;
            }
            if (z3 && z) {
                z2 = true;
            }
            return Boxing.boxBoolean(z2);
        }
    }

    public final Flow<Boolean> invoke() {
        return FlowKt.flowCombine(this.appUsageRepository.getAppOpenCountFlow(), this.engagementRepository.getShareAppDialogLastUsageDate(), new AnonymousClass1(null));
    }
}
