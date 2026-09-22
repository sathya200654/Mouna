package com.azure.core.models;

import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.json.ReadValueCallback;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class GeoBoundingBox implements JsonSerializable<GeoBoundingBox> {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) GeoBoundingBox.class);
    private final double east;
    private final Double maxAltitude;
    private final Double minAltitude;
    private final double north;
    private final double south;
    private final double west;

    public GeoBoundingBox(double d, double d2, double d3, double d4) {
        this(d, d2, d3, d4, null, null, null);
    }

    public GeoBoundingBox(double d, double d2, double d3, double d4, double d5, double d6) {
        this(d, d2, d3, d4, Double.valueOf(d5), Double.valueOf(d6), null);
    }

    private GeoBoundingBox(double d, double d2, double d3, double d4, Double d5, Double d6, String str) {
        this.west = d;
        this.south = d2;
        this.east = d3;
        this.north = d4;
        this.minAltitude = d5;
        this.maxAltitude = d6;
    }

    public double getWest() {
        return this.west;
    }

    public double getSouth() {
        return this.south;
    }

    public double getEast() {
        return this.east;
    }

    public double getNorth() {
        return this.north;
    }

    public Double getMinAltitude() {
        return this.minAltitude;
    }

    public Double getMaxAltitude() {
        return this.maxAltitude;
    }

    public int hashCode() {
        return Objects.hash(Double.valueOf(this.west), Double.valueOf(this.south), Double.valueOf(this.east), Double.valueOf(this.north), this.minAltitude, this.maxAltitude);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GeoBoundingBox)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        GeoBoundingBox geoBoundingBox = (GeoBoundingBox) obj;
        return Double.compare(this.west, geoBoundingBox.west) == 0 && Double.compare(this.south, geoBoundingBox.south) == 0 && Double.compare(this.east, geoBoundingBox.east) == 0 && Double.compare(this.north, geoBoundingBox.north) == 0 && Objects.equals(this.minAltitude, geoBoundingBox.minAltitude) && Objects.equals(this.maxAltitude, geoBoundingBox.maxAltitude);
    }

    double get(int i) {
        Double d;
        Double d2 = this.minAltitude;
        if (d2 == null || (d = this.maxAltitude) == null) {
            if (i == 0) {
                return this.west;
            }
            if (i == 1) {
                return this.south;
            }
            if (i == 2) {
                return this.east;
            }
            if (i == 3) {
                return this.north;
            }
            throw LOGGER.logExceptionAsWarning(new IndexOutOfBoundsException("Index out of range: " + i));
        }
        if (i == 0) {
            return this.west;
        }
        if (i == 1) {
            return this.south;
        }
        if (i == 2) {
            return d2.doubleValue();
        }
        if (i == 3) {
            return this.east;
        }
        if (i == 4) {
            return this.north;
        }
        if (i == 5) {
            return d.doubleValue();
        }
        throw LOGGER.logExceptionAsWarning(new IndexOutOfBoundsException("Index out of range: " + i));
    }

    public String toString() {
        if (this.minAltitude != null && this.maxAltitude != null) {
            return String.format("[%s, %s, %s, %s, %s, %s]", Double.valueOf(this.west), Double.valueOf(this.south), this.minAltitude, Double.valueOf(this.east), Double.valueOf(this.north), this.maxAltitude);
        }
        return String.format("[%s, %s, %s, %s]", Double.valueOf(this.west), Double.valueOf(this.south), Double.valueOf(this.east), Double.valueOf(this.north));
    }

    @Override // com.azure.json.JsonSerializable
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartArray().writeDouble(this.west).writeDouble(this.south);
        Double d = this.minAltitude;
        if (d != null) {
            jsonWriter.writeDouble(d.doubleValue());
        }
        jsonWriter.writeDouble(this.east).writeDouble(this.north);
        Double d2 = this.maxAltitude;
        if (d2 != null) {
            jsonWriter.writeDouble(d2.doubleValue());
        }
        return jsonWriter.writeEndArray();
    }

    public static GeoBoundingBox fromJson(JsonReader jsonReader) throws IOException {
        List array = jsonReader.readArray(new ReadValueCallback() { // from class: com.azure.core.models.GeoBoundingBox$$ExternalSyntheticLambda0
            @Override // com.azure.json.ReadValueCallback
            public final Object read(Object obj) {
                return GeoBoundingBox.lambda$fromJson$0((JsonReader) obj);
            }
        });
        if (array == null) {
            return null;
        }
        int size = array.size();
        if (size != 4 && size != 6) {
            throw LOGGER.logExceptionAsError(new IllegalStateException("Only 2 or 3 dimension bounding boxes are supported."));
        }
        return new GeoBoundingBox(((Number) array.get(0)).doubleValue(), ((Number) array.get(1)).doubleValue(), ((Number) array.get(size == 6 ? 3 : 2)).doubleValue(), ((Number) array.get(size != 6 ? 3 : 4)).doubleValue(), size == 6 ? Double.valueOf(((Number) array.get(2)).doubleValue()) : null, size == 6 ? Double.valueOf(((Number) array.get(5)).doubleValue()) : null, null);
    }

    static /* synthetic */ Number lambda$fromJson$0(JsonReader jsonReader) throws IOException {
        if (jsonReader.currentToken() == JsonToken.NUMBER) {
            return Double.valueOf(jsonReader.getDouble());
        }
        return null;
    }
}
