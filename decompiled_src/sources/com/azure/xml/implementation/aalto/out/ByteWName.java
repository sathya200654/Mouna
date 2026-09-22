package com.azure.xml.implementation.aalto.out;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ByteWName extends WName {
    final byte[] _bytes;

    ByteWName(String str, byte[] bArr) {
        super(str);
        this._bytes = bArr;
    }

    ByteWName(String str, String str2, byte[] bArr) {
        super(str, str2);
        this._bytes = bArr;
    }

    @Override // com.azure.xml.implementation.aalto.out.WName
    public int serializedLength() {
        return this._bytes.length;
    }

    @Override // com.azure.xml.implementation.aalto.out.WName
    public int appendBytes(byte[] bArr, int i) {
        byte[] bArr2 = this._bytes;
        int length = bArr2.length;
        System.arraycopy(bArr2, 0, bArr, i, length);
        return length;
    }

    @Override // com.azure.xml.implementation.aalto.out.WName
    public void writeBytes(OutputStream outputStream) throws IOException {
        outputStream.write(this._bytes);
    }

    @Override // com.azure.xml.implementation.aalto.out.WName
    public void appendChars(char[] cArr, int i) {
        throw new RuntimeException("Internal error: appendChars() should never be called");
    }

    @Override // com.azure.xml.implementation.aalto.out.WName
    public void writeChars(Writer writer) {
        throw new RuntimeException("Internal error: writeChars() should never be called");
    }
}
