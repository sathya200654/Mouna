package com.squareup.wire.internal;

import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.ReverseProtoWriter;
import com.squareup.wire.WireField;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: RuntimeMessageAdapter.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ?*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004:\u0001?B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\u001f\u001a\u00028\u00002\u0006\u0010 \u001a\u00020!H\u0016¢\u0006\u0002\u0010\"J\u001d\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010(J\u001d\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020)2\u0006\u0010'\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010*J\u0015\u0010+\u001a\u00020\u00102\u0006\u0010'\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u00100\u001a\u00020\u0010H\u0016J\u000b\u00101\u001a\u00028\u0001¢\u0006\u0002\u00102J\u0015\u00103\u001a\u00028\u00002\u0006\u0010'\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00104J\u0015\u00105\u001a\u00020\u00152\u0006\u0010'\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00106JU\u00107\u001a\u00020$\"\u0004\b\u0002\u001082\b\u00109\u001a\u0004\u0018\u00018\u00002\f\u0010:\u001a\b\u0012\u0004\u0012\u0002H80\u00142\b\u0010;\u001a\u0004\u0018\u0001H82 \u0010<\u001a\u001c\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u00020$0=¢\u0006\u0002\u0010>R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\t¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR)\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001a\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u00020\u0015*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\n8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006@"}, d2 = {"Lcom/squareup/wire/internal/RuntimeMessageAdapter;", "M", "", "B", "Lcom/squareup/wire/ProtoAdapter;", "binding", "Lcom/squareup/wire/internal/MessageBinding;", "(Lcom/squareup/wire/internal/MessageBinding;)V", "fieldBindingsArray", "", "Lcom/squareup/wire/internal/FieldOrOneOfBinding;", "getFieldBindingsArray", "()[Lcom/squareup/wire/internal/FieldOrOneOfBinding;", "[Lcom/squareup/wire/internal/FieldOrOneOfBinding;", "fields", "", "", "getFields", "()Ljava/util/Map;", "jsonAlternateNames", "", "", "getJsonAlternateNames", "()Ljava/util/List;", "jsonNames", "getJsonNames", "messageType", "Lkotlin/reflect/KClass;", "jsonName", "getJsonName", "(Lcom/squareup/wire/internal/FieldOrOneOfBinding;)Ljava/lang/String;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "(Lcom/squareup/wire/ProtoReader;)Ljava/lang/Object;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "(Lcom/squareup/wire/ProtoWriter;Ljava/lang/Object;)V", "Lcom/squareup/wire/ReverseProtoWriter;", "(Lcom/squareup/wire/ReverseProtoWriter;Ljava/lang/Object;)V", "encodedSize", "(Ljava/lang/Object;)I", "equals", "", "other", "hashCode", "newBuilder", "()Ljava/lang/Object;", "redact", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "(Ljava/lang/Object;)Ljava/lang/String;", "writeAllFields", "A", ResponseKeys.KEY_MESSAGE, "jsonAdapters", "redactedFieldsAdapter", "encodeValue", "Lkotlin/Function3;", "(Ljava/lang/Object;Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "Companion", "wire-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RuntimeMessageAdapter<M, B> extends ProtoAdapter<M> {
    private static final String REDACTED = "██";
    private final MessageBinding<M, B> binding;
    private final FieldOrOneOfBinding<M, B>[] fieldBindingsArray;
    private final Map<Integer, FieldOrOneOfBinding<M, B>> fields;
    private final List<String> jsonAlternateNames;
    private final List<String> jsonNames;
    private final KClass<? super M> messageType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RuntimeMessageAdapter(MessageBinding<M, B> messageBinding) {
        String name;
        super(FieldEncoding.LENGTH_DELIMITED, messageBinding.getMessageType(), messageBinding.getTypeUrl(), messageBinding.getSyntax());
        Intrinsics.checkNotNullParameter(messageBinding, "binding");
        this.binding = messageBinding;
        this.messageType = messageBinding.getMessageType();
        Map<Integer, FieldOrOneOfBinding<M, B>> fields = messageBinding.getFields();
        this.fields = fields;
        FieldOrOneOfBinding<M, B>[] fieldOrOneOfBindingArr = (FieldOrOneOfBinding[]) fields.values().toArray(new FieldOrOneOfBinding[0]);
        this.fieldBindingsArray = fieldOrOneOfBindingArr;
        ArrayList arrayList = new ArrayList(fieldOrOneOfBindingArr.length);
        for (FieldOrOneOfBinding<M, B> fieldOrOneOfBinding : fieldOrOneOfBindingArr) {
            arrayList.add(getJsonName(fieldOrOneOfBinding));
        }
        this.jsonNames = arrayList;
        FieldOrOneOfBinding<M, B>[] fieldOrOneOfBindingArr2 = this.fieldBindingsArray;
        ArrayList arrayList2 = new ArrayList(fieldOrOneOfBindingArr2.length);
        for (FieldOrOneOfBinding<M, B> fieldOrOneOfBinding2 : fieldOrOneOfBindingArr2) {
            arrayList2.add(getJsonName(fieldOrOneOfBinding2));
        }
        ArrayList arrayList3 = arrayList2;
        FieldOrOneOfBinding<M, B>[] fieldOrOneOfBindingArr3 = this.fieldBindingsArray;
        ArrayList arrayList4 = new ArrayList(fieldOrOneOfBindingArr3.length);
        for (FieldOrOneOfBinding<M, B> fieldOrOneOfBinding3 : fieldOrOneOfBindingArr3) {
            if (!Intrinsics.areEqual(getJsonName(fieldOrOneOfBinding3), fieldOrOneOfBinding3.getDeclaredName())) {
                name = fieldOrOneOfBinding3.getDeclaredName();
            } else if (Intrinsics.areEqual(getJsonName(fieldOrOneOfBinding3), fieldOrOneOfBinding3.getName())) {
                String strCamelCase$default = _PlatformKt.camelCase$default(fieldOrOneOfBinding3.getDeclaredName(), false, 2, null);
                name = (Intrinsics.areEqual(getJsonName(fieldOrOneOfBinding3), strCamelCase$default) || arrayList3.contains(strCamelCase$default)) ? null : strCamelCase$default;
            } else {
                name = fieldOrOneOfBinding3.getName();
            }
            arrayList4.add(name);
        }
        this.jsonAlternateNames = arrayList4;
    }

    public final Map<Integer, FieldOrOneOfBinding<M, B>> getFields() {
        return this.fields;
    }

    public final FieldOrOneOfBinding<M, B>[] getFieldBindingsArray() {
        return this.fieldBindingsArray;
    }

    public final List<String> getJsonNames() {
        return this.jsonNames;
    }

    public final List<String> getJsonAlternateNames() {
        return this.jsonAlternateNames;
    }

    public final String getJsonName(FieldOrOneOfBinding<?, ?> fieldOrOneOfBinding) {
        Intrinsics.checkNotNullParameter(fieldOrOneOfBinding, "<this>");
        return fieldOrOneOfBinding.getWireFieldJsonName().length() == 0 ? fieldOrOneOfBinding.getDeclaredName() : fieldOrOneOfBinding.getWireFieldJsonName();
    }

    public final B newBuilder() {
        return this.binding.newBuilder();
    }

    @Override // com.squareup.wire.ProtoAdapter
    public int encodedSize(M value) {
        Intrinsics.checkNotNullParameter(value, "value");
        int cachedSerializedSize = this.binding.getCachedSerializedSize(value);
        if (cachedSerializedSize != 0) {
            return cachedSerializedSize;
        }
        int iEncodedSizeWithTag = 0;
        for (FieldOrOneOfBinding<M, B> fieldOrOneOfBinding : this.fields.values()) {
            Object obj = fieldOrOneOfBinding.get(value);
            if (obj != null) {
                iEncodedSizeWithTag += fieldOrOneOfBinding.getAdapter().encodedSizeWithTag(fieldOrOneOfBinding.getTag(), obj);
            }
        }
        int size = iEncodedSizeWithTag + this.binding.unknownFields(value).size();
        this.binding.setCachedSerializedSize(value, size);
        return size;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encode(ProtoWriter writer, M value) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(value, "value");
        for (FieldOrOneOfBinding<M, B> fieldOrOneOfBinding : this.fields.values()) {
            Object obj = fieldOrOneOfBinding.get(value);
            if (obj != null) {
                fieldOrOneOfBinding.getAdapter().encodeWithTag(writer, fieldOrOneOfBinding.getTag(), obj);
            }
        }
        writer.writeBytes(this.binding.unknownFields(value));
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encode(ReverseProtoWriter writer, M value) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(value, "value");
        writer.writeBytes(this.binding.unknownFields(value));
        int length = this.fieldBindingsArray.length;
        while (true) {
            length--;
            if (-1 >= length) {
                return;
            }
            FieldOrOneOfBinding<M, B> fieldOrOneOfBinding = this.fieldBindingsArray[length];
            Object obj = fieldOrOneOfBinding.get(value);
            if (obj != null) {
                fieldOrOneOfBinding.getAdapter().encodeWithTag(writer, fieldOrOneOfBinding.getTag(), obj);
            }
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    public M redact(M value) {
        Intrinsics.checkNotNullParameter(value, "value");
        B bNewBuilder = this.binding.newBuilder();
        for (FieldOrOneOfBinding<M, B> fieldOrOneOfBinding : this.fields.values()) {
            if (fieldOrOneOfBinding.getRedacted() && fieldOrOneOfBinding.getLabel() == WireField.Label.REQUIRED) {
                throw new UnsupportedOperationException("Field '" + fieldOrOneOfBinding.getName() + "' in " + getType() + " is required and cannot be redacted.");
            }
            boolean zIsMessage = fieldOrOneOfBinding.isMessage();
            if (fieldOrOneOfBinding.getRedacted() || (zIsMessage && !fieldOrOneOfBinding.getLabel().isRepeated())) {
                Object fromBuilder = fieldOrOneOfBinding.getFromBuilder(bNewBuilder);
                if (fromBuilder != null) {
                    fieldOrOneOfBinding.set(bNewBuilder, fieldOrOneOfBinding.getAdapter().redact(fromBuilder));
                }
            } else if (zIsMessage && fieldOrOneOfBinding.getLabel().isRepeated()) {
                Object fromBuilder2 = fieldOrOneOfBinding.getFromBuilder(bNewBuilder);
                Intrinsics.checkNotNull(fromBuilder2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                ProtoAdapter<?> singleAdapter = fieldOrOneOfBinding.getSingleAdapter();
                Intrinsics.checkNotNull(singleAdapter, "null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
                fieldOrOneOfBinding.set(bNewBuilder, Internal.m2213redactElements((List) fromBuilder2, singleAdapter));
            }
        }
        this.binding.clearUnknownFields(bNewBuilder);
        return this.binding.build(bNewBuilder);
    }

    public boolean equals(Object other) {
        return (other instanceof RuntimeMessageAdapter) && Intrinsics.areEqual(((RuntimeMessageAdapter) other).messageType, this.messageType);
    }

    public int hashCode() {
        return this.messageType.hashCode();
    }

    @Override // com.squareup.wire.ProtoAdapter
    public String toString(M value) {
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder sb = new StringBuilder();
        sb.append(this.messageType.getSimpleName());
        sb.append('{');
        boolean z = true;
        for (FieldOrOneOfBinding<M, B> fieldOrOneOfBinding : this.fields.values()) {
            Object obj = fieldOrOneOfBinding.get(value);
            if (obj != null) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(fieldOrOneOfBinding.getName());
                sb.append('=');
                if (fieldOrOneOfBinding.getRedacted()) {
                    obj = REDACTED;
                }
                sb.append(obj);
                z = false;
            }
        }
        sb.append('}');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public M decode(ProtoReader reader) throws IOException {
        ProtoAdapter<?> singleAdapter;
        Intrinsics.checkNotNullParameter(reader, "reader");
        B bNewBuilder = newBuilder();
        long jBeginMessage = reader.beginMessage();
        while (true) {
            int iNextTag = reader.nextTag();
            if (iNextTag != -1) {
                FieldOrOneOfBinding<M, B> fieldOrOneOfBinding = this.fields.get(Integer.valueOf(iNextTag));
                if (fieldOrOneOfBinding != null) {
                    try {
                        if (fieldOrOneOfBinding.isMap()) {
                            singleAdapter = fieldOrOneOfBinding.getAdapter();
                        } else {
                            singleAdapter = fieldOrOneOfBinding.getSingleAdapter();
                        }
                        Object objDecode = singleAdapter.decode(reader);
                        Intrinsics.checkNotNull(objDecode);
                        fieldOrOneOfBinding.value(bNewBuilder, objDecode);
                    } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                        this.binding.addUnknownField(bNewBuilder, iNextTag, FieldEncoding.VARINT, Long.valueOf(e.value));
                    }
                } else {
                    FieldEncoding nextFieldEncoding = reader.getNextFieldEncoding();
                    Intrinsics.checkNotNull(nextFieldEncoding);
                    this.binding.addUnknownField(bNewBuilder, iNextTag, nextFieldEncoding, nextFieldEncoding.rawProtoAdapter().decode(reader));
                }
            } else {
                reader.endMessageAndGetUnknownFields(jBeginMessage);
                return this.binding.build(bNewBuilder);
            }
        }
    }

    public final <A> void writeAllFields(M message, List<? extends A> jsonAdapters, A redactedFieldsAdapter, Function3<? super String, Object, ? super A, Unit> encodeValue) {
        Intrinsics.checkNotNullParameter(jsonAdapters, "jsonAdapters");
        Intrinsics.checkNotNullParameter(encodeValue, "encodeValue");
        int length = this.fieldBindingsArray.length;
        ArrayList arrayList = null;
        for (int i = 0; i < length; i++) {
            FieldOrOneOfBinding<M, B> fieldOrOneOfBinding = this.fieldBindingsArray[i];
            Intrinsics.checkNotNull(message);
            Object obj = fieldOrOneOfBinding.get(message);
            if (!fieldOrOneOfBinding.omitFromJson(getSyntax(), obj)) {
                if (fieldOrOneOfBinding.getRedacted() && redactedFieldsAdapter != null && obj != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(this.jsonNames.get(i));
                } else {
                    encodeValue.invoke(this.jsonNames.get(i), obj, jsonAdapters.get(i));
                }
            }
        }
        if (arrayList == null || !(!arrayList.isEmpty())) {
            return;
        }
        Intrinsics.checkNotNull(redactedFieldsAdapter);
        encodeValue.invoke("__redacted_fields", arrayList, redactedFieldsAdapter);
    }
}
