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
public final class GeoPolygon extends GeoObject {
    private final List<GeoLinearRing> rings;

    public GeoPolygon(GeoLinearRing geoLinearRing) {
        this(geoLinearRing, (GeoBoundingBox) null, (Map<String, Object>) null);
    }

    public GeoPolygon(GeoLinearRing geoLinearRing, GeoBoundingBox geoBoundingBox, Map<String, Object> map) {
        this((List<GeoLinearRing>) Collections.singletonList((GeoLinearRing) Objects.requireNonNull(geoLinearRing, "'ring' cannot be null.")), geoBoundingBox, map);
    }

    public GeoPolygon(List<GeoLinearRing> list) {
        this(list, (GeoBoundingBox) null, (Map<String, Object>) null);
    }

    public GeoPolygon(List<GeoLinearRing> list, GeoBoundingBox geoBoundingBox, Map<String, Object> map) {
        super(geoBoundingBox, map);
        Objects.requireNonNull(list, "'rings' cannot be null.");
        this.rings = Collections.unmodifiableList(new ArrayList(list));
    }

    public List<GeoLinearRing> getRings() {
        return this.rings;
    }

    public GeoLinearRing getOuterRing() {
        return this.rings.get(0);
    }

    GeoArray<GeoArray<GeoPosition>> getCoordinates() {
        return new GeoArray<>(this);
    }

    @Override // com.azure.core.models.GeoObject
    public GeoObjectType getType() {
        return GeoObjectType.POLYGON;
    }

    @Override // com.azure.core.models.GeoObject
    public int hashCode() {
        return Objects.hash(this.rings, Integer.valueOf(super.hashCode()));
    }

    @Override // com.azure.core.models.GeoObject
    public boolean equals(Object obj) {
        if (!(obj instanceof GeoPolygon)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return super.equals(obj) && Objects.equals(this.rings, ((GeoPolygon) obj).rings);
    }

    @Override // com.azure.core.models.GeoObject, com.azure.json.JsonSerializable
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject().writeStringField(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, GeoObjectType.POLYGON.toString()).writeArrayField("coordinates", getRings(), new WriteValueCallback() { // from class: com.azure.core.models.GeoPolygon$$ExternalSyntheticLambda1
            @Override // com.azure.json.WriteValueCallback
            public final void write(Object obj, Object obj2) throws IOException {
                ((JsonWriter) obj).writeJson((GeoLinearRing) obj2);
            }
        }).writeJsonField("bbox", getBoundingBox());
        return writeCustomProperties(jsonWriter).writeEndObject();
    }

    public static GeoPolygon fromJson(JsonReader jsonReader) throws IOException {
        return (GeoPolygon) jsonReader.readObject(new ReadValueCallback() { // from class: com.azure.core.models.GeoPolygon$$ExternalSyntheticLambda0
            @Override // com.azure.json.ReadValueCallback
            public final Object read(Object obj) {
                return GeoPolygon.lambda$fromJson$0((JsonReader) obj);
            }
        });
    }

    static /* synthetic */ GeoPolygon lambda$fromJson$0(JsonReader jsonReader) throws IOException {
        List array = null;
        GeoBoundingBox geoBoundingBoxFromJson = null;
        LinkedHashMap linkedHashMap = null;
        while (jsonReader.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jsonReader.getFieldName();
            jsonReader.nextToken();
            if (ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY.equals(fieldName)) {
                String string = jsonReader.getString();
                if (!GeoObjectType.POLYGON.toString().equals(string)) {
                    throw new IllegalStateException("'type' was expected to be non-null and equal to 'Polygon'. The found 'type' was '" + string + "'.");
                }
            } else if ("coordinates".equals(fieldName)) {
                array = jsonReader.readArray(new GeoPolygon$$ExternalSyntheticLambda2());
            } else if ("bbox".equals(fieldName)) {
                geoBoundingBoxFromJson = GeoBoundingBox.fromJson(jsonReader);
            } else {
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap();
                }
                linkedHashMap.put(fieldName, jsonReader.readUntyped());
            }
        }
        return new GeoPolygon((List<GeoLinearRing>) array, geoBoundingBoxFromJson, linkedHashMap);
    }
}
