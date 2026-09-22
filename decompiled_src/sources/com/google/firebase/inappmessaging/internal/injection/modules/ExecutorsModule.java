package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import java.util.concurrent.Executor;
import javax.inject.Singleton;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Module
public class ExecutorsModule {
    private final Executor backgroundExecutor;
    private final Executor blockingExecutor;
    private final Executor lightWeightExecutor;

    public ExecutorsModule(Executor executor, Executor executor2, Executor executor3) {
        this.lightWeightExecutor = executor;
        this.backgroundExecutor = executor2;
        this.blockingExecutor = executor3;
    }

    @Provides
    @Singleton
    public Executor providesBackgroundExecutor() {
        return this.backgroundExecutor;
    }

    @Provides
    @Singleton
    public Executor providesLightWeightExecutor() {
        return this.lightWeightExecutor;
    }

    @Provides
    @Singleton
    public Executor providesBlockingExecutor() {
        return this.blockingExecutor;
    }
}
