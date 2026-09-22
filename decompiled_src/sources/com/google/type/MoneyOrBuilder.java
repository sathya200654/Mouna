package com.google.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface MoneyOrBuilder extends MessageLiteOrBuilder {
    String getCurrencyCode();

    ByteString getCurrencyCodeBytes();

    int getNanos();

    long getUnits();
}
