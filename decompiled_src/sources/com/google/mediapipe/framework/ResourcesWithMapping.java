package com.google.mediapipe.framework;

import java.util.Map;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ResourcesWithMapping {
    private final Map<String, String> resourcesMapping;

    public ResourcesWithMapping() {
        this(null);
    }

    public ResourcesWithMapping(Map<String, String> resourcesMapping) {
        this.resourcesMapping = resourcesMapping;
    }

    public Map<String, String> getResourcesMapping() {
        return this.resourcesMapping;
    }
}
