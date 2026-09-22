package androidx.webkit.internal;

import androidx.webkit.WebViewCompat;
import org.chromium.support_lib_boundary.VisualStateCallbackBoundaryInterface;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class VisualStateCallbackAdapter implements VisualStateCallbackBoundaryInterface {
    private final WebViewCompat.VisualStateCallback mVisualStateCallback;

    public VisualStateCallbackAdapter(WebViewCompat.VisualStateCallback visualStateCallback) {
        this.mVisualStateCallback = visualStateCallback;
    }

    public void onComplete(long j) {
        this.mVisualStateCallback.onComplete(j);
    }
}
