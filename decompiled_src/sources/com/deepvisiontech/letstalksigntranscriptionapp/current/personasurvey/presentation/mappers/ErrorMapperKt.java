package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.mappers;

import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ErrorMapper.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toOnboardingErrorMessageRes", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ErrorMapperKt {
    public static final int toOnboardingErrorMessageRes(AppError appError) {
        Intrinsics.checkNotNullParameter(appError, "<this>");
        if (Intrinsics.areEqual(appError, AppError.UpstreamTimeout.INSTANCE) || Intrinsics.areEqual(appError, AppError.TextToSpeechTimeout.INSTANCE)) {
            return R.string.onboarding_timeout_error;
        }
        if (Intrinsics.areEqual(appError, AppError.ServiceUnavailable.INSTANCE) || Intrinsics.areEqual(appError, AppError.UpstreamServiceError.INSTANCE) || Intrinsics.areEqual(appError, AppError.SystemBusy.INSTANCE)) {
            return R.string.onboarding_server_error;
        }
        if (Intrinsics.areEqual(appError, AppError.InvalidInput.INSTANCE) || Intrinsics.areEqual(appError, AppError.MissingParameter.INSTANCE) || Intrinsics.areEqual(appError, AppError.MissingRequiredField.INSTANCE) || Intrinsics.areEqual(appError, AppError.ConflictState.INSTANCE) || Intrinsics.areEqual(appError, AppError.ItemAlreadyExists.INSTANCE)) {
            return R.string.onboarding_validation_error;
        }
        if (Intrinsics.areEqual(appError, AppError.RecordNotFound.INSTANCE) || Intrinsics.areEqual(appError, AppError.ResourceMissing.INSTANCE) || Intrinsics.areEqual(appError, AppError.ParsingError.INSTANCE)) {
            return R.string.onboarding_load_failed;
        }
        if (Intrinsics.areEqual(appError, AppError.AuthenticationFailed.INSTANCE) || Intrinsics.areEqual(appError, AppError.NotSignedIn.INSTANCE) || Intrinsics.areEqual(appError, AppError.AccessDenied.INSTANCE) || Intrinsics.areEqual(appError, AppError.SessionExpired.INSTANCE)) {
            return R.string.onboarding_auth_error;
        }
        if (Intrinsics.areEqual(appError, AppError.ServerError.INSTANCE) || Intrinsics.areEqual(appError, AppError.DatabaseLocked.INSTANCE) || Intrinsics.areEqual(appError, AppError.LocalStorageError.INSTANCE) || Intrinsics.areEqual(appError, AppError.StorageFull.INSTANCE) || Intrinsics.areEqual(appError, AppError.DataCorrupted.INSTANCE) || Intrinsics.areEqual(appError, AppError.ProcessingFailed.INSTANCE) || Intrinsics.areEqual(appError, AppError.UnknownError.INSTANCE)) {
            return R.string.onboarding_generic_error;
        }
        return R.string.onboarding_generic_error;
    }
}
