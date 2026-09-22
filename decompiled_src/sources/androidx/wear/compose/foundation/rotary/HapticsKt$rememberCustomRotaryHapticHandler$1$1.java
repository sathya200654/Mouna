package androidx.wear.compose.foundation.rotary;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: Haptics.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.wear.compose.foundation.rotary.HapticsKt$rememberCustomRotaryHapticHandler$1$1", f = "Haptics.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
final class HapticsKt$rememberCustomRotaryHapticHandler$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<RotaryHapticsType> $hapticsChannel;
    final /* synthetic */ RotaryHapticFeedbackProvider $hapticsProvider;
    final /* synthetic */ long $throttleThresholdMs;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HapticsKt$rememberCustomRotaryHapticHandler$1$1(Channel<RotaryHapticsType> channel, long j, RotaryHapticFeedbackProvider rotaryHapticFeedbackProvider, Continuation<? super HapticsKt$rememberCustomRotaryHapticHandler$1$1> continuation) {
        super(2, continuation);
        this.$hapticsChannel = channel;
        this.$throttleThresholdMs = j;
        this.$hapticsProvider = rotaryHapticFeedbackProvider;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HapticsKt$rememberCustomRotaryHapticHandler$1$1(this.$hapticsChannel, this.$throttleThresholdMs, this.$hapticsProvider, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow flowThrottleLatest = HapticsKt.throttleLatest(FlowKt.receiveAsFlow(this.$hapticsChannel), this.$throttleThresholdMs);
            final RotaryHapticFeedbackProvider rotaryHapticFeedbackProvider = this.$hapticsProvider;
            this.label = 1;
            if (flowThrottleLatest.collect(new FlowCollector() { // from class: androidx.wear.compose.foundation.rotary.HapticsKt$rememberCustomRotaryHapticHandler$1$1.1
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return m482emitmClSfgk(((RotaryHapticsType) obj2).getType(), continuation);
                }

                /* JADX INFO: renamed from: emit-mClSfgk, reason: not valid java name */
                public final Object m482emitmClSfgk(int i2, Continuation<? super Unit> continuation) {
                    Object objWithContext = BuildersKt.withContext(Dispatchers.getDefault(), new AnonymousClass2(rotaryHapticFeedbackProvider, i2, System.currentTimeMillis(), null), continuation);
                    return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: androidx.wear.compose.foundation.rotary.HapticsKt$rememberCustomRotaryHapticHandler$1$1$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: Haptics.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.wear.compose.foundation.rotary.HapticsKt$rememberCustomRotaryHapticHandler$1$1$1$2", f = "Haptics.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ long $currentTime;
                    final /* synthetic */ int $hapticType;
                    final /* synthetic */ RotaryHapticFeedbackProvider $hapticsProvider;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(RotaryHapticFeedbackProvider rotaryHapticFeedbackProvider, int i, long j, Continuation<? super AnonymousClass2> continuation) {
                        super(2, continuation);
                        this.$hapticsProvider = rotaryHapticFeedbackProvider;
                        this.$hapticType = i;
                        this.$currentTime = j;
                    }

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass2(this.$hapticsProvider, this.$hapticType, this.$currentTime, continuation);
                    }

                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        this.$hapticsProvider.m484performHapticFeedbackgZ48kpk(this.$hapticType);
                        return Unit.INSTANCE;
                    }
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
