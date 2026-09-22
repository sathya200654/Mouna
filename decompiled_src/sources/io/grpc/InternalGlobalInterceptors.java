package io.grpc;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class InternalGlobalInterceptors {
    public static void setInterceptorsTracers(List<ClientInterceptor> list, List<ServerInterceptor> list2, List<ServerStreamTracer.Factory> list3) {
        GlobalInterceptors.setInterceptorsTracers(list, list2, list3);
    }

    public static List<ClientInterceptor> getClientInterceptors() {
        return GlobalInterceptors.getClientInterceptors();
    }

    public static List<ServerInterceptor> getServerInterceptors() {
        return GlobalInterceptors.getServerInterceptors();
    }

    public static List<ServerStreamTracer.Factory> getServerStreamTracerFactories() {
        return GlobalInterceptors.getServerStreamTracerFactories();
    }

    private InternalGlobalInterceptors() {
    }
}
