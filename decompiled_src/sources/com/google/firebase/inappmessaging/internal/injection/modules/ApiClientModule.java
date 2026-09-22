package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.ApiClient;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.GrpcClient;
import com.google.firebase.inappmessaging.internal.ProviderInstaller;
import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import com.google.firebase.inappmessaging.internal.TestDeviceHelper;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.installations.FirebaseInstallationsApi;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Module
public class ApiClientModule {
    private final Clock clock;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;

    public ApiClientModule(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, Clock clock) {
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.clock = clock;
    }

    @Provides
    FirebaseInstallationsApi providesFirebaseInstallations() {
        return this.firebaseInstallations;
    }

    @Provides
    FirebaseApp providesFirebaseApp() {
        return this.firebaseApp;
    }

    @Provides
    SharedPreferencesUtils providesSharedPreferencesUtils() {
        return new SharedPreferencesUtils(this.firebaseApp);
    }

    @Provides
    DataCollectionHelper providesDataCollectionHelper(SharedPreferencesUtils sharedPreferencesUtils, Subscriber subscriber) {
        return new DataCollectionHelper(this.firebaseApp, sharedPreferencesUtils, subscriber);
    }

    @Provides
    TestDeviceHelper providesTestDeviceHelper(SharedPreferencesUtils sharedPreferencesUtils) {
        return new TestDeviceHelper(sharedPreferencesUtils);
    }

    @Provides
    ApiClient providesApiClient(Provider<GrpcClient> provider, Application application, ProviderInstaller providerInstaller) {
        return new ApiClient(provider, this.firebaseApp, application, this.clock, providerInstaller);
    }
}
