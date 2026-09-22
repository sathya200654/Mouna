package dagger.internal;

import com.google.protobuf.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class DaggerCollections {
    private static final int MAX_POWER_OF_TWO = 1073741824;

    private static int calculateInitialCapacity(int expectedSize) {
        if (expectedSize < 3) {
            return expectedSize + 1;
        }
        return expectedSize < 1073741824 ? (int) ((expectedSize / 0.75f) + 1.0f) : Reader.READ_DONE;
    }

    private DaggerCollections() {
    }

    public static <T> List<T> presizedList(int size) {
        if (size == 0) {
            return Collections.emptyList();
        }
        return new ArrayList(size);
    }

    public static <T> boolean hasDuplicates(List<T> list) {
        if (list.size() < 2) {
            return false;
        }
        return list.size() != new HashSet(list).size();
    }

    static <T> HashSet<T> newHashSetWithExpectedSize(int expectedSize) {
        return new HashSet<>(calculateInitialCapacity(expectedSize));
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMapWithExpectedSize(int expectedSize) {
        return new LinkedHashMap<>(calculateInitialCapacity(expectedSize));
    }
}
