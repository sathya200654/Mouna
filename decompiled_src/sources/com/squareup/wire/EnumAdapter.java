package com.squareup.wire;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: EnumAdapter.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B'\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\tB\u0015\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\nB\u001d\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bB\u0015\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\f¢\u0006\u0002\u0010\rB\u001d\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000eB'\b\u0004\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u000fJ\u0015\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u001d\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eJ\u0017\u0010\u001f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0018\u001a\u00020\u001dH$¢\u0006\u0002\u0010 J\u0015\u0010!\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"¨\u0006#"}, d2 = {"Lcom/squareup/wire/EnumAdapter;", "E", "Lcom/squareup/wire/WireEnum;", "Lcom/squareup/wire/ProtoAdapter;", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Ljava/lang/Class;", "syntax", "Lcom/squareup/wire/Syntax;", "identity", "(Ljava/lang/Class;Lcom/squareup/wire/Syntax;Lcom/squareup/wire/WireEnum;)V", "(Ljava/lang/Class;)V", "(Ljava/lang/Class;Lcom/squareup/wire/Syntax;)V", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)V", "(Lkotlin/reflect/KClass;Lcom/squareup/wire/Syntax;)V", "(Lkotlin/reflect/KClass;Lcom/squareup/wire/Syntax;Lcom/squareup/wire/WireEnum;)V", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "(Lcom/squareup/wire/ProtoReader;)Lcom/squareup/wire/WireEnum;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "(Lcom/squareup/wire/ProtoWriter;Lcom/squareup/wire/WireEnum;)V", "Lcom/squareup/wire/ReverseProtoWriter;", "(Lcom/squareup/wire/ReverseProtoWriter;Lcom/squareup/wire/WireEnum;)V", "encodedSize", "", "(Lcom/squareup/wire/WireEnum;)I", "fromValue", "(I)Lcom/squareup/wire/WireEnum;", "redact", "(Lcom/squareup/wire/WireEnum;)Lcom/squareup/wire/WireEnum;", "wire-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class EnumAdapter<E extends WireEnum> extends ProtoAdapter<E> {
    protected abstract E fromValue(int value);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected EnumAdapter(KClass<E> kClass, Syntax syntax, E e) {
        super(FieldEncoding.VARINT, (KClass<?>) kClass, (String) null, syntax, e);
        Intrinsics.checkNotNullParameter(kClass, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        Intrinsics.checkNotNullParameter(syntax, "syntax");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EnumAdapter(Class<E> cls, Syntax syntax, E e) {
        this(JvmClassMappingKt.getKotlinClass(cls), syntax, e);
        Intrinsics.checkNotNullParameter(cls, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        Intrinsics.checkNotNullParameter(syntax, "syntax");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EnumAdapter(Class<E> cls) {
        this((KClass<WireEnum>) JvmClassMappingKt.getKotlinClass(cls), Syntax.PROTO_2, Internal.getIdentityOrNull(cls));
        Intrinsics.checkNotNullParameter(cls, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EnumAdapter(Class<E> cls, Syntax syntax) {
        this((KClass<WireEnum>) JvmClassMappingKt.getKotlinClass(cls), syntax, Internal.getIdentityOrNull(cls));
        Intrinsics.checkNotNullParameter(cls, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        Intrinsics.checkNotNullParameter(syntax, "syntax");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EnumAdapter(KClass<E> kClass) {
        this(kClass, Syntax.PROTO_2, Internal.getIdentityOrNull(JvmClassMappingKt.getJavaClass(kClass)));
        Intrinsics.checkNotNullParameter(kClass, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EnumAdapter(KClass<E> kClass, Syntax syntax) {
        this(kClass, syntax, Internal.getIdentityOrNull(JvmClassMappingKt.getJavaClass(kClass)));
        Intrinsics.checkNotNullParameter(kClass, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        Intrinsics.checkNotNullParameter(syntax, "syntax");
    }

    @Override // com.squareup.wire.ProtoAdapter
    public int encodedSize(E value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return ProtoWriter.INSTANCE.varint32Size$wire_runtime(value.getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encode(ProtoWriter writer, E value) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(value, "value");
        writer.writeVarint32(value.getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encode(ReverseProtoWriter writer, E value) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(value, "value");
        writer.writeVarint32(value.getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public E decode(ProtoReader reader) throws IOException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        int varint32 = reader.readVarint32();
        E e = (E) fromValue(varint32);
        if (e != null) {
            return e;
        }
        throw new ProtoAdapter.EnumConstantNotFoundException(varint32, getType());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public E redact(E value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new UnsupportedOperationException();
    }
}
