package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: ConversationSettingsRepository.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u0019J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u0019J\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u001c\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u001dJ\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u001f\u001a\u00020\rH¦@¢\u0006\u0002\u0010 J\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H¦@¢\u0006\u0002\u0010\"J\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H¦@¢\u0006\u0002\u0010\"J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010%\u001a\u00020\u0013H¦@¢\u0006\u0002\u0010&J\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H¦@¢\u0006\u0002\u0010\"R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006R\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006R\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0006¨\u0006(À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationSettingsRepository;", "", "userLanguage", "Lkotlinx/coroutines/flow/Flow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "getUserLanguage", "()Lkotlinx/coroutines/flow/Flow;", "speakerLanguage", "getSpeakerLanguage", "conversationMode", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;", "getConversationMode", "conversationTranscriptFontSize", "", "getConversationTranscriptFontSize", "isCorrectionSuggestionsEnabled", "", "isSpeakerDetectionEnabled", "ttsVoice", "", "getTtsVoice", "setSpeakerLanguage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "lang", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setUserLanguage", "setConversationMode", "mode", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setConversationTranscriptFontSize", "size", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toggleSpeakerDetection", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toggleCorrectionSuggestion", "setSelectedVoice", "voiceName", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearSelectedVoice", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ConversationSettingsRepository {
    Object clearSelectedVoice(Continuation<? super ResponseResource<Unit>> continuation);

    Flow<ConversationMode> getConversationMode();

    Flow<Float> getConversationTranscriptFontSize();

    Flow<LanguageEnum> getSpeakerLanguage();

    Flow<String> getTtsVoice();

    Flow<LanguageEnum> getUserLanguage();

    Flow<Boolean> isCorrectionSuggestionsEnabled();

    Flow<Boolean> isSpeakerDetectionEnabled();

    Object setConversationMode(ConversationMode conversationMode, Continuation<? super ResponseResource<Unit>> continuation);

    Object setConversationTranscriptFontSize(float f, Continuation<? super ResponseResource<Unit>> continuation);

    Object setSelectedVoice(String str, Continuation<? super ResponseResource<Unit>> continuation);

    Object setSpeakerLanguage(LanguageEnum languageEnum, Continuation<? super ResponseResource<Unit>> continuation);

    Object setUserLanguage(LanguageEnum languageEnum, Continuation<? super ResponseResource<Unit>> continuation);

    Object toggleCorrectionSuggestion(Continuation<? super ResponseResource<Unit>> continuation);

    Object toggleSpeakerDetection(Continuation<? super ResponseResource<Unit>> continuation);
}
