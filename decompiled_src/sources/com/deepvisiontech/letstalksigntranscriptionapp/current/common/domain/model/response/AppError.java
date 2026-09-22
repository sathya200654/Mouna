package com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response;

import kotlin.Metadata;

/* JADX INFO: compiled from: AppError.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:/\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0\u0082\u0001/123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_¨\u0006`À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "", "UnknownError", "ServerError", "ParsingError", "UpstreamServiceError", "ServiceUnavailable", "UpstreamTimeout", "SystemBusy", "ProcessingFailed", "MissingParameter", "InputTooLong", "InvalidInput", "InvalidFormat", "ContentModerationFailed", "MissingRequiredField", "InvalidReference", "UploadFailed", "FileTooLarge", "UnsupportedMediaType", "UnsupportedVideoUrlError", "UnsupportedPdfUrlError", "UnsupportedSocialUrlError", "UnsupportedImageUrlError", "UnsupportedDriveUrlError", "RecognitionFailed", "AuthenticationFailed", "NotSignedIn", "SessionExpired", "AccessDenied", "QuotaExceeded", "ResourceMissing", "ConflictState", "ItemAlreadyExists", "RecordNotFound", "StorageFull", "DataCorrupted", "DatabaseLocked", "SchemaError", "LocalStorageError", "TextToSpeechFailed", "TextToSpeechTimeout", "AvatarRendererCrashed", "AvatarLoadTimeout", "AvatarAssetLoadFailed", "AvatarClipMissing", "AvatarInternalError", "AvatarSecurityError", "LanguageError", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$AccessDenied;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$AuthenticationFailed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$AvatarAssetLoadFailed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$AvatarClipMissing;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$AvatarInternalError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$AvatarLoadTimeout;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$AvatarRendererCrashed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$AvatarSecurityError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$ConflictState;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$ContentModerationFailed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$DataCorrupted;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$DatabaseLocked;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$FileTooLarge;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$InputTooLong;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$InvalidFormat;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$InvalidInput;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$InvalidReference;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$ItemAlreadyExists;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$LanguageError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$LocalStorageError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$MissingParameter;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$MissingRequiredField;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$NotSignedIn;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$ParsingError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$ProcessingFailed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$QuotaExceeded;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$RecognitionFailed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$RecordNotFound;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$ResourceMissing;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$SchemaError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$ServerError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$ServiceUnavailable;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$SessionExpired;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$StorageFull;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$SystemBusy;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$TextToSpeechFailed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$TextToSpeechTimeout;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$UnknownError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$UnsupportedDriveUrlError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$UnsupportedImageUrlError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$UnsupportedMediaType;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$UnsupportedPdfUrlError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$UnsupportedSocialUrlError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$UnsupportedVideoUrlError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$UploadFailed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$UpstreamServiceError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$UpstreamTimeout;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AppError {

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$UnknownError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UnknownError implements AppError {
        public static final int $stable = 0;
        public static final UnknownError INSTANCE = new UnknownError();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UnknownError)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1928750400;
        }

        public String toString() {
            return "UnknownError";
        }

        private UnknownError() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$ServerError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ServerError implements AppError {
        public static final int $stable = 0;
        public static final ServerError INSTANCE = new ServerError();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ServerError)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 708378339;
        }

        public String toString() {
            return "ServerError";
        }

        private ServerError() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$ParsingError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ParsingError implements AppError {
        public static final int $stable = 0;
        public static final ParsingError INSTANCE = new ParsingError();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ParsingError)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -118994278;
        }

        public String toString() {
            return "ParsingError";
        }

        private ParsingError() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$UpstreamServiceError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UpstreamServiceError implements AppError {
        public static final int $stable = 0;
        public static final UpstreamServiceError INSTANCE = new UpstreamServiceError();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpstreamServiceError)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1640478000;
        }

        public String toString() {
            return "UpstreamServiceError";
        }

        private UpstreamServiceError() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$ServiceUnavailable;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ServiceUnavailable implements AppError {
        public static final int $stable = 0;
        public static final ServiceUnavailable INSTANCE = new ServiceUnavailable();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ServiceUnavailable)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 188212797;
        }

        public String toString() {
            return "ServiceUnavailable";
        }

        private ServiceUnavailable() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$UpstreamTimeout;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UpstreamTimeout implements AppError {
        public static final int $stable = 0;
        public static final UpstreamTimeout INSTANCE = new UpstreamTimeout();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpstreamTimeout)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1206860188;
        }

        public String toString() {
            return "UpstreamTimeout";
        }

        private UpstreamTimeout() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$SystemBusy;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SystemBusy implements AppError {
        public static final int $stable = 0;
        public static final SystemBusy INSTANCE = new SystemBusy();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SystemBusy)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1249211734;
        }

        public String toString() {
            return "SystemBusy";
        }

        private SystemBusy() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$ProcessingFailed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ProcessingFailed implements AppError {
        public static final int $stable = 0;
        public static final ProcessingFailed INSTANCE = new ProcessingFailed();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ProcessingFailed)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1265015406;
        }

        public String toString() {
            return "ProcessingFailed";
        }

        private ProcessingFailed() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$MissingParameter;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class MissingParameter implements AppError {
        public static final int $stable = 0;
        public static final MissingParameter INSTANCE = new MissingParameter();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MissingParameter)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -852290235;
        }

        public String toString() {
            return "MissingParameter";
        }

        private MissingParameter() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$InputTooLong;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class InputTooLong implements AppError {
        public static final int $stable = 0;
        public static final InputTooLong INSTANCE = new InputTooLong();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InputTooLong)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1177547736;
        }

        public String toString() {
            return "InputTooLong";
        }

        private InputTooLong() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$InvalidInput;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class InvalidInput implements AppError {
        public static final int $stable = 0;
        public static final InvalidInput INSTANCE = new InvalidInput();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvalidInput)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -516150923;
        }

        public String toString() {
            return "InvalidInput";
        }

        private InvalidInput() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$InvalidFormat;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class InvalidFormat implements AppError {
        public static final int $stable = 0;
        public static final InvalidFormat INSTANCE = new InvalidFormat();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvalidFormat)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1094278060;
        }

        public String toString() {
            return "InvalidFormat";
        }

        private InvalidFormat() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$ContentModerationFailed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ContentModerationFailed implements AppError {
        public static final int $stable = 0;
        public static final ContentModerationFailed INSTANCE = new ContentModerationFailed();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ContentModerationFailed)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1861454598;
        }

        public String toString() {
            return "ContentModerationFailed";
        }

        private ContentModerationFailed() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$MissingRequiredField;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class MissingRequiredField implements AppError {
        public static final int $stable = 0;
        public static final MissingRequiredField INSTANCE = new MissingRequiredField();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MissingRequiredField)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 2080515127;
        }

        public String toString() {
            return "MissingRequiredField";
        }

        private MissingRequiredField() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$InvalidReference;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class InvalidReference implements AppError {
        public static final int $stable = 0;
        public static final InvalidReference INSTANCE = new InvalidReference();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvalidReference)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1900723338;
        }

        public String toString() {
            return "InvalidReference";
        }

        private InvalidReference() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$UploadFailed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UploadFailed implements AppError {
        public static final int $stable = 0;
        public static final UploadFailed INSTANCE = new UploadFailed();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UploadFailed)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1194023680;
        }

        public String toString() {
            return "UploadFailed";
        }

        private UploadFailed() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$FileTooLarge;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FileTooLarge implements AppError {
        public static final int $stable = 0;
        public static final FileTooLarge INSTANCE = new FileTooLarge();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileTooLarge)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 991292741;
        }

        public String toString() {
            return "FileTooLarge";
        }

        private FileTooLarge() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$UnsupportedMediaType;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UnsupportedMediaType implements AppError {
        public static final int $stable = 0;
        public static final UnsupportedMediaType INSTANCE = new UnsupportedMediaType();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UnsupportedMediaType)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1279976981;
        }

        public String toString() {
            return "UnsupportedMediaType";
        }

        private UnsupportedMediaType() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$UnsupportedVideoUrlError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UnsupportedVideoUrlError implements AppError {
        public static final int $stable = 0;
        public static final UnsupportedVideoUrlError INSTANCE = new UnsupportedVideoUrlError();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UnsupportedVideoUrlError)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -140570207;
        }

        public String toString() {
            return "UnsupportedVideoUrlError";
        }

        private UnsupportedVideoUrlError() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$UnsupportedPdfUrlError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UnsupportedPdfUrlError implements AppError {
        public static final int $stable = 0;
        public static final UnsupportedPdfUrlError INSTANCE = new UnsupportedPdfUrlError();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UnsupportedPdfUrlError)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 428797528;
        }

        public String toString() {
            return "UnsupportedPdfUrlError";
        }

        private UnsupportedPdfUrlError() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$UnsupportedSocialUrlError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UnsupportedSocialUrlError implements AppError {
        public static final int $stable = 0;
        public static final UnsupportedSocialUrlError INSTANCE = new UnsupportedSocialUrlError();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UnsupportedSocialUrlError)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -390786087;
        }

        public String toString() {
            return "UnsupportedSocialUrlError";
        }

        private UnsupportedSocialUrlError() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$UnsupportedImageUrlError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UnsupportedImageUrlError implements AppError {
        public static final int $stable = 0;
        public static final UnsupportedImageUrlError INSTANCE = new UnsupportedImageUrlError();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UnsupportedImageUrlError)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1492567681;
        }

        public String toString() {
            return "UnsupportedImageUrlError";
        }

        private UnsupportedImageUrlError() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$UnsupportedDriveUrlError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UnsupportedDriveUrlError implements AppError {
        public static final int $stable = 0;
        public static final UnsupportedDriveUrlError INSTANCE = new UnsupportedDriveUrlError();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UnsupportedDriveUrlError)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -833415248;
        }

        public String toString() {
            return "UnsupportedDriveUrlError";
        }

        private UnsupportedDriveUrlError() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$RecognitionFailed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class RecognitionFailed implements AppError {
        public static final int $stable = 0;
        public static final RecognitionFailed INSTANCE = new RecognitionFailed();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RecognitionFailed)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1065981618;
        }

        public String toString() {
            return "RecognitionFailed";
        }

        private RecognitionFailed() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$AuthenticationFailed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AuthenticationFailed implements AppError {
        public static final int $stable = 0;
        public static final AuthenticationFailed INSTANCE = new AuthenticationFailed();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AuthenticationFailed)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 305608759;
        }

        public String toString() {
            return "AuthenticationFailed";
        }

        private AuthenticationFailed() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$NotSignedIn;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NotSignedIn implements AppError {
        public static final int $stable = 0;
        public static final NotSignedIn INSTANCE = new NotSignedIn();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NotSignedIn)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -2073106510;
        }

        public String toString() {
            return "NotSignedIn";
        }

        private NotSignedIn() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$SessionExpired;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SessionExpired implements AppError {
        public static final int $stable = 0;
        public static final SessionExpired INSTANCE = new SessionExpired();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SessionExpired)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1021446289;
        }

        public String toString() {
            return "SessionExpired";
        }

        private SessionExpired() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$AccessDenied;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AccessDenied implements AppError {
        public static final int $stable = 0;
        public static final AccessDenied INSTANCE = new AccessDenied();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AccessDenied)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 546280321;
        }

        public String toString() {
            return "AccessDenied";
        }

        private AccessDenied() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$QuotaExceeded;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class QuotaExceeded implements AppError {
        public static final int $stable = 0;
        public static final QuotaExceeded INSTANCE = new QuotaExceeded();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QuotaExceeded)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1386920137;
        }

        public String toString() {
            return "QuotaExceeded";
        }

        private QuotaExceeded() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$ResourceMissing;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ResourceMissing implements AppError {
        public static final int $stable = 0;
        public static final ResourceMissing INSTANCE = new ResourceMissing();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResourceMissing)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1836459222;
        }

        public String toString() {
            return "ResourceMissing";
        }

        private ResourceMissing() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$ConflictState;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ConflictState implements AppError {
        public static final int $stable = 0;
        public static final ConflictState INSTANCE = new ConflictState();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConflictState)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -399419715;
        }

        public String toString() {
            return "ConflictState";
        }

        private ConflictState() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$ItemAlreadyExists;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ItemAlreadyExists implements AppError {
        public static final int $stable = 0;
        public static final ItemAlreadyExists INSTANCE = new ItemAlreadyExists();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ItemAlreadyExists)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 849475167;
        }

        public String toString() {
            return "ItemAlreadyExists";
        }

        private ItemAlreadyExists() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$RecordNotFound;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class RecordNotFound implements AppError {
        public static final int $stable = 0;
        public static final RecordNotFound INSTANCE = new RecordNotFound();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RecordNotFound)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1819998402;
        }

        public String toString() {
            return "RecordNotFound";
        }

        private RecordNotFound() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$StorageFull;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class StorageFull implements AppError {
        public static final int $stable = 0;
        public static final StorageFull INSTANCE = new StorageFull();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StorageFull)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 965041672;
        }

        public String toString() {
            return "StorageFull";
        }

        private StorageFull() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$DataCorrupted;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class DataCorrupted implements AppError {
        public static final int $stable = 0;
        public static final DataCorrupted INSTANCE = new DataCorrupted();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DataCorrupted)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -349377088;
        }

        public String toString() {
            return "DataCorrupted";
        }

        private DataCorrupted() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$DatabaseLocked;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class DatabaseLocked implements AppError {
        public static final int $stable = 0;
        public static final DatabaseLocked INSTANCE = new DatabaseLocked();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DatabaseLocked)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1706764615;
        }

        public String toString() {
            return "DatabaseLocked";
        }

        private DatabaseLocked() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$SchemaError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SchemaError implements AppError {
        public static final int $stable = 0;
        public static final SchemaError INSTANCE = new SchemaError();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SchemaError)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 456475461;
        }

        public String toString() {
            return "SchemaError";
        }

        private SchemaError() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$LocalStorageError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class LocalStorageError implements AppError {
        public static final int $stable = 0;
        public static final LocalStorageError INSTANCE = new LocalStorageError();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LocalStorageError)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1820140746;
        }

        public String toString() {
            return "LocalStorageError";
        }

        private LocalStorageError() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$TextToSpeechFailed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TextToSpeechFailed implements AppError {
        public static final int $stable = 0;
        public static final TextToSpeechFailed INSTANCE = new TextToSpeechFailed();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TextToSpeechFailed)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1892898889;
        }

        public String toString() {
            return "TextToSpeechFailed";
        }

        private TextToSpeechFailed() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$TextToSpeechTimeout;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TextToSpeechTimeout implements AppError {
        public static final int $stable = 0;
        public static final TextToSpeechTimeout INSTANCE = new TextToSpeechTimeout();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TextToSpeechTimeout)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1676997931;
        }

        public String toString() {
            return "TextToSpeechTimeout";
        }

        private TextToSpeechTimeout() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$AvatarRendererCrashed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AvatarRendererCrashed implements AppError {
        public static final int $stable = 0;
        public static final AvatarRendererCrashed INSTANCE = new AvatarRendererCrashed();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AvatarRendererCrashed)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1663499912;
        }

        public String toString() {
            return "AvatarRendererCrashed";
        }

        private AvatarRendererCrashed() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$AvatarLoadTimeout;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AvatarLoadTimeout implements AppError {
        public static final int $stable = 0;
        public static final AvatarLoadTimeout INSTANCE = new AvatarLoadTimeout();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AvatarLoadTimeout)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1025192544;
        }

        public String toString() {
            return "AvatarLoadTimeout";
        }

        private AvatarLoadTimeout() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$AvatarAssetLoadFailed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AvatarAssetLoadFailed implements AppError {
        public static final int $stable = 0;
        public static final AvatarAssetLoadFailed INSTANCE = new AvatarAssetLoadFailed();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AvatarAssetLoadFailed)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1472377368;
        }

        public String toString() {
            return "AvatarAssetLoadFailed";
        }

        private AvatarAssetLoadFailed() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$AvatarClipMissing;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AvatarClipMissing implements AppError {
        public static final int $stable = 0;
        public static final AvatarClipMissing INSTANCE = new AvatarClipMissing();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AvatarClipMissing)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 854940859;
        }

        public String toString() {
            return "AvatarClipMissing";
        }

        private AvatarClipMissing() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$AvatarInternalError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AvatarInternalError implements AppError {
        public static final int $stable = 0;
        public static final AvatarInternalError INSTANCE = new AvatarInternalError();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AvatarInternalError)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -2023691056;
        }

        public String toString() {
            return "AvatarInternalError";
        }

        private AvatarInternalError() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$AvatarSecurityError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AvatarSecurityError implements AppError {
        public static final int $stable = 0;
        public static final AvatarSecurityError INSTANCE = new AvatarSecurityError();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AvatarSecurityError)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -259582419;
        }

        public String toString() {
            return "AvatarSecurityError";
        }

        private AvatarSecurityError() {
        }
    }

    /* JADX INFO: compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError$LanguageError;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class LanguageError implements AppError {
        public static final int $stable = 0;
        public static final LanguageError INSTANCE = new LanguageError();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LanguageError)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -2080915346;
        }

        public String toString() {
            return "LanguageError";
        }

        private LanguageError() {
        }
    }
}
