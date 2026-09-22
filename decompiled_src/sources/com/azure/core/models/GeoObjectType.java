package com.azure.core.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class GeoObjectType extends ExpandableStringEnum<GeoObjectType> {
    public static final GeoObjectType POINT = fromString("Point");
    public static final GeoObjectType MULTI_POINT = fromString("MultiPoint");
    public static final GeoObjectType POLYGON = fromString("Polygon");
    public static final GeoObjectType MULTI_POLYGON = fromString("MultiPolygon");
    public static final GeoObjectType LINE_STRING = fromString("LineString");
    public static final GeoObjectType MULTI_LINE_STRING = fromString("MultiLineString");
    public static final GeoObjectType GEOMETRY_COLLECTION = fromString("GeometryCollection");

    @Deprecated
    public GeoObjectType() {
    }

    @JsonCreator
    public static GeoObjectType fromString(String str) {
        return (GeoObjectType) fromString(str, GeoObjectType.class);
    }

    public static Collection<GeoObjectType> values() {
        return values(GeoObjectType.class);
    }
}
