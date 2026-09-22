package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import android.speech.tts.Voice;
import android.util.Log;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.wear.compose.foundation.SwipeToRevealKt;
import androidx.window.core.layout.WindowSizeClass;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.mappers.LanguageMapper;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.Conversation;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMessage;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMode;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.MessageInputType;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.MessageType;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion.FetchCorrectionSuggestionUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationusage.CheckAndResetDailyLimitsUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationusage.SyncConversationUsageLimitsUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecasewrappers.ConversationManagementUseCases;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecasewrappers.ConversationSettingsUseCases;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecasewrappers.InterpretationUseCases;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecasewrappers.SuggestionUseCases;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecasewrappers.TextToSpeechUseCases;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.mappers.AppErrorMappersKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.mappers.SpeechErrorMapperKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.shareintent.domain.ShareIntentManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.texttospeech.TextToSpeechManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.texttospeech.TextToSpeechManagerEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: ConversationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \\2\u00020\u0001:\u0001\\Bq\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010D\u001a\u00020EH\u0002J(\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u0002052\b\u0010J\u001a\u0004\u0018\u00010KH\u0082@¢\u0006\u0002\u0010LJ\u0010\u0010M\u001a\u00020E2\u0006\u0010N\u001a\u00020OH\u0002J\u0010\u0010P\u001a\u00020E2\u0006\u0010J\u001a\u00020KH\u0002J\u0006\u0010Q\u001a\u00020EJ\u001f\u0010R\u001a\u00020E2\u0006\u0010N\u001a\u00020O2\b\u0010J\u001a\u0004\u0018\u00010KH\u0002¢\u0006\u0002\u0010SJ\u001f\u0010T\u001a\u00020E2\u0006\u0010N\u001a\u00020O2\b\u0010J\u001a\u0004\u0018\u00010KH\u0002¢\u0006\u0002\u0010SJ\u0010\u0010U\u001a\u00020E2\u0006\u0010N\u001a\u00020VH\u0002J\u0010\u0010W\u001a\u00020E2\u0006\u0010N\u001a\u00020OH\u0002J\u0010\u0010X\u001a\u00020E2\u0006\u0010N\u001a\u00020OH\u0002J\u0010\u0010Y\u001a\u00020E2\u0006\u0010N\u001a\u00020OH\u0002J\u001f\u0010Z\u001a\u00020E2\u0006\u0010N\u001a\u00020O2\b\u0010J\u001a\u0004\u0018\u00010KH\u0002¢\u0006\u0002\u0010SJ\u000e\u0010[\u001a\u00020E2\u0006\u0010N\u001a\u00020OR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0'X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+0*X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b-\u0010.R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u0002000*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u0002020*X\u0082\u0004¢\u0006\u0002\n\u0000R \u00103\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000205040*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\b\u0012\u0004\u0012\u0002070*X\u0082\u0004¢\u0006\u0002\n\u0000R#\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u000207040*¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020 0'¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020#0?¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationViewModel;", "Landroidx/lifecycle/ViewModel;", "conversationSpeechRecognizerService", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationSpeechRecognizerService;", "webViewManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;", "textToSpeechManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManager;", "shareIntentManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/shareintent/domain/ShareIntentManager;", "conversationSettingsRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationSettingsRepository;", "suggestionUseCases", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecasewrappers/SuggestionUseCases;", "interpretationUseCases", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecasewrappers/InterpretationUseCases;", "conversationManagementUseCases", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecasewrappers/ConversationManagementUseCases;", "syncConversationUsageLimitsUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationusage/SyncConversationUsageLimitsUseCase;", "checkAndResetDailyLimitsUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationusage/CheckAndResetDailyLimitsUseCase;", "conversationSettingsUseCases", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecasewrappers/ConversationSettingsUseCases;", "analyticsManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;", "textToSpeechUseCases", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecasewrappers/TextToSpeechUseCases;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationSpeechRecognizerService;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManager;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/shareintent/domain/ShareIntentManager;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationSettingsRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecasewrappers/SuggestionUseCases;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecasewrappers/InterpretationUseCases;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecasewrappers/ConversationManagementUseCases;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationusage/SyncConversationUsageLimitsUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationusage/CheckAndResetDailyLimitsUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecasewrappers/ConversationSettingsUseCases;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecasewrappers/TextToSpeechUseCases;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiState;", "_uiEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiEvent;", "isLanguageAnnouncementShown", "", "_conversationFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/Conversation;", "_conversationMessageFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;", "get_conversationMessageFlow$annotations", "()V", "_serviceFlow", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ServiceState;", "_conversationSuggestionsStateFlow", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSuggestionsState;", "_conversationLanguageSettingsFlow", "Lkotlin/Pair;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "_conversationScreenSettingsStateFlow", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationScreenSettingsState;", "settingsAndSuggestions", "getSettingsAndSuggestions", "()Lkotlinx/coroutines/flow/Flow;", "uiState", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "uiEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getUiEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "recognitionJob", "Lkotlinx/coroutines/Job;", "stopRecognitionJob", "", "fetchSuggestionsForSend", "text", "", "lang", "conversationId", "", "(Ljava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleInputAction", "action", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "recognizerInterpretAndInsertSpeech", "resetLanguageAnnouncementState", "handleInterpretationAction", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;Ljava/lang/Long;)V", "handleTtsAction", "handleMessageInteraction", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction$OnBubbleLongPress;", "handleSuggestionAction", "handleDrawerAction", "handleWebViewAction", "handleConversationManagementAction", "onAction", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ConversationViewModel extends ViewModel {
    private static final String TAG = "ConversationViewModel";
    private final StateFlow<Conversation> _conversationFlow;
    private final Flow<Pair<LanguageEnum, LanguageEnum>> _conversationLanguageSettingsFlow;
    private final Flow<List<ConversationMessage>> _conversationMessageFlow;
    private final Flow<ConversationScreenSettingsState> _conversationScreenSettingsStateFlow;
    private final Flow<ConversationSuggestionsState> _conversationSuggestionsStateFlow;
    private final Flow<ServiceState> _serviceFlow;
    private final MutableSharedFlow<ConversationUiEvent> _uiEvent;
    private final MutableStateFlow<ConversationUiState> _uiState;
    private final AnalyticsManager analyticsManager;
    private final CheckAndResetDailyLimitsUseCase checkAndResetDailyLimitsUseCase;
    private final ConversationManagementUseCases conversationManagementUseCases;
    private final ConversationSettingsRepository conversationSettingsRepository;
    private final ConversationSettingsUseCases conversationSettingsUseCases;
    private final ConversationSpeechRecognizerService conversationSpeechRecognizerService;
    private final InterpretationUseCases interpretationUseCases;
    private boolean isLanguageAnnouncementShown;
    private Job recognitionJob;
    private final Flow<Pair<ConversationSuggestionsState, ConversationScreenSettingsState>> settingsAndSuggestions;
    private final ShareIntentManager shareIntentManager;
    private final SuggestionUseCases suggestionUseCases;
    private final SyncConversationUsageLimitsUseCase syncConversationUsageLimitsUseCase;
    private final TextToSpeechManager textToSpeechManager;
    private final TextToSpeechUseCases textToSpeechUseCases;
    private final SharedFlow<ConversationUiEvent> uiEvent;
    private final StateFlow<ConversationUiState> uiState;
    private final WebViewManager webViewManager;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ConversationMode.values().length];
            try {
                iArr[ConversationMode.ONE_TO_ONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ConversationMode.MEETING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[MessageType.values().length];
            try {
                iArr2[MessageType.INTERPRETATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[MessageType.TEXT_TO_SPEECH.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$fetchSuggestionsForSend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel", f = "ConversationViewModel.kt", i = {0, 0, 0}, l = {570}, m = "fetchSuggestionsForSend", n = {"text", "lang", "conversationId"}, s = {"L$0", "L$1", "L$2"})
    static final class C02441 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C02441(Continuation<? super C02441> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConversationViewModel.this.fetchSuggestionsForSend(null, null, null, (Continuation) this);
        }
    }

    private static /* synthetic */ void get_conversationMessageFlow$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Inject
    public ConversationViewModel(ConversationSpeechRecognizerService conversationSpeechRecognizerService, WebViewManager webViewManager, TextToSpeechManager textToSpeechManager, ShareIntentManager shareIntentManager, ConversationSettingsRepository conversationSettingsRepository, SuggestionUseCases suggestionUseCases, InterpretationUseCases interpretationUseCases, ConversationManagementUseCases conversationManagementUseCases, SyncConversationUsageLimitsUseCase syncConversationUsageLimitsUseCase, CheckAndResetDailyLimitsUseCase checkAndResetDailyLimitsUseCase, ConversationSettingsUseCases conversationSettingsUseCases, AnalyticsManager analyticsManager, TextToSpeechUseCases textToSpeechUseCases) {
        Intrinsics.checkNotNullParameter(conversationSpeechRecognizerService, "conversationSpeechRecognizerService");
        Intrinsics.checkNotNullParameter(webViewManager, "webViewManager");
        Intrinsics.checkNotNullParameter(textToSpeechManager, "textToSpeechManager");
        Intrinsics.checkNotNullParameter(shareIntentManager, "shareIntentManager");
        Intrinsics.checkNotNullParameter(conversationSettingsRepository, "conversationSettingsRepository");
        Intrinsics.checkNotNullParameter(suggestionUseCases, "suggestionUseCases");
        Intrinsics.checkNotNullParameter(interpretationUseCases, "interpretationUseCases");
        Intrinsics.checkNotNullParameter(conversationManagementUseCases, "conversationManagementUseCases");
        Intrinsics.checkNotNullParameter(syncConversationUsageLimitsUseCase, "syncConversationUsageLimitsUseCase");
        Intrinsics.checkNotNullParameter(checkAndResetDailyLimitsUseCase, "checkAndResetDailyLimitsUseCase");
        Intrinsics.checkNotNullParameter(conversationSettingsUseCases, "conversationSettingsUseCases");
        Intrinsics.checkNotNullParameter(analyticsManager, "analyticsManager");
        Intrinsics.checkNotNullParameter(textToSpeechUseCases, "textToSpeechUseCases");
        this.conversationSpeechRecognizerService = conversationSpeechRecognizerService;
        this.webViewManager = webViewManager;
        this.textToSpeechManager = textToSpeechManager;
        this.shareIntentManager = shareIntentManager;
        this.conversationSettingsRepository = conversationSettingsRepository;
        this.suggestionUseCases = suggestionUseCases;
        this.interpretationUseCases = interpretationUseCases;
        this.conversationManagementUseCases = conversationManagementUseCases;
        this.syncConversationUsageLimitsUseCase = syncConversationUsageLimitsUseCase;
        this.checkAndResetDailyLimitsUseCase = checkAndResetDailyLimitsUseCase;
        this.conversationSettingsUseCases = conversationSettingsUseCases;
        this.analyticsManager = analyticsManager;
        this.textToSpeechUseCases = textToSpeechUseCases;
        String str = null;
        boolean z = false;
        List list = null;
        Flow flowMutableStateFlow = StateFlowKt.MutableStateFlow(new ConversationUiState(null, null, null, null, null, null, null, null, str, null, null, null, null, null, z, null, null, null, null, list, false, false, false, false, 0.0f, 33554431, null));
        this._uiState = flowMutableStateFlow;
        MutableSharedFlow<ConversationUiEvent> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._uiEvent = mutableSharedFlowMutableSharedFlow$default;
        ConversationViewModel conversationViewModel = this;
        Flow flowStateIn = FlowKt.stateIn(conversationManagementUseCases.getGetActiveOrNewConversation().invoke(), ViewModelKt.getViewModelScope(conversationViewModel), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object) null), (Object) null);
        this._conversationFlow = flowStateIn;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(conversationViewModel), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(conversationViewModel), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(null), 3, (Object) null);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(conversationViewModel), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass3(null), 3, (Object) null);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(conversationViewModel), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass4(null), 3, (Object) null);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(conversationViewModel), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass5(null), 3, (Object) null);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(conversationViewModel), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass6(null), 3, (Object) null);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(conversationViewModel), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass7(null), 3, (Object) null);
        final Flow flow = flowMutableStateFlow;
        Flow<List<ConversationMessage>> flowCatch = FlowKt.catch(FlowKt.transformLatest(FlowKt.combine(flowStateIn, FlowKt.distinctUntilChanged(new Flow<String>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$special$$inlined$map$1
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = flow.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$special$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$special$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$special$$inlined$map$1$2", f = "ConversationViewModel.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        String searchQuery = ((ConversationUiState) obj).getSearchQuery();
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(searchQuery, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }
        }), new ConversationViewModel$_conversationMessageFlow$2(null)), new ConversationViewModel$special$$inlined$flatMapLatest$1(null, this)), new ConversationViewModel$_conversationMessageFlow$4(this, null));
        this._conversationMessageFlow = flowCatch;
        Flow<ServiceState> flowCombine = FlowKt.combine(conversationSpeechRecognizerService.getServiceState(), webViewManager.getWebViewState(), textToSpeechManager.getTextToSpeechManagerState(), new ConversationViewModel$_serviceFlow$1(null));
        this._serviceFlow = flowCombine;
        Flow<ConversationSuggestionsState> flowCombine2 = FlowKt.combine(conversationSettingsRepository.isCorrectionSuggestionsEnabled(), suggestionUseCases.getGetAll().invoke(), conversationSettingsRepository.getUserLanguage(), new ConversationViewModel$_conversationSuggestionsStateFlow$1(null));
        this._conversationSuggestionsStateFlow = flowCombine2;
        Flow<Pair<LanguageEnum, LanguageEnum>> flowCombine3 = FlowKt.combine(conversationSettingsRepository.getUserLanguage(), conversationSettingsRepository.getSpeakerLanguage(), new ConversationViewModel$_conversationLanguageSettingsFlow$1(null));
        this._conversationLanguageSettingsFlow = flowCombine3;
        Flow<ConversationScreenSettingsState> flowCombine4 = FlowKt.combine(conversationSettingsRepository.getConversationMode(), conversationSettingsRepository.getConversationTranscriptFontSize(), flowCombine3, conversationSettingsRepository.isSpeakerDetectionEnabled(), conversationSettingsRepository.getTtsVoice(), new ConversationViewModel$_conversationScreenSettingsStateFlow$1(null));
        this._conversationScreenSettingsStateFlow = flowCombine4;
        Flow<Pair<ConversationSuggestionsState, ConversationScreenSettingsState>> flowCombine5 = FlowKt.combine(flowCombine2, flowCombine4, new ConversationViewModel$settingsAndSuggestions$1(null));
        this.settingsAndSuggestions = flowCombine5;
        Object[] objArr = 0 == true ? 1 : 0;
        Object[] objArr2 = 0 == true ? 1 : 0;
        Object[] objArr3 = 0 == true ? 1 : 0;
        Object[] objArr4 = 0 == true ? 1 : 0;
        Object[] objArr5 = 0 == true ? 1 : 0;
        Object[] objArr6 = 0 == true ? 1 : 0;
        Object[] objArr7 = 0 == true ? 1 : 0;
        Object[] objArr8 = 0 == true ? 1 : 0;
        this.uiState = FlowKt.stateIn(FlowKt.combine(flowMutableStateFlow, flowCatch, flowCombine5, flowStateIn, flowCombine, new ConversationViewModel$uiState$1(null)), ViewModelKt.getViewModelScope(conversationViewModel), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object) null), new ConversationUiState(null, null, null, null, null, null, null, null, null, null, objArr, objArr2, objArr3, objArr4, false, str, objArr5, objArr6, objArr7, objArr8, false, z, false, false, 0.0f, 33554431, list));
        this.uiEvent = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$1", f = "ConversationViewModel.kt", i = {}, l = {292, 293}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
        
            if (r4.this$0.syncConversationUsageLimitsUseCase.invoke((kotlin.coroutines.Continuation) r4) == r0) goto L15;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r5)
                goto L45
            L12:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L1a:
                kotlin.ResultKt.throwOnFailure(r5)
                goto L33
            L1e:
                kotlin.ResultKt.throwOnFailure(r5)
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel r5 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationusage.CheckAndResetDailyLimitsUseCase r5 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.access$getCheckAndResetDailyLimitsUseCase$p(r5)
                r1 = r4
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r4.label = r3
                java.lang.Object r5 = r5.invoke(r1)
                if (r5 != r0) goto L33
                goto L44
            L33:
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel r5 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationusage.SyncConversationUsageLimitsUseCase r5 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.access$getSyncConversationUsageLimitsUseCase$p(r5)
                r1 = r4
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r4.label = r2
                java.lang.Object r4 = r5.invoke(r1)
                if (r4 != r0) goto L45
            L44:
                return r0
            L45:
                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$2", f = "ConversationViewModel.kt", i = {}, l = {297}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new AnonymousClass2(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.KotlinNothingValueException */
        public final Object invokeSuspend(Object obj) throws KotlinNothingValueException {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<String> sharedText = ConversationViewModel.this.shareIntentManager.getSharedText();
                final ConversationViewModel conversationViewModel = ConversationViewModel.this;
                this.label = 1;
                if (sharedText.collect(new FlowCollector() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.2.1
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((String) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(String str, Continuation<? super Unit> continuation) {
                        Object value;
                        String strTake;
                        MessageInputType messageInputType;
                        String str2 = str;
                        if (str2 != null && !StringsKt.isBlank(str2)) {
                            MutableStateFlow mutableStateFlow = conversationViewModel._uiState;
                            do {
                                value = mutableStateFlow.getValue();
                                strTake = StringsKt.take(str, 1000);
                                messageInputType = MessageInputType.SHARED;
                            } while (!mutableStateFlow.compareAndSet(value, ConversationUiState.copy$default((ConversationUiState) value, null, ConversationDrawer.None.INSTANCE, null, null, null, null, null, null, null, null, null, strTake, messageInputType, null, false, null, null, CollectionsKt.emptyList(), null, null, false, false, false, false, 0.0f, 33417213, null)));
                            conversationViewModel.shareIntentManager.consumeSharedIntentText();
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$3", f = "ConversationViewModel.kt", i = {}, l = {313}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new AnonymousClass3(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object objInvoke;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                objInvoke = ConversationViewModel.this.suggestionUseCases.getFetchFromNetwork().invoke((Continuation) this);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objInvoke = obj;
            }
            ResponseResource responseResource = (ResponseResource) objInvoke;
            if (responseResource instanceof ResponseResource.Success) {
                MutableStateFlow mutableStateFlow = ConversationViewModel.this._uiState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, ConversationUiState.copy$default((ConversationUiState) value, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, (List) ((ResponseResource.Success) responseResource).getData(), false, false, false, false, 0.0f, 33030143, null)));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$4, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$4", f = "ConversationViewModel.kt", i = {}, l = {330}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new AnonymousClass4(continuation);
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
                if (FlowKt.collectLatest(FlowKt.combine(ConversationViewModel.this.conversationSettingsRepository.getUserLanguage(), ConversationViewModel.this.conversationSettingsRepository.getSpeakerLanguage(), ConversationViewModel.this.conversationSettingsRepository.getConversationMode(), new AnonymousClass1(null)), new AnonymousClass2(ConversationViewModel.this, null), (Continuation) this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: ConversationViewModel.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;", "userLang", "speakerLang", "mode"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$4$1", f = "ConversationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function4<LanguageEnum, LanguageEnum, ConversationMode, Continuation<? super Triple<? extends LanguageEnum, ? extends LanguageEnum, ? extends ConversationMode>>, Object> {
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            /* synthetic */ Object L$2;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(4, continuation);
            }

            public final Object invoke(LanguageEnum languageEnum, LanguageEnum languageEnum2, ConversationMode conversationMode, Continuation<? super Triple<? extends LanguageEnum, ? extends LanguageEnum, ? extends ConversationMode>> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.L$0 = languageEnum;
                anonymousClass1.L$1 = languageEnum2;
                anonymousClass1.L$2 = conversationMode;
                return anonymousClass1.invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                LanguageEnum languageEnum = (LanguageEnum) this.L$0;
                LanguageEnum languageEnum2 = (LanguageEnum) this.L$1;
                ConversationMode conversationMode = (ConversationMode) this.L$2;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return new Triple(languageEnum, languageEnum2, conversationMode);
            }
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$4$2, reason: invalid class name */
        /* JADX INFO: compiled from: ConversationViewModel.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "<destruct>", "Lkotlin/Triple;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$4$2", f = "ConversationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<Triple<? extends LanguageEnum, ? extends LanguageEnum, ? extends ConversationMode>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ConversationViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(ConversationViewModel conversationViewModel, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = conversationViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            public final Object invoke(Triple<? extends LanguageEnum, ? extends LanguageEnum, ? extends ConversationMode> triple, Continuation<? super Unit> continuation) {
                return create(triple, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                Object value;
                Triple triple = (Triple) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    Job job = this.this$0.recognitionJob;
                    if (job != null && job.isActive()) {
                        Log.d(ConversationViewModel.TAG, "Settings changed externally. Cancelling active recognition job.");
                        this.this$0.stopRecognitionJob();
                        MutableStateFlow mutableStateFlow = this.this$0._uiState;
                        do {
                            value = mutableStateFlow.getValue();
                        } while (!mutableStateFlow.compareAndSet(value, ConversationUiState.copy$default((ConversationUiState) value, ConversationActivity.Idle.INSTANCE, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, false, false, false, 0.0f, 33554430, null)));
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$5, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$5", f = "ConversationViewModel.kt", i = {}, l = {340}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass5(Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new AnonymousClass5(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.KotlinNothingValueException */
        public final Object invokeSuspend(Object obj) throws KotlinNothingValueException {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SharedFlow<SpeechRecognizerEvent> events = ConversationViewModel.this.conversationSpeechRecognizerService.getEvents();
                final ConversationViewModel conversationViewModel = ConversationViewModel.this;
                this.label = 1;
                if (events.collect(new FlowCollector() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.5.1
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((SpeechRecognizerEvent) obj2, (Continuation<? super Unit>) continuation);
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public final Object emit(SpeechRecognizerEvent speechRecognizerEvent, Continuation<? super Unit> continuation) throws NoWhenBranchMatchedException {
                        if (speechRecognizerEvent instanceof SpeechRecognizerEvent.Error) {
                            SpeechRecognizerEvent.Error error = (SpeechRecognizerEvent.Error) speechRecognizerEvent;
                            if (error.getDebugMessage() != null) {
                                Log.e(ConversationViewModel.TAG, "Speech Error: " + error.getDebugMessage());
                            }
                            Object objEmit = conversationViewModel._uiEvent.emit(new ConversationUiEvent.Error(SpeechErrorMapperKt.toErrorMessageRes(error.getType())), continuation);
                            return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                        }
                        if (!(speechRecognizerEvent instanceof SpeechRecognizerEvent.Recognized)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$6, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$6", f = "ConversationViewModel.kt", i = {}, l = {356}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass6(Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new AnonymousClass6(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.KotlinNothingValueException */
        public final Object invokeSuspend(Object obj) throws KotlinNothingValueException {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SharedFlow<WebViewEvent> webViewEvent = ConversationViewModel.this.webViewManager.getWebViewEvent();
                final ConversationViewModel conversationViewModel = ConversationViewModel.this;
                this.label = 1;
                if (webViewEvent.collect(new FlowCollector() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.6.1
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((WebViewEvent) obj2, (Continuation<? super Unit>) continuation);
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public final Object emit(WebViewEvent webViewEvent2, Continuation<? super Unit> continuation) throws NoWhenBranchMatchedException {
                        if (webViewEvent2 instanceof WebViewEvent.Error) {
                            Object objEmit = conversationViewModel._uiEvent.emit(new ConversationUiEvent.Error(AppErrorMappersKt.toConversationErrorMessageRes(((WebViewEvent.Error) webViewEvent2).getError())), continuation);
                            return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                        }
                        if (Intrinsics.areEqual(webViewEvent2, WebViewEvent.WebViewLoadFailed.INSTANCE)) {
                            Object objEmit2 = conversationViewModel._uiEvent.emit(new ConversationUiEvent.Error(R.string.conversation_avatar_load_error), continuation);
                            return objEmit2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit2 : Unit.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$7, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$7", f = "ConversationViewModel.kt", i = {}, l = {369}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass7(Continuation<? super AnonymousClass7> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new AnonymousClass7(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.KotlinNothingValueException */
        public final Object invokeSuspend(Object obj) throws KotlinNothingValueException {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SharedFlow<TextToSpeechManagerEvent> textToSpeechManagerEvent = ConversationViewModel.this.textToSpeechManager.getTextToSpeechManagerEvent();
                final ConversationViewModel conversationViewModel = ConversationViewModel.this;
                this.label = 1;
                if (textToSpeechManagerEvent.collect(new FlowCollector() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.7.1
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((TextToSpeechManagerEvent) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(TextToSpeechManagerEvent textToSpeechManagerEvent2, Continuation<? super Unit> continuation) {
                        if (textToSpeechManagerEvent2 instanceof TextToSpeechManagerEvent.Error) {
                            TextToSpeechManagerEvent.Error error = (TextToSpeechManagerEvent.Error) textToSpeechManagerEvent2;
                            if (error instanceof TextToSpeechManagerEvent.Error.InitializationFailed) {
                                Object objEmit = conversationViewModel._uiEvent.emit(new ConversationUiEvent.Error(R.string.conversation_tts_initialization_error), continuation);
                                return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                            }
                            if (error instanceof TextToSpeechManagerEvent.Error.OperationFailed) {
                                Object objEmit2 = conversationViewModel._uiEvent.emit(new ConversationUiEvent.Error(R.string.conversation_tts_error), continuation);
                                return objEmit2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit2 : Unit.INSTANCE;
                            }
                            if (error instanceof TextToSpeechManagerEvent.Error.LanguageNotSupported) {
                                Object objEmit3 = conversationViewModel._uiEvent.emit(new ConversationUiEvent.Error(R.string.conversation_language_not_supported_error), continuation);
                                return objEmit3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit3 : Unit.INSTANCE;
                            }
                            Object objEmit4 = conversationViewModel._uiEvent.emit(new ConversationUiEvent.Error(R.string.conversation_tts_error), continuation);
                            return objEmit4 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit4 : Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    public final Flow<Pair<ConversationSuggestionsState, ConversationScreenSettingsState>> getSettingsAndSuggestions() {
        return this.settingsAndSuggestions;
    }

    public final StateFlow<ConversationUiState> getUiState() {
        return this.uiState;
    }

    public final SharedFlow<ConversationUiEvent> getUiEvent() {
        return this.uiEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopRecognitionJob() {
        Job job = this.recognitionJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.recognitionJob = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object fetchSuggestionsForSend(String str, LanguageEnum languageEnum, Long l, Continuation<? super Unit> continuation) throws NoWhenBranchMatchedException {
        C02441 c02441;
        Object value;
        Long l2;
        Object value2;
        Object value3;
        Object value4;
        String str2 = str;
        if (continuation instanceof C02441) {
            c02441 = (C02441) continuation;
            if ((c02441.label & Integer.MIN_VALUE) != 0) {
                c02441.label -= Integer.MIN_VALUE;
            } else {
                c02441 = new C02441(continuation);
            }
        } else {
            c02441 = new C02441(continuation);
        }
        Object objInvoke = c02441.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02441.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objInvoke);
            MutableStateFlow<ConversationUiState> mutableStateFlow = this._uiState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ConversationUiState.copy$default((ConversationUiState) value, ConversationActivity.IsFetchingSuggestions.INSTANCE, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, false, false, false, 0.0f, 33554430, null)));
            FetchCorrectionSuggestionUseCase fetch = this.suggestionUseCases.getFetch();
            c02441.L$0 = str2;
            c02441.L$1 = SpillingKt.nullOutSpilledVariable(languageEnum);
            l2 = l;
            c02441.L$2 = l2;
            c02441.label = 1;
            objInvoke = fetch.invoke(languageEnum, str2, c02441);
            if (objInvoke == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Long l3 = (Long) c02441.L$2;
            String str3 = (String) c02441.L$0;
            ResultKt.throwOnFailure(objInvoke);
            l2 = l3;
            str2 = str3;
        }
        ResponseResource responseResource = (ResponseResource) objInvoke;
        if (responseResource instanceof ResponseResource.Error) {
            MutableStateFlow<ConversationUiState> mutableStateFlow2 = this._uiState;
            do {
                value4 = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value4, ConversationUiState.copy$default((ConversationUiState) value4, ConversationActivity.Idle.INSTANCE, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, false, false, false, 0.0f, 33554430, null)));
            handleTtsAction(new ConversationUiAction.OnTtsSpeakAndSaveMessage(str2), l2);
        } else if (responseResource instanceof ResponseResource.Success) {
            ResponseResource.Success success = (ResponseResource.Success) responseResource;
            if (!((Collection) success.getData()).isEmpty()) {
                MutableStateFlow<ConversationUiState> mutableStateFlow3 = this._uiState;
                do {
                    value3 = mutableStateFlow3.getValue();
                } while (!mutableStateFlow3.compareAndSet(value3, ConversationUiState.copy$default((ConversationUiState) value3, ConversationActivity.Idle.INSTANCE, ConversationDrawer.CorrectionSuggestions.INSTANCE, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, (List) success.getData(), null, null, false, false, false, false, 0.0f, 33423356, null)));
            } else {
                MutableStateFlow<ConversationUiState> mutableStateFlow4 = this._uiState;
                do {
                    value2 = mutableStateFlow4.getValue();
                } while (!mutableStateFlow4.compareAndSet(value2, ConversationUiState.copy$default((ConversationUiState) value2, ConversationActivity.Idle.INSTANCE, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, false, false, false, 0.0f, 33554430, null)));
                handleTtsAction(new ConversationUiAction.OnTtsSpeakAndSaveMessage(str2), l2);
            }
        } else if (!Intrinsics.areEqual(responseResource, ResponseResource.Loading.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }

    private final void handleInputAction(ConversationUiAction action) {
        Object value;
        Object value2;
        Object value3;
        String strTake;
        if (action instanceof ConversationUiAction.OnInputTextChange) {
            MutableStateFlow<ConversationUiState> mutableStateFlow = this._uiState;
            do {
                value3 = mutableStateFlow.getValue();
                strTake = StringsKt.take(((ConversationUiAction.OnInputTextChange) action).getText(), 1000);
            } while (!mutableStateFlow.compareAndSet(value3, ConversationUiState.copy$default((ConversationUiState) value3, null, ConversationDrawer.None.INSTANCE, null, null, null, null, null, null, null, null, null, strTake, MessageInputType.TYPED, null, false, null, null, CollectionsKt.emptyList(), null, null, false, false, false, false, 0.0f, 33417213, null)));
            return;
        }
        if (action instanceof ConversationUiAction.OnSearchQueryChange) {
            MutableStateFlow<ConversationUiState> mutableStateFlow2 = this._uiState;
            do {
                value2 = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value2, ConversationUiState.copy$default((ConversationUiState) value2, null, null, null, null, null, null, null, null, null, null, null, null, null, ((ConversationUiAction.OnSearchQueryChange) action).getQuery(), false, null, null, null, null, null, false, false, false, false, 0.0f, 33546239, null)));
        } else if (action instanceof ConversationUiAction.OnClearInputText) {
            MutableStateFlow<ConversationUiState> mutableStateFlow3 = this._uiState;
            do {
                value = mutableStateFlow3.getValue();
            } while (!mutableStateFlow3.compareAndSet(value, ConversationUiState.copy$default((ConversationUiState) value, null, ConversationDrawer.None.INSTANCE, null, null, null, null, null, null, null, null, null, "", MessageInputType.TYPED, null, false, null, null, CollectionsKt.emptyList(), null, null, false, false, false, false, 0.0f, 33417213, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recognizerInterpretAndInsertSpeech(long conversationId) {
        Object value;
        MutableStateFlow<ConversationUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ConversationUiState.copy$default((ConversationUiState) value, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, false, false, false, 0.0f, 27262975, null)));
        stopRecognitionJob();
        this.recognitionJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C02612(conversationId, null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$recognizerInterpretAndInsertSpeech$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$recognizerInterpretAndInsertSpeech$2", f = "ConversationViewModel.kt", i = {}, l = {635}, m = "invokeSuspend", n = {}, s = {})
    static final class C02612 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $conversationId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02612(long j, Continuation<? super C02612> continuation) {
            super(2, continuation);
            this.$conversationId = j;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new C02612(this.$conversationId, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ConversationViewModel.this.textToSpeechManager.stopSpeaking();
                ConversationViewModel.this.webViewManager.restoreView();
                MutableStateFlow mutableStateFlow = ConversationViewModel.this._uiState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, ConversationUiState.copy$default((ConversationUiState) value, null, ConversationDrawer.None.INSTANCE, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, CollectionsKt.emptyList(), null, null, false, false, false, false, 0.0f, 33423357, null)));
                this.label = 1;
                if (ConversationViewModel.this.interpretationUseCases.getRecognizeInterpretAndInsert().invoke(this.$conversationId, (Continuation) this) == coroutine_suspended) {
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

    public final void resetLanguageAnnouncementState() {
        this.isLanguageAnnouncementShown = false;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleInterpretationAction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleInterpretationAction$1", f = "ConversationViewModel.kt", i = {}, l = {645}, m = "invokeSuspend", n = {}, s = {})
    static final class C02511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C02511(Continuation<? super C02511> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new C02511(continuation);
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
                if (ConversationViewModel.this._uiEvent.emit(new ConversationUiEvent.Error(R.string.conversation_not_ready_error), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    private final void handleInterpretationAction(ConversationUiAction action, Long conversationId) throws NoWhenBranchMatchedException {
        Object value;
        Object value2;
        Object value3;
        Object value4;
        Object value5;
        if (conversationId == null) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C02511(null), 3, (Object) null);
            return;
        }
        MutableStateFlow<ConversationUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ConversationUiState.copy$default((ConversationUiState) value, null, null, new ConversationActionElement.InterpretationWebView(false), null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, false, false, false, 0.0f, 33554427, null)));
        if (action instanceof ConversationUiAction.OnShowSpeakerLanguageDialog) {
            this.textToSpeechManager.stopSpeaking();
            MutableStateFlow<ConversationUiState> mutableStateFlow2 = this._uiState;
            do {
                value5 = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value5, ConversationUiState.copy$default((ConversationUiState) value5, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, false, true, false, 0.0f, 27262975, null)));
            Unit unit = Unit.INSTANCE;
            return;
        }
        if (action instanceof ConversationUiAction.OnMicrophonePermissionGranted) {
            int i = WhenMappings.$EnumSwitchMapping$0[((ConversationUiState) this.uiState.getValue()).getConversationMode().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                recognizerInterpretAndInsertSpeech(conversationId.longValue());
                Unit unit2 = Unit.INSTANCE;
                return;
            }
            if (!this.isLanguageAnnouncementShown) {
                this.isLanguageAnnouncementShown = true;
                LanguageEnum speakerLang = ((ConversationUiState) this.uiState.getValue()).getSpeakerLang();
                Voice ttsVoice = ((ConversationUiState) this.uiState.getValue()).getTtsVoice();
                MutableStateFlow<ConversationUiState> mutableStateFlow3 = this._uiState;
                do {
                    value4 = mutableStateFlow3.getValue();
                } while (!mutableStateFlow3.compareAndSet(value4, ConversationUiState.copy$default((ConversationUiState) value4, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, true, false, false, 0.0f, 31457279, null)));
                TextToSpeechManager.speakText$default(this.textToSpeechManager, speakerLang.getSpeakText(), LanguageMapper.INSTANCE.toTranscriptionLang(speakerLang), ttsVoice, 0, 8, null);
            } else {
                recognizerInterpretAndInsertSpeech(conversationId.longValue());
            }
            Unit unit3 = Unit.INSTANCE;
            return;
        }
        if (action instanceof ConversationUiAction.OnSetSpeakerLanguageAndStartInterpretation) {
            MutableStateFlow<ConversationUiState> mutableStateFlow4 = this._uiState;
            do {
                value3 = mutableStateFlow4.getValue();
            } while (!mutableStateFlow4.compareAndSet(value3, ConversationUiState.copy$default((ConversationUiState) value3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, false, false, false, 0.0f, 27262975, null)));
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C02526(action, conversationId, null), 3, (Object) null);
            return;
        }
        if (action instanceof ConversationUiAction.OnInterpretSpeech) {
            recognizerInterpretAndInsertSpeech(conversationId.longValue());
            Unit unit4 = Unit.INSTANCE;
            return;
        }
        if (action instanceof ConversationUiAction.OnInterpretInputText) {
            String inputText = ((ConversationUiState) this._uiState.getValue()).getInputText();
            MessageInputType activeInputType = ((ConversationUiState) this._uiState.getValue()).getActiveInputType();
            this.webViewManager.restoreView();
            MutableStateFlow<ConversationUiState> mutableStateFlow5 = this._uiState;
            do {
                value2 = mutableStateFlow5.getValue();
            } while (!mutableStateFlow5.compareAndSet(value2, ConversationUiState.copy$default((ConversationUiState) value2, ConversationActivity.IsProcessingInputText.INSTANCE, ConversationDrawer.None.INSTANCE, null, null, null, null, null, null, null, null, null, "", MessageInputType.TYPED, null, false, null, null, null, null, null, false, false, false, false, 0.0f, 33548284, null)));
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass8(conversationId, inputText, activeInputType, null), 3, (Object) null);
            return;
        }
        if (action instanceof ConversationUiAction.OnInterpretScannedDocument) {
            this.webViewManager.restoreView();
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass9(conversationId, action, null), 3, (Object) null);
            return;
        }
        if (action instanceof ConversationUiAction.OnRequestMicrophonePermissionForInterpretation) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass10(null), 3, (Object) null);
            return;
        }
        if (action instanceof ConversationUiAction.OnOpenDocumentScanner) {
            this.analyticsManager.logEvent(new AnalyticsEvent.ImageScanButtonClicked(((ConversationUiState) this.uiState.getValue()).getUserLang().name()));
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass11(null), 3, (Object) null);
        } else {
            if (action instanceof ConversationUiAction.OnStopInterpretationAndTranscription) {
                stopRecognitionJob();
                this.textToSpeechManager.stopSpeaking();
                BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass12(null), 3, (Object) null);
                return;
            }
            Unit unit5 = Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleInterpretationAction$6, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleInterpretationAction$6", f = "ConversationViewModel.kt", i = {1}, l = {694, 697}, m = "invokeSuspend", n = {"response"}, s = {"L$0"})
    static final class C02526 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ConversationUiAction $action;
        final /* synthetic */ Long $conversationId;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02526(ConversationUiAction conversationUiAction, Long l, Continuation<? super C02526> continuation) {
            super(2, continuation);
            this.$action = conversationUiAction;
            this.$conversationId = l;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new C02526(this.$action, this.$conversationId, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x006f, code lost:
        
            if (r5.this$0._uiEvent.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent.Error(com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.mappers.AppErrorMappersKt.toConversationErrorMessageRes(((com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r6).getError())), (kotlin.coroutines.Continuation) r5) == r0) goto L17;
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
                if (r1 == 0) goto L23
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r5 = r5.L$0
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r5 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r5
                kotlin.ResultKt.throwOnFailure(r6)
                goto L90
            L17:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1f:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L44
            L23:
                kotlin.ResultKt.throwOnFailure(r6)
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecasewrappers.ConversationSettingsUseCases r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.access$getConversationSettingsUseCases$p(r6)
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.SetConversationSpeakerLanguageUseCase r6 = r6.getSetSpeakerLanguage()
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiAction r1 = r5.$action
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiAction$OnSetSpeakerLanguageAndStartInterpretation r1 = (com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiAction.OnSetSpeakerLanguageAndStartInterpretation) r1
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum r1 = r1.getSpeakerLang()
                r4 = r5
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r5.label = r3
                java.lang.Object r6 = r6.invoke(r1, r4)
                if (r6 != r0) goto L44
                goto L71
            L44:
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r6 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r6
                boolean r1 = r6 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error
                if (r1 == 0) goto L72
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.this
                kotlinx.coroutines.flow.MutableSharedFlow r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.access$get_uiEvent$p(r1)
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent$Error r3 = new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent$Error
                r4 = r6
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Error r4 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r4
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError r4 = r4.getError()
                int r4 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.mappers.AppErrorMappersKt.toConversationErrorMessageRes(r4)
                r3.<init>(r4)
                r4 = r5
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
                r5.L$0 = r6
                r5.label = r2
                java.lang.Object r5 = r1.emit(r3, r4)
                if (r5 != r0) goto L90
            L71:
                return r0
            L72:
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Loading r0 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Loading.INSTANCE
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r0)
                if (r0 != 0) goto L90
                boolean r6 = r6 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Success
                if (r6 == 0) goto L8a
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.this
                java.lang.Long r5 = r5.$conversationId
                long r0 = r5.longValue()
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.access$recognizerInterpretAndInsertSpeech(r6, r0)
                goto L90
            L8a:
                kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
                r5.<init>()
                throw r5
            L90:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.C02526.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleInterpretationAction$8, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleInterpretationAction$8", f = "ConversationViewModel.kt", i = {1}, l = {722, 727}, m = "invokeSuspend", n = {"response"}, s = {"L$0"})
    static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Long $conversationId;
        final /* synthetic */ String $inputText;
        final /* synthetic */ MessageInputType $inputType;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass8(Long l, String str, MessageInputType messageInputType, Continuation<? super AnonymousClass8> continuation) {
            super(2, continuation);
            this.$conversationId = l;
            this.$inputText = str;
            this.$inputType = messageInputType;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new AnonymousClass8(this.$conversationId, this.$inputText, this.$inputType, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0086, code lost:
        
            if (r30.this$0._uiEvent.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent.Error(com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.mappers.AppErrorMappersKt.toConversationErrorMessageRes(((com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r2).getError())), (kotlin.coroutines.Continuation) r30) == r1) goto L17;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r31) throws kotlin.NoWhenBranchMatchedException {
            /*
                Method dump skipped, instruction units count: 297
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.AnonymousClass8.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleInterpretationAction$9, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleInterpretationAction$9", f = "ConversationViewModel.kt", i = {}, l = {740}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ConversationUiAction $action;
        final /* synthetic */ Long $conversationId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass9(Long l, ConversationUiAction conversationUiAction, Continuation<? super AnonymousClass9> continuation) {
            super(2, continuation);
            this.$conversationId = l;
            this.$action = conversationUiAction;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new AnonymousClass9(this.$conversationId, this.$action, continuation);
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
                if (ConversationViewModel.this.interpretationUseCases.getTranslateInterpretAndSaveInputText().invoke(this.$conversationId.longValue(), ((ConversationUiAction.OnInterpretScannedDocument) this.$action).getScannedText(), LanguageEnum.ENGLISH, MessageInputType.SCANNED, MessageType.INTERPRETATION, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleInterpretationAction$10, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleInterpretationAction$10", f = "ConversationViewModel.kt", i = {}, l = {746}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass10 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass10(Continuation<? super AnonymousClass10> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new AnonymousClass10(continuation);
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
                if (ConversationViewModel.this._uiEvent.emit(ConversationUiEvent.RequestMicrophonePermission.INSTANCE, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleInterpretationAction$11, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleInterpretationAction$11", f = "ConversationViewModel.kt", i = {}, l = {751}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass11 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass11(Continuation<? super AnonymousClass11> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new AnonymousClass11(continuation);
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
                if (ConversationViewModel.this._uiEvent.emit(ConversationUiEvent.NavigateToDocumentScanner.INSTANCE, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleInterpretationAction$12, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleInterpretationAction$12", f = "ConversationViewModel.kt", i = {}, l = {757}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass12 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass12(Continuation<? super AnonymousClass12> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new AnonymousClass12(continuation);
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
                if (ConversationViewModel.this.interpretationUseCases.getStopInterpretationAndTranscription().invoke((Continuation) this) == coroutine_suspended) {
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

    private final void handleTtsAction(ConversationUiAction action, Long conversationId) {
        Object value;
        Object value2;
        Object value3;
        MessageInputType messageInputType;
        if (action instanceof ConversationUiAction.OnTtsSpeakAndSaveMessage) {
            if (conversationId == null) {
                return;
            }
            String string = ((ConversationUiAction.OnTtsSpeakAndSaveMessage) action).getString();
            ((ConversationUiState) this.uiState.getValue()).getActiveInputType();
            LanguageEnum userLang = ((ConversationUiState) this.uiState.getValue()).getUserLang();
            LanguageEnum speakerLang = ((ConversationUiState) this.uiState.getValue()).getSpeakerLang();
            Voice ttsVoice = ((ConversationUiState) this.uiState.getValue()).getTtsVoice();
            MutableStateFlow<ConversationUiState> mutableStateFlow = this._uiState;
            do {
                value3 = mutableStateFlow.getValue();
                messageInputType = MessageInputType.TYPED;
            } while (!mutableStateFlow.compareAndSet(value3, ConversationUiState.copy$default((ConversationUiState) value3, ConversationActivity.IsProcessingInputText.INSTANCE, ConversationDrawer.None.INSTANCE, null, null, null, null, null, null, null, null, null, "", messageInputType, null, false, null, null, null, null, null, false, false, false, false, 0.0f, 33548284, null)));
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C02592(string, conversationId, speakerLang, userLang, ttsVoice, null), 3, (Object) null);
            return;
        }
        if (action instanceof ConversationUiAction.OnTtsSpeak) {
            ConversationUiAction.OnTtsSpeak onTtsSpeak = (ConversationUiAction.OnTtsSpeak) action;
            String string2 = onTtsSpeak.getString();
            LanguageEnum language = onTtsSpeak.getLanguage();
            Voice ttsVoice2 = ((ConversationUiState) this.uiState.getValue()).getTtsVoice();
            MutableStateFlow<ConversationUiState> mutableStateFlow2 = this._uiState;
            do {
                value2 = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value2, ConversationUiState.copy$default((ConversationUiState) value2, null, ConversationDrawer.None.INSTANCE, ConversationActionElement.TextToSpeechDrawer.INSTANCE, null, null, null, null, null, null, null, null, "", null, null, false, null, null, null, null, null, false, false, false, false, 0.0f, 33552377, null)));
            TextToSpeechManager.speakText$default(this.textToSpeechManager, string2, LanguageMapper.INSTANCE.toTranscriptionLang(language), ttsVoice2, 0, 8, null);
            return;
        }
        if (action instanceof ConversationUiAction.OnTtsRepeat) {
            this.textToSpeechManager.repeatLast(((ConversationUiState) this.uiState.getValue()).getTtsVoice());
        } else if (action instanceof ConversationUiAction.OnTtsDrawerClose) {
            this.textToSpeechManager.stopSpeaking();
            MutableStateFlow<ConversationUiState> mutableStateFlow3 = this._uiState;
            do {
                value = mutableStateFlow3.getValue();
            } while (!mutableStateFlow3.compareAndSet(value, ConversationUiState.copy$default((ConversationUiState) value, null, ConversationDrawer.None.INSTANCE, new ConversationActionElement.InterpretationWebView(false), null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, false, false, false, 0.0f, 33554425, null)));
            this.webViewManager.restoreView();
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleTtsAction$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleTtsAction$2", f = "ConversationViewModel.kt", i = {1}, l = {784, 796}, m = "invokeSuspend", n = {"response"}, s = {"L$0"})
    static final class C02592 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Long $conversationId;
        final /* synthetic */ String $inputText;
        final /* synthetic */ Voice $selectedVoice;
        final /* synthetic */ LanguageEnum $speakerLang;
        final /* synthetic */ LanguageEnum $userLang;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02592(String str, Long l, LanguageEnum languageEnum, LanguageEnum languageEnum2, Voice voice, Continuation<? super C02592> continuation) {
            super(2, continuation);
            this.$inputText = str;
            this.$conversationId = l;
            this.$speakerLang = languageEnum;
            this.$userLang = languageEnum2;
            this.$selectedVoice = voice;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new C02592(this.$inputText, this.$conversationId, this.$speakerLang, this.$userLang, this.$selectedVoice, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x00c1, code lost:
        
            if (r34.this$0._uiEvent.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent.Error(com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.mappers.AppErrorMappersKt.toConversationErrorMessageRes(((com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r2).getError())), (kotlin.coroutines.Continuation) r34) == r1) goto L20;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r35) throws kotlin.NoWhenBranchMatchedException {
            /*
                Method dump skipped, instruction units count: 354
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.C02592.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    private final void handleMessageInteraction(ConversationUiAction.OnBubbleLongPress action) throws NoWhenBranchMatchedException {
        Object value;
        ConversationMessage conversationMessage = action.getConversationMessage();
        int i = WhenMappings.$EnumSwitchMapping$1[conversationMessage.getMessageType().ordinal()];
        if (i == 1) {
            this.webViewManager.restoreView();
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C02531(conversationMessage, null), 3, (Object) null);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            Voice ttsVoice = ((ConversationUiState) this.uiState.getValue()).getTtsVoice();
            MutableStateFlow<ConversationUiState> mutableStateFlow = this._uiState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ConversationUiState.copy$default((ConversationUiState) value, null, null, ConversationActionElement.TextToSpeechDrawer.INSTANCE, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, false, false, false, 0.0f, 33554427, null)));
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C02543(conversationMessage, ttsVoice, null), 3, (Object) null);
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleMessageInteraction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleMessageInteraction$1", f = "ConversationViewModel.kt", i = {}, l = {850}, m = "invokeSuspend", n = {}, s = {})
    static final class C02531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ConversationMessage $conversationMessage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02531(ConversationMessage conversationMessage, Continuation<? super C02531> continuation) {
            super(2, continuation);
            this.$conversationMessage = conversationMessage;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new C02531(this.$conversationMessage, continuation);
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
                if (ConversationViewModel.this.interpretationUseCases.getInterpretMessage().invoke(this.$conversationMessage, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleMessageInteraction$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleMessageInteraction$3", f = "ConversationViewModel.kt", i = {}, l = {857}, m = "invokeSuspend", n = {}, s = {})
    static final class C02543 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ConversationMessage $conversationMessage;
        final /* synthetic */ Voice $selectedVoice;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02543(ConversationMessage conversationMessage, Voice voice, Continuation<? super C02543> continuation) {
            super(2, continuation);
            this.$conversationMessage = conversationMessage;
            this.$selectedVoice = voice;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new C02543(this.$conversationMessage, this.$selectedVoice, continuation);
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
                if (ConversationViewModel.this.textToSpeechUseCases.getSpeakMessage().invoke(this.$conversationMessage, this.$selectedVoice, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleSuggestionAction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleSuggestionAction$1", f = "ConversationViewModel.kt", i = {}, l = {869}, m = "invokeSuspend", n = {}, s = {})
    static final class C02551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C02551(Continuation<? super C02551> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new C02551(continuation);
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
                if (ConversationViewModel.this.conversationSettingsRepository.toggleCorrectionSuggestion((Continuation) this) == coroutine_suspended) {
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

    private final void handleSuggestionAction(ConversationUiAction action) {
        Object value;
        Object value2;
        Object value3;
        if (action instanceof ConversationUiAction.OnToggleInputSuggestion) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C02551(null), 3, (Object) null);
            return;
        }
        if (action instanceof ConversationUiAction.OnCorrectionSuggestionSelect) {
            MutableStateFlow<ConversationUiState> mutableStateFlow = this._uiState;
            do {
                value3 = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value3, ConversationUiState.copy$default((ConversationUiState) value3, null, ConversationDrawer.None.INSTANCE, null, null, null, null, null, null, null, null, null, ((ConversationUiAction.OnCorrectionSuggestionSelect) action).getSuggestion().getSentence(), MessageInputType.TYPED, null, false, null, null, CollectionsKt.emptyList(), null, null, false, false, false, false, 0.0f, 33417213, null)));
            return;
        }
        if (action instanceof ConversationUiAction.OnShowCorrectionSuggestionSaveDialogBox) {
            MutableStateFlow<ConversationUiState> mutableStateFlow2 = this._uiState;
            do {
                value2 = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value2, ConversationUiState.copy$default((ConversationUiState) value2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, new SaveInputSuggestionDialogState.Show(((ConversationUiAction.OnShowCorrectionSuggestionSaveDialogBox) action).getSuggestion()), null, null, null, false, false, false, false, 0.0f, 33488895, null)));
        } else if (action instanceof ConversationUiAction.OnCorrectionSuggestionSaveDismiss) {
            MutableStateFlow<ConversationUiState> mutableStateFlow3 = this._uiState;
            do {
                value = mutableStateFlow3.getValue();
            } while (!mutableStateFlow3.compareAndSet(value, ConversationUiState.copy$default((ConversationUiState) value, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, SaveInputSuggestionDialogState.Hidden.INSTANCE, null, null, null, false, false, false, false, 0.0f, 33488895, null)));
        } else if (action instanceof ConversationUiAction.OnSaveCorrectionSuggestion) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C02565(action, null), 3, (Object) null);
        } else if (action instanceof ConversationUiAction.OnDeleteCategory) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C02576(action, null), 3, (Object) null);
        } else if (action instanceof ConversationUiAction.OnDeleteSuggestion) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C02587(action, null), 3, (Object) null);
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleSuggestionAction$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleSuggestionAction$5", f = "ConversationViewModel.kt", i = {1}, l = {890, 892}, m = "invokeSuspend", n = {"response"}, s = {"L$0"})
    static final class C02565 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ConversationUiAction $action;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02565(ConversationUiAction conversationUiAction, Continuation<? super C02565> continuation) {
            super(2, continuation);
            this.$action = conversationUiAction;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new C02565(this.$action, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x00cd, code lost:
        
            if (r34.this$0._uiEvent.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent.Error(com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.mappers.AppErrorMappersKt.toConversationErrorMessageRes(((com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r2).getError())), (kotlin.coroutines.Continuation) r34) == r1) goto L20;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r35) {
            /*
                Method dump skipped, instruction units count: 211
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.C02565.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleSuggestionAction$6, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleSuggestionAction$6", f = "ConversationViewModel.kt", i = {1}, l = {898, WindowSizeClass.HEIGHT_DP_EXPANDED_LOWER_BOUND}, m = "invokeSuspend", n = {"response"}, s = {"L$0"})
    static final class C02576 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ConversationUiAction $action;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02576(ConversationUiAction conversationUiAction, Continuation<? super C02576> continuation) {
            super(2, continuation);
            this.$action = conversationUiAction;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new C02576(this.$action, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x006e, code lost:
        
            if (r5.this$0._uiEvent.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent.Error(com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.mappers.AppErrorMappersKt.toConversationErrorMessageRes(((com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r6).getError())), (kotlin.coroutines.Continuation) r5) == r0) goto L17;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r5 = r5.L$0
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r5 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r5
                kotlin.ResultKt.throwOnFailure(r6)
                goto L71
            L16:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1e:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L43
            L22:
                kotlin.ResultKt.throwOnFailure(r6)
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecasewrappers.SuggestionUseCases r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.access$getSuggestionUseCases$p(r6)
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion.DeleteConversationInputSuggestionCategoryUseCase r6 = r6.getDeleteCategory()
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiAction r1 = r5.$action
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiAction$OnDeleteCategory r1 = (com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiAction.OnDeleteCategory) r1
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.SuggestionCategory r1 = r1.getCategory()
                r4 = r5
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r5.label = r3
                java.lang.Object r6 = r6.invoke(r1, r4)
                if (r6 != r0) goto L43
                goto L70
            L43:
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r6 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r6
                boolean r1 = r6 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error
                if (r1 == 0) goto L71
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.this
                kotlinx.coroutines.flow.MutableSharedFlow r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.access$get_uiEvent$p(r1)
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent$Error r3 = new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent$Error
                r4 = r6
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Error r4 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r4
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError r4 = r4.getError()
                int r4 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.mappers.AppErrorMappersKt.toConversationErrorMessageRes(r4)
                r3.<init>(r4)
                r4 = r5
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
                r5.L$0 = r6
                r5.label = r2
                java.lang.Object r5 = r1.emit(r3, r4)
                if (r5 != r0) goto L71
            L70:
                return r0
            L71:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.C02576.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleSuggestionAction$7, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleSuggestionAction$7", f = "ConversationViewModel.kt", i = {1}, l = {906, 908}, m = "invokeSuspend", n = {"response"}, s = {"L$0"})
    static final class C02587 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ConversationUiAction $action;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02587(ConversationUiAction conversationUiAction, Continuation<? super C02587> continuation) {
            super(2, continuation);
            this.$action = conversationUiAction;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new C02587(this.$action, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0072, code lost:
        
            if (r6.this$0._uiEvent.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent.Error(com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.mappers.AppErrorMappersKt.toConversationErrorMessageRes(((com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r7).getError())), (kotlin.coroutines.Continuation) r6) == r0) goto L17;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r6 = r6.L$0
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r6 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r6
                kotlin.ResultKt.throwOnFailure(r7)
                goto L75
            L16:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1e:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L47
            L22:
                kotlin.ResultKt.throwOnFailure(r7)
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecasewrappers.SuggestionUseCases r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.access$getSuggestionUseCases$p(r7)
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion.DeleteConversationInputSuggestionUseCase r7 = r7.getDeleteSuggestion()
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiAction r1 = r6.$action
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiAction$OnDeleteSuggestion r1 = (com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiAction.OnDeleteSuggestion) r1
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.ConversationSuggestion r1 = r1.getSuggestion()
                long r4 = r1.getId()
                r1 = r6
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r6.label = r3
                java.lang.Object r7 = r7.invoke(r4, r1)
                if (r7 != r0) goto L47
                goto L74
            L47:
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r7 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r7
                boolean r1 = r7 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error
                if (r1 == 0) goto L75
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.this
                kotlinx.coroutines.flow.MutableSharedFlow r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.access$get_uiEvent$p(r1)
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent$Error r3 = new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent$Error
                r4 = r7
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Error r4 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r4
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError r4 = r4.getError()
                int r4 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.mappers.AppErrorMappersKt.toConversationErrorMessageRes(r4)
                r3.<init>(r4)
                r4 = r6
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                r6.L$0 = r7
                r6.label = r2
                java.lang.Object r6 = r1.emit(r3, r4)
                if (r6 != r0) goto L75
            L74:
                return r0
            L75:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.C02587.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final void handleDrawerAction(ConversationUiAction action) {
        Object value;
        Object value2;
        if (action instanceof ConversationUiAction.OnShowDrawer) {
            MutableStateFlow<ConversationUiState> mutableStateFlow = this._uiState;
            do {
                value2 = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value2, ConversationUiState.copy$default((ConversationUiState) value2, null, ((ConversationUiAction.OnShowDrawer) action).getDrawer(), null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, false, false, false, 0.0f, 33554429, null)));
        } else if (action instanceof ConversationUiAction.OnHideDrawer) {
            MutableStateFlow<ConversationUiState> mutableStateFlow2 = this._uiState;
            do {
                value = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value, ConversationUiState.copy$default((ConversationUiState) value, null, ConversationDrawer.None.INSTANCE, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, false, false, false, 0.0f, 33554429, null)));
        }
    }

    private final void handleWebViewAction(ConversationUiAction action) {
        if (action instanceof ConversationUiAction.OnToggleWebViewMinimization) {
            if (((ConversationUiState) this.uiState.getValue()).getActiveActionElement() instanceof ConversationActionElement.InterpretationWebView) {
                this.webViewManager.setWebViewVisibility(false);
            }
        } else if (action instanceof ConversationUiAction.OnRestoreWebView) {
            this.webViewManager.restoreView();
        } else if (action instanceof ConversationUiAction.OnMinimizeWebView) {
            this.webViewManager.onCloseAction();
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleConversationManagementAction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleConversationManagementAction$1", f = "ConversationViewModel.kt", i = {}, l = {948}, m = "invokeSuspend", n = {}, s = {})
    static final class C02451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C02451(Continuation<? super C02451> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new C02451(continuation);
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
                if (ConversationViewModel.this._uiEvent.emit(new ConversationUiEvent.Error(R.string.conversation_not_ready_error), (Continuation) this) == coroutine_suspended) {
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

    private final void handleConversationManagementAction(ConversationUiAction action, Long conversationId) {
        Object value;
        if (conversationId == null && !(action instanceof ConversationUiAction.OnSwitchConversationMode)) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C02451(null), 3, (Object) null);
            return;
        }
        if (action instanceof ConversationUiAction.OnSummarize) {
            List<ConversationMessage> conversationMessages = ((ConversationUiState) this.uiState.getValue()).getConversationMessages();
            LanguageEnum speakerLang = ((ConversationUiState) this.uiState.getValue()).getSpeakerLang();
            MutableStateFlow<ConversationUiState> mutableStateFlow = this._uiState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ConversationUiState.copy$default((ConversationUiState) value, ConversationActivity.IsSummarizing.INSTANCE, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, false, false, false, 0.0f, 33554430, null)));
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C02463(conversationId, conversationMessages, speakerLang, null), 3, (Object) null);
            return;
        }
        if (action instanceof ConversationUiAction.OnSwitchConversationMode) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C02474(action, null), 3, (Object) null);
            return;
        }
        if (action instanceof ConversationUiAction.UpdateConversationName) {
            Conversation conversation = (Conversation) this._conversationFlow.getValue();
            if (conversation != null) {
                ConversationUiAction.UpdateConversationName updateConversationName = (ConversationUiAction.UpdateConversationName) action;
                if (!StringsKt.isBlank(updateConversationName.getNewName())) {
                    BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C02485(Conversation.copy$default(conversation, 0L, updateConversationName.getNewName(), false, 0L, 13, null), null), 3, (Object) null);
                }
            }
            Unit unit = Unit.INSTANCE;
            return;
        }
        if (action instanceof ConversationUiAction.OnSetUserLanguage) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C02496(action, null), 3, (Object) null);
        } else if (action instanceof ConversationUiAction.OnSetSpeakerLanguage) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C02507(action, null), 3, (Object) null);
        } else {
            Unit unit2 = Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleConversationManagementAction$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleConversationManagementAction$3", f = "ConversationViewModel.kt", i = {1}, l = {958, 960}, m = "invokeSuspend", n = {"response"}, s = {"L$0"})
    static final class C02463 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Long $conversationId;
        final /* synthetic */ List<ConversationMessage> $messages;
        final /* synthetic */ LanguageEnum $speakerLanguage;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02463(Long l, List<ConversationMessage> list, LanguageEnum languageEnum, Continuation<? super C02463> continuation) {
            super(2, continuation);
            this.$conversationId = l;
            this.$messages = list;
            this.$speakerLanguage = languageEnum;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new C02463(this.$conversationId, this.$messages, this.$speakerLanguage, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0077, code lost:
        
            if (r30.this$0._uiEvent.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent.Error(com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.mappers.AppErrorMappersKt.toConversationErrorMessageRes(((com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r2).getError())), (kotlin.coroutines.Continuation) r30) == r1) goto L17;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r31) {
            /*
                r30 = this;
                r0 = r30
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L26
                if (r2 == r4) goto L20
                if (r2 != r3) goto L18
                java.lang.Object r1 = r0.L$0
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r1 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r1
                kotlin.ResultKt.throwOnFailure(r31)
                goto L7a
            L18:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L20:
                kotlin.ResultKt.throwOnFailure(r31)
                r2 = r31
                goto L4c
            L26:
                kotlin.ResultKt.throwOnFailure(r31)
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel r2 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecasewrappers.ConversationManagementUseCases r2 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.access$getConversationManagementUseCases$p(r2)
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsummary.GenerateAndInsertConversationSummaryUseCase r5 = r2.getSummarizeConversationMessages()
                java.lang.Long r2 = r0.$conversationId
                kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
                long r6 = r2.longValue()
                java.util.List<com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMessage> r8 = r0.$messages
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum r9 = r0.$speakerLanguage
                r10 = r0
                kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
                r0.label = r4
                java.lang.Object r2 = r5.invoke(r6, r8, r9, r10)
                if (r2 != r1) goto L4c
                goto L79
            L4c:
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r2 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r2
                boolean r4 = r2 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error
                if (r4 == 0) goto L7a
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel r4 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.this
                kotlinx.coroutines.flow.MutableSharedFlow r4 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.access$get_uiEvent$p(r4)
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent$Error r5 = new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent$Error
                r6 = r2
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Error r6 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r6
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError r6 = r6.getError()
                int r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.mappers.AppErrorMappersKt.toConversationErrorMessageRes(r6)
                r5.<init>(r6)
                r6 = r0
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
                r0.L$0 = r2
                r0.label = r3
                java.lang.Object r2 = r4.emit(r5, r6)
                if (r2 != r1) goto L7a
            L79:
                return r1
            L7a:
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel r0 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.this
                kotlinx.coroutines.flow.MutableStateFlow r0 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.access$get_uiState$p(r0)
            L80:
                java.lang.Object r1 = r0.getValue()
                r2 = r1
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiState r2 = (com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiState) r2
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationActivity$Idle r3 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationActivity.Idle.INSTANCE
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationActivity r3 = (com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationActivity) r3
                r28 = 33554430(0x1fffffe, float:9.4039537E-38)
                r29 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                r16 = 0
                r17 = 0
                r18 = 0
                r19 = 0
                r20 = 0
                r21 = 0
                r22 = 0
                r23 = 0
                r24 = 0
                r25 = 0
                r26 = 0
                r27 = 0
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiState r2 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiState.copy$default(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
                boolean r1 = r0.compareAndSet(r1, r2)
                if (r1 == 0) goto L80
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.C02463.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleConversationManagementAction$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleConversationManagementAction$4", f = "ConversationViewModel.kt", i = {1}, l = {967, 969}, m = "invokeSuspend", n = {"response"}, s = {"L$0"})
    static final class C02474 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ConversationUiAction $action;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02474(ConversationUiAction conversationUiAction, Continuation<? super C02474> continuation) {
            super(2, continuation);
            this.$action = conversationUiAction;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new C02474(this.$action, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x006e, code lost:
        
            if (r5.this$0._uiEvent.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent.Error(com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.mappers.AppErrorMappersKt.toConversationErrorMessageRes(((com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r6).getError())), (kotlin.coroutines.Continuation) r5) == r0) goto L17;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r5 = r5.L$0
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r5 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r5
                kotlin.ResultKt.throwOnFailure(r6)
                goto L71
            L16:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1e:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L43
            L22:
                kotlin.ResultKt.throwOnFailure(r6)
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecasewrappers.ConversationManagementUseCases r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.access$getConversationManagementUseCases$p(r6)
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.SetConversationModeUseCase r6 = r6.getSetModeConversationMode()
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiAction r1 = r5.$action
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiAction$OnSwitchConversationMode r1 = (com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiAction.OnSwitchConversationMode) r1
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMode r1 = r1.getMode()
                r4 = r5
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r5.label = r3
                java.lang.Object r6 = r6.invoke(r1, r4)
                if (r6 != r0) goto L43
                goto L70
            L43:
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r6 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r6
                boolean r1 = r6 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error
                if (r1 == 0) goto L71
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.this
                kotlinx.coroutines.flow.MutableSharedFlow r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.access$get_uiEvent$p(r1)
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent$Error r3 = new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent$Error
                r4 = r6
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Error r4 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r4
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError r4 = r4.getError()
                int r4 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.mappers.AppErrorMappersKt.toConversationErrorMessageRes(r4)
                r3.<init>(r4)
                r4 = r5
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
                r5.L$0 = r6
                r5.label = r2
                java.lang.Object r5 = r1.emit(r3, r4)
                if (r5 != r0) goto L71
            L70:
                return r0
            L71:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.C02474.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleConversationManagementAction$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleConversationManagementAction$5", f = "ConversationViewModel.kt", i = {1}, l = {978, 980}, m = "invokeSuspend", n = {"response"}, s = {"L$0"})
    static final class C02485 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Conversation $updatedConversation;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02485(Conversation conversation, Continuation<? super C02485> continuation) {
            super(2, continuation);
            this.$updatedConversation = conversation;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new C02485(this.$updatedConversation, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0068, code lost:
        
            if (r5.this$0._uiEvent.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent.Error(com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.mappers.AppErrorMappersKt.toConversationErrorMessageRes(((com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r6).getError())), (kotlin.coroutines.Continuation) r5) == r0) goto L17;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r5 = r5.L$0
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r5 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r5
                kotlin.ResultKt.throwOnFailure(r6)
                goto L6b
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
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecasewrappers.ConversationManagementUseCases r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.access$getConversationManagementUseCases$p(r6)
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversation.UpdateConversationUseCase r6 = r6.getUpdateConversation()
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.Conversation r1 = r5.$updatedConversation
                r4 = r5
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r5.label = r3
                java.lang.Object r6 = r6.invoke(r1, r4)
                if (r6 != r0) goto L3d
                goto L6a
            L3d:
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r6 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r6
                boolean r1 = r6 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error
                if (r1 == 0) goto L6b
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.this
                kotlinx.coroutines.flow.MutableSharedFlow r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.access$get_uiEvent$p(r1)
                com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent$Error r3 = new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent$Error
                r4 = r6
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Error r4 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r4
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError r4 = r4.getError()
                int r4 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.mappers.AppErrorMappersKt.toConversationErrorMessageRes(r4)
                r3.<init>(r4)
                r4 = r5
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
                r5.L$0 = r6
                r5.label = r2
                java.lang.Object r5 = r1.emit(r3, r4)
                if (r5 != r0) goto L6b
            L6a:
                return r0
            L6b:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel.C02485.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleConversationManagementAction$6, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleConversationManagementAction$6", f = "ConversationViewModel.kt", i = {}, l = {987}, m = "invokeSuspend", n = {}, s = {})
    static final class C02496 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ConversationUiAction $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02496(ConversationUiAction conversationUiAction, Continuation<? super C02496> continuation) {
            super(2, continuation);
            this.$action = conversationUiAction;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new C02496(this.$action, continuation);
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
                if (ConversationViewModel.this.conversationSettingsUseCases.getSetUserLanguage().invoke(((ConversationUiAction.OnSetUserLanguage) this.$action).getUserLang(), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleConversationManagementAction$7, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$handleConversationManagementAction$7", f = "ConversationViewModel.kt", i = {}, l = {992}, m = "invokeSuspend", n = {}, s = {})
    static final class C02507 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ConversationUiAction $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02507(ConversationUiAction conversationUiAction, Continuation<? super C02507> continuation) {
            super(2, continuation);
            this.$action = conversationUiAction;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new C02507(this.$action, continuation);
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
                if (ConversationViewModel.this.conversationSettingsUseCases.getSetSpeakerLanguage().invoke(((ConversationUiAction.OnSetSpeakerLanguage) this.$action).getSpeakerLang(), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final void onAction(ConversationUiAction action) throws NoWhenBranchMatchedException {
        Object value;
        Intrinsics.checkNotNullParameter(action, "action");
        Conversation conversation = (Conversation) this._conversationFlow.getValue();
        Long lValueOf = conversation != null ? Long.valueOf(conversation.getId()) : null;
        if ((action instanceof ConversationUiAction.OnInputTextChange) || (action instanceof ConversationUiAction.OnSearchQueryChange) || (action instanceof ConversationUiAction.OnClearInputText)) {
            handleInputAction(action);
            return;
        }
        if ((action instanceof ConversationUiAction.OnInterpretSpeech) || (action instanceof ConversationUiAction.OnRequestMicrophonePermissionForInterpretation) || (action instanceof ConversationUiAction.OnShowSpeakerLanguageDialog) || (action instanceof ConversationUiAction.OnSetSpeakerLanguageAndStartInterpretation) || (action instanceof ConversationUiAction.OnMicrophonePermissionGranted) || (action instanceof ConversationUiAction.OnInterpretInputText) || (action instanceof ConversationUiAction.OnInterpretScannedDocument) || (action instanceof ConversationUiAction.OnOpenDocumentScanner) || (action instanceof ConversationUiAction.OnStopInterpretationAndTranscription)) {
            handleInterpretationAction(action, lValueOf);
            return;
        }
        if ((action instanceof ConversationUiAction.OnTtsSpeakAndSaveMessage) || (action instanceof ConversationUiAction.OnTtsSpeak) || (action instanceof ConversationUiAction.OnTtsRepeat) || (action instanceof ConversationUiAction.OnTtsDrawerClose)) {
            handleTtsAction(action, lValueOf);
            return;
        }
        if (action instanceof ConversationUiAction.OnSendButtonClicked) {
            if (((ConversationUiState) this.uiState.getValue()).isCorrectionSuggestionsEnabled() && ((ConversationUiAction.OnSendButtonClicked) action).getText().length() <= 40) {
                BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C02601(action, lValueOf, null), 3, (Object) null);
                return;
            } else {
                handleTtsAction(new ConversationUiAction.OnTtsSpeakAndSaveMessage(((ConversationUiAction.OnSendButtonClicked) action).getText()), lValueOf);
                return;
            }
        }
        if (action instanceof ConversationUiAction.OnCorrectionSuggestionChosenForTts) {
            MutableStateFlow<ConversationUiState> mutableStateFlow = this._uiState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ConversationUiState.copy$default((ConversationUiState) value, null, ConversationDrawer.None.INSTANCE, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, CollectionsKt.emptyList(), null, null, false, false, false, false, 0.0f, 33423357, null)));
            handleTtsAction(new ConversationUiAction.OnTtsSpeakAndSaveMessage(((ConversationUiAction.OnCorrectionSuggestionChosenForTts) action).getText()), lValueOf);
            return;
        }
        if (action instanceof ConversationUiAction.OnBubbleLongPress) {
            handleMessageInteraction((ConversationUiAction.OnBubbleLongPress) action);
            return;
        }
        if ((action instanceof ConversationUiAction.OnCorrectionSuggestionSelect) || (action instanceof ConversationUiAction.OnShowCorrectionSuggestionSaveDialogBox) || (action instanceof ConversationUiAction.OnCorrectionSuggestionSaveDismiss) || (action instanceof ConversationUiAction.OnSaveCorrectionSuggestion) || (action instanceof ConversationUiAction.OnDeleteCategory) || (action instanceof ConversationUiAction.OnDeleteSuggestion) || (action instanceof ConversationUiAction.OnToggleInputSuggestion)) {
            handleSuggestionAction(action);
            return;
        }
        if ((action instanceof ConversationUiAction.OnShowDrawer) || (action instanceof ConversationUiAction.OnHideDrawer)) {
            handleDrawerAction(action);
            return;
        }
        if ((action instanceof ConversationUiAction.OnToggleWebViewMinimization) || (action instanceof ConversationUiAction.OnMinimizeWebView) || (action instanceof ConversationUiAction.OnRestoreWebView)) {
            handleWebViewAction(action);
            return;
        }
        if (!(action instanceof ConversationUiAction.OnSummarize) && !(action instanceof ConversationUiAction.OnSwitchConversationMode) && !(action instanceof ConversationUiAction.OnSetSpeakerLanguage) && !(action instanceof ConversationUiAction.OnSetUserLanguage) && !(action instanceof ConversationUiAction.UpdateConversationName)) {
            throw new NoWhenBranchMatchedException();
        }
        handleConversationManagementAction(action, lValueOf);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$onAction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$onAction$1", f = "ConversationViewModel.kt", i = {}, l = {1029}, m = "invokeSuspend", n = {}, s = {})
    static final class C02601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ConversationUiAction $action;
        final /* synthetic */ Long $conversationId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02601(ConversationUiAction conversationUiAction, Long l, Continuation<? super C02601> continuation) {
            super(2, continuation);
            this.$action = conversationUiAction;
            this.$conversationId = l;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationViewModel.this.new C02601(this.$action, this.$conversationId, continuation);
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
                if (ConversationViewModel.this.fetchSuggestionsForSend(((ConversationUiAction.OnSendButtonClicked) this.$action).getText(), ((ConversationUiState) ConversationViewModel.this.getUiState().getValue()).getUserLang(), this.$conversationId, (Continuation) this) == coroutine_suspended) {
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
