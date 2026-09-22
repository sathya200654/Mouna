package com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.remote.api.AnalyticsApi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AnalyticsRepositoryImpl_Factory implements Factory<AnalyticsRepositoryImpl> {
    private final Provider<AnalyticsApi> analyticsApiProvider;

    private AnalyticsRepositoryImpl_Factory(Provider<AnalyticsApi> analyticsApiProvider) {
        this.analyticsApiProvider = analyticsApiProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public AnalyticsRepositoryImpl m1307get() {
        return newInstance((AnalyticsApi) this.analyticsApiProvider.get());
    }

    public static AnalyticsRepositoryImpl_Factory create(Provider<AnalyticsApi> analyticsApiProvider) {
        return new AnalyticsRepositoryImpl_Factory(analyticsApiProvider);
    }

    public static AnalyticsRepositoryImpl newInstance(AnalyticsApi analyticsApi) {
        return new AnalyticsRepositoryImpl(analyticsApi);
    }
}
