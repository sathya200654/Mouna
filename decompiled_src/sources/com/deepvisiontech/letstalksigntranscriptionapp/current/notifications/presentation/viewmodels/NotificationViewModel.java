package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.navigation.SavedStateHandleKt;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.media.MediaPlayerManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.media.MediaPlayerState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.usecase.GetNotificationFlowUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.usecase.SubmitNotificationActionUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.usecase.SubmitNotificationListActionUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.navigation.NotificationRoute;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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

/* JADX INFO: compiled from: NotificationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0001?B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020+J\u0006\u0010/\u001a\u00020+J\u0016\u00100\u001a\u00020+2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0011J\u000e\u00104\u001a\u00020+2\u0006\u00105\u001a\u000206J1\u00107\u001a\u00020+2\"\u00108\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0;0:\u0012\u0006\u0012\u0004\u0018\u00010<09H\u0002¢\u0006\u0002\u0010=J\b\u0010>\u001a\u00020+H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010#\u001a\u0004\u0018\u00010$8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u001f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"¨\u0006@"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationViewModel;", "Landroidx/lifecycle/ViewModel;", "getNotificationFlowUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/usecase/GetNotificationFlowUseCase;", "submitNotificationActionUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/usecase/SubmitNotificationActionUseCase;", "submitNotificationListActionUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/usecase/SubmitNotificationListActionUseCase;", "mediaPlayerManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerManager;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/usecase/GetNotificationFlowUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/usecase/SubmitNotificationActionUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/usecase/SubmitNotificationListActionUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerManager;Landroidx/lifecycle/SavedStateHandle;)V", "_navigationArgs", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/navigation/NotificationRoute$NotificationScreen;", "_notificationId", "", "_userSelections", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationUserSelections;", "_isSubmitting", "", "_uiEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationScreenEventState;", "uiEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getUiEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "mediaPlayerState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerState;", "getMediaPlayerState", "()Lkotlinx/coroutines/flow/StateFlow;", "player", "Landroidx/media3/common/Player;", "getPlayer", "()Landroidx/media3/common/Player;", "uiState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationScreenUiState;", "getUiState", "setMediaItem", "", "mediaItem", "Landroidx/media3/common/MediaItem;", "play", "pause", "updateSelectedOptions", "pageId", "", "option", "onAction", "action", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationScreenUiAction;", "handleSubmission", "apiCall", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "(Lkotlin/jvm/functions/Function1;)V", "onCleared", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NotificationViewModel extends ViewModel {
    private static final String TAG = "NotificationViewModel";
    private final MutableStateFlow<Boolean> _isSubmitting;
    private final NotificationRoute.NotificationScreen _navigationArgs;
    private final String _notificationId;
    private final MutableSharedFlow<NotificationScreenEventState> _uiEvent;
    private final MutableStateFlow<NotificationUserSelections> _userSelections;
    private final GetNotificationFlowUseCase getNotificationFlowUseCase;
    private final MediaPlayerManager mediaPlayerManager;
    private final StateFlow<MediaPlayerState> mediaPlayerState;
    private final SubmitNotificationActionUseCase submitNotificationActionUseCase;
    private final SubmitNotificationListActionUseCase submitNotificationListActionUseCase;
    private final SharedFlow<NotificationScreenEventState> uiEvent;
    private final StateFlow<NotificationScreenUiState> uiState;
    public static final int $stable = 8;

    @Inject
    public NotificationViewModel(GetNotificationFlowUseCase getNotificationFlowUseCase, SubmitNotificationActionUseCase submitNotificationActionUseCase, SubmitNotificationListActionUseCase submitNotificationListActionUseCase, MediaPlayerManager mediaPlayerManager, SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(getNotificationFlowUseCase, "getNotificationFlowUseCase");
        Intrinsics.checkNotNullParameter(submitNotificationActionUseCase, "submitNotificationActionUseCase");
        Intrinsics.checkNotNullParameter(submitNotificationListActionUseCase, "submitNotificationListActionUseCase");
        Intrinsics.checkNotNullParameter(mediaPlayerManager, "mediaPlayerManager");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.getNotificationFlowUseCase = getNotificationFlowUseCase;
        this.submitNotificationActionUseCase = submitNotificationActionUseCase;
        this.submitNotificationListActionUseCase = submitNotificationListActionUseCase;
        this.mediaPlayerManager = mediaPlayerManager;
        NotificationRoute.NotificationScreen notificationScreen = (NotificationRoute.NotificationScreen) SavedStateHandleKt.toRoute(savedStateHandle, Reflection.getOrCreateKotlinClass(NotificationRoute.NotificationScreen.class), MapsKt.emptyMap());
        this._navigationArgs = notificationScreen;
        this._notificationId = notificationScreen.getNotificationId();
        Flow flowMutableStateFlow = StateFlowKt.MutableStateFlow(new NotificationUserSelections(null, 1, null));
        this._userSelections = flowMutableStateFlow;
        Flow flowMutableStateFlow2 = StateFlowKt.MutableStateFlow(false);
        this._isSubmitting = flowMutableStateFlow2;
        MutableSharedFlow<NotificationScreenEventState> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._uiEvent = mutableSharedFlowMutableSharedFlow$default;
        this.uiEvent = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
        this.mediaPlayerState = mediaPlayerManager.getMediaPlayerState();
        this.uiState = FlowKt.stateIn(FlowKt.flowCombine(FlowKt.flowCombine(FlowKt.flow(new NotificationViewModel$uiState$1(this, null)), flowMutableStateFlow, new NotificationViewModel$uiState$2(null)), flowMutableStateFlow2, new NotificationViewModel$uiState$3(null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object) null), NotificationScreenUiState.Loading.INSTANCE);
    }

    public final SharedFlow<NotificationScreenEventState> getUiEvent() {
        return this.uiEvent;
    }

    public final StateFlow<MediaPlayerState> getMediaPlayerState() {
        return this.mediaPlayerState;
    }

    public final Player getPlayer() {
        return this.mediaPlayerManager.getPlayer();
    }

    public final StateFlow<NotificationScreenUiState> getUiState() {
        return this.uiState;
    }

    public final void setMediaItem(MediaItem mediaItem) {
        Intrinsics.checkNotNullParameter(mediaItem, "mediaItem");
        this.mediaPlayerManager.setMediaItem(mediaItem);
    }

    public final void play() {
        this.mediaPlayerManager.play();
    }

    public final void pause() {
        this.mediaPlayerManager.pause();
    }

    public final void updateSelectedOptions(long pageId, String option) {
        Object value;
        Intrinsics.checkNotNullParameter(option, "option");
        if (((Boolean) this._isSubmitting.getValue()).booleanValue()) {
            return;
        }
        MutableStateFlow<NotificationUserSelections> mutableStateFlow = this._userSelections;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ((NotificationUserSelections) value).toggleOption(pageId, option)));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final void onAction(NotificationScreenUiAction action) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter(action, "action");
        if (((Boolean) this._isSubmitting.getValue()).booleanValue()) {
            return;
        }
        String str = this._notificationId;
        if (action instanceof NotificationScreenUiAction.OnNotificationActionClick) {
            handleSubmission(new C02911(str, action, null));
            return;
        }
        if (!(action instanceof NotificationScreenUiAction.OnNotificationSubmitListActionClick)) {
            throw new NoWhenBranchMatchedException();
        }
        List<String> listForSubmission = ((NotificationUserSelections) this._userSelections.getValue()).getListForSubmission(((NotificationScreenUiAction.OnNotificationSubmitListActionClick) action).getPageId());
        if (listForSubmission.isEmpty()) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(null), 3, (Object) null);
        } else {
            handleSubmission(new AnonymousClass3(str, action, listForSubmission, null));
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationViewModel$onAction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NotificationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationViewModel$onAction$1", f = "NotificationViewModel.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
    static final class C02911 extends SuspendLambda implements Function1<Continuation<? super ResponseResource<? extends Unit>>, Object> {
        final /* synthetic */ NotificationScreenUiAction $action;
        final /* synthetic */ String $notificationId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02911(String str, NotificationScreenUiAction notificationScreenUiAction, Continuation<? super C02911> continuation) {
            super(1, continuation);
            this.$notificationId = str;
            this.$action = notificationScreenUiAction;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return NotificationViewModel.this.new C02911(this.$notificationId, this.$action, continuation);
        }

        public final Object invoke(Continuation<? super ResponseResource<Unit>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objInvoke = NotificationViewModel.this.submitNotificationActionUseCase.invoke(this.$notificationId, ((NotificationScreenUiAction.OnNotificationActionClick) this.$action).getPageId(), ((NotificationScreenUiAction.OnNotificationActionClick) this.$action).getAction(), (Continuation) this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationViewModel$onAction$2, reason: invalid class name */
    /* JADX INFO: compiled from: NotificationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationViewModel$onAction$2", f = "NotificationViewModel.kt", i = {}, l = {159}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NotificationViewModel.this.new AnonymousClass2(continuation);
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
                if (NotificationViewModel.this._uiEvent.emit(new NotificationScreenEventState.ErrorEvent(R.string.notification_empty_selection_error), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationViewModel$onAction$3, reason: invalid class name */
    /* JADX INFO: compiled from: NotificationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationViewModel$onAction$3", f = "NotificationViewModel.kt", i = {}, l = {164}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super ResponseResource<? extends Unit>>, Object> {
        final /* synthetic */ NotificationScreenUiAction $action;
        final /* synthetic */ String $notificationId;
        final /* synthetic */ List<String> $selectedList;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(String str, NotificationScreenUiAction notificationScreenUiAction, List<String> list, Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
            this.$notificationId = str;
            this.$action = notificationScreenUiAction;
            this.$selectedList = list;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return NotificationViewModel.this.new AnonymousClass3(this.$notificationId, this.$action, this.$selectedList, continuation);
        }

        public final Object invoke(Continuation<? super ResponseResource<Unit>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        public final Object invokeSuspend(Object obj) throws NoWhenBranchMatchedException {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objInvoke = NotificationViewModel.this.submitNotificationListActionUseCase.invoke(this.$notificationId, ((NotificationScreenUiAction.OnNotificationSubmitListActionClick) this.$action).getPageId(), this.$selectedList, (Continuation) this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationViewModel$handleSubmission$1, reason: invalid class name */
    /* JADX INFO: compiled from: NotificationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationViewModel$handleSubmission$1", f = "NotificationViewModel.kt", i = {1}, l = {177, 182}, m = "invokeSuspend", n = {"response"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super ResponseResource<Unit>>, Object> $apiCall;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function1<? super Continuation<? super ResponseResource<Unit>>, ? extends Object> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$apiCall = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NotificationViewModel.this.new AnonymousClass1(this.$apiCall, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0078, code lost:
        
            if (r5.this$0._uiEvent.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationScreenEventState.ErrorEvent(com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.mappers.AppErrorMapperKt.toNotificationErrorMessageRes(((com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r6).getError())), (kotlin.coroutines.Continuation) r5) == r0) goto L20;
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
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r0 = r5.L$0
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r0 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r0
                kotlin.ResultKt.throwOnFailure(r6)
                goto L83
            L16:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1e:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L3d
            L22:
                kotlin.ResultKt.throwOnFailure(r6)
                com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationViewModel r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationViewModel.this
                kotlinx.coroutines.flow.MutableStateFlow r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationViewModel.access$get_isSubmitting$p(r6)
                java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
                r6.setValue(r1)
                kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource<kotlin.Unit>>, java.lang.Object> r6 = r5.$apiCall
                r5.label = r3
                java.lang.Object r6 = r6.invoke(r5)
                if (r6 != r0) goto L3d
                goto L7a
            L3d:
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r6 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r6
                boolean r1 = r6 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Success
                if (r1 == 0) goto L4f
                java.lang.String r6 = "NotificationViewModel"
                java.lang.String r0 = "Submission successful"
                int r6 = android.util.Log.d(r6, r0)
                kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
                goto L83
            L4f:
                boolean r1 = r6 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error
                if (r1 == 0) goto L7b
                com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationViewModel r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationViewModel.this
                kotlinx.coroutines.flow.MutableSharedFlow r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationViewModel.access$get_uiEvent$p(r1)
                com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationScreenEventState$ErrorEvent r3 = new com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationScreenEventState$ErrorEvent
                r4 = r6
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Error r4 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r4
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError r4 = r4.getError()
                int r4 = com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.mappers.AppErrorMapperKt.toNotificationErrorMessageRes(r4)
                r3.<init>(r4)
                r4 = r5
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
                r5.L$0 = r6
                r5.label = r2
                java.lang.Object r6 = r1.emit(r3, r4)
                if (r6 != r0) goto L83
            L7a:
                return r0
            L7b:
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Loading r0 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Loading.INSTANCE
                boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r0)
                if (r6 == 0) goto L94
            L83:
                com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationViewModel r5 = com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationViewModel.this
                kotlinx.coroutines.flow.MutableStateFlow r5 = com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationViewModel.access$get_isSubmitting$p(r5)
                r6 = 0
                java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
                r5.setValue(r6)
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            L94:
                kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
                r5.<init>()
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final void handleSubmission(Function1<? super Continuation<? super ResponseResource<Unit>>, ? extends Object> apiCall) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(apiCall, null), 3, (Object) null);
    }

    protected void onCleared() {
        super.onCleared();
        this.mediaPlayerManager.stop();
    }
}
