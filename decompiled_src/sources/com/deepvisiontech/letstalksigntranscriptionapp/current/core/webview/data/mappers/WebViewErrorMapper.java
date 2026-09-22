package com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.mappers;

import android.webkit.RenderProcessGoneDetail;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebViewErrorMapper.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/mappers/WebViewErrorMapper;", "", "<init>", "()V", "mapJavascriptEvent", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "event", "", "mapResourceError", "errorCode", "", "mapRenderProcessGone", "detail", "Landroid/webkit/RenderProcessGoneDetail;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WebViewErrorMapper {
    public static final int $stable = 0;
    public static final WebViewErrorMapper INSTANCE = new WebViewErrorMapper();

    private WebViewErrorMapper() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final AppError mapJavascriptEvent(String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String lowerCase = event.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case -460706191:
                if (lowerCase.equals("allow error")) {
                    return AppError.AccessDenied.INSTANCE;
                }
                break;
            case 29019448:
                if (lowerCase.equals("clip error")) {
                    return AppError.AvatarClipMissing.INSTANCE;
                }
                break;
            case 69558229:
                if (lowerCase.equals("cors error")) {
                    return AppError.AvatarSecurityError.INSTANCE;
                }
                break;
            case 562946544:
                if (lowerCase.equals("interpretation error")) {
                    return AppError.AvatarInternalError.INSTANCE;
                }
                break;
        }
        return AppError.UnknownError.INSTANCE;
    }

    public final AppError mapResourceError(int errorCode) {
        if (errorCode == -8) {
            return AppError.AvatarLoadTimeout.INSTANCE;
        }
        if (errorCode != -6 && errorCode != -2) {
            switch (errorCode) {
                case -15:
                    return AppError.SystemBusy.INSTANCE;
                case -14:
                case -13:
                case -12:
                    return AppError.AvatarAssetLoadFailed.INSTANCE;
                case -11:
                    break;
                default:
                    return AppError.AvatarAssetLoadFailed.INSTANCE;
            }
        }
        return AppError.ServiceUnavailable.INSTANCE;
    }

    public final AppError mapRenderProcessGone(RenderProcessGoneDetail detail) {
        Intrinsics.checkNotNullParameter(detail, "detail");
        if (detail.didCrash()) {
            return AppError.AvatarRendererCrashed.INSTANCE;
        }
        return AppError.SystemBusy.INSTANCE;
    }
}
