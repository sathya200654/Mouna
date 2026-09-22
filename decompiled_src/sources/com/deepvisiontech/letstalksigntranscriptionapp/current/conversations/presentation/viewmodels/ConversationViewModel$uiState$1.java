package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import android.speech.tts.Voice;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.mappers.LanguageMapper;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationServiceState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.Conversation;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMessage;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMode;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewState;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiState;", "uiState", "messages", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;", "<destruct>", "Lkotlin/Pair;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSuggestionsState;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationScreenSettingsState;", "conversation", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/Conversation;", "serviceState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ServiceState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$uiState$1", f = "ConversationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ConversationViewModel$uiState$1 extends SuspendLambda implements Function6<ConversationUiState, List<? extends ConversationMessage>, Pair<? extends ConversationSuggestionsState, ? extends ConversationScreenSettingsState>, Conversation, ServiceState, Continuation<? super ConversationUiState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    /* synthetic */ Object L$3;
    /* synthetic */ Object L$4;
    int label;

    ConversationViewModel$uiState$1(Continuation<? super ConversationViewModel$uiState$1> continuation) {
        super(6, continuation);
    }

    public final Object invoke(ConversationUiState conversationUiState, List<ConversationMessage> list, Pair<ConversationSuggestionsState, ConversationScreenSettingsState> pair, Conversation conversation, ServiceState serviceState, Continuation<? super ConversationUiState> continuation) {
        ConversationViewModel$uiState$1 conversationViewModel$uiState$1 = new ConversationViewModel$uiState$1(continuation);
        conversationViewModel$uiState$1.L$0 = conversationUiState;
        conversationViewModel$uiState$1.L$1 = list;
        conversationViewModel$uiState$1.L$2 = pair;
        conversationViewModel$uiState$1.L$3 = conversation;
        conversationViewModel$uiState$1.L$4 = serviceState;
        return conversationViewModel$uiState$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String activeText;
        ConversationActivity.IsInitializing activity;
        Object next;
        ConversationActionElement.InterpretationWebView interpretationWebView;
        ConversationUiState conversationUiState = (ConversationUiState) this.L$0;
        List list = (List) this.L$1;
        Pair pair = (Pair) this.L$2;
        Conversation conversation = (Conversation) this.L$3;
        ServiceState serviceState = (ServiceState) this.L$4;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ConversationSuggestionsState conversationSuggestionsState = (ConversationSuggestionsState) pair.component1();
        ConversationScreenSettingsState conversationScreenSettingsState = (ConversationScreenSettingsState) pair.component2();
        if (serviceState.getSpeech() instanceof ConversationServiceState.Listening) {
            activeText = ((ConversationServiceState.Listening) serviceState.getSpeech()).getActiveText();
        } else {
            activeText = "";
        }
        String str = activeText;
        if (serviceState.getWeb() instanceof WebViewState.IsInterpretingConversationMessage) {
            activity = new ConversationActivity.IsInterpreting(((WebViewState.IsInterpretingConversationMessage) serviceState.getWeb()).getCurrentlyInterpreting());
        } else if (serviceState.getWeb() instanceof WebViewState.IsLoading) {
            activity = ConversationActivity.IsWebViewLoading.INSTANCE;
        } else if ((serviceState.getSpeech() instanceof ConversationServiceState.Initializing) || (serviceState.getSpeech() instanceof ConversationServiceState.Starting) || (serviceState.getSpeech() instanceof ConversationServiceState.Queued)) {
            activity = ConversationActivity.IsInitializing.INSTANCE;
        } else if (serviceState.getSpeech() instanceof ConversationServiceState.Listening) {
            activity = ConversationActivity.IsTranscribing.INSTANCE;
        } else if (serviceState.getTts().isSpeaking() || serviceState.getTts().isSynthesizing()) {
            activity = ConversationActivity.IsSpeaking.INSTANCE;
        } else {
            activity = ConversationActivity.Idle.INSTANCE;
        }
        if (!Intrinsics.areEqual(conversationUiState.getActivity(), ConversationActivity.Idle.INSTANCE)) {
            activity = conversationUiState.getActivity();
        }
        Iterator<T> it = serviceState.getTts().getVoices().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((Voice) next).getName(), conversationScreenSettingsState.getSelectedVoiceId()));
        Voice voice = (Voice) next;
        if (Intrinsics.areEqual(activity, ConversationActivity.IsSpeaking.INSTANCE)) {
            if (conversationUiState.isLanguageAnnouncementPopUpVisible() || conversationUiState.isLanguageSelectionDialogVisible()) {
                interpretationWebView = new ConversationActionElement.InterpretationWebView(serviceState.getWeb() instanceof WebViewState.Minimized);
            } else {
                interpretationWebView = ConversationActionElement.TextToSpeechDrawer.INSTANCE;
            }
        } else if (conversationUiState.getActiveActionElement() instanceof ConversationActionElement.TextToSpeechDrawer) {
            interpretationWebView = conversationUiState.getActiveActionElement();
        } else {
            interpretationWebView = new ConversationActionElement.InterpretationWebView(serviceState.getWeb() instanceof WebViewState.Minimized);
        }
        ConversationActionElement conversationActionElement = interpretationWebView;
        boolean z = (serviceState.getSpeech() instanceof ConversationServiceState.Listening) && (serviceState.getWeb() instanceof WebViewState.IsInterpretingConversationMessage) && conversationScreenSettingsState.getConversationMode() == ConversationMode.MEETING;
        LanguageEnum languageEnum = LanguageMapper.INSTANCE.toLanguageEnum(serviceState.getTts().getLastSpokenTextLanguage());
        ConversationDrawer activeDrawer = conversationUiState.getActiveDrawer();
        ConversationMode conversationMode = conversationScreenSettingsState.getConversationMode();
        LanguageEnum userLang = conversationScreenSettingsState.getUserLang();
        LanguageEnum speakerLang = conversationScreenSettingsState.getSpeakerLang();
        String inputText = conversationUiState.getInputText();
        String lastSpokenText = serviceState.getTts().getLastSpokenText();
        String searchQuery = conversationUiState.getSearchQuery();
        boolean zIsLanguageSelectionDialogVisible = conversationUiState.isLanguageSelectionDialogVisible();
        boolean zIsLanguageAnnouncementPopUpVisible = conversationUiState.isLanguageAnnouncementPopUpVisible();
        return new ConversationUiState(activity, activeDrawer, conversationActionElement, conversation, list, conversationMode, userLang, speakerLang, lastSpokenText, languageEnum, voice, inputText, null, searchQuery, conversationSuggestionsState.isCorrectionSuggestionsEnabled(), str, conversationUiState.getSaveInputSuggestionDialogState(), conversationUiState.getCorrectionSuggestions(), conversationSuggestionsState.getConversationSuggestions(), conversationUiState.getConversationSuggestionsNetwork(), conversationScreenSettingsState.isSpeakerDetectionEnabled(), zIsLanguageAnnouncementPopUpVisible, zIsLanguageSelectionDialogVisible, z, conversationScreenSettingsState.getTranscriptFontSize(), 4096, null);
    }
}
