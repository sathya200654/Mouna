package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.conversationsuggestion;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.ConversationSuggestion;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.CorrectionSuggestion;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.SuggestionCategory;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: ConversationSuggestionRepository.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\r\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0006\u0010\u0011\u001a\u00020\bH¦@¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0006\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0006\u0010\r\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0006\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000bJJ\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00040\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0019H¦@¢\u0006\u0002\u0010 J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\r\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u000eJ:\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019H¦@¢\u0006\u0002\u0010#¨\u0006$À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/conversationsuggestion/ConversationSuggestionRepository;", "", "getAllSuggestions", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/ConversationSuggestion;", "insertInputSuggestionCategory", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "category", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/SuggestionCategory;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/SuggestionCategory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertInputSuggestion", "suggestion", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/ConversationSuggestion;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteInputSuggestion", "", "suggestionId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteInputSuggestionCategory", "updateInputSuggestion", "updateInputSuggestionCategory", "fetchCorrectionSuggestion", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/CorrectionSuggestion;", "deviceId", "", "gmailId", "customerId", "token", "inputLang", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "sentence", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSuggestionWithCategory", "fetchPredefinedSuggestions", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ConversationSuggestionRepository {
    Object deleteInputSuggestion(long j, Continuation<? super ResponseResource<Unit>> continuation);

    Object deleteInputSuggestionCategory(SuggestionCategory suggestionCategory, Continuation<? super ResponseResource<Unit>> continuation);

    Object fetchCorrectionSuggestion(String str, String str2, String str3, String str4, LanguageEnum languageEnum, String str5, Continuation<? super ResponseResource<? extends List<CorrectionSuggestion>>> continuation);

    Object fetchPredefinedSuggestions(String str, String str2, String str3, String str4, Continuation<? super ResponseResource<? extends List<ConversationSuggestion>>> continuation);

    Flow<List<ConversationSuggestion>> getAllSuggestions();

    Object insertInputSuggestion(ConversationSuggestion conversationSuggestion, Continuation<? super ResponseResource<Long>> continuation);

    Object insertInputSuggestionCategory(SuggestionCategory suggestionCategory, Continuation<? super ResponseResource<Long>> continuation);

    Object insertSuggestionWithCategory(ConversationSuggestion conversationSuggestion, Continuation<? super ResponseResource<Long>> continuation);

    Object updateInputSuggestion(ConversationSuggestion conversationSuggestion, Continuation<? super ResponseResource<Unit>> continuation);

    Object updateInputSuggestionCategory(SuggestionCategory suggestionCategory, Continuation<? super ResponseResource<Unit>> continuation);
}
