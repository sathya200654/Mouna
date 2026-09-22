package com.google.firebase.remoteconfig;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface FirebaseRemoteConfigValue {
    boolean asBoolean() throws IllegalArgumentException;

    byte[] asByteArray();

    double asDouble() throws IllegalArgumentException;

    long asLong() throws IllegalArgumentException;

    String asString();

    int getSource();
}
