package com.azure.core.util;

import com.azure.core.util.logging.ClientLogger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class Context {
    public static final Context NONE;
    private final int contextCount;
    private final Object key;
    private final Context parent;
    private final Object value;
    private Map<Object, Object> valuesMap;
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) Context.class);
    private static final Context[] EMPTY_CHAIN = new Context[0];

    static {
        Context context = null;
        NONE = new Context(context, context, context, 0) { // from class: com.azure.core.util.Context.1
            @Override // com.azure.core.util.Context
            public Optional<Object> getData(Object obj) {
                if (obj == null) {
                    throw Context.LOGGER.logExceptionAsError(new IllegalArgumentException("key cannot be null"));
                }
                return Optional.empty();
            }

            @Override // com.azure.core.util.Context
            public Map<Object, Object> getValues() {
                return Collections.emptyMap();
            }

            @Override // com.azure.core.util.Context
            Context[] getContextChain() {
                return Context.EMPTY_CHAIN;
            }
        };
    }

    public Context(Object obj, Object obj2) {
        this.parent = null;
        this.key = Objects.requireNonNull(obj, "'key' cannot be null.");
        this.value = obj2;
        this.contextCount = 1;
    }

    private Context(Context context, Object obj, Object obj2, int i) {
        this.parent = context;
        this.key = obj;
        this.value = obj2;
        this.contextCount = i;
    }

    Object getKey() {
        return this.key;
    }

    Object getValue() {
        return this.value;
    }

    public Context addData(Object obj, Object obj2) {
        if (obj == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("key cannot be null"));
        }
        return new Context(this, obj, obj2, this.contextCount + 1);
    }

    public static Context of(Map<Object, Object> map) {
        if (CoreUtils.isNullOrEmpty((Map<?, ?>) map)) {
            throw new IllegalArgumentException("Key value map cannot be null or empty");
        }
        Context context = null;
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            if (context == null) {
                context = new Context(entry.getKey(), entry.getValue());
            } else {
                context = context.addData(entry.getKey(), entry.getValue());
            }
        }
        return context;
    }

    public Optional<Object> getData(Object obj) {
        if (obj == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("key cannot be null"));
        }
        while (this != null) {
            if (obj.equals(this.key)) {
                return Optional.ofNullable(this.value);
            }
            if (this.contextCount != 1) {
                this = this.parent;
            } else {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }

    public Map<Object, Object> getValues() {
        Map<Object, Object> map = this.valuesMap;
        if (map != null) {
            return map;
        }
        if (this.contextCount == 1) {
            Map<Object, Object> mapSingletonMap = Collections.singletonMap(this.key, this.value);
            this.valuesMap = mapSingletonMap;
            return mapSingletonMap;
        }
        HashMap map2 = new HashMap((int) Math.ceil(this.contextCount / 0.75f));
        for (Context context = this; context != null; context = context.parent) {
            Object obj = context.key;
            if (obj != null) {
                map2.putIfAbsent(obj, context.value);
            }
            if (context.contextCount == 1) {
                break;
            }
        }
        Map<Object, Object> mapUnmodifiableMap = Collections.unmodifiableMap(map2);
        this.valuesMap = mapUnmodifiableMap;
        return mapUnmodifiableMap;
    }

    Context[] getContextChain() {
        int i = this.contextCount;
        Context[] contextArr = new Context[i];
        int i2 = i - 1;
        while (this != null) {
            int i3 = i2 - 1;
            contextArr[i2] = this;
            if (this.contextCount == 1) {
                break;
            }
            this = this.parent;
            i2 = i3;
        }
        return contextArr;
    }
}
