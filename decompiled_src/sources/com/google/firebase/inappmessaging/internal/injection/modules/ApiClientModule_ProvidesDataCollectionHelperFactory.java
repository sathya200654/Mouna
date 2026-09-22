package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ApiClientModule_ProvidesDataCollectionHelperFactory implements Factory<DataCollectionHelper> {
    private final Provider<Subscriber> firebaseEventSubscriberProvider;
    private final ApiClientModule module;
    private final Provider<SharedPreferencesUtils> sharedPreferencesUtilsProvider;

    public ApiClientModule_ProvidesDataCollectionHelperFactory(ApiClientModule apiClientModule, Provider<SharedPreferencesUtils> provider, Provider<Subscriber> provider2) {
        this.module = apiClientModule;
        this.sharedPreferencesUtilsProvider = provider;
        this.firebaseEventSubscriberProvider = provider2;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public DataCollectionHelper m2070get() {
        return providesDataCollectionHelper(this.module, (SharedPreferencesUtils) this.sharedPreferencesUtilsProvider.get(), (Subscriber) this.firebaseEventSubscriberProvider.get());
    }

    public static ApiClientModule_ProvidesDataCollectionHelperFactory create(ApiClientModule apiClientModule, Provider<SharedPreferencesUtils> provider, Provider<Subscriber> provider2) {
        return new ApiClientModule_ProvidesDataCollectionHelperFactory(apiClientModule, provider, provider2);
    }

    public static DataCollectionHelper providesDataCollectionHelper(ApiClientModule apiClientModule, SharedPreferencesUtils sharedPreferencesUtils, Subscriber subscriber) {
        return (DataCollectionHelper) Preconditions.checkNotNullFromProvides(apiClientModule.providesDataCollectionHelper(sharedPreferencesUtils, subscriber));
    }
}
