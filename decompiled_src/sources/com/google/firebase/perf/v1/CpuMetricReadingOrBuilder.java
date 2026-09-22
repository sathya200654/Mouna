package com.google.firebase.perf.v1;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface CpuMetricReadingOrBuilder extends MessageLiteOrBuilder {
    long getClientTimeUs();

    long getSystemTimeUs();

    long getUserTimeUs();

    boolean hasClientTimeUs();

    boolean hasSystemTimeUs();

    boolean hasUserTimeUs();
}
