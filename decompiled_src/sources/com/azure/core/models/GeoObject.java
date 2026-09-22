package com.azure.core.models;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.azure.core.implementation.GeoObjectHelper;
import com.azure.core.util.CoreUtils;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.json.ReadValueCallback;
import com.azure.json.WriteValueCallback;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@JsonSubTypes({@JsonSubTypes.Type(name = "Point", value = GeoPoint.class), @JsonSubTypes.Type(name = "LineString", value = GeoLineString.class), @JsonSubTypes.Type(name = "Polygon", value = GeoPolygon.class), @JsonSubTypes.Type(name = "MultiPoint", value = GeoPointCollection.class), @JsonSubTypes.Type(name = "MultiLineString", value = GeoLineStringCollection.class), @JsonSubTypes.Type(name = "MultiPolygon", value = GeoPolygonCollection.class), @JsonSubTypes.Type(name = "GeometryCollection", value = GeoCollection.class)})
public abstract class GeoObject implements JsonSerializable<GeoObject> {
    private final GeoBoundingBox boundingBox;
    private final Map<String, Object> customProperties;

    @JsonProperty(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)
    public abstract GeoObjectType getType();

    protected GeoObject(GeoBoundingBox geoBoundingBox, Map<String, Object> map) {
        this.boundingBox = geoBoundingBox;
        if (map == null) {
            this.customProperties = null;
        } else {
            this.customProperties = Collections.unmodifiableMap(new HashMap(map));
        }
    }

    static {
        GeoObjectHelper.setAccessor(new GeoObjectHelper.GeoObjectAccessor() { // from class: com.azure.core.models.GeoObject$$ExternalSyntheticLambda2
            @Override // com.azure.core.implementation.GeoObjectHelper.GeoObjectAccessor
            public final Map getCustomProperties(GeoObject geoObject) {
                return geoObject.getCustomProperties();
            }
        });
    }

    public final GeoBoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    public final Map<String, Object> getCustomProperties() {
        return this.customProperties;
    }

    public int hashCode() {
        return Objects.hash(this.boundingBox, this.customProperties);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GeoObject)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        GeoObject geoObject = (GeoObject) obj;
        return Objects.equals(this.boundingBox, geoObject.boundingBox) && Objects.equals(this.customProperties, geoObject.customProperties);
    }

    @Override // com.azure.json.JsonSerializable
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject().writeJsonField("bbox", getBoundingBox());
        Map<String, Object> customProperties = getCustomProperties();
        if (!CoreUtils.isNullOrEmpty(customProperties)) {
            jsonWriter.writeMap(customProperties, new WriteValueCallback() { // from class: com.azure.core.models.GeoObject$$ExternalSyntheticLambda1
                @Override // com.azure.json.WriteValueCallback
                public final void write(Object obj, Object obj2) throws IOException {
                    ((JsonWriter) obj).writeUntyped(obj2);
                }
            });
        }
        return jsonWriter.writeEndObject();
    }

    public static GeoObject fromJson(JsonReader jsonReader) throws IOException {
        return (GeoObject) jsonReader.readObject(new ReadValueCallback() { // from class: com.azure.core.models.GeoObject$$ExternalSyntheticLambda0
            @Override // com.azure.json.ReadValueCallback
            public final Object read(Object obj) {
                return GeoObject.lambda$fromJson$0((JsonReader) obj);
            }
        });
    }

    static /* synthetic */ GeoObject lambda$fromJson$0(JsonReader jsonReader) throws IOException {
        String string;
        JsonReader jsonReaderBufferObject = jsonReader.bufferObject();
        jsonReaderBufferObject.nextToken();
        while (true) {
            if (jsonReaderBufferObject.nextToken() == JsonToken.END_OBJECT) {
                string = null;
                break;
            }
            String fieldName = jsonReaderBufferObject.getFieldName();
            jsonReaderBufferObject.nextToken();
            if (ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY.equals(fieldName)) {
                string = jsonReaderBufferObject.getString();
                break;
            }
            jsonReaderBufferObject.skipChildren();
        }
        if (string != null) {
            jsonReaderBufferObject = jsonReaderBufferObject.reset();
        }
        if ("Point".equals(string)) {
            return GeoPoint.fromJson(jsonReaderBufferObject);
        }
        if ("MultiPoint".equals(string)) {
            return GeoPointCollection.fromJson(jsonReaderBufferObject);
        }
        if ("Polygon".equals(string)) {
            return GeoPolygon.fromJson(jsonReaderBufferObject);
        }
        if ("MultiPolygon".equals(string)) {
            return GeoPolygonCollection.fromJson(jsonReaderBufferObject);
        }
        if ("LineString".equals(string)) {
            return GeoLineString.fromJson(jsonReaderBufferObject);
        }
        if ("MultiLineString".equals(string)) {
            return GeoLineStringCollection.fromJson(jsonReaderBufferObject);
        }
        if ("GeometryCollection".equals(string)) {
            return GeoCollection.fromJson(jsonReaderBufferObject);
        }
        throw new IllegalStateException("Discriminator field 'type' didn't match one of the expected values 'Point', 'MultiPoint', 'Polygon', 'MultiPolygon', 'LineString', 'MultiLineString', or 'GeometryCollection'. It was: '" + string + "'.");
    }

    JsonWriter writeCustomProperties(JsonWriter jsonWriter) throws IOException {
        if (!CoreUtils.isNullOrEmpty(this.customProperties)) {
            for (Map.Entry<String, Object> entry : this.customProperties.entrySet()) {
                jsonWriter.writeUntypedField(String.valueOf(entry.getKey()), entry.getValue());
            }
        }
        return jsonWriter;
    }
}
