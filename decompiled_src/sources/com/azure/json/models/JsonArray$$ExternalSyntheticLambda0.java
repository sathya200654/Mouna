package com.azure.json.models;

import com.azure.json.JsonWriter;
import com.azure.json.WriteValueCallback;
import java.io.IOException;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final /* synthetic */ class JsonArray$$ExternalSyntheticLambda0 implements WriteValueCallback {
    @Override // com.azure.json.WriteValueCallback
    public final void write(Object obj, Object obj2) throws IOException {
        ((JsonWriter) obj).writeJson((JsonElement) obj2);
    }
}
