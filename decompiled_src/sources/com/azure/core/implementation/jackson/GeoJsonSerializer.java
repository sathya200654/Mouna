package com.azure.core.implementation.jackson;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.azure.core.implementation.GeoObjectHelper;
import com.azure.core.models.GeoBoundingBox;
import com.azure.core.models.GeoCollection;
import com.azure.core.models.GeoLineString;
import com.azure.core.models.GeoLineStringCollection;
import com.azure.core.models.GeoLinearRing;
import com.azure.core.models.GeoObject;
import com.azure.core.models.GeoObjectType;
import com.azure.core.models.GeoPoint;
import com.azure.core.models.GeoPointCollection;
import com.azure.core.models.GeoPolygon;
import com.azure.core.models.GeoPolygonCollection;
import com.azure.core.models.GeoPosition;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class GeoJsonSerializer extends JsonSerializer<GeoObject> {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) GeoJsonSerializer.class);
    private static final SimpleModule MODULE = new SimpleModule().addSerializer(GeoObject.class, new GeoJsonSerializer());

    GeoJsonSerializer() {
    }

    public static SimpleModule getModule() {
        return MODULE;
    }

    public void serialize(GeoObject geoObject, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        write(geoObject, jsonGenerator);
    }

    private static void write(GeoObject geoObject, JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeStartObject();
        if (geoObject instanceof GeoPoint) {
            writeType(GeoObjectType.POINT, jsonGenerator);
            jsonGenerator.writeFieldName("coordinates");
            writePosition(((GeoPoint) geoObject).getCoordinates(), jsonGenerator);
        } else if (geoObject instanceof GeoLineString) {
            writeType(GeoObjectType.LINE_STRING, jsonGenerator);
            jsonGenerator.writeFieldName("coordinates");
            writePositions(((GeoLineString) geoObject).getCoordinates(), jsonGenerator);
        } else if (geoObject instanceof GeoPolygon) {
            writeType(GeoObjectType.POLYGON, jsonGenerator);
            jsonGenerator.writeArrayFieldStart("coordinates");
            Iterator<GeoLinearRing> it = ((GeoPolygon) geoObject).getRings().iterator();
            while (it.hasNext()) {
                writePositions(it.next().getCoordinates(), jsonGenerator);
            }
            jsonGenerator.writeEndArray();
        } else if (geoObject instanceof GeoPointCollection) {
            writeType(GeoObjectType.MULTI_POINT, jsonGenerator);
            jsonGenerator.writeArrayFieldStart("coordinates");
            Iterator<GeoPoint> it2 = ((GeoPointCollection) geoObject).getPoints().iterator();
            while (it2.hasNext()) {
                writePosition(it2.next().getCoordinates(), jsonGenerator);
            }
            jsonGenerator.writeEndArray();
        } else if (geoObject instanceof GeoLineStringCollection) {
            writeType(GeoObjectType.MULTI_LINE_STRING, jsonGenerator);
            jsonGenerator.writeArrayFieldStart("coordinates");
            Iterator<GeoLineString> it3 = ((GeoLineStringCollection) geoObject).getLines().iterator();
            while (it3.hasNext()) {
                writePositions(it3.next().getCoordinates(), jsonGenerator);
            }
            jsonGenerator.writeEndArray();
        } else if (geoObject instanceof GeoPolygonCollection) {
            writeType(GeoObjectType.MULTI_POLYGON, jsonGenerator);
            jsonGenerator.writeArrayFieldStart("coordinates");
            for (GeoPolygon geoPolygon : ((GeoPolygonCollection) geoObject).getPolygons()) {
                jsonGenerator.writeStartArray();
                Iterator<GeoLinearRing> it4 = geoPolygon.getRings().iterator();
                while (it4.hasNext()) {
                    writePositions(it4.next().getCoordinates(), jsonGenerator);
                }
                jsonGenerator.writeEndArray();
            }
            jsonGenerator.writeEndArray();
        } else if (geoObject instanceof GeoCollection) {
            writeType(GeoObjectType.GEOMETRY_COLLECTION, jsonGenerator);
            jsonGenerator.writeArrayFieldStart("geometries");
            Iterator<GeoObject> it5 = ((GeoCollection) geoObject).getGeometries().iterator();
            while (it5.hasNext()) {
                write(it5.next(), jsonGenerator);
            }
            jsonGenerator.writeEndArray();
        } else {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(String.format("Geo type '%s' isn't supported.", geoObject.getClass().getName())));
        }
        writeBoundingBox(geoObject.getBoundingBox(), jsonGenerator);
        writeAdditionalProperties(GeoObjectHelper.getCustomProperties(geoObject), jsonGenerator);
        jsonGenerator.writeEndObject();
    }

    private static void writePositions(List<GeoPosition> list, JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeStartArray();
        Iterator<GeoPosition> it = list.iterator();
        while (it.hasNext()) {
            writePosition(it.next(), jsonGenerator);
        }
        jsonGenerator.writeEndArray();
    }

    private static void writePosition(GeoPosition geoPosition, JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeStartArray();
        jsonGenerator.writeNumber(geoPosition.getLongitude());
        jsonGenerator.writeNumber(geoPosition.getLatitude());
        Double altitude = geoPosition.getAltitude();
        if (altitude != null) {
            jsonGenerator.writeNumber(altitude.doubleValue());
        }
        jsonGenerator.writeEndArray();
    }

    private static void writeType(GeoObjectType geoObjectType, JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeStringField(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, geoObjectType.toString());
    }

    private static void writeBoundingBox(GeoBoundingBox geoBoundingBox, JsonGenerator jsonGenerator) throws IOException {
        if (geoBoundingBox == null) {
            return;
        }
        jsonGenerator.writeArrayFieldStart("bbox");
        jsonGenerator.writeNumber(geoBoundingBox.getWest());
        jsonGenerator.writeNumber(geoBoundingBox.getSouth());
        Double minAltitude = geoBoundingBox.getMinAltitude();
        if (minAltitude != null) {
            jsonGenerator.writeNumber(minAltitude.doubleValue());
        }
        jsonGenerator.writeNumber(geoBoundingBox.getEast());
        jsonGenerator.writeNumber(geoBoundingBox.getNorth());
        Double maxAltitude = geoBoundingBox.getMaxAltitude();
        if (maxAltitude != null) {
            jsonGenerator.writeNumber(maxAltitude.doubleValue());
        }
        jsonGenerator.writeEndArray();
    }

    private static void writeAdditionalProperties(Map<String, Object> map, JsonGenerator jsonGenerator) throws IOException {
        if (CoreUtils.isNullOrEmpty(map)) {
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            jsonGenerator.writeFieldName(entry.getKey());
            jsonGenerator.writeObject(entry.getValue());
        }
    }
}
