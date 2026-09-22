package com.google.firebase.remoteconfig;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class FirebaseRemoteConfigFetchThrottledException extends FirebaseRemoteConfigException {
    private final long throttleEndTimeMillis;

    public FirebaseRemoteConfigFetchThrottledException(long j) {
        this("Fetch was throttled.", j);
    }

    public FirebaseRemoteConfigFetchThrottledException(String str, long j) {
        super(str);
        this.throttleEndTimeMillis = j;
    }

    public long getThrottleEndTimeMillis() {
        return this.throttleEndTimeMillis;
    }
}
