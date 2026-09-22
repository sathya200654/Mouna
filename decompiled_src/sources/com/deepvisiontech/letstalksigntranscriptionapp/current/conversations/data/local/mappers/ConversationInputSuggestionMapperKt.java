package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.mappers;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.SuggestionWithCategoryTuple;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationInputSuggestionCategoryEntity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationInputSuggestionSentenceEntity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.ConversationSuggestion;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.SuggestionCategory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationInputSuggestionMapper.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0003\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0001¨\u0006\u0007"}, d2 = {"toDomain", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/ConversationSuggestion;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/SuggestionWithCategoryTuple;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/SuggestionCategory;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationInputSuggestionCategoryEntity;", "toEntity", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationInputSuggestionSentenceEntity;", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ConversationInputSuggestionMapperKt {
    public static final ConversationSuggestion toDomain(SuggestionWithCategoryTuple suggestionWithCategoryTuple) {
        Intrinsics.checkNotNullParameter(suggestionWithCategoryTuple, "<this>");
        return new ConversationSuggestion(suggestionWithCategoryTuple.getSuggestion().getId(), suggestionWithCategoryTuple.getSuggestion().getText(), suggestionWithCategoryTuple.getSuggestion().getSuggestionLanguage(), new SuggestionCategory(suggestionWithCategoryTuple.getCategoryId(), suggestionWithCategoryTuple.getCategoryName()));
    }

    public static final SuggestionCategory toDomain(ConversationInputSuggestionCategoryEntity conversationInputSuggestionCategoryEntity) {
        Intrinsics.checkNotNullParameter(conversationInputSuggestionCategoryEntity, "<this>");
        return new SuggestionCategory(conversationInputSuggestionCategoryEntity.getId(), conversationInputSuggestionCategoryEntity.getCategoryName());
    }

    public static final ConversationInputSuggestionCategoryEntity toEntity(SuggestionCategory suggestionCategory) {
        Intrinsics.checkNotNullParameter(suggestionCategory, "<this>");
        return new ConversationInputSuggestionCategoryEntity(suggestionCategory.getId(), suggestionCategory.getName());
    }

    public static final ConversationInputSuggestionSentenceEntity toEntity(ConversationSuggestion conversationSuggestion) {
        Intrinsics.checkNotNullParameter(conversationSuggestion, "<this>");
        return new ConversationInputSuggestionSentenceEntity(conversationSuggestion.getId(), conversationSuggestion.getText(), conversationSuggestion.getCategory().getId(), conversationSuggestion.getLanguage());
    }
}
