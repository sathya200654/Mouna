package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface ResourceTranscoder<Z, R> {
    Resource<R> transcode(Resource<Z> resource, Options options);
}
