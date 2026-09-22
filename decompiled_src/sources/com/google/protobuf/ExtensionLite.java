package com.google.protobuf;

import com.google.protobuf.MessageLite;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class ExtensionLite<ContainingType extends MessageLite, Type> {
    public abstract Type getDefaultValue();

    public abstract WireFormat.FieldType getLiteType();

    public abstract MessageLite getMessageDefaultInstance();

    public abstract int getNumber();

    boolean isLite() {
        return true;
    }

    public abstract boolean isRepeated();
}
