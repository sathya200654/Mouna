package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.mappers;

import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppErrorMapper.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0004"}, d2 = {"toSetUpErrorMessageRes", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "toCredentialErrorMessageRes", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AppErrorMapperKt {
    public static final int toSetUpErrorMessageRes(AppError appError) {
        Intrinsics.checkNotNullParameter(appError, "<this>");
        if (Intrinsics.areEqual(appError, AppError.AuthenticationFailed.INSTANCE) || Intrinsics.areEqual(appError, AppError.AccessDenied.INSTANCE)) {
            return R.string.setup_auth_failed_error;
        }
        if (Intrinsics.areEqual(appError, AppError.NotSignedIn.INSTANCE) || Intrinsics.areEqual(appError, AppError.SessionExpired.INSTANCE)) {
            return R.string.setup_session_expired_error;
        }
        if (Intrinsics.areEqual(appError, AppError.MissingParameter.INSTANCE) || Intrinsics.areEqual(appError, AppError.RecordNotFound.INSTANCE)) {
            return R.string.setup_missing_info_error;
        }
        if (Intrinsics.areEqual(appError, AppError.ServerError.INSTANCE) || Intrinsics.areEqual(appError, AppError.ServiceUnavailable.INSTANCE) || Intrinsics.areEqual(appError, AppError.UpstreamTimeout.INSTANCE) || Intrinsics.areEqual(appError, AppError.SystemBusy.INSTANCE)) {
            return R.string.setup_server_down_error;
        }
        return R.string.setup_generic_error;
    }

    public static final int toCredentialErrorMessageRes(AppError appError) {
        Intrinsics.checkNotNullParameter(appError, "<this>");
        return R.string.credential_fail_error;
    }
}
