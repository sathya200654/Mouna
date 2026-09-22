package com.azure.core.models;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.json.ReadValueCallback;
import com.azure.json.WriteValueCallback;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class GeoLineStringCollection extends GeoObject {
    private final List<GeoLineString> lines;

    public GeoLineStringCollection(List<GeoLineString> list) {
        this(list, null, null);
    }

    public GeoLineStringCollection(List<GeoLineString> list, GeoBoundingBox geoBoundingBox, Map<String, Object> map) {
        super(geoBoundingBox, map);
        Objects.requireNonNull(list, "'lines' cannot be null.");
        this.lines = Collections.unmodifiableList(new ArrayList(list));
    }

    public List<GeoLineString> getLines() {
        return this.lines;
    }

    GeoArray<GeoArray<GeoPosition>> getCoordinates() {
        return new GeoArray<>(this);
    }

    @Override // com.azure.core.models.GeoObject
    public GeoObjectType getType() {
        return GeoObjectType.MULTI_LINE_STRING;
    }

    @Override // com.azure.core.models.GeoObject
    public int hashCode() {
        return Objects.hash(this.lines, Integer.valueOf(super.hashCode()));
    }

    @Override // com.azure.core.models.GeoObject
    public boolean equals(Object obj) {
        if (!(obj instanceof GeoLineStringCollection)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return super.equals(obj) && Objects.equals(this.lines, ((GeoLineStringCollection) obj).lines);
    }

    @Override // com.azure.core.models.GeoObject, com.azure.json.JsonSerializable
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject().writeStringField(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, GeoObjectType.MULTI_LINE_STRING.toString()).writeArrayField("coordinates", this.lines, new WriteValueCallback() { // from class: com.azure.core.models.GeoLineStringCollection$$ExternalSyntheticLambda1
            @Override // com.azure.json.WriteValueCallback
            public final void write(Object obj, Object obj2) throws IOException {
                ((JsonWriter) obj).writeArray(((GeoLineString) obj2).getCoordinates(), new WriteValueCallback() { // from class: com.azure.core.models.GeoLineStringCollection$$ExternalSyntheticLambda3
                    @Override // com.azure.json.WriteValueCallback
                    public final void write(Object obj3, Object obj4) throws IOException {
                        ((JsonWriter) obj3).writeJson((GeoPosition) obj4);
                    }
                });
            }
        }).writeJsonField("bbox", getBoundingBox());
        return writeCustomProperties(jsonWriter).writeEndObject();
    }

    public static GeoLineStringCollection fromJson(JsonReader jsonReader) throws IOException {
        return (GeoLineStringCollection) jsonReader.readObject(new ReadValueCallback() { // from class: com.azure.core.models.GeoLineStringCollection$$ExternalSyntheticLambda2
            @Override // com.azure.json.ReadValueCallback
            public final Object read(Object obj) {
                return GeoLineStringCollection.lambda$fromJson$2((JsonReader) obj);
            }
        });
    }

    static /* synthetic */ GeoLineStringCollection lambda$fromJson$2(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = null;
        GeoBoundingBox geoBoundingBoxFromJson = null;
        LinkedHashMap linkedHashMap = null;
        while (jsonReader.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jsonReader.getFieldName();
            jsonReader.nextToken();
            if (ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY.equals(fieldName)) {
                String string = jsonReader.getString();
                if (!GeoObjectType.MULTI_LINE_STRING.toString().equals(string)) {
                    throw new IllegalStateException("'type' was expected to be non-null and equal to 'MultiLineString'. The found 'type' was '" + string + "'.");
                }
            } else if ("coordinates".equals(fieldName)) {
                List array = jsonReader.readArray(new ReadValueCallback() { // from class: com.azure.core.models.GeoLineStringCollection$$ExternalSyntheticLambda0
                    @Override // com.azure.json.ReadValueCallback
                    public final Object read(Object obj) {
                        return ((JsonReader) obj).readArray(new GeoLineString$$ExternalSyntheticLambda1());
                    }
                });
                ArrayList arrayList2 = new ArrayList(array.size());
                Iterator it = array.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new GeoLineString((List) it.next()));
                }
                arrayList = arrayList2;
            } else if ("bbox".equals(fieldName)) {
                geoBoundingBoxFromJson = GeoBoundingBox.fromJson(jsonReader);
            } else {
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap();
                }
                linkedHashMap.put(fieldName, jsonReader.readUntyped());
            }
        }
        return new GeoLineStringCollection(arrayList, geoBoundingBoxFromJson, linkedHashMap);
    }
}
