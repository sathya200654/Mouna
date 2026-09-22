package com.google.longrunning;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface ListOperationsRequestOrBuilder extends MessageLiteOrBuilder {
    String getFilter();

    ByteString getFilterBytes();

    String getName();

    ByteString getNameBytes();

    int getPageSize();

    String getPageToken();

    ByteString getPageTokenBytes();
}
