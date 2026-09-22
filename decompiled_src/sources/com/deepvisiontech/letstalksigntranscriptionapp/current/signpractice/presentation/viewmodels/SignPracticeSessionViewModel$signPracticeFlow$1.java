package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels;

import android.util.Log;
import androidx.media3.common.MediaItem;
import androidx.wear.compose.material.AnimationKt;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.media.MediaPlayerManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPractice;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.GetSignPracticeFlowUseCase;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: SignPracticeSessionViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPractice;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel$signPracticeFlow$1", f = "SignPracticeSessionViewModel.kt", i = {0}, l = {78}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
final class SignPracticeSessionViewModel$signPracticeFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super SignPractice>, Continuation<? super Unit>, Object> {
    final /* synthetic */ GetSignPracticeFlowUseCase $getSignPracticeFlowUseCase;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SignPracticeSessionViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SignPracticeSessionViewModel$signPracticeFlow$1(GetSignPracticeFlowUseCase getSignPracticeFlowUseCase, SignPracticeSessionViewModel signPracticeSessionViewModel, Continuation<? super SignPracticeSessionViewModel$signPracticeFlow$1> continuation) {
        super(2, continuation);
        this.$getSignPracticeFlowUseCase = getSignPracticeFlowUseCase;
        this.this$0 = signPracticeSessionViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> signPracticeSessionViewModel$signPracticeFlow$1 = new SignPracticeSessionViewModel$signPracticeFlow$1(this.$getSignPracticeFlowUseCase, this.this$0, continuation);
        signPracticeSessionViewModel$signPracticeFlow$1.L$0 = obj;
        return signPracticeSessionViewModel$signPracticeFlow$1;
    }

    public final Object invoke(FlowCollector<? super SignPractice> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        final FlowCollector flowCollector = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow flowCatch = FlowKt.catch(this.$getSignPracticeFlowUseCase.invoke(this.this$0._signPracticeId), new AnonymousClass1(this.this$0, null));
            final SignPracticeSessionViewModel signPracticeSessionViewModel = this.this$0;
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.label = 1;
            if (flowCatch.collect(new FlowCollector() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel$signPracticeFlow$1.2
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((SignPractice) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(SignPractice signPractice, Continuation<? super Unit> continuation) {
                    MediaPlayerManager mediaPlayerManager = signPracticeSessionViewModel.mediaPlayerManager;
                    MediaItem mediaItemFromUri = MediaItem.fromUri(signPractice.getUri());
                    Intrinsics.checkNotNullExpressionValue(mediaItemFromUri, "fromUri(...)");
                    mediaPlayerManager.setMediaItem(mediaItemFromUri);
                    Object objEmit = flowCollector.emit(signPractice, continuation);
                    return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                }
            }, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel$signPracticeFlow$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: SignPracticeSessionViewModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPractice;", "exception", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel$signPracticeFlow$1$1", f = "SignPracticeSessionViewModel.kt", i = {0}, l = {AnimationKt.FLASH}, m = "invokeSuspend", n = {"exception"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super SignPractice>, Throwable, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SignPracticeSessionViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SignPracticeSessionViewModel signPracticeSessionViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
            this.this$0 = signPracticeSessionViewModel;
        }

        public final Object invoke(FlowCollector<? super SignPractice> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = th;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Throwable th = (Throwable) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = th;
                this.label = 1;
                if (this.this$0._uiEvent.emit(new SignPracticeSessionEventState.ErrorEvent(R.string.sign_practice_load_error), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Log.e("SignPracticeSessionViewModel", "Failed to load sign practice.", th);
            return Unit.INSTANCE;
        }
    }
}
