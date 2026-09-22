package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.mappers.LanguageMapper;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.ConversationSuggestion;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.CorrectionSuggestion;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.SuggestionCategory;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.conversationsuggestion.ConversationSuggestionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.legacy.utils.StringUtilsKt;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InsertConversationInputSuggestionUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Singleton
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J.\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086B¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsuggestion/InsertConversationInputSuggestionUseCase;", "", "conversationSuggestionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/conversationsuggestion/ConversationSuggestionRepository;", "analyticsManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/conversationsuggestion/ConversationSuggestionRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "correctionSuggestion", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/CorrectionSuggestion;", "category", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/SuggestionCategory;", "categoryName", "", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/CorrectionSuggestion;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/SuggestionCategory;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InsertConversationInputSuggestionUseCase {
    public static final int $stable = AnalyticsManager.$stable;
    private final AnalyticsManager analyticsManager;
    private final ConversationSuggestionRepository conversationSuggestionRepository;

    @Inject
    public InsertConversationInputSuggestionUseCase(ConversationSuggestionRepository conversationSuggestionRepository, AnalyticsManager analyticsManager) {
        Intrinsics.checkNotNullParameter(conversationSuggestionRepository, "conversationSuggestionRepository");
        Intrinsics.checkNotNullParameter(analyticsManager, "analyticsManager");
        this.conversationSuggestionRepository = conversationSuggestionRepository;
        this.analyticsManager = analyticsManager;
    }

    public final Object invoke(CorrectionSuggestion correctionSuggestion, SuggestionCategory suggestionCategory, String str, Continuation<? super ResponseResource<Long>> continuation) {
        if (!StringUtilsKt.isTextInLanguage(correctionSuggestion.getSentence(), LanguageMapper.INSTANCE.toTranscriptionLang(correctionSuggestion.getLanguage()))) {
            return new ResponseResource.Error(AppError.LanguageError.INSTANCE);
        }
        if (suggestionCategory == null) {
            suggestionCategory = new SuggestionCategory(0L, str);
        }
        ConversationSuggestion conversationSuggestion = new ConversationSuggestion(0L, correctionSuggestion.getSentence(), correctionSuggestion.getLanguage(), suggestionCategory);
        this.analyticsManager.logEvent(new AnalyticsEvent.SuggestionSavedToPredef(correctionSuggestion.getLanguage().name(), correctionSuggestion.getSentence().length()));
        return this.conversationSuggestionRepository.insertSuggestionWithCategory(conversationSuggestion, continuation);
    }
}
