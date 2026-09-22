package com.azure.core.util;

import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class LibraryTelemetryOptions {
    private final String libraryName;
    private String libraryVersion;
    private String rpNamespace;
    private String schemaUrl;

    public LibraryTelemetryOptions(String str) {
        this.libraryName = (String) Objects.requireNonNull(str, "'libraryName' cannot be null.");
    }

    public LibraryTelemetryOptions setLibraryVersion(String str) {
        this.libraryVersion = str;
        return this;
    }

    public LibraryTelemetryOptions setResourceProviderNamespace(String str) {
        this.rpNamespace = str;
        return this;
    }

    public LibraryTelemetryOptions setSchemaUrl(String str) {
        this.schemaUrl = str;
        return this;
    }

    public String getLibraryName() {
        return this.libraryName;
    }

    public String getLibraryVersion() {
        return this.libraryVersion;
    }

    public String getResourceProviderNamespace() {
        return this.rpNamespace;
    }

    public String getSchemaUrl() {
        return this.schemaUrl;
    }
}
