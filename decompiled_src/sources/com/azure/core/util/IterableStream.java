package com.azure.core.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import reactor.core.publisher.Flux;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class IterableStream<T> implements Iterable<T> {
    private static final int DEFAULT_BATCH_SIZE = 1;
    private static final IterableStream<Object> EMPTY = new IterableStream<>(new ArrayList());
    private final Flux<T> flux;
    private final Iterable<T> iterable;

    public IterableStream(Flux<T> flux) {
        this.flux = (Flux) Objects.requireNonNull(flux, "'flux' cannot be null.");
        this.iterable = null;
    }

    public IterableStream(Iterable<T> iterable) {
        this.iterable = (Iterable) Objects.requireNonNull(iterable, "'iterable' cannot be null.");
        this.flux = null;
    }

    public Stream<T> stream() {
        Flux<T> flux = this.flux;
        return flux != null ? flux.toStream(1) : StreamSupport.stream(this.iterable.spliterator(), false);
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        Flux<T> flux = this.flux;
        return (flux != null ? flux.toIterable(1) : this.iterable).iterator();
    }

    public static <T> IterableStream<T> of(Iterable<T> iterable) {
        if (iterable == null) {
            return (IterableStream<T>) EMPTY;
        }
        return new IterableStream<>(iterable);
    }
}
