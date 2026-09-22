package io.grpc;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class ChannelLogger {

    public enum ChannelLogLevel {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    public abstract void log(ChannelLogLevel channelLogLevel, String str);

    public abstract void log(ChannelLogLevel channelLogLevel, String str, Object... objArr);
}
