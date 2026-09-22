package com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.screens;

import com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.NetworkUnavailableEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.NetworkUnavailableViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: NetworkUnavailableScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.screens.NetworkUnavailableScreenKt$NetworkUnavailableScreen$1$1", f = "NetworkUnavailableScreen.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
final class NetworkUnavailableScreenKt$NetworkUnavailableScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NetworkUnavailableViewModel $networkUnavailableViewModel;
    final /* synthetic */ Function0<Unit> $onNavigateToAuthGraph;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NetworkUnavailableScreenKt$NetworkUnavailableScreen$1$1(NetworkUnavailableViewModel networkUnavailableViewModel, Function0<Unit> function0, Continuation<? super NetworkUnavailableScreenKt$NetworkUnavailableScreen$1$1> continuation) {
        super(2, continuation);
        this.$networkUnavailableViewModel = networkUnavailableViewModel;
        this.$onNavigateToAuthGraph = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NetworkUnavailableScreenKt$NetworkUnavailableScreen$1$1(this.$networkUnavailableViewModel, this.$onNavigateToAuthGraph, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<NetworkUnavailableEvent> events = this.$networkUnavailableViewModel.getEvents();
            final Function0<Unit> function0 = this.$onNavigateToAuthGraph;
            this.label = 1;
            if (events.collect(new FlowCollector() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.screens.NetworkUnavailableScreenKt$NetworkUnavailableScreen$1$1.1
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((NetworkUnavailableEvent) obj2, (Continuation<? super Unit>) continuation);
                }

                /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                public final Object emit(NetworkUnavailableEvent networkUnavailableEvent, Continuation<? super Unit> continuation) throws NoWhenBranchMatchedException {
                    if (!Intrinsics.areEqual(networkUnavailableEvent, NetworkUnavailableEvent.NavigateToAuthGraph.INSTANCE)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    function0.invoke();
                    return Unit.INSTANCE;
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
}
