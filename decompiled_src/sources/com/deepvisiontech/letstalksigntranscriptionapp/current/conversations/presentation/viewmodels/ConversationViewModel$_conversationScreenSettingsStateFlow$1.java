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

/* JADX INFO: compiled from: ConversationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationScreenSettingsState;", "conversationMode", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;", "fontSize", "", "<destruct>", "Lkotlin/Pair;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "speakerDetectionState", "", "selectedVoiceId", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$_conversationScreenSettingsStateFlow$1", f = "ConversationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ConversationViewModel$_conversationScreenSettingsStateFlow$1 extends SuspendLambda implements Function6<ConversationMode, Float, Pair<? extends LanguageEnum, ? extends LanguageEnum>, Boolean, String, Continuation<? super ConversationScreenSettingsState>, Object> {
    /* synthetic */ float F$0;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    /* synthetic */ boolean Z$0;
    int label;

    ConversationViewModel$_conversationScreenSettingsStateFlow$1(Continuation<? super ConversationViewModel$_conversationScreenSettingsStateFlow$1> continuation) {
        super(6, continuation);
    }

    public final Object invoke(ConversationMode conversationMode, float f, Pair<? extends LanguageEnum, ? extends LanguageEnum> pair, boolean z, String str, Continuation<? super ConversationScreenSettingsState> continuation) {
        ConversationViewModel$_conversationScreenSettingsStateFlow$1 conversationViewModel$_conversationScreenSettingsStateFlow$1 = new ConversationViewModel$_conversationScreenSettingsStateFlow$1(continuation);
        conversationViewModel$_conversationScreenSettingsStateFlow$1.L$0 = conversationMode;
        conversationViewModel$_conversationScreenSettingsStateFlow$1.F$0 = f;
        conversationViewModel$_conversationScreenSettingsStateFlow$1.L$1 = pair;
        conversationViewModel$_conversationScreenSettingsStateFlow$1.Z$0 = z;
        conversationViewModel$_conversationScreenSettingsStateFlow$1.L$2 = str;
        return conversationViewModel$_conversationScreenSettingsStateFlow$1.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return invoke((ConversationMode) obj, ((Number) obj2).floatValue(), (Pair<? extends LanguageEnum, ? extends LanguageEnum>) obj3, ((Boolean) obj4).booleanValue(), (String) obj5, (Continuation<? super ConversationScreenSettingsState>) obj6);
    }

    public final Object invokeSuspend(Object obj) {
        ConversationMode conversationMode = (ConversationMode) this.L$0;
        float f = this.F$0;
        Pair pair = (Pair) this.L$1;
        boolean z = this.Z$0;
        String str = (String) this.L$2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return new ConversationScreenSettingsState(conversationMode, (LanguageEnum) pair.component1(), (LanguageEnum) pair.component2(), f, str, z);
    }
}
