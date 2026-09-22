package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.model.Persona;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.model.Role;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.usecase.SubmitPersonaDataUseCase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: OnBoardingViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010!\u001a\u00020\u0019J\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/presentation/viewmodels/OnBoardingViewModel;", "Landroidx/lifecycle/ViewModel;", "personaSurveyRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/repository/PersonaSurveyRepository;", "submitPersonaDataUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/usecase/SubmitPersonaDataUseCase;", "engagementRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/domain/repository/EngagementRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/repository/PersonaSurveyRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/usecase/SubmitPersonaDataUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/domain/repository/EngagementRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/presentation/viewmodels/OnBoardingUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "_uiEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/presentation/viewmodels/OnBoardingUiEvent;", "uiEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getUiEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "onProceed", "", "onPersonaSelected", "personaId", "", "pageIndex", "", "onRoleToggled", "roleId", "onSkip", "onSubmit", "persona", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/model/Persona;", "onOk", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OnBoardingViewModel extends ViewModel {
    private static final int MAX_ROLES_ALLOWED = 2;
    private final MutableSharedFlow<OnBoardingUiEvent> _uiEvent;
    private final MutableStateFlow<OnBoardingUiState> _uiState;
    private final EngagementRepository engagementRepository;
    private final PersonaSurveyRepository personaSurveyRepository;
    private final SubmitPersonaDataUseCase submitPersonaDataUseCase;
    private final SharedFlow<OnBoardingUiEvent> uiEvent;
    private final StateFlow<OnBoardingUiState> uiState;
    public static final int $stable = 8;

    @Inject
    public OnBoardingViewModel(PersonaSurveyRepository personaSurveyRepository, SubmitPersonaDataUseCase submitPersonaDataUseCase, EngagementRepository engagementRepository) {
        Intrinsics.checkNotNullParameter(personaSurveyRepository, "personaSurveyRepository");
        Intrinsics.checkNotNullParameter(submitPersonaDataUseCase, "submitPersonaDataUseCase");
        Intrinsics.checkNotNullParameter(engagementRepository, "engagementRepository");
        this.personaSurveyRepository = personaSurveyRepository;
        this.submitPersonaDataUseCase = submitPersonaDataUseCase;
        this.engagementRepository = engagementRepository;
        MutableStateFlow<OnBoardingUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(new OnBoardingUiState(null, null, 3, null));
        this._uiState = MutableStateFlow;
        this.uiState = FlowKt.asStateFlow(MutableStateFlow);
        SharedFlow<OnBoardingUiEvent> sharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._uiEvent = sharedFlowMutableSharedFlow$default;
        this.uiEvent = sharedFlowMutableSharedFlow$default;
    }

    public final StateFlow<OnBoardingUiState> getUiState() {
        return this.uiState;
    }

    public final SharedFlow<OnBoardingUiEvent> getUiEvent() {
        return this.uiEvent;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingViewModel$onProceed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OnBoardingViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingViewModel$onProceed$1", f = "OnBoardingViewModel.kt", i = {1}, l = {54, 56}, m = "invokeSuspend", n = {"response"}, s = {"L$0"})
    static final class C02981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C02981(Continuation<? super C02981> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OnBoardingViewModel.this.new C02981(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0063, code lost:
        
            if (r5.this$0._uiEvent.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingUiEvent(com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.mappers.ErrorMapperKt.toOnboardingErrorMessageRes(((com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r6).getError())), (kotlin.coroutines.Continuation) r5) == r0) goto L17;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws kotlin.NoWhenBranchMatchedException {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 1
                r3 = 2
                if (r1 == 0) goto L23
                if (r1 == r2) goto L1f
                if (r1 != r3) goto L17
                java.lang.Object r5 = r5.L$0
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r5 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r5
                kotlin.ResultKt.throwOnFailure(r6)
                goto L9e
            L17:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1f:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L38
            L23:
                kotlin.ResultKt.throwOnFailure(r6)
                com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingViewModel r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingViewModel.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingViewModel.access$getPersonaSurveyRepository$p(r6)
                r1 = r5
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r5.label = r2
                java.lang.Object r6 = r6.getSurveyData(r1)
                if (r6 != r0) goto L38
                goto L65
            L38:
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r6 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r6
                boolean r1 = r6 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error
                if (r1 == 0) goto L66
                com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingViewModel r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingViewModel.this
                kotlinx.coroutines.flow.MutableSharedFlow r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingViewModel.access$get_uiEvent$p(r1)
                com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingUiEvent r2 = new com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingUiEvent
                r4 = r6
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Error r4 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r4
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError r4 = r4.getError()
                int r4 = com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.mappers.ErrorMapperKt.toOnboardingErrorMessageRes(r4)
                r2.<init>(r4)
                r4 = r5
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
                r5.L$0 = r6
                r5.label = r3
                java.lang.Object r5 = r1.emit(r2, r4)
                if (r5 != r0) goto L9e
            L65:
                return r0
            L66:
                boolean r0 = r6 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Loading
                if (r0 != 0) goto L9e
                boolean r0 = r6 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Success
                if (r0 == 0) goto L98
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Success r6 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Success) r6
                java.lang.Object r6 = r6.getData()
                java.util.List r6 = (java.util.List) r6
                com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingViewModel r5 = com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingViewModel.this
                kotlinx.coroutines.flow.MutableStateFlow r5 = com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingViewModel.access$get_uiState$p(r5)
            L7c:
                java.lang.Object r0 = r5.getValue()
                r1 = r0
                com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingUiState r1 = (com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingUiState) r1
                com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingPages$PersonaPage r2 = new com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingPages$PersonaPage
                r2.<init>(r6)
                java.util.List r2 = kotlin.collections.CollectionsKt.listOf(r2)
                r4 = 0
                com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingUiState r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingUiState.copy$default(r1, r2, r4, r3, r4)
                boolean r0 = r5.compareAndSet(r0, r1)
                if (r0 == 0) goto L7c
                goto L9e
            L98:
                kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
                r5.<init>()
                throw r5
            L9e:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingViewModel.C02981.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void onProceed() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C02981(null), 3, (Object) null);
    }

    public final void onPersonaSelected(String personaId, int pageIndex) {
        Object value;
        OnBoardingUiState onBoardingUiStateCopy$default;
        Object next;
        Intrinsics.checkNotNullParameter(personaId, "personaId");
        MutableStateFlow<OnBoardingUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
            onBoardingUiStateCopy$default = (OnBoardingUiState) value;
            Object orNull = CollectionsKt.getOrNull(onBoardingUiStateCopy$default.getPages(), pageIndex);
            OnBoardingPages.PersonaPage personaPage = orNull instanceof OnBoardingPages.PersonaPage ? (OnBoardingPages.PersonaPage) orNull : null;
            if (personaPage != null) {
                List<Persona> personas = personaPage.getPersonas();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(personas, 10));
                for (Persona persona : personas) {
                    arrayList.add(Persona.copy$default(persona, null, null, null, Intrinsics.areEqual(persona.getId(), personaId), 7, null));
                }
                ArrayList arrayList2 = arrayList;
                Iterator it = arrayList2.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!((Persona) next).isSelected());
                Persona persona2 = (Persona) next;
                if (persona2 != null) {
                    OnBoardingPages.PersonaPage personaPage2 = new OnBoardingPages.PersonaPage(arrayList2);
                    List mutableList = CollectionsKt.toMutableList(CollectionsKt.take(onBoardingUiStateCopy$default.getPages(), pageIndex));
                    mutableList.add(personaPage2);
                    mutableList.add(new OnBoardingPages.RolePage(persona2, 0));
                    onBoardingUiStateCopy$default = OnBoardingUiState.copy$default(onBoardingUiStateCopy$default, mutableList, null, 2, null);
                }
            }
        } while (!mutableStateFlow.compareAndSet(value, onBoardingUiStateCopy$default));
    }

    public final void onRoleToggled(String roleId, String personaId) {
        Object value;
        OnBoardingUiState onBoardingUiState;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(roleId, "roleId");
        Intrinsics.checkNotNullParameter(personaId, "personaId");
        MutableStateFlow<OnBoardingUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
            onBoardingUiState = (OnBoardingUiState) value;
            List<OnBoardingPages> pages = onBoardingUiState.getPages();
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(pages, 10));
            Iterator<T> it = pages.iterator();
            while (true) {
                Object obj = null;
                if (!it.hasNext()) {
                    break;
                }
                OnBoardingPages.RolePage rolePageCopy = (OnBoardingPages) it.next();
                if (rolePageCopy instanceof OnBoardingPages.RolePage) {
                    OnBoardingPages.RolePage rolePage = (OnBoardingPages.RolePage) rolePageCopy;
                    if (Intrinsics.areEqual(rolePage.getPersona().getId(), personaId)) {
                        for (Object obj2 : rolePage.getPersona().getRoles()) {
                            if (Intrinsics.areEqual(((Role) obj2).getId(), roleId)) {
                                obj = obj2;
                                break;
                            }
                        }
                        Role role = (Role) obj;
                        if (role != null) {
                            List<Role> roles = rolePage.getPersona().getRoles();
                            int i = 0;
                            if (!(roles instanceof Collection) || !roles.isEmpty()) {
                                Iterator<T> it2 = roles.iterator();
                                while (it2.hasNext()) {
                                    if (((Role) it2.next()).isSelected() && (i = i + 1) < 0) {
                                        CollectionsKt.throwCountOverflow();
                                    }
                                }
                            }
                            int i2 = i + (role.isSelected() ? -1 : 1);
                            if (i2 <= 2) {
                                List<Role> roles2 = rolePage.getPersona().getRoles();
                                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(roles2, 10));
                                for (Role roleCopy$default : roles2) {
                                    if (Intrinsics.areEqual(roleCopy$default.getId(), roleId)) {
                                        roleCopy$default = Role.copy$default(roleCopy$default, null, null, !roleCopy$default.isSelected(), 3, null);
                                    }
                                    arrayList2.add(roleCopy$default);
                                }
                                rolePageCopy = rolePage.copy(Persona.copy$default(rolePage.getPersona(), null, null, arrayList2, false, 11, null), i2);
                            }
                        }
                    }
                }
                arrayList.add(rolePageCopy);
            }
        } while (!mutableStateFlow.compareAndSet(value, OnBoardingUiState.copy$default(onBoardingUiState, arrayList, null, 2, null)));
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingViewModel$onSkip$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OnBoardingViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingViewModel$onSkip$1", f = "OnBoardingViewModel.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
    static final class C02991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C02991(Continuation<? super C02991> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OnBoardingViewModel.this.new C02991(continuation);
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
                if (OnBoardingViewModel.this.engagementRepository.setOnboardingShownState(true, (Continuation) this) == coroutine_suspended) {
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

    public final void onSkip() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C02991(null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingViewModel$onSubmit$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OnBoardingViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingViewModel$onSubmit$1", f = "OnBoardingViewModel.kt", i = {0, 1, 1}, l = {138, 144}, m = "invokeSuspend", n = {"selectedRoles", "selectedRoles", "response"}, s = {"L$0", "L$0", "L$1"})
    static final class C03001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Persona $persona;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ OnBoardingViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03001(Persona persona, OnBoardingViewModel onBoardingViewModel, Continuation<? super C03001> continuation) {
            super(2, continuation);
            this.$persona = persona;
            this.this$0 = onBoardingViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03001(this.$persona, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x00ac, code lost:
        
            if (r8.this$0._uiEvent.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingUiEvent(com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.mappers.ErrorMapperKt.toOnboardingErrorMessageRes(((com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r9).getError())), (kotlin.coroutines.Continuation) r8) == r0) goto L23;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws kotlin.NoWhenBranchMatchedException {
            /*
                Method dump skipped, instruction units count: 256
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingViewModel.C03001.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void onSubmit(Persona persona) {
        Intrinsics.checkNotNullParameter(persona, "persona");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C03001(persona, this, null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingViewModel$onOk$1, reason: invalid class name */
    /* JADX INFO: compiled from: OnBoardingViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingViewModel$onOk$1", f = "OnBoardingViewModel.kt", i = {}, l = {167}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OnBoardingViewModel.this.new AnonymousClass1(continuation);
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
                if (OnBoardingViewModel.this.engagementRepository.setOnboardingShownState(true, (Continuation) this) == coroutine_suspended) {
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

    public final void onOk() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
    }
}
