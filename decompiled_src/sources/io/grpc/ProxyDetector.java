package io.grpc;

import java.io.IOException;
import java.net.SocketAddress;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface ProxyDetector {
    @Nullable
    ProxiedSocketAddress proxyFor(SocketAddress socketAddress) throws IOException;
}
