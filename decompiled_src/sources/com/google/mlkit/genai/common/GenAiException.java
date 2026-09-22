package com.google.mlkit.genai.common;

/* JADX INFO: compiled from: com.google.mlkit:genai-common@@1.0.0-beta1 */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class GenAiException extends Exception {
    private final int zza;

    /* JADX INFO: compiled from: com.google.mlkit:genai-common@@1.0.0-beta1 */
    public @interface ErrorCode {
        public static final int AICORE_INCOMPATIBLE = -101;
        public static final int BUSY = 9;
        public static final int CANCELLED = 7;
        public static final int NEEDS_SYSTEM_UPDATE = 604;
        public static final int NOT_AVAILABLE = 8;
        public static final int NOT_ENOUGH_DISK_SPACE = 501;
        public static final int REQUEST_PROCESSING_ERROR = 4;
        public static final int REQUEST_TOO_LARGE = 12;
        public static final int REQUEST_TOO_SMALL = -100;
        public static final int RESPONSE_GENERATION_ERROR = 15;
        public static final int RESPONSE_PROCESSING_ERROR = 11;
        public static final int UNKNOWN = 0;
    }

    public GenAiException(String str, Throwable th, int i) {
        super(str, th);
        this.zza = i;
    }

    public int getErrorCode() {
        return this.zza;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public GenAiException(Throwable th, int i) {
        String message;
        if (i == -101) {
            message = "AICore is either not installed or the installed version is too low.";
        } else if (i == -100) {
            message = "Request too small. Please provide a longer input.";
        } else if (i == 4) {
            message = "Request doesn't pass certain policy check.";
        } else if (i == 15) {
            message = "Couldn't generate a response. Try a different input.";
        } else if (i == 501) {
            message = "Not enough storage. Please clear some space.";
        } else if (i == 604) {
            message = "Android version is outdated. Please update.";
        } else if (i == 7) {
            message = "Inference is canceled.";
        } else if (i == 8) {
            message = "This feature is not supported on this device.";
        } else if (i == 9) {
            message = "Request cannot be processed. Either your app is out of usage quota (try again later) or the request is from disallowed background usage (use the API while the app is in the foreground).";
        } else if (i == 11) {
            message = "Generated response doesn't pass certain policy check.";
        } else if (i == 12) {
            message = "Request too large. Please shorten your input.";
        } else if (th != null) {
            message = th.getMessage();
            if (message == null) {
                message = "";
            }
        } else {
            message = "Unknown error.";
        }
        super(message, th);
        this.zza = i;
    }
}
