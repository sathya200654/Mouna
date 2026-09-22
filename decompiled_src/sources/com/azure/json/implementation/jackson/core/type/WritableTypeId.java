package com.azure.json.implementation.jackson.core.type;

import com.azure.json.implementation.jackson.core.JsonToken;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class WritableTypeId {
    public Object extra;
    public Object forValue;
    public Object id;
    public Inclusion include;
    public JsonToken valueShape;

    public enum Inclusion {
        WRAPPER_ARRAY,
        WRAPPER_OBJECT,
        METADATA_PROPERTY,
        PARENT_PROPERTY
    }

    public WritableTypeId(Object obj, JsonToken jsonToken, Object obj2) {
        this.forValue = obj;
        this.id = obj2;
        this.valueShape = jsonToken;
    }
}
