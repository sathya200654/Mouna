package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens;

import android.media.AudioManager;
import android.view.View;
import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarHostState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ConversationScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$ConversationScreen$2$1", f = "ConversationScreen.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
final class ConversationScreenKt$ConversationScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AudioManager $audioManager;
    final /* synthetic */ int $currentVolume;
    final /* synthetic */ int $maxVolume;
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    final /* synthetic */ View $view;
    final /* synthetic */ String $volumeSnackbarMessage;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConversationScreenKt$ConversationScreen$2$1(int i, int i2, AudioManager audioManager, SnackbarHostState snackbarHostState, String str, View view, Continuation<? super ConversationScreenKt$ConversationScreen$2$1> continuation) {
        super(2, continuation);
        this.$currentVolume = i;
        this.$maxVolume = i2;
        this.$audioManager = audioManager;
        this.$snackbarHostState = snackbarHostState;
        this.$volumeSnackbarMessage = str;
        this.$view = view;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationScreenKt$ConversationScreen$2$1(this.$currentVolume, this.$maxVolume, this.$audioManager, this.$snackbarHostState, this.$volumeSnackbarMessage, this.$view, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            int i2 = this.$currentVolume;
            int i3 = this.$maxVolume;
            if (i2 < i3 / 2) {
                this.$audioManager.setStreamVolume(3, i3 / 2, 4);
                this.label = 1;
                if (SnackbarHostState.showSnackbar$default(this.$snackbarHostState, this.$volumeSnackbarMessage, (String) null, false, (SnackbarDuration) null, (Continuation) this, 14, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$view.announceForAccessibility(this.$volumeSnackbarMessage);
        return Unit.INSTANCE;
    }
}
