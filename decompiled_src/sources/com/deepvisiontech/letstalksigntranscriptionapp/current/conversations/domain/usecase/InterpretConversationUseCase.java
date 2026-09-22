package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase;

import android.util.Log;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMessage;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationMessageRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InterpretConversationUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Singleton
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0086B¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/InterpretConversationUseCase;", "", "webViewManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;", "conversationMessageRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationMessageRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationMessageRepository;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "conversationMessage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InterpretConversationUseCase {
    public static final int $stable = 0;
    private static final String TAG = "InterpretConversationUseCase";
    private final ConversationMessageRepository conversationMessageRepository;
    private final WebViewManager webViewManager;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.InterpretConversationUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: InterpretConversationUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.InterpretConversationUseCase", f = "InterpretConversationUseCase.kt", i = {0, 0}, l = {21}, m = "invoke", n = {"conversationMessage", "processedMessage"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InterpretConversationUseCase.this.invoke(null, (Continuation) this);
        }
    }

    @Inject
    public InterpretConversationUseCase(WebViewManager webViewManager, ConversationMessageRepository conversationMessageRepository) {
        Intrinsics.checkNotNullParameter(webViewManager, "webViewManager");
        Intrinsics.checkNotNullParameter(conversationMessageRepository, "conversationMessageRepository");
        this.webViewManager = webViewManager;
        this.conversationMessageRepository = conversationMessageRepository;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object invoke(ConversationMessage conversationMessage, Continuation<? super ResponseResource<Unit>> continuation) throws NoWhenBranchMatchedException {
        AnonymousClass1 anonymousClass1;
        ConversationMessage conversationMessage2;
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
        Object objUpdateConversationMessage = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objUpdateConversationMessage);
                ConversationMessage conversationMessageCopy$default = ConversationMessage.copy$default(conversationMessage, 0L, 0L, null, null, null, null, null, 0, null, null, null, true, false, 0L, 14335, null);
                ConversationMessageRepository conversationMessageRepository = this.conversationMessageRepository;
                anonymousClass1.L$0 = conversationMessage;
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(conversationMessageCopy$default);
                anonymousClass1.label = 1;
                objUpdateConversationMessage = conversationMessageRepository.updateConversationMessage(conversationMessageCopy$default, anonymousClass1);
                if (objUpdateConversationMessage == coroutine_suspended) {
                    return coroutine_suspended;
                }
                conversationMessage2 = conversationMessage;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                conversationMessage2 = (ConversationMessage) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objUpdateConversationMessage);
            }
            ResponseResource responseResource = (ResponseResource) objUpdateConversationMessage;
            if (responseResource instanceof ResponseResource.Success) {
                ((ResponseResource.Success) responseResource).getData();
                this.webViewManager.sendConversationMessageToWebView(conversationMessage2);
                return new ResponseResource.Success(Unit.INSTANCE);
            }
            if (responseResource instanceof ResponseResource.Error) {
                return responseResource;
            }
            if (Intrinsics.areEqual(responseResource, ResponseResource.Loading.INSTANCE)) {
                return ResponseResource.Loading.INSTANCE;
            }
            throw new NoWhenBranchMatchedException();
        } catch (Exception e) {
            Log.e(TAG, "Failed to send conversation message to webview", e);
            return new ResponseResource.Error(AppError.UnknownError.INSTANCE);
        }
    }
}
