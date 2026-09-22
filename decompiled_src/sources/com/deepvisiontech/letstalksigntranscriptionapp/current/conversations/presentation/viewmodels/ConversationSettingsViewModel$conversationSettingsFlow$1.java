package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function6;

/* JADX INFO: compiled from: ConversationSettingsViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsFlow;", "<destruct>", "Lkotlin/Pair;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "speakerDetection", "", "fontSize", "", "convoMode", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;", "selectedVoice", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationSettingsViewModel$conversationSettingsFlow$1", f = "ConversationSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ConversationSettingsViewModel$conversationSettingsFlow$1 extends SuspendLambda implements Function6<Pair<? extends LanguageEnum, ? extends LanguageEnum>, Boolean, Float, ConversationMode, String, Continuation<? super ConversationSettingsFlow>, Object> {
    /* synthetic */ float F$0;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    /* synthetic */ boolean Z$0;
    int label;

    ConversationSettingsViewModel$conversationSettingsFlow$1(Continuation<? super ConversationSettingsViewModel$conversationSettingsFlow$1> continuation) {
        super(6, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return invoke((Pair<? extends LanguageEnum, ? extends LanguageEnum>) obj, ((Boolean) obj2).booleanValue(), ((Number) obj3).floatValue(), (ConversationMode) obj4, (String) obj5, (Continuation<? super ConversationSettingsFlow>) obj6);
    }

    public final Object invoke(Pair<? extends LanguageEnum, ? extends LanguageEnum> pair, boolean z, float f, ConversationMode conversationMode, String str, Continuation<? super ConversationSettingsFlow> continuation) {
        ConversationSettingsViewModel$conversationSettingsFlow$1 conversationSettingsViewModel$conversationSettingsFlow$1 = new ConversationSettingsViewModel$conversationSettingsFlow$1(continuation);
        conversationSettingsViewModel$conversationSettingsFlow$1.L$0 = pair;
        conversationSettingsViewModel$conversationSettingsFlow$1.Z$0 = z;
        conversationSettingsViewModel$conversationSettingsFlow$1.F$0 = f;
        conversationSettingsViewModel$conversationSettingsFlow$1.L$1 = conversationMode;
        conversationSettingsViewModel$conversationSettingsFlow$1.L$2 = str;
        return conversationSettingsViewModel$conversationSettingsFlow$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Pair pair = (Pair) this.L$0;
        boolean z = this.Z$0;
        float f = this.F$0;
        ConversationMode conversationMode = (ConversationMode) this.L$1;
        String str = (String) this.L$2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return new ConversationSettingsFlow((LanguageEnum) pair.component1(), (LanguageEnum) pair.component2(), z, str, f, conversationMode);
    }
}
