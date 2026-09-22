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
public final class GeoPolygonCollection extends GeoObject {
    private final List<GeoPolygon> polygons;

    public GeoPolygonCollection(List<GeoPolygon> list) {
        this(list, null, null);
    }

    public GeoPolygonCollection(List<GeoPolygon> list, GeoBoundingBox geoBoundingBox, Map<String, Object> map) {
        super(geoBoundingBox, map);
        Objects.requireNonNull(list, "'polygons' cannot be null.");
        this.polygons = Collections.unmodifiableList(new ArrayList(list));
    }

    public List<GeoPolygon> getPolygons() {
        return this.polygons;
    }

    GeoArray<GeoArray<GeoArray<GeoPosition>>> getCoordinates() {
        return new GeoArray<>(this);
    }

    @Override // com.azure.core.models.GeoObject
    public GeoObjectType getType() {
        return GeoObjectType.MULTI_POLYGON;
    }

    @Override // com.azure.core.models.GeoObject
    public int hashCode() {
        return Objects.hash(this.polygons, Integer.valueOf(super.hashCode()));
    }

    @Override // com.azure.core.models.GeoObject
    public boolean equals(Object obj) {
        if (!(obj instanceof GeoPolygonCollection)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return super.equals(obj) && Objects.equals(this.polygons, ((GeoPolygonCollection) obj).polygons);
    }

    @Override // com.azure.core.models.GeoObject, com.azure.json.JsonSerializable
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject().writeStringField(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, GeoObjectType.MULTI_POLYGON.toString()).writeArrayField("coordinates", this.polygons, new WriteValueCallback() { // from class: com.azure.core.models.GeoPolygonCollection$$ExternalSyntheticLambda0
            @Override // com.azure.json.WriteValueCallback
            public final void write(Object obj, Object obj2) throws IOException {
                ((JsonWriter) obj).writeArray(((GeoPolygon) obj2).getRings(), new WriteValueCallback() { // from class: com.azure.core.models.GeoPolygonCollection$$ExternalSyntheticLambda1
                    @Override // com.azure.json.WriteValueCallback
                    public final void write(Object obj3, Object obj4) throws IOException {
                        ((JsonWriter) obj3).writeJson((GeoLinearRing) obj4);
                    }
                });
            }
        }).writeJsonField("bbox", getBoundingBox());
        return writeCustomProperties(jsonWriter).writeEndObject();
    }

    public static GeoPolygonCollection fromJson(JsonReader jsonReader) throws IOException {
        return (GeoPolygonCollection) jsonReader.readObject(new ReadValueCallback() { // from class: com.azure.core.models.GeoPolygonCollection$$ExternalSyntheticLambda2
            @Override // com.azure.json.ReadValueCallback
            public final Object read(Object obj) {
                return GeoPolygonCollection.lambda$fromJson$2((JsonReader) obj);
            }
        });
    }

    static /* synthetic */ GeoPolygonCollection lambda$fromJson$2(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = null;
        GeoBoundingBox geoBoundingBoxFromJson = null;
        LinkedHashMap linkedHashMap = null;
        while (jsonReader.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jsonReader.getFieldName();
            jsonReader.nextToken();
            if (ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY.equals(fieldName)) {
                String string = jsonReader.getString();
                if (!GeoObjectType.MULTI_POLYGON.toString().equals(string)) {
                    throw new IllegalStateException("'type' was expected to be non-null and equal to 'MultiPolygon'. The found 'type' was '" + string + "'.");
                }
            } else if ("coordinates".equals(fieldName)) {
                List array = jsonReader.readArray(new ReadValueCallback() { // from class: com.azure.core.models.GeoPolygonCollection$$ExternalSyntheticLambda3
                    @Override // com.azure.json.ReadValueCallback
                    public final Object read(Object obj) {
                        return ((JsonReader) obj).readArray(new GeoPolygon$$ExternalSyntheticLambda2());
                    }
                });
                ArrayList arrayList2 = new ArrayList(array.size());
                Iterator it = array.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new GeoPolygon((List<GeoLinearRing>) it.next()));
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
        return new GeoPolygonCollection(arrayList, geoBoundingBoxFromJson, linkedHashMap);
    }
}
