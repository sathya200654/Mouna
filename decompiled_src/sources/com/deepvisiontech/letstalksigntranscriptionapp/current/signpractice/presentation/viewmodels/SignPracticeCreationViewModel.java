package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeComplexity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeDomain;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeType;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeWordCount;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.repository.SignPracticeRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.InsertSignPracticeAndGetIdUseCase;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
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

/* JADX INFO: compiled from: SignPracticeCreationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 82\u00020\u0001:\u00018B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\rJ\u000e\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020\u0010J\u000e\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020\rJ\u000e\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020\rJ\u000e\u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020\u0014J\u000e\u00101\u001a\u00020'2\u0006\u00102\u001a\u00020\u0012J\u000e\u00103\u001a\u00020'2\u0006\u00104\u001a\u00020\u0016J\u000e\u00105\u001a\u00020\nH\u0082@¢\u0006\u0002\u00106J\u0006\u00107\u001a\u00020'R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00069"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeCreationViewModel;", "Landroidx/lifecycle/ViewModel;", "insertSignPracticeAndGetIdUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/usecase/InsertSignPracticeAndGetIdUseCase;", "signPracticeRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/repository/SignPracticeRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/usecase/InsertSignPracticeAndGetIdUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/repository/SignPracticeRepository;)V", "_isLoading", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_isGenerating", "_practiceName", "", "_practiceTopic", "_practiceComplexity", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeComplexity;", "_language", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "_wordCount", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeWordCount;", "_type", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeType;", "_domains", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeDomain;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeCreationUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "_uiEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeCreationUiEvent;", "uiEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getUiEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "onPracticeNameChange", "", "newName", "onPracticeComplexityChange", "complexity", "onPracticeTopicChange", "topic", "selectDomain", "id", "selectWordCount", "signPracticeWordCount", "selectLanguage", "language", "selectType", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "validateGenerationData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateSignPractice", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SignPracticeCreationViewModel extends ViewModel {

    @Deprecated
    public static final int PRACTICE_NAME_MAX_CHAR_LIMIT = 30;

    @Deprecated
    public static final int PRACTICE_NAME_MIN_CHAR_LIMIT = 3;
    private static final String TAG = "SignPracticeCreationViewModel";

    @Deprecated
    public static final int TOPIC_MAX_CHAR_LIMIT = 85;

    @Deprecated
    public static final int TOPIC_MIN_CHAR_LIMIT = 3;
    private final MutableStateFlow<List<SignPracticeDomain>> _domains;
    private final MutableStateFlow<Boolean> _isGenerating;
    private final MutableStateFlow<Boolean> _isLoading;
    private final MutableStateFlow<LanguageEnum> _language;
    private final MutableStateFlow<SignPracticeComplexity> _practiceComplexity;
    private final MutableStateFlow<String> _practiceName;
    private final MutableStateFlow<String> _practiceTopic;
    private final MutableStateFlow<SignPracticeType> _type;
    private final MutableSharedFlow<SignPracticeCreationUiEvent> _uiEvent;
    private final MutableStateFlow<SignPracticeWordCount> _wordCount;
    private final InsertSignPracticeAndGetIdUseCase insertSignPracticeAndGetIdUseCase;
    private final SignPracticeRepository signPracticeRepository;
    private final SharedFlow<SignPracticeCreationUiEvent> uiEvent;
    private final StateFlow<SignPracticeCreationUiState> uiState;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel$validateGenerationData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SignPracticeCreationViewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel", f = "SignPracticeCreationViewModel.kt", i = {0, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4}, l = {162, 168, 172, 183, 187}, m = "validateGenerationData", n = {"selectedDomain", "selectedDomain", "practiceName", "selectedDomain", "practiceName", "selectedDomain", "practiceName", "topic", "selectedDomain", "practiceName", "topic"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    static final class C03061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C03061(Continuation<? super C03061> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SignPracticeCreationViewModel.this.validateGenerationData((Continuation) this);
        }
    }

    @Inject
    public SignPracticeCreationViewModel(InsertSignPracticeAndGetIdUseCase insertSignPracticeAndGetIdUseCase, SignPracticeRepository signPracticeRepository) {
        Intrinsics.checkNotNullParameter(insertSignPracticeAndGetIdUseCase, "insertSignPracticeAndGetIdUseCase");
        Intrinsics.checkNotNullParameter(signPracticeRepository, "signPracticeRepository");
        this.insertSignPracticeAndGetIdUseCase = insertSignPracticeAndGetIdUseCase;
        this.signPracticeRepository = signPracticeRepository;
        Flow flowMutableStateFlow = StateFlowKt.MutableStateFlow(true);
        this._isLoading = flowMutableStateFlow;
        Flow flowMutableStateFlow2 = StateFlowKt.MutableStateFlow(false);
        this._isGenerating = flowMutableStateFlow2;
        Flow flowMutableStateFlow3 = StateFlowKt.MutableStateFlow("");
        this._practiceName = flowMutableStateFlow3;
        Flow flowMutableStateFlow4 = StateFlowKt.MutableStateFlow("");
        this._practiceTopic = flowMutableStateFlow4;
        Flow flowMutableStateFlow5 = StateFlowKt.MutableStateFlow(SignPracticeComplexity.MEDIUM);
        this._practiceComplexity = flowMutableStateFlow5;
        Flow flowMutableStateFlow6 = StateFlowKt.MutableStateFlow(LanguageEnum.ENGLISH);
        this._language = flowMutableStateFlow6;
        Flow flowMutableStateFlow7 = StateFlowKt.MutableStateFlow(SignPracticeWordCount.MEDIUM);
        this._wordCount = flowMutableStateFlow7;
        Flow flowMutableStateFlow8 = StateFlowKt.MutableStateFlow(SignPracticeType.FORMAL);
        this._type = flowMutableStateFlow8;
        Flow flowMutableStateFlow9 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._domains = flowMutableStateFlow9;
        Flow flowCatch = FlowKt.catch(FlowKt.flowCombine(FlowKt.flowCombine(FlowKt.flowCombine(FlowKt.flowCombine(FlowKt.flowCombine(FlowKt.flowCombine(FlowKt.flowCombine(FlowKt.flowCombine(flowMutableStateFlow, flowMutableStateFlow2, new SignPracticeCreationViewModel$uiState$1(null)), flowMutableStateFlow3, new SignPracticeCreationViewModel$uiState$2(null)), flowMutableStateFlow7, new SignPracticeCreationViewModel$uiState$3(null)), flowMutableStateFlow4, new SignPracticeCreationViewModel$uiState$4(null)), flowMutableStateFlow8, new SignPracticeCreationViewModel$uiState$5(null)), flowMutableStateFlow5, new SignPracticeCreationViewModel$uiState$6(null)), flowMutableStateFlow6, new SignPracticeCreationViewModel$uiState$7(null)), flowMutableStateFlow9, new SignPracticeCreationViewModel$uiState$8(null)), new SignPracticeCreationViewModel$uiState$9(this, null));
        SignPracticeCreationViewModel signPracticeCreationViewModel = this;
        this.uiState = FlowKt.stateIn(flowCatch, ViewModelKt.getViewModelScope(signPracticeCreationViewModel), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object) null), new SignPracticeCreationUiState(false, false, null, null, null, null, null, null, null, 511, null));
        SharedFlow<SignPracticeCreationUiEvent> sharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._uiEvent = sharedFlowMutableSharedFlow$default;
        this.uiEvent = sharedFlowMutableSharedFlow$default;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(signPracticeCreationViewModel), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
    }

    public final StateFlow<SignPracticeCreationUiState> getUiState() {
        return this.uiState;
    }

    public final SharedFlow<SignPracticeCreationUiEvent> getUiEvent() {
        return this.uiEvent;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: SignPracticeCreationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel$1", f = "SignPracticeCreationViewModel.kt", i = {1}, l = {108, 110}, m = "invokeSuspend", n = {"response"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SignPracticeCreationViewModel.this.new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0064, code lost:
        
            if (r6.this$0._uiEvent.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationUiEvent.ErrorMessage(com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.mappers.AppErrorMapperKt.toSignPracticeErrorMessageRes(((com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r7).getError()), null, 2, null), (kotlin.coroutines.Continuation) r6) == r0) goto L17;
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
                r2 = 1
                r3 = 2
                if (r1 == 0) goto L23
                if (r1 == r2) goto L1f
                if (r1 != r3) goto L17
                java.lang.Object r6 = r6.L$0
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r6 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r6
                kotlin.ResultKt.throwOnFailure(r7)
                goto L97
            L17:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1f:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L38
            L23:
                kotlin.ResultKt.throwOnFailure(r7)
                com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.repository.SignPracticeRepository r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel.access$getSignPracticeRepository$p(r7)
                r1 = r6
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r6.label = r2
                java.lang.Object r7 = r7.getSignPracticeDomains(r1)
                if (r7 != r0) goto L38
                goto L66
            L38:
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r7 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r7
                boolean r1 = r7 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error
                if (r1 == 0) goto L67
                com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel.this
                kotlinx.coroutines.flow.MutableSharedFlow r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel.access$get_uiEvent$p(r1)
                com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationUiEvent$ErrorMessage r2 = new com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationUiEvent$ErrorMessage
                r4 = r7
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Error r4 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r4
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError r4 = r4.getError()
                int r4 = com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.mappers.AppErrorMapperKt.toSignPracticeErrorMessageRes(r4)
                r5 = 0
                r2.<init>(r4, r5, r3, r5)
                r4 = r6
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                r6.L$0 = r7
                r6.label = r3
                java.lang.Object r6 = r1.emit(r2, r4)
                if (r6 != r0) goto L97
            L66:
                return r0
            L67:
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Loading r0 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Loading.INSTANCE
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r0)
                if (r0 != 0) goto L97
                boolean r0 = r7 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Success
                if (r0 == 0) goto L91
                com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel r0 = com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel.this
                kotlinx.coroutines.flow.MutableStateFlow r0 = com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel.access$get_domains$p(r0)
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Success r7 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Success) r7
                java.lang.Object r7 = r7.getData()
                r0.setValue(r7)
                com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel.this
                kotlinx.coroutines.flow.MutableStateFlow r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel.access$get_isLoading$p(r6)
                r7 = 0
                java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
                r6.setValue(r7)
                goto L97
            L91:
                kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
                r6.<init>()
                throw r6
            L97:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void onPracticeNameChange(String newName) {
        Intrinsics.checkNotNullParameter(newName, "newName");
        this._practiceName.setValue(newName);
    }

    public final void onPracticeComplexityChange(SignPracticeComplexity complexity) {
        Intrinsics.checkNotNullParameter(complexity, "complexity");
        this._practiceComplexity.setValue(complexity);
    }

    public final void onPracticeTopicChange(String topic) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        this._practiceTopic.setValue(topic);
    }

    public final void selectDomain(String id) {
        Object value;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(id, "id");
        MutableStateFlow<List<SignPracticeDomain>> mutableStateFlow = this._domains;
        do {
            value = mutableStateFlow.getValue();
            List<SignPracticeDomain> list = (List) value;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (SignPracticeDomain signPracticeDomain : list) {
                arrayList.add(SignPracticeDomain.copy$default(signPracticeDomain, null, null, Intrinsics.areEqual(signPracticeDomain.getId(), id), 3, null));
            }
        } while (!mutableStateFlow.compareAndSet(value, arrayList));
    }

    public final void selectWordCount(SignPracticeWordCount signPracticeWordCount) {
        Intrinsics.checkNotNullParameter(signPracticeWordCount, "signPracticeWordCount");
        this._wordCount.setValue(signPracticeWordCount);
    }

    public final void selectLanguage(LanguageEnum language) {
        Intrinsics.checkNotNullParameter(language, "language");
        this._language.setValue(language);
    }

    public final void selectType(SignPracticeType type) {
        Intrinsics.checkNotNullParameter(type, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        this._type.setValue(type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c3, code lost:
    
        if (r12.emit(r13, r0) == r1) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00f8, code lost:
    
        if (r12.emit(r3, r0) == r1) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0147, code lost:
    
        if (r12.emit(r3, r0) == r1) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0194, code lost:
    
        if (r12.emit(r4, r0) == r1) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01cb, code lost:
    
        if (r12.emit(r3, r0) == r1) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object validateGenerationData(kotlin.coroutines.Continuation<? super java.lang.Boolean> r13) {
        /*
            Method dump skipped, instruction units count: 467
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel.validateGenerationData(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel$generateSignPractice$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SignPracticeCreationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel$generateSignPractice$1", f = "SignPracticeCreationViewModel.kt", i = {2, 3}, l = {200, 204, 217, 224}, m = "invokeSuspend", n = {"respose", "respose"}, s = {"L$0", "L$0"})
    static final class C03051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C03051(Continuation<? super C03051> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SignPracticeCreationViewModel.this.new C03051(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        /* JADX WARN: Code duplicated, block: B:31:0x00f0  */
        /* JADX WARN: Code duplicated, block: B:34:0x0126  */
        /* JADX WARN: Code duplicated, block: B:36:0x012e  */
        /* JADX WARN: Code duplicated, block: B:38:0x0132  */
        /* JADX WARN: Code duplicated, block: B:41:0x0169  */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0123, code lost:
        
            if (r14.this$0._uiEvent.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationUiEvent.ErrorMessage(com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.mappers.AppErrorMapperKt.toSignPracticeErrorMessageRes(((com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r15).getError()), null, 2, null), (kotlin.coroutines.Continuation) r14) == r0) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0166, code lost:
        
            if (r14.this$0._uiEvent.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationUiEvent.Generated(((java.lang.Number) ((com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Success) r15).getData()).longValue()), (kotlin.coroutines.Continuation) r14) == r0) goto L40;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) throws kotlin.NoWhenBranchMatchedException {
            /*
                Method dump skipped, instruction units count: 378
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel.C03051.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void generateSignPractice() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C03051(null), 3, (Object) null);
    }

    /* JADX INFO: compiled from: SignPracticeCreationViewModel.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeCreationViewModel$Companion;", "", "<init>", "()V", "TOPIC_MIN_CHAR_LIMIT", "", "TOPIC_MAX_CHAR_LIMIT", "PRACTICE_NAME_MIN_CHAR_LIMIT", "PRACTICE_NAME_MAX_CHAR_LIMIT", "TAG", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
