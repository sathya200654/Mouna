package com.microsoft.cognitiveservices.speech.transcription;

import com.microsoft.cognitiveservices.speech.RecognitionEventArgs;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class MeetingTranscriptionEventArgs extends RecognitionEventArgs {
    private MeetingTranscriptionResult result;

    MeetingTranscriptionEventArgs(long j) {
        super(j);
        storeEventData(false);
    }

    MeetingTranscriptionEventArgs(long j, boolean z) {
        super(j);
        storeEventData(z);
    }

    private void storeEventData(boolean z) {
        Contracts.throwIfNull(this.eventHandle, "eventHandle");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getRecognitionResult(this.eventHandle, intRef));
        this.result = new MeetingTranscriptionResult(intRef.getValue());
        Contracts.throwIfNull(getSessionId(), "SessionId");
        if (z) {
            super.close();
        }
    }

    public final MeetingTranscriptionResult getResult() {
        return this.result;
    }

    @Override // com.microsoft.cognitiveservices.speech.RecognitionEventArgs, com.microsoft.cognitiveservices.speech.SessionEventArgs
    public String toString() {
        return "SessionId:" + getSessionId() + " ResultId:" + this.result.getResultId() + " Reason:" + this.result.getReason() + " UserId:" + this.result.getUserId() + " UtteranceId:" + this.result.getUtteranceId() + " Recognized text:<" + this.result.getText() + ">.";
    }
}
