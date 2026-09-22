package dagger.hilt.android.internal.modules;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ApplicationContextModule_ProvideApplicationFactory implements Factory<Application> {
    private final ApplicationContextModule module;

    private ApplicationContextModule_ProvideApplicationFactory(ApplicationContextModule module) {
        this.module = module;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public Application m2267get() {
        return provideApplication(this.module);
    }

    public static ApplicationContextModule_ProvideApplicationFactory create(ApplicationContextModule module) {
        return new ApplicationContextModule_ProvideApplicationFactory(module);
    }

    public static Application provideApplication(ApplicationContextModule instance) {
        return (Application) Preconditions.checkNotNullFromProvides(instance.provideApplication());
    }
}
