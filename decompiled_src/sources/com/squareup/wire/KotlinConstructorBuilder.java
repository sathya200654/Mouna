package com.squareup.wire;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: KotlinConstructorBuilder.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0002*\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004:\u0001\u001cB\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\r\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0002J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\fJ\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a*\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0002R(\u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\n\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t0\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/squareup/wire/KotlinConstructorBuilder;", "M", "Lcom/squareup/wire/Message;", "B", "Lcom/squareup/wire/Message$Builder;", "messageType", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "fieldValueMap", "", "", "Lkotlin/Pair;", "Lcom/squareup/wire/WireField;", "", "mapFieldKeyValueMap", "repeatedFieldValueMap", "", "build", "()Lcom/squareup/wire/Message;", "clobberOtherIsOneOfs", "", "field", "get", "set", "value", "declaredProtoFields", "", "Lcom/squareup/wire/KotlinConstructorBuilder$ProtoField;", "ProtoField", "wire-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class KotlinConstructorBuilder<M extends Message<M, B>, B extends Message.Builder<M, B>> extends Message.Builder<M, B> {
    private final Map<Integer, Pair<WireField, Object>> fieldValueMap;
    private final Map<Integer, Pair<WireField, Map<?, ?>>> mapFieldKeyValueMap;
    private final Class<M> messageType;
    private final Map<Integer, Pair<WireField, List<?>>> repeatedFieldValueMap;

    public KotlinConstructorBuilder(Class<M> cls) {
        Intrinsics.checkNotNullParameter(cls, "messageType");
        this.messageType = cls;
        int length = cls.getDeclaredFields().length;
        this.fieldValueMap = new LinkedHashMap(length);
        this.repeatedFieldValueMap = new LinkedHashMap(length);
        this.mapFieldKeyValueMap = new LinkedHashMap(length);
    }

    public final void set(WireField field, Object value) {
        Intrinsics.checkNotNullParameter(field, "field");
        if (KotlinConstructorBuilderKt.isMap(field)) {
            Map<Integer, Pair<WireField, Map<?, ?>>> map = this.mapFieldKeyValueMap;
            Integer numValueOf = Integer.valueOf(field.tag());
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.MutableMap<*, *>");
            map.put(numValueOf, TuplesKt.to(field, TypeIntrinsics.asMutableMap(value)));
            return;
        }
        if (field.label().isRepeated()) {
            Map<Integer, Pair<WireField, List<?>>> map2 = this.repeatedFieldValueMap;
            Integer numValueOf2 = Integer.valueOf(field.tag());
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.MutableList<*>");
            map2.put(numValueOf2, TuplesKt.to(field, TypeIntrinsics.asMutableList(value)));
            return;
        }
        this.fieldValueMap.put(Integer.valueOf(field.tag()), TuplesKt.to(field, value));
        if (value == null || !field.label().isOneOf()) {
            return;
        }
        clobberOtherIsOneOfs(field);
    }

    private final void clobberOtherIsOneOfs(WireField field) {
        Collection<Pair<WireField, Object>> collectionValues = this.fieldValueMap.values();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collectionValues, 10));
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            arrayList.add((WireField) ((Pair) it.next()).getFirst());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            WireField wireField = (WireField) obj;
            if (Intrinsics.areEqual(wireField.oneofName(), field.oneofName()) && wireField.tag() != field.tag()) {
                arrayList2.add(obj);
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            this.fieldValueMap.remove(Integer.valueOf(((WireField) it2.next()).tag()));
        }
    }

    public final Object get(WireField field) {
        List list;
        Map map;
        Intrinsics.checkNotNullParameter(field, "field");
        if (KotlinConstructorBuilderKt.isMap(field)) {
            Pair<WireField, Map<?, ?>> pair = this.mapFieldKeyValueMap.get(Integer.valueOf(field.tag()));
            return (pair == null || (map = (Map) pair.getSecond()) == null) ? MapsKt.emptyMap() : map;
        }
        if (field.label().isRepeated()) {
            Pair<WireField, List<?>> pair2 = this.repeatedFieldValueMap.get(Integer.valueOf(field.tag()));
            return (pair2 == null || (list = (List) pair2.getSecond()) == null) ? CollectionsKt.emptyList() : list;
        }
        Pair<WireField, Object> pair3 = this.fieldValueMap.get(Integer.valueOf(field.tag()));
        Object second = pair3 != null ? pair3.getSecond() : null;
        return (second == null && field.label() == WireField.Label.OMIT_IDENTITY) ? ProtoAdapter.INSTANCE.get(field.adapter()).getIdentity() : second;
    }

    @Override // com.squareup.wire.Message.Builder
    public M build() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        List<ProtoField> listDeclaredProtoFields = declaredProtoFields(this.messageType);
        ArrayDeque arrayDeque = new ArrayDeque();
        Iterator<ProtoField> it = listDeclaredProtoFields.iterator();
        while (it.hasNext()) {
            arrayDeque.add(it.next());
        }
        Constructor<?>[] constructors = this.messageType.getConstructors();
        Intrinsics.checkNotNullExpressionValue(constructors, "getConstructors(...)");
        for (Constructor<?> constructor : constructors) {
            if (constructor.getParameterCount() == listDeclaredProtoFields.size() + 1) {
                Parameter[] parameters = constructor.getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
                Parameter[] parameterArr = parameters;
                ArrayList arrayList = new ArrayList(parameterArr.length);
                int length = parameterArr.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    Parameter parameter = parameterArr[i];
                    int i3 = i2 + 1;
                    arrayList.add(i2 == listDeclaredProtoFields.size() ? buildUnknownFields() : get(((ProtoField) arrayDeque.removeFirst()).getWireField()));
                    i++;
                    i2 = i3;
                }
                Object[] array = arrayList.toArray(new Object[0]);
                Object objNewInstance = constructor.newInstance(Arrays.copyOf(array, array.length));
                Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type M of com.squareup.wire.KotlinConstructorBuilder");
                return (M) objNewInstance;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    private final List<ProtoField> declaredProtoFields(Class<M> cls) {
        ProtoField protoField;
        Field[] declaredFields = cls.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
        ArrayList arrayList = new ArrayList();
        for (Field field : declaredFields) {
            Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
            Intrinsics.checkNotNullExpressionValue(declaredAnnotations, "getDeclaredAnnotations(...)");
            ArrayList arrayList2 = new ArrayList();
            for (Annotation annotation : declaredAnnotations) {
                if (annotation instanceof WireField) {
                    arrayList2.add(annotation);
                }
            }
            WireField wireField = (WireField) CollectionsKt.firstOrNull(arrayList2);
            if (wireField != null) {
                Class<?> type = field.getType();
                Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                protoField = new ProtoField(type, wireField);
            } else {
                protoField = null;
            }
            if (protoField != null) {
                arrayList.add(protoField);
            }
        }
        return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.squareup.wire.KotlinConstructorBuilder$declaredProtoFields$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((KotlinConstructorBuilder.ProtoField) t).getWireField().schemaIndex()), Integer.valueOf(((KotlinConstructorBuilder.ProtoField) t2).getWireField().schemaIndex()));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: KotlinConstructorBuilder.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/squareup/wire/KotlinConstructorBuilder$ProtoField;", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Ljava/lang/Class;", "wireField", "Lcom/squareup/wire/WireField;", "(Ljava/lang/Class;Lcom/squareup/wire/WireField;)V", "getType", "()Ljava/lang/Class;", "getWireField", "()Lcom/squareup/wire/WireField;", "wire-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    static final class ProtoField {
        private final Class<?> type;
        private final WireField wireField;

        public ProtoField(Class<?> cls, WireField wireField) {
            Intrinsics.checkNotNullParameter(cls, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            Intrinsics.checkNotNullParameter(wireField, "wireField");
            this.type = cls;
            this.wireField = wireField;
        }

        public final Class<?> getType() {
            return this.type;
        }

        public final WireField getWireField() {
            return this.wireField;
        }
    }
}
