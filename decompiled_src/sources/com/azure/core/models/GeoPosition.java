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
public final class GeoPosition implements JsonSerializable<GeoPosition> {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) GeoPosition.class);
    private final Double altitude;
    private final double latitude;
    private final double longitude;

    public GeoPosition(double d, double d2) {
        this(d, d2, null);
    }

    public GeoPosition(double d, double d2, Double d3) {
        this.longitude = d;
        this.latitude = d2;
        this.altitude = d3;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public Double getAltitude() {
        return this.altitude;
    }

    public int count() {
        return this.altitude == null ? 2 : 3;
    }

    double get(int i) {
        if (i == 0) {
            return this.longitude;
        }
        if (i == 1) {
            return this.latitude;
        }
        if (i != 2) {
            throw LOGGER.logExceptionAsError(new IndexOutOfBoundsException("Index out of range: " + i));
        }
        Double d = this.altitude;
        if (d == null) {
            throw LOGGER.logExceptionAsError(new IndexOutOfBoundsException("Index out of range: " + i));
        }
        return d.doubleValue();
    }

    public int hashCode() {
        return Objects.hash(Double.valueOf(this.longitude), Double.valueOf(this.latitude), this.altitude);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GeoPosition)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        GeoPosition geoPosition = (GeoPosition) obj;
        return Double.compare(this.longitude, geoPosition.longitude) == 0 && Double.compare(this.latitude, geoPosition.latitude) == 0 && Objects.equals(this.altitude, geoPosition.altitude);
    }

    public String toString() {
        if (this.altitude != null) {
            return String.format("[%s, %s, %s]", Double.valueOf(this.longitude), Double.valueOf(this.latitude), this.altitude);
        }
        return String.format("[%s, %s]", Double.valueOf(this.longitude), Double.valueOf(this.latitude));
    }

    @Override // com.azure.json.JsonSerializable
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartArray().writeDouble(this.longitude).writeDouble(this.latitude);
        Double d = this.altitude;
        if (d != null) {
            jsonWriter.writeDouble(d.doubleValue());
        }
        return jsonWriter.writeEndArray();
    }

    public static GeoPosition fromJson(JsonReader jsonReader) throws IOException {
        List array = jsonReader.readArray(new ReadValueCallback() { // from class: com.azure.core.models.GeoPosition$$ExternalSyntheticLambda0
            @Override // com.azure.json.ReadValueCallback
            public final Object read(Object obj) {
                return GeoPosition.lambda$fromJson$0((JsonReader) obj);
            }
        });
        if (array == null) {
            return null;
        }
        int size = array.size();
        if (size < 2 || size > 3) {
            throw LOGGER.logExceptionAsError(new IllegalStateException("Only 2 or 3 element coordinates supported."));
        }
        return new GeoPosition(((Number) array.get(0)).doubleValue(), ((Number) array.get(1)).doubleValue(), size == 3 ? Double.valueOf(((Number) array.get(2)).doubleValue()) : null);
    }

    static /* synthetic */ Number lambda$fromJson$0(JsonReader jsonReader) throws IOException {
        if (jsonReader.currentToken() == JsonToken.NUMBER) {
            return Double.valueOf(jsonReader.getDouble());
        }
        return null;
    }
}
