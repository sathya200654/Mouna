package com.azure.core.credential;

import java.util.function.Consumer;
import reactor.core.publisher.Sinks;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final /* synthetic */ class SimpleTokenCache$$ExternalSyntheticLambda6 implements Consumer {
    public final /* synthetic */ Sinks.One f$0;

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.tryEmitError((Throwable) obj);
    }
}
