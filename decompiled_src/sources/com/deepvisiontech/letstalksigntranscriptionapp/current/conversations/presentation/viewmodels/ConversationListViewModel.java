package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.DateFilterRange;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.ListSortOrder;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.Conversation;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.DeleteConversationsUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.GetAllFilteredConversationsUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.InsertAndSetActiveConversationUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.SetActiveConversationUseCase;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: ConversationListViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u000eJ\u000e\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020\u0010J\u000e\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020\u0015J\u000e\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\u0013J\u0006\u00100\u001a\u00020'J\u000e\u00101\u001a\u00020'2\u0006\u0010/\u001a\u00020\u0013J\u000e\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00064"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationListViewModel;", "Landroidx/lifecycle/ViewModel;", "getAllFilteredConversationsUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/GetAllFilteredConversationsUseCase;", "setActiveConversationUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/SetActiveConversationUseCase;", "deleteConversationsUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/DeleteConversationsUseCase;", "insertAndSetActiveConversationUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/InsertAndSetActiveConversationUseCase;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/GetAllFilteredConversationsUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/SetActiveConversationUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/DeleteConversationsUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/InsertAndSetActiveConversationUseCase;)V", "_searchQuery", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_sortOrder", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/ListSortOrder;", "_selectedIds", "", "", "_dateRange", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/DateFilterRange;", "_uiEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationListScreenEvent;", "uiEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getUiEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "filteredConversations", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/Conversation;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationListScreenUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "clearSelectedIds", "", "updateSearchQuery", "query", "updateSortOrder", "order", "updateDateRange", "range", "updateSelectedIds", "id", "deleteConversations", "updateActiveConversation", "createNewConversation", "name", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ConversationListViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<DateFilterRange> _dateRange;
    private final MutableStateFlow<String> _searchQuery;
    private final MutableStateFlow<Set<Long>> _selectedIds;
    private final MutableStateFlow<ListSortOrder> _sortOrder;
    private final MutableSharedFlow<ConversationListScreenEvent> _uiEvent;
    private final DeleteConversationsUseCase deleteConversationsUseCase;
    private final Flow<List<Conversation>> filteredConversations;
    private final InsertAndSetActiveConversationUseCase insertAndSetActiveConversationUseCase;
    private final SetActiveConversationUseCase setActiveConversationUseCase;
    private final SharedFlow<ConversationListScreenEvent> uiEvent;
    private final StateFlow<ConversationListScreenUiState> uiState;

    @Inject
    public ConversationListViewModel(GetAllFilteredConversationsUseCase getAllFilteredConversationsUseCase, SetActiveConversationUseCase setActiveConversationUseCase, DeleteConversationsUseCase deleteConversationsUseCase, InsertAndSetActiveConversationUseCase insertAndSetActiveConversationUseCase) {
        Intrinsics.checkNotNullParameter(getAllFilteredConversationsUseCase, "getAllFilteredConversationsUseCase");
        Intrinsics.checkNotNullParameter(setActiveConversationUseCase, "setActiveConversationUseCase");
        Intrinsics.checkNotNullParameter(deleteConversationsUseCase, "deleteConversationsUseCase");
        Intrinsics.checkNotNullParameter(insertAndSetActiveConversationUseCase, "insertAndSetActiveConversationUseCase");
        this.setActiveConversationUseCase = setActiveConversationUseCase;
        this.deleteConversationsUseCase = deleteConversationsUseCase;
        this.insertAndSetActiveConversationUseCase = insertAndSetActiveConversationUseCase;
        MutableStateFlow<String> MutableStateFlow = StateFlowKt.MutableStateFlow("");
        this._searchQuery = MutableStateFlow;
        MutableStateFlow<ListSortOrder> MutableStateFlow2 = StateFlowKt.MutableStateFlow(ListSortOrder.BY_TIME_DESC);
        this._sortOrder = MutableStateFlow2;
        Flow flowMutableStateFlow = StateFlowKt.MutableStateFlow(SetsKt.emptySet());
        this._selectedIds = flowMutableStateFlow;
        MutableStateFlow<DateFilterRange> MutableStateFlow3 = StateFlowKt.MutableStateFlow(new DateFilterRange(null, null, 3, null));
        this._dateRange = MutableStateFlow3;
        MutableSharedFlow<ConversationListScreenEvent> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._uiEvent = mutableSharedFlowMutableSharedFlow$default;
        this.uiEvent = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
        Flow<List<Conversation>> flowInvoke = getAllFilteredConversationsUseCase.invoke((Flow) MutableStateFlow, (Flow) MutableStateFlow2, (Flow) MutableStateFlow3);
        this.filteredConversations = flowInvoke;
        this.uiState = FlowKt.stateIn(FlowKt.catch(FlowKt.flowCombine(FlowKt.flowCombine(FlowKt.flowCombine(FlowKt.flowCombine(flowInvoke, (Flow) MutableStateFlow, new ConversationListViewModel$uiState$1(null)), (Flow) MutableStateFlow2, new ConversationListViewModel$uiState$2(null)), (Flow) MutableStateFlow3, new ConversationListViewModel$uiState$3(null)), flowMutableStateFlow, new ConversationListViewModel$uiState$4(null)), new ConversationListViewModel$uiState$5(this, null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object) null), new ConversationListScreenUiState(null, false, false, null, null, null, null, 127, null));
    }

    public final SharedFlow<ConversationListScreenEvent> getUiEvent() {
        return this.uiEvent;
    }

    public final StateFlow<ConversationListScreenUiState> getUiState() {
        return this.uiState;
    }

    public final void clearSelectedIds() {
        Object value;
        MutableStateFlow<Set<Long>> mutableStateFlow = this._selectedIds;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, SetsKt.emptySet()));
    }

    public final void updateSearchQuery(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        this._searchQuery.setValue(query);
    }

    public final void updateSortOrder(ListSortOrder order) {
        Intrinsics.checkNotNullParameter(order, "order");
        this._sortOrder.setValue(order);
    }

    public final void updateDateRange(DateFilterRange range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.getEndDate() != null) {
            range = DateFilterRange.copy$default(range, null, Long.valueOf((range.getEndDate().longValue() + ((long) 86400000)) - 1), 1, null);
        }
        this._dateRange.setValue(range);
    }

    public final void updateSelectedIds(long id) {
        Object value;
        Set setPlus;
        MutableStateFlow<Set<Long>> mutableStateFlow = this._selectedIds;
        do {
            value = mutableStateFlow.getValue();
            Set set = (Set) value;
            if (set.contains(Long.valueOf(id))) {
                setPlus = SetsKt.minus(set, Long.valueOf(id));
            } else {
                setPlus = SetsKt.plus(set, Long.valueOf(id));
            }
        } while (!mutableStateFlow.compareAndSet(value, setPlus));
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel$deleteConversations$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationListViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel$deleteConversations$1", f = "ConversationListViewModel.kt", i = {0, 1, 1}, l = {138, 140}, m = "invokeSuspend", n = {"conversationsToDelete", "conversationsToDelete", "response"}, s = {"L$0", "L$0", "L$1"})
    static final class C02401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        C02401(Continuation<? super C02401> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationListViewModel.this.new C02401(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00bd, code lost:
        
            if (r7.this$0._uiEvent.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListScreenEvent.ShowUserMessage(com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.mappers.AppErrorMappersKt.toConversationListErrorMessageRes(((com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r8).getError())), (kotlin.coroutines.Continuation) r7) == r0) goto L27;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws kotlin.NoWhenBranchMatchedException {
            /*
                Method dump skipped, instruction units count: 221
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel.C02401.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void deleteConversations() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C02401(null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel$updateActiveConversation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationListViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel$updateActiveConversation$1", f = "ConversationListViewModel.kt", i = {1, 2}, l = {153, 155, 158}, m = "invokeSuspend", n = {"response", "response"}, s = {"L$0", "L$0"})
    static final class C02411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $id;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02411(long j, Continuation<? super C02411> continuation) {
            super(2, continuation);
            this.$id = j;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationListViewModel.this.new C02411(this.$id, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x005a, code lost:
        
            if (r7.this$0._uiEvent.emit(com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListScreenEvent.NavigateToConversationScreen.INSTANCE, (kotlin.coroutines.Continuation) r7) == r0) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0086, code lost:
        
            if (r7.this$0._uiEvent.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListScreenEvent.ShowUserMessage(com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.mappers.AppErrorMappersKt.toConversationListErrorMessageRes(((com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r8).getError())), (kotlin.coroutines.Continuation) r7) == r0) goto L24;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws kotlin.NoWhenBranchMatchedException {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L26
                if (r1 == r4) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                goto L1a
            L12:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1a:
                java.lang.Object r7 = r7.L$0
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r7 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r7
                kotlin.ResultKt.throwOnFailure(r8)
                goto L8d
            L22:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L3d
            L26:
                kotlin.ResultKt.throwOnFailure(r8)
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel r8 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.SetActiveConversationUseCase r8 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel.access$getSetActiveConversationUseCase$p(r8)
                long r5 = r7.$id
                r1 = r7
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r7.label = r4
                java.lang.Object r8 = r8.invoke(r5, r1)
                if (r8 != r0) goto L3d
                goto L88
            L3d:
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r8 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r8
                boolean r1 = r8 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Success
                if (r1 == 0) goto L5d
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel.this
                kotlinx.coroutines.flow.MutableSharedFlow r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel.access$get_uiEvent$p(r1)
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListScreenEvent$NavigateToConversationScreen r2 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListScreenEvent.NavigateToConversationScreen.INSTANCE
                r4 = r7
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
                r7.L$0 = r8
                r7.label = r3
                java.lang.Object r7 = r1.emit(r2, r4)
                if (r7 != r0) goto L8d
                goto L88
            L5d:
                boolean r1 = r8 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error
                if (r1 == 0) goto L89
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel.this
                kotlinx.coroutines.flow.MutableSharedFlow r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel.access$get_uiEvent$p(r1)
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListScreenEvent$ShowUserMessage r3 = new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListScreenEvent$ShowUserMessage
                r4 = r8
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Error r4 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r4
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError r4 = r4.getError()
                int r4 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.mappers.AppErrorMappersKt.toConversationListErrorMessageRes(r4)
                r3.<init>(r4)
                r4 = r7
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
                r7.L$0 = r8
                r7.label = r2
                java.lang.Object r7 = r1.emit(r3, r4)
                if (r7 != r0) goto L8d
            L88:
                return r0
            L89:
                boolean r7 = r8 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Loading
                if (r7 == 0) goto L90
            L8d:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            L90:
                kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
                r7.<init>()
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel.C02411.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void updateActiveConversation(long id) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C02411(id, null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel$createNewConversation$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationListViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel$createNewConversation$1", f = "ConversationListViewModel.kt", i = {1, 2}, l = {167, 169, 172}, m = "invokeSuspend", n = {"response", "response"}, s = {"L$0", "L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $name;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$name = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationListViewModel.this.new AnonymousClass1(this.$name, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x005a, code lost:
        
            if (r6.this$0._uiEvent.emit(com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListScreenEvent.NavigateToConversationScreen.INSTANCE, (kotlin.coroutines.Continuation) r6) == r0) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0086, code lost:
        
            if (r6.this$0._uiEvent.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListScreenEvent.ShowUserMessage(com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.mappers.AppErrorMappersKt.toConversationListErrorMessageRes(((com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r7).getError())), (kotlin.coroutines.Continuation) r6) == r0) goto L24;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws kotlin.NoWhenBranchMatchedException {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L26
                if (r1 == r4) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                goto L1a
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1a:
                java.lang.Object r6 = r6.L$0
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r6 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r6
                kotlin.ResultKt.throwOnFailure(r7)
                goto L8d
            L22:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L3d
            L26:
                kotlin.ResultKt.throwOnFailure(r7)
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.InsertAndSetActiveConversationUseCase r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel.access$getInsertAndSetActiveConversationUseCase$p(r7)
                java.lang.String r1 = r6.$name
                r5 = r6
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r6.label = r4
                java.lang.Object r7 = r7.invoke(r1, r5)
                if (r7 != r0) goto L3d
                goto L88
            L3d:
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r7 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r7
                boolean r1 = r7 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Success
                if (r1 == 0) goto L5d
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel.this
                kotlinx.coroutines.flow.MutableSharedFlow r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel.access$get_uiEvent$p(r1)
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListScreenEvent$NavigateToConversationScreen r2 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListScreenEvent.NavigateToConversationScreen.INSTANCE
                r4 = r6
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                r6.L$0 = r7
                r6.label = r3
                java.lang.Object r6 = r1.emit(r2, r4)
                if (r6 != r0) goto L8d
                goto L88
            L5d:
                boolean r1 = r7 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error
                if (r1 == 0) goto L89
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel.this
                kotlinx.coroutines.flow.MutableSharedFlow r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel.access$get_uiEvent$p(r1)
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListScreenEvent$ShowUserMessage r3 = new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListScreenEvent$ShowUserMessage
                r4 = r7
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Error r4 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r4
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError r4 = r4.getError()
                int r4 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.mappers.AppErrorMappersKt.toConversationListErrorMessageRes(r4)
                r3.<init>(r4)
                r4 = r6
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                r6.L$0 = r7
                r6.label = r2
                java.lang.Object r6 = r1.emit(r3, r4)
                if (r6 != r0) goto L8d
            L88:
                return r0
            L89:
                boolean r6 = r7 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Loading
                if (r6 == 0) goto L90
            L8d:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            L90:
                kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
                r6.<init>()
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void createNewConversation(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(name, null), 3, (Object) null);
    }
}
