package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Named;
import javax.inject.Singleton;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Module
public class SchedulerModule {
    @Provides
    @Singleton
    @Named("io")
    public Scheduler providesIOScheduler() {
        return Schedulers.io();
    }

    @Provides
    @Singleton
    @Named("compute")
    public Scheduler providesComputeScheduler() {
        return Schedulers.computation();
    }

    @Provides
    @Singleton
    @Named("main")
    public Scheduler providesMainThreadScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
