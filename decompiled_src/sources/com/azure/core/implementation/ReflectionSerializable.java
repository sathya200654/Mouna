package com.azure.core.implementation;

import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonProviders;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonWriter;
import com.azure.xml.XmlReader;
import com.azure.xml.XmlSerializable;
import com.azure.xml.XmlWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ReflectionSerializable {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) ReflectionSerializable.class);
    private static final Map<Class<?>, ReflectiveInvoker> FROM_JSON_CACHE = new ConcurrentHashMap();
    private static final Map<Class<?>, ReflectiveInvoker> FROM_XML_CACHE = new ConcurrentHashMap();

    public static boolean supportsJsonSerializable(Class<?> cls) {
        if (FROM_JSON_CACHE.containsKey(cls)) {
            return true;
        }
        if (!JsonSerializable.class.isAssignableFrom(cls)) {
            return false;
        }
        boolean z = false;
        boolean z2 = false;
        for (Method method : cls.getDeclaredMethods()) {
            if (method.getName().equals("fromJson") && (method.getModifiers() & 8) != 0 && method.getParameterCount() == 1 && method.getParameterTypes()[0].equals(JsonReader.class)) {
                z = true;
            } else if (method.getName().equals("toJson") && method.getParameterCount() == 1 && method.getParameterTypes()[0].equals(JsonWriter.class)) {
                z2 = true;
            }
            if (z && z2) {
                return true;
            }
        }
        return false;
    }

    public static ByteBuffer serializeJsonSerializableToByteBuffer(JsonSerializable<?> jsonSerializable) throws IOException {
        return (ByteBuffer) serializeJsonSerializableWithReturn(jsonSerializable, new ReflectionSerializable$$ExternalSyntheticLambda0());
    }

    public static byte[] serializeJsonSerializableToBytes(JsonSerializable<?> jsonSerializable) throws IOException {
        return (byte[]) serializeJsonSerializableWithReturn(jsonSerializable, new ReflectionSerializable$$ExternalSyntheticLambda2());
    }

    public static String serializeJsonSerializableToString(JsonSerializable<?> jsonSerializable) throws IOException {
        return (String) serializeJsonSerializableWithReturn(jsonSerializable, new Function() { // from class: com.azure.core.implementation.ReflectionSerializable$$ExternalSyntheticLambda4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((AccessibleByteArrayOutputStream) obj).toString(StandardCharsets.UTF_8);
            }
        });
    }

    private static <T> T serializeJsonSerializableWithReturn(JsonSerializable<?> jsonSerializable, Function<AccessibleByteArrayOutputStream, T> function) throws IOException {
        AccessibleByteArrayOutputStream accessibleByteArrayOutputStream = new AccessibleByteArrayOutputStream();
        jsonSerializable.toJson(accessibleByteArrayOutputStream);
        return function.apply(accessibleByteArrayOutputStream);
    }

    public static void serializeJsonSerializableIntoOutputStream(JsonSerializable<?> jsonSerializable, OutputStream outputStream) throws IOException {
        jsonSerializable.toJson(outputStream);
    }

    public static Object deserializeAsJsonSerializable(final Class<?> cls, byte[] bArr) throws IOException {
        Map<Class<?>, ReflectiveInvoker> map = FROM_JSON_CACHE;
        if (map.size() >= 10000) {
            map.clear();
        }
        ReflectiveInvoker reflectiveInvokerComputeIfAbsent = map.computeIfAbsent(cls, new Function() { // from class: com.azure.core.implementation.ReflectionSerializable$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ReflectionSerializable.lambda$deserializeAsJsonSerializable$1(cls, (Class) obj);
            }
        });
        try {
            JsonReader jsonReaderCreateReader = JsonProviders.createReader(bArr);
            try {
                Object objInvokeStatic = reflectiveInvokerComputeIfAbsent.invokeStatic(jsonReaderCreateReader);
                if (jsonReaderCreateReader != null) {
                    jsonReaderCreateReader.close();
                }
                return objInvokeStatic;
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
        } catch (Throwable th3) {
            if (th3 instanceof IOException) {
                throw ((IOException) th3);
            }
            if (th3 instanceof Exception) {
                throw new IOException(th3);
            }
            throw ((Error) th3);
        }
    }

    static /* synthetic */ ReflectiveInvoker lambda$deserializeAsJsonSerializable$1(Class cls, Class cls2) {
        try {
            return ReflectionUtils.getMethodInvoker(cls2, cls.getDeclaredMethod("fromJson", JsonReader.class));
        } catch (Exception e) {
            throw LOGGER.logExceptionAsError(new IllegalStateException(e));
        }
    }

    public static boolean supportsXmlSerializable(Class<?> cls) {
        if (FROM_XML_CACHE.containsKey(cls)) {
            return true;
        }
        if (!XmlSerializable.class.isAssignableFrom(cls)) {
            return false;
        }
        boolean z = false;
        boolean z2 = false;
        for (Method method : cls.getDeclaredMethods()) {
            if (method.getName().equals("fromXml") && (method.getModifiers() & 8) != 0 && method.getParameterCount() == 2 && method.getParameterTypes()[0].equals(XmlReader.class) && method.getParameterTypes()[1].equals(String.class)) {
                z = true;
            } else if (method.getName().equals("toXml") && method.getParameterCount() == 2 && method.getParameterTypes()[0].equals(XmlWriter.class) && method.getParameterTypes()[1].equals(String.class)) {
                z2 = true;
            }
            if (z && z2) {
                return true;
            }
        }
        return false;
    }

    public static ByteBuffer serializeXmlSerializableToByteBuffer(XmlSerializable<?> xmlSerializable) throws IOException {
        return (ByteBuffer) serializeXmlSerializableWithReturn(xmlSerializable, new ReflectionSerializable$$ExternalSyntheticLambda0());
    }

    public static byte[] serializeXmlSerializableToBytes(XmlSerializable<?> xmlSerializable) throws IOException {
        return (byte[]) serializeXmlSerializableWithReturn(xmlSerializable, new ReflectionSerializable$$ExternalSyntheticLambda2());
    }

    public static String serializeXmlSerializableToString(XmlSerializable<?> xmlSerializable) throws IOException {
        return (String) serializeXmlSerializableWithReturn(xmlSerializable, new Function() { // from class: com.azure.core.implementation.ReflectionSerializable$$ExternalSyntheticLambda5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((AccessibleByteArrayOutputStream) obj).toString(StandardCharsets.UTF_8);
            }
        });
    }

    private static <T> T serializeXmlSerializableWithReturn(XmlSerializable<?> xmlSerializable, Function<AccessibleByteArrayOutputStream, T> function) throws IOException {
        try {
            AccessibleByteArrayOutputStream accessibleByteArrayOutputStream = new AccessibleByteArrayOutputStream();
            try {
                XmlWriter stream = XmlWriter.toStream(accessibleByteArrayOutputStream);
                try {
                    stream.writeStartDocument();
                    stream.writeXml(xmlSerializable);
                    stream.flush();
                    T tApply = function.apply(accessibleByteArrayOutputStream);
                    if (stream != null) {
                        stream.close();
                    }
                    accessibleByteArrayOutputStream.close();
                    return tApply;
                } catch (Throwable th) {
                    if (stream != null) {
                        try {
                            stream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    accessibleByteArrayOutputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (XMLStreamException e) {
            throw new IOException((Throwable) e);
        }
    }

    public static void serializeXmlSerializableIntoOutputStream(XmlSerializable<?> xmlSerializable, OutputStream outputStream) throws IOException {
        try {
            XmlWriter stream = XmlWriter.toStream(outputStream);
            try {
                stream.writeStartDocument();
                stream.writeXml(xmlSerializable);
                stream.flush();
                if (stream != null) {
                    stream.close();
                }
            } catch (Throwable th) {
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (XMLStreamException e) {
            throw new IOException((Throwable) e);
        }
    }

    public static Object deserializeAsXmlSerializable(final Class<?> cls, byte[] bArr) throws IOException {
        Map<Class<?>, ReflectiveInvoker> map = FROM_XML_CACHE;
        if (map.size() >= 10000) {
            map.clear();
        }
        ReflectiveInvoker reflectiveInvokerComputeIfAbsent = map.computeIfAbsent(cls, new Function() { // from class: com.azure.core.implementation.ReflectionSerializable$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ReflectionSerializable.lambda$deserializeAsXmlSerializable$3(cls, (Class) obj);
            }
        });
        try {
            XmlReader xmlReaderFromBytes = XmlReader.fromBytes(bArr);
            try {
                Object objInvokeStatic = reflectiveInvokerComputeIfAbsent.invokeStatic(xmlReaderFromBytes);
                if (xmlReaderFromBytes != null) {
                    xmlReaderFromBytes.close();
                }
                return objInvokeStatic;
            } catch (Throwable th) {
                if (xmlReaderFromBytes != null) {
                    try {
                        xmlReaderFromBytes.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            if (th3 instanceof IOException) {
                throw ((IOException) th3);
            }
            if (th3 instanceof Exception) {
                throw new IOException(th3);
            }
            throw ((Error) th3);
        }
    }

    static /* synthetic */ ReflectiveInvoker lambda$deserializeAsXmlSerializable$3(Class cls, Class cls2) {
        try {
            return ReflectionUtils.getMethodInvoker(cls, cls.getDeclaredMethod("fromXml", XmlReader.class));
        } catch (Exception e) {
            throw LOGGER.logExceptionAsError(new IllegalStateException(e));
        }
    }

    private ReflectionSerializable() {
    }
}
