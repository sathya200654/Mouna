package com.azure.core.models;

import com.azure.core.util.logging.ClientLogger;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class GeoArray<T> extends AbstractList<T> {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) GeoArray.class);
    private static final String NO_MUTATION_MESSAGE = "GeoArray cannot be mutated.";
    private final Object container;

    GeoArray(Object obj) {
        this.container = obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        Object obj = this.container;
        if (obj instanceof List) {
            return (T) ((List) obj).get(i);
        }
        if (obj instanceof GeoPointCollection) {
            return (T) ((GeoPointCollection) obj).getPoints().get(i).getCoordinates();
        }
        if (obj instanceof GeoLineStringCollection) {
            return (T) ((GeoLineStringCollection) obj).getLines().get(i).getCoordinates();
        }
        if (obj instanceof GeoPolygon) {
            return (T) ((GeoPolygon) obj).getRings().get(i).getCoordinates();
        }
        if (obj instanceof GeoPolygonCollection) {
            return (T) ((GeoPolygonCollection) obj).getPolygons().get(i).getCoordinates();
        }
        throw LOGGER.logExceptionAsError(new IllegalStateException());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        Object obj = this.container;
        if (obj instanceof List) {
            return ((List) obj).size();
        }
        if (obj instanceof GeoPointCollection) {
            return ((GeoPointCollection) obj).getPoints().size();
        }
        if (obj instanceof GeoLineStringCollection) {
            return ((GeoLineStringCollection) obj).getLines().size();
        }
        if (obj instanceof GeoPolygon) {
            return ((GeoPolygon) obj).getRings().size();
        }
        if (obj instanceof GeoPolygonCollection) {
            return ((GeoPolygonCollection) obj).getPolygons().size();
        }
        throw LOGGER.logExceptionAsError(new IllegalStateException());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        throw LOGGER.logExceptionAsError(new UnsupportedOperationException(NO_MUTATION_MESSAGE));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> collection) {
        throw LOGGER.logExceptionAsError(new UnsupportedOperationException(NO_MUTATION_MESSAGE));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> collection) {
        throw LOGGER.logExceptionAsError(new UnsupportedOperationException(NO_MUTATION_MESSAGE));
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<T> unaryOperator) {
        throw LOGGER.logExceptionAsError(new UnsupportedOperationException(NO_MUTATION_MESSAGE));
    }

    @Override // java.util.List
    public void sort(Comparator<? super T> comparator) {
        throw LOGGER.logExceptionAsError(new UnsupportedOperationException(NO_MUTATION_MESSAGE));
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super T> predicate) {
        throw LOGGER.logExceptionAsError(new UnsupportedOperationException(NO_MUTATION_MESSAGE));
    }

    @Override // java.util.AbstractList, java.util.List
    public List<T> subList(int i, int i2) {
        throw LOGGER.logExceptionAsError(new UnsupportedOperationException("GeoArray does not support sub lists."));
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (!(obj instanceof GeoArray)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return Objects.equals(this.container, ((GeoArray) obj).container);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return Objects.hashCode(this.container);
    }
}
