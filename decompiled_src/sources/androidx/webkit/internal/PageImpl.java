package androidx.webkit.internal;

import androidx.webkit.Page;
import org.chromium.support_lib_boundary.WebViewPageBoundaryInterface;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class PageImpl implements Page {
    private final WebViewPageBoundaryInterface mPageBoundaryInterface;

    public PageImpl(WebViewPageBoundaryInterface webViewPageBoundaryInterface) {
        this.mPageBoundaryInterface = webViewPageBoundaryInterface;
    }
}
