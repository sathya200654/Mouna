package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface EnumValueOrBuilder extends MessageLiteOrBuilder {
    String getName();

    ByteString getNameBytes();

    int getNumber();

    Option getOptions(int index);

    int getOptionsCount();

    List<Option> getOptionsList();
}
