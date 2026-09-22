package com.azure.json.models;

import com.azure.json.JsonReader;
import com.azure.json.ReadValueCallback;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final /* synthetic */ class JsonArray$$ExternalSyntheticLambda1 implements ReadValueCallback {
    @Override // com.azure.json.ReadValueCallback
    public final Object read(Object obj) {
        return JsonElement.fromJson((JsonReader) obj);
    }
}
