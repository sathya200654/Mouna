package com.deepvisiontech.letstalksigntranscriptionapp.current.core.shareintent.data;

import android.util.Patterns;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.shareintent.domain.ShareIntentManager;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: ShareIntentManagerImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Singleton
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/shareintent/data/ShareIntentManagerImpl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/shareintent/domain/ShareIntentManager;", "<init>", "()V", "_sharedText", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "sharedText", "Lkotlinx/coroutines/flow/StateFlow;", "getSharedText", "()Lkotlinx/coroutines/flow/StateFlow;", "onNewShareIntentTextReceived", "", "text", "consumeSharedIntentText", "processIncomingText", "rawInput", "extractTextFragmentFromUrl", "cleanText", "textValue", "replaceSpecialCharacters", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ShareIntentManagerImpl implements ShareIntentManager {
    public static final int $stable = 8;
    private final MutableStateFlow<String> _sharedText;
    private final StateFlow<String> sharedText;

    private final String replaceSpecialCharacters(String text) {
        return text;
    }

    @Inject
    public ShareIntentManagerImpl() {
        MutableStateFlow<String> MutableStateFlow = StateFlowKt.MutableStateFlow((Object) null);
        this._sharedText = MutableStateFlow;
        this.sharedText = FlowKt.asStateFlow(MutableStateFlow);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.shareintent.domain.ShareIntentManager
    public StateFlow<String> getSharedText() {
        return this.sharedText;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.shareintent.domain.ShareIntentManager
    public void onNewShareIntentTextReceived(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this._sharedText.setValue(processIncomingText(text));
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.shareintent.domain.ShareIntentManager
    public void consumeSharedIntentText() {
        this._sharedText.setValue((Object) null);
    }

    private final String processIncomingText(String rawInput) {
        String strExtractTextFragmentFromUrl = extractTextFragmentFromUrl(rawInput);
        if (strExtractTextFragmentFromUrl != null) {
            return cleanText(strExtractTextFragmentFromUrl);
        }
        return cleanText(rawInput);
    }

    private final String extractTextFragmentFromUrl(String text) {
        Matcher matcher = Patterns.WEB_URL.matcher(text);
        if (matcher.find()) {
            String strGroup = matcher.group();
            Intrinsics.checkNotNull(strGroup);
            int iIndexOf$default = StringsKt.indexOf$default(strGroup, "#:~:text=", 0, false, 6, (Object) null);
            if (iIndexOf$default != -1) {
                try {
                    String strSubstring = strGroup.substring(iIndexOf$default + "#:~:text=".length());
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    return URLDecoder.decode(strSubstring, "UTF-8");
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }

    private final String cleanText(String textValue) {
        return StringsKt.trim(replaceSpecialCharacters(textValue)).toString();
    }
}
