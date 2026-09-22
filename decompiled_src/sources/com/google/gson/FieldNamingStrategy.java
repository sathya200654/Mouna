package com.google.gson;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface FieldNamingStrategy {
    String translateName(Field field);

    default List<String> alternateNames(Field field) {
        return Collections.emptyList();
    }
}
