package com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager;

import android.webkit.WebView;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMessage;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewState;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: WebViewManager.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0016\u0010\u0014\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H&J\b\u0010\u0018\u001a\u00020\u0011H&J\b\u0010\u0019\u001a\u00020\u0011H&J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u0011H&J\b\u0010\u001e\u001a\u00020\u0011H&J\b\u0010\u001f\u001a\u00020\u0011H&J\b\u0010 \u001a\u00020\u0011H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006!À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;", "", "webView", "Landroid/webkit/WebView;", "getWebView", "()Landroid/webkit/WebView;", "webViewState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState;", "getWebViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "webViewEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewEvent;", "getWebViewEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "sendConversationMessageToWebView", "", "conversationMessage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;", "sendSentenceListToWebView", "sentences", "", "", "stopInterpretationAndClearTranscripts", "stopInterpretation", "setWebViewVisibility", "isVisible", "", "resetToIdle", "restoreView", "onCloseAction", "reload", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface WebViewManager {
    WebView getWebView();

    SharedFlow<WebViewEvent> getWebViewEvent();

    StateFlow<WebViewState> getWebViewState();

    void onCloseAction();

    void reload();

    void resetToIdle();

    void restoreView();

    void sendConversationMessageToWebView(ConversationMessage conversationMessage);

    void sendSentenceListToWebView(List<String> sentences);

    void setWebViewVisibility(boolean isVisible);

    void stopInterpretation();

    void stopInterpretationAndClearTranscripts();
}
