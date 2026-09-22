package com.azure.core.exception;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class AzureException extends RuntimeException {
    public AzureException() {
    }

    public AzureException(String str) {
        super(str);
    }

    public AzureException(Throwable th) {
        super(th);
    }

    public AzureException(String str, Throwable th) {
        super(str, th);
    }

    public AzureException(String str, Throwable th, boolean z, boolean z2) {
        super(str, th, z, z2);
    }
}
