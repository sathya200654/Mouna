package com.azure.core.implementation.jackson;

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
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class GeoJsonDeserializer extends JsonDeserializer<GeoObject> {
    static final String BOUNDING_BOX_PROPERTY = "bbox";
    static final String COORDINATES_PROPERTY = "coordinates";
    static final String GEOMETRIES_PROPERTY = "geometries";
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) GeoJsonDeserializer.class);
    static final SimpleModule MODULE = new SimpleModule().addDeserializer(GeoObject.class, new GeoJsonDeserializer()).addDeserializer(GeoPoint.class, geoSubclassDeserializer(GeoPoint.class)).addDeserializer(GeoLineString.class, geoSubclassDeserializer(GeoLineString.class)).addDeserializer(GeoPolygon.class, geoSubclassDeserializer(GeoPolygon.class)).addDeserializer(GeoPointCollection.class, geoSubclassDeserializer(GeoPointCollection.class)).addDeserializer(GeoLineStringCollection.class, geoSubclassDeserializer(GeoLineStringCollection.class)).addDeserializer(GeoPolygonCollection.class, geoSubclassDeserializer(GeoPolygonCollection.class)).addDeserializer(GeoCollection.class, geoSubclassDeserializer(GeoCollection.class));
    static final String TYPE_PROPERTY = "type";

    GeoJsonDeserializer() {
    }

    public static SimpleModule getModule() {
        return MODULE;
    }

    /* JADX INFO: renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public GeoObject m1202deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return read(deserializationContext.readTree(jsonParser));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static GeoObject read(JsonNode jsonNode) {
        String strAsText = getRequiredProperty(jsonNode, "type").asText();
        if (isGeoObjectType(strAsText, GeoObjectType.GEOMETRY_COLLECTION)) {
            ArrayList arrayList = new ArrayList();
            Iterator it = getRequiredProperty(jsonNode, GEOMETRIES_PROPERTY).iterator();
            while (it.hasNext()) {
                arrayList.add(read((JsonNode) it.next()));
            }
            return new GeoCollection(arrayList, readBoundingBox(jsonNode), readProperties(jsonNode, GEOMETRIES_PROPERTY));
        }
        JsonNode requiredProperty = getRequiredProperty(jsonNode, COORDINATES_PROPERTY);
        GeoBoundingBox boundingBox = readBoundingBox(jsonNode);
        Map<String, Object> properties = readProperties(jsonNode);
        if (isGeoObjectType(strAsText, GeoObjectType.POINT)) {
            return new GeoPoint(readCoordinate(requiredProperty), boundingBox, properties);
        }
        if (isGeoObjectType(strAsText, GeoObjectType.LINE_STRING)) {
            return new GeoLineString(readCoordinates(requiredProperty), boundingBox, properties);
        }
        if (isGeoObjectType(strAsText, GeoObjectType.POLYGON)) {
            final ArrayList arrayList2 = new ArrayList();
            requiredProperty.forEach(new Consumer() { // from class: com.azure.core.implementation.jackson.GeoJsonDeserializer$$ExternalSyntheticLambda1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    arrayList2.add(new GeoLinearRing(GeoJsonDeserializer.readCoordinates((JsonNode) obj)));
                }
            });
            return new GeoPolygon(arrayList2, boundingBox, properties);
        }
        if (isGeoObjectType(strAsText, GeoObjectType.MULTI_POINT)) {
            final ArrayList arrayList3 = new ArrayList();
            readCoordinates(requiredProperty).forEach(new Consumer() { // from class: com.azure.core.implementation.jackson.GeoJsonDeserializer$$ExternalSyntheticLambda2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    arrayList3.add(new GeoPoint((GeoPosition) obj));
                }
            });
            return new GeoPointCollection(arrayList3, boundingBox, properties);
        }
        if (isGeoObjectType(strAsText, GeoObjectType.MULTI_LINE_STRING)) {
            final ArrayList arrayList4 = new ArrayList();
            requiredProperty.forEach(new Consumer() { // from class: com.azure.core.implementation.jackson.GeoJsonDeserializer$$ExternalSyntheticLambda3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    arrayList4.add(new GeoLineString(GeoJsonDeserializer.readCoordinates((JsonNode) obj)));
                }
            });
            return new GeoLineStringCollection(arrayList4, boundingBox, properties);
        }
        if (isGeoObjectType(strAsText, GeoObjectType.MULTI_POLYGON)) {
            return readMultiPolygon(requiredProperty, boundingBox, properties);
        }
        throw LOGGER.logExceptionAsError(new IllegalStateException(String.format("Unsupported geo type %s.", strAsText)));
    }

    private static boolean isGeoObjectType(String str, GeoObjectType geoObjectType) {
        return geoObjectType.toString().equalsIgnoreCase(str);
    }

    private static GeoPolygonCollection readMultiPolygon(JsonNode jsonNode, GeoBoundingBox geoBoundingBox, Map<String, Object> map) {
        ArrayList arrayList = new ArrayList();
        Iterator it = jsonNode.iterator();
        while (it.hasNext()) {
            JsonNode jsonNode2 = (JsonNode) it.next();
            final ArrayList arrayList2 = new ArrayList();
            jsonNode2.forEach(new Consumer() { // from class: com.azure.core.implementation.jackson.GeoJsonDeserializer$$ExternalSyntheticLambda4
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    arrayList2.add(new GeoLinearRing(GeoJsonDeserializer.readCoordinates((JsonNode) obj)));
                }
            });
            arrayList.add(new GeoPolygon(arrayList2));
        }
        return new GeoPolygonCollection(arrayList, geoBoundingBox, map);
    }

    private static JsonNode getRequiredProperty(JsonNode jsonNode, String str) {
        JsonNode jsonNode2 = jsonNode.get(str);
        if (jsonNode2 != null) {
            return jsonNode2;
        }
        throw LOGGER.logExceptionAsError(new IllegalStateException(String.format("GeoJSON object expected to have '%s' property.", str)));
    }

    private static GeoBoundingBox readBoundingBox(JsonNode jsonNode) {
        JsonNode jsonNode2 = jsonNode.get(BOUNDING_BOX_PROPERTY);
        if (jsonNode2 == null) {
            return null;
        }
        int size = jsonNode2.size();
        if (size == 4) {
            return new GeoBoundingBox(jsonNode2.get(0).asDouble(), jsonNode2.get(1).asDouble(), jsonNode2.get(2).asDouble(), jsonNode2.get(3).asDouble());
        }
        if (size == 6) {
            return new GeoBoundingBox(jsonNode2.get(0).asDouble(), jsonNode2.get(1).asDouble(), jsonNode2.get(3).asDouble(), jsonNode2.get(4).asDouble(), jsonNode2.get(2).asDouble(), jsonNode2.get(5).asDouble());
        }
        throw LOGGER.logExceptionAsError(new IllegalStateException("Only 2 or 3 dimension bounding boxes are supported."));
    }

    private static Map<String, Object> readProperties(JsonNode jsonNode) {
        return readProperties(jsonNode, COORDINATES_PROPERTY);
    }

    private static Map<String, Object> readProperties(JsonNode jsonNode, String str) {
        Iterator itFields = jsonNode.fields();
        HashMap map = null;
        while (itFields.hasNext()) {
            Map.Entry entry = (Map.Entry) itFields.next();
            String str2 = (String) entry.getKey();
            if (!str2.equalsIgnoreCase("type") && !str2.equalsIgnoreCase(BOUNDING_BOX_PROPERTY) && !str2.equalsIgnoreCase(str)) {
                if (map == null) {
                    map = new HashMap();
                }
                map.put(str2, readAdditionalPropertyValue((JsonNode) entry.getValue()));
            }
        }
        return map;
    }

    /* JADX INFO: renamed from: com.azure.core.implementation.jackson.GeoJsonDeserializer$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$databind$node$JsonNodeType;

        static {
            int[] iArr = new int[JsonNodeType.values().length];
            $SwitchMap$com$fasterxml$jackson$databind$node$JsonNodeType = iArr;
            try {
                iArr[JsonNodeType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$databind$node$JsonNodeType[JsonNodeType.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$databind$node$JsonNodeType[JsonNodeType.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$databind$node$JsonNodeType[JsonNodeType.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$databind$node$JsonNodeType[JsonNodeType.MISSING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$databind$node$JsonNodeType[JsonNodeType.OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$databind$node$JsonNodeType[JsonNodeType.ARRAY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private static Object readAdditionalPropertyValue(JsonNode jsonNode) {
        switch (AnonymousClass2.$SwitchMap$com$fasterxml$jackson$databind$node$JsonNodeType[jsonNode.getNodeType().ordinal()]) {
            case 1:
                return jsonNode.asText();
            case 2:
                if (jsonNode.isInt()) {
                    return Integer.valueOf(jsonNode.asInt());
                }
                if (jsonNode.isLong()) {
                    return Long.valueOf(jsonNode.asLong());
                }
                if (jsonNode.isFloat()) {
                    return Float.valueOf(jsonNode.floatValue());
                }
                return Double.valueOf(jsonNode.asDouble());
            case 3:
                return Boolean.valueOf(jsonNode.asBoolean());
            case 4:
            case 5:
                return null;
            case 6:
                final HashMap map = new HashMap();
                jsonNode.fields().forEachRemaining(new Consumer() { // from class: com.azure.core.implementation.jackson.GeoJsonDeserializer$$ExternalSyntheticLambda5
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        Map.Entry entry = (Map.Entry) obj;
                        map.put((String) entry.getKey(), GeoJsonDeserializer.readAdditionalPropertyValue((JsonNode) entry.getValue()));
                    }
                });
                return map;
            case 7:
                final ArrayList arrayList = new ArrayList();
                jsonNode.forEach(new Consumer() { // from class: com.azure.core.implementation.jackson.GeoJsonDeserializer$$ExternalSyntheticLambda6
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        arrayList.add(GeoJsonDeserializer.readAdditionalPropertyValue((JsonNode) obj));
                    }
                });
                return arrayList;
            default:
                throw LOGGER.logExceptionAsError(new IllegalStateException(String.format("Unsupported additional property type %s.", jsonNode.getNodeType())));
        }
    }

    private static List<GeoPosition> readCoordinates(JsonNode jsonNode) {
        final ArrayList arrayList = new ArrayList();
        jsonNode.forEach(new Consumer() { // from class: com.azure.core.implementation.jackson.GeoJsonDeserializer$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                arrayList.add(GeoJsonDeserializer.readCoordinate((JsonNode) obj));
            }
        });
        return arrayList;
    }

    private static GeoPosition readCoordinate(JsonNode jsonNode) {
        int size = jsonNode.size();
        if (size < 2 || size > 3) {
            throw LOGGER.logExceptionAsError(new IllegalStateException("Only 2 or 3 element coordinates supported."));
        }
        return new GeoPosition(jsonNode.get(0).asDouble(), jsonNode.get(1).asDouble(), size > 2 ? Double.valueOf(jsonNode.get(2).asDouble()) : null);
    }

    private static <T extends GeoObject> JsonDeserializer<T> geoSubclassDeserializer(final Class<T> cls) {
        return (JsonDeserializer<T>) new JsonDeserializer<T>() { // from class: com.azure.core.implementation.jackson.GeoJsonDeserializer.1
            /* JADX WARN: Incorrect return type in method signature: (Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)TT; */
            /* JADX INFO: renamed from: deserialize, reason: merged with bridge method [inline-methods] */
            public GeoObject m1203deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
                return (GeoObject) cls.cast(GeoJsonDeserializer.read(deserializationContext.readTree(jsonParser)));
            }
        };
    }
}
