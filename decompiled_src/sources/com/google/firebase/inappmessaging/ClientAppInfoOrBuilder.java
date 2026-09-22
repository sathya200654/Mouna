package com.google.firebase.inappmessaging;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface ClientAppInfoOrBuilder extends MessageLiteOrBuilder {
    String getFirebaseInstanceId();

    ByteString getFirebaseInstanceIdBytes();

    String getGoogleAppId();

    ByteString getGoogleAppIdBytes();

    boolean hasFirebaseInstanceId();

    boolean hasGoogleAppId();
}
