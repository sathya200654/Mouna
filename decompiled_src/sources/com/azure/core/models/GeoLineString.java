package com.azure.core.models;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.json.ReadValueCallback;
import com.azure.json.WriteValueCallback;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class GeoLineString extends GeoObject {
    private final GeoArray<GeoPosition> coordinates;

    public GeoLineString(List<GeoPosition> list) {
        this(list, null, null);
    }

    public GeoLineString(List<GeoPosition> list, GeoBoundingBox geoBoundingBox, Map<String, Object> map) {
        super(geoBoundingBox, map);
        Objects.requireNonNull(list, "'positions' cannot be null.");
        this.coordinates = new GeoArray<>(new ArrayList(list));
    }

    public List<GeoPosition> getCoordinates() {
        return this.coordinates;
    }

    @Override // com.azure.core.models.GeoObject
    public GeoObjectType getType() {
        return GeoObjectType.LINE_STRING;
    }

    @Override // com.azure.core.models.GeoObject
    public int hashCode() {
        return Objects.hash(this.coordinates, Integer.valueOf(super.hashCode()));
    }

    @Override // com.azure.core.models.GeoObject
    public boolean equals(Object obj) {
        if (!(obj instanceof GeoLineString)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        GeoLineString geoLineString = (GeoLineString) obj;
        return super.equals(geoLineString) && Objects.equals(this.coordinates, geoLineString.coordinates);
    }

    @Override // com.azure.core.models.GeoObject, com.azure.json.JsonSerializable
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject().writeStringField(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, GeoObjectType.LINE_STRING.toString()).writeArrayField("coordinates", getCoordinates(), new WriteValueCallback() { // from class: com.azure.core.models.GeoLineString$$ExternalSyntheticLambda2
            @Override // com.azure.json.WriteValueCallback
            public final void write(Object obj, Object obj2) throws IOException {
                ((JsonWriter) obj).writeJson((GeoPosition) obj2);
            }
        }).writeJsonField("bbox", getBoundingBox());
        return writeCustomProperties(jsonWriter).writeEndObject();
    }

    public static GeoLineString fromJson(JsonReader jsonReader) throws IOException {
        return (GeoLineString) jsonReader.readObject(new ReadValueCallback() { // from class: com.azure.core.models.GeoLineString$$ExternalSyntheticLambda0
            @Override // com.azure.json.ReadValueCallback
            public final Object read(Object obj) {
                return GeoLineString.lambda$fromJson$0((JsonReader) obj);
            }
        });
    }

    static /* synthetic */ GeoLineString lambda$fromJson$0(JsonReader jsonReader) throws IOException {
        List array = null;
        GeoBoundingBox geoBoundingBoxFromJson = null;
        LinkedHashMap linkedHashMap = null;
        while (jsonReader.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jsonReader.getFieldName();
            jsonReader.nextToken();
            if (ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY.equals(fieldName)) {
                String string = jsonReader.getString();
                if (!GeoObjectType.LINE_STRING.toString().equals(string)) {
                    throw new IllegalStateException("'type' was expected to be non-null and equal to 'LineString'. The found 'type' was '" + string + "'.");
                }
            } else if ("coordinates".equals(fieldName)) {
                array = jsonReader.readArray(new GeoLineString$$ExternalSyntheticLambda1());
            } else if ("bbox".equals(fieldName)) {
                geoBoundingBoxFromJson = GeoBoundingBox.fromJson(jsonReader);
            } else {
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap();
                }
                linkedHashMap.put(fieldName, jsonReader.readUntyped());
            }
        }
        return new GeoLineString(array, geoBoundingBoxFromJson, linkedHashMap);
    }
}
