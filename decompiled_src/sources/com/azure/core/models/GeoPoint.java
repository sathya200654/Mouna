package com.azure.core.models;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.json.ReadValueCallback;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class GeoPoint extends GeoObject {
    private final GeoPosition coordinates;

    public GeoPoint(double d, double d2) {
        this(d, d2, (Double) null);
    }

    public GeoPoint(double d, double d2, Double d3) {
        this(new GeoPosition(d, d2, d3));
    }

    public GeoPoint(GeoPosition geoPosition) {
        this(geoPosition, (GeoBoundingBox) null, (Map<String, Object>) null);
    }

    public GeoPoint(GeoPosition geoPosition, GeoBoundingBox geoBoundingBox, Map<String, Object> map) {
        super(geoBoundingBox, map);
        this.coordinates = (GeoPosition) Objects.requireNonNull(geoPosition, "'position' cannot be null.");
    }

    public GeoPosition getCoordinates() {
        return this.coordinates;
    }

    @Override // com.azure.core.models.GeoObject
    public GeoObjectType getType() {
        return GeoObjectType.POINT;
    }

    @Override // com.azure.core.models.GeoObject
    public int hashCode() {
        return Objects.hash(this.coordinates, Integer.valueOf(super.hashCode()));
    }

    @Override // com.azure.core.models.GeoObject
    public boolean equals(Object obj) {
        if (!(obj instanceof GeoPoint)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return super.equals(obj) && Objects.equals(this.coordinates, ((GeoPoint) obj).coordinates);
    }

    @Override // com.azure.core.models.GeoObject, com.azure.json.JsonSerializable
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject().writeStringField(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, GeoObjectType.POINT.toString()).writeJsonField("coordinates", this.coordinates).writeJsonField("bbox", getBoundingBox());
        return writeCustomProperties(jsonWriter).writeEndObject();
    }

    public static GeoPoint fromJson(JsonReader jsonReader) throws IOException {
        return (GeoPoint) jsonReader.readObject(new ReadValueCallback() { // from class: com.azure.core.models.GeoPoint$$ExternalSyntheticLambda0
            @Override // com.azure.json.ReadValueCallback
            public final Object read(Object obj) {
                return GeoPoint.lambda$fromJson$0((JsonReader) obj);
            }
        });
    }

    static /* synthetic */ GeoPoint lambda$fromJson$0(JsonReader jsonReader) throws IOException {
        GeoPosition geoPositionFromJson = null;
        GeoBoundingBox geoBoundingBoxFromJson = null;
        LinkedHashMap linkedHashMap = null;
        while (jsonReader.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jsonReader.getFieldName();
            jsonReader.nextToken();
            if (ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY.equals(fieldName)) {
                String string = jsonReader.getString();
                if (!GeoObjectType.POINT.toString().equals(string)) {
                    throw new IllegalStateException("'type' was expected to be non-null and equal to 'Point'. The found 'type' was '" + string + "'.");
                }
            } else if ("coordinates".equals(fieldName)) {
                geoPositionFromJson = GeoPosition.fromJson(jsonReader);
            } else if ("bbox".equals(fieldName)) {
                geoBoundingBoxFromJson = GeoBoundingBox.fromJson(jsonReader);
            } else {
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap();
                }
                linkedHashMap.put(fieldName, jsonReader.readUntyped());
            }
        }
        return new GeoPoint(geoPositionFromJson, geoBoundingBoxFromJson, linkedHashMap);
    }
}
