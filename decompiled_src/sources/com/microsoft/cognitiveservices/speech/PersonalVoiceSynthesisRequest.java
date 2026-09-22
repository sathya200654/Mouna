package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class PersonalVoiceSynthesisRequest extends SpeechSynthesisRequest {
    public PersonalVoiceSynthesisRequest(SpeechSynthesisRequest.SpeechSynthesisRequestInputType speechSynthesisRequestInputType, String str, String str2) {
        super(speechSynthesisRequestInputType);
        if (speechSynthesisRequestInputType != SpeechSynthesisRequest.SpeechSynthesisRequestInputType.TextStream) {
            throw new UnsupportedOperationException("Only text streaming is supported for personal voice synthesis.");
        }
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("personalVoiceName cannot be null or empty");
        }
        if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException("modelName cannot be null or empty");
        }
        Contracts.throwIfFail(setVoice(getRequestHandle(), null, str, str2));
    }

    private final native int setVoice(SafeHandle safeHandle, String str, String str2, String str3);
}
