package com.azure.json;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class JsonWriter implements Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close() throws IOException;

    public abstract JsonWriter flush() throws IOException;

    public abstract JsonWriteContext getWriteContext();

    public abstract JsonWriter writeBinary(byte[] bArr) throws IOException;

    public abstract JsonWriter writeBoolean(boolean z) throws IOException;

    public abstract JsonWriter writeDouble(double d) throws IOException;

    public abstract JsonWriter writeEndArray() throws IOException;

    public abstract JsonWriter writeEndObject() throws IOException;

    public abstract JsonWriter writeFieldName(String str) throws IOException;

    public abstract JsonWriter writeFloat(float f) throws IOException;

    public abstract JsonWriter writeInt(int i) throws IOException;

    public abstract JsonWriter writeLong(long j) throws IOException;

    public abstract JsonWriter writeNull() throws IOException;

    public abstract JsonWriter writeRawValue(String str) throws IOException;

    public abstract JsonWriter writeStartArray() throws IOException;

    public abstract JsonWriter writeStartObject() throws IOException;

    public abstract JsonWriter writeString(String str) throws IOException;

    public final JsonWriter writeStartObject(String str) throws IOException {
        Objects.requireNonNull(str, "'fieldName' cannot be null.");
        return writeFieldName(str).writeStartObject();
    }

    public final JsonWriter writeStartArray(String str) throws IOException {
        Objects.requireNonNull(str, "'fieldName' cannot be null.");
        return writeFieldName(str).writeStartArray();
    }

    public final JsonWriter writeJson(JsonSerializable<?> jsonSerializable) throws IOException {
        return jsonSerializable == null ? this : jsonSerializable.toJson(this);
    }

    public final <T> JsonWriter writeArray(T[] tArr, WriteValueCallback<JsonWriter, T> writeValueCallback) throws IOException {
        return writeArray((Object[]) tArr, (WriteValueCallback) writeValueCallback, false);
    }

    public <T> JsonWriter writeArray(T[] tArr, WriteValueCallback<JsonWriter, T> writeValueCallback, boolean z) throws IOException {
        Objects.requireNonNull(writeValueCallback, "'elementWriterFunc' cannot be null.");
        if (tArr == null) {
            return writeNull();
        }
        return writeArrayInternal(Arrays.asList(tArr), writeValueCallback, null, z);
    }

    public final <T> JsonWriter writeArray(Iterable<T> iterable, WriteValueCallback<JsonWriter, T> writeValueCallback) throws IOException {
        return writeArray((Iterable) iterable, (WriteValueCallback) writeValueCallback, false);
    }

    public <T> JsonWriter writeArray(Iterable<T> iterable, WriteValueCallback<JsonWriter, T> writeValueCallback, boolean z) throws IOException {
        Objects.requireNonNull(writeValueCallback, "'elementWriterFunc' cannot be null.");
        if (iterable == null) {
            return writeNull();
        }
        return writeArrayInternal(iterable, writeValueCallback, null, z);
    }

    private <T> JsonWriter writeArrayInternal(Iterable<T> iterable, WriteValueCallback<JsonWriter, T> writeValueCallback, String str, boolean z) throws IOException {
        if (str == null) {
            writeStartArray();
        } else {
            writeStartArray(str);
        }
        for (T t : iterable) {
            if (t != null) {
                writeValueCallback.write(this, t);
            } else if (!z) {
                writeNull();
            }
        }
        return writeEndArray();
    }

    public final <T> JsonWriter writeMap(Map<String, T> map, WriteValueCallback<JsonWriter, T> writeValueCallback) throws IOException {
        return writeMap(map, writeValueCallback, false);
    }

    public <T> JsonWriter writeMap(Map<String, T> map, WriteValueCallback<JsonWriter, T> writeValueCallback, boolean z) throws IOException {
        Objects.requireNonNull(writeValueCallback, "'valueWriterFunc' cannot be null.");
        if (map == null) {
            return writeNull();
        }
        return writeMapInternal(null, map, writeValueCallback, z);
    }

    private <T> JsonWriter writeMapInternal(String str, Map<String, T> map, WriteValueCallback<JsonWriter, T> writeValueCallback, boolean z) throws IOException {
        if (str == null) {
            writeStartObject();
        } else {
            writeStartObject(str);
        }
        for (Map.Entry<String, T> entry : map.entrySet()) {
            T value = entry.getValue();
            if (!z || value != null) {
                writeFieldName(entry.getKey());
                if (value == null) {
                    writeNull();
                } else {
                    writeValueCallback.write(this, value);
                }
            }
        }
        return writeEndObject();
    }

    public final JsonWriter writeBoolean(Boolean bool) throws IOException {
        return bool == null ? writeNull() : writeBoolean(bool.booleanValue());
    }

    public final JsonWriter writeNumber(Number number) throws IOException {
        if (number == null) {
            return writeNull();
        }
        if ((number instanceof Byte) || (number instanceof Short) || (number instanceof Integer)) {
            return writeInt(number.intValue());
        }
        if (number instanceof Long) {
            return writeLong(number.longValue());
        }
        if (number instanceof Float) {
            return writeFloat(number.floatValue());
        }
        if (number instanceof Double) {
            return writeDouble(number.doubleValue());
        }
        return writeRawValue(number.toString());
    }

    public final <T> JsonWriter writeNullableField(String str, T t, WriteValueCallback<JsonWriter, T> writeValueCallback) throws IOException {
        Objects.requireNonNull(str, "'fieldName' cannot be null.");
        Objects.requireNonNull(writeValueCallback, "'writerFunc' cannot be null.");
        if (t == null) {
            return writeNullField(str);
        }
        writeValueCallback.write(writeFieldName(str), t);
        return this;
    }

    public final JsonWriter writeJsonField(String str, JsonSerializable<?> jsonSerializable) throws IOException {
        Objects.requireNonNull(str, "'fieldName' cannot be null.");
        return jsonSerializable == null ? this : jsonSerializable.toJson(writeFieldName(str));
    }

    public final <T> JsonWriter writeArrayField(String str, T[] tArr, WriteValueCallback<JsonWriter, T> writeValueCallback) throws IOException {
        return writeArrayField(str, (Object[]) tArr, (WriteValueCallback) writeValueCallback, false);
    }

    public <T> JsonWriter writeArrayField(String str, T[] tArr, WriteValueCallback<JsonWriter, T> writeValueCallback, boolean z) throws IOException {
        Objects.requireNonNull(str, "'fieldName' cannot be null.");
        Objects.requireNonNull(writeValueCallback, "'elementWriterFunc' cannot be null.");
        return tArr == null ? this : writeArrayInternal(Arrays.asList(tArr), writeValueCallback, str, z);
    }

    public final <T> JsonWriter writeArrayField(String str, Iterable<T> iterable, WriteValueCallback<JsonWriter, T> writeValueCallback) throws IOException {
        return writeArrayField(str, (Iterable) iterable, (WriteValueCallback) writeValueCallback, false);
    }

    public <T> JsonWriter writeArrayField(String str, Iterable<T> iterable, WriteValueCallback<JsonWriter, T> writeValueCallback, boolean z) throws IOException {
        Objects.requireNonNull(str, "'fieldName' cannot be null.");
        Objects.requireNonNull(writeValueCallback, "'elementWriterFunc' cannot be null.");
        return iterable == null ? this : writeArrayInternal(iterable, writeValueCallback, str, z);
    }

    public final <T> JsonWriter writeMapField(String str, Map<String, T> map, WriteValueCallback<JsonWriter, T> writeValueCallback) throws IOException {
        return writeMapField(str, map, writeValueCallback, false);
    }

    public <T> JsonWriter writeMapField(String str, Map<String, T> map, WriteValueCallback<JsonWriter, T> writeValueCallback, boolean z) throws IOException {
        Objects.requireNonNull(str, "'fieldName' cannot be null.");
        Objects.requireNonNull(writeValueCallback, "'valueWriterFunc' cannot be null.");
        return map == null ? this : writeMapInternal(str, map, writeValueCallback, z);
    }

    public final JsonWriter writeBinaryField(String str, byte[] bArr) throws IOException {
        Objects.requireNonNull(str, "'fieldName' cannot be null.");
        return bArr == null ? this : writeFieldName(str).writeBinary(bArr);
    }

    public final JsonWriter writeBooleanField(String str, boolean z) throws IOException {
        Objects.requireNonNull(str, "'fieldName' cannot be null.");
        return writeFieldName(str).writeBoolean(z);
    }

    public final JsonWriter writeBooleanField(String str, Boolean bool) throws IOException {
        Objects.requireNonNull(str, "'fieldName' cannot be null.");
        return bool == null ? this : writeBooleanField(str, bool.booleanValue());
    }

    public final JsonWriter writeDoubleField(String str, double d) throws IOException {
        Objects.requireNonNull(str, "'fieldName' cannot be null.");
        return writeFieldName(str).writeDouble(d);
    }

    public final JsonWriter writeFloatField(String str, float f) throws IOException {
        Objects.requireNonNull(str, "'fieldName' cannot be null.");
        return writeFieldName(str).writeFloat(f);
    }

    public final JsonWriter writeIntField(String str, int i) throws IOException {
        Objects.requireNonNull(str, "'fieldName' cannot be null.");
        return writeFieldName(str).writeInt(i);
    }

    public final JsonWriter writeLongField(String str, long j) throws IOException {
        Objects.requireNonNull(str, "'fieldName' cannot be null.");
        return writeFieldName(str).writeLong(j);
    }

    public final JsonWriter writeNullField(String str) throws IOException {
        Objects.requireNonNull(str, "'fieldName' cannot be null.");
        return writeFieldName(str).writeNull();
    }

    public final JsonWriter writeNumberField(String str, Number number) throws IOException {
        Objects.requireNonNull(str, "'fieldName' cannot be null.");
        return number == null ? this : writeFieldName(str).writeNumber(number);
    }

    public final JsonWriter writeStringField(String str, String str2) throws IOException {
        Objects.requireNonNull(str, "'fieldName' cannot be null.");
        return str2 == null ? this : writeFieldName(str).writeString(str2);
    }

    public final JsonWriter writeRawField(String str, String str2) throws IOException {
        Objects.requireNonNull(str, "'fieldName' cannot be null.");
        Objects.requireNonNull(str2, "'value' cannot be null.");
        return writeFieldName(str).writeRawValue(str2);
    }

    public JsonWriter writeUntypedField(String str, Object obj) throws IOException {
        Objects.requireNonNull(str, "'fieldName' cannot be null.");
        return writeFieldName(str).writeUntyped(obj);
    }

    public JsonWriter writeUntyped(Object obj) throws IOException {
        if (obj == null) {
            return writeNull();
        }
        if (obj instanceof Short) {
            return writeInt(((Short) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return writeInt(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            return writeLong(((Long) obj).longValue());
        }
        if (obj instanceof Float) {
            return writeFloat(((Float) obj).floatValue());
        }
        if (obj instanceof Double) {
            return writeDouble(((Double) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return writeBoolean(((Boolean) obj).booleanValue());
        }
        if (obj instanceof byte[]) {
            return writeBinary((byte[]) obj);
        }
        if (obj instanceof CharSequence) {
            return writeString(String.valueOf(obj));
        }
        if (obj instanceof Character) {
            return writeString(String.valueOf(((Character) obj).charValue()));
        }
        if (obj instanceof JsonSerializable) {
            return ((JsonSerializable) obj).toJson(this);
        }
        if (obj instanceof Object[]) {
            writeStartArray();
            for (Object obj2 : (Object[]) obj) {
                writeUntyped(obj2);
            }
            return writeEndArray();
        }
        if (obj instanceof Iterable) {
            writeStartArray();
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                writeUntyped(it.next());
            }
            return writeEndArray();
        }
        if (obj instanceof Map) {
            writeStartObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                writeFieldName(String.valueOf(entry.getKey())).writeUntyped(entry.getValue());
            }
            return writeEndObject();
        }
        if (obj.getClass() == Object.class) {
            return writeStartObject().writeEndObject();
        }
        return writeString(String.valueOf(obj));
    }
}
