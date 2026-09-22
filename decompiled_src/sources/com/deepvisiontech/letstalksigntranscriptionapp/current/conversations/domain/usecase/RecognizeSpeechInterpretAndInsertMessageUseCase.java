package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase;

import android.util.Log;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMessage;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.MessageType;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationMessageRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel;
import com.google.protobuf.DescriptorProtos;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: RecognizeSpeechInterpretAndInsertMessageUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Singleton
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B3\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0086B¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/RecognizeSpeechInterpretAndInsertMessageUseCase;", "", "conversationSpeechRecognizerService", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationSpeechRecognizerService;", "conversationMessageRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationMessageRepository;", "webViewManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;", "analyticsManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationSpeechRecognizerService;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationMessageRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getIoDispatcher$annotations", "()V", "invoke", "conversationId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecognizeSpeechInterpretAndInsertMessageUseCase {
    private static final String TAG = "RecognizeSpeechInterpretAndInsertMessageUseCase";
    private final AnalyticsManager analyticsManager;
    private final ConversationMessageRepository conversationMessageRepository;
    private final ConversationSpeechRecognizerService conversationSpeechRecognizerService;
    private final CoroutineDispatcher ioDispatcher;
    private final WebViewManager webViewManager;
    public static final int $stable = 8;

    private static /* synthetic */ void getIoDispatcher$annotations() {
    }

    @Inject
    public RecognizeSpeechInterpretAndInsertMessageUseCase(ConversationSpeechRecognizerService conversationSpeechRecognizerService, ConversationMessageRepository conversationMessageRepository, WebViewManager webViewManager, AnalyticsManager analyticsManager, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(conversationSpeechRecognizerService, "conversationSpeechRecognizerService");
        Intrinsics.checkNotNullParameter(conversationMessageRepository, "conversationMessageRepository");
        Intrinsics.checkNotNullParameter(webViewManager, "webViewManager");
        Intrinsics.checkNotNullParameter(analyticsManager, "analyticsManager");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        this.conversationSpeechRecognizerService = conversationSpeechRecognizerService;
        this.conversationMessageRepository = conversationMessageRepository;
        this.webViewManager = webViewManager;
        this.analyticsManager = analyticsManager;
        this.ioDispatcher = coroutineDispatcher;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.RecognizeSpeechInterpretAndInsertMessageUseCase$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: RecognizeSpeechInterpretAndInsertMessageUseCase.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.RecognizeSpeechInterpretAndInsertMessageUseCase$invoke$2", f = "RecognizeSpeechInterpretAndInsertMessageUseCase.kt", i = {}, l = {SignPracticeCreationViewModel.PRACTICE_NAME_MAX_CHAR_LIMIT, 36, 74, 74, 74}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
        final /* synthetic */ long $conversationId;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(long j, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$conversationId = j;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RecognizeSpeechInterpretAndInsertMessageUseCase.this.new AnonymousClass2(this.$conversationId, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<Object> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:33:0x00a3 A[RETURN] */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Unit unit;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (RecognizeSpeechInterpretAndInsertMessageUseCase.this.conversationSpeechRecognizerService.startListening((Continuation) this) == coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i != 2) {
                            if (i == 3) {
                                Unit unit2 = (Unit) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                return unit2;
                            }
                            if (i == 4) {
                                Integer num = (Integer) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                return num;
                            }
                            if (i != 5) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            Throwable th = (Throwable) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            throw th;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    unit = Unit.INSTANCE;
                    this.L$0 = unit;
                    this.label = 3;
                    if (RecognizeSpeechInterpretAndInsertMessageUseCase.this.conversationSpeechRecognizerService.stopListening((Continuation) this) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return unit;
                    Flow flowOnCompletion = FlowKt.onCompletion(RecognizeSpeechInterpretAndInsertMessageUseCase.this.conversationSpeechRecognizerService.getEvents(), new AnonymousClass1(RecognizeSpeechInterpretAndInsertMessageUseCase.this, null));
                    final long j = this.$conversationId;
                    final RecognizeSpeechInterpretAndInsertMessageUseCase recognizeSpeechInterpretAndInsertMessageUseCase = RecognizeSpeechInterpretAndInsertMessageUseCase.this;
                    this.label = 2;
                    if (flowOnCompletion.collect(new FlowCollector() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.RecognizeSpeechInterpretAndInsertMessageUseCase.invoke.2.2
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((SpeechRecognizerEvent) obj2, (Continuation<? super Unit>) continuation);
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public final Object emit(SpeechRecognizerEvent speechRecognizerEvent, Continuation<? super Unit> continuation) throws NoWhenBranchMatchedException {
                            if (!(speechRecognizerEvent instanceof SpeechRecognizerEvent.Error)) {
                                if (!(speechRecognizerEvent instanceof SpeechRecognizerEvent.Recognized)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                SpeechRecognizerEvent.Recognized recognized = (SpeechRecognizerEvent.Recognized) speechRecognizerEvent;
                                ConversationMessage conversationMessage = new ConversationMessage(0L, j, recognized.getUserName(), recognized.getText(), recognized.getProcessedText(), recognized.getProcessedTextLanguage(), null, 0, recognized.getTextLanguage(), recognized.getInputType(), MessageType.INTERPRETATION, true, false, System.currentTimeMillis(), 4289, null);
                                recognizeSpeechInterpretAndInsertMessageUseCase.webViewManager.sendConversationMessageToWebView(conversationMessage);
                                recognizeSpeechInterpretAndInsertMessageUseCase.analyticsManager.logEvent(new AnalyticsEvent.SttInterpreted(recognized.getTextLanguage().name(), recognized.getText().length()));
                                Object objInsertConversationMessageWithNextSequenceIdAndGetWithId = recognizeSpeechInterpretAndInsertMessageUseCase.conversationMessageRepository.insertConversationMessageWithNextSequenceIdAndGetWithId(conversationMessage, continuation);
                                return objInsertConversationMessageWithNextSequenceIdAndGetWithId == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInsertConversationMessageWithNextSequenceIdAndGetWithId : Unit.INSTANCE;
                            }
                            return Unit.INSTANCE;
                        }
                    }, (Continuation) this) != coroutine_suspended) {
                        unit = Unit.INSTANCE;
                        this.L$0 = unit;
                        this.label = 3;
                        if (RecognizeSpeechInterpretAndInsertMessageUseCase.this.conversationSpeechRecognizerService.stopListening((Continuation) this) != coroutine_suspended) {
                            return unit;
                        }
                    }
                } catch (Exception e) {
                    if (e instanceof CancellationException) {
                        throw e;
                    }
                    Integer numBoxInt = Boxing.boxInt(Log.e(RecognizeSpeechInterpretAndInsertMessageUseCase.TAG, "Error while recognizing speech", e));
                    this.L$0 = numBoxInt;
                    this.label = 4;
                    if (RecognizeSpeechInterpretAndInsertMessageUseCase.this.conversationSpeechRecognizerService.stopListening((Continuation) this) != coroutine_suspended) {
                        return numBoxInt;
                    }
                }
            } catch (Throwable th2) {
                this.L$0 = th2;
                this.label = 5;
                if (RecognizeSpeechInterpretAndInsertMessageUseCase.this.conversationSpeechRecognizerService.stopListening((Continuation) this) != coroutine_suspended) {
                    throw th2;
                }
            }
            return coroutine_suspended;
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.RecognizeSpeechInterpretAndInsertMessageUseCase$invoke$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: RecognizeSpeechInterpretAndInsertMessageUseCase.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/model/SpeechRecognizerEvent;", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.RecognizeSpeechInterpretAndInsertMessageUseCase$invoke$2$1", f = "RecognizeSpeechInterpretAndInsertMessageUseCase.kt", i = {}, l = {DescriptorProtos.MethodOptions.IDEMPOTENCY_LEVEL_FIELD_NUMBER}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super SpeechRecognizerEvent>, Throwable, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ RecognizeSpeechInterpretAndInsertMessageUseCase this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(RecognizeSpeechInterpretAndInsertMessageUseCase recognizeSpeechInterpretAndInsertMessageUseCase, Continuation<? super AnonymousClass1> continuation) {
                super(3, continuation);
                this.this$0 = recognizeSpeechInterpretAndInsertMessageUseCase;
            }

            public final Object invoke(FlowCollector<? super SpeechRecognizerEvent> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                return new AnonymousClass1(this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.this$0.conversationSpeechRecognizerService.stopListening((Continuation) this) == coroutine_suspended) {
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

    public final Object invoke(long j, Continuation<Object> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new AnonymousClass2(j, null), continuation);
    }
}
