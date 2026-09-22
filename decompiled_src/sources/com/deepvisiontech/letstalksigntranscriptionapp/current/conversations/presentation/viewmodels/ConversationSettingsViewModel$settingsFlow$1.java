package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.model.InterpretationMode;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.model.InterpretationSpeed;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: ConversationSettingsViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/SettingsFlow;", "interpretationSpeed", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationSpeed;", "interpretationMode", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationMode;", "isSoundRecognizerEnabled", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationSettingsViewModel$settingsFlow$1", f = "ConversationSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ConversationSettingsViewModel$settingsFlow$1 extends SuspendLambda implements Function4<InterpretationSpeed, InterpretationMode, Boolean, Continuation<? super SettingsFlow>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ boolean Z$0;
    int label;

    ConversationSettingsViewModel$settingsFlow$1(Continuation<? super ConversationSettingsViewModel$settingsFlow$1> continuation) {
        super(4, continuation);
    }

    public final Object invoke(InterpretationSpeed interpretationSpeed, InterpretationMode interpretationMode, boolean z, Continuation<? super SettingsFlow> continuation) {
        ConversationSettingsViewModel$settingsFlow$1 conversationSettingsViewModel$settingsFlow$1 = new ConversationSettingsViewModel$settingsFlow$1(continuation);
        conversationSettingsViewModel$settingsFlow$1.L$0 = interpretationSpeed;
        conversationSettingsViewModel$settingsFlow$1.L$1 = interpretationMode;
        conversationSettingsViewModel$settingsFlow$1.Z$0 = z;
        return conversationSettingsViewModel$settingsFlow$1.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return invoke((InterpretationSpeed) obj, (InterpretationMode) obj2, ((Boolean) obj3).booleanValue(), (Continuation<? super SettingsFlow>) obj4);
    }

    public final Object invokeSuspend(Object obj) {
        InterpretationSpeed interpretationSpeed = (InterpretationSpeed) this.L$0;
        InterpretationMode interpretationMode = (InterpretationMode) this.L$1;
        boolean z = this.Z$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return new SettingsFlow(interpretationMode, interpretationSpeed, z);
    }
}
