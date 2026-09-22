package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.annotations.ExtraProperty;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@ExtraProperty
public @interface Protobuf {

    public enum IntEncoding {
        DEFAULT,
        SIGNED,
        FIXED
    }

    IntEncoding intEncoding() default IntEncoding.DEFAULT;

    int tag();
}
