package com.google.mediapipe.framework;

import java.util.Map;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class ResourcesService implements GraphService<ResourcesWithMapping> {
    public native void nativeInstallServiceObject(long context, Map<String, String> resourcesMapping);

    @Override // com.google.mediapipe.framework.GraphService
    public void installServiceObject(long context, ResourcesWithMapping object) {
        nativeInstallServiceObject(context, object.getResourcesMapping());
    }
}
