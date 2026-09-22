package com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;

/* JADX INFO: compiled from: JavascriptCallbackHandler.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\t\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/JavascriptCallbackHandler;", "", "handleJavascriptEvent", "", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "onMissingAnimation", "word", "getInterpretationModeKey", "getInterpretationSpeedKey", "onCloseAction", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface JavascriptCallbackHandler {
    String getInterpretationModeKey();

    String getInterpretationSpeedKey();

    void handleJavascriptEvent(String data);

    void onCloseAction();

    void onMissingAnimation(String word);
}
