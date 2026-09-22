package com.google.protobuf;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@CheckReturnValue
interface MessageInfoFactory {
    boolean isSupported(Class<?> clazz);

    MessageInfo messageInfoFor(Class<?> clazz);
}
