package com.google.rpc;

import com.google.protobuf.Duration;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface RetryInfoOrBuilder extends MessageLiteOrBuilder {
    Duration getRetryDelay();

    boolean hasRetryDelay();
}
