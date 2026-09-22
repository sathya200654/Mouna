package com.google.mediapipe.tasks.core;

import com.google.mediapipe.framework.GraphService;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
class ModelResourcesCacheService implements GraphService<ModelResourcesCache> {
    public native void nativeInstallServiceObject(long context, long object);

    @Override // com.google.mediapipe.framework.GraphService
    public void installServiceObject(long context, ModelResourcesCache object) {
        nativeInstallServiceObject(context, object.getNativeHandle());
    }
}
