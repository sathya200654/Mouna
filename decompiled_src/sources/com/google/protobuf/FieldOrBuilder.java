package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface FieldOrBuilder extends MessageLiteOrBuilder {
    Field.Cardinality getCardinality();

    int getCardinalityValue();

    String getDefaultValue();

    ByteString getDefaultValueBytes();

    String getJsonName();

    ByteString getJsonNameBytes();

    Field.Kind getKind();

    int getKindValue();

    String getName();

    ByteString getNameBytes();

    int getNumber();

    int getOneofIndex();

    Option getOptions(int index);

    int getOptionsCount();

    List<Option> getOptionsList();

    boolean getPacked();

    String getTypeUrl();

    ByteString getTypeUrlBytes();
}
