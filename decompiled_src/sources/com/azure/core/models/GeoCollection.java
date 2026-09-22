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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class GeoCollection extends GeoObject {
    private final List<GeoObject> geometries;

    public GeoCollection(List<GeoObject> list) {
        this(list, null, null);
    }

    public GeoCollection(List<GeoObject> list, GeoBoundingBox geoBoundingBox, Map<String, Object> map) {
        super(geoBoundingBox, map);
        Objects.requireNonNull(list, "'geometries' cannot be null.");
        this.geometries = Collections.unmodifiableList(new ArrayList(list));
    }

    public List<GeoObject> getGeometries() {
        return this.geometries;
    }

    @Override // com.azure.core.models.GeoObject
    public GeoObjectType getType() {
        return GeoObjectType.GEOMETRY_COLLECTION;
    }

    @Override // com.azure.core.models.GeoObject
    public int hashCode() {
        return Objects.hash(this.geometries, Integer.valueOf(super.hashCode()));
    }

    @Override // com.azure.core.models.GeoObject
    public boolean equals(Object obj) {
        if (!(obj instanceof GeoCollection)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        GeoCollection geoCollection = (GeoCollection) obj;
        return super.equals(geoCollection) && Objects.equals(this.geometries, geoCollection.geometries);
    }

    @Override // com.azure.core.models.GeoObject, com.azure.json.JsonSerializable
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject().writeStringField(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, GeoObjectType.GEOMETRY_COLLECTION.toString()).writeArrayField("geometries", this.geometries, new WriteValueCallback() { // from class: com.azure.core.models.GeoCollection$$ExternalSyntheticLambda0
            @Override // com.azure.json.WriteValueCallback
            public final void write(Object obj, Object obj2) throws IOException {
                ((JsonWriter) obj).writeJson((GeoObject) obj2);
            }
        }).writeJsonField("bbox", getBoundingBox());
        return writeCustomProperties(jsonWriter).writeEndObject();
    }

    public static GeoCollection fromJson(JsonReader jsonReader) throws IOException {
        return (GeoCollection) jsonReader.readObject(new ReadValueCallback() { // from class: com.azure.core.models.GeoCollection$$ExternalSyntheticLambda2
            @Override // com.azure.json.ReadValueCallback
            public final Object read(Object obj) {
                return GeoCollection.lambda$fromJson$0((JsonReader) obj);
            }
        });
    }

    static /* synthetic */ GeoCollection lambda$fromJson$0(JsonReader jsonReader) throws IOException {
        List array = null;
        GeoBoundingBox geoBoundingBoxFromJson = null;
        LinkedHashMap linkedHashMap = null;
        while (jsonReader.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jsonReader.getFieldName();
            jsonReader.nextToken();
            if (ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY.equals(fieldName)) {
                String string = jsonReader.getString();
                if (!GeoObjectType.GEOMETRY_COLLECTION.toString().equals(string)) {
                    throw new IllegalStateException("'type' was expected to be non-null and equal to 'GeometryCollection'. The found 'type' was '" + string + "'.");
                }
            } else if ("geometries".equals(fieldName)) {
                array = jsonReader.readArray(new ReadValueCallback() { // from class: com.azure.core.models.GeoCollection$$ExternalSyntheticLambda1
                    @Override // com.azure.json.ReadValueCallback
                    public final Object read(Object obj) {
                        return GeoObject.fromJson((JsonReader) obj);
                    }
                });
            } else if ("bbox".equals(fieldName)) {
                geoBoundingBoxFromJson = GeoBoundingBox.fromJson(jsonReader);
            } else {
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap();
                }
                linkedHashMap.put(fieldName, jsonReader.readUntyped());
            }
        }
        return new GeoCollection(array, geoBoundingBoxFromJson, linkedHashMap);
    }
}
