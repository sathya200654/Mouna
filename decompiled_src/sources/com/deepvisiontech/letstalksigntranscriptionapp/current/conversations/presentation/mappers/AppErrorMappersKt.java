package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.mappers;

import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppErrorMappers.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0006"}, d2 = {"toConversationErrorMessageRes", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "toDocumentScannerErrorMessageRes", "toConversationSettingsErrorMessageRes", "toConversationListErrorMessageRes", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AppErrorMappersKt {
    public static final int toConversationErrorMessageRes(AppError appError) {
        Intrinsics.checkNotNullParameter(appError, "<this>");
        if (Intrinsics.areEqual(appError, AppError.RecognitionFailed.INSTANCE)) {
            return R.string.conversation_speech_recognition_error;
        }
        if (Intrinsics.areEqual(appError, AppError.TextToSpeechFailed.INSTANCE)) {
            return R.string.conversation_tts_playback_error;
        }
        if (Intrinsics.areEqual(appError, AppError.TextToSpeechTimeout.INSTANCE)) {
            return R.string.conversation_tts_timeout_error;
        }
        if (Intrinsics.areEqual(appError, AppError.ServerError.INSTANCE) || Intrinsics.areEqual(appError, AppError.ServiceUnavailable.INSTANCE) || Intrinsics.areEqual(appError, AppError.SystemBusy.INSTANCE) || Intrinsics.areEqual(appError, AppError.UpstreamServiceError.INSTANCE)) {
            return R.string.conversation_service_unavailable_error;
        }
        if (Intrinsics.areEqual(appError, AppError.UpstreamTimeout.INSTANCE)) {
            return R.string.conversation_network_timeout_error;
        }
        if (Intrinsics.areEqual(appError, AppError.QuotaExceeded.INSTANCE)) {
            return R.string.conversation_daily_limit_reached_error;
        }
        if (Intrinsics.areEqual(appError, AppError.ContentModerationFailed.INSTANCE)) {
            return R.string.conversation_content_flagged_error;
        }
        if (Intrinsics.areEqual(appError, AppError.InputTooLong.INSTANCE)) {
            return R.string.conversation_input_too_long_error;
        }
        if (Intrinsics.areEqual(appError, AppError.InvalidInput.INSTANCE) || Intrinsics.areEqual(appError, AppError.MissingParameter.INSTANCE)) {
            return R.string.conversation_invalid_input_error;
        }
        if (Intrinsics.areEqual(appError, AppError.UnsupportedVideoUrlError.INSTANCE)) {
            return R.string.conversation_unsupported_video_url_error;
        }
        if (Intrinsics.areEqual(appError, AppError.UnsupportedPdfUrlError.INSTANCE)) {
            return R.string.conversation_unsupported_pdf_url_error;
        }
        if (Intrinsics.areEqual(appError, AppError.UnsupportedSocialUrlError.INSTANCE)) {
            return R.string.conversation_unsupported_social_url_error;
        }
        if (Intrinsics.areEqual(appError, AppError.UnsupportedImageUrlError.INSTANCE)) {
            return R.string.conversation_unsupported_image_url_error;
        }
        if (Intrinsics.areEqual(appError, AppError.UnsupportedDriveUrlError.INSTANCE)) {
            return R.string.conversation_unsupported_drive_url_error;
        }
        if (Intrinsics.areEqual(appError, AppError.UploadFailed.INSTANCE) || Intrinsics.areEqual(appError, AppError.FileTooLarge.INSTANCE) || Intrinsics.areEqual(appError, AppError.UnsupportedMediaType.INSTANCE)) {
            return R.string.conversation_image_processing_failed_error;
        }
        if (Intrinsics.areEqual(appError, AppError.LocalStorageError.INSTANCE) || Intrinsics.areEqual(appError, AppError.StorageFull.INSTANCE) || Intrinsics.areEqual(appError, AppError.DatabaseLocked.INSTANCE) || Intrinsics.areEqual(appError, AppError.DataCorrupted.INSTANCE)) {
            return R.string.conversation_local_storage_error;
        }
        if (Intrinsics.areEqual(appError, AppError.ItemAlreadyExists.INSTANCE)) {
            return R.string.conversation_suggestion_exists_error;
        }
        if (Intrinsics.areEqual(appError, AppError.RecordNotFound.INSTANCE)) {
            return R.string.conversation_record_not_found_error;
        }
        if (Intrinsics.areEqual(appError, AppError.AuthenticationFailed.INSTANCE) || Intrinsics.areEqual(appError, AppError.SessionExpired.INSTANCE) || Intrinsics.areEqual(appError, AppError.NotSignedIn.INSTANCE) || Intrinsics.areEqual(appError, AppError.AccessDenied.INSTANCE)) {
            return R.string.conversation_auth_required_error;
        }
        if (Intrinsics.areEqual(appError, AppError.ProcessingFailed.INSTANCE) || Intrinsics.areEqual(appError, AppError.UnknownError.INSTANCE)) {
            return R.string.conversation_generic_error;
        }
        if (Intrinsics.areEqual(appError, AppError.LanguageError.INSTANCE)) {
            return R.string.conversation_language_error;
        }
        return Intrinsics.areEqual(appError, AppError.ParsingError.INSTANCE) ? R.string.conversation_parsing_error : R.string.conversation_generic_error;
    }

    public static final int toDocumentScannerErrorMessageRes(AppError appError) {
        Intrinsics.checkNotNullParameter(appError, "<this>");
        if (Intrinsics.areEqual(appError, AppError.RecognitionFailed.INSTANCE)) {
            return R.string.document_scanner_recognition_failed_error;
        }
        if (Intrinsics.areEqual(appError, AppError.ParsingError.INSTANCE)) {
            return R.string.document_scanner_parsing_error;
        }
        if (Intrinsics.areEqual(appError, AppError.UploadFailed.INSTANCE) || Intrinsics.areEqual(appError, AppError.FileTooLarge.INSTANCE) || Intrinsics.areEqual(appError, AppError.UnsupportedMediaType.INSTANCE)) {
            return R.string.document_scanner_image_processing_error;
        }
        if (Intrinsics.areEqual(appError, AppError.ServerError.INSTANCE) || Intrinsics.areEqual(appError, AppError.ServiceUnavailable.INSTANCE) || Intrinsics.areEqual(appError, AppError.SystemBusy.INSTANCE) || Intrinsics.areEqual(appError, AppError.UpstreamServiceError.INSTANCE)) {
            return R.string.document_scanner_service_unavailable_error;
        }
        if (Intrinsics.areEqual(appError, AppError.UpstreamTimeout.INSTANCE)) {
            return R.string.document_scanner_network_timeout_error;
        }
        if (Intrinsics.areEqual(appError, AppError.QuotaExceeded.INSTANCE)) {
            return R.string.document_scanner_daily_limit_reached_error;
        }
        if (Intrinsics.areEqual(appError, AppError.InputTooLong.INSTANCE)) {
            return R.string.document_scanner_input_too_long_error;
        }
        if (Intrinsics.areEqual(appError, AppError.InvalidInput.INSTANCE) || Intrinsics.areEqual(appError, AppError.InvalidFormat.INSTANCE) || Intrinsics.areEqual(appError, AppError.MissingParameter.INSTANCE)) {
            return R.string.document_scanner_invalid_input_error;
        }
        if (Intrinsics.areEqual(appError, AppError.LocalStorageError.INSTANCE) || Intrinsics.areEqual(appError, AppError.StorageFull.INSTANCE) || Intrinsics.areEqual(appError, AppError.DatabaseLocked.INSTANCE) || Intrinsics.areEqual(appError, AppError.DataCorrupted.INSTANCE)) {
            return R.string.document_scanner_local_storage_error;
        }
        if (Intrinsics.areEqual(appError, AppError.AuthenticationFailed.INSTANCE) || Intrinsics.areEqual(appError, AppError.SessionExpired.INSTANCE) || Intrinsics.areEqual(appError, AppError.NotSignedIn.INSTANCE) || Intrinsics.areEqual(appError, AppError.AccessDenied.INSTANCE)) {
            return R.string.document_scanner_auth_required_error;
        }
        if (Intrinsics.areEqual(appError, AppError.ContentModerationFailed.INSTANCE)) {
            return R.string.document_scanner_content_flagged_error;
        }
        if (Intrinsics.areEqual(appError, AppError.ProcessingFailed.INSTANCE) || Intrinsics.areEqual(appError, AppError.UnknownError.INSTANCE)) {
            return R.string.document_scanner_generic_error;
        }
        return R.string.document_scanner_generic_error;
    }

    public static final int toConversationSettingsErrorMessageRes(AppError appError) {
        Intrinsics.checkNotNullParameter(appError, "<this>");
        if (Intrinsics.areEqual(appError, AppError.LocalStorageError.INSTANCE) || Intrinsics.areEqual(appError, AppError.StorageFull.INSTANCE) || Intrinsics.areEqual(appError, AppError.DatabaseLocked.INSTANCE) || Intrinsics.areEqual(appError, AppError.DataCorrupted.INSTANCE)) {
            return R.string.conversation_settings_local_storage_error;
        }
        if (Intrinsics.areEqual(appError, AppError.MissingParameter.INSTANCE) || Intrinsics.areEqual(appError, AppError.InvalidInput.INSTANCE) || Intrinsics.areEqual(appError, AppError.InvalidFormat.INSTANCE)) {
            return R.string.conversation_settings_invalid_input_error;
        }
        if (Intrinsics.areEqual(appError, AppError.LanguageError.INSTANCE)) {
            return R.string.conversation_settings_language_unavailable_error;
        }
        if (Intrinsics.areEqual(appError, AppError.TextToSpeechFailed.INSTANCE) || Intrinsics.areEqual(appError, AppError.TextToSpeechTimeout.INSTANCE)) {
            return R.string.conversation_settings_tts_playback_error;
        }
        if (Intrinsics.areEqual(appError, AppError.ServerError.INSTANCE) || Intrinsics.areEqual(appError, AppError.ServiceUnavailable.INSTANCE) || Intrinsics.areEqual(appError, AppError.SystemBusy.INSTANCE) || Intrinsics.areEqual(appError, AppError.UpstreamServiceError.INSTANCE)) {
            return R.string.conversation_settings_service_unavailable_error;
        }
        if (Intrinsics.areEqual(appError, AppError.UpstreamTimeout.INSTANCE)) {
            return R.string.conversation_settings_network_timeout_error;
        }
        if (Intrinsics.areEqual(appError, AppError.QuotaExceeded.INSTANCE)) {
            return R.string.conversation_settings_quota_exceeded_error;
        }
        if (Intrinsics.areEqual(appError, AppError.AuthenticationFailed.INSTANCE) || Intrinsics.areEqual(appError, AppError.SessionExpired.INSTANCE) || Intrinsics.areEqual(appError, AppError.NotSignedIn.INSTANCE) || Intrinsics.areEqual(appError, AppError.AccessDenied.INSTANCE)) {
            return R.string.conversation_settings_auth_required_error;
        }
        if (Intrinsics.areEqual(appError, AppError.UnknownError.INSTANCE) || Intrinsics.areEqual(appError, AppError.ProcessingFailed.INSTANCE)) {
            return R.string.conversation_settings_generic_error;
        }
        return R.string.conversation_settings_generic_error;
    }

    public static final int toConversationListErrorMessageRes(AppError appError) {
        Intrinsics.checkNotNullParameter(appError, "<this>");
        if (Intrinsics.areEqual(appError, AppError.LocalStorageError.INSTANCE) || Intrinsics.areEqual(appError, AppError.StorageFull.INSTANCE) || Intrinsics.areEqual(appError, AppError.DatabaseLocked.INSTANCE) || Intrinsics.areEqual(appError, AppError.DataCorrupted.INSTANCE)) {
            return R.string.conversation_list_local_storage_error;
        }
        if (Intrinsics.areEqual(appError, AppError.RecordNotFound.INSTANCE)) {
            return R.string.conversation_list_not_found_error;
        }
        if (Intrinsics.areEqual(appError, AppError.InvalidInput.INSTANCE) || Intrinsics.areEqual(appError, AppError.MissingParameter.INSTANCE)) {
            return R.string.conversation_list_invalid_input_error;
        }
        if (Intrinsics.areEqual(appError, AppError.UnknownError.INSTANCE) || Intrinsics.areEqual(appError, AppError.ProcessingFailed.INSTANCE)) {
            return R.string.conversation_list_generic_error;
        }
        return R.string.conversation_list_generic_error;
    }
}
