package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.mappers;

import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechErrorType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpeechErrorMapper.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toErrorMessageRes", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/model/SpeechErrorType;", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SpeechErrorMapperKt {

    /* JADX INFO: compiled from: SpeechErrorMapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SpeechErrorType.values().length];
            try {
                iArr[SpeechErrorType.SERVICE_NOT_READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SpeechErrorType.INITIALIZATION_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SpeechErrorType.START_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SpeechErrorType.STOP_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SpeechErrorType.TRANSCRIPTION_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SpeechErrorType.AUTH_FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SpeechErrorType.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final int toErrorMessageRes(SpeechErrorType speechErrorType) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter(speechErrorType, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[speechErrorType.ordinal()]) {
            case 1:
                return R.string.speech_service_not_ready_error;
            case 2:
                return R.string.speech_initialization_failed_error;
            case 3:
                return R.string.speech_start_failed_error;
            case 4:
                return R.string.speech_stop_failed_error;
            case 5:
                return R.string.speech_transcription_error;
            case 6:
                return R.string.speech_auth_failed_error;
            case 7:
                return R.string.speech_unknown_error;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
