package com.azure.json.implementation.jackson.core.json;

import com.azure.json.implementation.jackson.core.Version;
import com.azure.json.implementation.jackson.core.Versioned;
import com.azure.json.implementation.jackson.core.util.VersionUtil;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class PackageVersion implements Versioned {
    public static final Version VERSION = VersionUtil.parseVersion("2.13.2", "com.azure.json.implementation.jackson.core", "jackson-core");

    @Override // com.azure.json.implementation.jackson.core.Versioned
    public Version version() {
        return VERSION;
    }
}
