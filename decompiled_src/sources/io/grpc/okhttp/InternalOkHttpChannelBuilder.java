package io.grpc.okhttp;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class InternalOkHttpChannelBuilder {
    public static void setStatsEnabled(OkHttpChannelBuilder okHttpChannelBuilder, boolean z) {
        okHttpChannelBuilder.setStatsEnabled(z);
    }

    public static void disableCheckAuthority(OkHttpChannelBuilder okHttpChannelBuilder) {
        okHttpChannelBuilder.disableCheckAuthority();
    }

    public static void enableCheckAuthority(OkHttpChannelBuilder okHttpChannelBuilder) {
        okHttpChannelBuilder.enableCheckAuthority();
    }

    private InternalOkHttpChannelBuilder() {
    }
}
