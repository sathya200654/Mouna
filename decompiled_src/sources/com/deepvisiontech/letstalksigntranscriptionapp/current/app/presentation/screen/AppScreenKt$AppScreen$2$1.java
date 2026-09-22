package com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen;

import android.content.Context;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppUiState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.utils.VibrationHelperKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.model.EnvironmentSound;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.model.VibrationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AppScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$AppScreen$2$1", f = "AppScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AppScreenKt$AppScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableLongState $lastVibrateTime$delegate;
    final /* synthetic */ MutableState<String> $lastVibratedLabel$delegate;
    final /* synthetic */ State<AppUiState> $uiState$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppScreenKt$AppScreen$2$1(State<AppUiState> state, Context context, MutableLongState mutableLongState, MutableState<String> mutableState, Continuation<? super AppScreenKt$AppScreen$2$1> continuation) {
        super(2, continuation);
        this.$uiState$delegate = state;
        this.$context = context;
        this.$lastVibrateTime$delegate = mutableLongState;
        this.$lastVibratedLabel$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppScreenKt$AppScreen$2$1(this.$uiState$delegate, this.$context, this.$lastVibrateTime$delegate, this.$lastVibratedLabel$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final Object invokeSuspend(Object obj) throws NoWhenBranchMatchedException {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (!AppScreenKt.AppScreen$lambda$0(this.$uiState$delegate).isEnvSoundEnabled()) {
                return Unit.INSTANCE;
            }
            EnvironmentSound environmentSound = AppScreenKt.AppScreen$lambda$0(this.$uiState$delegate).getEnvironmentSound();
            if (environmentSound != null) {
                Context context = this.$context;
                MutableLongState mutableLongState = this.$lastVibrateTime$delegate;
                MutableState<String> mutableState = this.$lastVibratedLabel$delegate;
                long jCurrentTimeMillis = System.currentTimeMillis();
                boolean z = environmentSound.getVibrationLevel() == VibrationLevel.HIGH;
                long j = z ? 10000L : 60000L;
                long j2 = z ? 5000L : 20000L;
                long jAppScreen$lambda$5 = jCurrentTimeMillis - AppScreenKt.AppScreen$lambda$5(mutableLongState);
                boolean zAreEqual = Intrinsics.areEqual(environmentSound.getLabel(), AppScreenKt.AppScreen$lambda$2(mutableState));
                if (jAppScreen$lambda$5 > j || (!zAreEqual && jAppScreen$lambda$5 > j2)) {
                    VibrationHelperKt.triggerVibration(context, environmentSound.getVibrationLevel());
                    mutableState.setValue(environmentSound.getLabel());
                    mutableLongState.setLongValue(jCurrentTimeMillis);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
