package androidx.webkit.internal;

import androidx.webkit.WebViewStartUpConfig;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.WebViewStartUpConfigBoundaryInterface;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class WebViewStartUpConfigAdapter implements WebViewStartUpConfigBoundaryInterface {
    private final WebViewStartUpConfig mWebViewStartUpConfig;

    public WebViewStartUpConfigAdapter(WebViewStartUpConfig webViewStartUpConfig) {
        this.mWebViewStartUpConfig = webViewStartUpConfig;
    }

    public Executor getBackgroundExecutor() {
        return this.mWebViewStartUpConfig.getBackgroundExecutor();
    }

    public boolean shouldRunUiThreadStartUpTasks() {
        return this.mWebViewStartUpConfig.shouldRunUiThreadStartUpTasks();
    }
}
