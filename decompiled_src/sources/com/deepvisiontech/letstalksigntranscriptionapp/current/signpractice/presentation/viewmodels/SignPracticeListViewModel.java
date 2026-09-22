package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.DateFilterRange;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.ListSortOrder;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPractice;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.DeleteSignPracticeUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.GetAllFilteredSignPracticesUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.IncrementSignPracticeOpenCountUseCase;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
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

/* JADX INFO: compiled from: SignPracticeListViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020'J\u000e\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020\u000eJ\u000e\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020\u0010J\u000e\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020\u0015J\u000e\u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020\u0013J\u000e\u00101\u001a\u00020'2\u0006\u00102\u001a\u00020 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00064"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeListViewModel;", "Landroidx/lifecycle/ViewModel;", "deleteSignPracticeUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/usecase/DeleteSignPracticeUseCase;", "incrementSignPracticeOpenCountUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/usecase/IncrementSignPracticeOpenCountUseCase;", "analyticsManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;", "getAllFilteredSignPracticeUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/usecase/GetAllFilteredSignPracticesUseCase;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/usecase/DeleteSignPracticeUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/usecase/IncrementSignPracticeOpenCountUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/usecase/GetAllFilteredSignPracticesUseCase;)V", "_searchQuery", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_sortOrder", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/ListSortOrder;", "_selectedIds", "", "", "_dateRange", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/DateFilterRange;", "_uiEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeListUiEvent;", "uiEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getUiEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "filteredPractices", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPractice;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeListUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "deleteSignPractices", "", "clearSelectedIds", "updateSearchQuery", "query", "updateSortOrder", "order", "updateDateRange", "range", "updateSelectedIds", "id", "incrementSignPracticeOpenCount", "signPractice", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SignPracticeListViewModel extends ViewModel {
    private static final String TAG = "SignPracticeListViewModel";
    private final MutableStateFlow<DateFilterRange> _dateRange;
    private final MutableStateFlow<String> _searchQuery;
    private final MutableStateFlow<Set<Integer>> _selectedIds;
    private final MutableStateFlow<ListSortOrder> _sortOrder;
    private final MutableSharedFlow<SignPracticeListUiEvent> _uiEvent;
    private final AnalyticsManager analyticsManager;
    private final DeleteSignPracticeUseCase deleteSignPracticeUseCase;
    private final Flow<List<SignPractice>> filteredPractices;
    private final IncrementSignPracticeOpenCountUseCase incrementSignPracticeOpenCountUseCase;
    private final SharedFlow<SignPracticeListUiEvent> uiEvent;
    private final StateFlow<SignPracticeListUiState> uiState;
    public static final int $stable = 8;

    @Inject
    public SignPracticeListViewModel(DeleteSignPracticeUseCase deleteSignPracticeUseCase, IncrementSignPracticeOpenCountUseCase incrementSignPracticeOpenCountUseCase, AnalyticsManager analyticsManager, GetAllFilteredSignPracticesUseCase getAllFilteredSignPracticesUseCase) {
        Intrinsics.checkNotNullParameter(deleteSignPracticeUseCase, "deleteSignPracticeUseCase");
        Intrinsics.checkNotNullParameter(incrementSignPracticeOpenCountUseCase, "incrementSignPracticeOpenCountUseCase");
        Intrinsics.checkNotNullParameter(analyticsManager, "analyticsManager");
        Intrinsics.checkNotNullParameter(getAllFilteredSignPracticesUseCase, "getAllFilteredSignPracticeUseCase");
        this.deleteSignPracticeUseCase = deleteSignPracticeUseCase;
        this.incrementSignPracticeOpenCountUseCase = incrementSignPracticeOpenCountUseCase;
        this.analyticsManager = analyticsManager;
        MutableStateFlow<String> MutableStateFlow = StateFlowKt.MutableStateFlow("");
        this._searchQuery = MutableStateFlow;
        MutableStateFlow<ListSortOrder> MutableStateFlow2 = StateFlowKt.MutableStateFlow(ListSortOrder.BY_TIME_DESC);
        this._sortOrder = MutableStateFlow2;
        Flow flowMutableStateFlow = StateFlowKt.MutableStateFlow(SetsKt.emptySet());
        this._selectedIds = flowMutableStateFlow;
        MutableStateFlow<DateFilterRange> MutableStateFlow3 = StateFlowKt.MutableStateFlow(new DateFilterRange(null, null, 3, null));
        this._dateRange = MutableStateFlow3;
        SharedFlow<SignPracticeListUiEvent> sharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._uiEvent = sharedFlowMutableSharedFlow$default;
        this.uiEvent = sharedFlowMutableSharedFlow$default;
        Flow<List<SignPractice>> flowInvoke = getAllFilteredSignPracticesUseCase.invoke((Flow) MutableStateFlow, (Flow) MutableStateFlow2, (Flow) MutableStateFlow3);
        this.filteredPractices = flowInvoke;
        this.uiState = FlowKt.stateIn(FlowKt.catch(FlowKt.flowCombine(FlowKt.flowCombine(FlowKt.flowCombine(FlowKt.flowCombine(flowInvoke, (Flow) MutableStateFlow, new SignPracticeListViewModel$uiState$1(null)), (Flow) MutableStateFlow2, new SignPracticeListViewModel$uiState$2(null)), (Flow) MutableStateFlow3, new SignPracticeListViewModel$uiState$3(null)), flowMutableStateFlow, new SignPracticeListViewModel$uiState$4(null)), new SignPracticeListViewModel$uiState$5(this, null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object) null), new SignPracticeListUiState(null, false, false, null, null, null, null, 127, null));
    }

    public final SharedFlow<SignPracticeListUiEvent> getUiEvent() {
        return this.uiEvent;
    }

    public final StateFlow<SignPracticeListUiState> getUiState() {
        return this.uiState;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeListViewModel$deleteSignPractices$1, reason: invalid class name */
    /* JADX INFO: compiled from: SignPracticeListViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeListViewModel$deleteSignPractices$1", f = "SignPracticeListViewModel.kt", i = {0}, l = {108}, m = "invokeSuspend", n = {"practicesToDelete"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SignPracticeListViewModel.this.new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    List<SignPractice> signPractices = ((SignPracticeListUiState) SignPracticeListViewModel.this.getUiState().getValue()).getSignPractices();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : signPractices) {
                        if (((SignPractice) obj2).isSelected()) {
                            arrayList.add(obj2);
                        }
                    }
                    ArrayList arrayList2 = arrayList;
                    if (arrayList2.isEmpty()) {
                        return Unit.INSTANCE;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(arrayList2);
                    this.label = 1;
                    if (SignPracticeListViewModel.this.deleteSignPracticeUseCase.invoke(arrayList2, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                SignPracticeListViewModel.this.clearSelectedIds();
            } catch (Exception e) {
                Log.e(SignPracticeListViewModel.TAG, "Failed to delete sign practices", e);
                BuildersKt.launch$default(ViewModelKt.getViewModelScope(SignPracticeListViewModel.this), (CoroutineContext) null, (CoroutineStart) null, new C00501(SignPracticeListViewModel.this, null), 3, (Object) null);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeListViewModel$deleteSignPractices$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SignPracticeListViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeListViewModel$deleteSignPractices$1$1", f = "SignPracticeListViewModel.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
        static final class C00501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ SignPracticeListViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00501(SignPracticeListViewModel signPracticeListViewModel, Continuation<? super C00501> continuation) {
                super(2, continuation);
                this.this$0 = signPracticeListViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00501(this.this$0, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.this$0._uiEvent.emit(new SignPracticeListUiEvent.ErrorMessage(R.string.sign_practice_delete_error), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
    }

    public final void deleteSignPractices() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
    }

    public final void clearSelectedIds() {
        Object value;
        MutableStateFlow<Set<Integer>> mutableStateFlow = this._selectedIds;
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

    public final void updateSelectedIds(int id) {
        Object value;
        Set setPlus;
        MutableStateFlow<Set<Integer>> mutableStateFlow = this._selectedIds;
        do {
            value = mutableStateFlow.getValue();
            Set set = (Set) value;
            if (set.contains(Integer.valueOf(id))) {
                setPlus = SetsKt.minus(set, Integer.valueOf(id));
            } else {
                setPlus = SetsKt.plus(set, Integer.valueOf(id));
            }
        } while (!mutableStateFlow.compareAndSet(value, setPlus));
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeListViewModel$incrementSignPracticeOpenCount$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SignPracticeListViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeListViewModel$incrementSignPracticeOpenCount$1", f = "SignPracticeListViewModel.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {})
    static final class C03071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SignPractice $signPractice;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03071(SignPractice signPractice, Continuation<? super C03071> continuation) {
            super(2, continuation);
            this.$signPractice = signPractice;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SignPracticeListViewModel.this.new C03071(this.$signPractice, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (SignPracticeListViewModel.this.incrementSignPracticeOpenCountUseCase.invoke(this.$signPractice, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void incrementSignPracticeOpenCount(SignPractice signPractice) {
        Intrinsics.checkNotNullParameter(signPractice, "signPractice");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C03071(signPractice, null), 3, (Object) null);
    }
}
