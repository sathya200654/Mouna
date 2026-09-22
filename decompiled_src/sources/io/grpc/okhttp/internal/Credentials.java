package io.grpc.okhttp.internal;

import com.azure.xml.implementation.aalto.util.CharsetNames;
import java.io.UnsupportedEncodingException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class Credentials {
    private Credentials() {
    }

    public static String basic(String str, String str2) {
        try {
            return "Basic " + ByteString.of((str + ":" + str2).getBytes(CharsetNames.CS_ISO_LATIN1)).base64();
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        }
    }
}
