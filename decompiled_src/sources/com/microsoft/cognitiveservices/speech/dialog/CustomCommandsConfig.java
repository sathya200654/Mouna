package com.microsoft.cognitiveservices.speech.dialog;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.microsoft.cognitiveservices.speech.PropertyId;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class CustomCommandsConfig extends DialogServiceConfig {
    private CustomCommandsConfig(long j) {
        super(j);
    }

    private static final native long fromAuthorizationToken(IntRef intRef, String str, String str2, String str3);

    public static CustomCommandsConfig fromAuthorizationToken(String str, String str2, String str3) {
        Contracts.throwIfNull(str, RemoteConfigConstants.RequestFieldKey.APP_ID);
        Contracts.throwIfNullOrWhitespace(str2, "authorizationToken");
        Contracts.throwIfNullOrWhitespace(str3, "region");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(fromAuthorizationToken(intRef, str, str2, str3));
        return new CustomCommandsConfig(intRef.getValue());
    }

    private static final native long fromSubscription(IntRef intRef, String str, String str2, String str3);

    public static CustomCommandsConfig fromSubscription(String str, String str2, String str3) {
        Contracts.throwIfNull(str, RemoteConfigConstants.RequestFieldKey.APP_ID);
        Contracts.throwIfNull(str2, "subscription");
        Contracts.throwIfNull(str3, "region");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(fromSubscription(intRef, str, str2, str3));
        return new CustomCommandsConfig(intRef.getValue());
    }

    public String getApplicationId() {
        return getProperty(PropertyId.Conversation_ApplicationId);
    }

    public void setApplicationId(String str) {
        setProperty(PropertyId.Conversation_ApplicationId, str);
    }
}
