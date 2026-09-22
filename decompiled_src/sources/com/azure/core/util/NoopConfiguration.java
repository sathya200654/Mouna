package com.azure.core.util;

import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
class NoopConfiguration extends Configuration {
    @Override // com.azure.core.util.Configuration
    public boolean contains(String str) {
        return false;
    }

    @Override // com.azure.core.util.Configuration
    public <T> T get(String str, T t) {
        return t;
    }

    @Override // com.azure.core.util.Configuration
    public <T> T get(String str, Function<String, T> function) {
        return null;
    }

    @Override // com.azure.core.util.Configuration
    public String get(String str) {
        return null;
    }

    @Override // com.azure.core.util.Configuration
    @Deprecated
    public NoopConfiguration put(String str, String str2) {
        return this;
    }

    @Override // com.azure.core.util.Configuration
    @Deprecated
    public String remove(String str) {
        return null;
    }

    NoopConfiguration() {
    }

    @Override // com.azure.core.util.Configuration
    @Deprecated
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public NoopConfiguration mo1237clone() {
        return new NoopConfiguration();
    }
}
