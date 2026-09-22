package dagger.hilt.android.internal.managers;

import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory implements Factory<ActivityRetainedLifecycle> {
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ActivityRetainedLifecycle m2264get() {
        return provideActivityRetainedLifecycle();
    }

    public static ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ActivityRetainedLifecycle provideActivityRetainedLifecycle() {
        return (ActivityRetainedLifecycle) Preconditions.checkNotNullFromProvides(ActivityRetainedComponentManager.LifecycleModule.provideActivityRetainedLifecycle());
    }

    private static final class InstanceHolder {
        static final ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory INSTANCE = new ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory();

        private InstanceHolder() {
        }
    }
}
