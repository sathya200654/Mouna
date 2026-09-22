package io.perfmark;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class Tag {
    final long tagId;

    @Nullable
    final String tagName;

    Tag(@Nullable String str, long j) {
        this.tagName = str;
        this.tagId = j;
    }
}
