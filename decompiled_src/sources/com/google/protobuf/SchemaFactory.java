package com.google.protobuf;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@CheckReturnValue
interface SchemaFactory {
    <T> Schema<T> createSchema(Class<T> messageType);
}
