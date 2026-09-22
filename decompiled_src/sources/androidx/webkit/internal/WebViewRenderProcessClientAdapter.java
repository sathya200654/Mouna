package androidx.webkit.internal;

import android.webkit.WebView;
import androidx.webkit.WebViewFeature;
import androidx.webkit.WebViewRenderProcessClient;
import java.lang.reflect.InvocationHandler;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class WebViewRenderProcessClientAdapter implements WebViewRendererClientBoundaryInterface {
    private static final String[] sSupportedFeatures = {WebViewFeature.WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE};
    private final Executor mExecutor;
    private final WebViewRenderProcessClient mWebViewRenderProcessClient;

    public WebViewRenderProcessClientAdapter(Executor executor, WebViewRenderProcessClient webViewRenderProcessClient) {
        this.mExecutor = executor;
        this.mWebViewRenderProcessClient = webViewRenderProcessClient;
    }

    public WebViewRenderProcessClient getWebViewRenderProcessClient() {
        return this.mWebViewRenderProcessClient;
    }

    public final String[] getSupportedFeatures() {
        return sSupportedFeatures;
    }

    public final void onRendererUnresponsive(final WebView webView, InvocationHandler invocationHandler) {
        final WebViewRenderProcessImpl webViewRenderProcessImplForInvocationHandler = WebViewRenderProcessImpl.forInvocationHandler(invocationHandler);
        final WebViewRenderProcessClient webViewRenderProcessClient = this.mWebViewRenderProcessClient;
        Executor executor = this.mExecutor;
        if (executor == null) {
            webViewRenderProcessClient.onRenderProcessUnresponsive(webView, webViewRenderProcessImplForInvocationHandler);
        } else {
            executor.execute(new Runnable() { // from class: androidx.webkit.internal.WebViewRenderProcessClientAdapter$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    webViewRenderProcessClient.onRenderProcessUnresponsive(webView, webViewRenderProcessImplForInvocationHandler);
                }
            });
        }
    }

    public final void onRendererResponsive(final WebView webView, InvocationHandler invocationHandler) {
        final WebViewRenderProcessImpl webViewRenderProcessImplForInvocationHandler = WebViewRenderProcessImpl.forInvocationHandler(invocationHandler);
        final WebViewRenderProcessClient webViewRenderProcessClient = this.mWebViewRenderProcessClient;
        Executor executor = this.mExecutor;
        if (executor == null) {
            webViewRenderProcessClient.onRenderProcessResponsive(webView, webViewRenderProcessImplForInvocationHandler);
        } else {
            executor.execute(new Runnable() { // from class: androidx.webkit.internal.WebViewRenderProcessClientAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    webViewRenderProcessClient.onRenderProcessResponsive(webView, webViewRenderProcessImplForInvocationHandler);
                }
            });
        }
    }
}
