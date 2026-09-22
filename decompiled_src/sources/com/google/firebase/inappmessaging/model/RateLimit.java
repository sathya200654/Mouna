package com.google.firebase.inappmessaging.model;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class RateLimit {

    public static abstract class Builder {
        public abstract RateLimit build();

        public abstract Builder setLimit(long j);

        public abstract Builder setLimiterKey(String str);

        public abstract Builder setTimeToLiveMillis(long j);
    }

    public abstract long limit();

    public abstract String limiterKey();

    public abstract long timeToLiveMillis();

    public static Builder builder() {
        return new AutoValue_RateLimit.Builder();
    }
}
