package com.azure.xml.implementation.aalto.out;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class CharWName extends WName {
    final char[] _chars;

    public CharWName(String str) {
        super(str);
        this._chars = str.toCharArray();
    }

    public CharWName(String str, String str2) {
        super(str, str2);
        int length = str.length();
        int length2 = str2.length();
        int i = length + 1;
        char[] cArr = new char[i + length2];
        this._chars = cArr;
        str.getChars(0, length, cArr, 0);
        cArr[length] = ':';
        str2.getChars(0, length2, cArr, i);
    }

    @Override // com.azure.xml.implementation.aalto.out.WName
    public int serializedLength() {
        return this._chars.length;
    }

    @Override // com.azure.xml.implementation.aalto.out.WName
    public int appendBytes(byte[] bArr, int i) {
        throw new RuntimeException("Internal error: appendBytes() should never be called");
    }

    @Override // com.azure.xml.implementation.aalto.out.WName
    public void writeBytes(OutputStream outputStream) {
        throw new RuntimeException("Internal error: writeBytes() should never be called");
    }

    @Override // com.azure.xml.implementation.aalto.out.WName
    public void appendChars(char[] cArr, int i) {
        char[] cArr2 = this._chars;
        System.arraycopy(cArr2, 0, cArr, i, cArr2.length);
    }

    @Override // com.azure.xml.implementation.aalto.out.WName
    public void writeChars(Writer writer) throws IOException {
        writer.write(this._chars);
    }

    @Override // com.azure.xml.implementation.aalto.out.WName
    public String toString() {
        if (this._prefix != null) {
            return new String(this._chars);
        }
        return this._localName;
    }
}
