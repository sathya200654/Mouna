package com.azure.xml.implementation.aalto.util;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class TextAccumulator {
    private String mText = null;
    private StringBuilder mBuilder = null;

    public void addText(String str) {
        int length = str.length();
        if (length > 0) {
            if (this.mText != null) {
                StringBuilder sb = new StringBuilder(this.mText.length() + length);
                this.mBuilder = sb;
                sb.append(this.mText);
                this.mText = null;
            }
            StringBuilder sb2 = this.mBuilder;
            if (sb2 != null) {
                sb2.append(str);
            } else {
                this.mText = str;
            }
        }
    }

    public String getAndClear() {
        String str = this.mText;
        if (str != null) {
            this.mText = null;
            return str;
        }
        StringBuilder sb = this.mBuilder;
        if (sb != null) {
            String string = sb.toString();
            this.mBuilder = null;
            return string;
        }
        return "";
    }
}
