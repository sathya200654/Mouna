package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
interface EngineJobListener {
    void onEngineJobCancelled(EngineJob<?> engineJob, Key key);

    void onEngineJobComplete(EngineJob<?> engineJob, Key key, EngineResource<?> engineResource);
}
