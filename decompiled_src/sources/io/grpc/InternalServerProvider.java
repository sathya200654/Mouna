package io.grpc;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class InternalServerProvider {
    private InternalServerProvider() {
    }

    public static ServerBuilder<?> builderForPort(ServerProvider serverProvider, int i) {
        return serverProvider.builderForPort(i);
    }

    public static ServerProvider.NewServerBuilderResult newServerBuilderForPort(ServerProvider serverProvider, int i, ServerCredentials serverCredentials) {
        return serverProvider.newServerBuilderForPort(i, serverCredentials);
    }
}
