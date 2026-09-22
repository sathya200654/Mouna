package com.azure.json;

import com.azure.json.JsonSerializable;
import com.azure.json.implementation.StringBuilderWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface JsonSerializable<T extends JsonSerializable<T>> {
    JsonWriter toJson(JsonWriter jsonWriter) throws IOException;

    default void toJson(OutputStream outputStream) throws IOException {
        JsonWriter jsonWriterCreateWriter = JsonProviders.createWriter(outputStream);
        try {
            toJson(jsonWriterCreateWriter).flush();
            if (jsonWriterCreateWriter != null) {
                jsonWriterCreateWriter.close();
            }
        } catch (Throwable th) {
            if (jsonWriterCreateWriter != null) {
                try {
                    jsonWriterCreateWriter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    default void toJson(Writer writer) throws IOException {
        JsonWriter jsonWriterCreateWriter = JsonProviders.createWriter(writer);
        try {
            toJson(jsonWriterCreateWriter).flush();
            if (jsonWriterCreateWriter != null) {
                jsonWriterCreateWriter.close();
            }
        } catch (Throwable th) {
            if (jsonWriterCreateWriter != null) {
                try {
                    jsonWriterCreateWriter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    default String toJsonString() throws IOException {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        JsonWriter jsonWriterCreateWriter = JsonProviders.createWriter(stringBuilderWriter);
        try {
            toJson(jsonWriterCreateWriter).flush();
            String string = stringBuilderWriter.toString();
            if (jsonWriterCreateWriter != null) {
                jsonWriterCreateWriter.close();
            }
            return string;
        } catch (Throwable th) {
            if (jsonWriterCreateWriter != null) {
                try {
                    jsonWriterCreateWriter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    default byte[] toJsonBytes() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        JsonWriter jsonWriterCreateWriter = JsonProviders.createWriter(byteArrayOutputStream);
        try {
            toJson(jsonWriterCreateWriter).flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (jsonWriterCreateWriter != null) {
                jsonWriterCreateWriter.close();
            }
            return byteArray;
        } catch (Throwable th) {
            if (jsonWriterCreateWriter != null) {
                try {
                    jsonWriterCreateWriter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    static <T extends JsonSerializable<T>> T fromJson(JsonReader jsonReader) throws IOException {
        throw new UnsupportedOperationException("Implementation of JsonSerializable must define this factory method.");
    }

    static <T extends JsonSerializable<T>> T fromJson(String str) throws IOException {
        JsonReader jsonReaderCreateReader = JsonProviders.createReader(str);
        try {
            T t = (T) fromJson(jsonReaderCreateReader);
            if (jsonReaderCreateReader != null) {
                jsonReaderCreateReader.close();
            }
            return t;
        } catch (Throwable th) {
            if (jsonReaderCreateReader != null) {
                try {
                    jsonReaderCreateReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    static <T extends JsonSerializable<T>> T fromJson(byte[] bArr) throws IOException {
        JsonReader jsonReaderCreateReader = JsonProviders.createReader(bArr);
        try {
            T t = (T) fromJson(jsonReaderCreateReader);
            if (jsonReaderCreateReader != null) {
                jsonReaderCreateReader.close();
            }
            return t;
        } catch (Throwable th) {
            if (jsonReaderCreateReader != null) {
                try {
                    jsonReaderCreateReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    static <T extends JsonSerializable<T>> T fromJson(InputStream inputStream) throws IOException {
        JsonReader jsonReaderCreateReader = JsonProviders.createReader(inputStream);
        try {
            T t = (T) fromJson(jsonReaderCreateReader);
            if (jsonReaderCreateReader != null) {
                jsonReaderCreateReader.close();
            }
            return t;
        } catch (Throwable th) {
            if (jsonReaderCreateReader != null) {
                try {
                    jsonReaderCreateReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    static <T extends JsonSerializable<T>> T fromJson(Reader reader) throws IOException {
        JsonReader jsonReaderCreateReader = JsonProviders.createReader(reader);
        try {
            T t = (T) fromJson(jsonReaderCreateReader);
            if (jsonReaderCreateReader != null) {
                jsonReaderCreateReader.close();
            }
            return t;
        } catch (Throwable th) {
            if (jsonReaderCreateReader != null) {
                try {
                    jsonReaderCreateReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
