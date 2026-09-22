package com.azure.json.implementation.jackson.core;

import coil3.util.UtilsKt;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.net.URL;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class TokenStreamFactory implements Versioned, Serializable {
    private static final long serialVersionUID = 2;

    public abstract boolean canHandleBinaryNatively();

    public abstract JsonGenerator createGenerator(OutputStream outputStream) throws IOException;

    public abstract JsonGenerator createGenerator(OutputStream outputStream, JsonEncoding jsonEncoding) throws IOException;

    public abstract JsonGenerator createGenerator(Writer writer) throws IOException;

    public abstract JsonParser createParser(File file) throws IOException;

    public abstract JsonParser createParser(InputStream inputStream) throws IOException;

    public abstract JsonParser createParser(Reader reader) throws IOException;

    public abstract JsonParser createParser(String str) throws IOException;

    public abstract JsonParser createParser(URL url) throws IOException;

    public abstract JsonParser createParser(byte[] bArr) throws IOException;

    public abstract JsonParser createParser(byte[] bArr, int i, int i2) throws IOException;

    public abstract String getFormatName();

    public abstract boolean isEnabled(JsonGenerator.Feature feature);

    public abstract boolean isEnabled(JsonParser.Feature feature);

    protected InputStream _optimizedStreamFromURL(URL url) throws IOException {
        String host;
        if (UtilsKt.SCHEME_FILE.equals(url.getProtocol()) && (((host = url.getHost()) == null || host.isEmpty()) && url.getPath().indexOf(37) < 0)) {
            return new FileInputStream(url.getPath());
        }
        return FirebasePerfUrlConnection.openStream(url);
    }
}
