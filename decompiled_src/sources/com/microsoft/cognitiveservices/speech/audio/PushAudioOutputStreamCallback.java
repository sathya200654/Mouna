package com.microsoft.cognitiveservices.speech.audio;

import com.microsoft.cognitiveservices.speech.SpeechConfig;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class PushAudioOutputStreamCallback {
    static {
        try {
            Class.forName(SpeechConfig.class.getName());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    public abstract void close();

    public abstract int write(byte[] bArr);
}
