package com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.webviewinterface;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.webkit.JavascriptInterface;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.JavascriptCallbackHandler;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebViewJavascriptInterface.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH\u0007J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0007J\b\u0010\u000f\u001a\u00020\tH\u0007J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0007J\b\u0010\u0011\u001a\u00020\u000bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/webviewinterface/WebViewJavascriptInterface;", "", "callbackHandler", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/JavascriptCallbackHandler;", "context", "Landroid/content/Context;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/JavascriptCallbackHandler;Landroid/content/Context;)V", "sendDataToAndroid", "", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "missingAnimations", "word", "getQuickInterpretationValue", "closeAryaBox", "getSpeedModeValue", "getScreenSize", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WebViewJavascriptInterface {
    public static final int $stable = 8;
    private final JavascriptCallbackHandler callbackHandler;
    private final Context context;

    public WebViewJavascriptInterface(JavascriptCallbackHandler javascriptCallbackHandler, Context context) {
        Intrinsics.checkNotNullParameter(javascriptCallbackHandler, "callbackHandler");
        Intrinsics.checkNotNullParameter(context, "context");
        this.callbackHandler = javascriptCallbackHandler;
        this.context = context;
    }

    @JavascriptInterface
    public final void sendDataToAndroid(String data) {
        Intrinsics.checkNotNullParameter(data, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        this.callbackHandler.handleJavascriptEvent(data);
    }

    @JavascriptInterface
    public final void missingAnimations(String word) {
        Intrinsics.checkNotNullParameter(word, "word");
        this.callbackHandler.onMissingAnimation(word);
    }

    @JavascriptInterface
    public final String getQuickInterpretationValue() {
        return this.callbackHandler.getInterpretationModeKey();
    }

    @JavascriptInterface
    public final void closeAryaBox() {
        this.callbackHandler.onCloseAction();
    }

    @JavascriptInterface
    public final String getSpeedModeValue() {
        return this.callbackHandler.getInterpretationSpeedKey();
    }

    @JavascriptInterface
    public final String getScreenSize() {
        if (Build.VERSION.SDK_INT >= 30) {
            Object systemService = this.context.getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            WindowMetrics currentWindowMetrics = ((WindowManager) systemService).getCurrentWindowMetrics();
            Intrinsics.checkNotNullExpressionValue(currentWindowMetrics, "getCurrentWindowMetrics(...)");
            Rect bounds = currentWindowMetrics.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
            return bounds.width() + " " + bounds.height();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService2 = this.context.getSystemService("window");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService2).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels + " " + displayMetrics.heightPixels;
    }
}
