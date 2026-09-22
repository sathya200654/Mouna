package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import android.speech.tts.Voice;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsettings.VoiceOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationSettingsViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsState;", "<unused var>", "conversationSettings", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsFlow;", "settings", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/SettingsFlow;", "voices", "", "Landroid/speech/tts/Voice;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationSettingsViewModel$uiState$1", f = "ConversationSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ConversationSettingsViewModel$uiState$1 extends SuspendLambda implements Function5<ConversationSettingsState, ConversationSettingsFlow, SettingsFlow, List<? extends Voice>, Continuation<? super ConversationSettingsState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;

    ConversationSettingsViewModel$uiState$1(Continuation<? super ConversationSettingsViewModel$uiState$1> continuation) {
        super(5, continuation);
    }

    public final Object invoke(ConversationSettingsState conversationSettingsState, ConversationSettingsFlow conversationSettingsFlow, SettingsFlow settingsFlow, List<? extends Voice> list, Continuation<? super ConversationSettingsState> continuation) {
        ConversationSettingsViewModel$uiState$1 conversationSettingsViewModel$uiState$1 = new ConversationSettingsViewModel$uiState$1(continuation);
        conversationSettingsViewModel$uiState$1.L$0 = conversationSettingsFlow;
        conversationSettingsViewModel$uiState$1.L$1 = settingsFlow;
        conversationSettingsViewModel$uiState$1.L$2 = list;
        return conversationSettingsViewModel$uiState$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ConversationSettingsFlow conversationSettingsFlow = (ConversationSettingsFlow) this.L$0;
        SettingsFlow settingsFlow = (SettingsFlow) this.L$1;
        List list = (List) this.L$2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List listSortedWith = CollectionsKt.sortedWith(list, new Comparator() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationSettingsViewModel$uiState$1$invokeSuspend$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((Voice) t).getName(), ((Voice) t2).getName());
            }
        });
        int i = 0;
        VoiceOption voiceOption = new VoiceOption(null, R.string.global_label_system_default, null, conversationSettingsFlow.getSelectedVoice() == null, null, 4, null);
        List list2 = listSortedWith;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Object obj2 : list2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Voice voice = (Voice) obj2;
            arrayList.add(new VoiceOption(voice.getName(), R.string.conversation_tts_voice_name, CollectionsKt.listOf(Boxing.boxInt(i2)), Intrinsics.areEqual(voice.getName(), conversationSettingsFlow.getSelectedVoice()), voice));
            i = i2;
        }
        List listPlus = CollectionsKt.plus(CollectionsKt.listOf(voiceOption), arrayList);
        return new ConversationSettingsState(conversationSettingsFlow.getUserLang(), conversationSettingsFlow.getSpeakerLanguage(), conversationSettingsFlow.getConversationMode(), conversationSettingsFlow.isSpeakerDetectionEnabled(), settingsFlow.getInterpretationSpeed(), settingsFlow.getInterpretationMode(), conversationSettingsFlow.getTranscriptionFontSize(), listPlus, settingsFlow.getEnvironmentRecognitionState(), conversationSettingsFlow.getSelectedVoice());
    }
}
