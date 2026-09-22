package com.azure.core.models;

import com.azure.json.JsonReader;
import com.azure.json.ReadValueCallback;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final /* synthetic */ class GeoPolygon$$ExternalSyntheticLambda2 implements ReadValueCallback {
    @Override // com.azure.json.ReadValueCallback
    public final Object read(Object obj) {
        return GeoLinearRing.fromJson((JsonReader) obj);
    }
}
