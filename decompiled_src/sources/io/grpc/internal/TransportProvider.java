package io.grpc.internal;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
interface TransportProvider {
    @Nullable
    ClientTransport obtainActiveTransport();
}
