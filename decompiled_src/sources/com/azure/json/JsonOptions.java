package com.azure.json;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class JsonOptions {
    private boolean isJsoncSupported;
    private boolean nonNumericNumbersSupported = true;

    public boolean isNonNumericNumbersSupported() {
        return this.nonNumericNumbersSupported;
    }

    public JsonOptions setNonNumericNumbersSupported(boolean z) {
        this.nonNumericNumbersSupported = z;
        return this;
    }

    public boolean isJsoncSupported() {
        return this.isJsoncSupported;
    }

    public JsonOptions setJsoncSupported(boolean z) {
        this.isJsoncSupported = z;
        return this;
    }
}
