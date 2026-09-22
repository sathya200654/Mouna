package io.grpc;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class InsecureServerCredentials extends ServerCredentials {
    public static ServerCredentials create() {
        return new InsecureServerCredentials();
    }

    private InsecureServerCredentials() {
    }
}
