package com.azure.core.implementation;

import com.azure.core.util.logging.ClientLogger;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class Option<T> {
    private final boolean isInitialized;
    private final T value;
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) Option.class);
    private static final Option<?> UNINITIALIZED = new Option<>();
    private static final Option<?> EMPTY = new Option<>(null);

    public static <T> Option<T> of(T t) {
        return t == null ? empty() : new Option<>(t);
    }

    public static <T> Option<T> empty() {
        return (Option<T>) EMPTY;
    }

    public static <T> Option<T> uninitialized() {
        return (Option<T>) UNINITIALIZED;
    }

    public boolean isInitialized() {
        return this.isInitialized;
    }

    public T getValue() {
        if (!this.isInitialized) {
            throw LOGGER.logExceptionAsError(new NoSuchElementException("No value initialized"));
        }
        return this.value;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Option)) {
            return false;
        }
        Option option = (Option) obj;
        if (this.isInitialized ^ option.isInitialized) {
            return false;
        }
        return Objects.equals(this.value, option.value);
    }

    public int hashCode() {
        if (this.isInitialized) {
            return Objects.hashCode(this.value);
        }
        return -1;
    }

    private Option() {
        this.isInitialized = false;
        this.value = null;
    }

    private Option(T t) {
        this.isInitialized = true;
        this.value = t;
    }
}
