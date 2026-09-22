package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
interface NativeSessionFile {
    CrashlyticsReport.FilesPayload.File asFilePayload();

    String getReportsEndpointFilename();

    InputStream getStream();
}
