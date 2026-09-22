package com.google.mediapipe.framework;

import com.google.protobuf.MessageLite;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
interface TypeNameRegistry {
    <T extends MessageLite> String getTypeName(Class<T> clazz);

    <T extends MessageLite> void registerTypeName(Class<T> clazz, String typeName);
}
