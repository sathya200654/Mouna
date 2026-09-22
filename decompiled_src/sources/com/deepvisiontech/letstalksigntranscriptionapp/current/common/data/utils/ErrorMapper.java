package com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.utils;

import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteFullException;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError;
import java.io.IOException;
import java.io.InterruptedIOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ErrorMapper.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/utils/ErrorMapper;", "", "<init>", "()V", "mapCodeToAppError", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "errorCode", "", "mapDbError", "e", "", "mapIoError", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ErrorMapper {
    public static final int $stable = 0;
    public static final ErrorMapper INSTANCE = new ErrorMapper();

    private ErrorMapper() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final AppError mapCodeToAppError(String errorCode) {
        if (errorCode != null) {
            switch (errorCode.hashCode()) {
                case -2054170903:
                    if (errorCode.equals("processing_failed")) {
                        return AppError.ProcessingFailed.INSTANCE;
                    }
                    break;
                case -1910919878:
                    if (errorCode.equals("quota_exceeded")) {
                        return AppError.QuotaExceeded.INSTANCE;
                    }
                    break;
                case -1489705906:
                    if (errorCode.equals("internal_server_error")) {
                        return AppError.ServerError.INSTANCE;
                    }
                    break;
                case -1311914055:
                    if (errorCode.equals("parsing_error")) {
                        return AppError.ParsingError.INSTANCE;
                    }
                    break;
                case -1116990310:
                    if (errorCode.equals("upstream_service_error")) {
                        return AppError.UpstreamServiceError.INSTANCE;
                    }
                    break;
                case -760704159:
                    if (errorCode.equals("parameter_invalid")) {
                        return AppError.InvalidInput.INSTANCE;
                    }
                    break;
                case -693070394:
                    if (errorCode.equals("service_unavailable")) {
                        return AppError.ServiceUnavailable.INSTANCE;
                    }
                    break;
                case -684709872:
                    if (errorCode.equals("missing_parameter")) {
                        return AppError.MissingParameter.INSTANCE;
                    }
                    break;
                case -615077752:
                    if (errorCode.equals("auth_token_expired")) {
                        return AppError.SessionExpired.INSTANCE;
                    }
                    break;
                case -592873500:
                    if (errorCode.equals("authentication_failed")) {
                        return AppError.AuthenticationFailed.INSTANCE;
                    }
                    break;
                case -543084737:
                    if (errorCode.equals("invalid_format")) {
                        return AppError.InvalidFormat.INSTANCE;
                    }
                    break;
                case -444618026:
                    if (errorCode.equals("access_denied")) {
                        return AppError.AccessDenied.INSTANCE;
                    }
                    break;
                case -48151099:
                    if (errorCode.equals("recognition_failed")) {
                        return AppError.RecognitionFailed.INSTANCE;
                    }
                    break;
                case 111447070:
                    if (errorCode.equals("upstream_quota_exceeded")) {
                        return AppError.SystemBusy.INSTANCE;
                    }
                    break;
                case 287616484:
                    if (errorCode.equals("conflict_state")) {
                        return AppError.ConflictState.INSTANCE;
                    }
                    break;
                case 479212403:
                    if (errorCode.equals("upstream_service_timeout")) {
                        return AppError.UpstreamTimeout.INSTANCE;
                    }
                    break;
                case 853012539:
                    if (errorCode.equals("upload_failed")) {
                        return AppError.UploadFailed.INSTANCE;
                    }
                    break;
                case 899045119:
                    if (errorCode.equals("unsupported_media_type")) {
                        return AppError.UnsupportedMediaType.INSTANCE;
                    }
                    break;
                case 1159923504:
                    if (errorCode.equals("content_moderation_failed")) {
                        return AppError.ContentModerationFailed.INSTANCE;
                    }
                    break;
                case 1572077109:
                    if (errorCode.equals("resource_missing")) {
                        return AppError.ResourceMissing.INSTANCE;
                    }
                    break;
                case 1763607241:
                    if (errorCode.equals("auth_token_missing")) {
                        return AppError.NotSignedIn.INSTANCE;
                    }
                    break;
                case 1913058539:
                    if (errorCode.equals("parameter_value_too_long")) {
                        return AppError.InputTooLong.INSTANCE;
                    }
                    break;
                case 2085049119:
                    if (errorCode.equals("payload_too_large")) {
                        return AppError.FileTooLarge.INSTANCE;
                    }
                    break;
            }
        }
        return AppError.UnknownError.INSTANCE;
    }

    public final AppError mapDbError(Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (e instanceof SQLiteConstraintException) {
            String message = e.getMessage();
            return (message == null || !StringsKt.contains$default(message, "UNIQUE", false, 2, (Object) null)) ? AppError.InvalidReference.INSTANCE : AppError.ItemAlreadyExists.INSTANCE;
        }
        if (e instanceof SQLiteFullException) {
            return AppError.StorageFull.INSTANCE;
        }
        if (e instanceof SQLiteDatabaseLockedException) {
            return AppError.DatabaseLocked.INSTANCE;
        }
        if (e instanceof SQLiteDatabaseCorruptException) {
            return AppError.DataCorrupted.INSTANCE;
        }
        return e instanceof IllegalStateException ? AppError.SchemaError.INSTANCE : AppError.UnknownError.INSTANCE;
    }

    public final AppError mapIoError(Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (e instanceof InterruptedIOException) {
            return AppError.UpstreamTimeout.INSTANCE;
        }
        return e instanceof IOException ? AppError.LocalStorageError.INSTANCE : AppError.UnknownError.INSTANCE;
    }
}
