package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: LanguageAnnouncementPopUp.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.LanguageAnnouncementPopUpKt$LanguageAnnouncementPopup$1$1$1", f = "LanguageAnnouncementPopUp.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
final class LanguageAnnouncementPopUpKt$LanguageAnnouncementPopup$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $isInteracted$delegate;
    final /* synthetic */ Function0<Unit> $onTimerFinished;
    final /* synthetic */ long $timeoutMillis;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LanguageAnnouncementPopUpKt$LanguageAnnouncementPopup$1$1$1(long j, Function0<Unit> function0, MutableState<Boolean> mutableState, Continuation<? super LanguageAnnouncementPopUpKt$LanguageAnnouncementPopup$1$1$1> continuation) {
        super(2, continuation);
        this.$timeoutMillis = j;
        this.$onTimerFinished = function0;
        this.$isInteracted$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LanguageAnnouncementPopUpKt$LanguageAnnouncementPopup$1$1$1(this.$timeoutMillis, this.$onTimerFinished, this.$isInteracted$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(this.$timeoutMillis, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (!LanguageAnnouncementPopUpKt.LanguageAnnouncementPopup$lambda$18$lambda$1(this.$isInteracted$delegate)) {
            this.$onTimerFinished.invoke();
        }
        return Unit.INSTANCE;
    }
}
