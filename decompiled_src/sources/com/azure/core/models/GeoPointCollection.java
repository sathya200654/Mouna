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
public final class GeoPointCollection extends GeoObject {
    private final List<GeoPoint> points;

    public GeoPointCollection(List<GeoPoint> list) {
        this(list, null, null);
    }

    public GeoPointCollection(List<GeoPoint> list, GeoBoundingBox geoBoundingBox, Map<String, Object> map) {
        super(geoBoundingBox, map);
        Objects.requireNonNull(list, "'points' cannot be null.");
        this.points = Collections.unmodifiableList(new ArrayList(list));
    }

    public List<GeoPoint> getPoints() {
        return this.points;
    }

    GeoArray<GeoPosition> getCoordinates() {
        return new GeoArray<>(this);
    }

    @Override // com.azure.core.models.GeoObject
    public GeoObjectType getType() {
        return GeoObjectType.MULTI_POINT;
    }

    @Override // com.azure.core.models.GeoObject
    public int hashCode() {
        return Objects.hash(this.points, Integer.valueOf(super.hashCode()));
    }

    @Override // com.azure.core.models.GeoObject
    public boolean equals(Object obj) {
        if (!(obj instanceof GeoPointCollection)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return super.equals(obj) && Objects.equals(this.points, ((GeoPointCollection) obj).points);
    }

    @Override // com.azure.core.models.GeoObject, com.azure.json.JsonSerializable
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject().writeStringField(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, GeoObjectType.MULTI_POINT.toString()).writeArrayField("coordinates", this.points, new WriteValueCallback() { // from class: com.azure.core.models.GeoPointCollection$$ExternalSyntheticLambda0
            @Override // com.azure.json.WriteValueCallback
            public final void write(Object obj, Object obj2) throws IOException {
                ((GeoPoint) obj2).getCoordinates().toJson((JsonWriter) obj);
            }
        }).writeJsonField("bbox", getBoundingBox());
        return writeCustomProperties(jsonWriter).writeEndObject();
    }

    public static GeoPointCollection fromJson(JsonReader jsonReader) throws IOException {
        return (GeoPointCollection) jsonReader.readObject(new ReadValueCallback() { // from class: com.azure.core.models.GeoPointCollection$$ExternalSyntheticLambda1
            @Override // com.azure.json.ReadValueCallback
            public final Object read(Object obj) {
                return GeoPointCollection.lambda$fromJson$1((JsonReader) obj);
            }
        });
    }

    static /* synthetic */ GeoPointCollection lambda$fromJson$1(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = null;
        GeoBoundingBox geoBoundingBoxFromJson = null;
        LinkedHashMap linkedHashMap = null;
        while (jsonReader.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jsonReader.getFieldName();
            jsonReader.nextToken();
            if (ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY.equals(fieldName)) {
                String string = jsonReader.getString();
                if (!GeoObjectType.MULTI_POINT.toString().equals(string)) {
                    throw new IllegalStateException("'type' was expected to be non-null and equal to 'MultiPoint'. The found 'type' was '" + string + "'.");
                }
            } else if ("coordinates".equals(fieldName)) {
                List array = jsonReader.readArray(new GeoLineString$$ExternalSyntheticLambda1());
                ArrayList arrayList2 = new ArrayList(array.size());
                Iterator it = array.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new GeoPoint((GeoPosition) it.next()));
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
        return new GeoPointCollection(arrayList, geoBoundingBoxFromJson, linkedHashMap);
    }
}
