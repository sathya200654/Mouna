package com.azure.core.models;

import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonWriter;
import com.azure.json.WriteValueCallback;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class GeoLinearRing implements JsonSerializable<GeoLinearRing> {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) GeoLinearRing.class);
    private final GeoArray<GeoPosition> coordinates;

    public GeoLinearRing(List<GeoPosition> list) {
        Objects.requireNonNull(list, "'coordinates' cannot be null.");
        int size = list.size();
        if (size < 4) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("A linear ring requires at least 4 coordinates."));
        }
        if (!Objects.equals(list.get(0), list.get(size - 1))) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("The first and last coordinates of a linear ring must be equivalent."));
        }
        this.coordinates = new GeoArray<>(new ArrayList(list));
    }

    public List<GeoPosition> getCoordinates() {
        return this.coordinates;
    }

    public int hashCode() {
        return this.coordinates.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GeoLinearRing)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return Objects.equals(this.coordinates, ((GeoLinearRing) obj).coordinates);
    }

    @Override // com.azure.json.JsonSerializable
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        return jsonWriter.writeArray(getCoordinates(), new WriteValueCallback() { // from class: com.azure.core.models.GeoLinearRing$$ExternalSyntheticLambda0
            @Override // com.azure.json.WriteValueCallback
            public final void write(Object obj, Object obj2) throws IOException {
                ((JsonWriter) obj).writeJson((GeoPosition) obj2);
            }
        });
    }

    public static GeoLinearRing fromJson(JsonReader jsonReader) throws IOException {
        List array = jsonReader.readArray(new GeoLineString$$ExternalSyntheticLambda1());
        if (array == null) {
            return null;
        }
        return new GeoLinearRing(array);
    }
}
