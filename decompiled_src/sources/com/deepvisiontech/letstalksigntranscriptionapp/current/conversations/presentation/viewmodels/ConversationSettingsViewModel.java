package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.SettingsRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.GetAvailableVoicesForLanguageUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.LogRedirectActionUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.ResetSelectedVoiceUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.ResetUserPersonaDataUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.SaveConversationLanguageUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.SetConversationTranscriptionFontSizeUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.SetConversationUserLanguageUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.SetEnvironmentRecognitionStateUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.SetInterpretationModeUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.SetInterpretationSpeedUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.ToggleConversationSpeakerDetectionUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.texttospeech.TextToSpeechManager;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_18_4_1.FastDoubleMath;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: ConversationSettingsViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001By\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u00109\u001a\u00020:2\b\b\u0001\u0010;\u001a\u00020<H\u0002J\u0012\u0010=\u001a\u00020:2\b\b\u0001\u0010;\u001a\u00020<H\u0002J\u000e\u0010>\u001a\u00020:2\u0006\u0010?\u001a\u00020@R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020%0'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R \u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020-0,0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020/0+¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0017\u00102\u001a\b\u0012\u0004\u0012\u0002030+¢\u0006\b\n\u0000\u001a\u0004\b4\u00101R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\"06¢\u0006\b\n\u0000\u001a\u0004\b7\u00108¨\u0006A"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "conversationSettingsRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationSettingsRepository;", "settingsRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/repository/SettingsRepository;", "resetUserPersonaDataUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/ResetUserPersonaDataUseCase;", "setConversationUserLanguageUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/SetConversationUserLanguageUseCase;", "setInterpretationModeUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/SetInterpretationModeUseCase;", "setInterpretationSpeedUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/SetInterpretationSpeedUseCase;", "toggleConversationSpeakerDetectionUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/ToggleConversationSpeakerDetectionUseCase;", "setConversationTranscriptionFontSizeUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/SetConversationTranscriptionFontSizeUseCase;", "saveConversationLanguageUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/SaveConversationLanguageUseCase;", "resetSelectedVoiceUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/ResetSelectedVoiceUseCase;", "logRedirectActionUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/LogRedirectActionUseCase;", "setEnvironmentRecognitionStateUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/SetEnvironmentRecognitionStateUseCase;", "getAvailableVoicesForLanguageUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/GetAvailableVoicesForLanguageUseCase;", "textToSpeechManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManager;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationSettingsRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/repository/SettingsRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/ResetUserPersonaDataUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/SetConversationUserLanguageUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/SetInterpretationModeUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/SetInterpretationSpeedUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/ToggleConversationSpeakerDetectionUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/SetConversationTranscriptionFontSizeUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/SaveConversationLanguageUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/ResetSelectedVoiceUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/LogRedirectActionUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/SetEnvironmentRecognitionStateUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/GetAvailableVoicesForLanguageUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManager;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsState;", "_uiEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsEvent;", "uiEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getUiEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "_languageFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Pair;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "conversationSettingsFlow", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsFlow;", "getConversationSettingsFlow", "()Lkotlinx/coroutines/flow/Flow;", "settingsFlow", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/SettingsFlow;", "getSettingsFlow", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "sendErrorEvent", "", "messageRes", "", "showInfoMessage", "onAction", "action", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsAction;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ConversationSettingsViewModel extends ViewModel {
    public static final int $stable = 8;
    private final Flow<Pair<LanguageEnum, LanguageEnum>> _languageFlow;
    private final MutableSharedFlow<ConversationSettingsEvent> _uiEvent;
    private final MutableStateFlow<ConversationSettingsState> _uiState;
    private final Flow<ConversationSettingsFlow> conversationSettingsFlow;
    private final LogRedirectActionUseCase logRedirectActionUseCase;
    private final ResetSelectedVoiceUseCase resetSelectedVoiceUseCase;
    private final ResetUserPersonaDataUseCase resetUserPersonaDataUseCase;
    private final SaveConversationLanguageUseCase saveConversationLanguageUseCase;
    private final SetConversationTranscriptionFontSizeUseCase setConversationTranscriptionFontSizeUseCase;
    private final SetConversationUserLanguageUseCase setConversationUserLanguageUseCase;
    private final SetEnvironmentRecognitionStateUseCase setEnvironmentRecognitionStateUseCase;
    private final SetInterpretationModeUseCase setInterpretationModeUseCase;
    private final SetInterpretationSpeedUseCase setInterpretationSpeedUseCase;
    private final Flow<SettingsFlow> settingsFlow;
    private final TextToSpeechManager textToSpeechManager;
    private final ToggleConversationSpeakerDetectionUseCase toggleConversationSpeakerDetectionUseCase;
    private final SharedFlow<ConversationSettingsEvent> uiEvent;
    private final StateFlow<ConversationSettingsState> uiState;

    @Inject
    public ConversationSettingsViewModel(ConversationSettingsRepository conversationSettingsRepository, SettingsRepository settingsRepository, ResetUserPersonaDataUseCase resetUserPersonaDataUseCase, SetConversationUserLanguageUseCase setConversationUserLanguageUseCase, SetInterpretationModeUseCase setInterpretationModeUseCase, SetInterpretationSpeedUseCase setInterpretationSpeedUseCase, ToggleConversationSpeakerDetectionUseCase toggleConversationSpeakerDetectionUseCase, SetConversationTranscriptionFontSizeUseCase setConversationTranscriptionFontSizeUseCase, SaveConversationLanguageUseCase saveConversationLanguageUseCase, ResetSelectedVoiceUseCase resetSelectedVoiceUseCase, LogRedirectActionUseCase logRedirectActionUseCase, SetEnvironmentRecognitionStateUseCase setEnvironmentRecognitionStateUseCase, GetAvailableVoicesForLanguageUseCase getAvailableVoicesForLanguageUseCase, TextToSpeechManager textToSpeechManager) {
        Intrinsics.checkNotNullParameter(conversationSettingsRepository, "conversationSettingsRepository");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(resetUserPersonaDataUseCase, "resetUserPersonaDataUseCase");
        Intrinsics.checkNotNullParameter(setConversationUserLanguageUseCase, "setConversationUserLanguageUseCase");
        Intrinsics.checkNotNullParameter(setInterpretationModeUseCase, "setInterpretationModeUseCase");
        Intrinsics.checkNotNullParameter(setInterpretationSpeedUseCase, "setInterpretationSpeedUseCase");
        Intrinsics.checkNotNullParameter(toggleConversationSpeakerDetectionUseCase, "toggleConversationSpeakerDetectionUseCase");
        Intrinsics.checkNotNullParameter(setConversationTranscriptionFontSizeUseCase, "setConversationTranscriptionFontSizeUseCase");
        Intrinsics.checkNotNullParameter(saveConversationLanguageUseCase, "saveConversationLanguageUseCase");
        Intrinsics.checkNotNullParameter(resetSelectedVoiceUseCase, "resetSelectedVoiceUseCase");
        Intrinsics.checkNotNullParameter(logRedirectActionUseCase, "logRedirectActionUseCase");
        Intrinsics.checkNotNullParameter(setEnvironmentRecognitionStateUseCase, "setEnvironmentRecognitionStateUseCase");
        Intrinsics.checkNotNullParameter(getAvailableVoicesForLanguageUseCase, "getAvailableVoicesForLanguageUseCase");
        Intrinsics.checkNotNullParameter(textToSpeechManager, "textToSpeechManager");
        this.resetUserPersonaDataUseCase = resetUserPersonaDataUseCase;
        this.setConversationUserLanguageUseCase = setConversationUserLanguageUseCase;
        this.setInterpretationModeUseCase = setInterpretationModeUseCase;
        this.setInterpretationSpeedUseCase = setInterpretationSpeedUseCase;
        this.toggleConversationSpeakerDetectionUseCase = toggleConversationSpeakerDetectionUseCase;
        this.setConversationTranscriptionFontSizeUseCase = setConversationTranscriptionFontSizeUseCase;
        this.saveConversationLanguageUseCase = saveConversationLanguageUseCase;
        this.resetSelectedVoiceUseCase = resetSelectedVoiceUseCase;
        this.logRedirectActionUseCase = logRedirectActionUseCase;
        this.setEnvironmentRecognitionStateUseCase = setEnvironmentRecognitionStateUseCase;
        this.textToSpeechManager = textToSpeechManager;
        Flow flowMutableStateFlow = StateFlowKt.MutableStateFlow(new ConversationSettingsState(null, null, null, false, null, null, 0.0f, null, false, null, FastDoubleMath.DOUBLE_EXPONENT_BIAS, null));
        this._uiState = flowMutableStateFlow;
        MutableSharedFlow<ConversationSettingsEvent> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._uiEvent = mutableSharedFlowMutableSharedFlow$default;
        this.uiEvent = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
        Flow<Pair<LanguageEnum, LanguageEnum>> flowCombine = FlowKt.combine(conversationSettingsRepository.getUserLanguage(), conversationSettingsRepository.getSpeakerLanguage(), new ConversationSettingsViewModel$_languageFlow$1(null));
        this._languageFlow = flowCombine;
        Flow<ConversationSettingsFlow> flowCombine2 = FlowKt.combine(flowCombine, conversationSettingsRepository.isSpeakerDetectionEnabled(), conversationSettingsRepository.getConversationTranscriptFontSize(), conversationSettingsRepository.getConversationMode(), conversationSettingsRepository.getTtsVoice(), new ConversationSettingsViewModel$conversationSettingsFlow$1(null));
        this.conversationSettingsFlow = flowCombine2;
        Flow<SettingsFlow> flowCombine3 = FlowKt.combine(settingsRepository.getInterpretationSpeed(), settingsRepository.getInterpretationMode(), settingsRepository.isEnvSoundRecognizerEnabled(), new ConversationSettingsViewModel$settingsFlow$1(null));
        this.settingsFlow = flowCombine3;
        this.uiState = FlowKt.stateIn(FlowKt.combine(flowMutableStateFlow, flowCombine2, flowCombine3, getAvailableVoicesForLanguageUseCase.invoke(), new ConversationSettingsViewModel$uiState$1(null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object) null), new ConversationSettingsState(null, null, null, false, null, null, 0.0f, null, false, null, FastDoubleMath.DOUBLE_EXPONENT_BIAS, null));
    }

    public final SharedFlow<ConversationSettingsEvent> getUiEvent() {
        return this.uiEvent;
    }

    public final Flow<ConversationSettingsFlow> getConversationSettingsFlow() {
        return this.conversationSettingsFlow;
    }

    public final Flow<SettingsFlow> getSettingsFlow() {
        return this.settingsFlow;
    }

    public final StateFlow<ConversationSettingsState> getUiState() {
        return this.uiState;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationSettingsViewModel$sendErrorEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationSettingsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationSettingsViewModel$sendErrorEvent$1", f = "ConversationSettingsViewModel.kt", i = {}, l = {208}, m = "invokeSuspend", n = {}, s = {})
    static final class C02421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $messageRes;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02421(int i, Continuation<? super C02421> continuation) {
            super(2, continuation);
            this.$messageRes = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationSettingsViewModel.this.new C02421(this.$messageRes, continuation);
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
                if (ConversationSettingsViewModel.this._uiEvent.emit(new ConversationSettingsEvent.ShowErrorMessage(this.$messageRes), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendErrorEvent(int messageRes) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C02421(messageRes, null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationSettingsViewModel$showInfoMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationSettingsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationSettingsViewModel$showInfoMessage$1", f = "ConversationSettingsViewModel.kt", i = {}, l = {214}, m = "invokeSuspend", n = {}, s = {})
    static final class C02431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $messageRes;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02431(int i, Continuation<? super C02431> continuation) {
            super(2, continuation);
            this.$messageRes = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationSettingsViewModel.this.new C02431(this.$messageRes, continuation);
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
                if (ConversationSettingsViewModel.this._uiEvent.emit(new ConversationSettingsEvent.ShowInfoMessage(this.$messageRes), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void showInfoMessage(int messageRes) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C02431(messageRes, null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationSettingsViewModel$onAction$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationSettingsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationSettingsViewModel$onAction$1", f = "ConversationSettingsViewModel.kt", i = {}, l = {222, 230, 238, 246, 254, 262, 271, 273}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ConversationSettingsAction $action;
        int label;
        final /* synthetic */ ConversationSettingsViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ConversationSettingsAction conversationSettingsAction, ConversationSettingsViewModel conversationSettingsViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$action = conversationSettingsAction;
            this.this$0 = conversationSettingsViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$action, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        /* JADX WARN: Code restructure failed: missing block: B:110:0x0205, code lost:
        
            if (r9 == r0) goto L115;
         */
        /* JADX WARN: Code restructure failed: missing block: B:114:0x0225, code lost:
        
            if (r9 == r0) goto L115;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
        
            if (r9 == r0) goto L115;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00a5, code lost:
        
            if (r9 == r0) goto L115;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00ec, code lost:
        
            if (r9 == r0) goto L115;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0133, code lost:
        
            if (r9 == r0) goto L115;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x0176, code lost:
        
            if (r9 == r0) goto L115;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x01bd, code lost:
        
            if (r9 == r0) goto L115;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws kotlin.NoWhenBranchMatchedException {
            /*
                Method dump skipped, instruction units count: 700
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationSettingsViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationSettingsViewModel$onAction$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: ConversationSettingsViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationSettingsViewModel$onAction$1$2", f = "ConversationSettingsViewModel.kt", i = {}, l = {296}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ConversationSettingsAction $action;
            int label;
            final /* synthetic */ ConversationSettingsViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(ConversationSettingsViewModel conversationSettingsViewModel, ConversationSettingsAction conversationSettingsAction, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = conversationSettingsViewModel;
                this.$action = conversationSettingsAction;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$action, continuation);
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
                    if (this.this$0.setEnvironmentRecognitionStateUseCase.invoke(((ConversationSettingsAction.OnToggleEnvironmentSignRecognizerState) this.$action).getState(), (Continuation) this) == coroutine_suspended) {
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

    public final void onAction(ConversationSettingsAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(action, this, null), 3, (Object) null);
    }
}
