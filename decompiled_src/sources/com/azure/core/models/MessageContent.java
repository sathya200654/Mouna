package com.azure.core.models;

import com.azure.core.util.BinaryData;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class MessageContent {
    private BinaryData binaryData;
    private String contentType;

    public BinaryData getBodyAsBinaryData() {
        return this.binaryData;
    }

    public MessageContent setBodyAsBinaryData(BinaryData binaryData) {
        this.binaryData = binaryData;
        return this;
    }

    public String getContentType() {
        return this.contentType;
    }

    public MessageContent setContentType(String str) {
        this.contentType = str;
        return this;
    }
}
