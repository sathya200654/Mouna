package com.azure.json;

import com.azure.json.implementation.DefaultJsonProvider;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ServiceLoader;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class JsonProviders {
    private static final JsonOptions DEFAULT_OPTIONS = new JsonOptions();
    private static final JsonProvider JSON_PROVIDER;

    static {
        ServiceLoader serviceLoaderLoad = ServiceLoader.load(JsonProvider.class, JsonProvider.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        Iterator it = serviceLoaderLoad.iterator();
        if (it.hasNext()) {
            JsonProvider jsonProvider = (JsonProvider) it.next();
            arrayList.add(jsonProvider.getClass().getName());
            JSON_PROVIDER = jsonProvider;
        } else {
            JSON_PROVIDER = new DefaultJsonProvider();
        }
        while (it.hasNext()) {
            arrayList.add(((JsonProvider) it.next()).getClass().getName());
        }
        if (arrayList.size() > 1) {
            throw new IllegalStateException("More than one implementation of 'com.azure.json.JsonProvider' was found on the classpath. At this time 'azure-json' only supports one implementation being on the classpath. Remove all implementations, except the one that should be used during runtime, from 'META-INF/services/com.azure.json.JsonProvider'. Found implementations were: " + String.join(", ", arrayList));
        }
    }

    private JsonProviders() {
    }

    public static JsonReader createReader(byte[] bArr) throws IOException {
        return createReader(bArr, DEFAULT_OPTIONS);
    }

    public static JsonReader createReader(byte[] bArr, JsonOptions jsonOptions) throws IOException {
        return JSON_PROVIDER.createReader(bArr, jsonOptions);
    }

    public static JsonReader createReader(String str) throws IOException {
        return createReader(str, DEFAULT_OPTIONS);
    }

    public static JsonReader createReader(String str, JsonOptions jsonOptions) throws IOException {
        return JSON_PROVIDER.createReader(str, jsonOptions);
    }

    public static JsonReader createReader(InputStream inputStream) throws IOException {
        return createReader(inputStream, DEFAULT_OPTIONS);
    }

    public static JsonReader createReader(InputStream inputStream, JsonOptions jsonOptions) throws IOException {
        return JSON_PROVIDER.createReader(inputStream, jsonOptions);
    }

    public static JsonReader createReader(Reader reader) throws IOException {
        return createReader(reader, DEFAULT_OPTIONS);
    }

    public static JsonReader createReader(Reader reader, JsonOptions jsonOptions) throws IOException {
        return JSON_PROVIDER.createReader(reader, jsonOptions);
    }

    public static JsonWriter createWriter(OutputStream outputStream) throws IOException {
        return createWriter(outputStream, DEFAULT_OPTIONS);
    }

    public static JsonWriter createWriter(OutputStream outputStream, JsonOptions jsonOptions) throws IOException {
        return JSON_PROVIDER.createWriter(outputStream, jsonOptions);
    }

    public static JsonWriter createWriter(Writer writer) throws IOException {
        return createWriter(writer, DEFAULT_OPTIONS);
    }

    public static JsonWriter createWriter(Writer writer, JsonOptions jsonOptions) throws IOException {
        return JSON_PROVIDER.createWriter(writer, jsonOptions);
    }
}
