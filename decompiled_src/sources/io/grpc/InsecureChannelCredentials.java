package io.grpc;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class InsecureChannelCredentials extends ChannelCredentials {
    @Override // io.grpc.ChannelCredentials
    public ChannelCredentials withoutBearerTokens() {
        return this;
    }

    public static ChannelCredentials create() {
        return new InsecureChannelCredentials();
    }

    private InsecureChannelCredentials() {
    }
}
