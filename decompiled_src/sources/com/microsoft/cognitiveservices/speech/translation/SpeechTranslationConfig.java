package com.microsoft.cognitiveservices.speech.translation;

import com.azure.core.credential.KeyCredential;
import com.azure.core.credential.TokenCredential;
import com.microsoft.cognitiveservices.speech.PropertyId;
import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import java.net.URI;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class SpeechTranslationConfig extends SpeechConfig implements AutoCloseable {
    private boolean disposed;
    private TokenCredential tokenCredential;

    static {
        try {
            Class.forName(SpeechConfig.class.getName());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    private SpeechTranslationConfig(long j) {
        super(j);
        this.tokenCredential = null;
        this.disposed = false;
    }

    private SpeechTranslationConfig(long j, TokenCredential tokenCredential) {
        this(j);
        this.tokenCredential = tokenCredential;
    }

    private final native long addTargetLanguage(SafeHandle safeHandle, String str);

    private static final native long fromAuthorizationToken(IntRef intRef, String str, String str2);

    public static SpeechTranslationConfig fromAuthorizationToken(String str, String str2) {
        Contracts.throwIfNullOrWhitespace(str, "authorizationToken");
        Contracts.throwIfNullOrWhitespace(str2, "region");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(fromAuthorizationToken(intRef, str, str2));
        return new SpeechTranslationConfig(intRef.getValue());
    }

    private static final native long fromEndpoint(IntRef intRef, String str, String str2);

    public static SpeechTranslationConfig fromEndpoint(URI uri) {
        Contracts.throwIfNull(uri, "endpoint");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(fromEndpoint(intRef, uri.toString(), null));
        return new SpeechTranslationConfig(intRef.getValue());
    }

    public static SpeechTranslationConfig fromEndpoint(URI uri, KeyCredential keyCredential) {
        Contracts.throwIfNull(uri, "endpoint");
        Contracts.throwIfNull(keyCredential, "keyCredential");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(fromEndpoint(intRef, uri.toString(), keyCredential.getKey()));
        return new SpeechTranslationConfig(intRef.getValue());
    }

    public static SpeechTranslationConfig fromEndpoint(URI uri, TokenCredential tokenCredential) {
        Contracts.throwIfNull(uri, "endpoint");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(fromEndpoint(intRef, uri.toString(), null));
        return new SpeechTranslationConfig(intRef.getValue(), tokenCredential);
    }

    public static SpeechTranslationConfig fromEndpoint(URI uri, String str) {
        Contracts.throwIfNull(uri, "endpoint");
        if (str == null) {
            throw new NullPointerException("subscriptionKey");
        }
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(fromEndpoint(intRef, uri.toString(), str));
        return new SpeechTranslationConfig(intRef.getValue());
    }

    private static final native long fromHost(IntRef intRef, String str, String str2);

    public static SpeechTranslationConfig fromHost(URI uri) {
        Contracts.throwIfNull(uri, "host");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(fromHost(intRef, uri.toString(), null));
        return new SpeechTranslationConfig(intRef.getValue());
    }

    public static SpeechTranslationConfig fromHost(URI uri, String str) {
        Contracts.throwIfNull(uri, "host");
        if (str == null) {
            throw new NullPointerException("subscriptionKey");
        }
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(fromHost(intRef, uri.toString(), str));
        return new SpeechTranslationConfig(intRef.getValue());
    }

    private static final native long fromSubscription(IntRef intRef, String str, String str2);

    public static SpeechTranslationConfig fromSubscription(String str, String str2) {
        Contracts.throwIfIllegalSubscriptionKey(str, "subscriptionKey");
        Contracts.throwIfNullOrWhitespace(str2, "region");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(fromSubscription(intRef, str, str2));
        return new SpeechTranslationConfig(intRef.getValue());
    }

    private final native long removeTargetLanguage(SafeHandle safeHandle, String str);

    private final native long setCustomModelCategoryId(SafeHandle safeHandle, String str);

    public void addTargetLanguage(String str) {
        Contracts.throwIfNullOrWhitespace(str, "value");
        Contracts.throwIfFail(addTargetLanguage(super.getImpl(), str));
    }

    @Override // com.microsoft.cognitiveservices.speech.SpeechConfig, java.lang.AutoCloseable
    public void close() {
        if (this.disposed) {
            return;
        }
        super.close();
        this.disposed = true;
    }

    @Override // com.microsoft.cognitiveservices.speech.SpeechConfig
    public SafeHandle getImpl() {
        return super.getImpl();
    }

    public ArrayList<String> getTargetLanguages() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : getProperty(PropertyId.SpeechServiceConnection_TranslationToLanguages).split(",")) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.microsoft.cognitiveservices.speech.SpeechConfig
    public TokenCredential getTokenCredential() {
        return this.tokenCredential;
    }

    public String getVoiceName() {
        return getProperty(PropertyId.SpeechServiceConnection_TranslationVoice);
    }

    public void removeTargetLanguage(String str) {
        Contracts.throwIfNullOrWhitespace(str, "value");
        Contracts.throwIfFail(removeTargetLanguage(super.getImpl(), str));
    }

    public void setCustomModelCategoryId(String str) {
        Contracts.throwIfNullOrWhitespace(str, "categoryId");
        Contracts.throwIfFail(setCustomModelCategoryId(super.getImpl(), str));
    }

    public void setVoiceName(String str) {
        Contracts.throwIfNullOrWhitespace(str, "value");
        setProperty(PropertyId.SpeechServiceConnection_TranslationVoice, str);
    }
}
