package com.deepvisiontech.letstalksigntranscriptionapp.current.core.utils;

import android.net.Uri;
import coil3.util.UtilsKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileHandlingUtils.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"deleteFileFromUri", "", "uri", "Landroid/net/Uri;", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FileHandlingUtilsKt {
    public static final boolean deleteFileFromUri(Uri uri) {
        String path;
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            if (!Intrinsics.areEqual(uri.getScheme(), UtilsKt.SCHEME_FILE) || (path = uri.getPath()) == null) {
                return false;
            }
            return new File(path).delete();
        } catch (Exception unused) {
        }
        return false;
    }
}
