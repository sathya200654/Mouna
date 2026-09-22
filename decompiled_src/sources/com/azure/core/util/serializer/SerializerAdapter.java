package com.azure.core.util.serializer;

import com.azure.core.http.HttpHeaders;
import com.azure.core.util.Header;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface SerializerAdapter {
    <T> T deserialize(HttpHeaders httpHeaders, Type type) throws IOException;

    <T> T deserialize(String str, Type type, SerializerEncoding serializerEncoding) throws IOException;

    String serialize(Object obj, SerializerEncoding serializerEncoding) throws IOException;

    String serializeList(List<?> list, CollectionFormat collectionFormat);

    String serializeRaw(Object obj);

    default byte[] serializeToBytes(Object obj, SerializerEncoding serializerEncoding) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        serialize(obj, serializerEncoding, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    default void serialize(Object obj, SerializerEncoding serializerEncoding, OutputStream outputStream) throws IOException {
        String strSerialize = serialize(obj, serializerEncoding);
        if (strSerialize != null) {
            outputStream.write(strSerialize.getBytes(StandardCharsets.UTF_8));
        }
    }

    default String serializeIterable(Iterable<?> iterable, CollectionFormat collectionFormat) {
        if (iterable == null) {
            return null;
        }
        return (String) StreamSupport.stream(iterable.spliterator(), false).map(new Function() { // from class: com.azure.core.util.serializer.SerializerAdapter$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.serializeRaw(obj);
            }
        }).map(new Function() { // from class: com.azure.core.util.serializer.SerializerAdapter$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return SerializerAdapter.lambda$serializeIterable$0((String) obj);
            }
        }).collect(Collectors.joining(collectionFormat.getDelimiter()));
    }

    static /* synthetic */ String lambda$serializeIterable$0(String str) {
        return str == null ? "" : str;
    }

    default <T> T deserialize(byte[] bArr, Type type, SerializerEncoding serializerEncoding) throws IOException {
        return (T) deserialize(new String(bArr, StandardCharsets.UTF_8), type, serializerEncoding);
    }

    default <T> T deserialize(InputStream inputStream, Type type, SerializerEncoding serializerEncoding) throws IOException {
        if (inputStream == null) {
            return (T) deserialize((String) null, type, serializerEncoding);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[UserMetadata.MAX_ATTRIBUTE_SIZE];
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return (T) deserialize(byteArrayOutputStream.toString(StandardCharsets.UTF_8.name()), type, serializerEncoding);
            }
        }
    }

    default <T> T deserializeHeader(Header header, Type type) throws IOException {
        return (T) deserialize(new HttpHeaders().add(header.getName(), header.getValue()), type);
    }
}
