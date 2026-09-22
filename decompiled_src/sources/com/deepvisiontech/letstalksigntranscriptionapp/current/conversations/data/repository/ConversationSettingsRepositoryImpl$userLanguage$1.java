package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository;

import android.util.Log;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesFactory;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: ConversationSettingsRepositoryImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/datastore/preferences/core/Preferences;", "exception", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository.ConversationSettingsRepositoryImpl$userLanguage$1", f = "ConversationSettingsRepositoryImpl.kt", i = {0, 0}, l = {40}, m = "invokeSuspend", n = {"$this$catch", "exception"}, s = {"L$0", "L$1"})
final class ConversationSettingsRepositoryImpl$userLanguage$1 extends SuspendLambda implements Function3<FlowCollector<? super Preferences>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    ConversationSettingsRepositoryImpl$userLanguage$1(Continuation<? super ConversationSettingsRepositoryImpl$userLanguage$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(FlowCollector<? super Preferences> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        ConversationSettingsRepositoryImpl$userLanguage$1 conversationSettingsRepositoryImpl$userLanguage$1 = new ConversationSettingsRepositoryImpl$userLanguage$1(continuation);
        conversationSettingsRepositoryImpl$userLanguage$1.L$0 = flowCollector;
        conversationSettingsRepositoryImpl$userLanguage$1.L$1 = th;
        return conversationSettingsRepositoryImpl$userLanguage$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector = (FlowCollector) this.L$0;
        Throwable th = (Throwable) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Log.e(ConversationSettingsRepositoryImpl.TAG, "Error reading input language.", th);
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.L$1 = SpillingKt.nullOutSpilledVariable(th);
            this.label = 1;
            if (flowCollector.emit(PreferencesFactory.createEmpty(), (Continuation) this) == coroutine_suspended) {
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
