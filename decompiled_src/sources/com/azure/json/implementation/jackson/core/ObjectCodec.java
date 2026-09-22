package com.azure.json.implementation.jackson.core;

import com.azure.json.implementation.jackson.core.type.TypeReference;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class ObjectCodec extends TreeCodec implements Versioned {
    public abstract <T> T readValue(JsonParser jsonParser, TypeReference<T> typeReference) throws IOException;

    public abstract <T> T readValue(JsonParser jsonParser, Class<T> cls) throws IOException;

    @Override // com.azure.json.implementation.jackson.core.Versioned
    public abstract Version version();

    @Override // com.azure.json.implementation.jackson.core.TreeCodec
    public abstract void writeTree(JsonGenerator jsonGenerator, TreeNode treeNode) throws IOException;

    public abstract void writeValue(JsonGenerator jsonGenerator, Object obj) throws IOException;

    protected ObjectCodec() {
    }

    @Deprecated
    public JsonFactory getJsonFactory() {
        return getFactory();
    }

    public JsonFactory getFactory() {
        return getJsonFactory();
    }
}
