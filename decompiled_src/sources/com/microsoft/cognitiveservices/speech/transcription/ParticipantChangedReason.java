package com.microsoft.cognitiveservices.speech.transcription;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public enum ParticipantChangedReason {
    JoinedConversation(0),
    LeftConversation(1),
    Updated(2);

    private final int id;

    ParticipantChangedReason(int i) {
        this.id = i;
    }

    public int getValue() {
        return this.id;
    }
}
