package com.google.firebase.platforminfo;

import javax.annotation.Nonnull;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
abstract class LibraryVersion {
    @Nonnull
    public abstract String getLibraryName();

    @Nonnull
    public abstract String getVersion();

    LibraryVersion() {
    }

    static LibraryVersion create(String str, String str2) {
        return new AutoValue_LibraryVersion(str, str2);
    }
}
