package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecasewrappers;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.GetAllFilteredMessagesOfConversationUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.SetConversationModeUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversation.GetActiveOrNewConversationUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversation.UpdateConversationUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsummary.GenerateAndInsertConversationSummaryUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationManagementUseCases.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecasewrappers/ConversationManagementUseCases;", "", "getFilteredMessages", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/GetAllFilteredMessagesOfConversationUseCase;", "updateConversation", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversation/UpdateConversationUseCase;", "setModeConversationMode", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/SetConversationModeUseCase;", "summarizeConversationMessages", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsummary/GenerateAndInsertConversationSummaryUseCase;", "getActiveOrNewConversation", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversation/GetActiveOrNewConversationUseCase;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/GetAllFilteredMessagesOfConversationUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversation/UpdateConversationUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/SetConversationModeUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsummary/GenerateAndInsertConversationSummaryUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversation/GetActiveOrNewConversationUseCase;)V", "getGetFilteredMessages", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/GetAllFilteredMessagesOfConversationUseCase;", "getUpdateConversation", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversation/UpdateConversationUseCase;", "getSetModeConversationMode", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/SetConversationModeUseCase;", "getSummarizeConversationMessages", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsummary/GenerateAndInsertConversationSummaryUseCase;", "getGetActiveOrNewConversation", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversation/GetActiveOrNewConversationUseCase;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ConversationManagementUseCases {
    public static final int $stable = 8;
    private final GetActiveOrNewConversationUseCase getActiveOrNewConversation;
    private final GetAllFilteredMessagesOfConversationUseCase getFilteredMessages;
    private final SetConversationModeUseCase setModeConversationMode;
    private final GenerateAndInsertConversationSummaryUseCase summarizeConversationMessages;
    private final UpdateConversationUseCase updateConversation;

    public static /* synthetic */ ConversationManagementUseCases copy$default(ConversationManagementUseCases conversationManagementUseCases, GetAllFilteredMessagesOfConversationUseCase getAllFilteredMessagesOfConversationUseCase, UpdateConversationUseCase updateConversationUseCase, SetConversationModeUseCase setConversationModeUseCase, GenerateAndInsertConversationSummaryUseCase generateAndInsertConversationSummaryUseCase, GetActiveOrNewConversationUseCase getActiveOrNewConversationUseCase, int i, Object obj) {
        if ((i & 1) != 0) {
            getAllFilteredMessagesOfConversationUseCase = conversationManagementUseCases.getFilteredMessages;
        }
        if ((i & 2) != 0) {
            updateConversationUseCase = conversationManagementUseCases.updateConversation;
        }
        if ((i & 4) != 0) {
            setConversationModeUseCase = conversationManagementUseCases.setModeConversationMode;
        }
        if ((i & 8) != 0) {
            generateAndInsertConversationSummaryUseCase = conversationManagementUseCases.summarizeConversationMessages;
        }
        if ((i & 16) != 0) {
            getActiveOrNewConversationUseCase = conversationManagementUseCases.getActiveOrNewConversation;
        }
        GetActiveOrNewConversationUseCase getActiveOrNewConversationUseCase2 = getActiveOrNewConversationUseCase;
        SetConversationModeUseCase setConversationModeUseCase2 = setConversationModeUseCase;
        return conversationManagementUseCases.copy(getAllFilteredMessagesOfConversationUseCase, updateConversationUseCase, setConversationModeUseCase2, generateAndInsertConversationSummaryUseCase, getActiveOrNewConversationUseCase2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GetAllFilteredMessagesOfConversationUseCase getGetFilteredMessages() {
        return this.getFilteredMessages;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final UpdateConversationUseCase getUpdateConversation() {
        return this.updateConversation;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final SetConversationModeUseCase getSetModeConversationMode() {
        return this.setModeConversationMode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final GenerateAndInsertConversationSummaryUseCase getSummarizeConversationMessages() {
        return this.summarizeConversationMessages;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final GetActiveOrNewConversationUseCase getGetActiveOrNewConversation() {
        return this.getActiveOrNewConversation;
    }

    public final ConversationManagementUseCases copy(GetAllFilteredMessagesOfConversationUseCase getFilteredMessages, UpdateConversationUseCase updateConversation, SetConversationModeUseCase setModeConversationMode, GenerateAndInsertConversationSummaryUseCase summarizeConversationMessages, GetActiveOrNewConversationUseCase getActiveOrNewConversation) {
        Intrinsics.checkNotNullParameter(getFilteredMessages, "getFilteredMessages");
        Intrinsics.checkNotNullParameter(updateConversation, "updateConversation");
        Intrinsics.checkNotNullParameter(setModeConversationMode, "setModeConversationMode");
        Intrinsics.checkNotNullParameter(summarizeConversationMessages, "summarizeConversationMessages");
        Intrinsics.checkNotNullParameter(getActiveOrNewConversation, "getActiveOrNewConversation");
        return new ConversationManagementUseCases(getFilteredMessages, updateConversation, setModeConversationMode, summarizeConversationMessages, getActiveOrNewConversation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationManagementUseCases)) {
            return false;
        }
        ConversationManagementUseCases conversationManagementUseCases = (ConversationManagementUseCases) other;
        return Intrinsics.areEqual(this.getFilteredMessages, conversationManagementUseCases.getFilteredMessages) && Intrinsics.areEqual(this.updateConversation, conversationManagementUseCases.updateConversation) && Intrinsics.areEqual(this.setModeConversationMode, conversationManagementUseCases.setModeConversationMode) && Intrinsics.areEqual(this.summarizeConversationMessages, conversationManagementUseCases.summarizeConversationMessages) && Intrinsics.areEqual(this.getActiveOrNewConversation, conversationManagementUseCases.getActiveOrNewConversation);
    }

    public int hashCode() {
        return (((((((this.getFilteredMessages.hashCode() * 31) + this.updateConversation.hashCode()) * 31) + this.setModeConversationMode.hashCode()) * 31) + this.summarizeConversationMessages.hashCode()) * 31) + this.getActiveOrNewConversation.hashCode();
    }

    public String toString() {
        return "ConversationManagementUseCases(getFilteredMessages=" + this.getFilteredMessages + ", updateConversation=" + this.updateConversation + ", setModeConversationMode=" + this.setModeConversationMode + ", summarizeConversationMessages=" + this.summarizeConversationMessages + ", getActiveOrNewConversation=" + this.getActiveOrNewConversation + ")";
    }

    @Inject
    public ConversationManagementUseCases(GetAllFilteredMessagesOfConversationUseCase getAllFilteredMessagesOfConversationUseCase, UpdateConversationUseCase updateConversationUseCase, SetConversationModeUseCase setConversationModeUseCase, GenerateAndInsertConversationSummaryUseCase generateAndInsertConversationSummaryUseCase, GetActiveOrNewConversationUseCase getActiveOrNewConversationUseCase) {
        Intrinsics.checkNotNullParameter(getAllFilteredMessagesOfConversationUseCase, "getFilteredMessages");
        Intrinsics.checkNotNullParameter(updateConversationUseCase, "updateConversation");
        Intrinsics.checkNotNullParameter(setConversationModeUseCase, "setModeConversationMode");
        Intrinsics.checkNotNullParameter(generateAndInsertConversationSummaryUseCase, "summarizeConversationMessages");
        Intrinsics.checkNotNullParameter(getActiveOrNewConversationUseCase, "getActiveOrNewConversation");
        this.getFilteredMessages = getAllFilteredMessagesOfConversationUseCase;
        this.updateConversation = updateConversationUseCase;
        this.setModeConversationMode = setConversationModeUseCase;
        this.summarizeConversationMessages = generateAndInsertConversationSummaryUseCase;
        this.getActiveOrNewConversation = getActiveOrNewConversationUseCase;
    }

    public final GetAllFilteredMessagesOfConversationUseCase getGetFilteredMessages() {
        return this.getFilteredMessages;
    }

    public final UpdateConversationUseCase getUpdateConversation() {
        return this.updateConversation;
    }

    public final SetConversationModeUseCase getSetModeConversationMode() {
        return this.setModeConversationMode;
    }

    public final GenerateAndInsertConversationSummaryUseCase getSummarizeConversationMessages() {
        return this.summarizeConversationMessages;
    }

    public final GetActiveOrNewConversationUseCase getGetActiveOrNewConversation() {
        return this.getActiveOrNewConversation;
    }
}
