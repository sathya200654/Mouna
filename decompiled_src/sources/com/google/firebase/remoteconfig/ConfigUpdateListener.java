package com.google.firebase.remoteconfig;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface ConfigUpdateListener {
    void onError(FirebaseRemoteConfigException firebaseRemoteConfigException);

    void onUpdate(ConfigUpdate configUpdate);
}
