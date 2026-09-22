package com.azure.core.implementation;

import com.azure.core.models.GeoObject;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class GeoObjectHelper {
    private static GeoObjectAccessor accessor;

    public interface GeoObjectAccessor {
        Map<String, Object> getCustomProperties(GeoObject geoObject);
    }

    private GeoObjectHelper() {
    }

    public static void setAccessor(GeoObjectAccessor geoObjectAccessor) {
        accessor = geoObjectAccessor;
    }

    public static Map<String, Object> getCustomProperties(GeoObject geoObject) {
        return accessor.getCustomProperties(geoObject);
    }
}
