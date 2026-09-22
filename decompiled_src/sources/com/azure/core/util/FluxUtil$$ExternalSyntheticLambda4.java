package com.azure.core.util;

import com.azure.core.implementation.ByteBufferCollector;
import java.nio.ByteBuffer;
import java.util.function.BiConsumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final /* synthetic */ class FluxUtil$$ExternalSyntheticLambda4 implements BiConsumer {
    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((ByteBufferCollector) obj).write((ByteBuffer) obj2);
    }
}
