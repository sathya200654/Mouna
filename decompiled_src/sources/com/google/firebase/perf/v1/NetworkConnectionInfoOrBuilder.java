package com.google.firebase.perf.v1;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface NetworkConnectionInfoOrBuilder extends MessageLiteOrBuilder {
    NetworkConnectionInfo.MobileSubtype getMobileSubtype();

    NetworkConnectionInfo.NetworkType getNetworkType();

    boolean hasMobileSubtype();

    boolean hasNetworkType();
}
