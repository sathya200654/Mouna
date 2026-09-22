package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.ConversationSuggestion;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.conversationsuggestion.ConversationSuggestionRepository;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: GetAllConversationInputSuggestionUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Singleton
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsuggestion/GetAllConversationInputSuggestionUseCase;", "", "conversationSuggestionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/conversationsuggestion/ConversationSuggestionRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/conversationsuggestion/ConversationSuggestionRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/ConversationSuggestion;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetAllConversationInputSuggestionUseCase {
    public static final int $stable = 8;
    private final ConversationSuggestionRepository conversationSuggestionRepository;

    @Inject
    public GetAllConversationInputSuggestionUseCase(ConversationSuggestionRepository conversationSuggestionRepository) {
        Intrinsics.checkNotNullParameter(conversationSuggestionRepository, "conversationSuggestionRepository");
        this.conversationSuggestionRepository = conversationSuggestionRepository;
    }

    public final Flow<List<ConversationSuggestion>> invoke() {
        return this.conversationSuggestionRepository.getAllSuggestions();
    }
}
