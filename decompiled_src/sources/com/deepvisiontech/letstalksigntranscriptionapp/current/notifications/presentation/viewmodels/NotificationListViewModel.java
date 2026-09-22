package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.DateFilterRange;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.ListSortOrder;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.Notification;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.usecase.DeleteNotificationsUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.usecase.GetAllFilteredNotificationsUseCase;
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

/* JADX INFO: compiled from: NotificationListViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\nJ\u000e\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\fJ\u000e\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u0010J\u000e\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020\nJ\u0006\u0010+\u001a\u00020\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006-"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationListViewModel;", "Landroidx/lifecycle/ViewModel;", "getAllFilteredNotificationsUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/usecase/GetAllFilteredNotificationsUseCase;", "deleteNotificationsUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/usecase/DeleteNotificationsUseCase;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/usecase/GetAllFilteredNotificationsUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/usecase/DeleteNotificationsUseCase;)V", "_searchQuery", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_sortOrder", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/ListSortOrder;", "_selectedIds", "", "_dateRange", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/DateFilterRange;", "_uiEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationListScreenEvent;", "uiEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getUiEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "filteredNotifications", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/Notification;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationListScreenUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "clearSelectedIds", "", "updateSearchQuery", "query", "updateSortOrder", "order", "updateDateRange", "range", "updateSelectedIds", "id", "deleteNotifications", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NotificationListViewModel extends ViewModel {
    private static final String TAG = "NotificationListViewModel";
    private final MutableStateFlow<DateFilterRange> _dateRange;
    private final MutableStateFlow<String> _searchQuery;
    private final MutableStateFlow<Set<String>> _selectedIds;
    private final MutableStateFlow<ListSortOrder> _sortOrder;
    private final MutableSharedFlow<NotificationListScreenEvent> _uiEvent;
    private final DeleteNotificationsUseCase deleteNotificationsUseCase;
    private final Flow<List<Notification>> filteredNotifications;
    private final SharedFlow<NotificationListScreenEvent> uiEvent;
    private final StateFlow<NotificationListScreenUiState> uiState;
    public static final int $stable = 8;

    @Inject
    public NotificationListViewModel(GetAllFilteredNotificationsUseCase getAllFilteredNotificationsUseCase, DeleteNotificationsUseCase deleteNotificationsUseCase) {
        Intrinsics.checkNotNullParameter(getAllFilteredNotificationsUseCase, "getAllFilteredNotificationsUseCase");
        Intrinsics.checkNotNullParameter(deleteNotificationsUseCase, "deleteNotificationsUseCase");
        this.deleteNotificationsUseCase = deleteNotificationsUseCase;
        MutableStateFlow<String> MutableStateFlow = StateFlowKt.MutableStateFlow("");
        this._searchQuery = MutableStateFlow;
        MutableStateFlow<ListSortOrder> MutableStateFlow2 = StateFlowKt.MutableStateFlow(ListSortOrder.BY_TIME_DESC);
        this._sortOrder = MutableStateFlow2;
        Flow flowMutableStateFlow = StateFlowKt.MutableStateFlow(SetsKt.emptySet());
        this._selectedIds = flowMutableStateFlow;
        MutableStateFlow<DateFilterRange> MutableStateFlow3 = StateFlowKt.MutableStateFlow(new DateFilterRange(null, null, 3, null));
        this._dateRange = MutableStateFlow3;
        SharedFlow<NotificationListScreenEvent> sharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._uiEvent = sharedFlowMutableSharedFlow$default;
        this.uiEvent = sharedFlowMutableSharedFlow$default;
        Flow<List<Notification>> flowInvoke = getAllFilteredNotificationsUseCase.invoke((Flow) MutableStateFlow, (Flow) MutableStateFlow2, (Flow) MutableStateFlow3);
        this.filteredNotifications = flowInvoke;
        this.uiState = FlowKt.stateIn(FlowKt.catch(FlowKt.flowCombine(FlowKt.flowCombine(FlowKt.flowCombine(FlowKt.flowCombine(flowInvoke, (Flow) MutableStateFlow, new NotificationListViewModel$uiState$1(null)), (Flow) MutableStateFlow2, new NotificationListViewModel$uiState$2(null)), (Flow) MutableStateFlow3, new NotificationListViewModel$uiState$3(null)), flowMutableStateFlow, new NotificationListViewModel$uiState$4(null)), new NotificationListViewModel$uiState$5(this, null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object) null), new NotificationListScreenUiState(null, false, false, null, null, null, null, 127, null));
    }

    public final SharedFlow<NotificationListScreenEvent> getUiEvent() {
        return this.uiEvent;
    }

    public final StateFlow<NotificationListScreenUiState> getUiState() {
        return this.uiState;
    }

    public final void clearSelectedIds() {
        Object value;
        MutableStateFlow<Set<String>> mutableStateFlow = this._selectedIds;
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
        this._dateRange.setValue(range);
    }

    public final void updateSelectedIds(String id) {
        Object value;
        Set setPlus;
        Intrinsics.checkNotNullParameter(id, "id");
        MutableStateFlow<Set<String>> mutableStateFlow = this._selectedIds;
        do {
            value = mutableStateFlow.getValue();
            Set set = (Set) value;
            if (set.contains(id)) {
                setPlus = SetsKt.minus(set, id);
            } else {
                setPlus = SetsKt.plus(set, id);
            }
        } while (!mutableStateFlow.compareAndSet(value, setPlus));
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationListViewModel$deleteNotifications$1, reason: invalid class name */
    /* JADX INFO: compiled from: NotificationListViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationListViewModel$deleteNotifications$1", f = "NotificationListViewModel.kt", i = {0, 1, 1}, l = {134, 136}, m = "invokeSuspend", n = {"notificationsToDelete", "notificationsToDelete", "response"}, s = {"L$0", "L$0", "L$1"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NotificationListViewModel.this.new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00b6, code lost:
        
            if (r6.this$0._uiEvent.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationListScreenEvent.ShowUserMessage(com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.mappers.AppErrorMapperKt.toNotificationErrorMessageRes(((com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r7).getError())), (kotlin.coroutines.Continuation) r6) == r0) goto L27;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws kotlin.NoWhenBranchMatchedException {
            /*
                Method dump skipped, instruction units count: 218
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationListViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void deleteNotifications() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
    }
}
