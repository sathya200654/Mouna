package com.azure.core.models;

import com.fasterxml.jackson.annotation.JsonValue;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
enum JsonPatchOperationKind {
    ADD("add"),
    REMOVE("remove"),
    REPLACE("replace"),
    MOVE("move"),
    COPY("copy"),
    TEST("test");

    private final String op;

    JsonPatchOperationKind(String str) {
        this.op = str;
    }

    static JsonPatchOperationKind fromString(String str) {
        if (str == null) {
            return null;
        }
        for (JsonPatchOperationKind jsonPatchOperationKind : values()) {
            if (jsonPatchOperationKind.op.equals(str)) {
                return jsonPatchOperationKind;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    @JsonValue
    public String toString() {
        return this.op;
    }
}
