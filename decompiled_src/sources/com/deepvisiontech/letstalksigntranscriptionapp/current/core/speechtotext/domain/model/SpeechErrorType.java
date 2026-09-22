package com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: SpeechErrorType.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/model/SpeechErrorType;", "", "<init>", "(Ljava/lang/String;I)V", "SERVICE_NOT_READY", "INITIALIZATION_FAILED", "START_FAILED", "STOP_FAILED", "TRANSCRIPTION_ERROR", "AUTH_FAILED", "UNKNOWN", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum SpeechErrorType {
    SERVICE_NOT_READY,
    INITIALIZATION_FAILED,
    START_FAILED,
    STOP_FAILED,
    TRANSCRIPTION_ERROR,
    AUTH_FAILED,
    UNKNOWN;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<SpeechErrorType> getEntries() {
        return $ENTRIES;
    }
}
