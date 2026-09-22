package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import android.speech.tts.Voice;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.Conversation;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMessage;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMode;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.MessageInputType;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.ConversationSuggestion;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.CorrectionSuggestion;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.SuggestionCategory;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import io.grpc.internal.AbstractStream;
import io.grpc.internal.GrpcUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ConversationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u009d\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001f\u0012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u000b\u0012\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u000b\u0012\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u000b\u0012\b\b\u0002\u0010%\u001a\u00020\u001c\u0012\b\b\u0002\u0010&\u001a\u00020\u001c\u0012\b\b\u0002\u0010'\u001a\u00020\u001c\u0012\b\b\u0002\u0010(\u001a\u00020\u001c\u0012\b\b\u0002\u0010)\u001a\u00020*¢\u0006\u0004\b+\u0010,J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\t\u0010a\u001a\u00020\u0005HÆ\u0003J\t\u0010b\u001a\u00020\u0007HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000f\u0010d\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\t\u0010e\u001a\u00020\u000eHÆ\u0003J\t\u0010f\u001a\u00020\u0010HÆ\u0003J\t\u0010g\u001a\u00020\u0010HÆ\u0003J\t\u0010h\u001a\u00020\u0013HÆ\u0003J\t\u0010i\u001a\u00020\u0010HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\t\u0010k\u001a\u00020\u0013HÆ\u0003J\t\u0010l\u001a\u00020\u0019HÆ\u0003J\t\u0010m\u001a\u00020\u0013HÆ\u0003J\t\u0010n\u001a\u00020\u001cHÆ\u0003J\t\u0010o\u001a\u00020\u0013HÆ\u0003J\t\u0010p\u001a\u00020\u001fHÆ\u0003J\u000f\u0010q\u001a\b\u0012\u0004\u0012\u00020!0\u000bHÆ\u0003J\u000f\u0010r\u001a\b\u0012\u0004\u0012\u00020#0\u000bHÆ\u0003J\u000f\u0010s\u001a\b\u0012\u0004\u0012\u00020#0\u000bHÆ\u0003J\t\u0010t\u001a\u00020\u001cHÆ\u0003J\t\u0010u\u001a\u00020\u001cHÆ\u0003J\t\u0010v\u001a\u00020\u001cHÆ\u0003J\t\u0010w\u001a\u00020\u001cHÆ\u0003J\t\u0010x\u001a\u00020*HÆ\u0003J\u009f\u0002\u0010y\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00132\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00132\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u000b2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u000b2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u000b2\b\b\u0002\u0010%\u001a\u00020\u001c2\b\b\u0002\u0010&\u001a\u00020\u001c2\b\b\u0002\u0010'\u001a\u00020\u001c2\b\b\u0002\u0010(\u001a\u00020\u001c2\b\b\u0002\u0010)\u001a\u00020*HÆ\u0001J\u0013\u0010z\u001a\u00020\u001c2\b\u0010{\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010|\u001a\u00020}HÖ\u0001J\t\u0010~\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b;\u0010:R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010\u0014\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b>\u0010:R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0011\u0010\u0017\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bA\u0010=R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010\u001a\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bD\u0010=R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010ER\u0011\u0010\u001d\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bF\u0010=R\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u000b¢\u0006\b\n\u0000\u001a\u0004\bI\u00106R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u000b¢\u0006\b\n\u0000\u001a\u0004\bJ\u00106R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u000b¢\u0006\b\n\u0000\u001a\u0004\bK\u00106R\u0011\u0010%\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b%\u0010ER\u0011\u0010&\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b&\u0010ER\u0011\u0010'\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b'\u0010ER\u0011\u0010(\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b(\u0010ER\u0011\u0010)\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u0010N\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\bN\u0010ER\u0011\u0010O\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\bO\u0010ER\u0011\u0010P\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\bP\u0010ER\u0011\u0010Q\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\bQ\u0010ER\u0011\u0010R\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\bS\u0010ER\u0011\u0010T\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\bT\u0010ER\u0011\u0010U\u001a\u00020V8F¢\u0006\u0006\u001a\u0004\bW\u0010XR\u0011\u0010Y\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\bY\u0010ER\u0011\u0010Z\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\bZ\u0010ER\u0011\u0010[\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b[\u0010ER\u0017\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0\u000b8F¢\u0006\u0006\u001a\u0004\b^\u00106R\u0011\u0010_\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b_\u0010E¨\u0006\u007f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiState;", "", "activity", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity;", "activeDrawer", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationDrawer;", "activeActionElement", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActionElement;", "conversation", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/Conversation;", "conversationMessages", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;", "conversationMode", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;", "userLang", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "speakerLang", "ttsText", "", "ttsLanguage", "ttsVoice", "Landroid/speech/tts/Voice;", "inputText", "activeInputType", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/MessageInputType;", "searchQuery", "isCorrectionSuggestionsEnabled", "", "partialText", "saveInputSuggestionDialogState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/SaveInputSuggestionDialogState;", "correctionSuggestions", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/CorrectionSuggestion;", "conversationSuggestions", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/ConversationSuggestion;", "conversationSuggestionsNetwork", "isSpeakerDetectionEnabled", "isLanguageAnnouncementPopUpVisible", "isLanguageSelectionDialogVisible", "isListeningEllipsisVisible", "transcriptFontSize", "", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationDrawer;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActionElement;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/Conversation;Ljava/util/List;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Ljava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Landroid/speech/tts/Voice;Ljava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/MessageInputType;Ljava/lang/String;ZLjava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/SaveInputSuggestionDialogState;Ljava/util/List;Ljava/util/List;Ljava/util/List;ZZZZF)V", "getActivity", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity;", "getActiveDrawer", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationDrawer;", "getActiveActionElement", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActionElement;", "getConversation", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/Conversation;", "getConversationMessages", "()Ljava/util/List;", "getConversationMode", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;", "getUserLang", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "getSpeakerLang", "getTtsText", "()Ljava/lang/String;", "getTtsLanguage", "getTtsVoice", "()Landroid/speech/tts/Voice;", "getInputText", "getActiveInputType", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/MessageInputType;", "getSearchQuery", "()Z", "getPartialText", "getSaveInputSuggestionDialogState", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/SaveInputSuggestionDialogState;", "getCorrectionSuggestions", "getConversationSuggestions", "getConversationSuggestionsNetwork", "getTranscriptFontSize", "()F", "isClearTextButtonVisible", "isSendButtonEnabled", "isPartialTextVisible", "isInterpretButtonEnabled", "showInterpretationTranscriptionStopButton", "getShowInterpretationTranscriptionStopButton", "isInputSuggestionEnabled", "inputSource", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/InputSource;", "getInputSource", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/InputSource;", "isInputBottomDrawerButtonEnabled", "isSummarizeButtonEnabled", "isConfigBottomDrawerButtonEnabled", "conversationSuggestionCategories", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/SuggestionCategory;", "getConversationSuggestionCategories", "isProcessingIndicatorVisible", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ConversationUiState {
    public static final int $stable = 8;
    private final ConversationActionElement activeActionElement;
    private final ConversationDrawer activeDrawer;
    private final MessageInputType activeInputType;
    private final ConversationActivity activity;
    private final Conversation conversation;
    private final List<ConversationMessage> conversationMessages;
    private final ConversationMode conversationMode;
    private final List<ConversationSuggestion> conversationSuggestions;
    private final List<ConversationSuggestion> conversationSuggestionsNetwork;
    private final List<CorrectionSuggestion> correctionSuggestions;
    private final String inputText;
    private final boolean isCorrectionSuggestionsEnabled;
    private final boolean isLanguageAnnouncementPopUpVisible;
    private final boolean isLanguageSelectionDialogVisible;
    private final boolean isListeningEllipsisVisible;
    private final boolean isSpeakerDetectionEnabled;
    private final String partialText;
    private final SaveInputSuggestionDialogState saveInputSuggestionDialogState;
    private final String searchQuery;
    private final LanguageEnum speakerLang;
    private final float transcriptFontSize;
    private final LanguageEnum ttsLanguage;
    private final String ttsText;
    private final Voice ttsVoice;
    private final LanguageEnum userLang;

    public ConversationUiState() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, false, false, false, 0.0f, 33554431, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConversationUiState copy$default(ConversationUiState conversationUiState, ConversationActivity conversationActivity, ConversationDrawer conversationDrawer, ConversationActionElement conversationActionElement, Conversation conversation, List list, ConversationMode conversationMode, LanguageEnum languageEnum, LanguageEnum languageEnum2, String str, LanguageEnum languageEnum3, Voice voice, String str2, MessageInputType messageInputType, String str3, boolean z, String str4, SaveInputSuggestionDialogState saveInputSuggestionDialogState, List list2, List list3, List list4, boolean z2, boolean z3, boolean z4, boolean z5, float f, int i, Object obj) {
        float f2;
        boolean z6;
        ConversationActivity conversationActivity2 = (i & 1) != 0 ? conversationUiState.activity : conversationActivity;
        ConversationDrawer conversationDrawer2 = (i & 2) != 0 ? conversationUiState.activeDrawer : conversationDrawer;
        ConversationActionElement conversationActionElement2 = (i & 4) != 0 ? conversationUiState.activeActionElement : conversationActionElement;
        Conversation conversation2 = (i & 8) != 0 ? conversationUiState.conversation : conversation;
        List list5 = (i & 16) != 0 ? conversationUiState.conversationMessages : list;
        ConversationMode conversationMode2 = (i & 32) != 0 ? conversationUiState.conversationMode : conversationMode;
        LanguageEnum languageEnum4 = (i & 64) != 0 ? conversationUiState.userLang : languageEnum;
        LanguageEnum languageEnum5 = (i & 128) != 0 ? conversationUiState.speakerLang : languageEnum2;
        String str5 = (i & 256) != 0 ? conversationUiState.ttsText : str;
        LanguageEnum languageEnum6 = (i & 512) != 0 ? conversationUiState.ttsLanguage : languageEnum3;
        Voice voice2 = (i & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0 ? conversationUiState.ttsVoice : voice;
        String str6 = (i & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 ? conversationUiState.inputText : str2;
        MessageInputType messageInputType2 = (i & 4096) != 0 ? conversationUiState.activeInputType : messageInputType;
        String str7 = (i & 8192) != 0 ? conversationUiState.searchQuery : str3;
        ConversationActivity conversationActivity3 = conversationActivity2;
        boolean z7 = (i & 16384) != 0 ? conversationUiState.isCorrectionSuggestionsEnabled : z;
        String str8 = (i & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? conversationUiState.partialText : str4;
        SaveInputSuggestionDialogState saveInputSuggestionDialogState2 = (i & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? conversationUiState.saveInputSuggestionDialogState : saveInputSuggestionDialogState;
        List list6 = (i & 131072) != 0 ? conversationUiState.correctionSuggestions : list2;
        List list7 = (i & 262144) != 0 ? conversationUiState.conversationSuggestions : list3;
        List list8 = (i & 524288) != 0 ? conversationUiState.conversationSuggestionsNetwork : list4;
        boolean z8 = (i & 1048576) != 0 ? conversationUiState.isSpeakerDetectionEnabled : z2;
        boolean z9 = (i & 2097152) != 0 ? conversationUiState.isLanguageAnnouncementPopUpVisible : z3;
        boolean z10 = (i & GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE) != 0 ? conversationUiState.isLanguageSelectionDialogVisible : z4;
        boolean z11 = (i & 8388608) != 0 ? conversationUiState.isListeningEllipsisVisible : z5;
        if ((i & 16777216) != 0) {
            z6 = z11;
            f2 = conversationUiState.transcriptFontSize;
        } else {
            f2 = f;
            z6 = z11;
        }
        return conversationUiState.copy(conversationActivity3, conversationDrawer2, conversationActionElement2, conversation2, list5, conversationMode2, languageEnum4, languageEnum5, str5, languageEnum6, voice2, str6, messageInputType2, str7, z7, str8, saveInputSuggestionDialogState2, list6, list7, list8, z8, z9, z10, z6, f2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ConversationActivity getActivity() {
        return this.activity;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final LanguageEnum getTtsLanguage() {
        return this.ttsLanguage;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Voice getTtsVoice() {
        return this.ttsVoice;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getInputText() {
        return this.inputText;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final MessageInputType getActiveInputType() {
        return this.activeInputType;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getSearchQuery() {
        return this.searchQuery;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final boolean getIsCorrectionSuggestionsEnabled() {
        return this.isCorrectionSuggestionsEnabled;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getPartialText() {
        return this.partialText;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final SaveInputSuggestionDialogState getSaveInputSuggestionDialogState() {
        return this.saveInputSuggestionDialogState;
    }

    public final List<CorrectionSuggestion> component18() {
        return this.correctionSuggestions;
    }

    public final List<ConversationSuggestion> component19() {
        return this.conversationSuggestions;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ConversationDrawer getActiveDrawer() {
        return this.activeDrawer;
    }

    public final List<ConversationSuggestion> component20() {
        return this.conversationSuggestionsNetwork;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final boolean getIsSpeakerDetectionEnabled() {
        return this.isSpeakerDetectionEnabled;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final boolean getIsLanguageAnnouncementPopUpVisible() {
        return this.isLanguageAnnouncementPopUpVisible;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final boolean getIsLanguageSelectionDialogVisible() {
        return this.isLanguageSelectionDialogVisible;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final boolean getIsListeningEllipsisVisible() {
        return this.isListeningEllipsisVisible;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final float getTranscriptFontSize() {
        return this.transcriptFontSize;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ConversationActionElement getActiveActionElement() {
        return this.activeActionElement;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Conversation getConversation() {
        return this.conversation;
    }

    public final List<ConversationMessage> component5() {
        return this.conversationMessages;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ConversationMode getConversationMode() {
        return this.conversationMode;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final LanguageEnum getUserLang() {
        return this.userLang;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final LanguageEnum getSpeakerLang() {
        return this.speakerLang;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getTtsText() {
        return this.ttsText;
    }

    public final ConversationUiState copy(ConversationActivity activity, ConversationDrawer activeDrawer, ConversationActionElement activeActionElement, Conversation conversation, List<ConversationMessage> conversationMessages, ConversationMode conversationMode, LanguageEnum userLang, LanguageEnum speakerLang, String ttsText, LanguageEnum ttsLanguage, Voice ttsVoice, String inputText, MessageInputType activeInputType, String searchQuery, boolean isCorrectionSuggestionsEnabled, String partialText, SaveInputSuggestionDialogState saveInputSuggestionDialogState, List<CorrectionSuggestion> correctionSuggestions, List<ConversationSuggestion> conversationSuggestions, List<ConversationSuggestion> conversationSuggestionsNetwork, boolean isSpeakerDetectionEnabled, boolean isLanguageAnnouncementPopUpVisible, boolean isLanguageSelectionDialogVisible, boolean isListeningEllipsisVisible, float transcriptFontSize) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(activeDrawer, "activeDrawer");
        Intrinsics.checkNotNullParameter(activeActionElement, "activeActionElement");
        Intrinsics.checkNotNullParameter(conversationMessages, "conversationMessages");
        Intrinsics.checkNotNullParameter(conversationMode, "conversationMode");
        Intrinsics.checkNotNullParameter(userLang, "userLang");
        Intrinsics.checkNotNullParameter(speakerLang, "speakerLang");
        Intrinsics.checkNotNullParameter(ttsText, "ttsText");
        Intrinsics.checkNotNullParameter(ttsLanguage, "ttsLanguage");
        Intrinsics.checkNotNullParameter(inputText, "inputText");
        Intrinsics.checkNotNullParameter(activeInputType, "activeInputType");
        Intrinsics.checkNotNullParameter(searchQuery, "searchQuery");
        Intrinsics.checkNotNullParameter(partialText, "partialText");
        Intrinsics.checkNotNullParameter(saveInputSuggestionDialogState, "saveInputSuggestionDialogState");
        Intrinsics.checkNotNullParameter(correctionSuggestions, "correctionSuggestions");
        Intrinsics.checkNotNullParameter(conversationSuggestions, "conversationSuggestions");
        Intrinsics.checkNotNullParameter(conversationSuggestionsNetwork, "conversationSuggestionsNetwork");
        return new ConversationUiState(activity, activeDrawer, activeActionElement, conversation, conversationMessages, conversationMode, userLang, speakerLang, ttsText, ttsLanguage, ttsVoice, inputText, activeInputType, searchQuery, isCorrectionSuggestionsEnabled, partialText, saveInputSuggestionDialogState, correctionSuggestions, conversationSuggestions, conversationSuggestionsNetwork, isSpeakerDetectionEnabled, isLanguageAnnouncementPopUpVisible, isLanguageSelectionDialogVisible, isListeningEllipsisVisible, transcriptFontSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationUiState)) {
            return false;
        }
        ConversationUiState conversationUiState = (ConversationUiState) other;
        return Intrinsics.areEqual(this.activity, conversationUiState.activity) && Intrinsics.areEqual(this.activeDrawer, conversationUiState.activeDrawer) && Intrinsics.areEqual(this.activeActionElement, conversationUiState.activeActionElement) && Intrinsics.areEqual(this.conversation, conversationUiState.conversation) && Intrinsics.areEqual(this.conversationMessages, conversationUiState.conversationMessages) && this.conversationMode == conversationUiState.conversationMode && this.userLang == conversationUiState.userLang && this.speakerLang == conversationUiState.speakerLang && Intrinsics.areEqual(this.ttsText, conversationUiState.ttsText) && this.ttsLanguage == conversationUiState.ttsLanguage && Intrinsics.areEqual(this.ttsVoice, conversationUiState.ttsVoice) && Intrinsics.areEqual(this.inputText, conversationUiState.inputText) && this.activeInputType == conversationUiState.activeInputType && Intrinsics.areEqual(this.searchQuery, conversationUiState.searchQuery) && this.isCorrectionSuggestionsEnabled == conversationUiState.isCorrectionSuggestionsEnabled && Intrinsics.areEqual(this.partialText, conversationUiState.partialText) && Intrinsics.areEqual(this.saveInputSuggestionDialogState, conversationUiState.saveInputSuggestionDialogState) && Intrinsics.areEqual(this.correctionSuggestions, conversationUiState.correctionSuggestions) && Intrinsics.areEqual(this.conversationSuggestions, conversationUiState.conversationSuggestions) && Intrinsics.areEqual(this.conversationSuggestionsNetwork, conversationUiState.conversationSuggestionsNetwork) && this.isSpeakerDetectionEnabled == conversationUiState.isSpeakerDetectionEnabled && this.isLanguageAnnouncementPopUpVisible == conversationUiState.isLanguageAnnouncementPopUpVisible && this.isLanguageSelectionDialogVisible == conversationUiState.isLanguageSelectionDialogVisible && this.isListeningEllipsisVisible == conversationUiState.isListeningEllipsisVisible && Float.compare(this.transcriptFontSize, conversationUiState.transcriptFontSize) == 0;
    }

    public int hashCode() {
        int iHashCode = ((((this.activity.hashCode() * 31) + this.activeDrawer.hashCode()) * 31) + this.activeActionElement.hashCode()) * 31;
        Conversation conversation = this.conversation;
        int iHashCode2 = (((((((((((((iHashCode + (conversation == null ? 0 : conversation.hashCode())) * 31) + this.conversationMessages.hashCode()) * 31) + this.conversationMode.hashCode()) * 31) + this.userLang.hashCode()) * 31) + this.speakerLang.hashCode()) * 31) + this.ttsText.hashCode()) * 31) + this.ttsLanguage.hashCode()) * 31;
        Voice voice = this.ttsVoice;
        return ((((((((((((((((((((((((((((iHashCode2 + (voice != null ? voice.hashCode() : 0)) * 31) + this.inputText.hashCode()) * 31) + this.activeInputType.hashCode()) * 31) + this.searchQuery.hashCode()) * 31) + Boolean.hashCode(this.isCorrectionSuggestionsEnabled)) * 31) + this.partialText.hashCode()) * 31) + this.saveInputSuggestionDialogState.hashCode()) * 31) + this.correctionSuggestions.hashCode()) * 31) + this.conversationSuggestions.hashCode()) * 31) + this.conversationSuggestionsNetwork.hashCode()) * 31) + Boolean.hashCode(this.isSpeakerDetectionEnabled)) * 31) + Boolean.hashCode(this.isLanguageAnnouncementPopUpVisible)) * 31) + Boolean.hashCode(this.isLanguageSelectionDialogVisible)) * 31) + Boolean.hashCode(this.isListeningEllipsisVisible)) * 31) + Float.hashCode(this.transcriptFontSize);
    }

    public String toString() {
        return "ConversationUiState(activity=" + this.activity + ", activeDrawer=" + this.activeDrawer + ", activeActionElement=" + this.activeActionElement + ", conversation=" + this.conversation + ", conversationMessages=" + this.conversationMessages + ", conversationMode=" + this.conversationMode + ", userLang=" + this.userLang + ", speakerLang=" + this.speakerLang + ", ttsText=" + this.ttsText + ", ttsLanguage=" + this.ttsLanguage + ", ttsVoice=" + this.ttsVoice + ", inputText=" + this.inputText + ", activeInputType=" + this.activeInputType + ", searchQuery=" + this.searchQuery + ", isCorrectionSuggestionsEnabled=" + this.isCorrectionSuggestionsEnabled + ", partialText=" + this.partialText + ", saveInputSuggestionDialogState=" + this.saveInputSuggestionDialogState + ", correctionSuggestions=" + this.correctionSuggestions + ", conversationSuggestions=" + this.conversationSuggestions + ", conversationSuggestionsNetwork=" + this.conversationSuggestionsNetwork + ", isSpeakerDetectionEnabled=" + this.isSpeakerDetectionEnabled + ", isLanguageAnnouncementPopUpVisible=" + this.isLanguageAnnouncementPopUpVisible + ", isLanguageSelectionDialogVisible=" + this.isLanguageSelectionDialogVisible + ", isListeningEllipsisVisible=" + this.isListeningEllipsisVisible + ", transcriptFontSize=" + this.transcriptFontSize + ")";
    }

    public ConversationUiState(ConversationActivity conversationActivity, ConversationDrawer conversationDrawer, ConversationActionElement conversationActionElement, Conversation conversation, List<ConversationMessage> list, ConversationMode conversationMode, LanguageEnum languageEnum, LanguageEnum languageEnum2, String str, LanguageEnum languageEnum3, Voice voice, String str2, MessageInputType messageInputType, String str3, boolean z, String str4, SaveInputSuggestionDialogState saveInputSuggestionDialogState, List<CorrectionSuggestion> list2, List<ConversationSuggestion> list3, List<ConversationSuggestion> list4, boolean z2, boolean z3, boolean z4, boolean z5, float f) {
        Intrinsics.checkNotNullParameter(conversationActivity, "activity");
        Intrinsics.checkNotNullParameter(conversationDrawer, "activeDrawer");
        Intrinsics.checkNotNullParameter(conversationActionElement, "activeActionElement");
        Intrinsics.checkNotNullParameter(list, "conversationMessages");
        Intrinsics.checkNotNullParameter(conversationMode, "conversationMode");
        Intrinsics.checkNotNullParameter(languageEnum, "userLang");
        Intrinsics.checkNotNullParameter(languageEnum2, "speakerLang");
        Intrinsics.checkNotNullParameter(str, "ttsText");
        Intrinsics.checkNotNullParameter(languageEnum3, "ttsLanguage");
        Intrinsics.checkNotNullParameter(str2, "inputText");
        Intrinsics.checkNotNullParameter(messageInputType, "activeInputType");
        Intrinsics.checkNotNullParameter(str3, "searchQuery");
        Intrinsics.checkNotNullParameter(str4, "partialText");
        Intrinsics.checkNotNullParameter(saveInputSuggestionDialogState, "saveInputSuggestionDialogState");
        Intrinsics.checkNotNullParameter(list2, "correctionSuggestions");
        Intrinsics.checkNotNullParameter(list3, "conversationSuggestions");
        Intrinsics.checkNotNullParameter(list4, "conversationSuggestionsNetwork");
        this.activity = conversationActivity;
        this.activeDrawer = conversationDrawer;
        this.activeActionElement = conversationActionElement;
        this.conversation = conversation;
        this.conversationMessages = list;
        this.conversationMode = conversationMode;
        this.userLang = languageEnum;
        this.speakerLang = languageEnum2;
        this.ttsText = str;
        this.ttsLanguage = languageEnum3;
        this.ttsVoice = voice;
        this.inputText = str2;
        this.activeInputType = messageInputType;
        this.searchQuery = str3;
        this.isCorrectionSuggestionsEnabled = z;
        this.partialText = str4;
        this.saveInputSuggestionDialogState = saveInputSuggestionDialogState;
        this.correctionSuggestions = list2;
        this.conversationSuggestions = list3;
        this.conversationSuggestionsNetwork = list4;
        this.isSpeakerDetectionEnabled = z2;
        this.isLanguageAnnouncementPopUpVisible = z3;
        this.isLanguageSelectionDialogVisible = z4;
        this.isListeningEllipsisVisible = z5;
        this.transcriptFontSize = f;
    }

    public /* synthetic */ ConversationUiState(ConversationActivity conversationActivity, ConversationDrawer conversationDrawer, ConversationActionElement conversationActionElement, Conversation conversation, List list, ConversationMode conversationMode, LanguageEnum languageEnum, LanguageEnum languageEnum2, String str, LanguageEnum languageEnum3, Voice voice, String str2, MessageInputType messageInputType, String str3, boolean z, String str4, SaveInputSuggestionDialogState saveInputSuggestionDialogState, List list2, List list3, List list4, boolean z2, boolean z3, boolean z4, boolean z5, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ConversationActivity.Idle.INSTANCE : conversationActivity, (i & 2) != 0 ? ConversationDrawer.None.INSTANCE : conversationDrawer, (i & 4) != 0 ? new ConversationActionElement.InterpretationWebView(false) : conversationActionElement, (i & 8) != 0 ? null : conversation, (i & 16) != 0 ? CollectionsKt.emptyList() : list, (i & 32) != 0 ? ConversationMode.ONE_TO_ONE : conversationMode, (i & 64) != 0 ? LanguageEnum.ENGLISH : languageEnum, (i & 128) != 0 ? LanguageEnum.ENGLISH : languageEnum2, (i & 256) != 0 ? "" : str, (i & 512) != 0 ? LanguageEnum.ENGLISH : languageEnum3, (i & UserMetadata.MAX_ATTRIBUTE_SIZE) == 0 ? voice : null, (i & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 ? "" : str2, (i & 4096) != 0 ? MessageInputType.TYPED : messageInputType, (i & 8192) != 0 ? "" : str3, (i & 16384) != 0 ? false : z, (i & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) == 0 ? str4 : "", (i & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? SaveInputSuggestionDialogState.Hidden.INSTANCE : saveInputSuggestionDialogState, (i & 131072) != 0 ? CollectionsKt.emptyList() : list2, (i & 262144) != 0 ? CollectionsKt.emptyList() : list3, (i & 524288) != 0 ? CollectionsKt.emptyList() : list4, (i & 1048576) != 0 ? false : z2, (i & 2097152) != 0 ? false : z3, (i & GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE) != 0 ? false : z4, (i & 8388608) != 0 ? false : z5, (i & 16777216) != 0 ? 16.0f : f);
    }

    public final ConversationActivity getActivity() {
        return this.activity;
    }

    public final ConversationDrawer getActiveDrawer() {
        return this.activeDrawer;
    }

    public final ConversationActionElement getActiveActionElement() {
        return this.activeActionElement;
    }

    public final Conversation getConversation() {
        return this.conversation;
    }

    public final List<ConversationMessage> getConversationMessages() {
        return this.conversationMessages;
    }

    public final ConversationMode getConversationMode() {
        return this.conversationMode;
    }

    public final LanguageEnum getUserLang() {
        return this.userLang;
    }

    public final LanguageEnum getSpeakerLang() {
        return this.speakerLang;
    }

    public final String getTtsText() {
        return this.ttsText;
    }

    public final LanguageEnum getTtsLanguage() {
        return this.ttsLanguage;
    }

    public final Voice getTtsVoice() {
        return this.ttsVoice;
    }

    public final String getInputText() {
        return this.inputText;
    }

    public final MessageInputType getActiveInputType() {
        return this.activeInputType;
    }

    public final String getSearchQuery() {
        return this.searchQuery;
    }

    public final boolean isCorrectionSuggestionsEnabled() {
        return this.isCorrectionSuggestionsEnabled;
    }

    public final String getPartialText() {
        return this.partialText;
    }

    public final SaveInputSuggestionDialogState getSaveInputSuggestionDialogState() {
        return this.saveInputSuggestionDialogState;
    }

    public final List<CorrectionSuggestion> getCorrectionSuggestions() {
        return this.correctionSuggestions;
    }

    public final List<ConversationSuggestion> getConversationSuggestions() {
        return this.conversationSuggestions;
    }

    public final List<ConversationSuggestion> getConversationSuggestionsNetwork() {
        return this.conversationSuggestionsNetwork;
    }

    public final boolean isSpeakerDetectionEnabled() {
        return this.isSpeakerDetectionEnabled;
    }

    public final boolean isLanguageAnnouncementPopUpVisible() {
        return this.isLanguageAnnouncementPopUpVisible;
    }

    public final boolean isLanguageSelectionDialogVisible() {
        return this.isLanguageSelectionDialogVisible;
    }

    public final boolean isListeningEllipsisVisible() {
        return this.isListeningEllipsisVisible;
    }

    public final float getTranscriptFontSize() {
        return this.transcriptFontSize;
    }

    public final boolean isClearTextButtonVisible() {
        return !StringsKt.isBlank(this.inputText);
    }

    public final boolean isSendButtonEnabled() {
        if (StringsKt.isBlank(this.inputText)) {
            return false;
        }
        return (Intrinsics.areEqual(this.activity, ConversationActivity.Idle.INSTANCE) || Intrinsics.areEqual(this.activity, ConversationActivity.IsWebViewLoading.INSTANCE)) && !this.isLanguageAnnouncementPopUpVisible;
    }

    public final boolean isPartialTextVisible() {
        return Intrinsics.areEqual(this.activity, ConversationActivity.IsTranscribing.INSTANCE) && !StringsKt.isBlank(this.partialText);
    }

    public final boolean isInterpretButtonEnabled() {
        return Intrinsics.areEqual(this.activity, ConversationActivity.Idle.INSTANCE) && !this.isLanguageAnnouncementPopUpVisible;
    }

    public final boolean getShowInterpretationTranscriptionStopButton() {
        return Intrinsics.areEqual(this.activity, ConversationActivity.IsTranscribing.INSTANCE) || (this.activity instanceof ConversationActivity.IsInterpreting);
    }

    public final boolean isInputSuggestionEnabled() {
        if ((Intrinsics.areEqual(this.activity, ConversationActivity.Idle.INSTANCE) || Intrinsics.areEqual(this.activity, ConversationActivity.IsWebViewLoading.INSTANCE)) && !this.conversationSuggestions.isEmpty()) {
            return true;
        }
        return (this.conversationSuggestionsNetwork.isEmpty() || this.isLanguageAnnouncementPopUpVisible) ? false : true;
    }

    public final InputSource getInputSource() {
        return !StringsKt.isBlank(this.inputText) ? InputSource.Text.INSTANCE : InputSource.Voice.INSTANCE;
    }

    public final boolean isInputBottomDrawerButtonEnabled() {
        return (Intrinsics.areEqual(this.activity, ConversationActivity.Idle.INSTANCE) || Intrinsics.areEqual(this.activity, ConversationActivity.IsWebViewLoading.INSTANCE)) && !this.isLanguageAnnouncementPopUpVisible;
    }

    public final boolean isSummarizeButtonEnabled() {
        return this.conversationMessages.size() > 10 && Intrinsics.areEqual(this.activity, ConversationActivity.Idle.INSTANCE) && !this.isLanguageAnnouncementPopUpVisible;
    }

    public final boolean isConfigBottomDrawerButtonEnabled() {
        return Intrinsics.areEqual(this.activity, ConversationActivity.Idle.INSTANCE) && !this.isLanguageAnnouncementPopUpVisible;
    }

    public final List<SuggestionCategory> getConversationSuggestionCategories() {
        List<ConversationSuggestion> list = this.conversationSuggestions;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ConversationSuggestion) it.next()).getCategory());
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (hashSet.add(Long.valueOf(((SuggestionCategory) obj).getId()))) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public final boolean isProcessingIndicatorVisible() {
        ConversationActivity conversationActivity = this.activity;
        return (conversationActivity instanceof ConversationActivity.IsProcessingInputText) || (conversationActivity instanceof ConversationActivity.IsSummarizing) || (conversationActivity instanceof ConversationActivity.IsFetchingSuggestions);
    }
}
