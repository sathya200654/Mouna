package com.google.firebase.remoteconfig;

import java.util.Set;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class ConfigUpdate {
    public abstract Set<String> getUpdatedKeys();

    public static ConfigUpdate create(Set<String> set) {
        return new AutoValue_ConfigUpdate(set);
    }
}
