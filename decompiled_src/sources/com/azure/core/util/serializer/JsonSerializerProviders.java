package com.azure.core.util.serializer;

import com.azure.core.implementation.serializer.DefaultJsonSerializer;
import java.util.Iterator;
import java.util.ServiceLoader;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class JsonSerializerProviders {
    private static final String CANNOT_FIND_JSON_SERIALIZER_PROVIDER = "A request was made to load the default JSON serializer provider but one could not be found on the classpath. If you are using a dependency manager, consider including a dependency on azure-core-serializer-json-jackson or azure-core-serializer-json-gson. Depending on your existing dependencies, you have the choice of Jackson or GSON implementations. Additionally, refer to https://aka.ms/azsdk/java/docs/custom-jsonserializer to learn about writing your own implementation.";
    private static boolean attemptedLoad;
    private static JsonSerializerProvider jsonSerializerProvider;

    public static JsonSerializer createInstance() {
        return createInstance(false);
    }

    public static JsonSerializer createInstance(boolean z) {
        if (jsonSerializerProvider == null) {
            loadDefaultSerializer();
        }
        JsonSerializerProvider jsonSerializerProvider2 = jsonSerializerProvider;
        if (jsonSerializerProvider2 != null) {
            return jsonSerializerProvider2.createInstance();
        }
        if (z) {
            return new DefaultJsonSerializer();
        }
        throw new IllegalStateException(CANNOT_FIND_JSON_SERIALIZER_PROVIDER);
    }

    private static synchronized void loadDefaultSerializer() {
        if (attemptedLoad) {
            return;
        }
        attemptedLoad = true;
        Iterator it = ServiceLoader.load(JsonSerializerProvider.class, JsonSerializerProviders.class.getClassLoader()).iterator();
        if (it.hasNext()) {
            jsonSerializerProvider = (JsonSerializerProvider) it.next();
        }
    }

    private JsonSerializerProviders() {
    }
}
