package com.google.protobuf;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@CheckReturnValue
final class NewInstanceSchemaLite implements NewInstanceSchema {
    NewInstanceSchemaLite() {
    }

    @Override // com.google.protobuf.NewInstanceSchema
    public Object newInstance(Object defaultInstance) {
        return ((GeneratedMessageLite) defaultInstance).newMutableInstance();
    }
}
