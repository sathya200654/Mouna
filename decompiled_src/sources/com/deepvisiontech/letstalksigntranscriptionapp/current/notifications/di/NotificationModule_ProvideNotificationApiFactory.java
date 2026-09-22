package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.remote.api.NotificationApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class NotificationModule_ProvideNotificationApiFactory implements Factory<NotificationApi> {
    private final Provider<Retrofit> retrofitProvider;

    private NotificationModule_ProvideNotificationApiFactory(Provider<Retrofit> retrofitProvider) {
        this.retrofitProvider = retrofitProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public NotificationApi m1723get() {
        return provideNotificationApi((Retrofit) this.retrofitProvider.get());
    }

    public static NotificationModule_ProvideNotificationApiFactory create(Provider<Retrofit> retrofitProvider) {
        return new NotificationModule_ProvideNotificationApiFactory(retrofitProvider);
    }

    public static NotificationApi provideNotificationApi(Retrofit retrofit) {
        return (NotificationApi) Preconditions.checkNotNullFromProvides(NotificationModule.INSTANCE.provideNotificationApi(retrofit));
    }
}
