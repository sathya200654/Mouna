package com.google.internal.firebase.inappmessaging.v1.sdkserving;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface ClientAppInfoOrBuilder extends MessageLiteOrBuilder {
    String getAppInstanceId();

    ByteString getAppInstanceIdBytes();

    String getAppInstanceIdToken();

    ByteString getAppInstanceIdTokenBytes();

    String getGmpAppId();

    ByteString getGmpAppIdBytes();
}
