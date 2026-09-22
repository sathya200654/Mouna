package com.google.protobuf;

import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface LazyStringList extends ProtocolStringList {
    void add(ByteString element);

    void add(byte[] element);

    boolean addAllByteArray(Collection<byte[]> c);

    boolean addAllByteString(Collection<? extends ByteString> c);

    List<byte[]> asByteArrayList();

    byte[] getByteArray(int index);

    ByteString getByteString(int index);

    Object getRaw(int index);

    List<?> getUnderlyingElements();

    LazyStringList getUnmodifiableView();

    void mergeFrom(LazyStringList other);

    void set(int index, ByteString element);

    void set(int index, byte[] element);
}
