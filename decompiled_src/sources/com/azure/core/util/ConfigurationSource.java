package com.azure.core.util;

import java.util.Map;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@FunctionalInterface
public interface ConfigurationSource {
    Map<String, String> getProperties(String str);
}
