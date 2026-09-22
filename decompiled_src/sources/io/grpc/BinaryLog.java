package io.grpc;

import java.io.Closeable;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class BinaryLog implements Closeable {
    public abstract Channel wrapChannel(Channel channel);

    public abstract <ReqT, RespT> ServerMethodDefinition<?, ?> wrapMethodDefinition(ServerMethodDefinition<ReqT, RespT> serverMethodDefinition);
}
