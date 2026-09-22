package com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel;

import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.model.EnvironmentSound;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;

/* JADX INFO: compiled from: AppViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/app/presentation/viewmodel/AppUiState;", "shareAppDialogState", "", "userPersona", "", "soundEvent", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/model/EnvironmentSound;", "isEnvSoundEnabled"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel$uiState$2", f = "AppViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AppViewModel$uiState$2 extends SuspendLambda implements Function5<Boolean, String, EnvironmentSound, Boolean, Continuation<? super AppUiState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ boolean Z$0;
    /* synthetic */ boolean Z$1;
    int label;

    AppViewModel$uiState$2(Continuation<? super AppViewModel$uiState$2> continuation) {
        super(5, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return invoke(((Boolean) obj).booleanValue(), (String) obj2, (EnvironmentSound) obj3, ((Boolean) obj4).booleanValue(), (Continuation<? super AppUiState>) obj5);
    }

    public final Object invoke(boolean z, String str, EnvironmentSound environmentSound, boolean z2, Continuation<? super AppUiState> continuation) {
        AppViewModel$uiState$2 appViewModel$uiState$2 = new AppViewModel$uiState$2(continuation);
        appViewModel$uiState$2.Z$0 = z;
        appViewModel$uiState$2.L$0 = str;
        appViewModel$uiState$2.L$1 = environmentSound;
        appViewModel$uiState$2.Z$1 = z2;
        return appViewModel$uiState$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z = this.Z$0;
        String str = (String) this.L$0;
        EnvironmentSound environmentSound = (EnvironmentSound) this.L$1;
        boolean z2 = this.Z$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return new AppUiState(str, environmentSound, z, z2);
    }
}
