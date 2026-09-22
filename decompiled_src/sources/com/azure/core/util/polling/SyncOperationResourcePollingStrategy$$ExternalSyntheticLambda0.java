package com.azure.core.util.polling;

import java.time.OffsetDateTime;
import java.util.function.Supplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final /* synthetic */ class SyncOperationResourcePollingStrategy$$ExternalSyntheticLambda0 implements Supplier {
    @Override // java.util.function.Supplier
    public final Object get() {
        return OffsetDateTime.now();
    }
}
