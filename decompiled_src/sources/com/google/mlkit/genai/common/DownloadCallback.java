package com.google.mlkit.genai.common;

/* JADX INFO: compiled from: com.google.mlkit:genai-common@@1.0.0-beta1 */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface DownloadCallback {
    void onDownloadCompleted();

    void onDownloadFailed(GenAiException genAiException);

    void onDownloadProgress(long j);

    void onDownloadStarted(long j);
}
