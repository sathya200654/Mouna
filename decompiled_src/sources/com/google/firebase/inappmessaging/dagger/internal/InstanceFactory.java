package com.google.firebase.inappmessaging.dagger.internal;

import com.google.firebase.inappmessaging.dagger.Lazy;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class InstanceFactory<T> implements Factory<T>, Lazy<T> {
    private static final InstanceFactory<Object> NULL_INSTANCE_FACTORY = new InstanceFactory<>(null);
    private final T instance;

    public static <T> Factory<T> create(T t) {
        return new InstanceFactory(Preconditions.checkNotNull(t, "instance cannot be null"));
    }

    public static <T> Factory<T> createNullable(T t) {
        if (t == null) {
            return nullInstanceFactory();
        }
        return new InstanceFactory(t);
    }

    private static <T> InstanceFactory<T> nullInstanceFactory() {
        return (InstanceFactory<T>) NULL_INSTANCE_FACTORY;
    }

    private InstanceFactory(T t) {
        this.instance = t;
    }

    @Override // com.google.firebase.inappmessaging.dagger.Lazy
    public T get() {
        return this.instance;
    }
}
