package com.google.common.io;

import com.google.errorprone.annotations.DoNotMock;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@ElementTypesAreNonnullByDefault
@DoNotMock("Implement it normally")
public interface ByteProcessor<T> {
    @ParametricNullness
    T getResult();

    boolean processBytes(byte[] buf, int off, int len) throws IOException;
}
