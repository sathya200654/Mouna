package com.azure.core.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class CloudEventDataFormat extends ExpandableStringEnum<CloudEventDataFormat> {
    public static final CloudEventDataFormat BYTES = (CloudEventDataFormat) fromString("BYTES", CloudEventDataFormat.class);
    public static final CloudEventDataFormat JSON = (CloudEventDataFormat) fromString("JSON", CloudEventDataFormat.class);

    @Deprecated
    public CloudEventDataFormat() {
    }

    @JsonCreator
    public static CloudEventDataFormat fromString(String str) {
        return (CloudEventDataFormat) fromString(str, CloudEventDataFormat.class);
    }
}
