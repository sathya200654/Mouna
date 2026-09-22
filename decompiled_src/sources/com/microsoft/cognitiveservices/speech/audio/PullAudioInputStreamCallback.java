package com.microsoft.cognitiveservices.speech.audio;

import com.microsoft.cognitiveservices.speech.PropertyId;
import com.microsoft.cognitiveservices.speech.SpeechConfig;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class PullAudioInputStreamCallback {
    private static final String EMPTY_STRING = "";

    static {
        try {
            Class.forName(SpeechConfig.class.getName());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    public abstract void close();

    public String getProperty(PropertyId propertyId) {
        return "";
    }

    PropertyId getPropertyId(int i) {
        for (PropertyId propertyId : PropertyId.values()) {
            if (i == propertyId.getValue()) {
                return propertyId;
            }
        }
        return null;
    }

    public abstract int read(byte[] bArr);
}
