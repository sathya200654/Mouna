package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class SpeechSynthesisRequest implements AutoCloseable {
    private SpeechSynthesisInputStream inputStream;
    private PropertyCollection properties;
    private SafeHandle requestHandle;

    public class SpeechSynthesisInputStream implements AutoCloseable {
        private SpeechSynthesisRequest parentRequest;

        SpeechSynthesisInputStream(SpeechSynthesisRequest speechSynthesisRequest) {
            this.parentRequest = speechSynthesisRequest;
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            this.parentRequest.finishInput();
        }

        public void write(String str) {
            this.parentRequest.sendTextPiece(str);
        }
    }

    public enum SpeechSynthesisRequestInputType {
        None,
        Text,
        SSML,
        TextStream
    }

    public SpeechSynthesisRequest(SpeechSynthesisRequestInputType speechSynthesisRequestInputType) {
        this.requestHandle = null;
        if (speechSynthesisRequestInputType != SpeechSynthesisRequestInputType.TextStream) {
            throw new UnsupportedOperationException("Only text streaming is supported in this version.");
        }
        SafeHandle safeHandle = new SafeHandle(0L, SafeHandleType.SynthesisRequest);
        this.requestHandle = safeHandle;
        Contracts.throwIfFail(createRequest(safeHandle));
        this.inputStream = new SpeechSynthesisInputStream(this);
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getPropertyBag(this.requestHandle, intRef));
        this.properties = new PropertyCollection(intRef);
    }

    private final native long createRequest(SafeHandle safeHandle);

    private final native long getPropertyBag(SafeHandle safeHandle, IntRef intRef);

    private final native void releaseRequest(SafeHandle safeHandle);

    private final native long requestFinish(SafeHandle safeHandle);

    private final native long requestSendTextPiece(SafeHandle safeHandle, String str);

    @Override // java.lang.AutoCloseable
    public void close() {
        SpeechSynthesisInputStream speechSynthesisInputStream = this.inputStream;
        if (speechSynthesisInputStream != null) {
            speechSynthesisInputStream.close();
            this.inputStream = null;
        }
        PropertyCollection propertyCollection = this.properties;
        if (propertyCollection != null) {
            propertyCollection.close();
            this.properties = null;
        }
        SafeHandle safeHandle = this.requestHandle;
        if (safeHandle != null) {
            releaseRequest(safeHandle);
            this.requestHandle = null;
        }
    }

    public void finishInput() {
        Contracts.throwIfFail(requestFinish(this.requestHandle));
    }

    public SpeechSynthesisInputStream getInputStream() {
        return this.inputStream;
    }

    public SafeHandle getRequestHandle() {
        return this.requestHandle;
    }

    public void sendTextPiece(String str) {
        if (str == null) {
            throw new NullPointerException("text cannot be null");
        }
        Contracts.throwIfFail(requestSendTextPiece(this.requestHandle, str));
    }

    public void setPitch(String str) {
        this.properties.setProperty(PropertyId.SpeechSynthesisRequest_Pitch, str);
    }

    public void setRate(String str) {
        this.properties.setProperty(PropertyId.SpeechSynthesisRequest_Rate, str);
    }

    public void setStyle(String str) {
        this.properties.setProperty(PropertyId.SpeechSynthesisRequest_Style, str);
    }

    public void setTemperature(double d) {
        this.properties.setProperty(PropertyId.SpeechSynthesisRequest_Temperature, String.valueOf(d));
    }

    public void setVolume(String str) {
        this.properties.setProperty(PropertyId.SpeechSynthesisRequest_Volume, str);
    }
}
