package com.google.mediapipe.framework;

import com.azure.core.implementation.SemanticVersion;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class MediaPipeException extends RuntimeException {
    private final StatusCode statusCode;
    private final String statusMessage;

    public MediaPipeException(int statusCode, String statusMessage) {
        super(StatusCode.values()[statusCode].description() + ": " + statusMessage);
        this.statusCode = StatusCode.values()[statusCode];
        this.statusMessage = statusMessage;
    }

    MediaPipeException(int code, byte[] message) {
        this(code, new String(message, StandardCharsets.UTF_8));
    }

    public StatusCode getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public enum StatusCode {
        OK("ok"),
        CANCELLED("canceled"),
        UNKNOWN(SemanticVersion.UNKNOWN_VERSION),
        INVALID_ARGUMENT("invalid argument"),
        DEADLINE_EXCEEDED("deadline exceeded"),
        NOT_FOUND("not found"),
        ALREADY_EXISTS("already exists"),
        PERMISSION_DENIED("permission denied"),
        RESOURCE_EXHAUSTED("resource exhausted"),
        FAILED_PRECONDITION("failed precondition"),
        ABORTED("aborted"),
        OUT_OF_RANGE("out of range"),
        UNIMPLEMENTED("unimplemented"),
        INTERNAL("internal"),
        UNAVAILABLE("unavailable"),
        DATA_LOSS("data loss"),
        UNAUTHENTICATED("unauthenticated"),
        IO_EXCEPTION("i/o exception");

        private final String description;

        StatusCode(String description) {
            this.description = description;
        }

        public String description() {
            return this.description;
        }
    }
}
